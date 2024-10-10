package com.qa.opencart.factory;

import org.openqa.selenium.WebDriver;

public class WebdriverFactory {

	private static ThreadLocal<WebDriver> webDrivers = new ThreadLocal<WebDriver>();
	synchronized public static WebDriver getDriver() {
		return webDrivers.get();
	}
	synchronized public static void setDriver(WebDriver dr) {
		webDrivers.set(dr);
	}
}
