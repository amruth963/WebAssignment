package com.ordersummarypage.testscripts;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.common.utils.BrowserUtils;
import com.common.utils.PageConstants;
import com.pageobjects.CreditCardPageObjects;
import com.pages.HomePage;
import com.pages.OrderSummaryPage;

public class ClickOnContinueBtnAndSelectPaymentMethodTest extends BrowserUtils {


	private HomePage homePage = new HomePage();
	private OrderSummaryPage orderSummaryPage = new OrderSummaryPage();

	@Test(description = "Verify click on continue button and selection of credit card payment option")
	public void clickOnContinueBtnAndSelectCreditCardPayment() {
		homePage.launchUrl();
		Assert.assertEquals(homePage.verifyPillowTitle(), PageConstants.MIDTRANSPILLOWTITLE);
		Assert.assertEquals(homePage.clickOnBuyNowBtn(), true);
		homePage.enterCustomerDetailsAndClickOnCheckoutBtn(PageConstants.USERNAME, PageConstants.EMAIL, PageConstants.PHONENO, PageConstants.CITY, PageConstants.ADDRESS, PageConstants.POSTALCODE);
		switchiFrameOne(CreditCardPageObjects.IFRAMEPARENT);
		orderSummaryPage.clickOnContinueBtn();
		orderSummaryPage.selectCreditCardPaymentOption();
	}

}
