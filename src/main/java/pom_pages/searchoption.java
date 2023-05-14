package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Library.WebDriverUtility;

public class searchoption {
	@FindBy(xpath = "//img[@alt=\"SkillRary\"]")
	private WebElement logo1;
	@FindBy(xpath = "//a[text()=' Core Java For Selenium Trainin']")
	private WebElement javaselenium;

	// intilization

	public searchoption(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getlogo1() {
		return logo1;
	}

	public void clickjavaselenium() {
		javaselenium.click();
	}
}
