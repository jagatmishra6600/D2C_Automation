package com.automation.fsus.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.DeliveryDatePageActionsFsus;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.FrigidairePlpPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_06_AQA_PDP_Delivery_Dates_Fsus extends BaseTest {
    private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    private final DeliveryDatePageActionsFsus pdpPage = new DeliveryDatePageActionsFsus();
    private final FrigidairePlpPageActions plpPage = new FrigidairePlpPageActions();



    @Test(groups = {"regression"}, description = "Verify Delivery Dates availablity on PDP page")
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
    }

}
