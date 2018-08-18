package org.automation.protractor;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

public class ProtractorBy extends By {

	private String scripts;
	private Object[] args;

	public ProtractorBy(String script, Object... args) {
		this.scripts = script;
		this.args = args;
	}

	public Object[] AdditionalScriptsArguments;

	@Override
	public List<WebElement> findElements(SearchContext context) {
		// Create Scripts arguments
		Object[] scriptArgs = this.args;
		if (this.AdditionalScriptsArguments != null && this.AdditionalScriptsArguments.length > 0) {
			// additional scripts arguments
			scriptArgs = new Object[this.args.length + this.AdditionalScriptsArguments.length];
		}
		// Get JS Executor
		JavascriptExecutor jsExecutor = (JavascriptExecutor) context;
		if (jsExecutor == null) {
			WrapsDriver wrapsDriver = (WrapsDriver) context;

			if (wrapsDriver != null) {
				jsExecutor = (JavascriptExecutor) wrapsDriver.getWrappedDriver();
			}
		}
		@SuppressWarnings("unchecked")
		List<WebElement> elements = (List<WebElement>) jsExecutor.executeScript(this.scripts, scriptArgs);
		if (elements == null) {
			elements = new ArrayList<WebElement>(new ArrayList<WebElement>(0));
		}
		return new ArrayList<WebElement>(new ArrayList<WebElement>(elements));
	}

}
