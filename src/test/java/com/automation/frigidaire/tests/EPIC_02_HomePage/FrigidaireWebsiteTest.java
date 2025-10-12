package com.automation.frigidaire.tests.EPIC_02_HomePage;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions;
import com.automation.frigidaire.pages.SearchResultsPageActions;
import com.automation.frigidaire.tests.BaseTest;
import com.automation.frigidaire.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrigidaireWebsiteTest extends BaseTest {
    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    @Test(groups = {"smoke", "regression"}, description = "Should load the Frigidaire home page successfully")
    public void testHomePageLoad() {

        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        ExtentReportManager.getTest().pass("Home page loaded successfully and logo was verified.");
    }

    @Test(groups = {"smoke", "regression"}, description = "Should search for a product and display results")
    public void testSearchFunctionality() {
       String searchTerm = "refrigerator";

        homePage.navigateToHomePage();
        SearchResultsPageActions resultsPage = homePage.searchForProduct(searchTerm);

        Assert.assertTrue(resultsPage.isPageLoaded(), "Search results page failed to load.");
        Assert.assertTrue(resultsPage.areResultsFound(), "No search results were found for '" + searchTerm + "'.");
        ExtentReportManager.getTest().pass("Search for '" + searchTerm + "' was successful and results were verified.");
    }

    @Test(groups = {"regression"}, description = "Should navigate to the Products category page")
    public void testNavigationToProductsPage() {
        homePage.navigateToHomePage();
        ProductCategoryPageActions productsPage = homePage.clickProductsLink();
        Assert.assertTrue(productsPage.isPageLoaded(), "The Products category page did not load correctly.");
        ExtentReportManager.getTest().pass("Successfully navigated to the Products category page.");
    }

    @Test(groups = {"broken"}, description = "This test is designed to fail to show reporting")
    public void testFailingExample() {

        homePage.navigateToHomePage();
        Assert.assertTrue(false, "This is an intentional failure to test the reporting feature.");
    }
}