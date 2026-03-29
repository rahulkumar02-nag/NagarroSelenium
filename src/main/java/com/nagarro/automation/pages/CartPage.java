package com.nagarro.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.nagarro.automation.driver.DriverFactory;
import com.nagarro.automation.utils.WaitUtil;

public class CartPage {

	private WebDriver driver;

	public CartPage() {
		this.driver = DriverFactory.getDriver();
	}

	private By cartItem = By.xpath("//div[contains(text(),'Place Order')]");

	public boolean isItemAddedToCart() {
		return WaitUtil.waitForVisibility(cartItem).isDisplayed();
	}
}