package com.automation.fsus.EPIC_07_DandS;

import com.automation.BaseTest;

import com.automation.familystoreus.pages.DeliveryAndServicePageAction_FSUS;
import com.automation.familystoreus.pages.HomePageActionsFsus;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.familystoreus.pages.PdpPageActions_FSUS;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_01_AQA_Dnads_Productdetails extends BaseTest {

    private final HomePageActionsFsus homePage = new HomePageActionsFsus();
    private final PdpPageActions_FSUS pdpPage = new PdpPageActions_FSUS();
    private final DeliveryAndServicePageAction_FSUS dnsPage = new DeliveryAndServicePageAction_FSUS();
    LoginPageActionsFsus loginPage = new LoginPageActionsFsus();


    @Test(groups = {"smoke", "regression"}, description = "Verify product details on D&S page for French Door Refrigerator")
    public void EPIC_07_DandS_TC_01_verifyProductDetailsOnDeliveryAndServicePageForFrenchDoorRefrigerator() {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        homePage.clickSearchAndEnterProductId("FRFG1723AV");
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


        ExtentReportManager.getTest().pass("Verify product details on D&S page for French Door Refrigerator");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify product details ( Delivery and Services Section ) on D&S page for French Door Refrigerator")
    public void EPIC_07_DandS_TC_01_verifyDeliveryAndInstallationServicesSectionForFrenchDoorRefrigerator() {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
            homePage.clickSearchAndEnterProductId("FRFG1723AV");
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

            Assert.assertTrue(dnsPage.isAdditionalDetailsTextVisibleAndCorrect("Included with service:"), "Included with service: text does not display on Page or Not matched with expected text");

            dnsPage.clickCloseButtonAdditionalDetails();



        ExtentReportManager.getTest().pass("Verify product details ( Delivery and Services Section ) on D&S page for French Door Refrigerator");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify product details ( Add-on Services Section ) on D&S page for French Door Refrigerator")
    public void EPIC_07_DandS_TC_01_verifyAddonServicesSectionForFrenchDoorRefrigerator() {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
            homePage.clickSearchAndEnterProductId("FRFG1723AV");
            homePage.clickSearchIcon();
            homePage.clickProvidedProduct();
            pdpPage.clickAddToCartButton();

            Assert.assertTrue(dnsPage.isAddonServicesTextVisibleAndCorrect("Add-on Service"), "Add-on services does not visible on Delivery and service page");
            Assert.assertTrue(dnsPage.clickHaulAwayCheckBoxAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");
            Assert.assertTrue(dnsPage.clickMoveOldUnitCheckBoxAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");


        ExtentReportManager.getTest().pass("Verify product details ( Add-on Services Section ) on D&S page for French Door Refrigerator");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify product details ( Protection Plan Section ) on D&S page for French Door Refrigerator")
    public void EPIC_07_DandS_TC_01_verifyProtectionPlanSectionForFrenchDoorRefrigerator() {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
            homePage.clickSearchAndEnterProductId("FRFG1723AV");
            homePage.clickSearchIcon();
            homePage.clickProvidedProduct();
            pdpPage.clickAddToCartButton();

            Assert.assertTrue(dnsPage.isProtectionPlanTextVisibleAndCorrect("Protection plan"), "Select a protection plan does not visible on Delivery and service page");
            Assert.assertTrue(dnsPage.validateDeclineOptionIsSelected("active"), "The class name does not matched with the expected one");
            Assert.assertTrue(dnsPage.clickOneYearProtectionAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");
            Assert.assertTrue(dnsPage.clickThreeYearProtectionAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");
            Assert.assertTrue(dnsPage.clickFiveYearProtectionAndCheckTheUpdatedTotalPrice(), "The total price didn't matched after clicking action");



        ExtentReportManager.getTest().pass("Verify product details ( Protection Plan Section ) on D&S page for French Door Refrigerator");
    }
}
