package com.java.school.phoneshop.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.java.school.phoneshop.dto.ProductReportDTO;
import com.java.school.phoneshop.dto.report.ExpenseReportDTO;
import com.java.school.phoneshop.entity.Product;
import com.java.school.phoneshop.entity.ProductImportHistory;
import com.java.school.phoneshop.entity.SaleDetail;
import com.java.school.phoneshop.projection.ProductSold;
import com.java.school.phoneshop.repository.ProductImportHistoryRepository;
import com.java.school.phoneshop.repository.ProductRepository;
import com.java.school.phoneshop.repository.SaleDetailRepository;
import com.java.school.phoneshop.repository.SaleRepository;
import com.java.school.phoneshop.service.ReportService;
import com.java.school.phoneshop.specification.ProductImportHistoryFilter;
import com.java.school.phoneshop.specification.ProductImportHistorySpec;
import com.java.school.phoneshop.specification.SaleDetailFilter;
import com.java.school.phoneshop.specification.SaleDetailSpec;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{

	private final SaleRepository saleRepository;
	private final SaleDetailRepository saleDetailRepository;
	private final ProductRepository productRepository;
	private final ProductImportHistoryRepository productImportHistoryRepository;

	@Override
	public List<ProductSold> getProductSold(LocalDate startDate, LocalDate endDate) {
		return saleRepository.findProductSold(startDate, endDate);
	}

	@Override
	public List<ProductReportDTO> getProductReport(LocalDate startDate, LocalDate endDate) {
		List<ProductReportDTO> list = new ArrayList<>();

		SaleDetailFilter detailFilter = new SaleDetailFilter();
		detailFilter.setStartDate(startDate);
		detailFilter.setEndDate(endDate);
		Specification<SaleDetail> spec = new SaleDetailSpec(detailFilter);
		List<SaleDetail> saleDetails = saleDetailRepository.findAll(spec);

		List<Long> productIds = saleDetails.stream()
			.map(sd -> sd.getProduct().getId())
			.toList();
		Map<Long, Product> productMap = productRepository.findAllById(productIds).stream()
			.collect(Collectors.toMap(Product::getId, Function.identity()));

		Map<Product, List<SaleDetail>> saleDetailMap = saleDetails.stream()
			.collect(Collectors.groupingBy(SaleDetail::getProduct));

		for(var entry: saleDetailMap.entrySet()) {
			Product product = productMap.get(entry.getKey().getId());
			List<SaleDetail> sdList = entry.getValue();

			//total unit
			Integer unit = sdList.stream().map(SaleDetail::getUnit)
				.reduce(0, (a,b) -> a+b);
			/*
			 Integer integer = sdList.stream().map(SaleDetail::getUnit)
					.reduce((a,b) -> a+b)
					.get();
			*/
			
//			Double totalAmount = sdList.stream()
//				.map(sd -> sd.getUnit() * sd.getAmount().doubleValue())
//				.reduce(0d, (a,b) -> a+b);
			
			double totalAmount = sdList.stream()
				.mapToDouble(sd -> sd.getUnit() * sd.getAmount().doubleValue())
				.sum();
			
			//.map(sd -> sd.getUnit() * sd.getAmount().doubleValue())

			ProductReportDTO reportDTO = new ProductReportDTO();
			reportDTO.setProductId(product.getId());
			reportDTO.setProductName(product.getName());
			reportDTO.setUnit(unit);
			reportDTO.setTotalAmount(BigDecimal.valueOf(totalAmount));
			list.add(reportDTO);
		}

		return list;
	}

	@Override
	public List<ExpenseReportDTO> getExtenseReport(LocalDate startDate, LocalDate endDate) {
		ProductImportHistoryFilter historyFilter = new ProductImportHistoryFilter();
		historyFilter.setStartDate(startDate);
		historyFilter.setEndDate(endDate);
		
		ProductImportHistorySpec spec = new ProductImportHistorySpec(historyFilter);
		List<ProductImportHistory> importHistories = productImportHistoryRepository.findAll(spec);
		
		Set<Long> productIds = importHistories.stream()
			.map(his -> his.getProduct().getId())
			.collect(Collectors.toSet());
		
		List<Product> products = productRepository.findAllById(productIds);
		Map<Long, Product> productMap = products.stream()
			.collect(Collectors.toMap(p -> p.getId(), p -> p));
		//Map<Product, List<ProductImportHistory>> 
		Map<Product, List<ProductImportHistory>> importMap = importHistories.stream()
			.collect(Collectors.groupingBy(pi -> pi.getProduct()));
		
		var expenseReportDTOs = new ArrayList<ExpenseReportDTO>();
		
		for(var entry : importMap.entrySet()) {
			Product product = productMap.get(entry.getKey().getId());
			
			List<ProductImportHistory> importProduct = entry.getValue();
			int totalUnit = importProduct.stream()
				.mapToInt(pi -> pi.getImportUnit())
				.sum();
			
			double totalAmount = importProduct.stream()
				.mapToDouble(pi -> pi.getImportUnit() * pi.getPricePerUnit().doubleValue())
				.sum();
			
			var expenseReportDTO = new ExpenseReportDTO();
			expenseReportDTO.setProductId(product.getId());
			expenseReportDTO.setProductName(product.getName());
			expenseReportDTO.setTotalUnit(totalUnit);
			expenseReportDTO.setTotalAmount(BigDecimal.valueOf(totalAmount));
			expenseReportDTOs.add(expenseReportDTO);
		}
		return expenseReportDTOs;
	}

}