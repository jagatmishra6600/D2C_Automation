package com.automation.electrolux.EPIC_12_ShippingDetails;

import com.automation.BaseTest;
import com.automation.electrolux.pages.*;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;

public class EPIC_12_TC_AQA_ShippingDetails extends BaseTest {


    PLPProductItemsPageActionsElux plpProductItemsPageActionsElux = new PLPProductItemsPageActionsElux();
    ShippingAddressPageActionsElux shippingAddressPageActionsElux = new ShippingAddressPageActionsElux();
    OrderSummaryForCheckOutPage1ActionsElux orderSummaryCheckout1PageActionselux = new OrderSummaryForCheckOutPage1ActionsElux();
    DeliveryInstallationPageActionsElux deliveryInstallationPageActionsElux=new DeliveryInstallationPageActionsElux();

    @Test(groups = { "smoke", "regression" }, description = "Verify that the Shipping details")
    public void EPIC_12_CheckoutLogin_TC_02_AQA_ShippingDetailsElux() throws InterruptedException {
        orderSummaryCheckout1PageActionselux.navigateToShippingAddressPage("ELFW7337AW");
        deliveryInstallationPageActionsElux.selectRequiredInstallationPart();
        deliveryInstallationPageActionsElux.selectAddOnServices();
        plpProductItemsPageActionsElux.searchProducts( "EHVS75S1AO");
        orderSummaryCheckout1PageActionselux.verifyOrderSummaryForVacuumsProducts();
        shippingAddressPageActionsElux.verifyShippingDetails("automationtestengineer@maildrop.cc","PETER","PARKER","Carolina Beach","North Carolina","7829918924","28428","1 North Carolina Ave");
        ExtentReportManager.getTest()
                .pass("Verified the Shipping Address page");
    }
}
