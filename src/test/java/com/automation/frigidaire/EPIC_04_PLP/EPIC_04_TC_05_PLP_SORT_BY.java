package com.automation.frigidaire.EPIC_04_PLP;

import com.automation.BaseTest;
import com.automation.frigidaire.locators.FrigidaireConstants;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions;
import com.automation.frigidaire.pages.PLPProductItemsPageActions;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_04_TC_05_PLP_SORT_BY extends BaseTest {

    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductCategoryPageActions productCategoryPageActions = new ProductCategoryPageActions();
    PLPProductItemsPageActions PLPProductItemsPageActions = new PLPProductItemsPageActions();


    public void navigateToFrenchDoorRefrigerators(String webSite, String prodCategory, String subProdCategory) throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu(webSite, "Kitchen");
        productCategoryPageActions.clickOnProductMenu(webSite, "French Door");
        PLPProductItemsPageActions.closeEmailPopUp();
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        ExtentReportManager.getTest().pass("Successfully navigated to the Products category page.");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price Low to High")
    public void EPIC_04_PLP_TC_05_testSortByPriceLowToHigh() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.clickOnSortByDropDownvalues("Price (low to high)", "Price (low to high)");
        PLPProductItemsPageActions.verifyPriceLowToHighSort(FrigidaireConstants.frigidaireWeb);
        ExtentReportManager.getTest().pass("Successfully sort products by Price Low to High");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price High to Low")
    public void EPIC_04_PLP_TC_05_testSortByPriceHighToLow() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.clickOnSortByDropDownvalues("Price (high to low)", "Price (high to low)");
        PLPProductItemsPageActions.verifyPriceHighToLowSort(FrigidaireConstants.frigidaireWeb);
        ExtentReportManager.getTest().pass("Successfully sort products by Price High to Low");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Biggest Savings")
    public void EPIC_04_PLP_TC_05_testSortByBiggestSavings() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.clickOnSortByDropDownvalues("Biggest Savings", "Biggest Savings");
        PLPProductItemsPageActions.verifyBiggestSavingsSort("frigidaire");
        ExtentReportManager.getTest().pass("Successfully sort products by Biggest Savings");
    }


}
