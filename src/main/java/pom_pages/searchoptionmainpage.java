package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Library.WebDriverUtility;

public class searchoptionmainpage {
	@FindBy(xpath = "//img[@alt=\"SkillRary\"]")
	private WebElement logo;
	@FindBy(xpath = "//input[@name=\"q\"]")
	private WebElement searchoption;
	@FindBy(xpath = "//input[@type=\"submit\"]")
	private WebElement searchButton;

//intilization
	public searchoptionmainpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//declartion
	public WebElement getlogo() {
		return logo;

	}

	public void clicksearchButton() {
		searchButton.click();
	}

	public void searchoption(String element) {
		searchoption.sendKeys(element);

	}

	public void searchButton() {
		searchButton.click();
	}
}
