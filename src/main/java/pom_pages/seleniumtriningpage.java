package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Library.WebDriverUtility;

public class seleniumtriningpage {
	@FindBy(xpath = "//h1[text()='Selenium Training']")
	private WebElement pageheader;
	@FindBy(xpath = "//button[@class='btn btn-primary btn-lg btn-flat']")
	private WebElement AddTochart;
	@FindBy(xpath = "//button[@id=\"add\"]")
	private WebElement plusebutton;
	@FindBy(xpath = "//span[text()=\"Item added to cart\"]")
	private WebElement iteamaddtocartmessage;

	// intilization
	/**
	 * eleention of stale element reference exception
	 */
	public seleniumtriningpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization
	/**
	 * check the page it open or not by text
	 * 
	 * @return
	 */
	public String getpageheader() {
		return pageheader.getText();
	}

	/**
	 * action,doubleclick,click,ok, gettext
	 */
	public void doubleclick(WebDriverUtility click) {
		click.doubleClick(plusebutton);
	}

	public void clickAddTochart() {
		AddTochart.click();
	}

	public String getiteamaddtocartmessage() {
		return iteamaddtocartmessage.getText();
	}
}
