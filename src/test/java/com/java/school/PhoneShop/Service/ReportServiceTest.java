package com.java.school.PhoneShop.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.java.school.PhoneShop.utils.ReportTestHelper;
import com.java.school.phoneshop.dto.report.ExpenseReportDTO;
import com.java.school.phoneshop.entity.Product;
import com.java.school.phoneshop.entity.ProductImportHistory;
import com.java.school.phoneshop.repository.ProductImportHistoryRepository;
import com.java.school.phoneshop.repository.ProductRepository;
import com.java.school.phoneshop.repository.SaleDetailRepository;
import com.java.school.phoneshop.repository.SaleRepository;
import com.java.school.phoneshop.service.ReportService;
import com.java.school.phoneshop.service.impl.ReportServiceImpl;
import com.java.school.phoneshop.specification.ProductImportHistorySpec;

@ExtendWith(MockitoExtension.class)
public class ReportServiceTest {
	@Mock
	private SaleRepository saleRepository;
	@Mock
	private SaleDetailRepository saleDetailRepository;
	@Mock
	private ProductRepository productRepository;
	@Mock
	private ProductImportHistoryRepository productImportHistoryRepository;

	private ReportService reportService;

	@BeforeEach
	public void setup() {
		reportService = new ReportServiceImpl(saleRepository, saleDetailRepository, productRepository,
				productImportHistoryRepository);
	}

	@Test
	public void testGetExtenseReport() {
		//given
		List<ProductImportHistory> importHistories = ReportTestHelper.getProductImportHistories();
		List<Product> products = ReportTestHelper.getProduct();
		
		//when
		when(productImportHistoryRepository.findAll(Mockito.any(ProductImportHistorySpec.class)))
			.thenReturn(importHistories);
			
		when(productRepository.findAllById(anySet())).thenReturn(products);
		
		List<ExpenseReportDTO> extenseReports = reportService.getExtenseReport(LocalDate.now().minusMonths(1), LocalDate.now());
		//then
		
		assertEquals(2, extenseReports.size());
		ExpenseReportDTO expense1 = extenseReports.get(0);
		assertEquals(1, expense1.getProductId());
		assertEquals("iphone 15 pro", expense1.getProductName());
		assertEquals(15, expense1.getTotalUnit());
		assertEquals(18250d, expense1.getTotalAmount().doubleValue());
		
	}
}
