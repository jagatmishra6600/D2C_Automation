package com.automation.frigidaire.EPIC_03_PDP;

import com.automation.frigidaire.pages.DeliveryDatePageActionsFrig;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.PlpPageActionsFrig;
import com.automation.BaseTest;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_06_AQA_PDP_Delivery_Dates_Frig extends BaseTest {
    private final HomePageActionsFrig homePage = new HomePageActionsFrig();
    private final DeliveryDatePageActionsFrig pdpPage = new DeliveryDatePageActionsFrig();
    private final PlpPageActionsFrig plpPage = new PlpPageActionsFrig();



    @Test(groups = {"regression"}, description = "Verify Delivery Dates availability on checkout page")
    public void verifyDeliveryDates() {
        homePage.navigateToHomePage();
        pdpPage.searchProduct("GRMC2273CF-C1");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        pdpPage.clickAddToCart();
        pdpPage.selectDeliveryAndSaveAndViewCart();
        pdpPage.clickProceedToCheckout();
        pdpPage.clickContinueToDelivery();
        Assert.assertTrue(pdpPage.validateAllAvailableDeliveryDates(), "Delivery date is not available or not clickable");

        ExtentReportManager.getTest().pass("Verify Delivery Dates availability on checkout page");
    }

}
