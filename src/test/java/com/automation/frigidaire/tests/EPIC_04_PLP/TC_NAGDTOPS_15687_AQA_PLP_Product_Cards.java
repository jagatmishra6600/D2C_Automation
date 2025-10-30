package com.automation.frigidaire.tests.EPIC_04_PLP;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductListingPageActions;
import com.automation.frigidaire.tests.BaseTest;
import com.automation.frigidaire.utils.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_NAGDTOPS_15687_AQA_PLP_Product_Cards extends BaseTest {
    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductListingPageActions productListingPageActions = new ProductListingPageActions();

    @Test(groups = {"smoke", "regression"})
    public void testForKitchen(){
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productListingPageActions.clickOnProductMenu("Kitchen");
        productListingPageActions.clickOnProductMenu("French Door");
        productListingPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        //productListingPageActions.closeEmailPopUp();
        productListingPageActions.verifyProduct("22 Cu. Ft. Counter-Depth 4-Door Refrigerator with Free Additional Filter Kit");
        System.out.println("Done");
        DriverManager.quitDriver();
    }

    @Test(groups = {"smoke", "regression"})
    public void testForAirCare(){
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productListingPageActions.clickOnProductMenu("Air Care");
        productListingPageActions.clickOnProductMenu("Window Mounted AC");
        productListingPageActions.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        //productListingPageActions.closeEmailPopUp();
        productListingPageActions.verifyProduct("10,000 BTU Inverter Window Room Air Conditioner with Wi-Fi (Energy Star)");
        System.out.println("Done");
        DriverManager.quitDriver();
    }
}
