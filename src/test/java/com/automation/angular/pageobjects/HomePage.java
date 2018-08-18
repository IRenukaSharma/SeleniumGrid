package com.automation.angular.pageobjects;

import java.util.List;

import org.automation.helpers.selenium.NgBy;
import org.automation.helpers.selenium.WebElementFinder;
import org.openqa.selenium.WebElement;

public class HomePage {

	private List<WebElement> RowList() {
		return WebElementFinder.GetElements(NgBy.Repeater("row in rowCollection"));
	}

	public int GetRowCount() {
		return RowList().size();
	}

	public void PrintRowText() {
		for (WebElement element : RowList()) {
			System.out.println(element.getText());
		}
	}
}
