package org.automation.helpers.selenium;

import org.automation.protractor.NgByButtonText;
import org.automation.protractor.NgByModel;
import org.automation.protractor.NgByRepeater;
import org.openqa.selenium.By;

public class NgBy {

	public static By Model(String value) {
		return new NgByModel(value);
	}

	public static By Repeater(String value) {
		return new NgByRepeater(value);
	}
	
	public static By ButtonText(String value) {
		return new NgByButtonText(value);
	}
}
