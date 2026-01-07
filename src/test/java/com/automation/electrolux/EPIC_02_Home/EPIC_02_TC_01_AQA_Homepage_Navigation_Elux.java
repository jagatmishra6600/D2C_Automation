package com.automation.electrolux.EPIC_02_Home;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.BaseTest;
import com.automation.electrolux.locators.HomepageLocatorsElux;
import com.automation.electrolux.pages.HomePageActionsElux;
import com.automation.utils.ExtentReportManager;



public class EPIC_02_TC_01_AQA_Homepage_Navigation_Elux extends BaseTest {

    private final HomePageActionsElux homePage = new HomePageActionsElux();

    @Test(groups = {"regression", "TC_01"})
    public void EPIC_02_HomePage_TC_01_verifyElectroluxLogoOnHomepage() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isBrandLogoLoaded(),
                "Electrolux logo is not displayed on homepage");
        ExtentReportManager.getTest().pass("Home page loaded successfully and logo was verified.");
    }
    
    @Test(groups = {"regression", "TC_01"})
    public void EPIC_02_HomePage_TC_01_verifySearchIconAndInterfaceOnHomepage() throws InterruptedException {

        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isSearchIconDisplayed(), "Search icon is not displayed on homepage");
        Assert.assertTrue(homePage.isSearchInputFieldDisplayed(), "Search input field is not displayed on homepage");
        homePage.clickSearchInputAndEnterText("refrigerator");
        Assert.assertTrue(homePage.areSearchSuggestionsDisplayed(), "Search suggestions are not displayed");
        homePage.selectFirstSuggestion();
        Assert.assertTrue(homePage.isUserOnSearchResultsPage(), "User is not on search results page");
        ExtentReportManager.getTest().pass("Home page loaded successfully and logo was verified.");
    }
    
    @Test(groups = {"regression", "TC_01"}, priority = 10)
    public void EPIC_02_HomePage_TC_01_verifyL0CategoriesInHeader() {
        homePage.navigateToHomePage();
        String[] l0Categories = new String[]{"Vacuums", "Laundry", "Kitchen", "Filters & Accessories", "Owner Resources", "Recipes & Inspiration", "Sale"};
        for (String cat : l0Categories) {
            Assert.assertTrue(homePage.isHeaderCategoryDisplayed(cat), "L0 category not visible: " + cat);
        }
        ExtentReportManager.getTest().pass("Verified L0 header categories are visible: " + String.join(", ", l0Categories));
    }
    
    @Test(groups = {"regression", "TC_01"})
    public void EPIC_02_HomePage_TC_01_TCverifyVacuumsL1SubcategoriesVisible() {
        homePage.navigateToHomePage();
        homePage.openHeaderCategory("Vacuums");
        String[] VacuumsSubcats = new String[]{ "Vacuums","Explore Vacuums","Shop All Vacuums"};
        for (String sub : VacuumsSubcats) {
            Assert.assertTrue(homePage.isHeaderSubcategoryDisplayed(sub), "Vacuums subcategory not visible: " + sub);
        }
        ExtentReportManager.getTest().pass("Verified Vacuums L1 subcategories are visible (sample set).");
    }  

    @Test(groups = { "regression", "TC_01" })
    public void EPIC_02_HomePage_TC_01_verifyLaundryL1SubcategoriesVisible() {

        homePage.navigateToHomePage();
        homePage.openHeaderCategory("Laundry");
           String[] LaundrySubcats = new String[]{ "Washers",
                    "Dryers",
                    "Stacked Washer & Dryer Units",
                    "Pedestal Drawers",
                    "Electric Dryer Sets",
                    "Gas Dryer Sets"};
            for (String sub : LaundrySubcats) {
                Assert.assertTrue(homePage.isHeaderSubcategoryDisplayed(sub), "Laundry subcategory not visible: " + sub);
            }
        
        ExtentReportManager.getTest().pass("Verified Laundry L1 subcategories are visible.");
    }
    
    @Test(groups = { "regression", "TC_01" })
    public void EPIC_02_HomePage_TC_01_verifyKitchenL1SubcategoriesVisible() {
        homePage.navigateToHomePage();
        homePage.openHeaderCategory("Kitchen");
        
        String[] LaundrySubcats = new String[]{"Induction", "Dual Fuel", "Single", "Double", "Microwave Combination",
                                      "Single Door", "French Door", "Wine & Beverages Cooler", "Induction",
                                      "Gas Cooktops & Rangetops", "Microwaves",
                                      "Dishwasher", "Ventilation"};

        for (String sub : LaundrySubcats) {
            Assert.assertTrue(homePage.isHeaderSubcategoryDisplayed(sub), "Laundry subcategory not visible: " + sub);
        }
        ExtentReportManager.getTest().pass("Verified Laundry L1 subcategories are visible.");
    }
    
    @Test(groups = { "regression", "TC_01" })
    public void EPIC_02_HomePage_TC_01_verifyFiltersAndAccessoriesL1SubcategoriesVisible() {
        homePage.navigateToHomePage();
        homePage.openHeaderCategory("Filters & Accessories");
        
        String[] FiltersAndAccessoriesSubcats = new String[]{"Filters & Bags", "Accessories", "Shop Air Purfiers", "Filters", "Water Filters",
                                      "Air Filters", "Accessories", "Accessories", "Washer Cleaners",
                                      "Cooking & Ventilation",
                                       "Touch Up Paint"};

        for (String sub : FiltersAndAccessoriesSubcats) {
            Assert.assertTrue(homePage.isHeaderSubcategoryDisplayed(sub), "Laundry subcategory not visible: " + sub);
        }
        ExtentReportManager.getTest().pass("Verified Filters And Accessories L1 subcategories are visible.");
    }
    
    @Test(groups = { "regression", "TC_01" })
    public void EPIC_02_HomePage_TC_01_verifyOwnerResourcesL1SubcategoriesVisible() {
        homePage.navigateToHomePage();
        homePage.openHeaderCategory("Owner Resources");
        
        String[] OwnerResourcesSubcats = new String[]{ "Resource Library",
                "Product Support",
                "Google Assistant",
                "Alexa Assistant",   "Product Registration",
                "Warranty Information",
                "Contact Service & Repair",
                "Appliance Protection Plans",  "Contact Us",
                "Prepare for Your Delivery"};

        for (String sub : OwnerResourcesSubcats) {
            Assert.assertTrue(homePage.isHeaderSubcategoryDisplayed(sub), "Laundry subcategory not visible: " + sub);
        }
        ExtentReportManager.getTest().pass("Verified Owner Resources L1 subcategories are visible.");
    }
    
    @Test(groups = { "regression", "TC_01" })
    public void EPIC_02_HomePage_TC_01_verifyRecipesAndInspirationL1SubcategoriesVisible() {
        homePage.navigateToHomePage();
        homePage.openHeaderCategory("Recipes & Inspiration");
        
        String[] RecipesAndInspirationSubcats = new String[]{ 
                "Air Sous Vide",
                "Reducing Food Waste",
                "Steam Oven Cooking",
                "Celebrating The Southern Soufflé",
                "DIY Red Wine Reduction Sauce",
                "From Stem to Root",
                "Homemade Olive Oil Bread",
                "Incorporating Apples in Your Soup",
                "Moscow Mule with Vanilla Bean",
                "Sea Salt Pumpkin Caramels with Pine Nuts",
                "Olive Oil Mini Cakes",
                "Unexpected Methods and Tips for Cooking Greens",
                "A Growing Fashion Trend: Sustainability",
                "Caring For Your Fabrics",
                "How to Refresh Neutrals",
                "Expanding Your Herb Garden",
                "7 Ways to Revamp Your Laundry Room in a Big Way"};

        for (String sub : RecipesAndInspirationSubcats) {
            Assert.assertTrue(homePage.isHeaderSubcategoryDisplayed(sub), "Laundry subcategory not visible: " + sub);
        }
        ExtentReportManager.getTest().pass("Verified Recipes And Inspiration L1 subcategories are visible.");
    }
    
    @Test(groups = { "regression", "TC_01" })
    public void EPIC_02_HomePage_TC_01_verifySaleL1SubcategoriesVisible() {

        homePage.navigateToHomePage();
        homePage.openHeaderCategory("Sale");
           String[] SaleSubcats = new String[]{
                   "Military Discount",
                    "First Responder Discount",
                    "Teacher Discount",
                    "Healthcare Discount" };
            for (String sub : SaleSubcats) {
                Assert.assertTrue(homePage.isHeaderSubcategoryDisplayed(sub), "Laundry subcategory not visible: " + sub);
            }
        
        ExtentReportManager.getTest().pass("Verified Sale L1 subcategories are visible.");
    }
    
    @Test(groups = { "regression", "TC_01" })
    public void EPIC_02_HomePage_TC_01_verifyTermsOfOfferSelectionDisplayed() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isTermsOfOfferSelectionDisplayed(), "Terms Of Offer section is NOT displayed");
    }
}