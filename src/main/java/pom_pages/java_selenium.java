package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class java_selenium {
	@FindBy(xpath = "//h1[text()='Core Java For Selenium Training']")
	private WebElement selenium_java;
//@FindBy(xpath = "//*[name()='svg'][@class=\"PlayButton_module_playIcon__af9e9913\"]")
//private WebElement palybutton;
//@FindBy(xpath = "//*[name()='svg'][@class=\"PlayButton_module_pauseIcon__af9e9913\"]")
//private WebElement pausebutton;
//@FindBy(xpath = "//div[@class=\"vp-preview vp-preview-cover\"]")
//private WebElement palybutton;

	@FindBy(xpath = "//span[text()=\"Add To Wishlist\"]")
	private WebElement Wishlist;

//intilization

	public java_selenium(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
//declarition

	public String getselenium_java() {
		return selenium_java.getText();
	}

	public void clickWishlist() {
		Wishlist.click();
	}
}
