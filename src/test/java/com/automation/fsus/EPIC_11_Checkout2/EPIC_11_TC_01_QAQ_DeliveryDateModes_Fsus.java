package com.automation.fsus.EPIC_11_Checkout2;

import com.automation.BaseTest;
import com.automation.electrolux.pages.DeliveryDatePageActionsElux;
import com.automation.electrolux.pages.HomePageActionsElux;
import com.automation.electrolux.pages.PlpPageActionsElux;
import com.automation.familystoreus.pages.DeliveryDatePageActionsFsus;
import com.automation.familystoreus.pages.HomePageActionsFsus;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.familystoreus.pages.PlpPageActions_FSUS;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_11_TC_01_QAQ_DeliveryDateModes_Fsus extends BaseTest {
    private final HomePageActionsFsus homePage = new HomePageActionsFsus();
    private final DeliveryDatePageActionsFsus pdpPage = new DeliveryDatePageActionsFsus();
    private final PlpPageActions_FSUS plpPage = new PlpPageActions_FSUS();
    private final LoginPageActionsFsus loginPage = new LoginPageActionsFsus();


    @Test(groups = {"regression"}, description = "Verify Delivery Dates and Shipping modes on checkout page 2")
    public void verifyDeliveryDates() {
        loginPage.loginWithDefaultCredentials();
        homePage.navigateToHomePage();
        pdpPage.searchProduct("ELFW7537AW");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        pdpPage.clickAddToCart();
        homePage.navigateToHomePage();
        pdpPage.searchProduct("EHAW6020AG");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        pdpPage.clickAddToCart();
        homePage.navigateToHomePage();
        pdpPage.searchProduct("EHAW4010AG");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        pdpPage.clickAddToCart();
        pdpPage.clickProceedToCheckout();
        pdpPage.clickContinueToDelivery();
        Assert.assertTrue(pdpPage.validateCurrentDeliveryMonths(), "Current Month is not available");
        Assert.assertTrue(pdpPage.validateNextDeliveryMonths(), "Next Month is not available");
        Assert.assertTrue(pdpPage.validateUnavailableDatesAreGreyedAndNotSelectable(), "Unavailable dates are selectable");
        Assert.assertTrue(pdpPage.validateContinueToBillingEnabledOnDateSelection(), "Continue to Billing is not enabled on date selection");
        Assert.assertTrue(pdpPage.validateDeliveryCommentsBelowCalendar(), "Delivery Comments box is not available below calendar");
        Assert.assertTrue(pdpPage.validateOnlyOneCalendarDateSelection(), "More than one date can be selected in calendar");
        Assert.assertTrue(pdpPage.isEachLineItemDisplayedInItsOwnTile(), "Each line item is not displayed in its own tile");
        Assert.assertTrue(pdpPage.areParcelItemPricesDisplayed(), "Parcel item prices are not displayed");
        Assert.assertTrue(pdpPage.areParcelItemImagesDisplayed(), "Parcel item images are not displayed");
        Assert.assertTrue(pdpPage.areParcelItemSKUsDisplayed(), "Parcel item SKUs are not displayed");
        Assert.assertTrue(pdpPage.areParcelItemColorsDisplayed(), "Parcel item colors are not displayed");
        Assert.assertTrue(pdpPage.areParcelItemQuantitiesDisplayed(), "Parcel item quantities are not displayed");
        Assert.assertTrue(pdpPage.isAirConditionerShippingMessageDisplayed(), "Air Conditioner shipping message is not displayed");


        ExtentReportManager.getTest().pass("Verify Delivery Dates and Shipping modes on checkout page 2");
    }


}
