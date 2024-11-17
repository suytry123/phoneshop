package com.java.school.PhoneShop.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.school.PhoneShop.Entity.Model;
import com.java.school.PhoneShop.Repository.ModelRepository;
import com.java.school.PhoneShop.Service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ModelServiceImpl implements ModelService{
	private final ModelRepository modelRepository;
//	private final ModelEntityMapper modelMapper;
//	private BrandService brandService;
	
	
//	@Override
//	public Model save(ModelDTO dto) {
////		Integer brandId = model.getBrand().getId();
////		brandService.getById(brandId);
//		Model model = modelMapper.toModel(dto);
//		return modelRepository.save(model);
//	}
	
	@Override
	public Model save(Model model) {
		return modelRepository.save(model);
	}


	@Override
	public List<Model> getByBrand(Integer brandId) {
		return modelRepository.findByBrandId(brandId);
	}

}
