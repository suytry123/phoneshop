
package com.java.school.phoneshop.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.school.phoneshop.entity.Sale;
import com.java.school.phoneshop.projection.ProductSold;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{
//	@Query(value = "select p.product_id as productId, p.product_name productName, sum(sd.unit) unit, sum(sd.unit * sd.sold_amount) totalAmount\r\n"
//			+ "from sale_details sd \r\n"
//			+ "inner join sales s on sd.sale_id = s.sale_id\r\n"
//			+ "inner join products p on p.id = sd.product_id\r\n"
//			+ "where date(s.sold_date) >= :startDate and date(s.sold_date) <= :endDate\r\n"
//			+ "group by p.product_id, p.product_name\r\n"
//			+ "", nativeQuery = true)
	
	
	
	@Query(value = "select p.product_id as productId, p.product_name productName, sum(sd.unit) unit, sum(sd.unit * sd.sold_amount) totalAmount from sale_details sd\n"
			+ "inner join sales s on sd.sale_id = s.sale_id \n"
			+ "inner join products p on p.product_id = sd.product_id\n"
			+ "where date(s.sold_date) >= '2022-12-14' and date(s.sold_date) <= '2024-12-17'\n"
			+ "group by p.product_id, p. product_name", nativeQuery = true)
	List<ProductSold> findProductSold(LocalDate startDate, LocalDate endDate);
;}
