package com.nagarro.automation.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.nagarro.automation.driver.DriverFactory;
import com.nagarro.automation.utils.ConfigReader;

public class BaseTest {

	@BeforeMethod
	public void setUp() {

		String url = ConfigReader.getProperty("url");

		DriverFactory.initDriver();

		WebDriver driver = DriverFactory.getDriver();
		driver.get(url);
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}

}
