package com.automation.electrolux.tests.EPIC_04_PLP;

import com.automation.frigidaire.enums.FrigidaireConstants;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.PLPProductItemsPageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions;
import com.automation.frigidaire.tests.BaseTest;
import com.automation.frigidaire.utils.ExtentReportManager;
import com.automation.frigidaire.utils.WebElementUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.automation.frigidaire.enums.FrigidaireConstants.electroxWeb;

public class TC_05_PLP_Electrolux_Filter extends BaseTest{


        FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
        ProductCategoryPageActions productCategoryPageActions=new ProductCategoryPageActions();
        PLPProductItemsPageActions PLPProductItemsPageActions =new PLPProductItemsPageActions();

    public void navigateToVacuumsProducts(String webSite, String prodCategory , String subProdCategory ) throws InterruptedException {
        homePage.navigateToHomePage();
        //  Assert.assertTrue(homePage.isHomePageLoaded(), "The electrolux home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu(webSite,prodCategory);
        productCategoryPageActions.clickOnProductMenu(webSite,subProdCategory);
        //productCategoryPageActions.closeEmailPopUp();
        PLPProductItemsPageActions.closeEmailPopUp();
        WebElementUtil.zoomInOrOut(25);
        PLPProductItemsPageActions.verifyProductItemPage("Vacuums","Vacuums");


    }


        @Test(groups = {"smoke", "regression"}, description = "Product menu Shop All Vacuums displayed before clicking.")
        public void testHideShowFilters() throws InterruptedException {
            navigateToVacuumsProducts("electrolux","Vacuums","Shop All Vacuums");

           // PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
            PLPProductItemsPageActions.verifyHideAndShowAllFilters("Hide filters");
            PLPProductItemsPageActions.verifyHideAndShowAllFilters("Show filters");
            PLPProductItemsPageActions.verifyHideFilters("Hide filters");
            ExtentReportManager.getTest().pass("Successfully verify Product menu Shop All Vacuums displayed before clicking.");
        }






        @Test(groups = {"regression"}, description = "Verify every filter expand and collapse")
        public void testExpandAndCollapseFilter() throws InterruptedException {
            navigateToVacuumsProducts("electrolux","Vacuums","Shop All Vacuums");
           // PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
            PLPProductItemsPageActions.verifyExpandAndCollapseFilter("electrolux","Category", "Cordless Stick");
            PLPProductItemsPageActions.verifyExpandAndCollapseFilter("electrolux","Best For", "Multi-Surface Cleaning");
            PLPProductItemsPageActions.verifyExpandAndCollapseFilter("electrolux","Technology", "Auto Power Level");
            PLPProductItemsPageActions.verifyExpandAndCollapseFilter("electrolux","Bin Size", "Less than 0.4 L");
            PLPProductItemsPageActions.verifyExpandAndCollapseFilter("electrolux","Weight", "Less than 6 lbs");
            PLPProductItemsPageActions.verifyExpandAndCollapseFilter("electrolux","In stock", "Yes");
            ExtentReportManager.getTest().pass("Successfully Verify every filter expand and collapse");

        }


        @Test(groups = {"regression"}, description = "Verify reset all filter")
        public void testResetAll() throws InterruptedException  {
            navigateToVacuumsProducts("electrolux","Vacuums","Shop All Vacuums");
            PLPProductItemsPageActions.featureFilter(electroxWeb,"Category", "Cordless Stick");
            PLPProductItemsPageActions.verifySelectedFilters("Cordless Stick");
            ExtentReportManager.getTest().pass("Successfully Verify reset all filter");

        }

        @Test(groups = {"regression"}, description = "Verify Ice maker filter with its functionality")
        public void verifyPLPUpdatesWhenSingleFilterSelected() throws InterruptedException {
            navigateToVacuumsProducts("electrolux","Vacuums","Shop All Vacuums");
            PLPProductItemsPageActions.featureFilter(electroxWeb,"Technology", "Auto Power Level");
            PLPProductItemsPageActions.openAllProductsAndValidate("Vacuum Performance","Auto Power Level","Yes");
            ExtentReportManager.getTest().pass("Verify Ice maker filter with its functionality");


        }


    @Test(groups = {"regression"}, description = "Verify Ice maker filter with its functionality")
    public void verifyPLPUpdatesWhenSingleFilterSelectedd() throws InterruptedException {
        navigateToVacuumsProducts("electrolux","Vacuums","Shop All Vacuums");
        PLPProductItemsPageActions.featureFilter(electroxWeb,"Bin Size", "Less than 0.4 L");
        PLPProductItemsPageActions.openAllProductsAndValidate("General Specifications","Dust Bin Capacity","0.3 L");
        ExtentReportManager.getTest().pass("Verify Ice maker filter with its functionality");


    }

    @Test(groups = {"regression"}, description = "Verify Ice maker filter with its functionality")
    public void verifyPLPUpdatesWhenWeightFilterSelectedd() throws InterruptedException {
        navigateToVacuumsProducts("electrolux","Vacuums","Shop All Vacuums");
        PLPProductItemsPageActions.featureFilter(electroxWeb,"Weight", "Less than 6 lbs");
        PLPProductItemsPageActions.openAllProductsAndValidate("General Specifications","Dust Bin Capacity","0.3 L");
        ExtentReportManager.getTest().pass("Verify Ice maker filter with its functionality");


    }






        @Test(groups = {"regression"}, description = "Verify ENERGY STAR Certified filter with its functionality")
        public void verifyPLPUpdatesForEnergyStarCertifiedFeature() throws InterruptedException {
            navigateToVacuumsProducts("electrolux","Vacuums","Shop All Vacuums");
           // PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
            PLPProductItemsPageActions.featureFilter(electroxWeb,"Features ", " ENERGY STAR Certified ");
            PLPProductItemsPageActions.openAllProductsAndValidate("Certifications and Approvals","ENERGY STAR Certified","Yes");
            ExtentReportManager.getTest().pass("Verify ENERGY STAR Certified filter with its functionality");


        }



        //remained
//        @Test(groups = {"regression"}, description = "Verify filter with its functionality")
//        public void verifyVisibilityOfFiltersInPLP() throws InterruptedException {
//            navigateToVacuumsProducts("electrolux","Vacuums","Shop All Vacuums");
//            PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
//            PLPProductItemsPageActions.verifyFiltersInPLP("Availability");
//            PLPProductItemsPageActions.verifyFiltersInPLP("Series");
//            PLPProductItemsPageActions.verifyFiltersInPLP("color");
//            PLPProductItemsPageActions.verifyFiltersInPLP("Depth Type");
//            PLPProductItemsPageActions.verifyFiltersInPLP("Features");
//            PLPProductItemsPageActions.verifyFiltersInPLP("Standard Width");
//            PLPProductItemsPageActions.verifyFiltersInPLP("Height");
//            PLPProductItemsPageActions.verifyFiltersInPLP("Price");
//            ExtentReportManager.getTest().pass("Successfully Verify filter with its functionality");
//
//
//
//
//        }










    }


