package com.java.school.phoneshop.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.java.school.phoneshop.entity.Sale;
import com.java.school.phoneshop.entity.SaleDetail;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaleDetailSpec implements Specification<SaleDetail>{
	private SaleDetailFilter detailFilter;


	@Override
	public Predicate toPredicate(Root<SaleDetail> saleDetail, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicates = new ArrayList<>();
		Join<SaleDetail, Sale> sale = saleDetail.join("sale");
		if(Objects.nonNull(detailFilter.getStartDate())) { 
			cb.greaterThanOrEqualTo(sale.get("soldDate"), detailFilter.getStartDate());
		}
		if(Objects.nonNull(detailFilter.getEndDate())) { 
			cb.lessThanOrEqualTo(sale.get("soldDate"), detailFilter.getEndDate());
		}
		Predicate predicate = cb.and(predicates.toArray(Predicate[]::new));
		return predicate;
	}

}
