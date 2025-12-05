package com.automation.electrolux.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.DeliveryInstallationPageActions;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.PLPProductItemsPageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;

public class EPIC_07_TC_01_DandS extends BaseTest {

    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductCategoryPageActions productCategoryPageActions = new ProductCategoryPageActions();
    PLPProductItemsPageActions PLPProductItemsPageActions = new PLPProductItemsPageActions();
    DeliveryInstallationPageActions DeliveryInstallationPageActions = new DeliveryInstallationPageActions();

    public void navigateToVacuumsProducts(String webSite, String prodCategory, String subProdCategory) throws InterruptedException {
        homePage.navigateToHomePage();
        productCategoryPageActions.clickOnProductMenu(webSite, prodCategory);
        productCategoryPageActions.clickOnProductMenu(webSite, subProdCategory);
        PLPProductItemsPageActions.closeEmailPopUp();
        // WebElementUtil.zoomInOrOut(25);
        PLPProductItemsPageActions.verifyProductItemPage("Washers", "Washers");


    }



    @Test(groups = {"smoke", "regression"}, description = "To verify Included Parts section within Delivery & installation section")
    public void EPIC_05_DandS_TC_01_test_Included_Parts_Section_Within_Delivery_Installation_Section() throws InterruptedException {
        navigateToVacuumsProducts("electrolux", "Laundry", "Washers");
        DeliveryInstallationPageActions.selectProductAndAddToCart(1);
        DeliveryInstallationPageActions.verifyHeadingAndSubLinksinDAndSPage("Professional Installation");
        DeliveryInstallationPageActions.verifyPopupTextIsVisible();
        DeliveryInstallationPageActions.verifyProtectionPlanSection("electrolux");
        DeliveryInstallationPageActions.isDeclineProtectionVisible();
        DeliveryInstallationPageActions.validateProtectionPlanPrice("electrolux","1 year");
        DeliveryInstallationPageActions.validateProtectionPlanPrice("electrolux","3 years");
        DeliveryInstallationPageActions.validateProtectionPlanPrice("electrolux","5 years");
        ExtentReportManager.getTest().pass("Successfully verify the D and S page in Electrolux");
    }




}
