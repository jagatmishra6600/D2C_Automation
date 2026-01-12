package com.automation.fsus.EPIC_04_PLP;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.familystoreus.pages.PLPProductItemsPageActionsFsus;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WebElementUtil;
import org.testng.annotations.Test;

public class EPIC_04_TC_01_PLP_Filters_ElectroWashers_Fsus extends BaseTest {
    LoginPageActionsFsus loginPage= new LoginPageActionsFsus();
    PLPProductItemsPageActionsFsus productCard = new PLPProductItemsPageActionsFsus();

    @Test(groups = {"smoke", "regression"}, description = "verify the Hide and Show filters for Vacuums")
    public void verifyHideAndShowAllFiltersForLaundry() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Laundry");
        productCard.clickOnProductSubMenu("Electrolux Laundry");
        productCard.verifyProductItemPage("Laundry", "Laundry");
        productCard.verifyHideAndShowAllFilters("Hide Filters");
        productCard.verifyHideAndShowAllFilters("Show filtres");
        productCard.verifyHideFilters("Hide Filters");
        ExtentReportManager.getTest().pass("Successfully verified Product menu Shop All Washers displayed before clicking.");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify every filter expand and collapse")
    public void verifyExpandAndCollapseFilterInLaundry() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Laundry");
        productCard.clickOnProductSubMenu("Electrolux Laundry");
        productCard.verifyProductItemPage("Laundry", "Laundry");
//        productCard.verifyExpandAndCollapseFilter("Category", "Dryer");
        productCard.verifyExpandAndCollapseFilter("Brand", "Electrolux");
        productCard.verifyExpandAndCollapseFilter("Color", "White");
        productCard.verifyExpandAndCollapseFilter("Dryer Fuel Type", "Electric");
        productCard.verifyExpandAndCollapseFilter("Features", "ENERGY STAR Certified");
        productCard.verifyExpandAndCollapseFilter("Model", "700 Series");
        productCard.verifyExpandAndCollapseFilter("Height", "15\"");
        productCard.verifyExpandAndCollapseFilter("In stock", "Yes");
        ExtentReportManager.getTest().pass("Successfully Verified visibility of every filters");
    }

    @Test(groups = {"smoke", "regression"}, description = "verify the functionality of reset all button")
    public void verifyResetAll() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Laundry");
        productCard.clickOnProductSubMenu("Electrolux Laundry");
        productCard.verifyProductItemPage("Laundry", "Laundry");
        productCard.featureFilter("Category", "Front Load Washer");
        productCard.verifySelectedFilters("Electrolux");
        ExtentReportManager.getTest().pass("Successfully Verified the functionality of color feature in washer.");
    }

    @Test(groups = {"smoke", "regression"}, description = "verify the functionality of color feature in washer")
    public void verifyColorFilter() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Laundry");
        productCard.clickOnProductSubMenu("Electrolux Laundry");
        productCard.verifyProductItemPage("Laundry", "Laundry");
        productCard.featureFilter("Color", "White");
        productCard.openAllProductsAndValidateColor("White","White");
        ExtentReportManager.getTest().pass("Successfully Verified the functionality of color feature in washer.");

    }
    @Test(groups = {"regression"}, description = "Verify the visibility of every filter")
        public void verifyVisibilityOfFiltersInPLP() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Laundry");
        productCard.clickOnProductSubMenu("Electrolux Laundry");
        productCard.verifyProductItemPage("Laundry", "Laundry");
        productCard.verifyFiltersInPLP("Category");
        productCard.verifyFiltersInPLP("Brand");
        productCard.verifyFiltersInPLP("Color");
        productCard.verifyFiltersInPLP("Dryer Fuel Type");
        productCard.verifyFiltersInPLP("Features");
        productCard.verifyFiltersInPLP("Model");
        productCard.verifyFiltersInPLP("Height");
        productCard.verifyFiltersInPLP("In stock");
        ExtentReportManager.getTest().pass("Successfully verified the visibility of every filter.");
    }

    @Test(groups = {"smoke", "regression"}, description = "verify Checkbox Unchecked After Cross Click")
    public void verify_CrossBtn_In_PLP() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Laundry");
        productCard.clickOnProductSubMenu("Electrolux Laundry");
        productCard.verifyProductItemPage("Laundry", "Laundry");
        WebElementUtil.zoomInOrOut(50);
        productCard.validateCheckboxUncheckedAfterCrossClick("Category", "Dryer", "Dryer");
        productCard.validateCheckboxUncheckedAfterCrossClick("Category", "Front Load Washer", "Front Load Washer");
        productCard.validateCheckboxUncheckedAfterCrossClick("Category", "Laundry Tower", "Laundry Tower");
        ExtentReportManager.getTest().pass("Successfully verified Checkbox Unchecked After Cross Click");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify product dimensions for height")
    public void testForHeightDimensions() throws InterruptedException {

        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Laundry");
        productCard.clickOnProductSubMenu("Electrolux Laundry");
        productCard.verifyProductItemPage("Laundry", "Laundry");
        productCard.featureFilter("Height", "38\"");
        productCard.verifyProductWidthHeightAndDepth("38", "38\"");
        ExtentReportManager.getTest().pass("Successfully Verified product dimensions for height");
    }

    @Test(groups = {"smoke", "regression"}, description = "verify Availability of products in PLP")
    public void verify_Availaibility_In_PLP() throws InterruptedException
    {

        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Laundry");
        productCard.clickOnProductSubMenu("Electrolux Laundry");
        productCard.verifyProductItemPage("Laundry", "Laundry");
        productCard.featureFilter("In stock","Yes");
        productCard.validateAvailabilityOfProductsInPLP();
        ExtentReportManager.getTest().pass("Successfully verify Availability of products in PLP");

    }
}
