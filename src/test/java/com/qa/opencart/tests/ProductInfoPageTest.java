package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest{
	
	SoftAssert softAssert = new SoftAssert();

	@BeforeClass
	public void Accsetup(){
		accpage = loginpage.dologin(prop.getProperty("Username"), prop.getProperty("Password"));
		
	}
	@Test
	public void productInfoDataTest() {
		searchResultpage=accpage.dosearch("Macbook");
		productInfoPage = searchResultpage.SelectProductFromResults("MacBook Pro");
		Map<String, String>actproductinfoMap=productInfoPage.getproductInformation();
		softAssert.assertTrue(actproductinfoMap.get("name").equals("MacBook Pro"));
		softAssert.assertTrue(actproductinfoMap.get("Brand").equals("Apple"));
	    softAssert.assertTrue(actproductinfoMap.get("price").equals("$2,000.00"));
	    softAssert.assertAll();
	    
		
	}
}
