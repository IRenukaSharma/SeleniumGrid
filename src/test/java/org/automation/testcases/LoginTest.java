package org.automation.testcases;

import org.automation.pageobjects.FacebookApp;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

	@Test
	public void LoginWithCredentials() {

		FacebookApp app = new FacebookApp(_driver);
		app.NavigateToApplication();
		
		app.LoginPage().LoginWithCredentials("blahblahblahblah@blahblahblha.com", "blahblahblah");
		app.QuitApp();
	}

}
