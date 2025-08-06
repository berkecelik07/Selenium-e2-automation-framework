package com.berke.testbase;

import com.berke.pages.AddEmployeePageElements;
import com.berke.pages.DashboardPageElements;
import com.berke.pages.EmployeeListPageElements;
import com.berke.pages.LoginPageElements;
import com.berke.pages.PersonalDetailsPageElements;

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
