package com.automation.fsus.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.*;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_07_TC_02_AQA_Dnads_OrderSummary extends BaseTest {

    private final HomePageActionsFsus homePage = new HomePageActionsFsus();
    private final PdpPageActions_FSUS pdpPage = new PdpPageActions_FSUS();
    private final DeliveryAndServicePageAction_FSUS dnsPage = new DeliveryAndServicePageAction_FSUS();
    LoginPageActionsFsus loginPage = new LoginPageActionsFsus();
    private final CartPageAction_FSUS cartPage = new CartPageAction_FSUS();


    @Test(groups = {"smoke", "regression"}, description = "Verify Order Summary on D&S page for French Door Refrigerator")
    public void EPIC_07_DandS_TC_02_verifyOrderSummaryForFrenchDoorRefrigerator() {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        homePage.clickSearchAndEnterProductId("FRFG1723AV");
        homePage.clickSearchIcon();
        homePage.clickProvidedProduct();
        pdpPage.clickAddToCartButton();

        dnsPage.clickSaveAndViewCartButton();

        Assert.assertTrue(cartPage.isOrderSummaryTextVisibleAndCorrect("Order summary"), "Order summary text does not visible on page or Not matched with the expected one");
        Assert.assertTrue(cartPage.isSubtotalTextVisibleAndCorrect("Subtotal"), "Subtotal Text does not visible on page or Not matched with the expected one");
        Assert.assertTrue(cartPage.isSubtotalPriceVisible(), "Subtotal price does not visible on page");
        Assert.assertTrue(cartPage.isHomeDeliveryTextVisibleAndCorrect("Home Delivery"), "Home delivery Text does not visible on page or Not matched with the expected one");
        Assert.assertTrue(cartPage.isHomeDeliveryPriceVisible(), "Home delivery price does not visible on page");
        Assert.assertTrue(cartPage.isTotalTextVisibleAndCorrect("Total"), "Total Text does not visible on page or Not matched with the expected one");
        Assert.assertTrue(cartPage.isTotalPriceVisible(), "Total price does not visible on page");

        cartPage.clickProceedToCheckOutButton();

        ExtentReportManager.getTest().pass("Verify order summary on D&S page for French Door Refrigerator");
    }
}
