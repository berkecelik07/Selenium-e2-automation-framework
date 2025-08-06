package com.berkesolutionssolutions.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackgroundExample {
	
	@Given("Precondition1")
	public void precondition1() {
	    System.out.println("Precondition1");
	}
	@Given("Precondition2")
	public void precondition2() {
		System.out.println("Precondition2");
	}
	@When("Test Step nr1")
	public void test_step_nr1() {
	    System.out.println("Test Step nr1");
	}
	@When("Test Step nr2")
	public void test_step_nr2() {
		System.out.println("Test Step nr2");
	}
	@When("Test Step nr3")
	public void test_step_nr3() {
		System.out.println("Test Step nr3");
	}
	@Then("Validation nr1")
	public void validation_nr1() {
	    System.out.println("Validation nr1");
	}
	@Then("Validation nr2")
	public void validation_nr2() {
		System.out.println("Validation nr2");
	}
	
	@When("Test Step nr4")
	public void test_step_nr4() {
		System.out.println("Test Step nr4");
	}
	@When("Test Step nr5")
	public void test_step_nr5() {
		System.out.println("Test Step nr5");
	}
	@When("Test Step nr6")
	public void test_step_nr6() {
		System.out.println("Test Step nr6");
	}
	@Then("Validation nr3")
	public void validation_nr3() {
		System.out.println("Validation nr3");
	}
	@Then("Validation nr4")
	public void validation_nr4() {
		System.out.println("Validation nr4");
	}
	
	@When("Test Step nr1 is firstName {string} and lastName {string}")
	public void test_step_nr1_is_first_name_and_last_name(String firstName, String lastName) {
	    System.out.println("Running Test Step nr1 with firstName " + firstName + 
	    					" and lastName " + lastName);
	}


}
