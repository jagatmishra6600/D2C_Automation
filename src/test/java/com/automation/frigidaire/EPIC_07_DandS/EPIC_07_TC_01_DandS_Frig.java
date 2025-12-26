package com.automation.frigidaire.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.DeliveryInstallationPageActionsFrig;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.PLPProductItemsPageActionsFrig;
import com.automation.frigidaire.pages.ProductCategoryPageActionsFrig;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class EPIC_07_TC_01_DandS_Frig extends BaseTest {

    HomePageActionsFrig homePage = new HomePageActionsFrig();
    ProductCategoryPageActionsFrig productCategoryPageActionsFrig = new ProductCategoryPageActionsFrig();
    PLPProductItemsPageActionsFrig PLPProductItemsPageActionsFrig = new PLPProductItemsPageActionsFrig();
    DeliveryInstallationPageActionsFrig DeliveryInstallationPageActionsFrig = new DeliveryInstallationPageActionsFrig();

    public void navigateToFrenchDoorRefrigerators(String webSite, String prodCategory, String subProdCategory) {
        homePage.navigateToHomePage();
        assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActionsFrig.clickOnProductMenu(webSite, prodCategory);
        productCategoryPageActionsFrig.clickOnProductMenu(webSite, subProdCategory);
        PLPProductItemsPageActionsFrig.closeEmailPopUp();

    }




    @Test(groups = {"smoke", "regression"}, description = "To verify Included Parts section within Delivery & installation section")
    public void EPIC_05_DandS_TC_02_test_Decline_Protection_Plan() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        DeliveryInstallationPageActionsFrig.selectProductAndAddToCart(0);
        DeliveryInstallationPageActionsFrig.verifyHeadingAndSubLinksinDAndSPage("Delivery & installation");
        DeliveryInstallationPageActionsFrig.verifyPopupTextIsVisible();
        DeliveryInstallationPageActionsFrig.verifyProtectionPlanSection("frigidaire");
        DeliveryInstallationPageActionsFrig.validateViewDetailsPopUp();
        DeliveryInstallationPageActionsFrig.isDeclineProtectionVisible();
        DeliveryInstallationPageActionsFrig.validateProtectionPlanPrice("frigidaire","1 year");
        ExtentReportManager.getTest().pass("Successfully verify the D and S page in Frigidaire");
    }

}

