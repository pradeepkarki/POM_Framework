package com.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.base.PageBase;



public class LoginPage {

	WebDriver driver;

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

	public LoginPage(WebDriver driver) {
		this.driver = driver;
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
