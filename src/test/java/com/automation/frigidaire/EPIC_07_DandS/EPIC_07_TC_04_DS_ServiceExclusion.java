package com.automation.frigidaire.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.*;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_07_TC_04_DS_ServiceExclusion extends BaseTest {

    InstallationAddOnServicesPageActionFrig installationAndAddOnServices = new InstallationAddOnServicesPageActionFrig();
    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductDetailPageActionFrig productListingPageActions = new ProductDetailPageActionFrig();
    DSPServiceExclusionPageActionFrig dsPageServiceExclusion = new DSPServiceExclusionPageActionFrig();
    OutOfStockPageActionFrig productItems = new OutOfStockPageActionFrig();


    @Test(groups = {"smoke", "regression"})
    public void  EPIC_04_PLP_TC_03_DeliveryService() throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productListingPageActions.clickOnProductMenu("Kitchen");
        productListingPageActions.clickOnProductMenu("French Door");
        productListingPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        productItems.closeEmailPopUp();
        installationAndAddOnServices.clickProductBySKU("FRFG1723AV");
        dsPageServiceExclusion.zipCodeChange("85062");
        dsPageServiceExclusion.zipCodePop();
        dsPageServiceExclusion.deliveryOnlyIsAvailable();
        dsPageServiceExclusion.installationUnavailable();
        ExtentReportManager.getTest().pass("Verified Delivery page after change the zip code for FEDEX/AIT");
    }
}
