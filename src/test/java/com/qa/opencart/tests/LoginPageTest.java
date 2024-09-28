package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencarts.utils.Constants;

public class LoginPageTest extends BaseTest {
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginpage.getloginpagetitle();
		System.out.println("login page title is:- " + title);
		org.testng.Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);

	}
	
	
    @Test(priority = 2)
	public void forgotpwdlinktest() {
		Assert.assertTrue(loginpage.isforgotpwdLinkexist());
	}
	@Test(priority = 3)
	public void loginTest() {
		loginpage.dologin(prop.getProperty("Username"), prop.getProperty("Password"));
	}

}
