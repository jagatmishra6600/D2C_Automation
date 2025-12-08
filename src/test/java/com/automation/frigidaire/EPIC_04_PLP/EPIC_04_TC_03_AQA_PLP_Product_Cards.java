package com.automation.frigidaire.EPIC_04_PLP;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductItemsPageActions;
import com.automation.frigidaire.pages.ProductListingPageActions;

import com.automation.utils.DriverManager;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EPIC_04_TC_03_AQA_PLP_Product_Cards extends BaseTest {
    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductListingPageActions productListingPageActions = new ProductListingPageActions();
    ProductItemsPageActions productItems = new ProductItemsPageActions();


    @Test(groups = {"smoke", "regression"}, description = "Verify Kitchen Product Details in Product listing page", priority = 1)
    public void EPIC_04_PLP_TC_03_testForKitchen() throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productListingPageActions.clickOnProductMenu("Kitchen");
        productListingPageActions.clickOnProductMenu("French Door");
        productListingPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        productItems.closeEmailPopUp();
        productListingPageActions.checkPlpItem("Kitchen", 0);
        ExtentReportManager.getTest().pass("Verify Kitchen product details in product listing page and click on image, product name and rating navigate to PDP");
        DriverManager.quitDriver();
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify Air care Product Details in Product listing page", priority = 2)
    public void EPIC_04_PLP_TC_03_testForAirCare() throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productListingPageActions.clickOnProductMenu("Air Care");
        productListingPageActions.clickOnProductMenu("Window Mounted AC");
        productListingPageActions.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        productItems.closeEmailPopUp();
        productListingPageActions.checkPlpItem("Air Care", 1);
        ExtentReportManager.getTest().pass("Verify Air Care product details in product listing page and click on image,productName and rating navigate to PDP");
        DriverManager.quitDriver();
    }
}
