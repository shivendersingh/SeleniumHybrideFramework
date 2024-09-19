package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencarts.utils.ElementUtil;

public class productInfoPage {
	private WebDriver driver;
	private ElementUtil elementutil;

	public productInfoPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(this.driver);
	}
	private By ProductHeader = By.cssSelector("div#content h1");
	private By prodcutimg = By.cssSelector("ul.thumbnails img");
	private By ProductMetaData=By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By ProductPricedata = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	private By quantity = By.cssSelector("input#input-quantity");
	private By addcart = By.cssSelector("button#button-cart");
	private By successMessage = By.cssSelector("div.alert.alert-success.alert-dismissible");
	
	
	public String getproductheaderText() {
		return driver.findElement(ProductHeader).getText();
	}
	public Map<String, String> getproductInformation() {
		Map<String, String> productInfoMap = new HashMap<String, String>();
		productInfoMap.put("name", getproductheaderText());
		List<WebElement> productMetadatlist=elementutil.getelements(ProductMetaData);
		System.out.println("total product metadata"+productMetadatlist.size());
		for (WebElement e : productMetadatlist) {
			String meta[]=e.getText().split(":");
			String MetaKey = meta[0].trim();
			String Metavalue = meta[1].trim();
			productInfoMap.put(MetaKey, Metavalue);	
		}
		//price
		List<WebElement> productpricetlist=elementutil.getelements(ProductPricedata);
		productInfoMap.put("price", productpricetlist.get(0).getText().trim());
		productInfoMap.put("extrataxPrice", productpricetlist.get(1).getText().split(":")[1].trim());
		
		return productInfoMap;
	}
	
	
	
	
}
