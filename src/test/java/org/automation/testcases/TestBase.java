package org.automation.testcases;

import org.automation.helpers.selenium.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

	protected static WebDriver _driver;

	@BeforeTest
	public void TestIntialization() {
		// Initialize WebDriver Supports and Browser
		_driver = BrowserFactory.getBrowser(BrowserFactory.Browser.Chrome);

	}

	@AfterTest
	public void Flush() {
		//BrowserFactory.closeBrowser();
	}
}
