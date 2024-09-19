package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencarts.utils.ElementUtil;

public class AccountPage {
	private WebDriver driver;
	private ElementUtil elementutil;
	
	private By Accheaders = By.cssSelector("#content h2");
	private By searchfield = By.name("search");
	private By searchbutton = By.cssSelector("button[class='btn btn-default btn-lg']");
	//private By logo = By.cssSelector("#logo");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
	}

	public String getAccountpagetitle() {
		return elementutil.title(driver);
	}
	public int getAccountPageHeaderscount() {
		return driver.findElements(Accheaders).size();
	}
	
	public List<String> getAccountPageheaderslist() {
		List<WebElement> acclist =driver.findElements(Accheaders);
		List<String>accsectionlist = new ArrayList<String>();
		for (WebElement e:acclist) {
			accsectionlist.add(e.getText());
		}
		return accsectionlist;
	}
	
	public SearchResultPage dosearch(String Productname) {
		elementutil.sendkey(searchfield, Productname);
		elementutil.click(searchbutton);
		return new SearchResultPage(driver);
	}


}
