
package com.java.school.PhoneShop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.java.school.PhoneShop.Entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>, JpaSpecificationExecutor<Brand>{
    
	List<Brand> findByNameLike(String name);
	List<Brand> findByNameContaining(String name);
	
;}
