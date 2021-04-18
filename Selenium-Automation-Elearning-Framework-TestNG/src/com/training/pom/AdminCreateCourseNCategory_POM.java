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



public class AdminCreateCourseNCategory_POM {

	public WebDriver driver; 
	WebDriverWait wait;
	private ScreenShot screenShot;
	Actions act;
	public AdminCreateCourseNCategory_POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//a[contains(text(),'Administration')]") private WebElement Administration_Tab ;
	@FindBy (xpath="//a[contains(text(),'Courses categories')]") private WebElement CourseCategories; 
	@FindBy (xpath="//img[@title='Add category']") private WebElement AddCategory_Icon;
	@FindBy (id="course_category_code") private WebElement CategoryCode; 
	@FindBy (id="course_category_name") private WebElement CategoryName ;
	@FindBy (id="course_category_submit") private WebElement AddCategory_Button ;

	@FindBy (xpath="//a[contains(text(),'ELC')]") private WebElement CourseCreated_Link ;

	@FindBy (xpath="//a[contains(text(),'Create a course')]") private WebElement CreateACourse_Link ;
	@FindBy (id="update_course_title") private WebElement CourseTitle; 
	@FindBy (id="visual_code") private WebElement Coursecode ;
	@FindBy (xpath="//span[@class='select2-selection__choice__remove']") private WebElement RemoveExistingTeacherEntry ;
	@FindBy (xpath="//input[@class='select2-search__field' and @placeholder='Please select an option']") private WebElement Teacher ;
	@FindBy (xpath="//div[@class='filter-option-inner-inner']") private WebElement Category ;
	@FindBy (xpath="//*[@id='update_course']/fieldset/div[3]/div[1]/div/div/div[1]/input") private WebElement Category_textBox ;

	@FindBy (id="update_course_submit") private WebElement CreateCourse_Button ;

	public void click_Coursecategories() {
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Administration_Tab));
		this.Administration_Tab.click();
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
		CourseCategories.click();
	}

	public void Click_AddCategoryIcon() {
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(AddCategory_Icon));
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
		AddCategory_Icon.click();

	}

	public void AddCategory() {
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(CategoryCode));
		CategoryCode.sendKeys("ELC");
		CategoryName.sendKeys("E-Learning Course");
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
		AddCategory_Button.click();
	}


	public void Screenshot_The_CourseCreated() {
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(CourseCreated_Link));
		act=new Actions(driver);
		act.moveToElement(CourseCreated_Link).build().perform();
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
		Administration_Tab.click();
	}

	public void ClickCreateACourse() {
		
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(CreateACourse_Link));
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
		CreateACourse_Link.click();

	}

	public void CreateACourse() throws InterruptedException{

		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(CourseTitle));
		CourseTitle.sendKeys("Learning Selenium");
		Coursecode.sendKeys("LS");
		Thread.sleep(500);
		RemoveExistingTeacherEntry.click();
		Thread.sleep(500);
		Teacher.sendKeys("akash");
		Thread.sleep(2000);
		act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		
		Category.click();
		Thread.sleep(1000);
		Category_textBox.sendKeys("E-Learning Course");
		Thread.sleep(1000);

		act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
	
		screenShot=new ScreenShot(driver);
		screenShot.captureScreenShot();
	
		CreateCourse_Button.click();
	}
}



