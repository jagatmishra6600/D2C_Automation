package com.automation.frigidaire.EPIC_10_Checkout1;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.CheckoutPageActionsFrig;
import com.automation.frigidaire.pages.DeliveryDatePageActionsFrig;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.PlpPageActionsFrig;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_10_TC_03_AQA_CheckoutPageOrderItems_Frig extends BaseTest {
    private final HomePageActionsFrig homePage = new HomePageActionsFrig();
    private final CheckoutPageActionsFrig page = new CheckoutPageActionsFrig();
    private final DeliveryDatePageActionsFrig dpage = new DeliveryDatePageActionsFrig();
    private final PlpPageActionsFrig plpPage = new PlpPageActionsFrig();

    @Test(groups = {"regression"}, description = "Verify Order Items on Checkout page 1")
    public void verifyDeliveryDates() {
        homePage.navigateToHomePage();
        dpage.searchProduct("GRMC2273CF-C1");
        dpage.selectProductFromPLP();
        plpPage.closePopupModel();
        dpage.clickAddToCart();
        page.selectDeliveryAndSaveAndViewCart();
        dpage.clickProceedToCheckout();
        Assert.assertTrue(page.isDeliveryTypeBannerVisible(), "Delivery Type Banner is not visible");
        Assert.assertTrue(page.orderItemNameIsVisible(), "Order Item Title is not visible");
        Assert.assertTrue(page.isSKUVisible(), "Order Item SKU is not visible");
        Assert.assertTrue(page.isQtyVisible(), "Order Item Quantity is not visible");
        Assert.assertTrue(page.isOrderPriceVisible(), "Order Item Price is not visible");
        Assert.assertTrue(page.isDiscountPricePriceVisible(), "Order Item Discount Price is not visible");
        Assert.assertTrue(page.isProtectionPlanVisible(), "Protection Plan is not visible");
        Assert.assertTrue(page.isAddOnServiceVisible(), "Add On Service is not visible");
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
