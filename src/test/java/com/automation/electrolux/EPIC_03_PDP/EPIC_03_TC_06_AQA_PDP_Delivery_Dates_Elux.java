package com.automation.electrolux.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.electrolux.pages.DeliveryDatePageActionsElux;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.PlpPageActionsFrig;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_06_AQA_PDP_Delivery_Dates_Elux extends BaseTest {
    private final HomePageActionsFrig homePage = new HomePageActionsFrig();
    private final DeliveryDatePageActionsElux pdpPage = new DeliveryDatePageActionsElux();
    private final PlpPageActionsFrig plpPage = new PlpPageActionsFrig();



    @Test(groups = {"regression"}, description = "Verify Delivery Dates availablity on PDP page")
    public void verifyDeliveryDates() {
        homePage.navigateToHomePage();
        pdpPage.searchProduct("ELFW7537AW");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        pdpPage.clickAddToCart();
        pdpPage.clickProceedToCheckout();
        pdpPage.clickContinueToDelivery();
        Assert.assertTrue(pdpPage.validateAllAvailableDeliveryDates(), "Delivery date is not available or not clickable");
    }

}
