package com.automation.fsus.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.DeliveryDatePageActionsFsus;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.PlpPageActionsFrig;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_06_AQA_PDP_Delivery_Dates_Fsus extends BaseTest {
    private final HomePageActionsFrig homePage = new HomePageActionsFrig();
    private final DeliveryDatePageActionsFsus pdpPage = new DeliveryDatePageActionsFsus();
    private final PlpPageActionsFrig plpPage = new PlpPageActionsFrig();
    private final LoginPageActionsFsus loginPage = new LoginPageActionsFsus();



    @Test(groups = {"regression"}, description = "Verify Delivery Dates availability on PDP page")
    public void verifyDeliveryDates() {
        loginPage.loginWithDefaultCredentials();
        homePage.navigateToHomePage();
        pdpPage.searchProduct("EHVS75S1AO");
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
