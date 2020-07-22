package com.ordersummarypage.testscripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.utils.BrowserUtils;
import com.common.utils.PageConstants;
import com.pages.HomePage;
import com.pages.OrderSummaryPage;

public class VerifyPillowNameInOrderSummaryTest extends BrowserUtils{

	private HomePage homePage = new HomePage();
	private OrderSummaryPage orderSummaryPage = new OrderSummaryPage();

	@Test(description = "Verify 'Midtrans' pillow name in order summary screen")
	public void verifyPillowNameInOrderSummary() {
		homePage.launchUrl();
		AssertJUnit.assertEquals(homePage.verifyPillowTitle(), PageConstants.MIDTRANSPILLOWTITLE);
		String pillowTitleInHomePage = homePage.verifyPillowTitle();
		AssertJUnit.assertEquals(homePage.clickOnBuyNowBtn(), true);
		homePage.enterCustomerDetailsAndClickOnCheckoutBtn(PageConstants.USERNAME, PageConstants.EMAIL, PageConstants.PHONENO, PageConstants.CITY, PageConstants.ADDRESS, PageConstants.POSTALCODE);
		switchiFrameOne();
		String pillowTitleInOrderSummaryPage = orderSummaryPage.verifyPillowNameInOrderSummaryPage();
		AssertJUnit.assertEquals(pillowTitleInOrderSummaryPage, pillowTitleInHomePage);
	}

}
