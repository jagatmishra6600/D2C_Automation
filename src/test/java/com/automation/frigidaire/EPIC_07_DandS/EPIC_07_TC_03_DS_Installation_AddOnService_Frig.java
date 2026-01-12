package com.automation.frigidaire.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.InstallationAddOnServicesPageActionsFrig;
import com.automation.frigidaire.pages.OutOfStockPageActionsFrig;
import com.automation.frigidaire.pages.ProductDetailPageActionsFrig;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_07_TC_03_DS_Installation_AddOnService_Frig extends BaseTest {

    InstallationAddOnServicesPageActionsFrig installationAndAddOnServices = new InstallationAddOnServicesPageActionsFrig();
    HomePageActionsFrig homePage = new HomePageActionsFrig();
    ProductDetailPageActionsFrig productListingPageActions = new ProductDetailPageActionsFrig();
    OutOfStockPageActionsFrig productItems = new OutOfStockPageActionsFrig();


    public void navigateToDSPage() throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productListingPageActions.clickOnProductMenu("Kitchen");
        productListingPageActions.clickOnProductMenu("French Door");
        productListingPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        productItems.closeEmailPopUp();
        installationAndAddOnServices.clickProductBySKU("FRFG1723AV");
    }

    @Test(groups = {"smoke", "regression", "fg2"}, priority = 1)
    public void  EPIC_04_PLP_TC_03_testForDelivery() throws InterruptedException {
        navigateToDSPage();
        installationAndAddOnServices.validateDeliveryOnlyIsAvailable();
        installationAndAddOnServices.selectedDeliveryOnly();
        installationAndAddOnServices.selectCheckBoxRequired();
        ExtentReportManager.getTest().pass("Verified Delivery only is available");
    }
    @Test(groups = {"smoke", "regression", "fg2"}, priority = 2)
    public void  EPIC_04_PLP_TC_03_testForDeliveryInstallation() throws InterruptedException {
        navigateToDSPage();
        installationAndAddOnServices.deliveryInstallation();
        ExtentReportManager.getTest().pass("Verified Delivery Installation is available");
    }

    @Test(groups = {"smoke", "regression", "fg2"}, priority = 3)
    public void  EPIC_04_PLP_TC_03_testForAddOnService() throws InterruptedException {
        navigateToDSPage();
        installationAndAddOnServices.validateAddOnServicesAreAvailable();
        ExtentReportManager.getTest().pass("Verified Add on service is available");
    }

    @Test(groups = {"smoke", "regression", "fg2"}, priority = 4)
    public void  EPIC_04_PLP_TC_03_testForHaul() throws InterruptedException {
        navigateToDSPage();
        installationAndAddOnServices.selectHaul();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'haul' is selected and check if the total price changes accordingly.");
    }

    @Test(groups = {"smoke", "regression", "fg2"}, priority = 5)
    public void  EPIC_04_PLP_TC_03_testForMove() throws InterruptedException {
        navigateToDSPage();
        installationAndAddOnServices.moveOld();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'move' is selected and check if the total price changes accordingly.");
    }

    @Test(groups = {"smoke", "regression", "fg2"}, priority = 6)
    public void  EPIC_04_PLP_TC_03_testForHaulAndMove() throws InterruptedException {
        navigateToDSPage();
        installationAndAddOnServices.haulAndMove();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'haul and move' is selected and check if the total price changes accordingly.");
    }
}
