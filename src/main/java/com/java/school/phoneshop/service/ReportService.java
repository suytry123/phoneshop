package com.java.school.phoneshop.service;

import java.time.LocalDate;
import java.util.List;

import com.java.school.phoneshop.dto.ProductReportDTO;
import com.java.school.phoneshop.projection.ProductSold;

public interface ReportService {

	List<ProductSold> getProductSold(LocalDate startDate, LocalDate endDate);
	List<ProductReportDTO> getProductReport(LocalDate startDate, LocalDate endDate);
}
