package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencarts.utils.ElementUtil;
//import com.qa.opencart.base.BaseTest;

//Encapsulation
public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementutil;
//Page Objects private
	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginbutton = By.xpath("//input[@value='Login']");
	private By forgotpwd = By.xpath("//div[@class='form-group']//a[normalize-space()='Forgotten Password']");

//Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
	}

//pageactions
	public String getloginpagetitle() {
		return elementutil.title(driver);
		
	}

	public boolean isforgotpwdLinkexist() {
		return driver.findElement(forgotpwd).isDisplayed();
	}

	public AccountPage dologin(String un, String Pwd) {
		elementutil.sendkey(username, un);
		elementutil.sendkey(password, Pwd);
		elementutil.click(loginbutton);
		return new AccountPage(driver);
	

	}
}
