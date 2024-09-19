package com.qa.opencarts.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String LOGIN_PAGE_TITLE="Account Login";
	public static final String Account_PAGE_TITLE="My Account";
	public static final int ACC_PAGE_SECTION_COUNT= 5;
	
	public static List<String> expectedSectionlist(){
		List<String>explist = new ArrayList<String>();
		explist.add("My Account");
		explist.add("My Orders");
		explist.add("My Affiliate Account");
		explist.add("Newsletter");
		return explist;
	}
	
}
