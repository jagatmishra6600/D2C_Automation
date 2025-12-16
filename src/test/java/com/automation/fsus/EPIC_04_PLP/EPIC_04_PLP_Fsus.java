package com.automation.fsus.EPIC_04_PLP;

import com.automation.BaseTest;
import com.automation.electrolux.pages.ProductCategoryPageActionsElux;
import com.automation.electrolux.pages.PLPProductItemsPageActionsElux;
import com.automation.familystoreus.pages.HomePageActionsFsus;
import com.automation.frigidaire.locators.ConstantsLocatorsFrig;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WebElementUtil;
import org.testng.annotations.Test;

public class EPIC_04_PLP_Fsus extends BaseTest {


    HomePageActionsFsus homePage = new HomePageActionsFsus();
    ProductCategoryPageActionsElux productCategoryPageActions = new ProductCategoryPageActionsElux();
    PLPProductItemsPageActionsElux PLPProductItemsPageActions = new PLPProductItemsPageActionsElux();


    public void navigateToVacuumsProducts(String webSite, String prodCategory, String subProdCategory) throws InterruptedException {
        homePage.navigateToHomePage();
        //  Assert.assertTrue(homePage.isHomePageLoaded(), "The electrolux home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu(webSite, prodCategory);
        productCategoryPageActions.clickOnProductMenu(webSite, subProdCategory);
        //productCategoryPageActions.closeEmailPopUp();
        PLPProductItemsPageActions.closeEmailPopUp();
        WebElementUtil.zoomInOrOut(25);
        PLPProductItemsPageActions.verifyProductItemPage("Vacuums", "Vacuums");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price Low to High")
    public void testSortByPriceLowToHigh() throws InterruptedException {
        navigateToVacuumsProducts("fsus", "Vacuums", "Shop All Vacuums");
        PLPProductItemsPageActions.clickOnSortByDropDownvalues("Price (low to high)", "Price (low to high)");
        PLPProductItemsPageActions.verifyPriceLowToHighSort("electrolux");
        ExtentReportManager.getTest().pass("Successfully sort products by Price Low to High");
    }


    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price High to Low")
    public void testSortByPriceHighToLow() throws InterruptedException {
        navigateToVacuumsProducts("electrolux", "Vacuums", "Shop All Vacuums");
        PLPProductItemsPageActions.clickOnSortByDropDownvalues("Price (high to low)", "Price (high to low)");
        PLPProductItemsPageActions.verifyPriceHighToLowSort(ConstantsLocatorsFrig.electroxWeb);
        ExtentReportManager.getTest().pass("Successfully sort products by Price High to Low");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Biggest Savings")
    public void testSortByBiggestSavings() throws InterruptedException {
        navigateToVacuumsProducts("electrolux", "Vacuums", "Shop All Vacuums");
        PLPProductItemsPageActions.clickOnSortByDropDownvalues("Biggest Savings", "Biggest Savings");
        PLPProductItemsPageActions.verifyBiggestSavingsSort("electrolux");
        ExtentReportManager.getTest().pass("Successfully sort products by Biggest Savings");

    }
}