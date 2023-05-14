package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Library.WebDriverUtility;

public class testpage {
	@FindBy(xpath = "//h1[text()=\"Testing\"]")
	private WebElement pageHeader;
	@FindBy(xpath = "//*[name()='img'][@id=\"Selenium Training\"]")
	private WebElement selenum_img;
	@FindBy(xpath = "//div[@id=\"cartArea\"]")
	private WebElement addtochart;
	@FindBy(xpath = "//ul[@class=\"list-socialicons\"]/descendant::i[@class=\"fa fa-facebook\"]")
	private WebElement facebook;
	// intilization

	/**
	 * to element the stale elementreference exception and refer current web page
	 */
	public testpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utiliztion
	/**
	 * drag and drop scrolldown, click on faceebook and verify the page
	 */
	// getter
	public String getpageHeader() {
		return pageHeader.getText();
	}

	public WebElement getselenum_img() {
		return selenum_img;
	}

	public WebElement getaddtochart() {
		return addtochart;
	}

	public WebElement getfacebook() {
		return facebook;
	}

	/**
	 * function
	 * 
	 * @param web //
	 */
	public void draganddrop(WebDriverUtility web) {
		web.dragAndDrop(selenum_img, addtochart);

	}

	public void scrollbyfacebook(WebDriverUtility facebook1) {
		facebook1.scrollTillElement(facebook);
	}

	public void clickfacebook() {
		facebook.click();
	}

}
