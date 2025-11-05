package com.automation.frigidaire.tests.EPIC_04_PLP;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductListingPageActions;
import com.automation.frigidaire.tests.BaseTest;
import com.automation.frigidaire.utils.DriverManager;
import com.automation.frigidaire.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_NAGDTOPS_15687_AQA_PLP_Product_Cards extends BaseTest{
    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductListingPageActions productListingPageActions = new ProductListingPageActions();

    @Test(groups = {"smoke", "regression"}, description = "Verify Kitchen Product Details in Product listing page", priority = 1)
    public void testForKitchen() throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productListingPageActions.clickOnProductMenu("Kitchen");
        productListingPageActions.clickOnProductMenu("French Door");
        productListingPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        //productListingPageActions.closeEmailPopUp();
        productListingPageActions.checkPlpItem("Kitchen");
        ExtentReportManager.getTest().pass("Verify Kitchen product details in product listing page and click on image/productName navigate to PDP");
        DriverManager.quitDriver();
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify Air care Product Details in Product listing page", priority = 2)
    public void testForAirCare() throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productListingPageActions.clickOnProductMenu("Air Care");
        productListingPageActions.clickOnProductMenu("Window Mounted AC");
        productListingPageActions.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        productListingPageActions.closeEmailPopUp();
        productListingPageActions.checkPlpItem("Air Care");
        ExtentReportManager.getTest().pass("Verify Air Care product details in product listing page and click on image/productName navigate to PDP");
        DriverManager.quitDriver();
    }
}
