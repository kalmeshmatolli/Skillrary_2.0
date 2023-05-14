package skillraryRelese1;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic_Library.Baseclass;

public class testscript1 extends Baseclass {
	@Test
	public void test1() {
		SoftAssert soft = new SoftAssert();
		home.clickgearTab();
		home.clickskillrarydemoapp();
		web.handleChildBrowser();
		soft.assertEquals(demoapp.getpageHeader(), ("SkillRary-ECommerce"));
		demoapp.mouseHoverTocourse(web);
		demoapp.clickseleniumtraning();
		soft.assertEquals(selenium.getpageheader(), "Selenium Training");
		selenium.doubleclick(web);
		selenium.clickAddTochart();
		web.handelAlertpops("ok", null);
		soft.assertEquals(selenium.getiteamaddtocartmessage(), "Item added to cart");
		soft.assertAll();

	}

}
