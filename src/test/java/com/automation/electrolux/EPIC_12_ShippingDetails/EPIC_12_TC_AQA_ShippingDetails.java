package com.automation.electrolux.EPIC_12_ShippingDetails;

import com.automation.BaseTest;
import com.automation.electrolux.pages.*;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;

public class EPIC_12_TC_AQA_ShippingDetails extends BaseTest {

    HomePageActionsElux homePage = new HomePageActionsElux();
    ShippingAddressPageActionsElux shippingAddressPage = new ShippingAddressPageActionsElux();
    PdpPageActionsElux pdpPageActionsElux=new PdpPageActionsElux();
    PLPProductItemsPageActionsElux plpProductItemsPageActionsElux = new PLPProductItemsPageActionsElux();
    DeliveryAndServicePageActionsElux deliveryAndServicePageActionsElux= new DeliveryAndServicePageActionsElux();
    CartPageActionsElux cartPageActionsElux = new CartPageActionsElux();
    ShippingAddressPageActionsElux shippingAddressPageActionsElux = new ShippingAddressPageActionsElux();
    OrderSummaryForCheckOutPage1ActionsElux orderSummaryCheckout1PageActionselux = new OrderSummaryForCheckOutPage1ActionsElux();
    DeliveryInstallationPageActionsElux deliveryInstallationPageActionsElux=new DeliveryInstallationPageActionsElux();
    @Test(groups = { "smoke",
            "regression" }, description = "Verify that the Shipping details")
    public void EPIC_12_CheckoutLogin_TC_02_AQA_ShippingDetailsElux() throws InterruptedException {
        navigateToShippingAddressPage("ELFW7337AW");
        deliveryInstallationPageActionsElux.selectRequiredInstallationPart();
        deliveryInstallationPageActionsElux.selectAddOnServices();
        plpProductItemsPageActionsElux.searchProducts( "EHVS75S1AO");
        verifyOrderSummaryForVacuumsProducts();
        shippingAddressPageActionsElux.verifyShippingDetails("automationtestengineer@maildrop.cc","PETER","PARKER","Carolina Beach","North Carolina","7829918924","28428","1 North Carolina Ave");
        ExtentReportManager.getTest()
                .pass("Verified the Shipping Address page");
    }

    private void verifyOrderSummaryForVacuumsProducts() throws InterruptedException
    {

        pdpPageActionsElux.clickAddToCartButton();
        deliveryAndServicePageActionsElux.clickViewCartButton();
        orderSummaryCheckout1PageActionselux.clickProceedToCheckOutButton();
        orderSummaryCheckout1PageActionselux.verifyTaxAndSavingsforPage1();
    }

    private void navigateToShippingAddressPage(String skuNumber) throws InterruptedException {

        homePage.navigateToHomePage();
        plpProductItemsPageActionsElux.searchProducts( skuNumber);
        pdpPageActionsElux.closePopupModel();
        pdpPageActionsElux.clickAddToCartButton();
    }
}
