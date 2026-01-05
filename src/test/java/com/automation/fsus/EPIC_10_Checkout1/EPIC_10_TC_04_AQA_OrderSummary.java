package com.automation.fsus.EPIC_10_Checkout1;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.COPS_OrderSummaryPageActions_Fsus;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class EPIC_10_TC_04_AQA_OrderSummary extends BaseTest {

    LoginPageActionsFsus loginPage = new LoginPageActionsFsus();
    COPS_OrderSummaryPageActions_Fsus orderSummaryPage = new COPS_OrderSummaryPageActions_Fsus();


    public void placeOrderWithMultipleProducts() {

        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        orderSummaryPage.searchProducts("GRMC2273CF-C1");
        orderSummaryPage.clickOnProductBundle();
        WaitUtils.untilPageLoadComplete(10);
        orderSummaryPage.selectAddOnProtectionPlan();


        WaitUtils.untilPageLoadComplete();
        orderSummaryPage.searchProducts("FHWC064TE1");
        orderSummaryPage.clickOnProductRacks();

        orderSummaryPage.clickOnProceedCheckout();

    }


    @Test(groups = {"smoke", "regression"}, description = "Verify Order Summary for the checkout page 1.")
    public void verifyOrderSummaryDetails()
    {
        placeOrderWithMultipleProducts();
        List<String> labels = Arrays.asList("Subtotal", "Installation parts", "Add-on services", "Parcel shipment",
                "Tap protection plan");
        for (String label : labels) {
            Assert.assertTrue(
                    orderSummaryPage.verifySubtotal(label), "Order summary label '" + label + "' is not displayed.");
        }
        List<String> summaryTexts = Arrays.asList("Total", "You saved", "Cart savings", "Cart discounts");
        for (String total : summaryTexts) {
            Assert.assertTrue(
                    orderSummaryPage.verifySubtotal(total), "Order summary label '" + total + "' is not displayed.");
        }
        ExtentReportManager.getTest().pass("Verified Order Summary for the checkout page 1.");
    }
}
