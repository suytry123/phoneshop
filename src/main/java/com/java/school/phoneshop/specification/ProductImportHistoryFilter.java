package com.java.school.phoneshop.specification;


import java.time.LocalDate;

import lombok.Data;

@Data
public class ProductImportHistoryFilter {
	private LocalDate startDate;
	private LocalDate endDate;
}
