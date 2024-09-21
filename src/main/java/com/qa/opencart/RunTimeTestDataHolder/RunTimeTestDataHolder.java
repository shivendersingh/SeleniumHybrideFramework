package com.qa.opencart.RunTimeTestDataHolder;

import java.util.HashMap;

public class RunTimeTestDataHolder {
	private static ThreadLocal<HashMap<String, String>> testdataholder = new ThreadLocal<HashMap<String, String>>();

    public static HashMap<String, String> getDriver() {
        return testdataholder.get();
    }

    public static void setDriver(HashMap<String, String> datamap) {
        testdataholder.set(datamap);
    }
}
