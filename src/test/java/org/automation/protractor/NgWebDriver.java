package org.automation.protractor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class NgWebDriver {

	public NgWebDriver(WebDriver driver, String rootElement) {
		NgWebDriver.driver = driver;
		NgWebDriver.rootElement = rootElement;
		jsExecutor = (JavascriptExecutor) driver;
	}

	private static JavascriptExecutor jsExecutor;
	private static WebDriver driver;
	private static String rootElement;

	public static void WaitForAngular() {

		if (driver == null) {
			throw new NullPointerException("WebDriver instance must be set before use");
		}
		if (!(driver instanceof JavascriptExecutor)) {
			throw new UnsupportedOperationException("WebDriver must implement the Javascript interface");
		}
		ExecuteAsyncScript(ClientSideScripts.WaitForAngular, rootElement);
	}

	private static Object ExecuteAsyncScript(String script, Object... args) {
		return jsExecutor.executeAsyncScript(script, args);
	}
}
