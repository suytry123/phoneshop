package com.java.school.phoneshop.service;

import com.java.school.phoneshop.dto.ProductImportDTO;
import com.java.school.phoneshop.entity.Product;

public interface ProductService {

	Product create(Product product);

	Product getById(Long id);
	
	void importProduct(ProductImportDTO importDTO);
}
