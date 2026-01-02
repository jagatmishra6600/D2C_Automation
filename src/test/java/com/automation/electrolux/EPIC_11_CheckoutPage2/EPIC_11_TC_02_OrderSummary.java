package com.automation.electrolux.EPIC_11_CheckoutPage2;

import com.automation.BaseTest;
import com.automation.electrolux.pages.COPS_OrderSummaryPageActionsElux;
import com.automation.electrolux.pages.HomePageActionsElux;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class EPIC_11_TC_02_OrderSummary extends BaseTest {

    HomePageActionsElux homePageActionsElux = new HomePageActionsElux();
    COPS_OrderSummaryPageActionsElux orderSummaryElux = new COPS_OrderSummaryPageActionsElux();

    @Test(groups = {"smoke", "regression"}, description = "Verify Order summary page for checkout page_2")
    public void testForOrderSummary(){
        homePageActionsElux.navigateToHomePage();
        homePageActionsElux.isHomePageLoaded();
        orderSummaryElux.searchSku("ELFW7337AW");
        orderSummaryElux.clickOnProductSelectPlan();

        //homePageActionsElux.navigateToHomePage();
        orderSummaryElux.searchSku("EHVS75W1AY");
        orderSummaryElux.selectProduct();

        orderSummaryElux.clickOnProceed();
        orderSummaryElux.shippingAddress("demo14@gmail.com", "Tom", "Walker", "28088","7894561234");

        List<String> labels = Arrays.asList("Subtotal", "Installation parts", "Add-on services", "Parcel Shipping",
                "tap protection plan", "Sales tax");
        for(String label : labels){
            Assert.assertTrue(
                    orderSummaryElux.verifySubtotal(label), "Order summary label '" + label + "' is not displayed.");
        }

        List<String> summaryTexts = Arrays.asList("Total", "You saved", "Cart savings", "Cart discounts");
        for(String total : summaryTexts){
            Assert.assertTrue(
                    orderSummaryElux.verifySubtotal(total), "Order summary text '" + total + "' is not displayed."
            );
        }

        ExtentReportManager.getTest().pass("Verify Order summary page for checkout page_2");
    }
}
