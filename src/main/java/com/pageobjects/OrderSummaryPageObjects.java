package com.pageobjects;

import org.openqa.selenium.By;

public class OrderSummaryPageObjects {

	public static By TOTOALAMOUNT = By.cssSelector("td[class='table-amount text-body']");
	public static By PILLOWNAME = By.cssSelector("span[class='item-name']");
	public static By SHIPPINGDETAILSTAB = By.xpath("//span[contains(text(),'shipping details')]");
	public static By SHIPPINGDETAILSSECTION = By.cssSelector("div[class='content-text-block']");
	public static By CONTINUEBTN = By.cssSelector("div[class='sprite btn-main-next']");
	public static By CREDITCARDPAYMENTOPTION = By.cssSelector("a[href='#/credit-card']");
			
}
