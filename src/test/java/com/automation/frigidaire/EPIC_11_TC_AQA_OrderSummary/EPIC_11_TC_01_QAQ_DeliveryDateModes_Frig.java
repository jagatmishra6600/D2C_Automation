package com.automation.frigidaire.EPIC_11_TC_AQA_OrderSummary;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.DeliveryDatePageActionsFrig;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.PlpPageActionsFrig;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_11_TC_01_QAQ_DeliveryDateModes_Frig extends BaseTest {
    private final HomePageActionsFrig homePage = new HomePageActionsFrig();
    private final DeliveryDatePageActionsFrig pdpPage = new DeliveryDatePageActionsFrig();
    private final PlpPageActionsFrig plpPage = new PlpPageActionsFrig();


    @Test(groups = {"regression"}, description = "Verify Delivery Dates and Shipping modes on checkout page 2")
    public void verifyDeliveryDates() {
        homePage.navigateToHomePage();
        pdpPage.searchProduct("GRMC2273CF-C1");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        pdpPage.clickAddToCart();
        homePage.navigateToHomePage();
        pdpPage.searchProduct("FHWC064TE1");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        pdpPage.clickAddToCart();
        pdpPage.clickSaveAndViewCart();
        homePage.navigateToHomePage();
        pdpPage.searchProduct("FHWW184WE2");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        pdpPage.clickAddToCart();
        pdpPage.clickSaveAndViewCart();
        pdpPage.selectDeliveryAndSaveAndViewCart();
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
