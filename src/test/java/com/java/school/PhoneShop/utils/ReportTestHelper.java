package com.java.school.PhoneShop.utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.java.school.phoneshop.entity.Product;
import com.java.school.phoneshop.entity.ProductImportHistory;

public class ReportTestHelper {
	
	private static Product product1 = Product.builder()
			.id(1L)
			.name("iphone 15 pro")
			.build();
	
	private static Product product2 = Product.builder()
			.id(2L)
			.name("iphone 14 pro max")
			.build();
	
	private static Product product3 = Product.builder()
			.id(3L)
			.name("j7 pro")
			.build();
	
	public static List<Product> getProduct(){
		return List.of(product1, product2);
	}
	
	public static List<ProductImportHistory> getProductImportHistories(){
		ProductImportHistory history1 = ProductImportHistory.builder()
				.product(product1)
				.importUnit(10)
				.pricePerUnit(BigDecimal.valueOf(1200))
				.dateImport(LocalDateTime.of(2023, 1, 1, 8, 50))
				.build();
		
		ProductImportHistory history2 = ProductImportHistory.builder()
				.product(product2)
				.importUnit(15)
				.pricePerUnit(BigDecimal.valueOf(900))
				.dateImport(LocalDateTime.of(2024, 2, 2, 9, 00))
				.build();
		
		ProductImportHistory history3 = ProductImportHistory.builder()
				.product(product1)
				.importUnit(5)
				.pricePerUnit(BigDecimal.valueOf(1250))
				.dateImport(LocalDateTime.of(2024, 1, 1, 10, 00))
				.build();
		return List.of(history1, history2, history3);
	}
}
