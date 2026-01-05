package com.automation.electrolux.EPIC_11_CheckoutPage2;

import com.automation.BaseTest;
import com.automation.electrolux.pages.COPS_OrderItemsPageActionsElux;
import com.automation.electrolux.pages.COPS_OrderSummaryPageActionsElux;
import com.automation.electrolux.pages.HomePageActionsElux;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;


public class EPIC_11_TC_04_OrderItems extends BaseTest {

    HomePageActionsElux homePageActionsElux = new HomePageActionsElux();
    COPS_OrderSummaryPageActionsElux orderSummaryElux = new COPS_OrderSummaryPageActionsElux();
    COPS_OrderItemsPageActionsElux orderItemElux = new COPS_OrderItemsPageActionsElux();

    @Test(groups = {"smoke", "regression"}, description = "Verify Items summary page for checkout page_2")
    public void testForOrderItems(){
        homePageActionsElux.navigateToHomePage();
        homePageActionsElux.isHomePageLoaded();
        orderSummaryElux.searchSku("ELFW7337AW");
        orderSummaryElux.clickOnProductSelectPlan();

        orderSummaryElux.searchSku("EHVS75W1AY");
        orderSummaryElux.selectProduct();

        orderSummaryElux.clickOnProceed();
        orderSummaryElux.shippingAddress("demo14@gmail.com", "Tom", "Walker", "28088","7894561234");

        orderItemElux.orderItemsDetails();

        ExtentReportManager.getTest().pass("Verify Items summary page for checkout page_2");
    }
}
