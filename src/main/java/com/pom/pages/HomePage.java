package com.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.base.PageBase;



public class HomePage extends PageBase {

	@FindBy(xpath = "//*[@id=\"sidebar\"]/div[2]/a/p/strong")
	WebElement logedInUserLabel;

	@FindBy(xpath = "//*[@id=\"social-sidebar-menu\"]/li[1]/a")
	WebElement dashboardLink;

	@FindBy(xpath = "//*[@id=\"social-sidebar-menu\"]/li[2]/a/span[1]")
	WebElement updatesLink;

	@FindBy(xpath = "//*[@id=\"social-sidebar-menu\"]/li[3]/a")
	WebElement modulesLink;

	// Initializing the Page Objects:

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public String verifyCorrectUserName() {
		return logedInUserLabel.getText();
	}

	public DashBoardPage clickOnDashBoardLink() {
		dashboardLink.click();
		return new DashBoardPage();
	}

	public UpdatePage clickOnUpdatesLink() {
		updatesLink.click();
		return new UpdatePage();
	}

	public ModulePage clickOnModules() {
		modulesLink.click();
		return new ModulePage();
	}
}
