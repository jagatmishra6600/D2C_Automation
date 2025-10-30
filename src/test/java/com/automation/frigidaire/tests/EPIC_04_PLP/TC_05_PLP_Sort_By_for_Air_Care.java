package com.automation.frigidaire.tests.EPIC_04_PLP;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions;
import com.automation.frigidaire.pages.PLPProductItemsPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_05_PLP_Sort_By_for_Air_Care {


    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductCategoryPageActions productCategoryPageActions=new ProductCategoryPageActions();
    PLPProductItemsPageActions PLPProductItemsPageActions =new PLPProductItemsPageActions();

    public void navigateToAirCare(String prodCategory , String subProdCategory ) throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");

        productCategoryPageActions.clickOnProductMenu(prodCategory);
        productCategoryPageActions.clickOnProductMenu(subProdCategory);
      //  productItemsPageActions.closeEmailPopUp();

    }


    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price Low to High")
    public void testSortByPriceLowToHigh() throws InterruptedException {
        navigateToAirCare("Air Care","Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners","Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.clickOnSortByDropDownvalues("Price (low to high)", "Price (low to high)");
        PLPProductItemsPageActions.verifyPriceLowToHighSort();
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price High to Low")
    public void testSortByPriceHighToLow() throws InterruptedException {
        navigateToAirCare("Air Care","Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners","Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.clickOnSortByDropDownvalues("Price (high to low)", "Price (high to low)");
        PLPProductItemsPageActions.verifyPriceHighToLowSort();
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Biggest Savings")
    public void testSortByBiggestSavings() throws InterruptedException {
        navigateToAirCare("Air Care","Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners","Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.clickOnSortByDropDownvalues("Biggest Savings", "Biggest Savings");
        PLPProductItemsPageActions.verifyBiggestSavingsSort();
    }
}
