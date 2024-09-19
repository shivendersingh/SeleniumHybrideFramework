package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencarts.utils.ElementUtil;

public class SearchResultPage {
	private WebDriver driver;
	private ElementUtil elementutil;

	public SearchResultPage(WebDriver driver) {

		this.driver = driver;
		elementutil = new ElementUtil(this.driver);

	}
	
	By searchItemResult = By.cssSelector("div.product-layout div.product-thumb");
	By resultItems = By.cssSelector("div.product-thumb h4 a");
	
	public int getProductCount() {
		return elementutil.getelements(resultItems).size();
	}
	
	public productInfoPage SelectProductFromResults(String Productname) {
		List<WebElement> resultItemList=elementutil.getelements(resultItems);
		System.out.println("total number of items displayed for:-"+Productname+":"+
		resultItemList);
		for (WebElement e : resultItemList) {
			if (e.getText().equals(Productname)) {
				e.click();
				break;
			}
			
		}
	return new productInfoPage(driver);
	}
}
