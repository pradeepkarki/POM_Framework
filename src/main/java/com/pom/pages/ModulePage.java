package com.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.base.PageBase;



public class ModulePage extends PageBase {

	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[1]")
	WebElement moduleLevel;

	@FindBy(xpath = "//*[@class='table table-hover table-striped table-bordered']/tbody/tr[1]")
	WebElement tableSizeXpath;

	@FindBy(xpath = "//*[@id=\"smartAlertButtons\"]/div[1]")
	WebElement yesElement;

	public ModulePage() {
		PageFactory.initElements(driver, this);

	}

	public String verifyModulePage() {

		return moduleLevel.getText();

	}

	public void enableDisable(String srno, String module, String action) {
		int size = driver.findElements(By.xpath("//*[@id='content']/div[2]/div[2]/table/tbody/tr")).size();
		System.out.println(size);

		for (int i = 1; i <= size; i++) {
			String moduleUi = driver
					.findElement(By.xpath("//*[@id='content']/div[2]/div[2]/table/tbody/tr[" + i + "]/td[2]"))
					.getText();

			if (module.equalsIgnoreCase(moduleUi)) {
				String actionUi = driver
						.findElement(
								By.xpath("//*[@id='content']/div[2]/div[2]/table/tbody/tr[" + i + "]/td[3]/button"))
						.getText();
				if (action.equalsIgnoreCase(actionUi)) {
					// do nothing
				} else {
					driver.findElement(
							By.xpath("//*[@id='content']/div[2]/div[2]/table/tbody/tr[" + i + "]/td[3]/button"))
							.click();
					yesElement.click();
				}
			}
		}

	}

}
