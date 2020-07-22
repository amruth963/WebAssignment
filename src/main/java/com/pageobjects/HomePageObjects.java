package com.pageobjects;

import org.openqa.selenium.By;

public class HomePageObjects {

	public static By MIDTRANSPILLOWTITLE = By.cssSelector("div.title");
	public static By TOTALAMOUNTONHOMESCREEN = By.cssSelector("span[data-reactid='.0.0.0.2.0.0.2.1']");
	public static By BUYNOWBTN = By.linkText("BUY NOW");
	public static By SHOPPINGCARTTITLE = By.cssSelector("span[data-reactid='.0.0.1.0.0.0']");
	public static By TOTALAMOUNTONCART = By.cssSelector("td.amount");
	public static By NAMETXTFIELD = By.cssSelector("input[data-reactid='.0.0.1.0.3.0.0.0.1.0']");
	public static By EMAILTXTFIELD = By.cssSelector("input[data-reactid='.0.0.1.0.3.0.0.1.1.0']");
	public static By PHONENOTXTFIELD = By.cssSelector("input[data-reactid='.0.0.1.0.3.0.0.2.1.0']");
	public static By CITYTXTFIELD = By.cssSelector("input[data-reactid='.0.0.1.0.3.0.0.3.1.0']");
	public static By ADDRESSTXTFIELD = By.cssSelector("textarea[data-reactid='.0.0.1.0.3.0.0.4.1.0']");
	public static By POSTALCODETXTFIELD = By.cssSelector("input[data-reactid='.0.0.1.0.3.0.0.5.1.0']");
	public static By CHECKOUTBTN = By.cssSelector("div.cart-checkout");
	public static By PURCHASESUCCESSMSG = By.cssSelector("span[data-reactid='.0.0.0.2.0.1.0.0:0']");


}
