package com.automation.fsus.EPIC_04_PLP;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.familystoreus.pages.PLPProductItemsPageActionsFsus;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WebElementUtil;
import org.testng.annotations.Test;

public class EPIC_04_TC_02_PLP_Filters_Vacuums_Fsus extends BaseTest {

    LoginPageActionsFsus loginPage= new LoginPageActionsFsus();
    PLPProductItemsPageActionsFsus productCard = new PLPProductItemsPageActionsFsus();

    @Test(groups = {"smoke", "regression"}, description = "verify the Hide and Show filters for Vacuums")
    public void verifyHideAndShowAllFiltersInVacuums() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Vacuums");
        productCard.clickOnProductSubMenu("Explore Vacuums");
        productCard.verifyProductItemPage("Vacuums", "Vacuums");
        productCard.verifyHideAndShowAllFilters("Hide Filters");
        productCard.verifyHideAndShowAllFilters("Show filtres");
        productCard.verifyHideFilters("Hide Filters");
        ExtentReportManager.getTest().pass("Successfully verified Hide and Show Filter.");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify every filter expand and collapse")
    public void verifyExpandAndCollapseFilterForVacuums() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Vacuums");
        productCard.clickOnProductSubMenu("Explore Vacuums");
        productCard.verifyProductItemPage("Vacuums", "Vacuums");
        productCard.verifyExpandAndCollapseFilter("Category", "Cordless Stick");
        productCard.verifyExpandAndCollapseFilter("Best For", "Multi-Surface Cleaning");
        productCard.verifyExpandAndCollapseFilter("Technology", "LED Nozzle Lights");
        productCard.verifyExpandAndCollapseFilter("Bin Size", "Less than 0.4 L");
        productCard.verifyExpandAndCollapseFilter("Weight", "Less than 6 lbs");
        productCard.verifyExpandAndCollapseFilter("In stock", "Yes");
        ExtentReportManager.getTest().pass("Successfully Verified Expand and collapse of every filters.");

    }

    @Test(groups = {"smoke", "regression"}, description = "Verify Technology Filter in Vacuums")
    public void verifyTechnologyFilterInVacuums() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Vacuums");
        productCard.clickOnProductSubMenu("Explore Vacuums");
        productCard.verifyProductItemPage("Vacuums", "Vacuums");
        productCard.featureFilter("Technology","LED Nozzle Lights");
        productCard.openAllProductsAndValidate("General Specifications","LED Nozzle Lights","Yes");
        ExtentReportManager.getTest().pass("Successfully Verified Technology Filter");
    }

    @Test(groups = {"smoke", "regression"}, description = "verify the functionality of reset all button")
    public void verifyResetAll() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Vacuums");
        productCard.clickOnProductSubMenu("Explore Vacuums");
        productCard.verifyProductItemPage("Vacuums", "Vacuums");
        productCard.featureFilter("Category", "Cordless Stick");
        productCard.verifySelectedFilters("Cordless Stick");
        ExtentReportManager.getTest().pass("Successfully Verified the functionality of reset all button.");
    }

    @Test(groups = {"smoke", "regression"}, description = "verify Checkbox Unchecked After Cross Click")
    public void verify_CrossBtn_In_PLP() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Vacuums");
        productCard.clickOnProductSubMenu("Explore Vacuums");
        productCard.verifyProductItemPage("Vacuums", "Vacuums");
        WebElementUtil.zoomInOrOut(50);
        productCard.validateCheckboxUncheckedAfterCrossClick("Category", "Cordless Stick", "Cordless Stick");
        productCard.validateCheckboxUncheckedAfterCrossClick("Category", "Wet & Dry", "Wet & Dry");
        ExtentReportManager.getTest().pass("Successfully verified Checkbox Unchecked After Cross Click");
    }
}
