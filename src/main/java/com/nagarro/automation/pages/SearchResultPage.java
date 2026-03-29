package com.nagarro.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.nagarro.automation.driver.DriverFactory;
import com.nagarro.automation.utils.WaitUtil;

public class SearchResultPage {

    private WebDriver driver;

    public SearchResultPage() {
        this.driver = DriverFactory.getDriver();
    }

    private By results = By.xpath("//div[starts-with(@data-id, 'ACCH')][1]");
    private By brandFilter = By.xpath("//div[text()= 'Brand']");
    private By selectBoAtbrandFilter = By.xpath("//div[@title='boAt']");
    
  

    public boolean isResultsDisplayed() {
        return WaitUtil.waitForVisibility(results).isDisplayed();
    }

	public void applyPriceFilter() {		
		WaitUtil.waitForVisibility(brandFilter).click();
		WaitUtil.waitForVisibility(selectBoAtbrandFilter).click();
		
	}
}