package com.automation.frigidaire.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.DeliveryInstallationPageActions;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.PLPProductItemsPageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class EPIC_07_TC_01_DandS extends BaseTest {

    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductCategoryPageActions productCategoryPageActions = new ProductCategoryPageActions();
    PLPProductItemsPageActions PLPProductItemsPageActions = new PLPProductItemsPageActions();
    DeliveryInstallationPageActions DeliveryInstallationPageActions = new DeliveryInstallationPageActions();

    public void navigateToFrenchDoorRefrigerators(String webSite, String prodCategory, String subProdCategory) {
        homePage.navigateToHomePage();
        assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu(webSite, prodCategory);
        productCategoryPageActions.clickOnProductMenu(webSite, subProdCategory);
        PLPProductItemsPageActions.closeEmailPopUp();

    }

    @Test(groups = {"smoke", "regression"}, description = "To verify Included Parts section within Delivery & installation section")
    public void EPIC_05_DandS_TC_02_test_Decline_Protection_Plan() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        DeliveryInstallationPageActions.selectProductAndAddToCart(0);
        DeliveryInstallationPageActions.verifyHeadingAndSubLinksinDAndSPage("Delivery & installation");
        DeliveryInstallationPageActions.verifyPopupTextIsVisible();
        DeliveryInstallationPageActions.verifyProtectionPlanSection("frigidaire");
        DeliveryInstallationPageActions.validateViewDetailsPopUp();
        DeliveryInstallationPageActions.isDeclineProtectionVisible();
        DeliveryInstallationPageActions.validateProtectionPlanPrice("frigidaire","1 year");
        ExtentReportManager.getTest().pass("Successfully verify the D and S page in Frigidaire");
    }

}