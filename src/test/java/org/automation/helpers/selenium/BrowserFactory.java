package org.automation.helpers.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory extends WebDriverHelper {

	// Browser Names
	public static enum Browser {
		Chrome, IE, Firefox
	}

	// Initialize and get an instance of WebDriver
	// No Parameter as we are getting browser name from enum Browser
	// return type is WebDriver
	public static WebDriver getBrowser(Browser browserName) {

		switch (browserName) {
		case Chrome:
			System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
			_driver = new ChromeDriver();
			break;

		case IE:
			_driver = new InternetExplorerDriver();
			break;
		case Firefox:
			_driver = new FirefoxDriver();
			break;
		default:
			_driver = null;
			break;

		}
		_driver.manage().window().maximize();
		_driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		intializeWebDriverSupports();
		return _driver;
	}

	public static void closeBrowser() {
		_driver.close();
	}

}
