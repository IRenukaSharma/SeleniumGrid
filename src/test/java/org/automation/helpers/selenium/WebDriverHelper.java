package org.automation.helpers.selenium;

import java.time.Duration;

import org.automation.protractor.NgWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHelper {

	protected static WebDriver _driver;
	protected static WebDriverWait _wait;
	protected static Wait<WebDriver> _fluentWait;
	protected static JavascriptExecutor _jsExecutor;

	public static void intializeWebDriverSupports() {
		_wait = new WebDriverWait(_driver, 30);
		_jsExecutor = (JavascriptExecutor) _driver;
		_fluentWait = new FluentWait<WebDriver>(_driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
		@SuppressWarnings("unused")
		NgWebDriver ngWebDriver = new NgWebDriver(_driver, "");
		ngWebDriver = null;
	}

	public static void navigateToApplication(String appURL) {
		try {
			_driver.navigate().to(appURL);
			waitForPageLoad();
		} catch (Exception ex) {
			System.err.println("Bad URL:" + ex);
			throw ex;
		}
	}

	public static void waitForPageLoad() {
		new WebDriverWait(_driver, 30)
				.until(_driver -> _jsExecutor.executeScript("return document.readyState").equals("complete"));
	}

	public static void switchToFrame(String frameID) {
		try {
			_driver.switchTo().frame(frameID);
		} catch (Exception ex) {
			System.err.println("Frame :" + ex);
			throw ex;
		}
	}

	public static void switchToFrame(int frameIndex) {
		try {
			_driver.switchTo().frame(frameIndex);
		} catch (Exception ex) {
			System.err.println("Frame :" + ex);
			throw ex;
		}
	}

	public static void switchToDefaultFrame() {
		_driver.switchTo().defaultContent();
	}
}
