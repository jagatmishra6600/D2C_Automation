package com.automation.frigidaire.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.DeliveryInstallationPageActions_Frig;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.PLPProductItemsPageActions_Frig;
import com.automation.frigidaire.pages.ProductCategoryPageActions_Frig;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class EPIC_07_TC_01_DandS_Frig extends BaseTest {

    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductCategoryPageActions_Frig productCategoryPageActionsFrig = new ProductCategoryPageActions_Frig();
    PLPProductItemsPageActions_Frig PLPProductItemsPageActions_Frig = new PLPProductItemsPageActions_Frig();
    DeliveryInstallationPageActions_Frig DeliveryInstallationPageActions_Frig = new DeliveryInstallationPageActions_Frig();

    public void navigateToFrenchDoorRefrigerators(String webSite, String prodCategory, String subProdCategory) {
        homePage.navigateToHomePage();
        assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActionsFrig.clickOnProductMenu(webSite, prodCategory);
        productCategoryPageActionsFrig.clickOnProductMenu(webSite, subProdCategory);
        PLPProductItemsPageActions_Frig.closeEmailPopUp();

    }


    @Test(groups = {"smoke", "regression"}, description = "To verify Included Parts section within Delivery & installation section")
    public void EPIC_05_DandS_TC_02_test_Decline_Protection_Plan() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        DeliveryInstallationPageActions_Frig.selectProductAndAddToCart(0);
        DeliveryInstallationPageActions_Frig.verifyHeadingAndSubLinksinDAndSPage("Delivery & installation");
        DeliveryInstallationPageActions_Frig.verifyPopupTextIsVisible();
        DeliveryInstallationPageActions_Frig.verifyProtectionPlanSection("frigidaire");
        DeliveryInstallationPageActions_Frig.validateViewDetailsPopUp();
        DeliveryInstallationPageActions_Frig.isDeclineProtectionVisible();
        DeliveryInstallationPageActions_Frig.validateProtectionPlanPrice("frigidaire","1 year");
        ExtentReportManager.getTest().pass("Successfully verify the D and S page in Frigidaire");
    }

}