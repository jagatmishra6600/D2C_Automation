package com.automation.frigidaire.EPIC_03_PDP;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductItemsPageActions;
import com.automation.BaseTest;
import com.automation.frigidaire.utils.DataProviders;
import com.automation.frigidaire.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_NAGDTOPS_15684_AQA_PDP_Out_Of_Stock extends BaseTest {

    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductItemsPageActions productItems = new ProductItemsPageActions();

    @Test(dataProvider = "kitchenProductData", dataProviderClass = DataProviders.class, groups = {"regression", "smoke"})
    public void EPIC_03_PDP_TC_01_testStockForKitchen(String productMenu, String subProduct, String productName, String expectedPageTitle) {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productItems.clickOnProductMenu(productMenu);
        productItems.clickOnProductMenu(subProduct);
        // productItems.closeEmailPopUp();
        productItems.verifyProductItemPage(expectedPageTitle, expectedPageTitle);
        productItems.checkAndHandleNotifyMeForKitchen(productName, "boxifid681@dwakm.com");
        ExtentReportManager.getTest().pass("Verified that the Product displays stock availability " + " either 'Add to Cart' with earliest delivery date when in stock, or 'Temporarily out of stock in " + "your area' message with email notification option when unavailable.");

    }

    @Test(dataProvider = "airConditionersProductData", dataProviderClass = DataProviders.class, groups = {"regression", "smoke"})
    public void EPIC_03_PDP_TC_01_testStockForAirConditioners(String productMenu, String subProduct, String productName, String expectedPageTitle) {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productItems.clickOnProductMenu(productMenu);
        productItems.clickOnProductMenu(subProduct);
        // productItems.closeEmailPopUp();
        productItems.verifyProductItemPage(expectedPageTitle, expectedPageTitle);
        productItems.checkAndHandleNotifyMeForAirConditioners(productName, "boxifid681@dwakm.com");

        ExtentReportManager.getTest().pass("Verified that the Product displays stock availability " + "either 'Add to Cart' with earliest delivery date when in stock, or 'Temporarily out of stock in " + "your area' message with email notification option when unavailable.");
    }
}
