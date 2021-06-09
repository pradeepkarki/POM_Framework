package com.pom.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import com.pom.base.PageBase;
import com.pom.pages.HomePage;
import com.pom.pages.LoginPage;

public class HomePageTest extends PageBase {

	LoginPage loginPage;
	HomePage homePage;

	public HomePageTest() {
		super();
	}

	@BeforeClass
	public void setup() {
		initialization();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		homePage = new HomePage();
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Administator Login");
	}

	@Test(priority = 2)
	public void verifyUserTest() {
		String logedInUser = homePage.verifyCorrectUserName();
		Assert.assertEquals(logedInUser, "SUPER ADMIN");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
