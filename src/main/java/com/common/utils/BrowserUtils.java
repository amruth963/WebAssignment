package com.common.utils;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BrowserUtils {

	public static WebDriver driver;
	public ConfigReader configReader = new ConfigReader();
	private boolean flag = true;
	private static final Logger LOGGER = Logger.getLogger(Class.class.getName());


	@BeforeTest
	public void launchBrowser() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--disable-notifications");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty(configReader.getStaticProperty("ChromeKey"), configReader.getStaticProperty("ChromeValue"));
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	public WebElement webDriverWait(By locators) {
		WebElement ele = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locators));
			wait.until(ExpectedConditions.presenceOfElementLocated(locators));
			ele = driver.findElement(locators);
		} catch (Exception e) {
			Assert.fail("Unable to find element " + locators + " due to" + e.getMessage());
		}
		return ele;
	}

	public List<WebElement> webDriverWebElementsWait(By locators) {
		List<WebElement> ele = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locators));
			wait.until(ExpectedConditions.presenceOfElementLocated(locators));
			ele = driver.findElements(locators);
		} catch (Exception e) {
			Assert.fail("Unable to find element " + locators + " due to " + e.getMessage());
		}
		return ele;
	}

	public boolean isWebElementDisplayed(By locators) {
		try {
			WebElement ele = webDriverWait(locators);
			if (ele.isDisplayed()) {
				LOGGER.info("WebElement " + ele + " is displayed on the webpage");
			} else {
				LOGGER.info("WebElement " + ele + " is not displayed on the webpage");
			}
			return flag;
		} catch (Exception e) {
			Assert.fail("Unable to find element " + locators + " due to" + e.getMessage());
			flag = false;
			return flag;
		}
	}

	public List<WebElement> findWebElements(By locator) {
		List<WebElement> getWebElements = null;
		try {
			webDriverWebElementsWait(locator);
			getWebElements = driver.findElements(locator);
		} catch (Exception e) {
			Assert.fail("Unable to find web elements with " + locator + " due to" + e.getMessage());
		}
		return getWebElements;
	}

	public String getAttribute(By locators, String attributeName) {
		String attributeValue = null;
		try {
			WebElement ele = webDriverWait(locators);
			if (ele.isDisplayed()) {
				attributeValue = ele.getAttribute(attributeName);
			}
		} catch (Exception e) {
			Assert.fail("Unable to get attibute with given " + locators + " and " + attributeName + " due to :" + e.getMessage());
		}
		return attributeValue;
	}

	public ArrayList<String> getAttributes(By locators) {
		ArrayList<String> imageLinks = new ArrayList<String>();
		try {
			List<WebElement> ele = driver.findElements(locators);
			for (WebElement imageLink : ele) {
				imageLinks.add(imageLink.getAttribute(configReader.getStaticProperty("xoxodayimagesattibutename")));
			}
		} catch (Exception e) {
			Assert.fail("Unable to get attibutes with given " + locators + " due to: " + e.getMessage());
		}
		return imageLinks;
	}

	public ArrayList<String> getAttributes(By locators, String attributeName) {
		ArrayList<String> imageLinks = new ArrayList<String>();
		try {
			List<WebElement> ele = driver.findElements(locators);
			for (WebElement imageLink : ele) {
				imageLinks.add(imageLink.getAttribute(attributeName));
			}
		} catch (Exception e) {
			Assert.fail("Unable to get attibutes with given " + locators + " due to: " + e.getMessage());
		}
		return imageLinks;
	}


	public String getWebElementsTxt(By locators) {
		String menuNames = null;
		try {
			webDriverWebElementsWait(locators);
			List<WebElement> ele = driver.findElements(locators);
			for (WebElement name : ele) {
				menuNames = name.getText();
			}
		} catch (Exception e) {
			Assert.fail("WebElement is not displayed with given " + locators + " due to " + e.getMessage());
		}
		return menuNames;
	}

	public String getText(By locators) {
		String text = null;
		try {
			webDriverWebElementsWait(locators);
			isWebElementDisplayed(locators);
			WebElement ele = driver.findElement(locators);
			text = ele.getText();
		} catch (Exception e) {
			Assert.fail("WebElement is not displayed with given " + locators + " due to " + e.getMessage());
		}
		return text;
	}

	public ArrayList<String> getTextAsArrays(By locators) {
		ArrayList<String> getTexts = new ArrayList<String>();
		try {
			List<WebElement> ele = driver.findElements(locators);
			for (WebElement text : ele) {
				getTexts.add(text.getText());
			}
		} catch (Exception e) {
			Assert.fail("WebElement is not displayed with given " + locators + " due to " + e.getMessage());
		}
		return getTexts;
	}


	public boolean mouseHover(By locator) {
		try {
			Actions action = new Actions(driver);
			WebElement menuOption = driver.findElement(locator);
			action.moveToElement(menuOption).build().perform();
		} catch (Exception e) {
			Assert.fail("MouseHover function failed with " + locator + " due to " + e.getMessage());
		}
		return flag;
	}

	public boolean mouseHover(By locator1, By locator2) {
		try {
			Actions action = new Actions(driver);
			WebElement mainMenu = driver.findElement(locator1);
			action.moveToElement(mainMenu).moveToElement(driver.findElement(locator2)).click().build()
			.perform();
		} catch (Exception e) {
			Assert.fail("MouseHover function failed with " + locator1 + " and " + locator2 + " due to " + e.getMessage());
		}
		return flag;
	}

	public boolean clickOnElement(By locator) {
		try {
			WebElement ele = webDriverWait(locator);
			isWebElementDisplayed(locator);
			ele.click();
			LOGGER.info("Successfully clicked on " + locator + " element");
		} catch (Exception e) {
			Assert.fail("Unable to click on " + locator + " element due to: " + e.getMessage());
		}
		return flag;
	}

	public boolean clickOnElementUsingJavaScriptExecutor(By locator) {
		try {
			WebElement ele = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
		} catch (Exception e) {
			Assert.fail("Unable to click on " + locator + " element due to: " + e.getMessage());
		}
		return flag;
	}

	public String getCurrentURL() {
		String currentUrl = null;
		try {
			currentUrl = driver.getCurrentUrl();
		} catch (Exception e) {
			Assert.fail("Unable to get current url due to: " + e.getMessage());
		}
		return currentUrl;
	}


}
