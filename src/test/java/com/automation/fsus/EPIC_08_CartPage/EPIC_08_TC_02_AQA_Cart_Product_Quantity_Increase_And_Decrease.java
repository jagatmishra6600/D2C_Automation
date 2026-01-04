package com.automation.fsus.EPIC_08_CartPage;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.*;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_08_TC_02_AQA_Cart_Product_Quantity_Increase_And_Decrease extends BaseTest {
    private final HomePageActionsFsus homePage = new HomePageActionsFsus();
    private final PdpPageActions_FSUS pdpPage = new PdpPageActions_FSUS();
    private final DeliveryAndServicePageAction_FSUS dnsPage = new DeliveryAndServicePageAction_FSUS();
    LoginPageActionsFsus loginPage = new LoginPageActionsFsus();
    private final CartPageAction_FSUS cartPage = new CartPageAction_FSUS();


    @Test(groups = {"smoke", "regression"}, description = "Verify Product Quantity Increase And Decrease In Cart")
    public void EPIC_08_Cart_TC_02_verifyQuantityIncreaseAndDecreaseFromCart() {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        homePage.clickSearchAndEnterProductId("FHWC064TE1");
        homePage.clickSearchIcon();
        homePage.clickProvidedProduct();
        pdpPage.clickViewCartButton();

        Assert.assertTrue(cartPage.increaseQuantityAndValidateCount(), "The quantity doesn't increase as expected");
        Assert.assertTrue(cartPage.decreaseQuantityAndValidateCount(), "The quantity doesn't decrease as expected");

        ExtentReportManager.getTest().pass("Verify Product Quantity Increase And Decrease In Cart");
    }
}
