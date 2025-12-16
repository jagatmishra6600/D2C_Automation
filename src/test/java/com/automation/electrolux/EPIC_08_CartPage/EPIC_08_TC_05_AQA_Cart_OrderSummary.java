package com.automation.electrolux.EPIC_08_CartPage;

import com.automation.BaseTest;
import com.automation.electrolux.pages.CartPageActionsElux;
import com.automation.electrolux.pages.DeliveryAndServicePageActionsElux;
import com.automation.electrolux.pages.HomePageActionsElux;
import com.automation.electrolux.pages.PdpPageActionsElux;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_08_TC_05_AQA_Cart_OrderSummary extends BaseTest {

    private final HomePageActionsElux homePage = new HomePageActionsElux();
    private final PdpPageActionsElux pdpPage = new PdpPageActionsElux();
    private final DeliveryAndServicePageActionsElux dnsPage = new DeliveryAndServicePageActionsElux();
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
