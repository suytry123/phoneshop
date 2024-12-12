/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.school.phoneshop.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.java.school.phoneshop.entity.Brand;
import com.java.school.phoneshop.exception.ResourceNotFoundException;
import com.java.school.phoneshop.repository.BrandRepository;
import com.java.school.phoneshop.service.BrandService;
import com.java.school.phoneshop.service.util.PageUtil;
import com.java.school.phoneshop.specification.BrandFilter;
import com.java.school.phoneshop.specification.BrandSpec;

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
	public Brand getById(Long id) {
		return brandRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Brand", id));
	}

	@Override
	public Brand update(Long id, Brand brandUpdate) {
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
	
}
