package com.automation.frigidaire.EPIC_12_Checkout3;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.PayPalPageActionsFrig;
import com.automation.frigidaire.pages.PlpPageActionsFrig;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Epic_12_TC_03_PayPal_Frig extends BaseTest {
    private final HomePageActionsFrig homePage = new HomePageActionsFrig();
    private final PayPalPageActionsFrig pdpPage = new PayPalPageActionsFrig();
    private final PlpPageActionsFrig plpPage = new PlpPageActionsFrig();


    @Test(groups = {"regression"}, description = "Verify Paypal Payment option on checkout page")
    public void verifyPayPalOption() {
        homePage.navigateToHomePage();
        pdpPage.searchProduct("GRMC2273CF-C1");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        pdpPage.clickAddToCart();
        pdpPage.selectDeliveryAndSaveAndViewCart();
        pdpPage.clickProceedToCheckout();
        pdpPage.clickContinueToDelivery();
        pdpPage.selectDeliverDate();
        pdpPage.clickOnContinueToBilling();
        pdpPage.clickPayWithPayPal();
        Assert.assertTrue(pdpPage.validatePayPalWindowOpened(), "PayPal window did not open as expected.");

        ExtentReportManager.getTest().pass("Verify Paypal Payment option on checkout page");
    }


}
