package com.java.school.PhoneShop.Exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException{

	/*public ResourceNotFoundException(HttpStatus status, String message) {
		super(status, message);
		// TODO Auto-generated constructor stub
	}*/
	
	public ResourceNotFoundException(String resourceName, Integer id) {
		//String text = String.format("%s With id = %d Not Found", resourceName, id);
		super(HttpStatus.NOT_FOUND, String.format("%s With id = %d Not Found", resourceName, id));
		
	}
	
}
