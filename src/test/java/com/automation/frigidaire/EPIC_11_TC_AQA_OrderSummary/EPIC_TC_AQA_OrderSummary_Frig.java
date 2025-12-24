package com.automation.frigidaire.EPIC_11_TC_AQA_OrderSummary;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.OrderSummaryCheckout1PageActionsFrig;
import com.automation.frigidaire.pages.ShippingAddressPageActionsFrig;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_TC_AQA_OrderSummary_Frig extends BaseTest {

    HomePageActionsFrig homePage = new HomePageActionsFrig();
    OrderSummaryCheckout1PageActionsFrig orderSummary=new OrderSummaryCheckout1PageActionsFrig();

    @Test(groups = { "smoke", "regression" }, description = "Verify the Order Summary section on checkout page 1")
    public void EPIC_10_TC_AQA_OrderSummary() throws InterruptedException {
        navigateToShippingAddressPage();
        Assert.assertTrue(orderSummary.isOrderSummaryTextVisibleAndCorrect("Order summary"), "Order summary text does not visible on page or Not matched with the expected one");
        Assert.assertTrue(orderSummary.isSubtotalTextVisibleAndCorrect("Subtotal"), "Subtotal Text does not visible on page or Not matched with the expected one");
        Assert.assertTrue(orderSummary.isSubtotalPriceVisible(), "Subtotal price does not visible on page");
        Assert.assertTrue(orderSummary.isInstallationPartTextVisibleAndCorrect("Installation parts"), "Installation parts Text does not visible on page or Not matched with the expected one");
        Assert.assertTrue(orderSummary.isInstallationPriceVisible(), "Installation parts price does not visible on page");
        Assert.assertTrue(orderSummary.isTotalTextVisibleAndCorrect("Total"), "Total Text does not visible on page or Not matched with the expected one");
        Assert.assertTrue(orderSummary.isTotalPriceVisible(), "Total price does not visible on page");
        Assert.assertTrue(orderSummary.isPromoCodeTextVisibleAndCorrect("Promo code"), "Promo code Text does not visible on page or Not matched with the expected one");
        ExtentReportManager.getTest().pass(
                "To verify the Order Summary section on checkout page 1");
    }

    private void navigateToShippingAddressPage() {
        homePage.navigateToHomePage()
                .clickFrenchDoor().closePopupModel().clickProvidedProduct().clickDeliveryOption().clickAddToCartButton()
                .clickSaveAndViewCartButton().clickProceedToCheckOutButton();
    }

}
