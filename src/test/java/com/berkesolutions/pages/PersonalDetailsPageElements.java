package com.berkesolutionssolutions.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.berkesolutionssolutions.testbase.BaseClass;

public class PersonalDetailsPageElements {


	
	@FindBy(id = "pim.navbar.employeeName")
	public WebElement fullName;

	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(id = "employeeId")
	public WebElement employeeId;
	
	@FindBy(id = "pimPersonalDetailsForm")
	public WebElement personalDetailsForm;
	
	@FindBy(id = "licenseNo")
	public WebElement drivingLicense;
	
	@FindBy(xpath = "//label[text()='Smoker']")
	public WebElement smokerBox;
	
	@FindBy(id = "emp_gender")
	public WebElement genderDD;
	
	@FindBy(xpath = "//div[@id='emp_gender_inputfileddiv']/div/input")
	public WebElement genderInput;
	
	@FindBy(xpath = "//div[@id='emp_gender_inputfileddiv']/div/ul/li")
	public List<WebElement> genderOptions;
	
	
	@FindBy (xpath = "//div[@id='nation_code_inputfileddiv']/div/input")
	public WebElement nationInput;
	
	@FindBy (xpath = "//div[@id='nation_code_inputfileddiv']/div/ul/li")
	public List<WebElement> nationOptions;
	
	@FindBy (xpath = "//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//i")
	public WebElement licExpDate;
	
	@FindBy (xpath = "//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//div[@class='select-wrapper picker__select--year']/input")
	public WebElement licExpYearInput;
	
	@FindBy (xpath = "//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//div[@class='select-wrapper picker__select--year']/ul/li")
	public List<WebElement> licExpYearOptions;
	
	@FindBy (xpath = "//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//div[@class='select-wrapper picker__select--month']/input")
	public WebElement licExpMonthInput;
	
	
	@FindBy (xpath = "//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//div[@class='select-wrapper picker__select--month']/ul/li")
	public List<WebElement> licExpMonthOptions;
	
	@FindBy (xpath ="//input[@id='emp_dri_lice_exp_date']/following-sibling::span[1]//table/tbody/tr/td")
	public List<WebElement> licExpDays;
	
	@FindBy (xpath ="//form[@id='pimPersonalDetailsForm']//button[@type='submit']")
	public WebElement detailsSaveBtn;

	public PersonalDetailsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
