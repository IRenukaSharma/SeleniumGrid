package org.automation.pageobjects;

import org.automation.helpers.selenium.NgBy;
import org.automation.helpers.selenium.WebButtonHelper;
import org.automation.helpers.selenium.WebElementFinder;
import org.automation.helpers.selenium.WebTextHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public LoginPage() {

	}

	// Page Elements
	protected WebElement username() {
		return WebElementFinder.GetElement(By.id("email"));
	}

	protected WebElement password() {
		return WebElementFinder.GetElement(By.id("pass"));
	}

	protected WebElement loginBtn() {
		return WebElementFinder.GetElement(By.id("u_0_2"));
	}

	protected WebElement inputTextBox() {
		return WebElementFinder.GetElement(NgBy.Model("person.name"));
	}

	public void EnterTextUsingModel(String Text) {
		WebTextHelper.setText(inputTextBox(), Text);
	}
	public void LoginWithCredentials(String username, String password) {
		WebTextHelper.setText(username(), username);
		WebTextHelper.setText(password(), password);
		WebButtonHelper.clickOnLink(loginBtn());
	}

}
