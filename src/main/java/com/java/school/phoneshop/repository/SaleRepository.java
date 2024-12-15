
package com.java.school.phoneshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.school.phoneshop.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{
	
;}
