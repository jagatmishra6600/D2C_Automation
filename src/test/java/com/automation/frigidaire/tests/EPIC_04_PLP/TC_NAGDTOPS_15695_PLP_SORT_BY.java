package com.automation.frigidaire.tests.EPIC_04_PLP;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions;
import com.automation.frigidaire.pages.PLPProductItemsPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NAGDTOPS_15695_PLP_SORT_BY {

    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductCategoryPageActions productCategoryPageActions=new ProductCategoryPageActions();
    PLPProductItemsPageActions PLPProductItemsPageActions =new PLPProductItemsPageActions();



    public void navigateToFrenchDoorRefrigerators() throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
        //productItemsPageActions.closeEmailPopUp();
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price Low to High")
    public void testSortByPriceLowToHigh() throws InterruptedException {
        navigateToFrenchDoorRefrigerators();
        PLPProductItemsPageActions.clickOnSortByDropDownvalues("Price (low to high)", "Price (low to high)");
        PLPProductItemsPageActions.verifyPriceLowToHighSort();
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Price High to Low")
    public void testSortByPriceHighToLow() throws InterruptedException {
        navigateToFrenchDoorRefrigerators();
        PLPProductItemsPageActions.clickOnSortByDropDownvalues("Price (high to low)", "Price (high to low)");
        PLPProductItemsPageActions.verifyPriceHighToLowSort();
    }

    @Test(groups = {"smoke", "regression"}, description = "Should sort products by Biggest Savings")
    public void testSortByBiggestSavings() throws InterruptedException {
        navigateToFrenchDoorRefrigerators();
        PLPProductItemsPageActions.clickOnSortByDropDownvalues("Biggest Savings", "Biggest Savings");
        PLPProductItemsPageActions.verifyBiggestSavingsSort();
    }


}
