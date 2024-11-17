package com.java.school.PhoneShop.Service;

import java.util.List;

import com.java.school.PhoneShop.Entity.Model;

public interface ModelService {
	//Model save(ModelDTO dto);
	Model save(Model model);
	List<Model> getByBrand(Integer brandId);
}
