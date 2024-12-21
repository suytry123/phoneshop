package com.java.school.phoneshop.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.school.phoneshop.dto.ModelDTO;
import com.java.school.phoneshop.entity.Model;
import com.java.school.phoneshop.mapper.ModelEntityMapper;
import com.java.school.phoneshop.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models") //relative path
public class ModelController {
	private final ModelService modelService;
	private final ModelEntityMapper modelMapper;
	
	//@RequestMapping(method = RequestMethod.POST)
//	@PostMapping
//	public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO){
//		//Model model = modelMapper.toModel(modelDTO);
//		Model model = modelService.save(modelDTO);
//		//return ResponseEntity.ok(model);
//		//return ResponseEntity.ok(ModelEntityMapper.INSTANCE.toModelDTO(model));
//		return ResponseEntity.ok(modelMapper.toModelDTO(model));
//	}
	
	//@PostMapping
	@RolesAllowed("ROLE_ADMIN")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO){
		Model model = modelMapper.toModel(modelDTO);
		model = modelService.save(model);
		return ResponseEntity.ok(modelMapper.toModelDTO(model));
	}
	
}
