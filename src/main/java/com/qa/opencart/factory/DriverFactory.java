package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.opencart.wbedriverfactory.WebDriverFactory;

public class DriverFactory {
	WebDriver driver;
	Properties prop;
	/**
	 * here we author provide to intitate the wedriver
	 * 
	 * @param browsername
	 * @return driver
	 */
	public WebDriver init_driver(Properties prop) {
		
		String browsername= prop.getProperty("browsername");  
		System.out.println("browser name is: " + browsername);
		driver = WebDriverFactory.getDriver();
		
		if (browsername.equalsIgnoreCase("chrome")) {
			driver = WebDriverFactory.getDriver();
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("browser is not found...please pass the correct browser name" + browsername);
		}
		driver.manage().deleteAllCookies();

		driver.get(prop.getProperty("url"));
		//driver.manage().window().setSize(new Dimension(1532, 813));
		 driver.manage().window().fullscreen();

		return driver;
	}

	/**
	 * This Method is init the properties from properties file
	 * 
	 * @return return the properties(prop)
	 */

	public Properties init_prop() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}
}
