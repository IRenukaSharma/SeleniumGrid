package org.automation.pageobjects;

import org.automation.helpers.selenium.WebDriverHelper;
import org.openqa.selenium.WebDriver;

public class FacebookApp {

	protected final String PROD_URL = "http://facebook.com";
	protected static WebDriver _driver;

	// Page objects
	protected static LoginPage loginPage;

	public FacebookApp(WebDriver driver) {
		FacebookApp._driver = driver;
	}

	// Navigate to application
	public void NavigateToApplication() {
		WebDriverHelper.navigateToApplication(PROD_URL);
		System.out.println("Title:"+_driver.getTitle());
	}

	public LoginPage LoginPage() {

		return loginPage = (loginPage == null) ? new LoginPage() : loginPage;
	}
	
	public void QuitApp() {
		_driver.quit();
	}
	
	
}
