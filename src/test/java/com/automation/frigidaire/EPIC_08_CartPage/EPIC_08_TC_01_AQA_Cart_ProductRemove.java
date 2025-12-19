package com.automation.frigidaire.EPIC_08_CartPage;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.*;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_08_TC_01_AQA_Cart_ProductRemove extends BaseTest {
    private final HomePageActionsFrig homePage = new HomePageActionsFrig();
    private final PdpPageActionsFrig pdpPage = new PdpPageActionsFrig();
    private final PlpPageActionsFrig plpPage = new PlpPageActionsFrig();
    private final DAndSPageActionsFrig dnsPage = new DAndSPageActionsFrig();
    private final CartPageActionsFrig cartPage = new CartPageActionsFrig();


    @Test(groups = {"smoke", "regression"}, description = "Verify Product Remove from Cart page")
    public void EPIC_08_Cart_TC_01_verifyProductRemoveFromCart() {
        homePage.navigateToHomePage();
        WaitUtils.untilPageLoadComplete();
        homePage.clickFrenchDoor();
        plpPage.closePopupModel();
        plpPage.clickProvidedProduct();
        pdpPage.clickDeliveryOption();
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
        homePage.clickFrenchDoor();
        plpPage.closePopupModel();
        plpPage.clickProvidedProduct();
        pdpPage.clickDeliveryOption();
        pdpPage.clickAddToCartButton();
        dnsPage.clickSaveAndViewCartButton();
        cartPage.clickRemoveFromCartButton();

        Assert.assertTrue(cartPage.isYourCartEmptyTextVisibleAndCorrect("Your shopping cart is empty"), "Your shopping cart is empty text does not visible on page or Not matched with the expected one");

        ExtentReportManager.getTest().pass("Verify Product Remove From Cart page");
    }
}
