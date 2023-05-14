package skillraryRelese1;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic_Library.Baseclass;

public class testscript2 extends Baseclass {
	@Test
	public void test1() {
		SoftAssert soft = new SoftAssert();
		home.clickgearTab();
		home.clickskillrarydemoapp();
		web.handleChildBrowser();

		soft.assertEquals(demoapp.getpageHeader(), ("SkillRary-ECommerce"));
		demoapp.selectcatagorydropdown(web, 1);

		soft.assertEquals(testing.getpageHeader(), "Testing");

		web.dragAndDrop(testing.getselenum_img(), testing.getaddtochart());
		testing.scrollbyfacebook(web);
		testing.clickfacebook();
		soft.assertAll();

	}

}
