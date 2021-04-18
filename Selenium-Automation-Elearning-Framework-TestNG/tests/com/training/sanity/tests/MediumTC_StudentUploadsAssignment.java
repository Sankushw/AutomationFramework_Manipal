package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.StudentAddsAssignment_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MediumTC_StudentUploadsAssignment {

	public WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private StudentAddsAssignment_POM studentAddAssignment;
	private static Properties properties;
	public ScreenShot screenShot;

	@BeforeTest
	//--------IMP----------------
	//before running this Test case , login to app with teacher Id and search for DevOps_Learning course and --
	//--open the course and navigate to Users and unsubscribe the Student.Then run the test case.
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		studentAddAssignment=new StudentAddsAssignment_POM (driver);
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

	@Test(priority=1)
	public void LoginTestAdmin() {

		loginPOM.sendUserName("adarsh");
		loginPOM.sendPassword("adarsh");
		screenShot.captureScreenShot();
		loginPOM.clickLoginBtn();
	}
	@Test(priority=2)
	public void UploadingAssignment() {
		studentAddAssignment.ClickOnCourseCatalog();
		try {
			studentAddAssignment.SubscribingCourse();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		studentAddAssignment.OpeningTheCourse();
		studentAddAssignment.ClickAssignments();
		studentAddAssignment.ClickAssignedTasks();
		studentAddAssignment.Clik_UploadAssignment();
		try {
			studentAddAssignment.UploadAssignmentAttachment();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
