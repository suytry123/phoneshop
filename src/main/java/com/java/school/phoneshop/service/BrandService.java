
package com.java.school.phoneshop.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.java.school.phoneshop.entity.Brand;

public interface BrandService { //main brand
    Brand create(Brand brand);
    Brand getById(Long id);
    Brand update(Long id, Brand brandUpdate);
//	List<Brand> getBrands();
    List<Brand> getBrands(String name);
	//List<Brand> getBrand(Map<String, String> params);
    Page<Brand> getBrands(Map<String, String> params);
}
