package com.java.school.phoneshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.school.phoneshop.entity.Model;

public interface ModelRepository extends JpaRepository<Model, Long>{

//	Model save(Model model);
	
	List<Model> findByBrandId(Long brandId); 

}
