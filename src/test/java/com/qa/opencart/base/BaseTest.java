package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.AccountRegistration;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.SearchResultPage;
import com.qa.opencart.pages.productInfoPage;

public class BaseTest {

	private WebDriver driver;
	DriverFactory df;
	public Properties prop;
	public LoginPage loginpage;
	public AccountPage accpage;
	public SearchResultPage searchResultpage;
	public productInfoPage productInfoPage;
	public AccountRegistration AccpuntRegistrationPage;
	
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop=df.init_prop();
		driver = df.init_driver(prop);
		loginpage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
