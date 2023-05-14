package generic_Library;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	private WebDriver driver;
	private Actions a;
	private Select s;
	private Alert a1;

	/**
	 * THIS METHOD IS USED FOR OPEN THE BROWSER, NAVIGATE TO APPLICATION
	 * 
	 * @param browser
	 * @param url
	 * @param time
	 * @return
	 */

	public WebDriver openApplication(String browser, String url, long time) {
		switch (browser) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "fireFox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("invalid browser data");
		}

		driver.manage().window().maximize();
		driver.get(url);
		// version selenium version implicitly wait script change
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

		return driver;

	}

	public WebElement explicitWait(WebElement element, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement e = wait.until(ExpectedConditions.visibilityOf(element));
		return e;
	}

	/**
	 * THIS METHOD IS USED TO MOUSE HOVER ACTIONS
	 * 
	 * @param element
	 */

	public void mouseHover(WebElement element) {

		a = new Actions(driver);
		a.moveToElement(element).perform();

	}

	/**
	 * THIS METHOD IS USED TO DOUBLE CLICK
	 * 
	 * @param element
	 */

	public void doubleClick(WebElement element) {

		a = new Actions(driver);
		a.doubleClick(element).perform();

	}

	/**
	 * THIS METHOD IS USED FOR RIGHT CLICK
	 * 
	 * @param element
	 */

	public void rightClick(WebElement element) {

		a = new Actions(driver);
		a.contextClick(element).perform();

	}

	/**
	 * THIS METHOS IS USED TO DRAG AND DROP
	 * 
	 * @param element
	 * @param targate
	 */

	public void dragAndDrop(WebElement element, WebElement targate) {

		a = new Actions(driver);
		a.dragAndDrop(element, targate).perform();

	}

	/**
	 * THIS METHOD IS USED TO TAKE SCREEN SHOT
	 * 
	 * @param javaUtil
	 */

	public void takeScreenShots(JavaUtility javaUtil) {// CLASS LPOADING TIME
		// class.methodname
		// class we can reference
		// lose coupling

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot" + javaUtil.getcurrentdatetime() + ".png");

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// example for method overloading
	/**
	 * DROP DOWN, SELECT BY INDEX
	 * 
	 * @param element
	 * @param index
	 */

	public void dropDown(WebElement element, int index) {
		// support.ui.select
		s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * SELECT BY VALUES
	 * 
	 * @param element
	 * @param value
	 */

	public void dropDown(WebElement element, String value) {
		s = new Select(element);
		s.selectByValue(value);
	}

	/**
	 * SELECT BY VISIBLE TEXT
	 * 
	 * @param text
	 * @param element
	 */

	public void dropDown(String text, WebElement element) {
		s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * THIS METHOD IS USED TO SWITCH TO FRANME EX:FOR METTHOD OVER LOADING
	 * 
	 * @param index
	 */

	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	/**
	 * THIS METHOSD IS USED TO SWITCH BACK TO FRAME
	 */

	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}

	/**
	 * THIS METHOD IS USED TO SCROLL DOWN UNTILL THE OBECT VISABLE
	 * 
	 * @param element
	 */

	public void scrollTillElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

	}

	/**
	 * this method is used to handel the alert popups
	 * 
	 * @param sendkeys
	 * @param data
	 * @param status
	 */
//	public void handleAlert(String status) {
//	//	hadel by by alert interface
//
//		Alert al = driver.switchTo().alert();
//		if (status.equalsIgnoreCase("ok")) {
//			//status.equal("ok") 
//			al.accept();
//		} else {
//			al.dismiss();
//		}
//	}
	public void handelAlertpops(String elemnts, String data) {
		a1 = driver.switchTo().alert();

		switch (elemnts) {
		case "ok":
			a1.accept();
			break;
		case "cancel":
			a1.dismiss();
			break;
		case "sendkey":
			a1.sendKeys(data);
			break;
		case "gettext":
			a1.getText();
			break;
		default:
			System.out.println("another action is not intilized in frame work");

		}

	}

	/**
	 * this method is used to handel the parent browser address
	 */
	public void handelparentBrowser() {
		String parent = driver.getWindowHandle();
		driver.switchTo().window(parent);
	}

	/**
	 * this method is used to handel the ChildBrowser
	 */
	public void handleChildBrowser() {
		Set<String> set = driver.getWindowHandles();
		for (String wId : set) {
			driver.switchTo().window(wId);
		}
	}

	/**
	 * this method used to close the cureent tab
	 */

	public void closeCurrentTab() {
		driver.close();
	}

	/**
	 * this method is used to quit the browser
	 */
	public void quitBrowser() {
		driver.quit();
	}
}
