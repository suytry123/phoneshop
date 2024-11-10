package com.java.school.PhoneShop.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.school.PhoneShop.Dto.ModelDTO;
import com.java.school.PhoneShop.Entity.Model;
import com.java.school.PhoneShop.Mapper.ModelEntityMapper;
import com.java.school.PhoneShop.Service.ModelService;

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
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO){
		Model model = modelMapper.toModel(modelDTO);
		model = modelService.save(model);
		return ResponseEntity.ok(modelMapper.toModelDTO(model));
	}
	
}
