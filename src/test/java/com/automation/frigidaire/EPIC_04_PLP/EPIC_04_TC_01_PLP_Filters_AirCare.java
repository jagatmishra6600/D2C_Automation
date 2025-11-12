package com.automation.frigidaire.EPIC_04_PLP;

import com.automation.BaseTest;
<<<<<<< HEAD
import com.automation.frigidaire.locators.FrigidaireConstants;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions;
import com.automation.frigidaire.pages.PLPProductItemsPageActions;
import com.automation.utils.ExtentReportManager;
=======
import com.automation.frigidaire.enums.FrigidaireConstants;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions;
import com.automation.frigidaire.pages.PLPProductItemsPageActions;
import com.automation.frigidaire.utils.ExtentReportManager;
>>>>>>> c6eb8d75fde6b68139cd97bec28b88f0b427ba85

import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_04_TC_01_PLP_Filters_AirCare extends BaseTest {

    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductCategoryPageActions productCategoryPageActions = new ProductCategoryPageActions();
    PLPProductItemsPageActions PLPProductItemsPageActions = new PLPProductItemsPageActions();

    public void navigateToAirCare(String webSite, String prodCategory, String subProdCategory) throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu(webSite, prodCategory);
        productCategoryPageActions.clickOnProductMenu(webSite, subProdCategory);
        PLPProductItemsPageActions.closeEmailPopUp();

    }


    @Test(groups = {"smoke", "regression"}, description = "Verify hide/show filters functionality")
    public void  EPIC_04_PLP_TC_01_testHideShowFilters() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.verifyHideAndShowAllFilters("Hide filters");
        PLPProductItemsPageActions.verifyHideAndShowAllFilters("Show all filters");
        PLPProductItemsPageActions.verifyHideFilters("Hide filters");
        ExtentReportManager.getTest().pass("Successfully verify hide/show filters functionality");

    }


    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void  EPIC_04_PLP_TC_01_testExpandAndCollapseFilter() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "Features", "ENERGY STAR Certified");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "BTU", "5,000 BTU");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "Noise Level on Low", "Quiet (42-47 dBA)");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "Voltage Rating", "115 V");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "Min Window Opening Width", "23\"");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "Max Window Opening Width", "36\"");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "Min Window Opening Height", "14\"");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "Price", "$0-$249");
        ExtentReportManager.getTest().pass("Successfully Verify expand and collapse of filter sections");

    }

    @Test(groups = {"regression"}, description = "Verify reset all filter")
    public void  EPIC_04_PLP_TC_01_testResetAll() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "BTU ", "5,000 BTU ");
        PLPProductItemsPageActions.verifySelectedFilters("5,000 BTU ");
        ExtentReportManager.getTest().pass("Successfully Verify reset all filter");

    }

    @Test(groups = {"regression"}, description = "Verify all product using Features filter")
    public void  EPIC_04_PLP_TC_01_verifyPLPUpdatesWhenSingleFilterSelected() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Features ", " ENERGY STAR Certified ");
        PLPProductItemsPageActions.openAllProductsAndValidate("Certifications and Approvals", "ENERGY STAR Certified", "Yes");
        ExtentReportManager.getTest().pass("Successfully Verify all product using Features filter");

    }

    @Test(groups = {"regression"}, description = "Verify all product using BTU filter")
    public void EPIC_04_PLP_TC_01_verifyPLPUpdatesForBTUFilter() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "BTU ", " 5,000 BTU ");
        PLPProductItemsPageActions.openAllProductsAndValidate("Performance", "BTU (Cool)", "5000 BTU");
        ExtentReportManager.getTest().pass("Successfully Verify all product using BTU filter");

    }

    @Test(groups = {"regression"}, description = "Verify all product using Voltage Rating filter")
    public void EPIC_04_PLP_TC_01_verifyPLPUpdatesForVoltageRatingFilter() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Voltage Rating ", " 115 V ");
        PLPProductItemsPageActions.openAllProductsAndValidate("Electrical Specifications", "Voltage Rating", "115 V");
        ExtentReportManager.getTest().pass("Successfully Verify all product using Voltage Rating filter");

    }

    @Test(groups = {"regression"}, description = "Verify all product using Min Window Opening Width filter")
    public void EPIC_04_PLP_TC_01_verifyPLPUpdatesForMinWindowOpeningWidthFilter() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Min Window Opening Width ", " 23\" ");
        PLPProductItemsPageActions.openAllProductsAndValidate("Dimensions and Volume", "Window Width Minimum", "26 1/2\"");
        ExtentReportManager.getTest().pass("Successfully Verify all product using Min Window Opening Width filter");

    }

    @Test(groups = {"regression"}, description = "Verify all product using Max Window Opening Width filter")
    public void EPIC_04_PLP_TC_01_verifyPLPUpdatesForMaxWindowOpeningWidthFilter() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Max Window Opening Width ", " 36\" ");
        PLPProductItemsPageActions.openAllProductsAndValidate("Dimensions and Volume", "Window Width Maximum", "36\"");
        ExtentReportManager.getTest().pass("Successfully Verify all product using Max Window Opening Width filter");

    }

    @Test(groups = {"regression"}, description = "Verify Select yoour room size")
    public void EPIC_04_PLP_TC_01_verify_Select_Your_Room_Size_Filter() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.verifyAcRoomSize(" Small Room", "Performance", "Cool Area", "250", 100, 350);
        // loadMoreProducts(driver);
        // validateAirCareProductsForRoomSize( SpecsName ,  SpecsKey ,  SpecValue ,  lowerBound, upperBound);
        ExtentReportManager.getTest().pass("Successfully Verify Select your room size");

    }


}
