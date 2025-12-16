package com.automation.frigidaire.EPIC_04_PLP;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.ProductCategoryPageActionsFrig;
import com.automation.frigidaire.pages.PLPProductItemsPageActionsFrig;
import com.automation.utils.ExtentReportManager;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_04_TC_01_PLP_Filters_AirCare_Frig extends BaseTest {

    HomePageActionsFrig homePage = new HomePageActionsFrig();
    ProductCategoryPageActionsFrig productCategoryPageActionsFrig = new ProductCategoryPageActionsFrig();
    PLPProductItemsPageActionsFrig PLPProductItemsPageActionsFrig = new PLPProductItemsPageActionsFrig();

    public void navigateToAirCare( String webSite,String prodCategory, String subProdCategory) throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActionsFrig.clickOnProductMenu(webSite, prodCategory);
        productCategoryPageActionsFrig.clickOnProductMenu(webSite, subProdCategory);
        PLPProductItemsPageActionsFrig.closeEmailPopUp();

    }


    @Test(groups = {"smoke", "regression"}, description = "Verify hide/show filters functionality")
    public void  EPIC_04_PLP_TC_01_testHideShowFilters() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActionsFrig.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActionsFrig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActionsFrig.verifyHideAndShowAllFilters("Hide filters");
        PLPProductItemsPageActionsFrig.verifyHideAndShowAllFilters("Show all filters");
        PLPProductItemsPageActionsFrig.verifyHideFilters("Hide filters");
        ExtentReportManager.getTest().pass("Successfully verify hide/show filters functionality");

    }


    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void  EPIC_04_PLP_TC_01_testExpandAndCollapseFilter() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActionsFrig.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActionsFrig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActionsFrig.verifyExpandAndCollapseFilter("frigidaire", "Features", "ENERGY STAR Certified");
        PLPProductItemsPageActionsFrig.verifyExpandAndCollapseFilter("frigidaire", "BTU", "5,000 BTU");
        PLPProductItemsPageActionsFrig.verifyExpandAndCollapseFilter("frigidaire", "Noise Level on Low", "Quiet (42-47 dBA)");
        PLPProductItemsPageActionsFrig.verifyExpandAndCollapseFilter("frigidaire", "Voltage Rating", "115 V");
        PLPProductItemsPageActionsFrig.verifyExpandAndCollapseFilter("frigidaire", "Min Window Opening Width", "23\"");
        PLPProductItemsPageActionsFrig.verifyExpandAndCollapseFilter("frigidaire", "Max Window Opening Width", "36\"");
        PLPProductItemsPageActionsFrig.verifyExpandAndCollapseFilter("frigidaire", "Min Window Opening Height", "14\"");
        PLPProductItemsPageActionsFrig.verifyExpandAndCollapseFilter("frigidaire", "Price", "$0-$249");
        ExtentReportManager.getTest().pass("Successfully Verify expand and collapse of filter sections");

    }

    @Test(groups = {"regression"}, description = "Verify reset all filter")
    public void  EPIC_04_PLP_TC_01_testResetAll() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActionsFrig.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActionsFrig.featureFilter("frigidaire", "BTU ", "5,000 BTU ");
        PLPProductItemsPageActionsFrig.verifySelectedFilters("5,000 BTU ");
        ExtentReportManager.getTest().pass("Successfully Verify reset all filter");

    }

    @Test(groups = {"regression"}, description = "Verify all product using Features filter")
    public void  EPIC_04_PLP_TC_01_verifyPLPUpdatesWhenSingleFilterSelected() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActionsFrig.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActionsFrig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActionsFrig.featureFilter("frigidaire", "Features ", " ENERGY STAR Certified ");
        PLPProductItemsPageActionsFrig.openAllProductsAndValidate("Certifications and Approvals", "ENERGY STAR Certified", "Yes");
        ExtentReportManager.getTest().pass("Successfully Verify all product using Features filter");

    }

    @Test(groups = {"regression"}, description = "Verify all product using BTU filter")
    public void EPIC_04_PLP_TC_01_verifyPLPUpdatesForBTUFilter() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActionsFrig.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActionsFrig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActionsFrig.featureFilter("frigidaire", "BTU ", " 5,000 BTU ");
        PLPProductItemsPageActionsFrig.openAllProductsAndValidate("Performance", "BTU (Cool)", "5000 BTU");
        ExtentReportManager.getTest().pass("Successfully Verify all product using BTU filter");

    }

    @Test(groups = {"regression"}, description = "Verify all product using Voltage Rating filter")
    public void EPIC_04_PLP_TC_01_verifyPLPUpdatesForVoltageRatingFilter() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActionsFrig.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActionsFrig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActionsFrig.featureFilter("frigidaire", "Voltage Rating ", " 115 V ");
        PLPProductItemsPageActionsFrig.openAllProductsAndValidate("Electrical Specifications", "Voltage Rating", "115 V");
        ExtentReportManager.getTest().pass("Successfully Verify all product using Voltage Rating filter");

    }

    @Test(groups = {"regression"}, description = "Verify all product using Min Window Opening Width filter")
    public void EPIC_04_PLP_TC_01_verifyPLPUpdatesForMinWindowOpeningWidthFilter() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActionsFrig.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActionsFrig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActionsFrig.featureFilter("frigidaire", "Min Window Opening Width ", " 23\" ");
        PLPProductItemsPageActionsFrig.openAllProductsAndValidate("Dimensions and Volume", "Window Width Minimum", "26 1/2\"");
        ExtentReportManager.getTest().pass("Successfully Verify all product using Min Window Opening Width filter");

    }

    @Test(groups = {"regression"}, description = "Verify all product using Max Window Opening Width filter")
    public void EPIC_04_PLP_TC_01_verifyPLPUpdatesForMaxWindowOpeningWidthFilter() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActionsFrig.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActionsFrig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActionsFrig.featureFilter("frigidaire", "Max Window Opening Width ", " 36\" ");
        PLPProductItemsPageActionsFrig.openAllProductsAndValidate("Dimensions and Volume", "Window Width Maximum", "36\"");
        ExtentReportManager.getTest().pass("Successfully Verify all product using Max Window Opening Width filter");

    }

   // @Test(groups = {"regression"}, description = "Verify Select yoour room size")
    public void EPIC_04_PLP_TC_01_verify_Select_Your_Room_Size_Filter() throws InterruptedException {
        navigateToAirCare("frigidaire", "Air Care", "Window Mounted AC");
        PLPProductItemsPageActionsFrig.verifyProductItemPage("Window Mounted Air Conditioners", "Window Mounted Air Conditioners");
        PLPProductItemsPageActionsFrig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActionsFrig.verifyAcRoomSize(" Small Room", "Performance", "Cool Area", "250", 100, 350);
//         loadMoreProducts(driver);
//         validateAirCareProductsForRoomSize( SpecsName ,  SpecsKey ,  SpecValue ,  lowerBound, upperBound);
        PLPProductItemsPageActionsFrig.validateAirCareProductsForRoomSize("Performance", "Cool Area", "250", 100,350);
        ExtentReportManager.getTest().pass("Successfully Verify Select your room size");

    }

}
