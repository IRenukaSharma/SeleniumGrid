package org.automation.helpers.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTableHelper {

	public static int getRowCountOfTable(final By elementLocator) {
		List<WebElement> rowList = WebElementFinder.GetElements(elementLocator);
		return rowList.size();
	}

	public static String getRowText(final By elementLocator, int index) {
		List<WebElement> rowList = WebElementFinder.GetElements(elementLocator);
		return rowList.get(index).getText();
	}

	public static List<WebElement> getWebTableRows(final By elementLocator, int index) {
		List<WebElement> rowList = WebElementFinder.GetElements(elementLocator);
		return rowList;
	}

}
