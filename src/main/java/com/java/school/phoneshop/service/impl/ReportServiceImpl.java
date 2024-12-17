package com.java.school.phoneshop.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.school.phoneshop.projection.ProductSold;
import com.java.school.phoneshop.repository.SaleRepository;
import com.java.school.phoneshop.service.ReportService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{

	private final SaleRepository saleRepository;
	
	@Override
	public List<ProductSold> getProductSold(LocalDate startDate, LocalDate endDate) {
		return saleRepository.findProductSold(startDate, endDate);
	}
	
}
