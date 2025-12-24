package com.automation.frigidaire.EPIC_10_ShippingDetails;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.ShippingAddressPageActionsFrig;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;

public class EPIC_10_TC_AQA_ShippingDetailsFrig extends BaseTest {
    HomePageActionsFrig homePage = new HomePageActionsFrig();
    ShippingAddressPageActionsFrig shippingAddressPage = new ShippingAddressPageActionsFrig();

    @Test(groups = { "smoke", "regression" }, description = "Verify the Shipping Address section on checkout page 1")
    public void EPIC_10_TC_AQA_ShippingDetails() throws InterruptedException {
        navigateToShippingAddressPage();
        shippingAddressPage.verifyShippingDetails("automationtestengineer@maildrop.cc","PETER","PARKER","LANDIS","North Carolina","7829918924","28088","1234 Maple Street");
        ExtentReportManager.getTest().pass(
                "To verify the Shipping Address section on checkout page 1");
    }

    private void navigateToShippingAddressPage() {
        homePage.navigateToHomePage()
                .clickFrenchDoor().closePopupModel().clickProvidedProduct().clickDeliveryOption().clickAddToCartButton()
                .clickSaveAndViewCartButton().clickProceedToCheckOutButton();
    }



}
