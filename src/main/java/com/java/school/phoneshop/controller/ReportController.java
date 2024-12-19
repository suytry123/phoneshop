
package com.java.school.phoneshop.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.school.phoneshop.dto.ProductReportDTO;
import com.java.school.phoneshop.dto.report.ExpenseReportDTO;
import com.java.school.phoneshop.projection.ProductSold;
import com.java.school.phoneshop.service.ReportService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
@RequestMapping("reports")
public class ReportController {
	private final ReportService reportService;
	
	@GetMapping("{startDate}/{endDate}")
	public ResponseEntity<?> productSold(@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("startDate") LocalDate startDate, 
			@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("endDate") LocalDate endDate) {
		List<ProductSold> productSolds = reportService.getProductSold(startDate, endDate);
		return ResponseEntity.ok(productSolds);
	}

	@GetMapping("v2/{startDate}/{endDate}")
	public ResponseEntity<?> productSoldV2(@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("startDate") LocalDate startDate, 
			@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("endDate") LocalDate endDate) {
		List<ProductReportDTO> productSolds = reportService.getProductReport(startDate, endDate);
		return ResponseEntity.ok(productSolds);
	}

	@GetMapping("expense/{startDate}/{endDate}")
	public ResponseEntity<?> expenseReport(@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("startDate") LocalDate startDate, 
			@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable("endDate") LocalDate endDate) {
		List<ExpenseReportDTO> expenseReportDTOs = reportService.getExtenseReport(startDate, endDate);
		return ResponseEntity.ok(expenseReportDTOs);
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
