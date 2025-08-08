package com.berkesolutions.steps;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.berkesolutions.utils.CommonMethods;
import com.berkesolutions.utils.ConfigsReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps extends CommonMethods{
	/*
	 * //we are commenting the page element objects out because we want to use the inherited
	//page element objects
	
	// We need to create instance variable(s)
	// 1. LoginPageElements
//	LoginPageElements login;
	// 2. DashboardPageElements
//	DashboardPageElements dashboard;

	
	@Given("I navigated to the HRM Website")
	public void i_navigated_to_the_hrm_website() {
		setUp();
		
		login = new LoginPageElements();
		dashboard = new DashboardPageElements();
	}
*/
	@When("I enter a valid username")
	public void i_enter_a_valid_username() {
		
		sendText(loginPage.username, 
				ConfigsReader.getProperty("username"));
	}

	@When("I enter a valid password")
	public void i_enter_a_valid_password() {
		sendText(loginPage.password, 
				ConfigsReader.getProperty("password"));
	}
	   

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
	    click(loginPage.loginBtn);
	}

	@Then("I validate that I am logged in")
	public void i_validate_that_i_am_logged_in() {
		String expected = "Jacqueline White";
		String actual = dashboardPage.accountName.getText();
		
		if (actual.equals(expected)) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
	}

	/*
	
	@Then("I will quit the browser")
	public void i_will_quit_the_browser() {
	    tearDown();
	}

*/
	
	@When("I enter an invalid password")
	public void i_enter_an_invalid_password() {
		sendText(loginPage.password, "wrongPassword!");
	}

	@Then("I validate Invalid Credentials is displayed")
	public void i_validate_invalid_credentials_is_displayed() {
		
		String expectedText = "Invalid Credentials";
		String actualText = loginPage.wrongCredentialsMessage.getText();
		
		if (actualText.equals(expectedText))
		{
			System.out.println("Test Passed!");
		}
		else
		{
			System.out.println("Test Failed!");
		}
	}
	
	@When("user enters login information {string} and {string}")
	public void user_enters_login_information_and(String username, String password) {
		sendText(loginPage.username, username);
		sendText(loginPage.password, password);
	}
	@Then("verify that {string} is showing")
	public void verify_that_is_showing(String expectedAccountName) {
		String actualName = dashboardPage.accountName.getText();
		
		Assert.assertEquals("The account name did not match!", 
				expectedAccountName, actualName);
	
	}
	
	@When("user enter username and password and clicks on the login button")
	public void user_enter_username_and_password_and_clicks_on_the_login_button(DataTable dataTable) {
		//TODO
		//for every row of DataTable
		//send login credentials 
		//click login
		//verify
		//logout
		
		//get the data in dataTable as a list of maps
		List<Map<String, String>> listOfMaps = dataTable.asMaps();
		
		for (Map<String, String> map : listOfMaps)
		{
			System.out.println("Logining in as " + map.get("username") + 
								" : " + map.get("password"));
				
		//login
		sendText(loginPage.username, map.get("username"));
		sendText(loginPage.password, map.get("password"));
		
		click(loginPage.loginBtn);
		
		wait(1);
		
		//validate
		String actualAccountName = dashboardPage.accountName.getText();
		Assert.assertEquals(map.get("employeeName"), actualAccountName);
		
		//logout 
		click(dashboardPage.accountMenu);
		click(dashboardPage.logout);
		}
	}



}
