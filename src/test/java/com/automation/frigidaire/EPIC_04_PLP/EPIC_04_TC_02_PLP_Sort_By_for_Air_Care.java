package com.automation.frigidaire.EPIC_04_PLP;

import com.automation.BaseTest;
import com.automation.frigidaire.locators.FrigidaireConstants;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions_Frig;
import com.automation.frigidaire.pages.PLPProductItemsPageActions_Frig;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_04_TC_02_PLP_Sort_By_for_Air_Care extends BaseTest {


    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductCategoryPageActions_Frig productCategoryPageActionsFrig = new ProductCategoryPageActions_Frig();
    PLPProductItemsPageActions_Frig PLPProductItemsPageActions_Frig = new PLPProductItemsPageActions_Frig();

    public void navigateToAirCare(String webSite, String prodCategory, String subProdCategory) throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");

        productCategoryPageActionsFrig.clickOnProductMenu(webSite, prodCategory);
        productCategoryPageActionsFrig.clickOnProductMenu(webSite, subProdCategory);
        PLPProductItemsPageActions_Frig.closeEmailPopUp();

    }


    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price Low to High")
    public void  EPIC_04_PLP_TC_02_testSortByPriceLowToHigh() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.clickOnSortByDropDownvalues("Price (low to high)", "Price (low to high)");
        PLPProductItemsPageActions_Frig.verifyPriceLowToHighSort(FrigidaireConstants.frigidaireWeb);
        ExtentReportManager.getTest().pass("Successfully sort products by Price Low to High (Aire Care)");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price High to Low")
    public void  EPIC_04_PLP_TC_02_testSortByPriceHighToLow() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.clickOnSortByDropDownvalues("Price (high to low)", "Price (high to low)");
        PLPProductItemsPageActions_Frig.verifyPriceHighToLowSort(FrigidaireConstants.frigidaireWeb);
        ExtentReportManager.getTest().pass("Successfully sort products by Price High to Low (Aire Care)");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Biggest Savings")
    public void EPIC_04_PLP_TC_02_testSortByBiggestSavings() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.clickOnSortByDropDownvalues("Biggest Savings", "Biggest Savings");
        PLPProductItemsPageActions_Frig.verifyBiggestSavingsSort("frigidaire");
        ExtentReportManager.getTest().pass("Successfully sort products by Price Biggest Savings (Aire Care)");
    }


}
