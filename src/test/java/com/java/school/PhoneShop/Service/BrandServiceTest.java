package com.java.school.PhoneShop.Service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.java.school.phoneshop.entity.Brand;
import com.java.school.phoneshop.exception.ResourceNotFoundException;
import com.java.school.phoneshop.repository.BrandRepository;
import com.java.school.phoneshop.service.BrandService;
import com.java.school.phoneshop.service.impl.BrandServiceImpl;
@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {
	@Mock
	private BrandRepository brandRepository;
	
	private BrandService brandService;
	
	@BeforeEach 
	public void setUp() {
		brandService = new BrandServiceImpl(brandRepository);
	}
	/*
		@Test
	   public void testCreate() {
			//given
			Brand brand = new Brand();
			brand.setName("Apple");
			brand.setId(1);
			
			Brand brand2 = new Brand();
			brand2.setName("Apple");
			//When
			
			when(brandRepository.save(any(Brand.class))).thenReturn(brand);
			//when(brandRepository.save(brand2)).thenReturn(brand); //Behavior
			Brand brandReturn = brandService.create(brand2);
			
			//Then
			assertEquals(1, brandReturn.getId());
			assertEquals("Apple", brandReturn.getName());
	   }
	   */
	@Test
	public void testCreate() {
		//given
		Brand brand = new Brand();
		brand.setName("Apple");
		//when
		brandService.create(brand);
		//then
		verify(brandRepository, times(1)).save(brand);
		//verify(brandRepository, times(1)).delete(brand);
	}
	
	@Test
	public void TestgetByIdSuccess() {
		//given
		Brand brand = new Brand();
		brand.setName("Apple");
		brand.setId(1L);
		
		//when
		when(brandRepository.findById(1L)).thenReturn(Optional.of(brand)); //when = mock
		Brand brandReturn = brandService.getById(1L);
		//then
		assertEquals(1, brandReturn.getId());
		assertEquals("Apple", brandReturn.getName());
	}
	@Test
	public void TestgetByIdThrow() {
		//given
		
		//when
		when(brandRepository.findById(2L)).thenReturn(Optional.empty());
		//brandService.getById(2);
		assertThatThrownBy(() -> brandService.getById(2L))
		.isExactlyInstanceOf(ResourceNotFoundException.class)
		//.hasMessage("Brand With id = 2 Not Found");
		.hasMessage(String.format("%s With id = %d Not Found", "Brand", 2L));
		//.hasMessageEndingWith("not found");
		//then
		
	}
}
