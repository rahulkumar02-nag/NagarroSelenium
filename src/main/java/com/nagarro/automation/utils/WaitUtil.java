package com.nagarro.automation.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nagarro.automation.driver.DriverFactory;

public class WaitUtil {

	// Default wait time
	private static final int TIMEOUT = 10;

	// Wait for element visibility
	public static WebElement waitForVisibility(By locator) {
		WebDriver driver = DriverFactory.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Wait for element clickable
	public static WebElement waitForClickable(By locator) {
		WebDriver driver = DriverFactory.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// Wait for presence of element
	public static WebElement waitForElementPresent(By locator) {
		WebDriver driver = DriverFactory.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// Wait for element invisible
	public static boolean waitForElementInvisible(By locator) {
		WebDriver driver = DriverFactory.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	// static wait
	public static void staticWait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static WebElement waitForClickable(WebElement sizeLocator) {
		WebDriver driver = DriverFactory.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
		return wait.until(ExpectedConditions.elementToBeClickable(sizeLocator));
	}
}