package org.automation.helpers.selenium;

import org.openqa.selenium.WebElement;

public class JavaScriptHelper {

	private final int DEFAULT_TIMEOUT_IN_SECS = 30;

	public static void pageScrollDown() {
		WebDriverHelper._jsExecutor.executeScript("window.scrollBy(0,250)", "");
	}

	public static String getElemenTextUsingJavaScript(WebElement element) {
		return WebDriverHelper._jsExecutor.executeScript("return arguments[0].value;", element).toString();
	}

	public static void clickOnLinkUsingJavaScript(WebElement element) {
		WebDriverHelper._jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void waitForAjaxRequestToBeCompleted() throws InterruptedException {
		int timeout = DEFAULT_TIMEOUT_IN_SECS;
		while (timeout > 0) {
			boolean ajaxToBeCompleted = (boolean) WebDriverHelper._jsExecutor
					.executeScript("return jQuery.active == 0");
			if (ajaxToBeCompleted)
				break;
			Thread.sleep(1000);
			timeout = timeout - 1;
		}
	}

}
