package com.pageobjects;

import org.openqa.selenium.By;

public class CreditCardPageObjects {

	public static By TOTALAMOUNTINPAYMENTPAGE = By.cssSelector("span[class='text-amount-amount']");
	public static By CARDNUMBERTXTFIELD = By.name("cardnumber");
	public static By EXPIRYDATETXTFIELD = By.cssSelector("input[placeholder='MM / YY']");
	public static By CVVTXTFIELD = By.cssSelector("input[inputmode='numeric']");
	public static By PAYNOWBTN = By.cssSelector("div.text-button-main");
	public static By PROCESSINGTXT = By.cssSelector("div.text-button-main");
	public static By OTPTXTFIELD = By.id("PaRes");
	public static By OKBTN = By.cssSelector("button[class='btn btn-sm btn-success']");
	//	public static By TRANSACTIONSUCCESSMSG= By.xpath("//div[@class='text-success text-bold']");
	public static By TRANSACTIONFAILUREMSG = By.cssSelector("div[class='text-failed text-bold']");
	public static By TRANSACTIONFAILUREREASON = By.cssSelector("div[class='text-failed']");
	public static By IFRAMEPARENT = By.id("snap-midtrans");


}
