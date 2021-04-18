package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.generics.ScreenShot;

public class LoginPOM {

	private WebDriver driver; 
	private ScreenShot screenShot;
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy ( id="btn_signin") private WebElement Signin_Button ;
	@FindBy(id="login") private WebElement userName; 
	@FindBy(id="password") private WebElement password;
	@FindBy(id="form-login_submitAuth") private WebElement loginBtn; 
	@FindBy ( xpath="//li[@class='dropdown avatar-user']") private WebElement UserIcon_Dropdown ;
	@FindBy ( xpath="//a[@id='logout_button']") private WebElement LogoutButton ;

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}

	public void clickLoginBtn() {
		this.loginBtn.click();
	}

}
