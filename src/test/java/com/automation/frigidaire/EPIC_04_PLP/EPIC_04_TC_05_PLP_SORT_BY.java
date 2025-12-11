package com.automation.frigidaire.EPIC_04_PLP;

import com.automation.BaseTest;
import com.automation.frigidaire.locators.FrigidaireConstants;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions_Frig;
import com.automation.frigidaire.pages.PLPProductItemsPageActions_Frig;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_04_TC_05_PLP_SORT_BY extends BaseTest {

    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductCategoryPageActions_Frig productCategoryPageActionsFrig = new ProductCategoryPageActions_Frig();
    PLPProductItemsPageActions_Frig PLPProductItemsPageActions_Frig = new PLPProductItemsPageActions_Frig();


    public void navigateToFrenchDoorRefrigerators(String webSite, String prodCategory, String subProdCategory) throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActionsFrig.clickOnProductMenu(webSite, "Kitchen");
        productCategoryPageActionsFrig.clickOnProductMenu(webSite, "French Door");
        PLPProductItemsPageActions_Frig.closeEmailPopUp();
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        ExtentReportManager.getTest().pass("Successfully navigated to the Products category page.");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price Low to High")
    public void EPIC_04_PLP_TC_05_testSortByPriceLowToHigh() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.clickOnSortByDropDownvalues("Price (low to high)", "Price (low to high)");
        PLPProductItemsPageActions_Frig.verifyPriceLowToHighSort(FrigidaireConstants.frigidaireWeb);
        ExtentReportManager.getTest().pass("Successfully sort products by Price Low to High");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price High to Low")
    public void EPIC_04_PLP_TC_05_testSortByPriceHighToLow() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.clickOnSortByDropDownvalues("Price (high to low)", "Price (high to low)");
        PLPProductItemsPageActions_Frig.verifyPriceHighToLowSort(FrigidaireConstants.frigidaireWeb);
        ExtentReportManager.getTest().pass("Successfully sort products by Price High to Low");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Biggest Savings")
    public void EPIC_04_PLP_TC_05_testSortByBiggestSavings() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.clickOnSortByDropDownvalues("Biggest Savings", "Biggest Savings");
        PLPProductItemsPageActions_Frig.verifyBiggestSavingsSort("frigidaire");
        ExtentReportManager.getTest().pass("Successfully sort products by Biggest Savings");
    }


}
