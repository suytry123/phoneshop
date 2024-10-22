/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.java.school.PhoneShop.ServiceImpl;

import com.java.school.PhoneShop.Entity.Brand;
import com.java.school.PhoneShop.Repository.BrandRepository;
import com.java.school.PhoneShop.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService{
    @Autowired
    private BrandRepository brandRepository;
    
    @Override
    public Brand create(Brand brand) {
        Brand brand2 = brandRepository.save(brand);
        return brand2;
    }
    
}
