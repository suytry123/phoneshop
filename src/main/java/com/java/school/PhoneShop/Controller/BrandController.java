
package com.java.school.PhoneShop.Controller;

import com.java.school.PhoneShop.Dto.BrandDTO;
import com.java.school.PhoneShop.Entity.Brand;
import com.java.school.PhoneShop.Service.BrandService;
import com.java.school.PhoneShop.Service.Util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("brands")

public class BrandController {
    @Autowired
    private BrandService brandService;
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> Create(@RequestBody BrandDTO brandDTO){
        Brand brand = Mapper.toBrand(brandDTO);
        brand = brandService.create(brand);
        return ResponseEntity.ok(brand);
        //return ResponseEntity.ok(Mapper.toBrandDTO(brand));
    }
}
