package com.automation.fsus.EPIC_08_CartPage;

import com.automation.familystoreus.pages.CartUnavailableProductsFSUS;
import com.automation.familystoreus.pages.HomePageActionsFsus;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_08_TC_06_AQA_Cart_Error_message_for_Unavailable_Products {

    private final HomePageActionsFsus homePage = new HomePageActionsFsus();
    private final CartUnavailableProductsFSUS cartProductPage = new CartUnavailableProductsFSUS();
    private final LoginPageActionsFsus loginPage = new LoginPageActionsFsus();

    @Test(description = "Verify Error message from Cart for unavailable products")
    public void EPIC_08_Cart_TC_06_validateUnavailableProductsFromCart() {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
       // homePage.navigateToHomePage();
       // WaitUtils.untilPageLoadComplete();
        cartProductPage.clickOnKitchentext();
        cartProductPage.clickOnSingledoor();
        cartProductPage.clickOnrefrigeratoraddtocart();
        cartProductPage.clickOnSaveandcontinueshopping();
        cartProductPage.clickOnKitchentext();
        cartProductPage.clickOnInduction();
        cartProductPage.clickOnInductionaddtocart();
        cartProductPage.clickOnSaveandcontinueshopping();
        cartProductPage.clickOnKitchentext();
        cartProductPage.clickOnGas();
        cartProductPage.clickOnGasaddtocart();
        cartProductPage.clickOnSaveandcontinueshopping();
        cartProductPage.clickOnLaundrytext();
        cartProductPage.clickOnLaundrytext();
        cartProductPage.clickOnWasherstext();
        cartProductPage.clickOnWashersaddtocart();
        cartProductPage.clickOnSaveandviewcart();
        Assert.assertTrue(cartProductPage.verifyEmptycart(), "Empty cart text is not found.");


        ExtentReportManager.getTest().pass("Validate unavailable products on Cart page");

    }
}
