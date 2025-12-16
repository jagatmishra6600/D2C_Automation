package com.automation.frigidaire.EPIC_04_PLP;

import com.automation.BaseTest;
import com.automation.frigidaire.locators.ConstantsLocatorsFrig;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.ProductCategoryPageActionsFrig;
import com.automation.frigidaire.pages.PLPProductItemsPageActionsFrig;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_04_TC_02_PLP_Sort_By_for_Air_Care_Frig extends BaseTest {


    HomePageActionsFrig homePage = new HomePageActionsFrig();
    ProductCategoryPageActionsFrig productCategoryPageActionsFrig = new ProductCategoryPageActionsFrig();
    PLPProductItemsPageActionsFrig PLPProductItemsPageActionsFrig = new PLPProductItemsPageActionsFrig();

    public void navigateToAirCare(String webSite, String prodCategory, String subProdCategory) throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");

        productCategoryPageActionsFrig.clickOnProductMenu(webSite, prodCategory);
        productCategoryPageActionsFrig.clickOnProductMenu(webSite, subProdCategory);
        PLPProductItemsPageActionsFrig.closeEmailPopUp();

    }


    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price Low to High")
    public void  EPIC_04_PLP_TC_02_testSortByPriceLowToHigh() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActionsFrig.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActionsFrig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActionsFrig.clickOnSortByDropDownvalues("Price (low to high)", "Price (low to high)");
        PLPProductItemsPageActionsFrig.verifyPriceLowToHighSort(ConstantsLocatorsFrig.frigidaireWeb);
        ExtentReportManager.getTest().pass("Successfully sort products by Price Low to High (Aire Care)");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price High to Low")
    public void  EPIC_04_PLP_TC_02_testSortByPriceHighToLow() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActionsFrig.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActionsFrig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActionsFrig.clickOnSortByDropDownvalues("Price (high to low)", "Price (high to low)");
        PLPProductItemsPageActionsFrig.verifyPriceHighToLowSort(ConstantsLocatorsFrig.frigidaireWeb);
        ExtentReportManager.getTest().pass("Successfully sort products by Price High to Low (Aire Care)");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Biggest Savings")
    public void EPIC_04_PLP_TC_02_testSortByBiggestSavings() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActionsFrig.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActionsFrig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActionsFrig.clickOnSortByDropDownvalues("Biggest Savings", "Biggest Savings");
        PLPProductItemsPageActionsFrig.verifyBiggestSavingsSort("frigidaire");
        ExtentReportManager.getTest().pass("Successfully sort products by Price Biggest Savings (Aire Care)");
    }


}
