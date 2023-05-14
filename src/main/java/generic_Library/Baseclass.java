package generic_Library;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import pom_pages.contactus;
import pom_pages.java_selenium;
import pom_pages.mainpage;
import pom_pages.searchoption;
import pom_pages.searchoptionmainpage;
import pom_pages.seleniumtriningpage;
import pom_pages.skillrarydemopage;//impoert of pom package
import pom_pages.testpage;

public class Baseclass {
	// @BeforeSuite//CONNEXT THE DATA BASE CONNCETION
//	@BeforeTest//IT IS USED TO PAELLEXICUTION
	// LAUNCHING BROWSER AND NAVIGATION TO APLLICATION
	protected WebDriverUtility web;
	protected ExcelFileUtility excel;
	protected JavaUtility junit;
	protected PropertyFileUtility property;// link with property
	protected WebDriver driver;

	protected mainpage home;
	protected skillrarydemopage demoapp;
	protected seleniumtriningpage selenium;
	protected testpage testing;
	protected contactus contact;

	protected searchoptionmainpage searchhome;
	protected searchoption search;
	protected java_selenium javaselenium;

	@BeforeClass
	/**
	 * launching the browser
	 */
	public void classconfigration() {
		web = new WebDriverUtility();
		excel = new ExcelFileUtility();// ;ink with execel
		junit = new JavaUtility();
		property = new PropertyFileUtility();

		property.propertyconfg(IconstantPath.PROPERTIES_PATH);
		String browser = property.fetchproperty("browser");
		String url = property.fetchproperty("url");
		String time = property.fetchproperty("time");
		long a = Long.parseLong(time);
		driver = web.openApplication(browser, url, a);
	}

	@BeforeMethod // LOGGIN TO APLLICATION AND INTILIZATION OF POM CLASS
	public void methodconfigration() {
		excel.reintilization(IconstantPath.EXEL_PATH);
		home = new mainpage(driver);// connection to before class and method
		demoapp = new skillrarydemopage(driver);
		selenium = new seleniumtriningpage(driver);
		testing = new testpage(driver);
		contact = new contactus(driver);
		search = new searchoption(driver);
		searchhome = new searchoptionmainpage(driver);
		javaselenium = new java_selenium(driver);
		Assert.assertTrue(home.getlogo().isDisplayed());

	}

	@AfterMethod
	public void methodteardown() {
		excel.closeWorkBook();
	}

	@AfterClass
	public void closethebrowser() {
		web.quitBrowser();
	}
//	@AfterTest

// @AfterSuite

}
