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

public class EPIC_08_TC_02_AQA_Cart_Product_Quantity_Increase_And_Decrease extends BaseTest {
    private final HomePageActionsElux homePage = new HomePageActionsElux();
    private final PdpPageActionsElux pdpPage = new PdpPageActionsElux();
    private final DeliveryAndServicePageActionsElux dnsPage = new DeliveryAndServicePageActionsElux();
    private final CartPageActionsElux cartPage = new CartPageActionsElux();


    @Test(groups = {"smoke", "regression"}, description = "Verify Product Quantity Increase And Decrease from Cart page")
    public void EPIC_08_Cart_TC_02_verifyQuantityIncreaseAndDecreaseFromCart() {
        homePage.navigateToHomePage();
        WaitUtils.untilPageLoadComplete();
        homePage.clickSearchAndEnterProductId("EL65522");
        homePage.clickSearchIconAndWaitForAccessProduct();
        homePage.clickAccesProduct();
        pdpPage.clickAddToCartButton();
        pdpPage.clickViewCartButton();

        Assert.assertTrue(cartPage.increaseQuantityAndValidateCount(), "The quantity doesn't increase as expected");
        Assert.assertTrue(cartPage.decreaseQuantityAndValidateCount(), "The quantity doesn't decrease as expected");

        ExtentReportManager.getTest().pass("Verify Product Quantity Increase And Decrease from Cart page");
    }
}
