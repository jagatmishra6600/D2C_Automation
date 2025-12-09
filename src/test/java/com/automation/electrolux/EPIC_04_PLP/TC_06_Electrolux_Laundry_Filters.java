package com.automation.electrolux.EPIC_04_PLP;

import com.automation.electrolux.pages.EL_ProductCategoryPageActions;
import com.automation.electrolux.pages.ElectroluxPLPProductItemsPageActions;
import com.automation.electrolux.pages.HomePageActions;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WebElementUtil;
import org.testng.annotations.Test;
import com.automation.BaseTest;
import static com.automation.frigidaire.locators.FrigidaireConstants.electroxWeb;

public class TC_06_Electrolux_Laundry_Filters extends BaseTest {


    HomePageActions homePage = new HomePageActions();
    EL_ProductCategoryPageActions productCategoryPageActions = new EL_ProductCategoryPageActions();
    ElectroluxPLPProductItemsPageActions PLPProductItemsPageActions = new ElectroluxPLPProductItemsPageActions();

    public void navigateToVacuumsProducts(String webSite, String prodCategory, String subProdCategory) throws InterruptedException {
        homePage.navigateToHomePage();
        productCategoryPageActions.clickOnProductMenu(webSite, prodCategory);
        productCategoryPageActions.clickOnProductMenu(webSite, subProdCategory);
        PLPProductItemsPageActions.closeEmailPopUp();
        WebElementUtil.zoomInOrOut(25);
        PLPProductItemsPageActions.verifyProductItemPage("Washers", "Washers");


    }


    @Test(groups = {"smoke", "regression"}, description = " Verify Hide and Show Filter for Laundry ")
    public void testHideShowFilters() throws InterruptedException {
        navigateToVacuumsProducts("electrolux", "Laundry", "Washers");
        PLPProductItemsPageActions.verifyHideAndShowAllFilters("Hide filters");
        PLPProductItemsPageActions.verifyHideAndShowAllFilters("Show filters");
        PLPProductItemsPageActions.verifyHideFilters("Hide filters");
        ExtentReportManager.getTest().pass("Successfully Verify Hide and Show Filter for Laundry");
    }




    @Test(groups = {"regression"}, description = "Verify every filter expand and collapse")
    public void testExpandAndCollapseFilter() throws InterruptedException {
        navigateToVacuumsProducts("electrolux", "Laundry", "Washers");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter("electrolux", "Color", "Alpine");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter("electrolux", "Features", "High Efficiency");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter("electrolux", "Model", "700 Series");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter("electrolux", "In stock", "Yes");
        ExtentReportManager.getTest().pass("Successfully Verify every filter expand and collapse");

    }


    @Test(groups = {"regression"}, description = "Verify reset all filter")
    public void testResetAll() throws InterruptedException {
        navigateToVacuumsProducts("electrolux", "Laundry", "Washers");
        PLPProductItemsPageActions.featureFilter(electroxWeb, "Features", "High Efficiency");
        PLPProductItemsPageActions.verifySelectedFilters("High Efficiency");
        ExtentReportManager.getTest().pass("Successfully Verify reset all filter");

    }

    @Test(groups = {"regression"}, description = "Verify Ice maker filter with its functionality")
    public void verifyPLPUpdatesWhenSingleFilterSelected() throws InterruptedException {
        navigateToVacuumsProducts("electrolux", "Laundry", "Washers");
        PLPProductItemsPageActions.featureFilter(electroxWeb, "Features", "High Efficiency");
        PLPProductItemsPageActions.openAllProductsAndValidate("Certifications and Approvals", "High Efficiency", "Yes");
        ExtentReportManager.getTest().pass("Verify Ice maker filter with its functionality");


    }

    @Test(groups = {"regression"}, description = "Verify Model filter for 700 Series")
    public void verifyPLPUpdatesForModelFeature() throws InterruptedException {
        navigateToVacuumsProducts("electrolux", "Laundry", "Washers");
        PLPProductItemsPageActions.featureFilter(electroxWeb, "Model", "700 Series");
        PLPProductItemsPageActions.openAllProductsAndValidate("General Specifications", "Laundry Series", "700 Series");
        ExtentReportManager.getTest().pass("Verify Model filter for 700 Series");
    }

   // @Test(groups = {"smoke", "regression"}, description = "verify Availability of products in PLP")
    public void verify_Availaibility_In_PLP() throws InterruptedException
    {
        navigateToVacuumsProducts("electrolux", "Laundry", "Washers");
        PLPProductItemsPageActions.featureFilter("electrolux", "In stock", "Yes");
        PLPProductItemsPageActions.validateAvailabilityOfProductsInPLP();
        ExtentReportManager.getTest().pass("Successfully verify Availability of products in PLP");

    }
}
