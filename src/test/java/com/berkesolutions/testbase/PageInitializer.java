package com.berkesolutions.testbase;

import com.berkesolutions.pages.AddEmployeePageElements;
import com.berkesolutions.pages.DashboardPageElements;
import com.berkesolutions.pages.EmployeeListPageElements;
import com.berkesolutions.pages.LoginPageElements;
import com.berkesolutions.pages.PersonalDetailsPageElements;

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
