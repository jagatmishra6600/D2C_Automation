package com.automation.frigidaire.EPIC_11_CheckoutPage_2;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.*;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class EPIC_11_TC_04_OrderItems extends BaseTest{


    HomePageActionsFrig homePage = new HomePageActionsFrig();
    FEDEX_AITPageActionsFrig fedexPage = new FEDEX_AITPageActionsFrig();
    OutOfStockPageActionsFrig productItems = new OutOfStockPageActionsFrig();
    COPS_OrderSummaryPageActionsFrig cposPage = new COPS_OrderSummaryPageActionsFrig();
    OrderItemsPageActionsFrig orderItems = new OrderItemsPageActionsFrig();

    @Test(groups = {"smoke", "regression"}, description = "Verify Order Items Pages.")
    public void EPIC_04_PLP_TC_03_testOrderSummaryPage(){

        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");

        fedexPage.searchProducts("GRMC2273CF-C1");
        productItems.closeEmailPopUp();
        cposPage.clickProductKitchen();

        WaitUtils.sleep(5000);
        List<String> kitchenProducts = Arrays.asList("FHWW184WE2", "FHWC064TE1");
        for (String product : kitchenProducts) {
            fedexPage.searchProducts(product);
            fedexPage.clickProduct();
        }
        fedexPage.checkoutPageFirst();
        fedexPage.shippingAddress("28088");

        orderItems.orderItemsDetails();

        ExtentReportManager.getTest().pass("Verify Order items details");
    }
}
