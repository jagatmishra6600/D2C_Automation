package com.automation.electrolux.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.electrolux.pages.DeliveryInstallationPageActions_Elux;
import com.automation.electrolux.pages.ProductCategoryPageActions_Elux;
import com.automation.electrolux.pages.PLPProductItemsPageActions_Elux;
import com.automation.electrolux.pages.HomePageActions;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;

public class EPIC_07_TC_01_DandS_Elux extends BaseTest {

    HomePageActions homePage = new HomePageActions();
    ProductCategoryPageActions_Elux productCategoryPageActions = new ProductCategoryPageActions_Elux();
    PLPProductItemsPageActions_Elux PLPProductItemsPageActions = new PLPProductItemsPageActions_Elux();
    DeliveryInstallationPageActions_Elux DeliveryInstallationPageActions = new DeliveryInstallationPageActions_Elux();

    public void navigateToVacuumsProducts(String webSite, String prodCategory, String subProdCategory){
        homePage.navigateToHomePage();
        productCategoryPageActions.clickOnProductMenu(webSite, prodCategory);
        productCategoryPageActions.clickOnProductMenu(webSite, subProdCategory);
        PLPProductItemsPageActions.closeEmailPopUp();
        PLPProductItemsPageActions.verifyProductItemPage("Washers", "Washers");
    }

    @Test(groups = {"smoke", "regression"}, description = "To verify Included Parts section within Delivery & installation section")
    public void EPIC_05_DandS_TC_01_test_Included_Parts_Section_Within_Delivery_Installation_Section() throws InterruptedException {
        navigateToVacuumsProducts("electrolux", "Laundry", "Washers");
        DeliveryInstallationPageActions.selectProductAndAddToCart(3);
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
