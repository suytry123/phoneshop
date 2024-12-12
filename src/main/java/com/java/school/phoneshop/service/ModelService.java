package com.java.school.phoneshop.service;

import java.util.List;

import com.java.school.phoneshop.entity.Model;

public interface ModelService {
	//Model save(ModelDTO dto);
	Model save(Model model);
	List<Model> getByBrand(Long brandId);
}
