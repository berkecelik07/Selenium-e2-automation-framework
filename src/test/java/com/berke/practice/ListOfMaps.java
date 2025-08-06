package com.berkesolutionssolutions.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfMaps {

	public static void main(String[] args) {
		
		List<Map<String, String>> listOfMaps = new ArrayList<>();
		
		Map<String, String> mucteba = new HashMap<>();
		mucteba.put("firstName", "Mucteba");
		mucteba.put("lastName", "Yuksel");
		
		listOfMaps.add(mucteba);
		
		Map<String, String> scott = new HashMap<>();
		scott.put("firstName", "Scott");
		scott.put("lastName", "Seyrek");
		
		listOfMaps.add(scott);
		
		System.out.println(listOfMaps);
	}

}
