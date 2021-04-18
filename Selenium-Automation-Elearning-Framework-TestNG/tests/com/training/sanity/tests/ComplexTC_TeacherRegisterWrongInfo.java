package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;


import com.training.pom.TeacherRegisterWithWrongInfo_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ComplexTC_TeacherRegisterWrongInfo {

	public WebDriver driver;
	private String baseUrl;
	private TeacherRegisterWithWrongInfo_POM RegError;
	private static Properties properties;
	public ScreenShot screenShot;

	@BeforeTest
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.CHROME);
		RegError = new TeacherRegisterWithWrongInfo_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}

	@Test(priority=0)
	public void ClickOnSignUp()
	{
		RegError.ClickSignUp_Link();
	}
	
			
			
	@Test(priority=1,dataProvider = "FillInvalidTeacherInfo", dataProviderClass = LoginDataProviders.class)
	public void FillTeacherInfo(String FirstName, String LastName, String Email, String Username, String Password, String ConfirmPassword, String PhoneNumber) throws InterruptedException {
		
		RegError.Fill_RegistrationDetails(FirstName, LastName, Email, Username, Password, ConfirmPassword, PhoneNumber);

	}


}

	
	

