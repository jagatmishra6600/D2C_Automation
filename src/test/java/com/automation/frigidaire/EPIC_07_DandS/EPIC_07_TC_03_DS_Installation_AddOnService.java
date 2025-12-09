package com.automation.frigidaire.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.InstallationAndAddOnServices;
import com.automation.frigidaire.pages.ProductItemsPageActions;
import com.automation.frigidaire.pages.ProductListingPageActions;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_07_TC_03_DS_Installation_AddOnService extends BaseTest {

    InstallationAndAddOnServices installationAndAddOnServices = new InstallationAndAddOnServices();
    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductListingPageActions productListingPageActions = new ProductListingPageActions();
    ProductItemsPageActions productItems = new ProductItemsPageActions();


    public void navigateToDSPage() throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productListingPageActions.clickOnProductMenu("Kitchen");
        productListingPageActions.clickOnProductMenu("French Door");
        productListingPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        productItems.closeEmailPopUp();
        installationAndAddOnServices.clickProductBySKU("FRFG1723AV");
    }

    @Test(groups = {"smoke", "regression"}, priority = 1)
    public void  EPIC_04_PLP_TC_03_testForDelivery() throws InterruptedException {
        navigateToDSPage();
        installationAndAddOnServices.validateDeliveryOnlyIsAvailable();
        installationAndAddOnServices.selectedDeliveryOnly();
        installationAndAddOnServices.selectCheckBoxRequired();
        ExtentReportManager.getTest().pass("Verified Delivery only is available");
    }
    @Test(groups = {"smoke", "regression"}, priority = 2)
    public void  EPIC_04_PLP_TC_03_testForDeliveryInstallation() throws InterruptedException {
        navigateToDSPage();
        installationAndAddOnServices.deliveryInstallation();
        ExtentReportManager.getTest().pass("Verified Delivery Installation is available");
    }

    @Test(groups = {"smoke", "regression"}, priority = 3)
    public void  EPIC_04_PLP_TC_03_testForAddOnService() throws InterruptedException {
        navigateToDSPage();
        installationAndAddOnServices.validateAddOnServicesAreAvailable();
        ExtentReportManager.getTest().pass("Verified Add on service is available");
    }

    @Test(groups = {"smoke", "regression"}, priority = 4)
    public void  EPIC_04_PLP_TC_03_testForHaul() throws InterruptedException {
        navigateToDSPage();
        installationAndAddOnServices.selectHaul();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'haul' is selected and check if the total price changes accordingly.");
    }

    @Test(groups = {"smoke", "regression"}, priority = 5)
    public void  EPIC_04_PLP_TC_03_testForMove() throws InterruptedException {
        navigateToDSPage();
        installationAndAddOnServices.moveOld();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'move' is selected and check if the total price changes accordingly.");
    }

    @Test(groups = {"smoke", "regression"}, priority = 6)
    public void  EPIC_04_PLP_TC_03_testForHaulAndMove() throws InterruptedException {
        navigateToDSPage();
        installationAndAddOnServices.haulAndMove();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'haul and move' is selected and check if the total price changes accordingly.");
    }
}
