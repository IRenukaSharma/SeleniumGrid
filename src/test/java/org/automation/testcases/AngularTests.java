package org.automation.testcases;

import org.testng.annotations.Test;

import com.automation.angular.pageobjects.AngularApp;

public class AngularTests extends TestBase {

	@Test(enabled = true)
	public void AngularApplicationTest() {
		// Create an object of Application
		AngularApp app = new AngularApp();
		// Navigate To Application page
		app.NavigateToApplication();
		app.BankLogin().ClickOnCustomerLoginButton();
		app.BankLogin().SelectCustomerName("Hermoine Granger");

	}

}
