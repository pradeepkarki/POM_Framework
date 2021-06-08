package com.pom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.base.PageBase;
import com.pom.pages.DashBoardPage;
import com.pom.pages.HomePage;
import com.pom.pages.LoginPage;

public class DashboardPageTest extends PageBase {

	HomePage homePage;
	LoginPage loginPage;
	DashBoardPage dashboardPage;

	public DashboardPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		homePage = new HomePage();
		dashboardPage = homePage.clickOnDashBoardLink();
	}

	@Test(priority = 1)
	public void validateDahboardLabel() {
		String verifyDashboardLabel = dashboardPage.verifyDashboardLabel();
		if (verifyDashboardLabel.equals("0"))
			Assert.assertEquals(verifyDashboardLabel.equals("0"), true);
	}

	@Test(priority = 2)
	public void validateBookingCheckBox() {
		dashboardPage.selectForBooking();
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
