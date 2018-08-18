package org.automation.helpers.selenium;

import org.openqa.selenium.WebElement;

public class WebButtonHelper {

	public static void clickOnLink(WebElement element) {
		try {
			element.click();
		} catch (Exception ex) {
			System.out.println("Exception caught in clickOnLink(WebElement element)");
			throw ex;
		}
	}

}
