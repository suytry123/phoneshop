package com.java.school.phoneshop.service.impl;

import org.springframework.stereotype.Service;

import com.java.school.phoneshop.dto.ProductImportDTO;
import com.java.school.phoneshop.entity.Product;
import com.java.school.phoneshop.entity.ProductImportHistory;
import com.java.school.phoneshop.exception.ResourceNotFoundException;
import com.java.school.phoneshop.mapper.ProductMapper;
import com.java.school.phoneshop.repository.ProductImportHistoryRepository;
import com.java.school.phoneshop.repository.ProductRepository;
import com.java.school.phoneshop.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{
	private final ProductRepository productRepository;
	private final ProductImportHistoryRepository importHistoryRepository;
	private final ProductMapper productMapper;

	@Override
	public Product create(Product product) {
		String name = "%s %s"
				.formatted(product.getModel().getName(), product.getColor().getName()) ;
		product.setName(name);
		return productRepository.save(product);
	}

	@Override
	public Product getById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", id));
	}
	@Override
	public void importProduct(ProductImportDTO importDTO) {
		// update available product unit
		Product product = getById(importDTO.getProductId());
		Integer availableUnit = 0;
		if(product.getAvailableUnit() != null) {
			availableUnit = product.getAvailableUnit();
		}
		product.setAvailableUnit(availableUnit + importDTO.getImportUnit());
		productRepository.save(product);

		// save product import history
		ProductImportHistory importHistory = productMapper.toProductImportHistory(importDTO, product);
		importHistoryRepository.save(importHistory);
	}

}
