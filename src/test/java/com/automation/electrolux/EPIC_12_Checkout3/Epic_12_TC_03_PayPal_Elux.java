package com.automation.electrolux.EPIC_12_Checkout3;

import com.automation.BaseTest;
import com.automation.electrolux.pages.PayPalPageActionsElux;
import com.automation.electrolux.pages.PlpPageActionsElux;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Epic_12_TC_03_PayPal_Elux extends BaseTest {
    private final HomePageActionsFrig homePage = new HomePageActionsFrig();
    private final PayPalPageActionsElux pdpPage = new PayPalPageActionsElux();
    private final PlpPageActionsElux plpPage = new PlpPageActionsElux();


    @Test(groups = {"regression"}, description = "Verify Paypal Payment option on checkout page")
    public void verifyDeliveryDates() {
        homePage.navigateToHomePage();
        pdpPage.searchProduct("ELFW7537AW");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        pdpPage.clickAddToCart();
        pdpPage.clickSaveAndViewCart();
        pdpPage.clickProceedToCheckout();
        pdpPage.clickContinueToDelivery();
        pdpPage.selectDeliverDate();
        pdpPage.clickOnContinueToBilling();
        pdpPage.clickPayWithPayPal();
        Assert.assertTrue(pdpPage.validatePayPalWindowOpened(), "PayPal window did not open as expected.");

        ExtentReportManager.getTest().pass("Verify Paypal Payment option on checkout page");
    }


}
