package com.automation.frigidaire.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.FAQPage;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.utils.DriverManager;
import com.automation.frigidaire.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NAGDTOPS_15700_AQA_Frigidaire_PDP_FAQ extends BaseTest {

    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    FAQPage faqPage = new FAQPage();

    @Test(groups = {"regression", "smoke"}, priority = 1)
    public void testForFrigidaireFAQ() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        faqPage.clickOnProductMenu("Owner Support");
        faqPage.clickOnProductMenu("FAQs & How-Tos");
        faqPage.verifyFAQHeaderText();
        faqPage.verifyFAQSecond();
        faqPage.verifyAndClickAllCategoryTiles();
        ExtentReportManager.getTest().pass("Verified the functionality of the FAQ feature — shopper " + "successfully navigated from 'Owner Support' → 'FAQs and How-Tos' to the 'Owner Center Resource" + " Library' page, confirmed banner title, search input with suggestions, and visibility " + "of product category tiles: Accessories, Filters, General Knowledge, Home Comfort, Kitchen, " + "Laundry, and Online Orders and Delivery, each leading to its respective subcategory page.");
    }

    @Test(groups = {"regression", "smoke"}, priority = 2)
    public void testForFAQForKitchen() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        faqPage.clickOnProductMenu("Owner Support");
        faqPage.clickOnProductMenu("FAQs & How-Tos");
        faqPage.verifySearchBoxVisible();
        faqPage.verifyAllFAQArticlesRefrigerator();

        ExtentReportManager.getTest().pass("Verified the FAQ for French Door Refrigerator — shopper successfully" + " navigated via Kitchen → Refrigerators tile, confirmed visibility of search topic" + " input box, and verified that the list of recommended Refrigerator " + "articles are displayed as clickable links leading to their respective article pages.");
    }

    @Test(groups = {"regression", "smoke"}, priority = 3)
    public void testForFAQForAirCare() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        faqPage.clickOnProductMenu("Owner Support");
        faqPage.clickOnProductMenu("FAQs & How-Tos");
        faqPage.verifySearchBoxVisibles();
        faqPage.verifyAllFAQArticlesRoomAC();

        ExtentReportManager.getTest().pass("Verified the FAQ for Window Mounted Air Conditioner — shopper successfully" + " navigated via Home Comfort → Room AC tile, confirmed visibility of search topic input box, and verified " + "that the list of recommended Room AC articles are displayed as clickable links leading to their" + " respective article pages.");

        DriverManager.quitDriver();
    }

}
