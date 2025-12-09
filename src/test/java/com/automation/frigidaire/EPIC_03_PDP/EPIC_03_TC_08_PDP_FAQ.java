package com.automation.frigidaire.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.FAQPage;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;

import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_08_PDP_FAQ extends BaseTest {

    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    FAQPage faqPage = new FAQPage();

    @Test(groups = {"regression", "smoke"}, priority = 1)
    public void EPIC_03_PDP_TC_02_testForFrigidaireFAQ() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        faqPage.clickOnProductMenu("Owner Support");
        faqPage.clickOnProductMenu("FAQs & How-Tos");
        faqPage.verifyFAQHeaderText();
        faqPage.verifyFAQSecond();
        faqPage.verifyAndClickAllCategoryTiles();
        ExtentReportManager.getTest().pass("Verified the functionality of the FAQ Section and verify all the sub categories");
    }

    @Test(groups = {"regression", "smoke"}, priority = 2)
    public void EPIC_03_PDP_TC_02_testForFAQForKitchen() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        faqPage.clickOnProductMenu("Owner Support");
        faqPage.clickOnProductMenu("FAQs & How-Tos");
        faqPage.verifySearchBoxVisible();
        faqPage.verifyAllFAQArticlesRefrigerator();
        ExtentReportManager.getTest().pass("Verified the FAQ for French Door Refrigerator within the Kitchen category and navigated to the article pages successfully");
    }

    @Test(groups = {"regression", "smoke"}, priority = 3)
    public void EPIC_03_PDP_TC_02_testForFAQForAirCare() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        faqPage.clickOnProductMenu("Owner Support");
        faqPage.clickOnProductMenu("FAQs & How-Tos");
        faqPage.verifySearchBoxVisibles();
        faqPage.verifyAllFAQArticlesRoomAC();
        ExtentReportManager.getTest().pass("Verified the FAQ for Window Mounted Air Conditioner within the Room AC category and navigated to the article pages successfully");
    }

}
