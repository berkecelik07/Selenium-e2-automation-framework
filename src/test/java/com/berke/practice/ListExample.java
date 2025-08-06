package com.berkesolutions.practice;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		//We can use the classes the implement List
			//ArrayList
			//LinkedList
		List<String> list = new ArrayList<>();
		list.add("Ugur");
		list.add("Osman");
		list.add("Ulku");
		
		System.out.println(list);
		
		for (String name: list)
		{
			System.out.println(name);
		}

	}

}
