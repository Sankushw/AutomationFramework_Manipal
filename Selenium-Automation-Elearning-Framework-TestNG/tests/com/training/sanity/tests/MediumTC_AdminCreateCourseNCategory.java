package com.training.sanity.tests;

import org.testng.annotations.Test;
import com.training.pom.AdminCreateCourseNCategory_POM;


public class MediumTC_AdminCreateCourseNCategory extends SimpleTC_LoginTest_Admin {

	private AdminCreateCourseNCategory_POM CreateCourse;

	@Test(priority=2)
	public void CreateCourseBYAdmin() {

		CreateCourse = new  AdminCreateCourseNCategory_POM(driver);
		CreateCourse.click_Coursecategories();
		CreateCourse.Click_AddCategoryIcon();
		CreateCourse.AddCategory();
		CreateCourse.Screenshot_The_CourseCreated();
		CreateCourse.ClickCreateACourse();

		try {	CreateCourse.CreateACourse();	}
		catch (InterruptedException e) {e.printStackTrace();	}

	}

}