package org.automation.helpers.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElementHelper {

	private static Select select;

	public static String getAttributeValue(WebElement element, String attributeType) {
		try {
			return element.getAttribute(attributeType);
		} catch (Exception ex) {
			System.err.println(
					"Error occured at getAttributeValue(WebElement element, String attributeType): Error- " + ex);
			return null;
		}
	}

	public static String getElementText(WebElement element) {
		try {
			return element.getText().trim();
		} catch (Exception ex) {
			System.err.println("Error occured at getElementText(WebElement element): Error- " + ex);
			return null;
		}
	}

	public String getCSSPropertyValue(WebElement element, String cssProperty) {
		try {
			return element.getCssValue(cssProperty);
		} catch (Exception ex) {
			System.err.println(
					"Error occured at getCSSPropertyValue(WebElement element, String cssProperty): Error- " + ex);
			return null;
		}
	}

	public static void selectByValue(WebElement selectElement, String value) {
		try {
			select = new Select(selectElement);
			select.selectByValue(value);
		} catch (Exception ex) {
			System.err.println("Error occured at selectByValue(WebElement selectElement, String value). Error-" + ex);
			throw ex;
		}
	}

	public static void selectByIndex(WebElement selectElement, int index) {
		try {
			select = new Select(selectElement);
			select.selectByIndex(index);
		} catch (Exception ex) {
			System.err.println("Error occured at selectByIndex(WebElement selectElement, String value). Error-" + ex);
			throw ex;
		}
	}

	public static void selectByVisibleText(WebElement selectElement, String visibleText) {
		try {
			select = new Select(selectElement);
			select.selectByVisibleText(visibleText);
		} catch (Exception ex) {
			System.err.println("Error occured at selectByIndex(WebElement selectElement, String value). Error-" + ex);
			throw ex;
		}
	}

	public static boolean isElementPresent(By elementLocator) {
		if (WebElementFinder.GetElements(elementLocator).size() > 0)
			return true;
		else
			return false;
	}

}
