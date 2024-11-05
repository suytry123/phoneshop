
package com.java.school.PhoneShop.Service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.java.school.PhoneShop.Entity.Brand;

public interface BrandService { //main brand
    Brand create(Brand brand);
    Brand getById(Integer id);
    Brand update(Integer id, Brand brandUpdate);
//	List<Brand> getBrands();
    List<Brand> getBrands(String name);
	//List<Brand> getBrand(Map<String, String> params);
    Page<Brand> getBrands(Map<String, String> params);
}
