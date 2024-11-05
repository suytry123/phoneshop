package com.java.school.PhoneShop.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.school.PhoneShop.Dto.ModelDTO;
import com.java.school.PhoneShop.Entity.Model;
import com.java.school.PhoneShop.Mapper.ModelMapper;
import com.java.school.PhoneShop.Service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models") //relative path
public class ModelController {
	private final ModelService modelService;
	private final ModelMapper modelMapper;
	
	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO){
		Model model = modelMapper.toModel(modelDTO);
		model = modelService.save(model);
		return ResponseEntity.ok(model);
	}
	
	
}
