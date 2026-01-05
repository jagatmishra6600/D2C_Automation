package com.automation.fsus.EPIC_12_ShippingDetails;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.COPS_OrderSummaryPageActions_Fsus;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.utils.WaitUtils;
import org.testng.annotations.Test;

public class EPIC_11_TC_02_ShippingDetails extends BaseTest {

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
        orderSummaryPage.enterAddressDetails("Tom","Walker","28088");
    }


    @Test(groups = {"smoke", "regression"}, description = "Verify Shipping Details.")
    public void verifyShppingDetails()
    {
        placeOrderWithMultipleProducts();


    }
}
