package com.automation.electrolux.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.electrolux.pages.*;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_01_AQA_Dnads_Productdetails extends BaseTest {

    private final ElectroluxHomePageActions homePage = new ElectroluxHomePageActions();
    private final ElectroluxPdpPageActions pdpPage = new ElectroluxPdpPageActions();
    private final DeliveryAndServicePageActionElux dnsPage = new DeliveryAndServicePageActionElux();


    @Test(groups = {"smoke", "regression"}, description = "Verify product details on D&S page for Front Load Washer")
    public void EPIC_07_DandS_TC_01_verifyProductDetailsOnDeliveryAndServicePageForFrontLoadWasher() {
        homePage.navigateToHomePage();
        WaitUtils.untilPageLoadComplete();
        homePage.clickSearchAndEnterProductId("ELFW7537AT");
        homePage.clickSearchIcon();
        homePage.storeProvidedProductId();
        homePage.storeProvidedProductTitle();
        homePage.storeProvidedProductPrice();
        homePage.clickProvidedProduct();
        pdpPage.clickAddToCartButton();

        Assert.assertTrue(dnsPage.isDeliveryAndServicePageHeadingVisibleAndCorrect("Delivery, installation & service options"), "Delivery, installation & service options does not visible on Delivery and service page");
        Assert.assertTrue(dnsPage.isProductTitleMatchingWithHomePage(), "Product Title on DandS does not match the selected product from Home Page.");
        Assert.assertTrue(dnsPage.isProductPriceMatchingWithHomePage(), "Product Price on DNS does not match the selected product from Home Page.");
        Assert.assertTrue(dnsPage.isDeliveryAndServiceTextVisibleAndCorrect("Delivery & installation services"), "Delivery & installation services does not display on Page or Not matched with expected text");
//            Assert.assertTrue(dnsPage.validateDeliveryOptionIsSelected("selected"), "Selected delivery option does not display on Page or Not matched with expected class name");


        ExtentReportManager.getTest().pass("Verify product details on D&S page for Front Load Washer");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify product details ( Delivery and Services Section ) on D&S page for Front Load Washer")
    public void EPIC_07_DandS_TC_01_verifyDeliveryAndInstallationServicesSectionForFrontLoadWasher() {
        homePage.navigateToHomePage();
        WaitUtils.untilPageLoadComplete();
        homePage.clickSearchAndEnterProductId("ELFW7537AT");
        homePage.clickSearchIcon();
        homePage.clickProvidedProduct();
        pdpPage.clickAddToCartButton();

        Assert.assertTrue(dnsPage.isDeliveryAndServicePageHeadingVisibleAndCorrect("Delivery, installation & service options"), "Delivery, installation & service options does not visible on Delivery and service page");
        Assert.assertTrue(dnsPage.isDeliveryAndServiceTextVisibleAndCorrect("Delivery & installation services"), "Delivery and installation services text does not display on Page or Not matched with expected text");
        Assert.assertTrue(dnsPage.clickDeliveryOnlyAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");
        Assert.assertTrue(dnsPage.isRequireInstallationPartsTextVisibleAndCorrect("Required installation parts"), "Required installation parts text does not display on Page or Not matched with expected text");
        Assert.assertTrue(dnsPage.clickPartAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");
        Assert.assertTrue(dnsPage.clickProfessionalInstallationAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");

        dnsPage.clickAdditionalDetailsLink();

        Assert.assertTrue(dnsPage.isAdditionalDetailsTextVisibleAndCorrect("Delivery & appliance install"), "Delivery & appliance install text does not display on Page or Not matched with expected text");

        dnsPage.clickCloseButtonAdditionalDetails();



        ExtentReportManager.getTest().pass("Verify product details ( Delivery and Services Section ) on D&S page for Front Load Washer");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify product details ( Add-on Services Section ) on D&S page for Front Load Washer")
    public void EPIC_07_DandS_TC_01_verifyAddonServicesSectionForFrontLoadWasher() {
        homePage.navigateToHomePage();
        WaitUtils.untilPageLoadComplete();
        homePage.clickSearchAndEnterProductId("ELFW7537AT");
        homePage.clickSearchIcon();
        homePage.clickProvidedProduct();
        pdpPage.clickAddToCartButton();

        Assert.assertTrue(dnsPage.isAddonServicesTextVisibleAndCorrect("Add-on Services"), "Add-on services does not visible on Delivery and service page");
        Assert.assertTrue(dnsPage.clickHaulAwayCheckBoxAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");
        Assert.assertTrue(dnsPage.clickMoveOldUnitCheckBoxAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");
        Assert.assertTrue(dnsPage.clickDoorSwingCheckBoxAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");


        ExtentReportManager.getTest().pass("Verify product details ( Add-on Services Section ) on D&S page for Front Load Washer");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify product details ( Protection Plan Section ) on D&S page for Front Load Washer")
    public void EPIC_07_DandS_TC_01_verifyProtectionPlanSectionForFrontLoadWasher() {
        homePage.navigateToHomePage();
        WaitUtils.untilPageLoadComplete();
        homePage.clickSearchAndEnterProductId("ELFW7537AT");
        homePage.clickSearchIcon();
        homePage.clickProvidedProduct();
        pdpPage.clickAddToCartButton();

        Assert.assertTrue(dnsPage.isProtectionPlanTextVisibleAndCorrect("Select a protection plan"), "Select a protection plan does not visible on Delivery and service page");
        Assert.assertTrue(dnsPage.validateDeclineOptionIsSelected("active"), "The class name does not matched with the expected one");
        Assert.assertTrue(dnsPage.clickOneYearProtectionAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");
        Assert.assertTrue(dnsPage.clickThreeYearProtectionAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");
        Assert.assertTrue(dnsPage.clickFiveYearProtectionAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");


        ExtentReportManager.getTest().pass("Verify product details ( Protection Plan Section ) on D&S page for Front Load Washer");
    }
}
