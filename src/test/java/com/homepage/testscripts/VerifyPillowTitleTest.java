package com.homepage.testscripts;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.common.utils.BrowserUtils;
import com.common.utils.PageConstants;
import com.pages.HomePage;

public class VerifyPillowTitleTest extends BrowserUtils{

	private HomePage homePage = new HomePage();

	@Test(description = "Verify that 'Midtrans Pillow' title is displayed in home page")
	public void verifyPillowTitle() {
		homePage.launchUrl();
		Assert.assertEquals(homePage.verifyPillowTitle(), PageConstants.MIDTRANSPILLOWTITLE);
	}

}
