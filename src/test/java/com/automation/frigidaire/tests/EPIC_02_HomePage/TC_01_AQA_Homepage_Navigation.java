package com.automation.frigidaire.tests.EPIC_02_HomePage;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.tests.BaseTest;
import com.automation.frigidaire.utils.ExtentReportManager;
import com.automation.frigidaire.utils.WebElementUtil;
import com.automation.frigidaire.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TC_01_AQA_Homepage_Navigation extends BaseTest {
    private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();

    @Test(groups = {"regression","TC_01"}, priority = 1)
    public void verifyFrigidaireLogoOnHomepage() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isBrancdLogoLoaded(), "Frigidaire logo is not displayed on homepage");
        ExtentReportManager.getTest().pass("Home page loaded successfully and logo was verified.");
    }

    @Test(groups = {"regression","TC_01"}, priority = 2)
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

    @Test(groups = {"regression", "TC_01"}, priority = 4)
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


    @Test(groups = {"regression", "TC_01"}, priority = 5)
    public void verifyShopOurTopRatedAppliancesSection() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isShopOurTopRatedAppliancesSectionDisplayed(), "'Shop our Top-Rated, Most Feature-Packed Appliances' section is not displayed");
        Assert.assertTrue(homePage.areProductCardsElementsDisplayed(), "Elements on product cards are not displayed correctly");
        homePage.clickFirstProductCard();
        Assert.assertTrue(homePage.isUserOnPDP(), "Clicking on product card does not navigate to PDP");
    }

    @Test(groups = {"regression", "TC_01"}, priority = 6)
    public void verifyMoreToExploreSection() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isMoreToExploreSectionDisplayed(), "'More to Explore from Frigidaire' section is not displayed");
        List<String> expectedMoreToExp = Arrays.asList("NEW! Shop Air Purifiers", "Shop Small Appliances", "Subscribe & Save on Filters");
        List<String> actualMoreToExp = homePage.getMoreToExp();
        Assert.assertEquals(actualMoreToExp, expectedMoreToExp, "Categories in 'Shop Our Categories' section do not match");
    }

@Test(groups = {"regression","TC_01"}, priority = 7)
public void TC_01_verifySecondPromotionalBanners() {
    homePage.navigateToHomePage();
    Assert.assertTrue(homePage.isMoreToExploreSectionDisplayed(), "'More to Explore from Frigidaire' section is not displayed");
    Assert.assertTrue(homePage.isNewsletterRight_SpecialOffersDisplayed(), "Second set of promotional banners is not displayed");
    ExtentReportManager.getTest().pass("Verified second promotional banners below More to Explore.");
}

@Test(groups = {"regression","TC_01"}, priority = 8)
public void TC_01_verifyPromotionalRatingBanner() {
    homePage.navigateToHomePage();
    Assert.assertTrue(homePage.isShopOurTopRatedAppliancesSectionDisplayed(), "Top-rated appliances section is not displayed");
    Assert.assertTrue(homePage.areProductCardsElementsDisplayed(), "Product card elements (including ratings) are not displayed");
    ExtentReportManager.getTest().pass("Verified promotional rating banner shows rating and review elements.");
}

@Test(groups = {"regression","TC_01"}, priority = 9)
public void TC_01_verifyTermsAndRecallSection() {
    homePage.navigateToHomePage();
    homePage.scrollToFooter();
    Assert.assertTrue(homePage.isNewsletterLeft_TermsTextDisplayed(), "Terms of offer section is not displayed");
    Assert.assertTrue(homePage.isFooter_IcemakerRecallDisplayed(), "Recall information link is not displayed");
    homePage.clickFooter_IcemakerRecall();
    WaitUtils.waitForPageLoad();
    Assert.assertTrue(WaitUtils.untilUrlContains("recall"), "User is not on a Recall Information page");
    ExtentReportManager.getTest().pass("Verified terms of offer and Recall Information navigation.");
}

@Test(groups = {"regression","TC_01"}, priority = 10)
public void TC_01_verifyL0CategoriesInHeader() {
    homePage.navigateToHomePage();
    String[] l0Categories = new String[]{
            "Kitchen","Air Conditioners","Air Care","Laundry","Filters",
            "Accessories","Owner Support","Blog","Sale"
    };
    for (String cat : l0Categories) {
        Assert.assertTrue(homePage.isHeaderCategoryDisplayed(cat), "L0 category not visible: " + cat);
    }
    ExtentReportManager.getTest().pass("Verified L0 header categories are visible: " + String.join(", ", l0Categories));
}

@Test(groups = {"regression","TC_01"}, priority = 11)
public void TC_01_verifyKitchenL1SubcategoriesVisible() {
    homePage.navigateToHomePage();
    homePage.openHeaderCategory("Kitchen");
    String[] kitchenSubcats = new String[]{
            "French Door","Side-by-Side","Single Door","Top Freezer","Bottom Freezer",
            "Compact","Wine & Beverage","Built-in-Dishwashers","Induction","Gas","Electric",
            "Dual Fuel","Explore Pizza","Cooktops","Wall Ovens","Microwave Combination",
            "Microwaves","Kitchen Packages","Retro Mini Fridges","Espresso Makers","Air Fryers",
            "Ice Makers","Garbage Disposals"
    };
    for (String sub : kitchenSubcats) {
        Assert.assertTrue(homePage.isHeaderSubcategoryDisplayed(sub), "Kitchen subcategory not visible: " + sub);
    }
    ExtentReportManager.getTest().pass("Verified Kitchen L1 subcategories are visible (sample set).");
}

@Test(groups = {"regression", "TC_01"}, priority = 12)
public void TC_01_verifyAirConditionersL1SubcategoriesVisible() {
    homePage.navigateToHomePage();
    homePage.openHeaderCategory("Air Conditioners");
    String[] acSubcats = new String[]{"Window Mounted","Wall","Portable","Dehumidifiers","HVAC"};
    for (String sub : acSubcats) {
        Assert.assertTrue(homePage.isHeaderSubcategoryDisplayed(sub), "Air Conditioners subcategory not visible: " + sub);
    }
    ExtentReportManager.getTest().pass("Verified Air Conditioners L1 subcategories are visible.");
}

@Test(groups = {"regression", "TC_01"}, priority = 13)
public void TC_01_verifyPromotionalBannersCTAsClickable() {
    homePage.navigateToHomePage();
    Assert.assertTrue(homePage.isMoreToExploreSectionDisplayed(), "'More to Explore from Frigidaire' section is not displayed");
    String[] ctas = new String[]{"NEW! Shop Air Purifiers","Shop Small Appliances","Subscribe & Save on Filters"};
    String startUrl = WebElementUtil.getCurrentUrl();

    for (String text : ctas) {
        homePage.clickMoreToExploreLink(text);
        WaitUtils.waitForPageLoad();
        Assert.assertNotEquals(WebElementUtil.getCurrentUrl(), startUrl, "CTA did not navigate: " + text);
        WebElementUtil.navigateTo("https://www.frigidaire.com/en/");
        homePage.navigateToHomePage();
    }
    ExtentReportManager.getTest().pass("Verified promotional banners have clickable CTAs that navigate correctly.");
}
}
