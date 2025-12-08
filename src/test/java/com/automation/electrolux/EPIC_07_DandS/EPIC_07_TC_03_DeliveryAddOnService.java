package com.automation.electrolux.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.InstallationAndAddOnServices;
import com.automation.frigidaire.pages.ProductItemsPageActions;
import com.automation.frigidaire.pages.ProductListingPageActions;
import com.automation.utils.DriverManager;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;

public class EPIC_07_TC_03_DeliveryAddOnService extends BaseTest {

    InstallationAndAddOnServices installationAndAddOnServices = new InstallationAndAddOnServices();
    FrigidaireHomePageActions homePageActions = new FrigidaireHomePageActions();
    ProductListingPageActions productListingPageActions = new ProductListingPageActions();
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
    public void  EPIC_04_PLP_TC_03_testForDelivery() throws InterruptedException {
        navigateToDSPageElectrolux();
        installationAndAddOnServices.validateDeliveryOnlyIsAvailable();
        installationAndAddOnServices.selectedDeliveryOnly();
        installationAndAddOnServices.selectCheckBoxRequired();
        ExtentReportManager.getTest().pass("Verified Delivery only is available");
        DriverManager.quitDriver();
    }
    @Test(groups = {"smoke", "regression"}, priority = 2)
    public void  EPIC_04_PLP_TC_03_testDeliveryInstallation() throws InterruptedException {
        navigateToDSPageElectrolux();
        installationAndAddOnServices.professionalInstallation();
        ExtentReportManager.getTest().pass("Verified Delivery Installation is available");
        DriverManager.quitDriver();
    }

    @Test(groups = {"smoke", "regression"}, priority = 3)
    public void  EPIC_04_PLP_TC_03_testForAddOnService() throws InterruptedException {
        navigateToDSPageElectrolux();
        installationAndAddOnServices.validateAddOnServicesAreAvailable();
        installationAndAddOnServices.validateDoorSwing();
        ExtentReportManager.getTest().pass("Verified Add on service is available");
        DriverManager.quitDriver();
    }

    @Test(groups = {"smoke", "regression"}, priority = 4)
    public void  EPIC_04_PLP_TC_03_testForHaul() throws InterruptedException {
        navigateToDSPageElectrolux();
        installationAndAddOnServices.selectHaul();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'haul' is selected and check if the total price changes accordingly.");
        DriverManager.quitDriver();
    }

    @Test(groups = {"smoke", "regression"}, priority = 5)
    public void  EPIC_04_PLP_TC_03_testForMove() throws InterruptedException {
        navigateToDSPageElectrolux();
        installationAndAddOnServices.moveOld();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'move' is selected and check if the total price changes accordingly.");
        DriverManager.quitDriver();
    }

    @Test(groups = {"smoke", "regression"}, priority = 6)
    public void  EPIC_04_PLP_TC_03_testForDoorSwing() throws InterruptedException {
        navigateToDSPageElectrolux();
        installationAndAddOnServices.doorSwing();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'door swing' is selected and check if the total price changes accordingly.");
        DriverManager.quitDriver();
    }
    @Test(groups = {"smoke", "regression"}, priority = 7)
    public void  EPIC_04_PLP_TC_03_testForHaulAndMove() throws InterruptedException {
        navigateToDSPageElectrolux();
        installationAndAddOnServices.haulAndMove();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'haul and move' is selected and check if the total price changes accordingly.");

        DriverManager.quitDriver();
    }
    @Test(groups = {"smoke", "regression"}, priority = 8)
    public void  EPIC_04_PLP_TC_03_testForHaulAndDoor() throws InterruptedException {
        navigateToDSPageElectrolux();
        installationAndAddOnServices.haulAndDoor();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'haul and door' is selected and check if the total price changes accordingly.");
        DriverManager.quitDriver();
    }
    @Test(groups = {"smoke", "regression"}, priority = 9)
    public void  EPIC_04_PLP_TC_03_testForMoveAndDoor() throws InterruptedException {
        navigateToDSPageElectrolux();
        installationAndAddOnServices.moveAndDoor();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'move and door' is selected and check if the total price changes accordingly.");
        DriverManager.quitDriver();
    }

    @Test(groups = {"smoke", "regression"}, priority = 9)
    public void  EPIC_04_PLP_TC_03_testForHaulMoveDoor() throws InterruptedException {
        navigateToDSPageElectrolux();
        installationAndAddOnServices.haulMoveDoor();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'haul, move and door swing' is selected and check if the total price changes accordingly.");
        DriverManager.quitDriver();
    }

}
