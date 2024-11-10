/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.school.PhoneShop.ServiceImpl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.java.school.PhoneShop.Entity.Brand;
import com.java.school.PhoneShop.Exception.ResourceNotFoundException;
import com.java.school.PhoneShop.Repository.BrandRepository;
import com.java.school.PhoneShop.Service.BrandService;
import com.java.school.PhoneShop.Service.Util.PageUtil;
import com.java.school.PhoneShop.Specification.BrandFilter;
import com.java.school.PhoneShop.Specification.BrandSpec;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService{
    @Autowired
    private final BrandRepository brandRepository;
    
    @Override
    public Brand create(Brand brand) {
        //brand = brandRepository.save(brand);
        return brandRepository.save(brand);
    }

	@Override
	public Brand getById(Integer id) {
		//Optional<Brand> brandOptional = brandRepository.findById(id);
		/*
		if(brandOptional.isPresent()) {
			return brandOptional.get();
		}*/
//			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Brand with id = " + id + "not found");
		//throw new HttpClientErrorException(HttpStatus.NOT_FOUND, String.format("Brand with id = %d not found",id));
		
		return brandRepository.findById(id)
		//		.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, String.format("Brand with id = %d not found",id)));
		//		.orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, String.format("Brand with id = %d not found",id)));
		.orElseThrow(() -> new ResourceNotFoundException("Brand", id));
	}

	@Override
	public Brand update(Integer id, Brand brandUpdate) {
		Brand brand = getById(id);
		//brand.setId(brandUpdate.getId());
		brand.setName(brandUpdate.getName()); // @TODO improve update
		return brandRepository.save(brand);
	}
	

	@Override
	public Page<Brand> getBrands(Map<String, String> params) {
		BrandFilter brandFilter = new BrandFilter();
		
		if(params.containsKey("name")) {
			String name = params.get("name");
			brandFilter.setName(name);
		}
		
		if(params.containsKey("id")) {
			String id = params.get("id");
			brandFilter.setId(Integer.parseInt(id));
		}
		
		int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
		if(params.containsKey(PageUtil.PAGE_LIMIT)) {
			pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
		}
		
		int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
		if(params.containsKey(PageUtil.PAGE_NUMBER)){
			pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
		}
		
		BrandSpec brandSpec = new BrandSpec(brandFilter);
		
		Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);
		
		 Page<Brand> page = brandRepository.findAll(brandSpec, pageable);
		 return page;
		
	}

	
	
	
	
	
	@Override
	public List<Brand> getBrands(String name) {
		return brandRepository.findByNameContaining(name);
	}
	
	
	
	
	
	
	
	
	
	
	

	/*@Override
	public List<Brand> getBrand(Map<String, String> params) {
		BrandFilter brandFilter = new BrandFilter();
		
		if(params.containsKey("name")) {
			String name = params.get("name");
			brandFilter.setName(name);
		}
		
		if(params.containsKey("id")) {
			String id = params.get("id");
			brandFilter.setId(Integer.parseInt(id));
		}
		
		
		BrandSpec brandSpec = new BrandSpec(brandFilter);
		
		brandRepository.findAll(brandSpec, pageable);
		
	}*/
	
	
	
	
	

//	@Override
//	public List<Brand> getBrands() {
//		return brandRepository.findAll();
//	}
//
//	@Override
//	public List<Brand> getBrands(String name) {
//		//return brandRepository.findByNameLike("%"+name+"%");
//		return brandRepository.findByNameContaining(name);
//	}

	

	
}
