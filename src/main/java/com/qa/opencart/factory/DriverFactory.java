package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
//	WebDriver driver;
	Properties prop;
	public static String highlight;
	OptionsManager optionmanager;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	/**
	 * here we author provide to intitate the wedriver
	 * 
	 * @param browsername
	 * @return driver
	 */
	public WebDriver init_driver(Properties prop) {

		String browsername = prop.getProperty("browsername");
		System.out.println("browser name is: " + browsername);
		highlight = prop.getProperty("highlight").trim();
		optionmanager = new OptionsManager(prop);
		if (browsername.equalsIgnoreCase("chrome")) {
			// driver = new ChromeDriver(optionmanager.getChromeOptions());
			tldriver.set(new ChromeDriver(optionmanager.getChromeOptions()));
		} else if (browsername.equalsIgnoreCase("firefox")) {
			// driver = new FirefoxDriver(optionmanager.getfirefoxOptions());
			tldriver.set(new FirefoxDriver(optionmanager.getfirefoxOptions()));
		} else if (browsername.equalsIgnoreCase("edge")) {
			// driver = new EdgeDriver();
			tldriver.set(new EdgeDriver());

		} else {
			System.out.println("browser is not found...please pass the correct browser name" + browsername);
		}
		getDriver().manage().deleteAllCookies();

		getDriver().get(prop.getProperty("url"));
		// driver.manage().window().setSize(new Dimension(1532, 813));
		getDriver().manage().window().fullscreen();

		return getDriver();
	}

	/**
	 * It get all the thread local action of a driver
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	/**
	 * This Method is init the properties from properties file
	 * 
	 * @return return the properties(prop)
	 */

	public Properties init_prop() {

		prop = new Properties();
		FileInputStream ip = null;
		String env = System.getProperty("env");
		if (env == null) {
			try {
				ip = new FileInputStream("./src/test/resources/config/config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		} else {

			try {
				switch (env) {
				case "qa":
					ip = new FileInputStream("./src/test/resources/config/qaconfig.properties");
					break;
				case "dev":
					ip = new FileInputStream("./src/test/resources/config/devconfig.properties");
					break;
				case "staging":
					ip = new FileInputStream("./src/test/resources/config/stagingconfig.properties");
					break;

				default:
					System.out.println("please provide the right env......");
					break;
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}
	
	/**
	 * @author shive
	 * This method capture the screenshot
	 */
	public String getScreenshot() {
		File src=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		//File srcFile= new File(src);
		
		String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+
				".png";
		File destination =new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
