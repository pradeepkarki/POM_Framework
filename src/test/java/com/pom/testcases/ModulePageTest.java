package com.pom.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.base.PageBase;
import com.pom.pages.HomePage;
import com.pom.pages.LoginPage;
import com.pom.pages.ModulePage;
import com.pom.testdata.TestDataProvider;

public class ModulePageTest extends PageBase {

	LoginPage loginPage = null;
	HomePage homePage = null;
	ModulePage modulePage = null;

	public ModulePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		homePage = new HomePage();
		modulePage = homePage.clickOnModules();
	}

	@Test(priority = 1)
	public void verifyModulePage() {
		String verifyModulePageMsg = modulePage.verifyModulePage();

		Assert.assertEquals(verifyModulePageMsg.equals("PRIMARY MODULES1"), true);
	}

	@Test(priority = 3, dataProvider = "data-provider", dataProviderClass = TestDataProvider.class)
	public void enableDisableTest(String srno, String module, String action) {
		modulePage.enableDisable(srno, module, action);
		WebElement em = null;

		Select s = new Select(em);
		List<WebElement> options = s.getOptions();
		for (WebElement ele : options) {
			ele.getText();
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
