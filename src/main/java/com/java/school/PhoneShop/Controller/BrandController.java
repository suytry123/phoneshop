
package com.java.school.PhoneShop.Controller;

import com.java.school.PhoneShop.Dto.BrandDTO;
import com.java.school.PhoneShop.Entity.Brand;
import com.java.school.PhoneShop.Mapper.BrandMapper;
import com.java.school.PhoneShop.Service.BrandService;
import com.java.school.PhoneShop.Service.Util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("brands")

public class BrandController {
    @Autowired
    private BrandService brandService;
    
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
    	return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
    }
}
