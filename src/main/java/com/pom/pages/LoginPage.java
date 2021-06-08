package com.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.base.PageBase;



public class LoginPage extends PageBase {

	@FindBy(xpath = "//input[@type=\"text\"]")
	WebElement userNameEle;

	@FindBy(xpath = "//input[@type=\"password\"]")
	WebElement passwordEle;

	@FindBy(xpath = "//*[@type=\"submit\"]")
	WebElement logInButton;

	/*
	 * public LoginPage(WebDriver driver) { driver = LoginPage.driver; }
	 */
	
	// Using page factory

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateTitle() {
		return driver.getTitle();
	}

	public void login(String userName, String password) {

		userNameEle.sendKeys(userName);
		passwordEle.sendKeys(password);
		logInButton.click();

	}

}
