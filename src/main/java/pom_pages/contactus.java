package pom_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactus {

	@FindBy(xpath = "//img[contains(@src,'contactus')]")
	private WebElement contactUsicon;
	@FindBy(name = "name")
	private WebElement nametextfiled;
	@FindBy(xpath = "//input[@placeholder=\"Email\"]")
	private WebElement Emailtextfiled;

	@FindBy(name = "subject")
	private WebElement subject;
	@FindBy(name = "message")
	private WebElement message;
	@FindBy(xpath = "//button[text()='Send us mail']")
	private WebElement sendusmail;

	/**
	 * this method is used to stalelement reference exception
	 * 
	 * @param driver
	 */

	// intilization
	public contactus(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// declaration
	public WebElement getcontactUsicon() {
		return contactUsicon;
	}

	public void senkeys(String fullname, String email, String messages, String subject1) {
		nametextfiled.sendKeys(fullname);
		Emailtextfiled.sendKeys(email);
		message.sendKeys(messages);
		subject.sendKeys(subject1);
		sendusmail.click();// automaticalyy click

	}
}
