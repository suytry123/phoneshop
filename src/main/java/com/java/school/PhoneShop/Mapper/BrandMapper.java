package com.java.school.PhoneShop.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.java.school.PhoneShop.Dto.BrandDTO;
import com.java.school.PhoneShop.Entity.Brand;

@Mapper
public interface BrandMapper {
	
	BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
	
	Brand toBrand(BrandDTO dto);
	
	BrandDTO toBrandDTO(Brand brand);
}
