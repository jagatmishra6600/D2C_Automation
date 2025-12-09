package com.automation.electrolux.EPIC_04_PLP;

import com.automation.electrolux.pages.EL_ProductCategoryPageActions;
import com.automation.electrolux.pages.ElectroluxPLPProductItemsPageActions;
import com.automation.electrolux.pages.HomePageActions;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WebElementUtil;
import org.testng.annotations.Test;
import com.automation.BaseTest;

public class TC_04_PLP_ELECTROLUX_SORT_BY  extends BaseTest {



    HomePageActions homePage = new HomePageActions();
    EL_ProductCategoryPageActions productCategoryPageActions = new EL_ProductCategoryPageActions();
    ElectroluxPLPProductItemsPageActions PLPProductItemsPageActions = new ElectroluxPLPProductItemsPageActions();



    public void navigateToVacuumsProducts(String webSite, String prodCategory , String subProdCategory ) throws InterruptedException {
        homePage.navigateToHomePage();
      //  Assert.assertTrue(homePage.isHomePageLoaded(), "The electrolux home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu(webSite,prodCategory);
        productCategoryPageActions.clickOnProductMenu(webSite,subProdCategory);
        //productCategoryPageActions.closeEmailPopUp();
        PLPProductItemsPageActions.closeEmailPopUp();
        WebElementUtil.zoomInOrOut(25);
        PLPProductItemsPageActions.verifyProductItemPage("Vacuums","Vacuums");

//        ExtentReportManager.getTest().pass("Successfully navigated to the Products category page.");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price Low to High")
    public void testSortByPriceLowToHigh() throws InterruptedException {
        navigateToVacuumsProducts("electrolux","Vacuums","Shop All Vacuums");
        PLPProductItemsPageActions.clickOnSortByDropDownvalues("Price (low to high)", "Price (low to high)");
        PLPProductItemsPageActions.verifyPriceLowToHighSort("electrolux");
        ExtentReportManager.getTest().pass("Successfully sort products by Price Low to High");
    }



    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price High to Low")
    public void testSortByPriceHighToLow() throws InterruptedException {
        navigateToVacuumsProducts("electrolux","Vacuums","Shop All Vacuums");
        PLPProductItemsPageActions.clickOnSortByDropDownvalues("Price (high to low)", "Price (high to low)");
        PLPProductItemsPageActions.verifyPriceHighToLowSort("electrolux");
        ExtentReportManager.getTest().pass("Successfully sort products by Price High to Low");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Biggest Savings")
    public void testSortByBiggestSavings() throws InterruptedException {
        navigateToVacuumsProducts("electrolux","Vacuums","Shop All Vacuums");
        PLPProductItemsPageActions.clickOnSortByDropDownvalues("Biggest Savings", "Biggest Savings");
        PLPProductItemsPageActions.verifyBiggestSavingsSort("electrolux");
        ExtentReportManager.getTest().pass("Successfully sort products by Biggest Savings");

    }
}
