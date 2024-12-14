package com.java.school.phoneshop.service.impl;

import org.springframework.stereotype.Service;

import com.java.school.phoneshop.entity.Color;
import com.java.school.phoneshop.exception.ResourceNotFoundException;
import com.java.school.phoneshop.repository.ColorRepository;
import com.java.school.phoneshop.service.ColorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ColorServiceImpl implements ColorService {
	private final ColorRepository colorRepository;

	@Override
	public Color create(Color color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getById(Long id) {
		return colorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Color", id));
	}

}
