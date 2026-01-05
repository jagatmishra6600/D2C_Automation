package com.automation.fsus.EPIC_10_Checkout1;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.*;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_10_TC04AQAOrderSummary_TC_03_AQA_CheckoutPageOrderItems_Fsus extends BaseTest {
    private final HomePageActionsFsus homePage = new HomePageActionsFsus();
    private final CheckoutPageActionsFsus page = new CheckoutPageActionsFsus();
    private final DeliveryDatePageActionsFsus dpage = new DeliveryDatePageActionsFsus();
    private final PlpPageActions_FSUS plpPage = new PlpPageActions_FSUS();
    private final LoginPageActionsFsus loginPage = new LoginPageActionsFsus();

    @Test(groups = {"regression"}, description = "Verify Order Items on Checkout page 1")
    public void verifyDeliveryDates() {
        loginPage.loginWithDefaultCredentials();
        homePage.navigateToHomePage();
        dpage.searchProduct("EHVS2510AW-C1");
        dpage.selectProductFromPLP();
        plpPage.closePopupModel();
        dpage.clickAddToCart();
        dpage.clickProceedToCheckout();
        Assert.assertTrue(page.isDeliveryTypeBannerVisible(), "Delivery Type Banner is not visible");
        Assert.assertTrue(page.orderItemNameIsVisible(), "Order Item Title is not visible");
        Assert.assertTrue(page.isSKUVisible(), "Order Item SKU is not visible");
        Assert.assertTrue(page.isQtyVisible(), "Order Item Quantity is not visible");
        Assert.assertTrue(page.isOrderPriceVisible(), "Order Item Price is not visible");
        Assert.assertTrue(page.isDiscountPricePriceVisible(), "Order Item Discount Price is not visible");
        Assert.assertTrue(page.isIncludedSectionVisible(), "Included in your purchase section is not visible");
        Assert.assertTrue(page.isIncludedItemTitleVisible(), "Included Item Title is not visible");
        Assert.assertTrue(page.isIncludedItemSKUVisible(), "Included Item SKU is not visible");
        Assert.assertTrue(page.isIncludedItemColorVisible(), "Included Item Color is not visible");
        Assert.assertTrue(page.validateEditOrder(), "Edit Order link is not working");
        dpage.clickProceedToCheckout();
        Assert.assertTrue(page.isDeliveryTypeBannerVisible(), "Delivery Type Banner is not visible");

        ExtentReportManager.getTest().pass("Verify Order Items on Checkout page 1");
    }
}
