package com.java.school.phoneshop.service;

import java.math.BigDecimal;

import com.java.school.phoneshop.dto.ProductImportDTO;
import com.java.school.phoneshop.entity.Product;

public interface ProductService {

	Product create(Product product);

	Product getById(Long id);
	
	void importProduct(ProductImportDTO importDTO);
	
	void setSalePrice(Long procuctId, BigDecimal price);
	
	void validateStock(Long productId, Integer numberOfUnit);
}
