package com.automation.frigidaire.tests.EPIC_04_PLP;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions;
import com.automation.frigidaire.pages.ProductItemsPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_04_PLP_Filters_AirCare {

    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductCategoryPageActions productCategoryPageActions=new ProductCategoryPageActions();
    ProductItemsPageActions productItemsPageActions =new ProductItemsPageActions();
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
        productItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners","Window Mounted Air Conditioners");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.verifyHideAndShowAllFilters("Hide filters");
        productItemsPageActions.verifyHideAndShowAllFilters("Show all filters");
        productItemsPageActions.verifyHideFilters("Hide filters");
    }




    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void testExpandAndCollapseFilter() throws InterruptedException {
        navigateToAirCare("Air Care","Window Mounted AC");
        productItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners","Window Mounted Air Conditioners");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.verifyExpandAndCollapseFilter("Features", "ENERGY STAR Certified");
        productItemsPageActions.verifyExpandAndCollapseFilter("BTU", "5,000 BTU");
        productItemsPageActions.verifyExpandAndCollapseFilter("Noise Level on Low", "Quiet (42-47 dBA)");
        productItemsPageActions.verifyExpandAndCollapseFilter("Voltage Rating", "115 V");
        productItemsPageActions.verifyExpandAndCollapseFilter("Min Window Opening Width", "23\"");
        productItemsPageActions.verifyExpandAndCollapseFilter("Max Window Opening Width", "36\"");
        productItemsPageActions.verifyExpandAndCollapseFilter("Min Window Opening Height", "14\"");
        productItemsPageActions.verifyExpandAndCollapseFilter("Price", "$0-$249");

    }


    @Test(groups = {"regression"}, description = "Verify reset all filter")
    public void testResetAll() throws InterruptedException  {
        navigateToAirCare("Air Care","Window Mounted AC");
        productItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners","Window Mounted Air Conditioners");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.featureFilter("BTU ", "5,000 BTU ");
        productItemsPageActions.verifySelectedFilters("5,000 BTU ");

    }

    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void verifyPLPUpdatesWhenSingleFilterSelected() throws InterruptedException {
        navigateToAirCare("Air Care","Window Mounted AC");
        productItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners","Window Mounted Air Conditioners");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.featureFilter("Features ", " ENERGY STAR Certified ");
        productItemsPageActions.openAllProductsAndValidate("Certifications and Approvals","ENERGY STAR Certified","Yes");


    }

    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void verifyPLPUpdatesForBTUFilter() throws InterruptedException {
        navigateToAirCare("Air Care","Window Mounted AC");
        productItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners","Window Mounted Air Conditioners");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.featureFilter("BTU ", " 5,000 BTU ");
        productItemsPageActions.openAllProductsAndValidate("Performance","BTU (Cool)","5000 BTU");


    }

    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void verifyPLPUpdatesForVoltageRatingFilter() throws InterruptedException {
        navigateToAirCare("Air Care","Window Mounted AC");
        productItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners","Window Mounted Air Conditioners");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.featureFilter("Voltage Rating ", " 115 V ");
        productItemsPageActions.openAllProductsAndValidate("Electrical Specifications","Voltage Rating","115 V");


    }

    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void verifyPLPUpdatesForMinWindowOpeningWidthFilter() throws InterruptedException {
        navigateToAirCare("Air Care","Window Mounted AC");
        productItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners","Window Mounted Air Conditioners");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.featureFilter("Min Window Opening Width ", " 23\" ");
        productItemsPageActions.openAllProductsAndValidate("Dimensions and Volume","Window Width Minimum","26 1/2\"");


    }

    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void verifyPLPUpdatesForMaxWindowOpeningWidthFilter() throws InterruptedException {
        navigateToAirCare("Air Care","Window Mounted AC");
        productItemsPageActions.verifyProductItemPage("Window Mounted Air Conditioners","Window Mounted Air Conditioners");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.featureFilter("Max Window Opening Width ", " 36\" ");
        productItemsPageActions.openAllProductsAndValidate("Dimensions and Volume","Window Width Maximum","36\"");


    }






}
