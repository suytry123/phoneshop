package com.java.school.phoneshop.projection;

import java.math.BigDecimal;

public interface ProductSold {
	//productId, productName, unit, totalAmount
	Long getProductId();
	String getProductName();
	Integer getUnit();
	BigDecimal getTotalAmount();
	
}
