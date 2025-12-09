package com.automation.electrolux.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.electrolux.pages.EL_InstallationAndAddOnServices;
import com.automation.electrolux.pages.ElectroluxHomePageActions;
import com.automation.electrolux.pages.ElectroluxProductCards;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_07_TC_03_DeliveryAddOnService extends BaseTest {

    ElectroluxProductCards electroluxProductCards =new ElectroluxProductCards();
    ElectroluxHomePageActions electroluxHomePageActions = new ElectroluxHomePageActions();
    EL_InstallationAndAddOnServices elInstallationAndAddOnServices = new EL_InstallationAndAddOnServices();


    public void navigateToDSPageElectrolux() throws InterruptedException {
        electroluxHomePageActions.navigateToHomePage();
        electroluxProductCards.clickOnProductMenu("Laundry");
        electroluxProductCards.clickOnProductMenu("Washers");
        Assert.assertTrue(WebElementUtil.isDisplayed(By.xpath("//h1[normalize-space(text())='Washers']")), "Washers");
        elInstallationAndAddOnServices.clickProductBySKU("ELFW7537AW");
    }

    @Test(groups = {"smoke", "regression"}, priority = 1)
    public void  EPIC_04_PLP_TC_03_testForDelivery() throws InterruptedException {
        navigateToDSPageElectrolux();
        elInstallationAndAddOnServices.validateDeliveryOnlyIsAvailable();
        elInstallationAndAddOnServices.selectedDeliveryOnly();
        elInstallationAndAddOnServices.selectCheckBoxRequired();
        ExtentReportManager.getTest().pass("Verified Delivery only is available");
    }
    @Test(groups = {"smoke", "regression"}, priority = 2)
    public void  EPIC_04_PLP_TC_03_testDeliveryInstallation() throws InterruptedException {
        navigateToDSPageElectrolux();
        elInstallationAndAddOnServices.professionalInstallation();
        ExtentReportManager.getTest().pass("Verified Delivery Installation is available");
    }

    @Test(groups = {"smoke", "regression"}, priority = 3)
    public void  EPIC_04_PLP_TC_03_testForAddOnService() throws InterruptedException {
        navigateToDSPageElectrolux();
        elInstallationAndAddOnServices.validateAddOnServicesAreAvailable();
        elInstallationAndAddOnServices.validateDoorSwing();
        ExtentReportManager.getTest().pass("Verified Add on service is available");
    }

    @Test(groups = {"smoke", "regression"}, priority = 4)
    public void  EPIC_04_PLP_TC_03_testForHaul() throws InterruptedException {
        navigateToDSPageElectrolux();
        elInstallationAndAddOnServices.selectHaul();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'haul' is selected and check if the total price changes accordingly.");
    }

    @Test(groups = {"smoke", "regression"}, priority = 5)
    public void  EPIC_04_PLP_TC_03_testForMove() throws InterruptedException {
        navigateToDSPageElectrolux();
        elInstallationAndAddOnServices.moveOld();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'move' is selected and check if the total price changes accordingly.");
    }

    @Test(groups = {"smoke", "regression"}, priority = 6)
    public void  EPIC_04_PLP_TC_03_testForDoorSwing() throws InterruptedException {
        navigateToDSPageElectrolux();
        elInstallationAndAddOnServices.doorSwing();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'door swing' is selected and check if the total price changes accordingly.");
    }
    @Test(groups = {"smoke", "regression"}, priority = 7)
    public void  EPIC_04_PLP_TC_03_testForHaulAndMove() throws InterruptedException {
        navigateToDSPageElectrolux();
        elInstallationAndAddOnServices.haulAndMove();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'haul and move' is selected and check if the total price changes accordingly.");
    }
    @Test(groups = {"smoke", "regression"}, priority = 8)
    public void  EPIC_04_PLP_TC_03_testForHaulAndDoor() throws InterruptedException {
        navigateToDSPageElectrolux();
        elInstallationAndAddOnServices.haulAndDoor();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'haul and door' is selected and check if the total price changes accordingly.");
    }
    @Test(groups = {"smoke", "regression"}, priority = 9)
    public void  EPIC_04_PLP_TC_03_testForMoveAndDoor() throws InterruptedException {
        navigateToDSPageElectrolux();
        elInstallationAndAddOnServices.moveAndDoor();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'move and door' is selected and check if the total price changes accordingly.");
    }

    @Test(groups = {"smoke", "regression"}, priority = 10)
    public void  EPIC_04_PLP_TC_03_testForHaulMoveDoor() throws InterruptedException {
        navigateToDSPageElectrolux();
        elInstallationAndAddOnServices.haulMoveDoor();
        ExtentReportManager.getTest().pass("Verify that the Add-on service 'haul, move and door swing' is selected and check if the total price changes accordingly.");
    }

}
