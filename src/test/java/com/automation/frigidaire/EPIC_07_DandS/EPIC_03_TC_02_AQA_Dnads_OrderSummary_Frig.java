package com.automation.frigidaire.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.*;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_02_AQA_Dnads_OrderSummary_Frig extends BaseTest {

    private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    private final FrigidairePdpPageActions pdpPage = new FrigidairePdpPageActions();
    private final FrigidairePlpPageActions plpPage = new FrigidairePlpPageActions();
    private final FrigidaireDAndSPageActions dnsPage = new FrigidaireDAndSPageActions();
    private final CartPageActionsFrig cartOage = new CartPageActionsFrig();
    private String currentUrl;


    @Test(groups = {"smoke", "regression"}, description = "Verify Order Summary on D&S page for French Door Refrigerator")
    public void EPIC_07_DandS_TC_02_verifyOrderSummaryForFrenchDoorRefrigerator() {
        homePage.navigateToHomePage();
        currentUrl = WebElementUtil.getCurrentUrl();
        if (currentUrl.contains("frigidaire")) {
            WaitUtils.untilPageLoadComplete();
            homePage.clickFrenchDoor();
            plpPage.closePopupModel();
            plpPage.clickProvidedProduct();
            pdpPage.clickDeliveryOption();
            pdpPage.clickAddToCartButton();

            dnsPage.clickSaveAndViewCartButton();

            Assert.assertTrue(cartOage.isOrderSummaryTextVisibleAndCorrect("Order summary"), "Order summary text does not visible on page or Not matched with the expected one");
            Assert.assertTrue(cartOage.isSubtotalTextVisibleAndCorrect("Subtotal"), "Subtotal Text does not visible on page or Not matched with the expected one");
            Assert.assertTrue(cartOage.isSubtotalPriceVisible(), "Subtotal price does not visible on page");
            Assert.assertTrue(cartOage.isInstallationPartTextVisibleAndCorrect("Installation parts"), "Installation parts Text does not visible on page or Not matched with the expected one");
            Assert.assertTrue(cartOage.isInstallationPriceVisible(), "Installation parts price does not visible on page");
            Assert.assertTrue(cartOage.isTotalTextVisibleAndCorrect("Total"), "Total Text does not visible on page or Not matched with the expected one");
            Assert.assertTrue(cartOage.isTotalPriceVisible(), "Total price does not visible on page");
            Assert.assertTrue(cartOage.isPromoCodeTextVisibleAndCorrect("Promo code"), "Promo code Text does not visible on page or Not matched with the expected one");

            cartOage.clickProceedToCheckOutButton();

        }

        ExtentReportManager.getTest().pass("Verify order summary on D&S page for French Door Refrigerator");
    }
}
