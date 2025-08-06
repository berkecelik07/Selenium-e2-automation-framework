package com.berke.steps;

import com.berke.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchEmployeeSteps extends CommonMethods{

	@Given("user is logged in with valid credentials")
	public void user_is_logged_in_with_valid_credentials() {
		loginPage.adminLogin();
	}
	@Given("user navigates to employee list page")
	public void user_navigates_to_employee_list_page() {
		click(dashboardPage.PIM);
		click(dashboardPage.employeeList);
	}
	@When("user enters valid employee id")
	public void user_enters_valid_employee_id() {
	   sendText(employeeListPage.searchBox, "0032");
	}
	@When("clicks on search button")
	public void clicks_on_search_button() {
	    click(employeeListPage.searchIcon);
	}
	@Then("employee information is displayed")
	public void employee_information_is_displayed() {
		System.out.println("I see it!");
		wait(4);
	}

	@When("user enters valid employee first and last name")
	public void user_enters_valid_employee_first_and_last_name() {
		sendText(employeeListPage.searchBox,"Brody  Alan");
	}

}
