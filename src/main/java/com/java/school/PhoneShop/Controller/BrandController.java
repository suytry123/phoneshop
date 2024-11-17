
package com.java.school.PhoneShop.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.school.PhoneShop.Dto.BrandDTO;
import com.java.school.PhoneShop.Dto.ModelDTO;
import com.java.school.PhoneShop.Dto.PageDTO;
import com.java.school.PhoneShop.Entity.Brand;
import com.java.school.PhoneShop.Entity.Model;
import com.java.school.PhoneShop.Mapper.BrandMapper;
import com.java.school.PhoneShop.Mapper.ModelEntityMapper;
import com.java.school.PhoneShop.Service.BrandService;
import com.java.school.PhoneShop.Service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("brands")
public class BrandController {
    
    private final BrandService brandService;
    private final ModelService modelService;
    private final ModelEntityMapper modelMapper;
    
    // Handler
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
    public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId){
    	Brand brand = brandService.getById(brandId);
    	//Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
    	return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
    }
    
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer brandId, @RequestBody BrandDTO brandDTO){
//    	Brand brand = Mapper.toBrand(brandDTO);
    	//Brand updatedBrand = brandService.update(brandId, brand);
    	
    	Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
    	Brand updatedBrand = brandService.update(brandId, brand);
    	return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(updatedBrand));
    }
    
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
    public ResponseEntity<?> getModelsByBrand(@PathVariable("id") Integer brandId){
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
