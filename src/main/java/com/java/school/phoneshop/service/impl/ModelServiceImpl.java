package com.java.school.phoneshop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.school.phoneshop.entity.Model;
import com.java.school.phoneshop.exception.ResourceNotFoundException;
import com.java.school.phoneshop.repository.ModelRepository;
import com.java.school.phoneshop.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ModelServiceImpl implements ModelService{
	private final ModelRepository modelRepository;
	
	@Override
	public Model save(Model model) {
		return modelRepository.save(model);
	}


	@Override
	public List<Model> getByBrand(Long brandId) {
		return modelRepository.findByBrandId(brandId);
	}


	@Override
	public Model getById(Long id) {
		return modelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Model", id));
	}

}
