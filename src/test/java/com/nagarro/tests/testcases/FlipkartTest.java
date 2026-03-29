package com.nagarro.tests.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.nagarro.automation.base.BaseTest;
import com.nagarro.automation.pages.*;
import com.nagarro.tests.listeners.RetryListener;
import com.nagarro.tests.listeners.TestListener;


@Listeners({TestListener.class, RetryListener.class})
public class FlipkartTest extends BaseTest {
	

	@Test
    public void verifyGuestUserFilter() {

        HomePage home = new HomePage();
        home.closeLoginPopup();

        home.searchProduct("Headphones");

        SearchResultPage result = new SearchResultPage();
        result.applyPriceFilter();   // assume method in page class

        Assert.assertTrue(result.isResultsDisplayed(),
                "Filtered results not displayed");
    }

    @Test
    public void verifyGuestSearchFlow() {

        HomePage home = new HomePage();
        home.closeLoginPopup();

        home.searchProduct("Headphones");

        SearchResultPage result = new SearchResultPage();
        Assert.assertTrue(result.isResultsDisplayed(), "Guest user search failed");
    }

    @Test
    public void verifyGuestAddToCart() throws InterruptedException {

    	
        HomePage home = new HomePage();
        home.closeLoginPopup();
        home.searchProduct("Shoes");
        home.selectFirstProduct();

        ProductPage product = new ProductPage();
        product.switchToProductWindow();
        product.selectSize(7);
        product.addToCart();
        product.clickOnCartButton();

        CartPage cart = new CartPage();
        Assert.assertTrue(cart.isItemAddedToCart(), "Item not added to cart");
    }
}