package com.java.school.phoneshop.utils;

import java.util.List;
import java.util.stream.Collectors;

public class GeneralUtils {
	
	//Convert list of string to list of integer
	// ["Dara","Thida","Seyha"]
	// => [4,5,5]
	
	public static List<Integer> toIntegerList(List<String> list){
		return list.stream()
		.map(s -> s.length())
		.collect(Collectors.toList());
		
	}
	
	public static List<Integer> getEventNumber(List<Integer> list){
		return list.stream().filter(s -> s%2 == 0).collect(Collectors.toList());
		
	}
}
