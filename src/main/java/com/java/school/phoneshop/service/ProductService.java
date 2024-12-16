package com.java.school.phoneshop.service;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.java.school.phoneshop.dto.ProductImportDTO;
import com.java.school.phoneshop.entity.Product;

public interface ProductService {

	Product create(Product product);

	Product getById(Long id);
	
	Product getByModelIdAndColorId(Long modelId, Long colorId);
	
	void importProduct(ProductImportDTO importDTO);
	
	void setSalePrice(Long procuctId, BigDecimal price);
	
	void validateStock(Long productId, Integer numberOfUnit);
	
	Map<Integer, String> uploadProduct(MultipartFile file);
}
