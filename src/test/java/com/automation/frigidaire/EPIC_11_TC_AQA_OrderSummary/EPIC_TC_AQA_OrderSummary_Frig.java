package com.automation.frigidaire.EPIC_11_TC_AQA_OrderSummary;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.*;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_TC_AQA_OrderSummary_Frig extends BaseTest {

    HomePageActionsFrig homePage = new HomePageActionsFrig();
    OrderSummaryCheckout1PageActionsFrig orderSummary=new OrderSummaryCheckout1PageActionsFrig();
    PLPProductItemsPageActionsFrig plpProductItemsPageActionsFrig=new PLPProductItemsPageActionsFrig();
    PlpPageActionsFrig plpPageActionsFrig=new PlpPageActionsFrig();
    PdpPageActionsFrig pdpPageActionsFrig=new PdpPageActionsFrig();
    DeliveryInstallationPageActionsFrig deliveryInstallationPageActionsFrig=new DeliveryInstallationPageActionsFrig();
    CartPageActionsFrig cartPageActionsFrig=new CartPageActionsFrig();
    ShippingAddressPageActionsFrig shippingAddressPage = new ShippingAddressPageActionsFrig();

    @Test(groups = { "smoke", "regression" }, description = "Verify the Order Summary section on checkout page 1")
    public void EPIC_10_TC_AQA_OrderSummary() throws InterruptedException {
        navigateToShippingAddressPageForFrenchDoor("GRMC2273CF-C1");
        navigateToShippingAddressPageForAirCare("FHWH084WB1");
        navigateToShippingAddressPageForAirCare("FHWC064TE1");
        cartPageActionsFrig.clickProceedToCheckOutButton();
        orderSummary.verifyTaxAndSavingsForPage1();
        shippingAddressPage.verifyShippingDetails("automationtestengineer@maildrop.cc","PETER","PARKER","Carolina Beach","North Carolina","7829918924","28428","1 North Carolina Ave");
        orderSummary.clickOnSaveAndContinueBtnForCheckoutPage1();
        orderSummary.verifyTaxAndSavings();

        ExtentReportManager.getTest().pass(
                "To verify the Order Summary section on checkout page 1");
    }

    private void navigateToShippingAddressPageForFrenchDoor(String skuNumber) throws InterruptedException {


        homePage.navigateToHomePage();
        homePage.clickFrenchDoor();
        plpPageActionsFrig.closePopupModel();
        plpProductItemsPageActionsFrig.searchProducts(skuNumber);
        pdpPageActionsFrig.clickAddToCartButton();
        deliveryInstallationPageActionsFrig.selectRequiredInstallationPart();
        deliveryInstallationPageActionsFrig.selectAddOnServices();

    }
    private void navigateToShippingAddressPageForAirCare(String skuNumber) throws InterruptedException {

        plpProductItemsPageActionsFrig.searchProductsForAircare(skuNumber);
        pdpPageActionsFrig.clickAddToCartButton();
        deliveryInstallationPageActionsFrig.clickSideSaveAndViewCartButton();

    }
}
