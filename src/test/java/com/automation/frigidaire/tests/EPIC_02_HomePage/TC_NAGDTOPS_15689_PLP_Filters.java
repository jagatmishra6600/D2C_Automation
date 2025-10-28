package com.automation.frigidaire.tests.EPIC_02_HomePage;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions;
import com.automation.frigidaire.pages.ProductItemsPageActions;
import com.automation.frigidaire.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NAGDTOPS_15689_PLP_Filters  extends BaseTest {
    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductCategoryPageActions productCategoryPageActions=new ProductCategoryPageActions();
    ProductItemsPageActions productItemsPageActions =new ProductItemsPageActions();

    @Test(groups = {"smoke", "regression"}, description = "Should load the Frigidaire home page successfully")
    public void testHomePageLoad() {

        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        System.out.println("clicked on Kitchen product");
        productCategoryPageActions.clickOnProductMenu("French Door");
        System.out.println("clicked on frenchDoor product");
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators");
    }
    @Test(groups = {"smoke", "regression"},  dependsOnMethods = {"testHomePageLoad"}, description = "Should load the Frigidaire home page successfully")
    public void verifyFiltersInProductItems()
    {

    }
}
