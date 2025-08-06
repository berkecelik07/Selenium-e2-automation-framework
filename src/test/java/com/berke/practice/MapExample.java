package com.berke.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapExample {

	public static void main(String[] args) {
		
		Map<String, String> map = new LinkedHashMap<>();
		
		map.put("firstName", "Erhan");
		map.put("lastName", "Oz");
		map.put("age", "23");
		
		System.out.println(map);
		
			
		System.out.println(map.get("firstName"));
		System.out.println(map.get("age"));

	}

}
