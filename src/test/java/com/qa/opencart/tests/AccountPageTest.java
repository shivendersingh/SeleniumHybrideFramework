package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencarts.utils.Constants;
import com.qa.opencarts.utils.ErrorUtil;

public class AccountPageTest extends BaseTest {
	@BeforeClass
	public void Accsetup(){
		accpage = loginpage.dologin(prop.getProperty("Username"), prop.getProperty("Password"));
		
	}
	
	@Test(priority = 1)
	public void accPagetitletest() {
		String title= accpage.getAccountpagetitle();
		System.out.println("Account page title is:- " + title);
		Assert.assertEquals(title, Constants.Account_PAGE_TITLE);
	}
    @Test(priority = 2)
    public void accPageSectionCounttest() {
    	Assert.assertEquals(accpage.getAccountPageHeaderscount(), Constants.ACC_PAGE_SECTION_COUNT, ErrorUtil.ACC_PAGESECTION_COUNTTEST);    	
    }
    @Test(priority = 3)
    public void accPageSectionTest() {
    	List<String> actualAccsectionlist=accpage.getAccountPageheaderslist();
    	System.out.println(actualAccsectionlist);
    	Assert.assertEquals(actualAccsectionlist, Constants.expectedSectionlist());
    }
    @Test(priority = 4)
    public void searchTest() {
    	searchResultpage=accpage.dosearch("macbook");
    	Assert.assertTrue(searchResultpage.getProductCount()>0,ErrorUtil.GET_PRODUCT_COUNT);
    }
    @Test(priority = 5)
    public void selectProductTest() {
    	searchResultpage=accpage.dosearch("macbook");
    	searchResultpage.SelectProductFromResults("MacBook Pro");
    }
    
}
