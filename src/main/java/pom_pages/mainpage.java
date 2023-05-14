package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class mainpage {
	/**
	 * declartion
	 */
	@FindBy(xpath = "//img[@alt=\"SkillRary\"]")
	private WebElement logo;
	@FindBy(xpath = "//a[text()=' GEARS ']")
	private WebElement gearTab;
	@FindBy(xpath = "//ul[@class=\"dropdown-menu gear_menu\"]/descendant::a[normalize-space(text())='SkillRary Demo APP']")
	private WebElement skillrarydemoapp;

	// **
	/**
	 * intialization
	 * 
	 */
	public mainpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * utilization
	 * 
	 */
	public WebElement getlogo() {
		return logo;
	}

	/**
	 * actions
	 */
	public void clickgearTab() {
		gearTab.click();
	}

	/**
	 * dropdown actions
	 */
	public void clickskillrarydemoapp() {
		skillrarydemoapp.click();
	}

}
