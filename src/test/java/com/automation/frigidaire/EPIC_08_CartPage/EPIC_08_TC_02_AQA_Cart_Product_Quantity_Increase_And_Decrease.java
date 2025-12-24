package com.automation.frigidaire.EPIC_08_CartPage;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.*;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_08_TC_02_AQA_Cart_Product_Quantity_Increase_And_Decrease extends BaseTest {
    private final HomePageActionsFrig homePage = new HomePageActionsFrig();
    private final PdpPageActionsFrig pdpPage = new PdpPageActionsFrig();
    private final PlpPageActionsFrig plpPage = new PlpPageActionsFrig();
    private final DAndSPageActionsFrig dnsPage = new DAndSPageActionsFrig();
    private final CartPageActionsFrig cartPage = new CartPageActionsFrig();


    @Test(groups = {"smoke", "regression"}, description = "Verify Product Quantity Increase And Decrease from Cart page")
    public void EPIC_08_Cart_TC_02_verifyQuantityIncreaseAndDecreaseFromCart() {
        homePage.navigateToHomePage();
        WaitUtils.untilPageLoadComplete();
        homePage.clickSearchAndEnterProductId("IM117000");
        homePage.clickSearchIconAndWaitForAccessProduct();
        homePage.clickAccesProduct();
        pdpPage.clickAddToCart();
        pdpPage.clickViewCartButton();

        Assert.assertTrue(cartPage.increaseQuantityAndValidateCount(), "The quantity doesn't increase as expected");
        Assert.assertTrue(cartPage.decreaseQuantityAndValidateCount(), "The quantity doesn't decrease as expected");

        ExtentReportManager.getTest().pass("Verify Product Quantity Increase And Decrease from Cart page");
    }
}
