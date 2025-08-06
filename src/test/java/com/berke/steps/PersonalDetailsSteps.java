package com.berkesolutionssolutions.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.berkesolutionssolutions.utils.CommonMethods;

import io.cucumber.java.en.Then;

public class PersonalDetailsSteps extends CommonMethods {

	
	@Then("I am able to modify Employee Details {string}, {string}, {string}, {string}, {string}")
	public void i_am_able_to_modify_employee_details(String driverLicense, 
			String expirationDate, String smoker, String gender, String nationality) {

		
		//let us wait for the whole form to show up
		waitForVisibility(personalDetailsPage.personalDetailsForm);
		
		//send license number
		sendText(personalDetailsPage.drivingLicense, driverLicense);

		//click on Smoker check box if the employee is a smoker
		if (smoker.equals("Yes"))
		{
			click(personalDetailsPage.smokerBox);
		}
		
		//select gender
		
		//1st way: selectDropdown
		
	//	selectDropdown(personalDetailsPage.genderDD, gender);
		
		//2nd way: click and select
	//	click(personalDetailsPage.genderInput); //click on the gender input element
	//	click(driver.findElement(By.xpath("//span[text()='"+gender+"']"))); //click on an element based on the gender String
		
		//3rd way: click and get list of elements and click based on condition
		click(personalDetailsPage.genderInput); //click on the gender input element
		List<WebElement> genderOptions = personalDetailsPage.genderOptions;
		clickOnElement(genderOptions, gender);
		
		
		//select nationality
		click(personalDetailsPage.nationInput);
		clickOnElement(personalDetailsPage.nationOptions, nationality);
		
		//set the expiration date
		click(personalDetailsPage.licExpDate);
		
		
		//our incoming date format is: 2023-05-10
		//I want to select year: 
		String[] dateParts = expirationDate.split("-");
		//dateParts = ["2023", "05", "10"]
		
		click(personalDetailsPage.licExpYearInput);
		clickOnElement(personalDetailsPage.licExpYearOptions, dateParts[0]);
		

		//select month 
		//month is at dateParts[1]
		int month = Integer.parseInt(dateParts[1]); // from 05 as a String ---> int 5
		click(personalDetailsPage.licExpMonthInput);
		click(personalDetailsPage.licExpMonthOptions.get(month-1));
		
		
		//select day
		int day = Integer.parseInt(dateParts[2]);
		selectCalendarDate(personalDetailsPage.licExpDays, day+"");
		
		wait(2);
	}
	
	
	public void clickOnElement(List<WebElement> list, String value)
	{
		wait(1);
		for (WebElement option : list)
		{
			if (option.getText().equals(value))
			{
				click(option);
				break;
			}
		}
	}
	
	
	
	
	@Then("I click on Personal Details Save")
	public void i_click_on_personal_details_save() {
		
		jsClick(personalDetailsPage.detailsSaveBtn);
	}
	
	
}
