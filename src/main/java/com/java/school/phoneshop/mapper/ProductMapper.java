package com.java.school.phoneshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.java.school.phoneshop.dto.ProductDTO;
import com.java.school.phoneshop.dto.ProductImportDTO;
import com.java.school.phoneshop.entity.Product;
import com.java.school.phoneshop.entity.ProductImportHistory;
import com.java.school.phoneshop.service.ColorService;
import com.java.school.phoneshop.service.ModelService;

@Mapper(componentModel = "spring", uses = { ModelService.class, ColorService.class })
public interface ProductMapper {
	@Mapping(target = "model", source = "modelId")
	@Mapping(target = "color", source = "colorId")
	Product toProduct(ProductDTO productDTO);

	@Mapping(target = "dateImport", source = "importDTO.importDate")
	@Mapping(target = "pricePerUnit", source = "importDTO.importPrice")
	@Mapping(target = "product", source = "product")
	@Mapping(target = "id", ignore = true)
	ProductImportHistory toProductImportHistory(ProductImportDTO importDTO, Product product);

}
