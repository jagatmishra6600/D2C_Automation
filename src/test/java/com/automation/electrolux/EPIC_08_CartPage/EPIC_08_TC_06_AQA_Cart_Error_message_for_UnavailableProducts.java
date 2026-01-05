package com.automation.electrolux.EPIC_08_CartPage;

import com.automation.BaseTest;
import com.automation.electrolux.pages.CartUnavailableProductsElux;
import com.automation.electrolux.pages.HomePageActionsElux;
import com.automation.frigidaire.locators.CartLocatorsFrig;
import com.automation.frigidaire.pages.*;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EPIC_08_TC_06_AQA_Cart_Error_message_for_UnavailableProducts extends BaseTest {

    private final HomePageActionsElux homePage = new HomePageActionsElux();
    private final CartUnavailableProductsElux cartProductPage = new CartUnavailableProductsElux();


    @Test( description = "Verify Error message from Cart for unavailable products")
    public void EPIC_08_Cart_TC_06_validateUnavailableProductsFromCart() {
        homePage.navigateToHomePage();
        WaitUtils.untilPageLoadComplete();
        cartProductPage.clickOnFilterandaccessories();
        cartProductPage.clickOnAccessories();
        cartProductPage.clickOnAddtocartproduct1();
        cartProductPage.clickOnCancelbutton();
        cartProductPage.clickOnAddtocartproduct2();
        cartProductPage.clickOnCancelbutton();
        cartProductPage.clickOnAddtocartproduct3();
        cartProductPage.clickOnCancelbutton();
        cartProductPage.clickOnFilterandaccessories();
        cartProductPage.clickOnAirfilter();
        cartProductPage.clickOnAddtocartproduct();
        cartProductPage.clickOnCancelbutton();
        cartProductPage.clickOnFilterandaccessories();
        cartProductPage.clickOnDishwasher();
        cartProductPage.clickOnDishwasherproduct();
        cartProductPage.clickOnViewcart();
        Assert.assertTrue(cartProductPage.verifyemptycart(), "Empty cart text is not found.");


        ExtentReportManager.getTest().pass("Validate unavailable products on Cart page");

    }
}
