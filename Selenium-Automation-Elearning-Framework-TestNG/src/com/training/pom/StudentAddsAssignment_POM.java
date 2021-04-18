package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.generics.ScreenShot;

import common.Assert;


public class StudentAddsAssignment_POM {

	private WebDriver driver; 
	private ScreenShot screenShot;
	String CourseName="DevOps_Learning";
	public StudentAddsAssignment_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

	}
	@FindBy (xpath="//a[contains(text(),'Course catalog')]") private WebElement CourseCatalog ;
	@FindBy (name="search_term") private WebElement SearchBox; 
	@FindBy (xpath="//button[@class='btn btn-default' and@type='submit']") private WebElement SearchButton;
	@FindBy (xpath="//a[@class='btn btn-success btn-sm'  and @title='Subscribe']") private WebElement SubscribeBtn; 
	@FindBy (xpath="//div[@class='alert alert-info']") private WebElement ActualHeader; 

	@FindBy (xpath="//a[@title='My courses']") private WebElement MyCourses; 
	//@FindBy (xpath="//a[contains(text(),'"+CourseName+"')]") private WebElement CourseNameIcon; 
	@FindBy (xpath="//img[@title='Assignments']") private WebElement Assignments; 

	@FindBy (xpath="//a[contains(text(),'test system')]") private WebElement AssignedTask; 

	@FindBy (xpath="//a[@class='btn-toolbar']") private WebElement UploadAssignment_Link; 

	//	@FindBy (xpath="//div[@class='button-load']") private WebElement UploadAssignment; 
	@FindBy (xpath="//div[contains(text(),'Click or drag and drop files here to upload them')]") private WebElement UploadAssignment; 

	//--------IMP----------------
	//before running this Test case , login to app with teacher Id and search for DevOps_Learning course and --
	//--open the course and navigate to Users and unsubscribe the Student.Then run the test case.


	public void ClickOnCourseCatalog() {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(CourseCatalog));
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
		CourseCatalog.click();
	}

	public void SubscribingCourse() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(SearchBox));

		SearchBox.sendKeys(CourseName);
		SearchButton.click();

		WebDriverWait wait1=new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOf(SubscribeBtn));
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
		SubscribeBtn.click();
		/*
		 	Thread.sleep(4000);
			WebDriverWait wait2=new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.visibilityOf(ActualHeader));
		String ExpectedHeaderText="User adarsh adarsh (adarsh) has been registered to course "+CourseName;
		String ActualHeaderText=ActualHeader.getAttribute("value");
		if(ActualHeaderText.equals(ExpectedHeaderText))
		{
			System.out.println("The course has been successfully subscribed");
		}*/
	}

	public void OpeningTheCourse() {
		MyCourses.click();
		WebElement CourseNameIcon= driver.findElement(By.xpath("//a[contains(text(),'"+CourseName+"')]"));
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
		CourseNameIcon.click(); 


	}
	public void ClickAssignments() {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Assignments));
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
		Assignments.click();
	}
	public void ClickAssignedTasks() {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(AssignedTask));
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
		AssignedTask.click();
	}
	public void Clik_UploadAssignment() {

		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(UploadAssignment_Link));
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
		UploadAssignment_Link.click();
	}	

	public void UploadAssignmentAttachment() throws InterruptedException {

		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(UploadAssignment));

		Thread.sleep(1000);
		UploadAssignment.click();
		Thread.sleep(2000);
		//put path to your file in a clipboard
		StringSelection ss = new StringSelection("C:\\Users\\SanjayKushwaha\\Desktop\\Response attachment.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		try {
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
		
	}

}
