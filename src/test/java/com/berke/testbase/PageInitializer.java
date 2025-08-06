package com.berkesolutionssolutions.testbase;

import com.berkesolutionssolutions.pages.AddEmployeePageElements;
import com.berkesolutionssolutions.pages.DashboardPageElements;
import com.berkesolutionssolutions.pages.EmployeeListPageElements;
import com.berkesolutionssolutions.pages.LoginPageElements;
import com.berkesolutionssolutions.pages.PersonalDetailsPageElements;

public class PageInitializer extends BaseClass {
	public static LoginPageElements loginPage;
	public static DashboardPageElements dashboardPage;
	public static AddEmployeePageElements addEmployeePage;
	public static PersonalDetailsPageElements personalDetailsPage;
	public static EmployeeListPageElements employeeListPage;
	
	
	public static void initialize()
	{
		
		 loginPage = new LoginPageElements();
		 dashboardPage = new DashboardPageElements();
		 addEmployeePage = new AddEmployeePageElements();
		 personalDetailsPage = new PersonalDetailsPageElements();
		 employeeListPage = new EmployeeListPageElements();
		
	}
	
	
}
