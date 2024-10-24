/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.school.PhoneShop.ServiceImpl;

import com.java.school.PhoneShop.Entity.Brand;
import com.java.school.PhoneShop.Exception.ApiException;
import com.java.school.PhoneShop.Exception.ResourceNotFoundException;
import com.java.school.PhoneShop.Repository.BrandRepository;
import com.java.school.PhoneShop.Service.BrandService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class BrandServiceImpl implements BrandService{
    @Autowired
    private BrandRepository brandRepository;
    
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

	

	
}
