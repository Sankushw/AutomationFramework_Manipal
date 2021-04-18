
package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.generics.ScreenShot;

public class AdminCreatesUser_POM {


	public WebDriver driver; 
	WebDriverWait wait;
	private ScreenShot screenShot;
	public AdminCreatesUser_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//a[contains(text(),'Administration')]") private WebElement Administration_Tab ;
	@FindBy (xpath="//a[contains(text(),'Add a user')]") private WebElement AddUser_link; 

	@FindBy (id="firstname") private WebElement Firstname_Box; 
	@FindBy (id="lastname") private WebElement Lastname_Box ;
	@FindBy (id="email") private WebElement Email_Box ;
	@FindBy (id="username") private WebElement Login_Box ;
	@FindBy (xpath="//input[@name='password[password_auto]' and @value='0']") private WebElement EnterPassword_RadioButton ;
	@FindBy (id="password") private WebElement Password_Box; 
	@FindBy (id="status_select") private WebElement Profile; 
	@FindBy (name="submit") private WebElement Submit_button; 

	@FindBy (xpath="//a[contains(text(),'Add users to course')]") private WebElement AddUserToCourse_link; 

	@FindBy (name="UserList[]") private WebElement UserList_Dropdown ;
	@FindBy (name="CourseList[]") private WebElement CourseList_Dropdown ;	
	@FindBy (xpath="//button[@class='btn btn-primary']") private WebElement AddToCourse_Button ;

	public void click_AddUser() {
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Administration_Tab));
		this.Administration_Tab.click();
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
		AddUser_link.click();
	}

	public void Fill_UserDetails() {
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Firstname_Box));

		Firstname_Box.sendKeys("Shivam");
		Lastname_Box.sendKeys("Sharma");
		Email_Box.sendKeys("ShivamSelTest@gmail.com");
		Login_Box.sendKeys("Shivam");
		EnterPassword_RadioButton.click();
		Password_Box.sendKeys("Shivam@123");
		Select select= new Select(Profile);
		select.selectByVisibleText("Trainer");
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
		Submit_button.click();
	}

	public void Clicking_AddUserToCourse() {

		Administration_Tab.click();
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(AddUserToCourse_link));
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
		AddUserToCourse_link.click();

	}


	public void Adding_UsertoCourse() {
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(UserList_Dropdown));

		Select select1= new Select(UserList_Dropdown);
		select1.selectByVisibleText("adarsh adarsh (adarsh)");

		Select select2= new Select(CourseList_Dropdown);
		select2.selectByVisibleText("(SELENIUM) Selenium");

		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
		AddToCourse_Button.click();
	}


}


