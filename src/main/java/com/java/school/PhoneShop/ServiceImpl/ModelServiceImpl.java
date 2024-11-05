package com.java.school.PhoneShop.ServiceImpl;

import org.springframework.stereotype.Service;

import com.java.school.PhoneShop.Entity.Model;
import com.java.school.PhoneShop.Repository.ModelRepository;
import com.java.school.PhoneShop.Service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ModelServiceImpl implements ModelService{
	private final ModelRepository modelRepository;
//	private BrandService brandService;
	@Override
	public Model save(Model model) {
//		Integer brandId = model.getBrand().getId();
//		brandService.getById(brandId);
		return modelRepository.save(model);
	}

}
