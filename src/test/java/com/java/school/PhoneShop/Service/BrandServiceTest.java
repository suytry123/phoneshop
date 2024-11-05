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

import com.java.school.PhoneShop.Entity.Brand;
import com.java.school.PhoneShop.Exception.ResourceNotFoundException;
import com.java.school.PhoneShop.Repository.BrandRepository;
import com.java.school.PhoneShop.ServiceImpl.BrandServiceImpl;
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
		brand.setId(1);
		
		//when
		when(brandRepository.findById(1)).thenReturn(Optional.of(brand)); //when = mock
		Brand brandReturn = brandService.getById(1);
		//then
		assertEquals(1, brandReturn.getId());
		assertEquals("Apple", brandReturn.getName());
	}
	@Test
	public void TestgetByIdThrow() {
		//given
		
		//when
		when(brandRepository.findById(2)).thenReturn(Optional.empty());
		//brandService.getById(2);
		assertThatThrownBy(() -> brandService.getById(2))
		.isExactlyInstanceOf(ResourceNotFoundException.class)
		//.hasMessage("Brand With id = 2 Not Found");
		.hasMessage(String.format("%s With id = %d Not Found", "Brand", 2));
		//.hasMessageEndingWith("not found");
		//then
		
	}
}
