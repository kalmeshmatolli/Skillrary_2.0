package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Library.WebDriverUtility;

public class skillrarydemopage {
	@FindBy(xpath = "//a[@class=\"navbar-brand\"]")
	private WebElement pageHeader;
	@FindBy(id = "course")
	private WebElement course;
	@FindBy(xpath = "//span[@class=\"wrappers\"]/a[text()='Selenium Training']")
	private WebElement seleniumtraning;
	@FindBy(xpath = "//select[@class='chosen-select']")
	private WebElement catagorydropdown;
	@FindBy(xpath = "//a[text()='Contact Us']")
	private WebElement contactus;

	// intilzation
	/**
	 * to element the stale elementreference exception and refer current web page
	 */
	public skillrarydemopage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * utilization
	 * 
	 * @return
	 */
	public String getpageHeader() {
		return pageHeader.getText();
	}

	public void mouseHoverTocourse(WebDriverUtility web) {// creation of obect by the combition of lose coupliing type
		web.mouseHover(course);

	}

	public void clickseleniumtraning() {

		seleniumtraning.click();
	}

	public void selectcatagorydropdown(WebDriverUtility web1, int index) {
		web1.dropDown(catagorydropdown, index);

	}
//	public WebElement getcontactus(WebDriverUtility contact) {
//		return contactus;

	public WebElement scrollgetcontactus(WebDriverUtility utl) {
		return contactus;
	}

	public void clickcontactus() {
		contactus.click();
	}
}
