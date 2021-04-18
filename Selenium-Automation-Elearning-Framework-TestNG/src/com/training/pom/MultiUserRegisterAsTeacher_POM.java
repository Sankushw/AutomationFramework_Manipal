package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.generics.ScreenShot;

public class MultiUserRegisterAsTeacher_POM {

	private WebDriver driver; 
	private ScreenShot screenShot;
	public MultiUserRegisterAsTeacher_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//a[contains(text(),'Sign up! ')]") private WebElement SignUpLink; 
	@FindBy ( name="firstname") private WebElement FirstName ;
	@FindBy ( name="lastname") private WebElement LastName ;
	@FindBy ( name="email") private WebElement Email ;
	@FindBy ( name="username") private WebElement Username ;
	@FindBy ( name="pass1") private WebElement Password ;
	@FindBy ( name="pass2") private WebElement ConfirmPassword ;
	@FindBy ( name="phone") private WebElement PhoneNumber ;
	@FindBy ( xpath="//Select[@id='registration_language']") private WebElement LanguageDropDown ;
	@FindBy ( xpath="//input[@name='status' and @value='1']") private WebElement TeachCourseIcon ;
	@FindBy ( id="registration_submit") private WebElement SubmitButton ;
	@FindBy ( xpath="//a[@title='Homepage']") private WebElement HomePage ;
	@FindBy ( xpath="//li[@class='dropdown avatar-user']") private WebElement UserIcon_Dropdown ;
	@FindBy ( xpath="//a[@id='logout_button']") private WebElement LogoutButton ;
	

	public void ClickSignUp_Link() {
		
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
		SignUpLink.click();
	}

	public void Fill_RegistrationDetails(String FirstName,String LastName,String Email,String Username,String Password,String ConfirmPassword,String PhoneNumber) throws InterruptedException {

		this.FirstName.sendKeys(FirstName);
		this.LastName.sendKeys(LastName);
		this.Email.sendKeys(Email);
		this.Username.sendKeys(Username);
		this.Password.sendKeys(Password);
		this.ConfirmPassword.sendKeys(ConfirmPassword);
		this.PhoneNumber.sendKeys(PhoneNumber);

		Select Language =new Select(LanguageDropDown);
		Language.selectByVisibleText("English");

		TeachCourseIcon.click();
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();

		Actions actions=new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();

		Thread.sleep(3000);
		SubmitButton.click();
		
		Thread.sleep(2000);
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
		
		UserIcon_Dropdown.click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(LogoutButton));
		LogoutButton.click();
		
		WebDriverWait wait1=new WebDriverWait(driver, 4);
		wait1.until(ExpectedConditions.visibilityOf(SignUpLink));
		
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
		SignUpLink.click();
	}

}


