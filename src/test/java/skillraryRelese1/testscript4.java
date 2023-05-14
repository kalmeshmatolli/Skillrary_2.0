package skillraryRelese1;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic_Library.Baseclass;

public class testscript4 extends Baseclass {
	@Test
	public void test1() throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(searchhome.getlogo().isDisplayed());
		searchhome.searchoption("core java");
		searchhome.clicksearchButton();
		soft.assertTrue(search.getlogo1().isDisplayed());
		search.clickjavaselenium();

//		soft.assertEquals(javaselenium.getselenium_java(), "Core Java For Selenium Training");
//		javaselenium.clickppalybutton();
//		
//		Thread.sleep(1000);
//		javaselenium.clickpausebutton();

		javaselenium.clickWishlist();

		soft.assertAll();

//		search.moseover(web);
//		Thread.sleep(1000);

//		search.clickmouseover();
//		Thread.sleep(1000);
//		
//		search.clickmouseover();
//		Thread.sleep(1000);

//		search.clickplaybutton();
//		Thread.sleep(1000);
//		search.clickpalybutton();
//		
//		search.clickpausebutton();

	}

}
