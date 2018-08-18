package com.automation.angular.pageobjects;

import org.automation.helpers.selenium.WebDriverHelper;
import org.automation.protractor.NgWebDriver;

public class AngularApp {

	private static HomePage homePage;
	private static BankLoginPage bankLogin;
	// private final static String appURL =
	// "http://www.globalsqa.com/angularJs-protractor/WebTable/";
	private final static String appURL = "http://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

	public void NavigateToApplication() {
		WebDriverHelper.navigateToApplication(appURL);
		NgWebDriver.WaitForAngular();
	}

	public HomePage HomePage() {

		return homePage = (homePage == null) ? new HomePage() : homePage;
	}

	public BankLoginPage BankLogin() {

		return bankLogin = (bankLogin == null) ? new BankLoginPage() : bankLogin;
	}
}
