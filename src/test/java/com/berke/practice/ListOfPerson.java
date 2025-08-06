package com.berkesolutions.practice;

import java.util.ArrayList;
import java.util.List;

public class ListOfPerson {

	public static void main(String[] args) {

		List<Person> listOfPeople = new ArrayList<>();
		listOfPeople.add(new Person("Scott", 24));
		listOfPeople.add(new Person("Adela", 20));
		listOfPeople.add(new Person("Asli", 18));

		System.out.println(listOfPeople);
		
		for (Person p : listOfPeople)
		{
			System.out.println(p);
		}

	}

}

class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	
	  public String toString() 
	  { 
		  return name + " : " + age; 
	  }
	  
	  //Break until 9:18
	 
}
