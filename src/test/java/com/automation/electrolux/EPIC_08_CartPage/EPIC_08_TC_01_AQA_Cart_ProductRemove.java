package com.automation.electrolux.EPIC_08_CartPage;

import com.automation.BaseTest;
import com.automation.electrolux.pages.CartPageActionsElux;
import com.automation.electrolux.pages.DeliveryAndServicePageActionsElux;
import com.automation.electrolux.pages.HomePageActionsElux;
import com.automation.electrolux.pages.PdpPageActionsElux;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_08_TC_01_AQA_Cart_ProductRemove extends BaseTest {
    private final HomePageActionsElux homePage = new HomePageActionsElux();
    private final PdpPageActionsElux pdpPage = new PdpPageActionsElux();
    private final DeliveryAndServicePageActionsElux dnsPage = new DeliveryAndServicePageActionsElux();
    private final CartPageActionsElux cartPage = new CartPageActionsElux();


    @Test(groups = {"smoke", "regression"}, description = "Verify Product Remove from Cart page")
    public void EPIC_08_Cart_TC_01_verifyProductRemoveFromCart() {
        homePage.navigateToHomePage();
        WaitUtils.untilPageLoadComplete();
        homePage.clickSearchAndEnterProductId("ELFW7537AT");
        homePage.clickSearchIcon();
        homePage.clickProvidedProduct();
        pdpPage.clickAddToCartButton();
        dnsPage.clickSaveAndViewCartButton();
        cartPage.clickEmptyCartButton();

        Assert.assertTrue(cartPage.isYourCartEmptyTextVisibleAndCorrect("Your shopping cart is empty"), "Your shopping cart is empty text does not visible on page or Not matched with the expected one");

        ExtentReportManager.getTest().pass("Verify Product Remove From Cart page");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify Product Remove from Cart page")
    public void EPIC_08_Cart_TC_02_verifyProductRemoveFromCart() {
        homePage.navigateToHomePage();
        WaitUtils.untilPageLoadComplete();
        homePage.clickSearchAndEnterProductId("ELFW7537AT");
        homePage.clickSearchIcon();
        homePage.clickProvidedProduct();
        pdpPage.clickAddToCartButton();
        dnsPage.clickSaveAndViewCartButton();
        cartPage.clickRemoveFromCartButton();

        Assert.assertTrue(cartPage.isYourCartEmptyTextVisibleAndCorrect("Your shopping cart is empty"), "Your shopping cart is empty text does not visible on page or Not matched with the expected one");

        ExtentReportManager.getTest().pass("Verify Product Remove From Cart page");
    }
}
