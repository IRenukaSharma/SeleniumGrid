package com.automation.angular.pageobjects;

import org.automation.helpers.selenium.NgBy;
import org.automation.helpers.selenium.WebButtonHelper;
import org.automation.helpers.selenium.WebElementFinder;
import org.automation.helpers.selenium.WebElementHelper;
import org.automation.protractor.NgWebDriver;
import org.openqa.selenium.WebElement;

public class BankLoginPage {

	protected WebElement CustomerLoginBtn() {
		return WebElementFinder.GetElement(NgBy.ButtonText("Customer Login"));
	}

	protected WebElement YourName() {
		return WebElementFinder.GetElement(NgBy.Model("custId"));
	}

	public void ClickOnCustomerLoginButton() {
		WebButtonHelper.clickOnLink(CustomerLoginBtn());
		NgWebDriver.WaitForAngular();
	}

	public void SelectCustomerName(String customerName) {
		WebElementHelper.selectByVisibleText(YourName(), customerName);
	}

}
