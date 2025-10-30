package com.automation.frigidaire.tests.EPIC_04_PLP;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions;
import com.automation.frigidaire.pages.PLPProductItemsPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_04_PLP_Filters_AirCare {

    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductCategoryPageActions productCategoryPageActions=new ProductCategoryPageActions();
    PLPProductItemsPageActions PLPProductItemsPageActions =new PLPProductItemsPageActions();
    public void navigateToAirCare(String prodCategory , String subProdCategory ) throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");

        productCategoryPageActions.clickOnProductMenu(prodCategory);
        productCategoryPageActions.clickOnProductMenu(subProdCategory);
        //  productItemsPageActions.closeEmailPopUp();

    }


    @Test(groups = {"smoke", "regression"}, description = "Verify hide/show filters functionality")
    public void testHideShowFilters() throws InterruptedException {
        navigateToAirCare("Air Care","Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners","Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.verifyHideAndShowAllFilters("Hide filters");
        PLPProductItemsPageActions.verifyHideAndShowAllFilters("Show all filters");
        PLPProductItemsPageActions.verifyHideFilters("Hide filters");
    }




    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void testExpandAndCollapseFilter() throws InterruptedException {
        navigateToAirCare("Air Care","Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners","Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter("Features", "ENERGY STAR Certified");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter("BTU", "5,000 BTU");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter("Noise Level on Low", "Quiet (42-47 dBA)");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter("Voltage Rating", "115 V");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter("Min Window Opening Width", "23\"");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter("Max Window Opening Width", "36\"");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter("Min Window Opening Height", "14\"");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter("Price", "$0-$249");

    }


    @Test(groups = {"regression"}, description = "Verify reset all filter")
    public void testResetAll() throws InterruptedException  {
        navigateToAirCare("Air Care","Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners","Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter("BTU ", "5,000 BTU ");
        PLPProductItemsPageActions.verifySelectedFilters("5,000 BTU ");

    }

    @Test(groups = {"regression"}, description = "Verify all product using Features filter")
    public void verifyPLPUpdatesWhenSingleFilterSelected() throws InterruptedException {
        navigateToAirCare("Air Care","Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners","Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter("Features ", " ENERGY STAR Certified ");
        PLPProductItemsPageActions.openAllProductsAndValidate("Certifications and Approvals","ENERGY STAR Certified","Yes");


    }

    @Test(groups = {"regression"}, description = "Verify all product using BTU filter")
    public void verifyPLPUpdatesForBTUFilter() throws InterruptedException {
        navigateToAirCare("Air Care","Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners","Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter("BTU ", " 5,000 BTU ");
        PLPProductItemsPageActions.openAllProductsAndValidate("Performance","BTU (Cool)","5000 BTU");


    }

    @Test(groups = {"regression"}, description = "Verify all product using Voltage Rating filter")
    public void verifyPLPUpdatesForVoltageRatingFilter() throws InterruptedException {
        navigateToAirCare("Air Care","Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners","Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter("Voltage Rating ", " 115 V ");
        PLPProductItemsPageActions.openAllProductsAndValidate("Electrical Specifications","Voltage Rating","115 V");


    }

    @Test(groups = {"regression"}, description = "Verify all product using Min Window Opening Width filter")
    public void verifyPLPUpdatesForMinWindowOpeningWidthFilter() throws InterruptedException {
        navigateToAirCare("Air Care","Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners","Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter("Min Window Opening Width ", " 23\" ");
        PLPProductItemsPageActions.openAllProductsAndValidate("Dimensions and Volume","Window Width Minimum","26 1/2\"");


    }

    @Test(groups = {"regression"}, description = "Verify all product using Max Window Opening Width filter")
    public void verifyPLPUpdatesForMaxWindowOpeningWidthFilter() throws InterruptedException {
        navigateToAirCare("Air Care","Window Mounted AC");
        PLPProductItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners","Window Mounted Air Conditioners");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter("Max Window Opening Width ", " 36\" ");
        PLPProductItemsPageActions.openAllProductsAndValidate("Dimensions and Volume","Window Width Maximum","36\"");


    }






}
