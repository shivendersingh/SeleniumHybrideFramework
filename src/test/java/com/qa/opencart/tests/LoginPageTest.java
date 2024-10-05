package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencarts.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
@Epic("US:101: design the login page for demo opencart app with login, title and forgot pass and link")
@Story("US:-100:")
public class LoginPageTest extends BaseTest {
	@Description("Login page title verfication.....")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginpage.getloginpagetitle();
		System.out.println("login page title is:- " + title);
		org.testng.Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);

	}
	
	@Description("forgot password link verfication.....")
	@Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
	public void forgotpwdlinktest() {
		Assert.assertTrue(loginpage.isforgotpwdLinkexist());
	}
	@Description("user will get login.....")
	@Severity(SeverityLevel.BLOCKER)
	@Step("Logging in with username: {username} and password: {maskedPassword}")
	@Test(priority = 3)
	public void loginTest() {
		loginpage.dologin(prop.getProperty("Username"), prop.getProperty("Password"));
	}

}
