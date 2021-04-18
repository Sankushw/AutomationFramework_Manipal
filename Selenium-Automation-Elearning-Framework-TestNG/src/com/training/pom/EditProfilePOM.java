package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.generics.ScreenShot;

public class EditProfilePOM {

	private WebDriver driver; 
	private ScreenShot screenShot;


	public EditProfilePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy ( linkText="Homepage") private WebElement HomePage ;
	@FindBy(linkText="Edit profile") private WebElement Edit_Profile; 
	@FindBy(xpath="//input[@name='password0']") private WebElement CurrentPassword;
	@FindBy(xpath="//label[contains(text(),'New password')]/parent::div/div[1]/input") private WebElement NewPassword;
	@FindBy(xpath="//label[contains(text(),'Confirm password')]/parent::div/div[1]/input") private WebElement ConfirmPassword;
	@FindBy ( id="profile_apply_change") private WebElement SaveChangesButton ;

	public void ClickHomePage() {

		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(HomePage));
		HomePage.click();

	}

	public void ClickEditProfileLink() {

		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Edit_Profile));
		this.Edit_Profile.click();

	}

	public void EnterCurrentPassword(String CurrentPassword) {
		this.CurrentPassword.sendKeys(CurrentPassword);
		System.out.println("current password: "+CurrentPassword);
	}

	public void EnterNewPassword(String NewPassword) {
		this.NewPassword.sendKeys(NewPassword);
		System.out.println("New Password: "+NewPassword);
	}

	public void ConfirmNewPassword(String ConfirmPassword) {
		this.ConfirmPassword.sendKeys(ConfirmPassword);

	}

	public void ClickApplyChanges() {
		this.SaveChangesButton.click();

	}
}
