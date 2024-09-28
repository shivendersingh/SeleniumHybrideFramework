package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencarts.utils.Constants;
import com.qa.opencarts.utils.ErrorUtil;
import com.qa.opencarts.utils.Excelutil;

public class RegistrationPageTest extends BaseTest{

	@BeforeClass
	public void setupRegister() {
		AccpuntRegistrationPage=  loginpage.navigationToregistrationpage();
	}
	//dataprovider use to catch the data from excel java util
	@DataProvider
	public Object[][] getregisterData(){
		Object[][] data=  Excelutil.getTestData(Constants.REGISTRATION_SHEET_NAME);
		return data;	
	}
	public String getRandomnumber() {
		Random randomGenerator = new Random();
		String email = "Automation"+randomGenerator.nextInt(1000)+"@gmail.com";
		return email;
	}
	@Test(dataProvider = "getregisterData")
	public void userRegistrationTest(String firstname, String lastname, String telephone, String password,
			String subscribe) {
		Assert.assertTrue(AccpuntRegistrationPage.accountRegistration(firstname, lastname, getRandomnumber(), telephone, password, subscribe),
				ErrorUtil.REGISTERATION_FAIL_MESSAGE);
	}
}
