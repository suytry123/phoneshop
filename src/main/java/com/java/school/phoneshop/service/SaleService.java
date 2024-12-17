package com.java.school.phoneshop.service;

import com.java.school.phoneshop.dto.SaleDTO;
import com.java.school.phoneshop.entity.Sale;

public interface SaleService {
	void sell(SaleDTO saleDTO);
	Sale getById(Long saleId);
	void cancelSale(Long saleId);
}
