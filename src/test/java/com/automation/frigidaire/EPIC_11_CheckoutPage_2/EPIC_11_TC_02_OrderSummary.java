package com.automation.frigidaire.EPIC_11_CheckoutPage_2;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.COPS_OrderSummaryPageActionsFrig;
import com.automation.frigidaire.pages.FEDEX_AITPageActionsFrig;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.OutOfStockPageActionsFrig;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class EPIC_11_TC_02_OrderSummary extends BaseTest {

    HomePageActionsFrig homePage = new HomePageActionsFrig();
    FEDEX_AITPageActionsFrig fedexPage = new FEDEX_AITPageActionsFrig();
    OutOfStockPageActionsFrig productItems = new OutOfStockPageActionsFrig();
    COPS_OrderSummaryPageActionsFrig cposPage = new COPS_OrderSummaryPageActionsFrig();

    @Test(groups = {"smoke", "regression"}, description = "Verify Order Summary Pages.")
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

        List<String> labels = Arrays.asList("Subtotal", "Installation parts", "Add-on services", "Parcel shipping",
                "tap protection plan", "Sales tax");
        for(String label : labels){
            Assert.assertTrue(
                    cposPage.verifySubtotal(label), "Order summary label '" + label + "' is not displayed.");
        }

        List<String> summaryTexts = Arrays.asList("Total", "You saved", "Package savings", "Cart savings", "Cart discounts");
        for(String total : summaryTexts){
            Assert.assertTrue(
                    cposPage.verifySubtotal(total), "Order summary text '" + total + "' is not displayed."
            );
        }

        ExtentReportManager.getTest().pass("Verify Order Summary Pages.");
    }
}
