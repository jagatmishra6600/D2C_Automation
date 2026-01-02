package com.automation.frigidaire.EPIC_08_CartPage;

import com.automation.BaseTest;
import com.automation.frigidaire.locators.CartLocatorsFrig;
import com.automation.frigidaire.pages.*;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EPIC_08_TC_06_AQA_Cart_Error_message_for_UnavailableProducts extends BaseTest {

    private final HomePageActionsFrig homePage = new HomePageActionsFrig();
    private final CartUnavailableProductsFrig cartProductPage = new CartUnavailableProductsFrig();


    @Test( description = "Verify Error message from Cart for unavailable products")
    public void EPIC_08_Cart_TC_06_validateUnavailableProductsFromCart() {
        homePage.navigateToHomePage();
        WaitUtils.untilPageLoadComplete();
        cartProductPage.clickOnSmallAppliances();
        cartProductPage.clickOnEspressomaker();
        cartProductPage.clickOnSmallAppliances();
        cartProductPage.clickOnRetrominifridge();
        cartProductPage.clickOnitemaddtocart();
        cartProductPage.clickOnCancelbutton();
        cartProductPage.clickOnMinifridgetwo();
        cartProductPage.clickOnCancelbutton();
        cartProductPage.clickOnAccessories();
        cartProductPage.clickOnIcemakers();
        cartProductPage.clickOnIcemakersproduct();
        cartProductPage.clickOnSaveandViewCart();
        Assert.assertTrue(cartProductPage.verifyYourCart(), "Empty cart text is not found.");

        
        ExtentReportManager.getTest().pass("Validate unavailable products on Cart page");

    }
}
