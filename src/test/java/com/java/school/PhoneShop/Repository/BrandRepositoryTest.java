package com.java.school.phoneshop.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.java.school.phoneshop.entity.Brand;
import com.java.school.phoneshop.repository.BrandRepository;

@DataJpaTest
public class BrandRepositoryTest {
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Test
	public void testFindByNameLike() {
		//given
		Brand brand = new Brand();
		brand.setName("Apple");
		
		Brand brand2 = new Brand();
		brand2.setName("Samsung");
		
		brandRepository.save(brand);
		brandRepository.save(brand2);
		
		//when
		List<Brand> brands = brandRepository.findByNameLike("%A%");
		
		//then
		assertEquals(1, brands.size());
		assertEquals("Apple", brands.get(0).getName());
		assertNotNull(brands.get(0).getId());
	}
	
	public void testFindByNameContaining() {
		//given
		Brand brand = new Brand();
		brand.setName("Oppo");
		
		brandRepository.save(brand);
		
		//when
		List<Brand> brands1 = brandRepository.findByNameContaining("O");
		
		//then
		assertEquals(1, brands1.size());
		assertEquals("Oppo", brands1.get(0).getName());
		assertNotNull(brands1.get(0).getId());
	}
	
}
