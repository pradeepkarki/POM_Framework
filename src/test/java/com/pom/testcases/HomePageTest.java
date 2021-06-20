package com.pom.testcases;

import com.pom.base.PageBase;
import com.pom.pages.HomePage;
import com.pom.pages.LoginPage;
import com.pom.util.MavenProperties;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
        loginPage.login(MavenProperties.getMavenProperties().getProperty("userName"), MavenProperties.getMavenProperties().getProperty("password"));
        homePage = new HomePage(driver);
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
