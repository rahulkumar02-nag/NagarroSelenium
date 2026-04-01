package com.nagarro.automation.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.nagarro.automation.driver.DriverFactory;
import com.nagarro.automation.utils.WaitUtil;

public class ProductPage {

	private WebDriver driver;

	public ProductPage() {
		this.driver = DriverFactory.getDriver();
	}

	private By addToCartBtn = By.xpath("//div[contains(text(),'Add to cart')]");
	private By clickOnCartBtn = By.xpath("//a[@title='Cart']");

	public void switchToProductWindow() {

		String parent = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for (String win : allWindows) {
			if (!win.equals(parent)) {
				driver.switchTo().window(win);
				break;
			}

			WaitUtil.staticWait(5);
		}
	}

	public void selectSize(int requiredSize) {
		WebElement sizeLocator = driver.findElement(By.xpath("//div[normalize-space()='" + requiredSize + "']"));

		if (sizeLocator.isEnabled()) {
			WaitUtil.waitForClickable(sizeLocator).click();
		} else {
			System.out.println("Size is not available : Please Enter Another Size");
		}
	}

	public void addToCart() {
		
		WaitUtil.waitForElementPresent(addToCartBtn);
		WaitUtil.waitForClickable(addToCartBtn).click();
	}

	public void clickOnCartButton() {
		WaitUtil.waitForClickable(clickOnCartBtn).click();

	}
}