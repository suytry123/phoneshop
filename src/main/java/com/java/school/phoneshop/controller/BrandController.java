
package com.java.school.phoneshop.controller;


import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.school.phoneshop.dto.BrandDTO;
import com.java.school.phoneshop.dto.ModelDTO;
import com.java.school.phoneshop.dto.PageDTO;
import com.java.school.phoneshop.entity.Brand;
import com.java.school.phoneshop.entity.Model;
import com.java.school.phoneshop.mapper.BrandMapper;
import com.java.school.phoneshop.mapper.ModelEntityMapper;
import com.java.school.phoneshop.service.BrandService;
import com.java.school.phoneshop.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("brands")
public class BrandController {
    
    private final BrandService brandService;
    private final ModelService modelService;
    private final ModelEntityMapper modelMapper;
    
    // Handler
    @PreAuthorize("hasAuthority('brand:write')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO){
//        Brand brand = Mapper.toBrand(brandDTO);
    	Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
    	
        brand = brandService.create(brand);
        //return ResponseEntity.ok(brand);
        
       // return ResponseEntity.ok(Mapper.toBrandDTO(brand));
        return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
    }
    
    @GetMapping("{id}")
    public ResponseEntity<?> getOneBrand(@PathVariable("id") Long brandId){
    	Brand brand = brandService.getById(brandId);
    	//Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
    	return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
    }
    
    @PreAuthorize("hasAuthority('brand:write')")
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long brandId, @RequestBody BrandDTO brandDTO){
//    	Brand brand = Mapper.toBrand(brandDTO);
    	//Brand updatedBrand = brandService.update(brandId, brand);
    	
    	Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
    	Brand updatedBrand = brandService.update(brandId, brand);
    	return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(updatedBrand));
    }
    
    @PreAuthorize("hasAuthority('brand:read')")
    @GetMapping
    public ResponseEntity<?> getBrands(@RequestParam Map<String, String> params){
    	
    	Page<Brand> page = brandService.getBrands(params);
    	
    	PageDTO pageDTO = new PageDTO(page);
    	
    	
    	/*List<BrandDTO> list = brandService.getBrand(params)
    	    	.stream()
    	    	.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
    	    	.collect(Collectors.toList());
    	    	*/
    	    	return ResponseEntity.ok(pageDTO);
    	
    }
    
    
    @GetMapping("{id}/models")
    public ResponseEntity<?> getModelsByBrand(@PathVariable("id") Long brandId){
    	List<Model> brands = modelService.getByBrand(brandId);
    	List<ModelDTO> list = brands.stream()
//    		.map(model -> modelMapper.toModelDTO(model))
    		.map(modelMapper::toModelDTO)
    		.toList();
    	return ResponseEntity.ok(list);
    }
    
    
    
    
    
    
    
    
    
    /*@GetMapping
    public ResponseEntity<?> getBrands(){

    	List<BrandDTO> list = brandService.getBrands()
    	.stream()
    	.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
    	.collect(Collectors.toList());
    	
    	return ResponseEntity.ok(list);
    	
    	
    	
    	//return ResponseEntity.ok(brandService.getBrands());
    	
    	
    	//Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
    	//return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
    }*/
    
    /*@GetMapping
    public ResponseEntity<?> getBrandByName(@RequestParam Map<String, String> params){

    	List<BrandDTO> list = brandService.getBrands(name)
    	.stream()
    	.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
    	.collect(Collectors.toList());
    	
    	return ResponseEntity.ok(list);
    	
    }*/
}
