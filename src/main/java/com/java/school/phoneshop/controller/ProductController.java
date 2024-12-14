
package com.java.school.phoneshop.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.school.phoneshop.dto.ProductDTO;
import com.java.school.phoneshop.dto.ProductImportDTO;
import com.java.school.phoneshop.entity.Product;
import com.java.school.phoneshop.mapper.ProductMapper;
import com.java.school.phoneshop.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {
    
    private final ProductService productService;
    private final ProductMapper productMapper;
    
    // Handler
    @RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody ProductDTO productDTO ) {
		Product product = productMapper.toProduct(productDTO);
		product = productService.create(product);

		return ResponseEntity.ok(product);
	}
    
    @PostMapping("importProduct")
	public ResponseEntity<?> importProduct(@RequestBody @Valid ProductImportDTO importDTO){
		productService.importProduct(importDTO);
		return ResponseEntity.ok().build();
	}
    
    
    
    
    
    
    
   
    /*
    @GetMapping("{id}")
    public ResponseEntity<?> getOneBrand(@PathVariable("id") Long brandId){
    	Brand brand = brandService.getById(brandId);
    	//Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
    	return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
    }
    
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long brandId, @RequestBody BrandDTO brandDTO){
//    	Brand brand = Mapper.toBrand(brandDTO);
    	//Brand updatedBrand = brandService.update(brandId, brand);
    	
    	Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
    	Brand updatedBrand = brandService.update(brandId, brand);
    	return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(updatedBrand));
    }
    */
    /*
    @GetMapping
    public ResponseEntity<?> getBrands(@RequestParam Map<String, String> params){
    	
    	Page<Brand> page = brandService.getBrands(params);
    	
    	PageDTO pageDTO = new PageDTO(page);
    	
    	
    	/*List<BrandDTO> list = brandService.getBrand(params)
    	    	.stream()
    	    	.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
    	    	.collect(Collectors.toList());
    	    	
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
    */
    
    
    
    
    
    
    
    
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
