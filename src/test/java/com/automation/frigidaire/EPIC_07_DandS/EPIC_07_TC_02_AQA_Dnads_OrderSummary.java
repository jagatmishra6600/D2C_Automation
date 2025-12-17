package com.automation.frigidaire.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.*;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_07_TC_02_AQA_Dnads_OrderSummary extends BaseTest {

    private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    private final FrigidairePdpPageActions pdpPage = new FrigidairePdpPageActions();
    private final PlpPageActions_Frig plpPage = new PlpPageActions_Frig();
    private final FrigidaireDAndSPageActions dnsPage = new FrigidaireDAndSPageActions();

    @Test(groups = {"smoke", "regression"}, description = "Verify Order summary ( Delivery and Services Section ) on D&S page for French Door Refrigerator")
    public void EPIC_07_DandS_TC_01_verifyDeliveryAndInstallationServicesSectionForFrenchDoorRefrigerator() {
        homePage.navigateToHomePage();
        WaitUtils.untilPageLoadComplete();
        homePage.clickFrenchDoor();
        plpPage.closePopupModel();
        plpPage.clickProvidedProduct();
        pdpPage.clickDeliveryOption();
        pdpPage.clickAddToCartButton();

        Assert.assertTrue(dnsPage.isItemAddedToCartVisibleOnDnSPage("Item added to cart"), "Item Added To Cart does not visible on Delivery and service page");
        Assert.assertTrue(dnsPage.validateDeliveryOptionIsSelected("selected"), "Selected delivery option does not display on Page or Not matched with expected class name");
        Assert.assertTrue(dnsPage.isDeliveryAndServicesTextVisibleAndCorrect("Delivery & installation services"), "Delivery and installation services text does not display on Page or Not matched with expected text");
        Assert.assertTrue(dnsPage.clickDeliveryOnlyAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");
        Assert.assertTrue(dnsPage.isRequireInstallationPartsTextVisibleAndCorrect("Required installation parts"), "Required installation parts text does not display on Page or Not matched with expected text");
        Assert.assertTrue(dnsPage.clickPartAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");
        Assert.assertTrue(dnsPage.clickDeliveryAndInstallationAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");


        ExtentReportManager.getTest().pass("Verify order summary ( Delivery and Services Section ) on D&S page for French Door Refrigerator");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify order summary ( Add-on Services Section ) on D&S page for French Door Refrigerator")
    public void EPIC_07_DandS_TC_01_verifyAddonServicesSectionForFrenchDoorRefrigerator() {
        homePage.navigateToHomePage();
        WaitUtils.untilPageLoadComplete();
        homePage.clickFrenchDoor();
        plpPage.closePopupModel();
        plpPage.clickProvidedProduct();
        pdpPage.clickDeliveryOption();
        pdpPage.clickAddToCartButton();

        Assert.assertTrue(dnsPage.isAddonServicesTextVisibleAndCorrect("Add-on services"), "Add-on services does not visible on Delivery and service page");
        Assert.assertTrue(dnsPage.clickHaulAwayCheckBoxAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");
        Assert.assertTrue(dnsPage.clickMoveOldUnitCheckBoxAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");
        ExtentReportManager.getTest().pass("Verify Order summary ( Add-on Services Section ) on D&S page for French Door Refrigerator");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify Order summary ( Protection Plan Section ) on D&S page for French Door Refrigerator")
    public void EPIC_07_DandS_TC_01_verifyProtectionPlanSectionForFrenchDoorRefrigerator() {
        homePage.navigateToHomePage();
        WaitUtils.untilPageLoadComplete();
        homePage.clickFrenchDoor();
        plpPage.closePopupModel();
        plpPage.clickProvidedProduct();
        pdpPage.clickDeliveryOption();
        pdpPage.clickAddToCartButton();

        Assert.assertTrue(dnsPage.isProtectionPlanTextVisibleAndCorrect("Select a protection plan"), "Select a protection plan does not visible on Delivery and service page");
        Assert.assertTrue(dnsPage.validateDeclineOptionIsSelected("active"), "The class name does not matched with the expected one");
        Assert.assertTrue(dnsPage.clickOneYearProtectionAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");
        Assert.assertTrue(dnsPage.clickThreeYearProtectionAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");
        Assert.assertTrue(dnsPage.clickFiveYearProtectionAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");

        ExtentReportManager.getTest().pass("Verify Order summary ( Protection Plan Section ) on D&S page for French Door Refrigerator");
    }
}
