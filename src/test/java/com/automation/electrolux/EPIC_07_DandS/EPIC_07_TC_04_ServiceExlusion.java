package com.automation.electrolux.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.*;
import com.automation.utils.DriverManager;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;

public class EPIC_07_TC_04_ServiceExlusion extends BaseTest{
    InstallationAndAddOnServices installationAndAddOnServices = new InstallationAndAddOnServices();
    FrigidaireHomePageActions homePageActions = new FrigidaireHomePageActions();
    ProductListingPageActions productListingPageActions = new ProductListingPageActions();
    DSPageServiceExclusion dsPageServiceExclusion = new DSPageServiceExclusion();
    ProductItemsPageActions productItems = new ProductItemsPageActions();

    public void navigateToDSPageElectrolux() throws InterruptedException {
        homePageActions.navigateToHomePage();
        productListingPageActions.clickOnProductMenu("Laundry");
        productListingPageActions.clickOnProductMenu("Washers");
        productListingPageActions.verifyProductItemPage("Washers", "Washers");
        //productItems.closeEmailPopUp();
        installationAndAddOnServices.clickProductBySKU("ELFW7537AW","Electrolux");
    }

    @Test(groups = {"smoke", "regression"}, priority = 1)
    public void  EPIC_04_PLP_TC_03_testForFEDEX() throws InterruptedException {
        navigateToDSPageElectrolux();
        dsPageServiceExclusion.zipCodeChange("85062");
        dsPageServiceExclusion.zipCodePop();
        dsPageServiceExclusion.deliveryOnlyIsAvailable();
        dsPageServiceExclusion.installationUnavailable();
        ExtentReportManager.getTest().pass("Verified Delivery page after change the zip code for FEDEX/AIT");
        DriverManager.quitDriver();
    }
}
