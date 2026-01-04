package com.automation.electrolux.EPIC_11_CheckoutPage2;

import com.automation.BaseTest;
import com.automation.electrolux.pages.COPS_OrderSummaryPageActionsElux;
import com.automation.electrolux.pages.FEDEX_AITPageActionsElux;
import com.automation.electrolux.pages.HomePageActionsElux;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;

public class EPIC_11_TC_03_FEDEX_AIT extends BaseTest {


    HomePageActionsElux homePageActionsElux = new HomePageActionsElux();
    COPS_OrderSummaryPageActionsElux orderSummaryElux = new COPS_OrderSummaryPageActionsElux();
    FEDEX_AITPageActionsElux fedexAitElux = new FEDEX_AITPageActionsElux();

    @Test(groups = {"smoke", "regression"}, description = "Verify FEDEX and AIT for checkout page_2")
    public void testForFEDEXCheckoutPage(){
        homePageActionsElux.navigateToHomePage();
        homePageActionsElux.isHomePageLoaded();

        orderSummaryElux.searchSku("ELFW7537AW");
        orderSummaryElux.selectProduct();

        orderSummaryElux.clickOnProceed();
        orderSummaryElux.shippingAddress("demo14@gmail.com", "Tom", "Walker", "85062","7894561234");

        fedexAitElux.checkoutPagesFedex();

        ExtentReportManager.getTest().pass("Verify FEDEX and AIT for checkout page_2");
    }
}
