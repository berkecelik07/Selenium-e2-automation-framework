/**
 * PageInitializer - Centralized page object initialization
 * 
 * This class initializes all page objects used in the framework.
 * It implements the Page Object Model (POM) pattern by creating
 * instances of page element classes that can be used across all steps.
 * 
 * All page objects are static and can be accessed from any step definition
 * or utility class that extends this class.
 * 
 * @author Berke Solutions
 * @version 1.0
 */
package com.berkesolutions.testbase;

import com.berkesolutions.pages.AddEmployeePageElements;
import com.berkesolutions.pages.DashboardPageElements;
import com.berkesolutions.pages.EmployeeListPageElements;
import com.berkesolutions.pages.LoginPageElements;
import com.berkesolutions.pages.PersonalDetailsPageElements;

public class PageInitializer extends BaseClass {
	
	// Page object instances - accessible throughout the framework
	public static LoginPageElements loginPage;
	public static DashboardPageElements dashboardPage;
	public static AddEmployeePageElements addEmployeePage;
	public static PersonalDetailsPageElements personalDetailsPage;
	public static EmployeeListPageElements employeeListPage;

	/**
	 * Initializes all page objects
	 * 
	 * This method should be called during setup (in BaseClass.setUp())
	 * to instantiate all page object classes. Each page object initializes
	 * its WebElements using @FindBy annotations and PageFactory.
	 * 
	 * Note: Ensure that all page constructors call PageFactory.initElements()
	 * to properly initialize the WebElements.
	 */
	public static void initialize() {
		System.out.println("📖 Initializing Page Objects...");
		
		loginPage = new LoginPageElements();
		System.out.println("✅ LoginPageElements initialized");
		
		dashboardPage = new DashboardPageElements();
		System.out.println("✅ DashboardPageElements initialized");
		
		addEmployeePage = new AddEmployeePageElements();
		System.out.println("✅ AddEmployeePageElements initialized");
		
		personalDetailsPage = new PersonalDetailsPageElements();
		System.out.println("✅ PersonalDetailsPageElements initialized");
		
		employeeListPage = new EmployeeListPageElements();
		System.out.println("✅ EmployeeListPageElements initialized");
		
		System.out.println("🎉 All Page Objects initialized successfully!");
	}

}
