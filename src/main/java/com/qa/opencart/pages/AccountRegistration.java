package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencarts.utils.Constants;
import com.qa.opencarts.utils.ElementUtil;

public class AccountRegistration {
	private WebDriver driver;
	private ElementUtil elementutil;

	private By FirstName = By.xpath("//*[@id='input-firstname']");
	private By LastName = By.xpath("//input[@id='input-lastname']");
	private By Email = By.xpath("//input[@id='input-email']");
	private By Telephone = By.xpath("//input[@id='input-telephone']");
	private By Password = By.xpath("//input[@id='input-password']");
	private By ConfirmPassword = By.xpath("//input[@id='input-confirm']");
	private By Subsyes = By.xpath("//label[normalize-space()='Yes']//input[@value='1']");
	private By subsno = By.xpath("//label[normalize-space()='No']//input[@value='0']");
	private By PP = By.xpath("(//input[@value='1'])[3]");
	private By ContinueButton = By.xpath("//input[@value='Continue']");
	private By Successmessage = By.cssSelector("div#content h1");
	private By logout = By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']");
	private By registerlink = By.linkText("Register");

	public AccountRegistration(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
	}

	public boolean accountRegistration(String firstname, String lastname, String email, String telephone, String password,
			String subscribe) {
		
		elementutil.sendkey(FirstName, firstname);
		elementutil.sendkey(LastName, lastname);
		elementutil.sendkey(Email, email);
		elementutil.sendkey(Telephone, telephone);
		elementutil.sendkey(Password, password);
		elementutil.sendkey(ConfirmPassword, password);
		if (subscribe.equals("yes")) {
			driver.findElement(Subsyes).click();
		} else {
			driver.findElement(subsno).click();
		}
		driver.findElement(PP).click();
		driver.findElement(ContinueButton).click();
		System.out.println(driver.findElement(Successmessage).getText());
		if (driver.findElement(Successmessage).getText().contains(Constants.Account_CREATION_SUCESS_MESSAGE)) {
			driver.findElement(logout).click();
			driver.findElement(registerlink).click();
			return true;
		}else {
			return false;
		}
	}
}
