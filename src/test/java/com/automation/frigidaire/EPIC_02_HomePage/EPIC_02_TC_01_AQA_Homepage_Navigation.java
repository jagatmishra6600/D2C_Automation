package com.automation.frigidaire.EPIC_02_HomePage;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.BaseTest;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WebElementUtil;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class EPIC_02_TC_01_AQA_Homepage_Navigation extends BaseTest {
    private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();

    @Test(groups = {"regression", "TC_01"})
    public void EPIC_02_HomePage_TC_01_verifyFrigidaireLogoOnHomepage() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isBrancdLogoLoaded(), "Frigidaire logo is not displayed on homepage");
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

    @Test(groups = {"regression", "TC_01"})
    public void EPIC_02_HomePage_TC_01_verifyShopOurCategoriesSection() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isShopOurCategoriesSectionDisplayed(), "'Shop Our Categories' section is not displayed");
        List<String> expectedCategories = Arrays.asList("Refrigerators", "Ranges", "Dishwashers", "Wall Ovens","Cooktops",  "Microwaves", "Freezers", "Dehumidifiers", "Air Purifiers", "Air Care", "Small Appliances");
        List<String> actualCategories = homePage.getShopOurCategories();
        Assert.assertEquals(actualCategories, expectedCategories, "Categories in 'Shop Our Categories' section do not match");
    }


    @Test(groups = {"regression", "TC_01"})
    public void EPIC_02_HomePage_TC_01_verifyShopOurTopRatedAppliancesSection() throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isShopOurTopRatedAppliancesSectionDisplayed(), "'Shop our Top-Rated, Most Feature-Packed Appliances' section is not displayed");
        Assert.assertTrue(homePage.areProductCardsElementsDisplayed(), "Elements on product cards are not displayed correctly");
        homePage.clickFirstProductCard();
        Assert.assertTrue(homePage.isUserOnPDP(), "Clicking on product card does not navigate to PDP");
    }

    @Test(groups = {"regression", "TC_01"})
    public void EPIC_02_HomePage_TC_01_verifyTermsAndConditionSection() throws InterruptedException {
        homePage.navigateToHomePage();
        homePage.scrollToFooter();
        Assert.assertTrue(homePage.isNewsletterLeft_TermsTextDisplayed(), "Terms and section is not displayed");
        ExtentReportManager.getTest().pass("Verified terms adn condition Information navigation.");
    }

    @Test(groups = {"regression", "TC_01"})
    public void EPIC_02_HomePage_TC_01_verifyL0CategoriesInHeader() {
        homePage.navigateToHomePage();
        String[] l0Categories = new String[]{"Kitchen", "Air Care","Small Appliances", "Laundry", "Filters", "Accessories", "Owner Support", "Blog", "Sales"};
        for (String cat : l0Categories) {
            Assert.assertTrue(homePage.isHeaderCategoryDisplayed(cat), "L0 category not visible: " + cat);
        }
        ExtentReportManager.getTest().pass("Verified L0 header categories are visible: " + String.join(", ", l0Categories));
    }

    @Test(groups = {"regression", "TC_01"})
    public void EPIC_02_HomePage_TC_01_TCverifyKitchenL1SubcategoriesVisible() {
        homePage.navigateToHomePage();
        homePage.openHeaderCategory("Kitchen");
        String[] kitchenSubcats = new String[]{"French Door", "Side-by-Side", "Single Door", "Top Freezer", "Bottom Freezer", "Compact", "Wine & Beverage", "Built-in-Dishwashers", "Induction", "Gas", "Electric", "Dual Fuel", "Pizza-Mode Ranges", "Cooktops", "Wall Ovens", "Microwave Combination", "Microwaves", "Kitchen Packages"};
        for (String sub : kitchenSubcats) {
            Assert.assertTrue(homePage.isHeaderSubcategoryDisplayed(sub), "Kitchen subcategory not visible: " + sub);
        }
        ExtentReportManager.getTest().pass("Verified Kitchen L1 subcategories are visible (sample set).");
    }

    @Test(groups = {"regression", "TC_01"})
    public void EPIC_02_HomePage_TC_01_verifyAirConditionersL1SubcategoriesVisible() {
        homePage.navigateToHomePage();
        homePage.openHeaderCategory("Air Care");
        String[] acSubcats = new String[]{"Window Mounted AC", "Wall AC", "Portable AC", "Dehumidifiers", "HVAC"};
        for (String sub : acSubcats) {
            Assert.assertTrue(homePage.isHeaderSubcategoryDisplayed(sub), "Air Conditioners subcategory not visible: " + sub);
        }
        ExtentReportManager.getTest().pass("Verified Air Conditioners L1 subcategories are visible.");
    }

    @Test(groups = {"TC_01"})
    public void EPIC_02_HomePage_TC_01_verifyPromotionalBannersCTAsClickable() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isMoreToExploreSectionDisplayed(), "'More to Explore from Frigidaire' section is not displayed");
        String[] ctas = new String[]{"NEW! Shop Air Purifiers", "Shop Small Appliances", "Subscribe & Save on Filters"};
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
