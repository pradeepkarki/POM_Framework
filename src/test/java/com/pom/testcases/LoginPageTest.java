package com.pom.testcases;

import com.pom.base.PageBase;
import com.pom.pages.LoginPage;
import com.pom.util.MavenProperties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends PageBase {

    LoginPage loginPage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateTitle();
        Assert.assertEquals(title, "Administator Login");
    }

    @Test(priority = 2)
    public void loginTest() {
		System.out.println(MavenProperties.getMavenProperties().getProperty("userName"));
		System.out.println(MavenProperties.getMavenProperties().getProperty("password"));
        loginPage.login(MavenProperties.getMavenProperties().getProperty("userName"), MavenProperties.getMavenProperties().getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
