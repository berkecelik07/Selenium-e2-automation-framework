package com.berke.steps;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableSteps {
	@When("I login to the HRMs")
	public void i_login_to_the_hr_ms() {
		System.out.println("Login");
	}
	@When("I want to add Employees")
	public void i_want_to_add_employees(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
		//List of Maps - How does look like?
		//This is not a part of the implementation, it's just a recap!
		
		/*
		 * Map<String, String> map1 = new HashMap<>(); map1.put("FirstName", "Mohamed");
		 * map1.put("MiddleName", "Y"); map1.put("LastName", "Ghazy");
		 * 
		 * Map<String, String> map2 = new HashMap<>(); map2.put("FirstName", "Mucteba");
		 * map2.put("MiddleName", "B"); map2.put("LastName", "Yuksel");
		 * 
		 * Map<String, String> map3 = new HashMap<>(); map3.put("FirstName", "Hassan");
		 * map3.put("MiddleName", "G"); map3.put("LastName", "Aldoori");
		 * 
		 * List<Map<String, String>> lm = new ArrayList<>(); lm.add(map1); lm.add(map2);
		 * lm.add(map3);
		 */
		//[{}, {}, {}]
		
		//Getting data from the incoming DataTable
		List<Map<String, String>> listOfMaps = dataTable.asMaps();
		for (Map<String, String> map: listOfMaps) {
			System.out.println(map);
			System.out.println("-------------");
			System.out.println("First Name: " + map.get("FirstName"));
			System.out.println("Middle Name: " + map.get("MiddleName"));
			System.out.println("Last Name: " + map.get("LastName"));
		}
		
	}
	@Then("I validate employee is added")
	public void i_validate_employee_is_added() {
	   System.out.println("Validate Employee Added");
	}

}
