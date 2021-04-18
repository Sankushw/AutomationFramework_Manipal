package com.training.sanity.tests;

import org.testng.annotations.Test;
import com.training.pom.AdminCreatesUser_POM;

public class MediumTC_AdminCreatesUser extends SimpleTC_LoginTest_Admin {

	private AdminCreatesUser_POM adminCreatesUser_POM;
	
	@Test(priority=2)
	public void CreateCourseBYAdmin() {

		adminCreatesUser_POM = new  AdminCreatesUser_POM(driver);
		adminCreatesUser_POM.click_AddUser();
		adminCreatesUser_POM.Fill_UserDetails();
		adminCreatesUser_POM.Clicking_AddUserToCourse();
		adminCreatesUser_POM.Adding_UsertoCourse();
}
}
