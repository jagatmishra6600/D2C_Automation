package com.automation.electrolux.EPIC_08_CartPage;

import com.automation.BaseTest;
import com.automation.electrolux.pages.*;
import com.automation.frigidaire.pages.*;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_08_TC_04_AQA_Cart_Promo_Code_Elux extends BaseTest {
    private final HomePageActionsElux homePage = new HomePageActionsElux();
    private final CartPageActionsElux page = new CartPageActionsElux();
    private final DeliveryDatePageActionsElux dpage = new DeliveryDatePageActionsElux();
    private final PlpPageActionsElux plpPage = new PlpPageActionsElux();
    private final CheckoutPageActionsElux cpage = new CheckoutPageActionsElux();


    @Test(groups = {"regression"}, description = "Verify No eligible Promo Code message on Cart Page")
    public void verifyNotEligiblePromoCode() {
        homePage.navigateToHomePage();
        dpage.searchProduct("ELFW7537AW");
        dpage.selectProductFromPLP();
        plpPage.closePopupModel();
        dpage.clickAddToCart();
        page.clickOnPromoDropdown();
        page.applyPromoCode("TESTING10");
        Assert.assertEquals(page.getPromoErrorMessage(), "No eligible items in cart", "Unable to validate not eligible Promo Code");

        ExtentReportManager.getTest().pass("Verify No eligible Promo Code message on Cart Page");
    }

    @Test(groups = {"regression"}, description = "Verify Invalid Promo Code message on Cart Page")
    public void verifyInvalidEligiblePromoCode() {
        homePage.navigateToHomePage();
        dpage.searchProduct("ELFW7537AW");
        dpage.selectProductFromPLP();
        plpPage.closePopupModel();
        dpage.clickAddToCart();
        page.clickOnPromoDropdown();
        page.applyPromoCode("INVALID PROMO CODE");
        Assert.assertEquals(page.getPromoErrorMessage(), "Promo Code INVALID PROMO CODE is invalid", "Unable to validate Invalid Promo code");

        ExtentReportManager.getTest().pass("Verify No eligible Promo Code message on Cart Page");
    }

    @Test(groups = {"regression"}, description = "Verify Expired Promo Code message on Cart Page")
    public void verifyExpiredPromoCode() {
        homePage.navigateToHomePage();
        dpage.searchProduct("ELFW7537AW");
        dpage.selectProductFromPLP();
        plpPage.closePopupModel();
        dpage.clickAddToCart();
        page.clickOnPromoDropdown();
        page.applyPromoCode("COOL10");
        Assert.assertEquals(page.getPromoErrorMessage(), "Promo Code COOL10 is expired", "Promo code is not expired");

        ExtentReportManager.getTest().pass("Verify Expired Promo Code message on Cart Page");
    }


}
