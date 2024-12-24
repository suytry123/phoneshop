package com.java.school.PhoneShop.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.java.school.phoneshop.utils.GeneralUtils;


public class GeneralUtilsTest {
	
	//@Test
	public void toIntegerList() {
		//Given
		List<String> name = List.of("Dara","Cheata","Seyha");
		//When
		List<Integer> list = GeneralUtils.toIntegerList(name);
		//Then
		//[4,6,5]
		
		assertEquals(3, list.size());
		assertEquals(4, list.get(0));
		assertEquals(6, list.get(1));
		assertEquals(5, list.get(2));
	}
	
	//@Test
	public void getEventNumber() {
		//Given
		List<Integer> list = List.of(4,5,34,32,33,55,30);
		//When = call function
		List<Integer> eventNumber = GeneralUtils.getEventNumber(list);
		//Then
		assertEquals(4, eventNumber.size());
		assertEquals(4, eventNumber.get(0));
		assertEquals(34, eventNumber.get(1));
		assertEquals(32, eventNumber.get(2));
		assertEquals(30, eventNumber.get(3));
	}
	@Test
	public void showPassword() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encode = passwordEncoder.encode("dara123");
		System.out.println(encode);
	}
}
