package com.automation.electrolux.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.electrolux.pages.*;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_07_TC_02_AQA_Dnads_OrderSummary extends BaseTest {

    private final ElectroluxHomePageActions homePage = new ElectroluxHomePageActions();
    private final ElectroluxPdpPageActions pdpPage = new ElectroluxPdpPageActions();
    private final DeliveryAndServicePageActionElux dnsPage = new DeliveryAndServicePageActionElux();
    private final CartPageActionsElux cartPage = new CartPageActionsElux();


    @Test(groups = {"smoke", "regression"}, description = "Verify Order Summary on D&S page for Front Load Washer")
    public void EPIC_07_DandS_TC_02_verifyOrderSummaryForFrontLoadWasher() {
        homePage.navigateToHomePage();
        WaitUtils.untilPageLoadComplete();
        homePage.clickSearchAndEnterProductId("ELFW7537AT");
        homePage.clickSearchIcon();
        homePage.clickProvidedProduct();
        pdpPage.clickAddToCartButton();

        dnsPage.clickSaveAndViewCartButton();

        Assert.assertTrue(cartPage.isOrderSummaryTextVisibleAndCorrect("Order Summary"), "Order summary text does not visible on page or Not matched with the expected one");
        Assert.assertTrue(cartPage.isSubtotalTextVisibleAndCorrect("Subtotal"), "Subtotal Text does not visible on page or Not matched with the expected one");
        Assert.assertTrue(cartPage.isSubtotalPriceVisible(), "Subtotal price does not visible on page");
        Assert.assertTrue(cartPage.isHomeDeliveryTextVisibleAndCorrect("Home delivery"), "Home delivery Text does not visible on page or Not matched with the expected one");
        Assert.assertTrue(cartPage.isHomeDeliveryPriceVisible(), "Home delivery price does not visible on page");
        Assert.assertTrue(cartPage.isInstallationPartTextVisibleAndCorrect("Installation parts"), "Installation parts Text does not visible on page or Not matched with the expected one");
        Assert.assertTrue(cartPage.isInstallationPriceVisible(), "Installation parts price does not visible on page");
        Assert.assertTrue(cartPage.isTotalTextVisibleAndCorrect("Total"), "Total Text does not visible on page or Not matched with the expected one");
        Assert.assertTrue(cartPage.isTotalPriceVisible(), "Total price does not visible on page");
        Assert.assertTrue(cartPage.isPromoCodeTextVisibleAndCorrect("Promo code"), "Promo code Text does not visible on page or Not matched with the expected one");

        cartPage.clickProceedToCheckOutButton();


        ExtentReportManager.getTest().pass("Verify order summary on D&S page for Front Load Washer");
    }
}
