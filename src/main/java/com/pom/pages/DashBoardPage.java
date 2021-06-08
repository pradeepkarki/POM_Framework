package com.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.base.PageBase;



public class DashBoardPage extends PageBase {

	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/p")
	@CacheLookup
	WebElement dashboardLabel;

	@FindBy(xpath = "//*[@id=\"content\"]/div[5]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[2]/td[1]/div/input")
	WebElement selectBooking;

	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div[2]/div[1]/div[1]/div/div/div[2]/div/span[1]/strong")
	WebElement todaysBooking;

	public DashBoardPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyDashboardLabel() {
		String dashboardLabel1 = dashboardLabel.getText();
		return dashboardLabel1;
	}

	public void selectForBooking() {
		selectBooking.click();
	}

	public String todaysBooking() {
		return todaysBooking.getText();
	}
}
