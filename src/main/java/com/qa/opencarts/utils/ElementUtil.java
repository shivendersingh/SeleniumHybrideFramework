package com.qa.opencarts.utils;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	public  WebDriver driver;
	public  Actions act ;
	// paramatrized constructor
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		this.act = new Actions(driver);
	}

	/**
	 * This method will quite the bowser
	 * 
	 * @param driver
	 */
	public  void quitthebrowser() {
		hardcorewait(100);
		driver.quit();
		System.out.println("your browser is close..." + driver);
	}

	/**
	 * 
	 * @param driver
	 * @param url
	 */
	public  void luanchtheurl(String url) {
		System.out.println("your browser is launch...");
		driver.get(url);
	}

	/**
	 * 
	 * @param driver
	 * @param url
	 */
	public  void luanchtheurlandverifyitstitle(WebDriver driver, String url, String expectedvalue) {
		System.out.println("your browser is launch...");
		driver.get(url);
		verifythetitleoftheprovidedpage(driver, expectedvalue);

	}

	/**
	 * verifythetitleoftheprovidedpage
	 * 
	 * @param driver
	 * @param expectedvalue
	 */
	public  void verifythetitleoftheprovidedpage(WebDriver driver, String expectedvalue) {
		if (title(driver).contains(expectedvalue)) {
			System.out.println("title has been verified.....");
		} else {
			System.out.println("title has been not verified.....");
		}
	}

	/**
	 * 
	 * @param driver
	 */
	public  String title(WebDriver driver) {
		System.out.println("your title is ..." + driver.getTitle());
		return driver.getTitle();
	}

//	/**
//	 * findelements
//	 */
//	public static void findelements(WebDriver driver) {
//		List<WebElement> listofwebelemts = driver.findElements(By.tagName("a"));
//	}
//
//	/**
//	 * getallthelinksofthecurrentpage
//	 * 
//	 * @param title
//	 */
//	public static void getallthelinksofthecurrentpage(WebDriver driver,List list) {
//
//		System.out.println(driver.findElements(By.tagName("a")).size());
//		for (WebElement webElement : listofwebelemts) {
//			System.out.println(webElement.getAttribute("href"));
//		}
//
//	}
	/**
	 * entertextwithlocators
	 * 
	 * @param driver
	 * @param path
	 * @param Enteryourinputfield
	 */
	public static void entertextwithlocators(WebDriver driver, String inputvalue, String Enteryourinputfield,
			String enterthelocator) {

		switch (enterthelocator.toLowerCase()) {
		case "id":
			isEnabled(driver, inputvalue, enterthelocator);
			id(driver, inputvalue).sendKeys(Enteryourinputfield);
			hardcorewait(100);
			break;
		case "classname":
			isEnabled(driver, inputvalue, enterthelocator);
			classname(driver, inputvalue).sendKeys(Enteryourinputfield);
			hardcorewait(100);
			break;

		case "name":
			isEnabled(driver, inputvalue, enterthelocator);
			name(driver, inputvalue).sendKeys(Enteryourinputfield);
			hardcorewait(100);
			break;
		case "tagname":
			isEnabled(driver, inputvalue, enterthelocator);
			tagname(driver, inputvalue).sendKeys(Enteryourinputfield);
			hardcorewait(100);
			break;
		case "linktext":
			isEnabled(driver, inputvalue, enterthelocator);
			linktext(driver, inputvalue).sendKeys(Enteryourinputfield);
			hardcorewait(100);
			break;
		case "partiallinktext":
			isEnabled(driver, inputvalue, enterthelocator);
			partiallinktext(driver, inputvalue).sendKeys(Enteryourinputfield);
			hardcorewait(100);
			break;
		default:
			System.err.println(enterthelocator + "  locators is invalid.....");
			break;
		}

	}

	/**
	 * cleartextwithlocators
	 * 
	 * @param driver
	 * @param inputvalue
	 * @param Enteryourinputfield
	 * @param enterthelocator
	 */
	public static void cleartextwithlocators(WebDriver driver, String inputvalue, String enterthelocator) {

		switch (enterthelocator.toLowerCase()) {
		case "id":
			id(driver, inputvalue).clear();
			hardcorewait(100);
			break;
		case "classname":
			classname(driver, inputvalue).clear();
			hardcorewait(100);
			break;

		case "name":
			name(driver, inputvalue).clear();
			hardcorewait(100);
			break;
		case "tagname":
			isEnabled(driver, inputvalue, enterthelocator);
			tagname(driver, inputvalue).clear();
			hardcorewait(100);
			break;
		case "linktext":
			isEnabled(driver, inputvalue, enterthelocator);
			linktext(driver, inputvalue).clear();
			hardcorewait(100);
			break;
		case "partiallinktext":
			isEnabled(driver, inputvalue, enterthelocator);
			partiallinktext(driver, inputvalue).clear();
			hardcorewait(100);
			break;
		default:
			System.err.println(enterthelocator + "  locators is invalid.....");
			break;
		}

	}

	/**
	 * clicktextwithlocators
	 * 
	 * @param driver
	 * @param inputvalue
	 * @param Enteryourinputfield
	 * @param enterthelocator
	 */
	public static void clicktextwithlocators(WebDriver driver, String inputvalue, String enterthelocator) {

		switch (enterthelocator.toLowerCase()) {
		case "id":
			isEnabled(driver, inputvalue, enterthelocator);
			id(driver, inputvalue).click();
			hardcorewait(100);
			break;
		case "classname":
			isEnabled(driver, inputvalue, enterthelocator);
			classname(driver, inputvalue).click();
			hardcorewait(100);
			break;

		case "name":
			isEnabled(driver, inputvalue, enterthelocator);
			name(driver, inputvalue).click();
			hardcorewait(100);
			break;
		case "tagname":
			isEnabled(driver, inputvalue, enterthelocator);
			tagname(driver, inputvalue).click();
			hardcorewait(100);
			break;
		case "linktext":
			isEnabled(driver, inputvalue, enterthelocator);
			linktext(driver, inputvalue).click();
			hardcorewait(100);
			break;
		case "partiallinktext":
			isEnabled(driver, inputvalue, enterthelocator);
			partiallinktext(driver, inputvalue).click();
			hardcorewait(100);
			break;
		default:
			System.err.println(enterthelocator + "  locators is invalid.....");
			break;
		}

	}

	/**
	 * 
	 * @param enteryourwaititme
	 */
	public static void hardcorewait(int enteryourwaititme) {
		try {
			Thread.sleep(enteryourwaititme);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param driver
	 * @param path
	 */
	public static void clickanelemtwithbasicxpath(WebDriver driver, String tagname, String attributename,
			String value) {
		basicxpath(driver, tagname, attributename, value, 10).click();
		System.out.println("element is clicked>>>>>>");
		// System.out.println(driver.findElement(By.xpath(path)).getText() + elementname
		// + " " + isSelected(driver, path));
	}

	/**
	 * 
	 * @param driver
	 * @param tagname
	 * @param attributename
	 * @param value
	 */
	public static void enteranelemtwithbasicxpath(WebDriver driver, String tagname, String attributename, String value,
			String enteryourvalue, int time) {
		// basicxpath(driver, tagname, attributename,value,
		// time).sendKeys(enteryourvalue);
		xpathwithstartwith(driver, tagname, attributename, value, time).sendKeys(enteryourvalue);
	}

	/**
	 * enteranelemtwithorandxpath
	 * 
	 * @param driver
	 * @param tagname
	 * @param attribute1
	 * @param value1
	 * @param entertheamounttowait
	 * @param andor
	 * @param attribute2
	 * @param value2
	 * @param enteryourvalue
	 */
	public static void enteranelemtwithorandxpath(WebDriver driver, String tagname, String attribute1, String value1,
			int entertheamounttowait, String andor, String attribute2, String value2, String enteryourvalue) {
		xpathusingOrand(driver, tagname, attribute1, value1, entertheamounttowait, andor, attribute2, value2)
				.sendKeys(enteryourvalue);
	}

	/**
	 * clickanelemtwithtext
	 * 
	 * @param driver
	 * @param tagname
	 * @param value
	 * @param entertheamounttowait
	 * @param enteryourvalue
	 */
	public static void clickanelemtwithtext(WebDriver driver, String tagname, String value, int entertheamounttowait) {
		xpathusingtextmethod(driver, tagname, value, entertheamounttowait).click();
	}

	/**
	 * 
	 * iselementdisplay
	 * 
	 * @param driver
	 * @param path
	 */
	public static void iselementdisplay(WebDriver driver, String path) {
		if (!driver.findElement(By.xpath(path)).isDisplayed()) {
			System.out.println("element is not display");
		} else {
			System.out.println("element is display");
		}
	}

	/**
	 * isEnabled
	 * 
	 * @param driver
	 * @param path
	 */
	public static void isEnabled(WebDriver driver, String path, String enterthelocator) {
		switch (enterthelocator.toLowerCase()) {
		case "id":
			System.out.println(id(driver, path).isEnabled());
			if (!id(driver, path).isEnabled()) {
				System.out.println("element is not isEnabled");
			} else {
				System.out.println("element is isEnabled");
			}
			break;
		case "classname":
			System.out.println(classname(driver, path).isEnabled());
			if (!classname(driver, path).isEnabled()) {
				System.out.println("element is not isEnabled");
			} else {
				System.out.println("element is isEnabled");
			}
			break;

		case "name":
			System.out.println(name(driver, path).isEnabled());
			if (!name(driver, path).isEnabled()) {
				System.out.println("element is not isEnabled");
			} else {
				System.out.println("element is isEnabled");
			}
			break;
		case "tagname":
			System.out.println(tagname(driver, path).isEnabled());
			if (!tagname(driver, path).isEnabled()) {
				System.out.println("element is not isEnabled");
			} else {
				System.out.println("element is isEnabled");
			}
			break;
		case "linktext":
			System.out.println(linktext(driver, path).isEnabled());
			if (!linktext(driver, path).isEnabled()) {
				System.out.println("element is not isEnabled");
			} else {
				System.out.println("element is isEnabled");
			}
			break;
		case "partiallinktext":
			System.out.println(partiallinktext(driver, path).isEnabled());
			if (!partiallinktext(driver, path).isEnabled()) {
				System.out.println("element is not isEnabled");
			} else {
				System.out.println("element is isEnabled");
			}
			break;
		default:
			System.err.println(enterthelocator + "  locators is invalid.....");
			break;
		}

	}

	/**
	 * isSelected
	 * 
	 * @param driver
	 * @param path
	 */
	public static String isSelected(WebDriver driver, String path) {
		System.out.println(driver.findElement(By.xpath(path)).isSelected());// false
		if (driver.findElement(By.xpath(path)).isSelected()) {
			return "element is isnotSelected";
		} else {
			return "element is isSelected";
		}

	}

	/**
	 * gobackgoforward and verifytheretitle
	 * 
	 * @param driver
	 * @param userinput
	 * @param title
	 */
	public  void gobackgoforward(WebDriver driver, String userinput, String title, String URL) {
		if (userinput.contains("back") && "NA".contains(URL)) {
			driver.navigate().back();
			driver.navigate().refresh();
			System.out.println("page is been refershed>>>");
			verifythetitleoftheprovidedpage(driver, title);
		} else if (userinput.contains("NA") && URL.contains(URL)) {
			verifythetitleoftheprovidedpage(driver, title);
			driver.navigate().to(URL);
		} else {
			driver.navigate().forward();
			driver.navigate().refresh();
			System.out.println("page is been refershed>>>");
			verifythetitleoftheprovidedpage(driver, title);
		}
	}

	/**
	 * 
	 * @param driver
	 * @param enterthetimeamount
	 */
	@SuppressWarnings("deprecation")
	public static void implicitwait(WebDriver driver, int enterthetimeamount) {
		driver.manage().timeouts().implicitlyWait(enterthetimeamount, TimeUnit.SECONDS);
	}

	/**
	 * 
	 * @param driver
	 * @param i
	 * @param by
	 */
	public static void explictwait(WebDriver driver, int entertheamountvalue, String enterthexpathvalue) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(entertheamountvalue));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(enterthexpathvalue))));

	}

	/**
	 * locators utils selenium driven locator
	 * 
	 */
	/**
	 * 
	 * @param driver
	 * @param id
	 * @return
	 */
	public static WebElement id(WebDriver driver, String id) {
		return driver.findElement(By.id(id));
	}

	/**
	 * 
	 * @param driver
	 * @param classname
	 * @return
	 */
	public static WebElement classname(WebDriver driver, String classname) {
		return driver.findElement(By.className(classname));
	}

	/**
	 * 
	 * @param driver
	 * @param name
	 * @return
	 */
	public static WebElement name(WebDriver driver, String name) {
		return driver.findElement(By.name(name));
	}

	/**
	 * 
	 * @param driver
	 * @param name
	 * @return
	 */
	public static WebElement tagname(WebDriver driver, String name) {
		return driver.findElement(By.tagName(name));
	}

	/**
	 * 
	 * @param driver
	 * @param name
	 * @return
	 */
	public static WebElement linktext(WebDriver driver, String name) {
		return driver.findElement(By.linkText(name));
	}

	/**
	 * 
	 * @param driver
	 * @param name
	 * @return
	 */
	public static WebElement partiallinktext(WebDriver driver, String name) {
		return driver.findElement(By.partialLinkText(name));
	}

//==========================================XPATH=========================================
	/**
	 * user define xpath locator 1) Absolute xpath (/) 2) relative xpath (//)
	 * 
	 * // : Select current node. Tagname: Tagname of the particular node. @: Select
	 * attribute. Attribute: Attribute name of the node. Value: Value of the
	 * attribute.
	 * 
	 * 
	 */

	public static WebElement basicxpath(WebDriver driver, String tagname, String attribute, String value,
			int entertheamounttowait) {
		explictwait(driver, entertheamounttowait, "//" + tagname + "[@" + attribute + "=" + "'" + value + "'" + "]");
		return driver.findElement(By.xpath("//" + tagname + "[@" + attribute + "=" + "'" + value + "'" + "]"));
	}

	/**
	 * 
	 * //*[contains(@class,'gLFyf')]
	 * 
	 * @return
	 */
	public static WebElement xpathusingconstains(WebDriver driver, String tagname, String attribute, String value,
			int entertheamounttowait) {
		explictwait(driver, entertheamounttowait,
				"//" + tagname + "[contains(@" + attribute + "," + "'" + value + "'" + ")]");
		return driver
				.findElement(By.xpath("//" + tagname + "[contains(@" + attribute + "," + "'" + value + "'" + ")]"));

	}

	/**
	 * xpathusingOrand
	 * 
	 * @param driver
	 * @param tagname
	 * @param attribute
	 * @param value
	 * @param entertheamounttowait
	 * @return Xpath=//input[@type='submit' and @name='btnLogin']
	 */
	public static WebElement xpathusingOrand(WebDriver driver, String tagname, String attribute1, String value1,
			int entertheamounttowait, String andor, String attribute2, String value2) {
		explictwait(driver, entertheamounttowait, "//" + tagname + "[@" + attribute1 + "=" + "'" + value1 + "'" + andor
				+ "@" + attribute2 + "=" + "'" + value2 + "'" + "]");
		System.out.println(driver.findElement(By.xpath("//" + tagname + "[@" + attribute1 + "=" + "'" + value1 + "'"
				+ andor + "@" + attribute2 + "=" + "'" + value2 + "'" + "]")));
		return driver.findElement(By.xpath("//" + tagname + "[@" + attribute1 + "=" + "'" + value1 + "'" + andor + "@"
				+ attribute2 + "=" + "'" + value2 + "'" + "]"));

	}

	// textarea[starts-with(@class,'gLFyf') ]
	/**
	 * xpathwithstartwith
	 * 
	 * @param driver
	 * @param tagname
	 * @param attribute
	 * @param value
	 * @param entertheamounttowait
	 * @return
	 */
	public static WebElement xpathwithstartwith(WebDriver driver, String tagname, String attribute, String value,
			int entertheamounttowait) {
		explictwait(driver, entertheamounttowait,
				"//" + tagname + "[starts-with(@" + attribute + "," + "'" + value + "'" + ")]");
		System.out.println(driver
				.findElement(By.xpath("//" + tagname + "[starts-with(@" + attribute + "," + "'" + value + "'" + ")]")));
		return driver
				.findElement(By.xpath("//" + tagname + "[starts-with(@" + attribute + "," + "'" + value + "'" + ")]"));

	}

	/**
	 * return
	 * 
	 * @param driver
	 * @param tagname
	 * @param value
	 * @param entertheamounttowait
	 * @return
	 */
	public static WebElement xpathusingtextmethod(WebDriver driver, String tagname, String value,
			int entertheamounttowait) {
		explictwait(driver, entertheamounttowait, "//" + tagname + "[text()='" + value + "'" + "]");
		System.out.println(driver.findElement(By.xpath("//" + tagname + "[text()='" + value + "'" + "]")));
		return driver.findElement(By.xpath("//" + tagname + "[text()='" + value + "']"));

	}

	/**
	 * datepicker
	 * 
	 * @param driver
	 * @param locator
	 * @param dateneedtobepass
	 */
	static public void datepicker(WebDriver driver, By locator, String dateneedtobepass) {
		boolean flag = false;
		List<WebElement> listofdates = driver.findElements(locator);
		System.out.println(listofdates.size());
		for (WebElement webElement : listofdates) {
			if (webElement.getText().equals(dateneedtobepass)) {
				webElement.click();
				flag = true;
				break;
			}

		}
		if (!flag) {

			System.err.println("wrong date picked...." + dateneedtobepass);

		}

	}

		public  void domovetoelement(WebDriver driver, By locator) {
			act.moveToElement(driver.findElement(locator)).perform();
		}
		public  void domovetoelement(WebDriver driver, By locator, By locator2) {
			act.moveToElement(driver.findElement(locator)).moveToElement(driver.findElement(locator2)).build().perform();
		}
		
		/**
		 * 
		 * @param locator
		 * @param Enteryourstring
		 */
		public void sendkey(By locator, String Enteryourstring) {
			driver.findElement(locator).sendKeys(Enteryourstring);
		}
		
		public void click(By locator) {
			driver.findElement(locator).click();
		}
		
		public List<WebElement> getelements(By locator) {
			return driver.findElements(locator);
		}

}
