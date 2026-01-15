package com.automation.electrolux.EPIC_12_Checkout3;

import com.automation.BaseTest;
import com.automation.electrolux.pages.COPS_OrderSummaryPageActionsElux;
import com.automation.electrolux.pages.HomePageActionsElux;
import com.automation.electrolux.pages.KlarnaPageActionElux;
import com.automation.electrolux.pages.ProductDetailPageActionsElux;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_12_TC_Klarna extends BaseTest {

    HomePageActionsElux homePageActionsElux = new HomePageActionsElux();
    COPS_OrderSummaryPageActionsElux orderSummaryElux = new COPS_OrderSummaryPageActionsElux();
    ProductDetailPageActionsElux electroluxProductCards =new ProductDetailPageActionsElux();
    KlarnaPageActionElux klarnaElux = new KlarnaPageActionElux();

    @Test(groups = {"smoke", "regression"}, description = "Verify Order summary page for checkout page_2")
    public void testForKlarna(){
        homePageActionsElux.navigateToHomePage();
        Assert.assertTrue(homePageActionsElux.isBrandLogoLoaded(), "Electrolux logo is not displayed on homepage");
        homePageActionsElux.isHomePageLoaded();
        orderSummaryElux.searchSku("ELFW7637AT");
        klarnaElux.clickOnProduct();
        electroluxProductCards.closeEmailPopUp();
        klarnaElux.clickOnAddToCart();
        orderSummaryElux.clickOnProceed();
        orderSummaryElux.shippingAddress("demo14@gmail.com", "Tom", "Walker", "28088","7894561234");
        klarnaElux.checkoutPage();
        klarnaElux.navigateToKlarnaWindow();
        Assert.assertTrue(klarnaElux.isTitleVisible(),"Title is not visible");
        ExtentReportManager.getTest().pass("Verify Klarna payment option ");
    }
}
