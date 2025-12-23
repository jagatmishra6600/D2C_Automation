package com.automation.frigidaire.EPIC_10_ShippingDetails;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.ShippingAddressPageActionsFrig;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.UserTestData;
import com.automation.utils.WebElementUtil;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EPIC_10_TC_AQA_ShippingDetailsFrig extends BaseTest {
    HomePageActionsFrig homePage = new HomePageActionsFrig();
    ShippingAddressPageActionsFrig shippingAddressPage = new ShippingAddressPageActionsFrig();

    @Test(groups = { "smoke", "regression" }, description = "Verify that the Login section on the Checkout Shipping Address page displays correct UI, messages, fields  and allows the user to successfully log in with valid credentials.")
    public void EPIC_09_CheckoutLogin_TC_02_VerifyCheckoutLoginSectionAndUserLoginSuccess() {
        navigateToShippingAddressPage();
        shippingAddressPage.verifyShippingDeatils();
        ExtentReportManager.getTest().pass(
                "Verified Login section UI, fields and messages on the Checkout Shipping Address page, " +
                        "and confirmed successful valid user login with welcome greeting and logout link.");
    }

    private void navigateToShippingAddressPage() {
        homePage.navigateToHomePage()
                .clickFrenchDoor().closePopupModel().clickProvidedProduct().clickDeliveryOption().clickAddToCartButton()
                .clickSaveAndViewCartButton().clickProceedToCheckOutButton();
    }

}
