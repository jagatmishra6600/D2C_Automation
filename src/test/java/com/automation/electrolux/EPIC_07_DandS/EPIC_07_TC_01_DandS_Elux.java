package com.automation.electrolux.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.electrolux.pages.DeliveryInstallationPageActionsElux;
import com.automation.electrolux.pages.HomePageActionsElux;
import com.automation.electrolux.pages.ProductCategoryPageActionsElux;
import com.automation.electrolux.pages.PLPProductItemsPageActionsElux;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;

public class EPIC_07_TC_01_DandS_Elux extends BaseTest {

    HomePageActionsElux homePage = new HomePageActionsElux();
    ProductCategoryPageActionsElux productCategoryPageActions = new ProductCategoryPageActionsElux();
    PLPProductItemsPageActionsElux PLPProductItemsPageActions = new PLPProductItemsPageActionsElux();
    DeliveryInstallationPageActionsElux DeliveryInstallationPageActions = new DeliveryInstallationPageActionsElux();

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
