package com.automation.fsus.EPIC_11_CheckoutPage_2;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.COPS_OrderSummaryPageActions_Fsus;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.familystoreus.pages.OrderItemsPageActionsFsus;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.annotations.Test;


public class EPIC_11_TC_04_OrderItems extends BaseTest {

    LoginPageActionsFsus loginPage = new LoginPageActionsFsus();
    COPS_OrderSummaryPageActions_Fsus orderSummaryPage = new COPS_OrderSummaryPageActions_Fsus();
    OrderItemsPageActionsFsus orderitems = new OrderItemsPageActionsFsus();

    public void placeOrderWithMultipleProducts(){

        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        orderSummaryPage.searchProducts("GRMC2273CF-C1");
        orderSummaryPage.clickOnProductBundle();
        WaitUtils.untilPageLoadComplete();
        orderSummaryPage.selectAddOnProtectionPlan();

        orderSummaryPage.searchProducts("ELFW7537AW");
        orderSummaryPage.clickOnProductBundle();

        WaitUtils.untilPageLoadComplete();
        orderSummaryPage.searchProducts("FHWC064TE1");
        orderSummaryPage.clickOnProductRacks();

        orderSummaryPage.clickOnProceedCheckout();
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify Order Items Pages.")
    public void EPIC_04_PLP_TC_03_testOrderSummaryPage() {
        placeOrderWithMultipleProducts();
        orderSummaryPage.enterAddressDetails("Tom","Walker", "28088");
        orderitems.verifyDeliveryAndProductDetails();

        ExtentReportManager.getTest().pass("Verify Order Items Pages.");
    }
}
