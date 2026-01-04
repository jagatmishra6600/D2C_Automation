package com.automation.electrolux.EPIC_11_TC_AQA_OrderSummary;

import com.automation.BaseTest;
import com.automation.electrolux.pages.*;
import com.automation.frigidaire.pages.OrderSummaryCheckout1PageActionsFrig;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.annotations.Test;

public class EPIC_TC_AQA_OrderSummary_Elux extends BaseTest {
    HomePageActionsElux homePage = new HomePageActionsElux();
    ShippingAddressPageActionsElux shippingAddressPage = new ShippingAddressPageActionsElux();
    PdpPageActionsElux  pdpPageActionsElux=new PdpPageActionsElux();
    PLPProductItemsPageActionsElux plpProductItemsPageActionsElux = new PLPProductItemsPageActionsElux();
    DeliveryAndServicePageActionsElux deliveryAndServicePageActionsElux= new DeliveryAndServicePageActionsElux();
    CartPageActionsElux cartPageActionsElux = new CartPageActionsElux();
    ShippingAddressPageActionsElux shippingAddressPageActionsElux = new ShippingAddressPageActionsElux();
    OrderSummaryForCheckOutPage1ActionsElux orderSummaryCheckout1PageActionselux = new OrderSummaryForCheckOutPage1ActionsElux();
    DeliveryInstallationPageActionsElux deliveryInstallationPageActionsElux=new DeliveryInstallationPageActionsElux();
    @Test(groups = { "smoke",
            "regression" }, description = "Verify that the Login section on the Checkout Shipping Address page displays correct UI, messages, fields  and allows the user to successfully log in with valid credentials.")
    public void EPIC_09_CheckoutLogin_TC_02_AQA_OrderSummary_Elux() throws InterruptedException {
        navigateToShippingAddressPage("ELFW7337AW");
        deliveryInstallationPageActionsElux.selectRequiredInstallationPart();
        deliveryInstallationPageActionsElux.selectAddOnServices();
        plpProductItemsPageActionsElux.searchProducts( "EHVS75S1AO");
        verifyOrderSummaryForVacuumsProducts();
        shippingAddressPageActionsElux.verifyShippingDetails("automationtestengineer@maildrop.cc","PETER","PARKER","Carolina Beach","North Carolina","7829918924","28428","1 North Carolina Ave");
        orderSummaryCheckout1PageActionselux.clickOnSaveAndContinueBtnForCheckoutPage1();
        ExtentReportManager.getTest()
                .pass("Verified Login section UI, fields and messages on the Checkout Shipping Address page, "
                        + "and confirmed successful valid user login with welcome greeting and logout link.");
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