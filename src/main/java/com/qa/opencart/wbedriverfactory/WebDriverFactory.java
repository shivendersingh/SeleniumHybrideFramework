package com.qa.opencart.wbedriverfactory;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

	private static ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        return webdriver.get();
    }

    public static void setDriver(WebDriver driver) {
        webdriver.set(driver);
    }
}
