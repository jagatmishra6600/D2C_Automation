package com.automation.frigidaire.tests.EPIC_04_PLP;

import com.automation.frigidaire.enums.FrigidaireConstants;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions;
import com.automation.frigidaire.pages.PLPProductItemsPageActions;
import com.automation.frigidaire.tests.BaseTest;
import com.automation.frigidaire.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NAGDTOPS_15695_PLP_SORT_BY  extends BaseTest {

    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductCategoryPageActions productCategoryPageActions=new ProductCategoryPageActions();
    PLPProductItemsPageActions PLPProductItemsPageActions =new PLPProductItemsPageActions();



    public void navigateToFrenchDoorRefrigerators(String webSite,String prodCategory , String subProdCategory ) throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu(webSite,"Kitchen");
        productCategoryPageActions.clickOnProductMenu(webSite,"French Door");
        PLPProductItemsPageActions.closeEmailPopUp();
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        ExtentReportManager.getTest().pass("Successfully navigated to the Products category page.");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price Low to High")
    public void testSortByPriceLowToHigh() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire","Kitchen","French Door");
        PLPProductItemsPageActions.clickOnSortByDropDownvalues("Price (low to high)", "Price (low to high)");
        PLPProductItemsPageActions.verifyPriceLowToHighSort(FrigidaireConstants.frigidaireWeb);
        ExtentReportManager.getTest().pass("Successfully sort products by Price Low to High");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price High to Low")
    public void testSortByPriceHighToLow() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire","Kitchen","French Door");
        PLPProductItemsPageActions.clickOnSortByDropDownvalues("Price (high to low)", "Price (high to low)");
        PLPProductItemsPageActions.verifyPriceHighToLowSort(FrigidaireConstants.frigidaireWeb);
        ExtentReportManager.getTest().pass("Successfully sort products by Price High to Low");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Biggest Savings")
    public void testSortByBiggestSavings() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire","Kitchen","French Door");
        PLPProductItemsPageActions.clickOnSortByDropDownvalues("Biggest Savings", "Biggest Savings");
        PLPProductItemsPageActions.verifyBiggestSavingsSort("frigidaire");
        ExtentReportManager.getTest().pass("Successfully sort products by Biggest Savings");
    }


}
