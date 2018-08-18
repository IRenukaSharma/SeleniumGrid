package org.automation.helpers.selenium;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementFinder extends WebDriverHelper {

	private static WebElement _element;
	private static List<WebElement> _elements;

	public static WebElement GetElement(final By elementLocator) {
		try {
			_element = _fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(elementLocator);
				}
			});
			return _element;
		} catch (Exception ex) {
			System.err.println("Error:" + ex);
			throw ex;
		}
	}

	public static List<WebElement> GetElements(final By elementLocator) {
		try {
			_elements = _fluentWait.until(new Function<WebDriver, List<WebElement>>() {
				public List<WebElement> apply(WebDriver driver) {
					return driver.findElements(elementLocator);
				}
			});
			return _elements;
		} catch (Exception ex) {
			System.err.println("Error:" + ex);
			throw ex;
		}
	}

	public static WebElement GetInnerElement(WebElement parent, By innerElement) {
		try {
			_element = _fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return parent.findElement(innerElement);
				}
			});
			return _element;
		} catch (Exception ex) {
			System.err.println("Error:" + ex);
			throw ex;
		}
	}

	public static List<WebElement> GetInnerElements( WebElement parent,By innerElement) {
		try {
			_elements = _fluentWait.until(new Function<WebDriver, List<WebElement>>() {
				public List<WebElement> apply(WebDriver driver) {
					return parent.findElements(innerElement);
				}
			});
			return _elements;
		} catch (Exception ex) {
			System.err.println("Error:" + ex);
			throw ex;
		}
	}
}
