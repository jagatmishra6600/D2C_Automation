package com.automation.frigidaire.tests.EPIC_02_HomePage;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.tests.BaseTest;
import com.automation.frigidaire.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TC_01_AQA_Homepage_Navigation extends BaseTest {
    private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();

    @Test(groups = {"regression"}, priority = 1)
    public void verifyFrigidaireLogoOnHomepage() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isBrancdLogoLoaded(), "Frigidaire logo is not displayed on homepage");
        ExtentReportManager.getTest().pass("Home page loaded successfully and logo was verified.");
    }

    @Test(groups = {"regression"}, priority = 2)
    public void verifySearchIconAndInterfaceOnHomepage() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isSearchIconDisplayed(), "Search icon is not displayed on homepage");
        Assert.assertTrue(homePage.isSearchInputFieldDisplayed(), "Search input field is not displayed on homepage");
        homePage.clickSearchInputAndEnterText("refrigerator");
        Assert.assertTrue(homePage.areSearchSuggestionsDisplayed(), "Search suggestions are not displayed");
        homePage.selectFirstSuggestion();
        Assert.assertTrue(homePage.isUserOnSearchResultsPage(), "User is not on search results page");
        ExtentReportManager.getTest().pass("Home page loaded successfully and logo was verified.");
    }


////    To verify the L0 and L1 Product category navigation displayed on top of the homepage
////    The shopper should be able to see the following L0 and L1 Categories in navigation bar:
////
////    L0 Kitchen:
////
////    Refrigerators:
////    French Door
////    Side-by-Side
////    Single Door
////    Top Freezer
////    Bottom Freezer
////    Compact
////    Wine & Beverage
////    Freezers:
////    Single Door
////    Upright
////            Chest
////    Dishwashers:
////    Built-in-Dishwashers
////    Ranges & Stoves:
////    Induction
////            Gas
////    Electric
////    Dual Fuel
////    Explore Pizza
////    Cooktops:
////    Induction
////            Gas
////    Electric
////    Wall Ovens:
////    Single
////            Double
////    Microwave Combination
////    Microwaves:
////    Built-In
////    Over-the-Range
////            Ventilation
////    Kitchen Packages
////    Small Appliances:
////    Retro Mini Fridges
////    Espresso Makers
////    Air Fryers
////    Ice Makers
////    Garbage Disposals
////    L0 Air Conditioners:
////
////    Air Conditioners:
////    Window Mounted
////    Wall
////            Portable
////    More In Room Air:
////    Dehumidifiers
////            HVAC
////    L0 Air Care:
////
////    Air Purifiers
////    Dehumidifiers
////    L0 Laundry:
////
////    Frigidaire Laundry:
////    Washers
////            Dryers
////    Laundry Centers
////    Electrolux Laundry:
////    Washers
////            Dryers
////    Stacked Washer & Dryer
////    L0 Filters:
////
////    Filters:
////    Water Filters
////    Refrigerator Air Filters
////    Water & Air Filter Combo
////    Air Conditioner Filters
////    Furnace & HVAC Filters
////    Microwave Filters
////    Ventilation Filters
////    More In Filters:
////    Subscribe & Save
////    Genuine Water Filters
////    L0 Accessories:
////
////    Refrigeration:
////    Ice Makers
////    Trim Kits
////    Organizer Bins
////    Installation Parts
////    Dishwashers:
////    Installation Parts
////    Wall Ovens:
////    Trim Kits
////    Racks & Air Fry Trays
////    Cookware & Bakeware
////    Microwaves:
////    Trim Kits
////    Installation Parts
////    Ranges & Stoves:
////    Trim Kits
////    Racks & Air Fry Trays
////    Cookware & Bakeware
////    Installation Parts
////    Air Conditioners
////    Laundry:
////    Installation Parts
////    Cleaners
////    Repair & Replacement Parts
////    Appliance Paint
////    L0 Owner Support:
////
////    Resource Library:
////    Create an Account
////    Write a Review
////    Register Your Appliance
////    FAQs & How-Tos
////    Product Support
////    Service & Maintenance:
////    Prepare for Your Delivery
////    Warranty Information
////    Appliance Protection Plans
////    Replacement Parts
////    Contact Service & Repair
////    L0 Blog:
////
////    All Blogs
////    Appliance Tips
////    Recipes
////    Kitchen Design
////    Our Brand
////    L0 Sale:
////
////    Promotions:
////    Fall Savings Deal (if applicable)
////    Deal of the Week
////    Rebates
////    Discount:
////    Military Discount
////    First Responders Discount
////    Healthcare Professionals
////    Teachers Discount
////    NOTE: All L0 except Owner Support and Blog will have a small Marketing Banner
//
//
////    To verify the promotional banners on the homepage
////    The shopper should be able to see different kinds of promotional and marketing banners on the homepage like:
////
////    Header Promotion
////    Tiered Discount Banner
////    Weekly and & Category Deals Section etc.
////    The banners should have a clickable action button related to the content displayed
//    @Test(priority = 3)
//    public void verifyPromotionalBannersOnHomepage() {
//        Assert.assertTrue(homePage.arePromotionalBannersDisplayed(), "Promotional banners are not displayed");
//        Assert.assertTrue(homePage.areBannerActionButtonsClickable(), "Banner action buttons are not clickable");
//    }

    @Test(groups = {"regression", "TC_02"}, priority = 4)
    public void verifyShopOurCategoriesSection() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isShopOurCategoriesSectionDisplayed(), "'Shop Our Categories' section is not displayed");
        List<String> expectedCategories = Arrays.asList(
            "Refrigerators", "Freezers", "Ranges", "Cooktops", "Wall Ovens",
            "Dishwashers", "Microwaves", "Window Air Conditioners",
            "Portable Air Conditioners", "Wall Air Conditioners", "Dehumidifiers", "Air Purifiers"
        );
        List<String> actualCategories = homePage.getShopOurCategories();
        Assert.assertEquals(actualCategories, expectedCategories, "Categories in 'Shop Our Categories' section do not match");
    }


    @Test(groups = {"regression", "TC_02"}, priority = 5)
    public void verifyShopOurTopRatedAppliancesSection() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isShopOurTopRatedAppliancesSectionDisplayed(), "'Shop our Top-Rated, Most Feature-Packed Appliances' section is not displayed");
        Assert.assertTrue(homePage.areProductCardsElementsDisplayed(), "Elements on product cards are not displayed correctly");
        homePage.clickFirstProductCard();
        Assert.assertTrue(homePage.isUserOnPDP(), "Clicking on product card does not navigate to PDP");
    }

//    To verify the 'More to Explore from Frigidare' section
//    The shopper should see product banners with image, information and an action button
    @Test(groups = {"regression", "TC_02"}, priority = 6)
    public void verifyMoreToExploreSection() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isMoreToExploreSectionDisplayed(), "'More to Explore from Frigidaire' section is not displayed");
        List<String> expectedMoreToExp = Arrays.asList("NEW! Shop Air Purifiers", "Shop Small Appliances", "Subscribe & Save on Filters");
        List<String> actualMoreToExp = homePage.getMoreToExp();
        Assert.assertEquals(actualMoreToExp, expectedMoreToExp, "Categories in 'Shop Our Categories' section do not match");
    }

////    To verify the second set of promotional banners
////    The shopper should see another set of promotional banners right below the 'More to Explore from Frigidare' section
//    @Test(priority = 7)
//    public void verifySecondPromotionalBanners() {
//        Assert.assertTrue(homePage.isSecondPromotionalBannersDisplayed(), "Second set of promotional banners is not displayed");
//    }
//
////    To verify promotional rating banner
////    The shopper should be able to see a banner which includes a rating and a review
//    @Test(priority = 8)
//    public void verifyPromotionalRatingBanner() {
//        Assert.assertTrue(homePage.isPromotionalRatingBannerDisplayed(), "Promotional rating banner is not displayed");
//    }
//
////    To verify terms of offer section and Recall information
////    The shopper should be able to see all terms of offer as text messages
////    The shopper should be able to see Recall information link, clicking which takes the shopper to the Recall Information page
//    @Test(priority = 9)
//    public void verifyTermsAndRecallSection() {
//        Assert.assertTrue(homePage.isTermsOfOfferDisplayed(), "Terms of offer section is not displayed");
//        Assert.assertTrue(homePage.isRecallInformationLinkDisplayed(), "Recall information link is not displayed");
//        homePage.clickRecallInformationLink();
//        Assert.assertTrue(homePage.isUserOnRecallInformationPage(), "User is not on Recall Information page");
//    }
}
