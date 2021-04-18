package com.training.sanity.tests;

import org.testng.annotations.Test;
import com.training.pom.EditProfilePOM;

public class SimpleTC_EditProfileTest_Admin extends SimpleTC_LoginTest_Admin {

	private EditProfilePOM editProfilePOM;
	@Test(priority=2)
	public void EditProfile() {

		editProfilePOM = new  EditProfilePOM(driver);
		editProfilePOM.ClickHomePage();
		editProfilePOM.ClickEditProfileLink();
		editProfilePOM.EnterCurrentPassword("admin@12345");
		editProfilePOM.EnterNewPassword("admin@123");
		editProfilePOM.ConfirmNewPassword("admin@123");
		screenShot.captureScreenShot("PasswordChanging");
		editProfilePOM.ClickApplyChanges();
	}

}


