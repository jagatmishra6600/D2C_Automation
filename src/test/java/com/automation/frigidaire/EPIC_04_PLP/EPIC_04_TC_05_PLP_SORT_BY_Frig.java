package com.automation.frigidaire.EPIC_04_PLP;

import com.automation.BaseTest;
import com.automation.frigidaire.locators.ConstantsLocatorsFrig;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.ProductCategoryPageActionsFrig;
import com.automation.frigidaire.pages.PLPProductItemsPageActionsFrig;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_04_TC_05_PLP_SORT_BY_Frig extends BaseTest {

    HomePageActionsFrig homePage = new HomePageActionsFrig();
    ProductCategoryPageActionsFrig productCategoryPageActionsFrig = new ProductCategoryPageActionsFrig();
    PLPProductItemsPageActionsFrig PLPProductItemsPageActionsFrig = new PLPProductItemsPageActionsFrig();


    public void navigateToFrenchDoorRefrigerators(String webSite, String prodCategory, String subProdCategory) throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActionsFrig.clickOnProductMenu(webSite, "Kitchen");
        productCategoryPageActionsFrig.clickOnProductMenu(webSite, "French Door");
        PLPProductItemsPageActionsFrig.closeEmailPopUp();
        PLPProductItemsPageActionsFrig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActionsFrig.verifyFiltersInProductItems("Availability", 60, "Availability");
        ExtentReportManager.getTest().pass("Successfully navigated to the Products category page.");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price Low to High")
    public void EPIC_04_PLP_TC_05_testSortByPriceLowToHigh() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActionsFrig.clickOnSortByDropDownvalues("Price (low to high)", "Price (low to high)");
        PLPProductItemsPageActionsFrig.verifyPriceLowToHighSort(ConstantsLocatorsFrig.frigidaireWeb);
        ExtentReportManager.getTest().pass("Successfully sort products by Price Low to High");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price High to Low")
    public void EPIC_04_PLP_TC_05_testSortByPriceHighToLow() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActionsFrig.clickOnSortByDropDownvalues("Price (high to low)", "Price (high to low)");
        PLPProductItemsPageActionsFrig.verifyPriceHighToLowSort(ConstantsLocatorsFrig.frigidaireWeb);
        ExtentReportManager.getTest().pass("Successfully sort products by Price High to Low");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Biggest Savings")
    public void EPIC_04_PLP_TC_05_testSortByBiggestSavings() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActionsFrig.clickOnSortByDropDownvalues("Biggest Savings", "Biggest Savings");
        PLPProductItemsPageActionsFrig.verifyBiggestSavingsSort("frigidaire");
        ExtentReportManager.getTest().pass("Successfully sort products by Biggest Savings");
    }


}
