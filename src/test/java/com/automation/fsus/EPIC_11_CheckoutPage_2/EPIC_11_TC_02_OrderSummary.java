package com.automation.fsus.EPIC_11_CheckoutPage_2;

import com.automation.familystoreus.pages.COPS_OrderSummaryPageActions_Fsus;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class EPIC_11_TC_02_OrderSummary {

     LoginPageActionsFsus loginPage = new LoginPageActionsFsus();
     COPS_OrderSummaryPageActions_Fsus orderSummaryPage = new COPS_OrderSummaryPageActions_Fsus();

    public void placeOrderWithMultipleProducts(){

        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        orderSummaryPage.searchProducts("GRMC2273CF-C1");
        orderSummaryPage.clickOnProductBundle();

        orderSummaryPage.searchProducts("ELFW7537AW");
        orderSummaryPage.clickOnProductBundle();

        orderSummaryPage.searchProducts("FHWC064TE1");
        orderSummaryPage.clickOnProductRacks();

        orderSummaryPage.clickOnProceedCheckout();
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify Order Summary Pages.")
    public void EPIC_04_PLP_TC_03_testOrderSummaryPage() {
        placeOrderWithMultipleProducts();
        orderSummaryPage.enterAddressDetails("28088");
        List<String> labels = Arrays.asList("Subtotal", "Installation parts", "Add-on services", "Parcel shipping",
                "tap protection plan", "Sales tax");
        for(String label : labels){
            orderSummaryPage.verifySubtotal(label);
        }
        List<String> summaryTexts = Arrays.asList("Total", "You saved", "Cart savings", "Cart discounts");
        for(String total : summaryTexts){
            orderSummaryPage.verifySubtotal(total);
        }
    }
}
