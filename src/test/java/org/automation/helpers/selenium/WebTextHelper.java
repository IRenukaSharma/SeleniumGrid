package org.automation.helpers.selenium;

import org.openqa.selenium.WebElement;

public class WebTextHelper {

	public static void setText(WebElement element, String text){
		try {
			element.sendKeys(text);
		} catch (Exception ex) {
			System.out.println("Exception caught in setText(WebElement element, String text)");
			throw ex;
		}
	}

	public static void clearText(WebElement element) {
		try {
			element.clear();
		} catch (Exception ex) {
			System.out.println("Exception caught in setText(WebElement element, String text)");
			throw ex;
		}
	}
	
	

}
