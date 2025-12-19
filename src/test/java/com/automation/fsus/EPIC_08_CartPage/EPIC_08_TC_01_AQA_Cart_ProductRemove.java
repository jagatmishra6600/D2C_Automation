package com.automation.fsus.EPIC_08_CartPage;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.*;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_08_TC_01_AQA_Cart_ProductRemove extends BaseTest {
    private final HomePageActionsFsus homePage = new HomePageActionsFsus();
    private final PdpPageActions_FSUS pdpPage = new PdpPageActions_FSUS();
    private final DeliveryAndServicePageAction_FSUS dnsPage = new DeliveryAndServicePageAction_FSUS();
    LoginPageActionsFsus loginPage = new LoginPageActionsFsus();
    private final CartPageAction_FSUS cartPage = new CartPageAction_FSUS();


    @Test(groups = {"smoke", "regression"}, description = "Verify Product Remove from Cart page for French Door Refrigerator")
    public void EPIC_08_Cart_TC_01_verifyProductRemoveFromCartForFrenchDoorRefrigerator() {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        homePage.clickSearchAndEnterProductId("FRFG1723AV");
        homePage.clickSearchIcon();
        homePage.clickProvidedProduct();
        pdpPage.clickAddToCartButton();
        dnsPage.clickSaveAndViewCartButton();
        cartPage.clickProceedToCheckOutButton();
        cartPage.clickEmptyCartButton();

        Assert.assertTrue(cartPage.isYourCartEmptyTextVisibleAndCorrect("Your shopping cart is empty"), "Your shopping cart is empty text does not visible on page or Not matched with the expected one");

        ExtentReportManager.getTest().pass("Verify Product Remove From Cart page for French Door Refrigerator");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify Product Remove from Cart page for French Door Refrigerator")
    public void EPIC_08_Cart_TC_02_verifyProductRemoveFromCartForFrenchDoorRefrigerator() {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        homePage.clickSearchAndEnterProductId("FRFG1723AV");
        homePage.clickSearchIcon();
        homePage.clickProvidedProduct();
        pdpPage.clickAddToCartButton();
        dnsPage.clickSaveAndViewCartButton();
        cartPage.clickProceedToCheckOutButton();
        cartPage.clickRemoveFromCartButton();

        Assert.assertTrue(cartPage.isYourCartEmptyTextVisibleAndCorrect("Your shopping cart is empty"), "Your shopping cart is empty text does not visible on page or Not matched with the expected one");

        ExtentReportManager.getTest().pass("Verify Product Remove From Cart page for French Door Refrigerator");
    }
}
