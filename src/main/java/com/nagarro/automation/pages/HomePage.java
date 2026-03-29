package com.nagarro.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.nagarro.automation.driver.DriverFactory;
import com.nagarro.automation.utils.WaitUtil;

public class HomePage {

    private WebDriver driver;

    public HomePage() {
        this.driver = DriverFactory.getDriver();
    }

    // Locators
    private By closeLoginPopup = By.xpath("//span[@role='button']");
    private By searchBox = By.name("q");
    private By searchBtn = By.xpath("//button[@type='submit']");
    private By firstProduct = By.xpath("//div[starts-with(@data-id, 'SHO')][1]");

    // Actions

    public void closeLoginPopup() {
        try {
            WaitUtil.waitForClickable(closeLoginPopup).click();
        } catch (Exception e) {
            // Ignore if popup not present
        }
    }

    public void searchProduct(String product) {
        WaitUtil.waitForVisibility(searchBox).sendKeys(product);
        WaitUtil.waitForClickable(searchBtn).click();
    }

    public void selectFirstProduct() {
        WaitUtil.waitForClickable(firstProduct).click();
    }
}