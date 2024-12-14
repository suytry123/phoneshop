package com.java.school.phoneshop.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException{

	
	public ResourceNotFoundException(String resourceName, Long id) {
		//String text = String.format("%s With id = %d Not Found", resourceName, id);
		super(HttpStatus.NOT_FOUND, String.format("%s With id = %d Not Found", resourceName, id));
		
	}
	
}
