package com.pom.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.base.PageBase;
import com.pom.pages.LoginPage;

public class LoginPageTest extends PageBase {

	LoginPage loginPage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateTitle();
		Assert.assertEquals(title, "Administator Login");
	}

	@Test(priority= 2)
	public void loginTest() {
		loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
