package com.automation.frigidaire.EPIC_04_PLP;

import com.automation.BaseTest;
import com.automation.frigidaire.enums.FrigidaireConstants;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions;
import com.automation.frigidaire.pages.PLPProductItemsPageActions;
import com.automation.frigidaire.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_04_PLP_Filters extends BaseTest {
    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductCategoryPageActions productCategoryPageActions = new ProductCategoryPageActions();
    PLPProductItemsPageActions PLPProductItemsPageActions = new PLPProductItemsPageActions();

    public void navigateToFrenchDoorRefrigerators(String webSite, String prodCategory, String subProdCategory) throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu(webSite, prodCategory);
        productCategoryPageActions.clickOnProductMenu(webSite, subProdCategory);
        PLPProductItemsPageActions.closeEmailPopUp();

    }


    @Test(groups = {"smoke", "regression"}, description = "Verify hide/show filters functionality")
    public void EPIC_04_PLP_TC_04_testHideShowFilters() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.verifyHideAndShowAllFilters("Hide filters");
        PLPProductItemsPageActions.verifyHideAndShowAllFilters("Show all filters");
        PLPProductItemsPageActions.verifyHideFilters("Hide filters");
        ExtentReportManager.getTest().pass("Successfully hide/show filters functionality for FrenchDoor");
    }


    @Test(groups = {"smoke", "regression"}, description = "Verify product dimensions for height")
    public void EPIC_04_PLP_TC_04_testForHeightDimensions() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        //PLPProductItemsPageActions.standardWidthClick();
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Height", "70");
        PLPProductItemsPageActions.verifyProductWidthHeightAndDepth("H", "70\"");
        ExtentReportManager.getTest().pass("SuccessfullyVerify product dimensions for height");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify product dimensions for height")
    public void EPIC_04_PLP_TC_04_testForHeightWithRatioDimensions() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        //PLPProductItemsPageActions.standardWidthClick();
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Height", "67 9/10\"");
        PLPProductItemsPageActions.verifyProductWidthHeightAndDepth("H", "67 9/10\"");
        ExtentReportManager.getTest().pass("Successfully Verify product dimensions for height");
    }


    @Test(groups = {"regression"}, description = "Verify every filter is with its sub-filter")
    public void EPIC_04_PLP_TC_04_testExpandAndCollapseFilter() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "Series", "Frigidaire");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "color", "Stainless Steel");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "Depth Type", "Counter-Depth");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "Features", "Ice Maker");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "Standard Width", "30\"");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "Height", "70\"");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "Price", "$1,000-$1,499");
        ExtentReportManager.getTest().pass("Successfully Verify every filter is with its sub-filter");

    }


    @Test(groups = {"regression"}, description = "Verify reset all filter")
    public void EPIC_04_PLP_TC_04_testResetAll() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Series ", " Frigidaire Gallery ");
        PLPProductItemsPageActions.verifySelectedFilters("Frigidaire Gallery ");
        ExtentReportManager.getTest().pass("Successfully Verify reset all filter");

    }

    @Test(groups = {"regression"}, description = "Verify Ice maker filter with its functionality")
    public void EPIC_04_PLP_TC_04_verifyPLPUpdatesWhenSingleFilterSelected() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Features ", " Ice Maker ");
        PLPProductItemsPageActions.openAllProductsAndValidate("Ice Maker", "Ice Maker", "Yes");
        ExtentReportManager.getTest().pass("Verify Ice maker filter with its functionality");


    }

    @Test(groups = {"regression"}, description = "Verify water dispenser filter with its functionality")
    public void EPIC_04_PLP_TC_04_verifyPLPUpdatesForWaterDispenserFeature() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Features ", " Water Dispenser ");
        PLPProductItemsPageActions.openAllProductsAndValidate("Dispenser", "Water Dispenser", "Yes");
        ExtentReportManager.getTest().pass("Verify water dispenser filter with its functionality");


    }

    @Test(groups = {"regression"}, description = "Verify ADA Complaint filter with its functionality")
    public void EPIC_04_PLP_TC_04_verifyPLPUpdatesForADAComplaintFeature() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Features ", " ADA Compliant ");
        PLPProductItemsPageActions.openAllProductsAndValidate("Certifications and Approvals", "ADA Compliant", "Yes");
        ExtentReportManager.getTest().pass("Verify ADA Complaint filter with its functionality");


    }


    @Test(groups = {"regression"}, description = "Verify ENERGY STAR Certified filter with its functionality")
    public void EPIC_04_PLP_TC_04_verifyPLPUpdatesForEnergyStarCertifiedFeature() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Features ", " ENERGY STAR Certified ");
        PLPProductItemsPageActions.openAllProductsAndValidate("Certifications and Approvals", "ENERGY STAR Certified", "Yes");
        ExtentReportManager.getTest().pass("Verify ENERGY STAR Certified filter with its functionality");


    }

    @Test(groups = {"regression"}, description = "Verify filter with its functionality")
    public void EPIC_04_PLP_TC_04_verifyVisibilityOfFiltersInPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.verifyFiltersInPLP("Availability");
        PLPProductItemsPageActions.verifyFiltersInPLP("Series");
        PLPProductItemsPageActions.verifyFiltersInPLP("color");
        PLPProductItemsPageActions.verifyFiltersInPLP("Depth Type");
        PLPProductItemsPageActions.verifyFiltersInPLP("Features");
        PLPProductItemsPageActions.verifyFiltersInPLP("Standard Width");
        PLPProductItemsPageActions.verifyFiltersInPLP("Height");
        PLPProductItemsPageActions.verifyFiltersInPLP("Price");
        ExtentReportManager.getTest().pass("Successfully Verify filter with its functionality");


    }

    @Test(groups = {"regression"}, description = "Verify Visibility of frigidaire gallery filters in PLP")
    public void EPIC_04_PLP_TC_04_verifyFrigidaireGalleryProductInPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.verifyFiltersInPLP("Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Series ", " Frigidaire Gallery ");
        PLPProductItemsPageActions.validateFrigidaireGalleryAndProfessionalProducts("Frigidaire Gallery", "Frigidaire Gallery");
        ExtentReportManager.getTest().pass("Verify Visibility of frigidaire gallery filters in PLP");

    }

    @Test(groups = {"regression"}, description = "Verify Visibility of frigidaire professional filters in PLP")
    public void EPIC_04_PLP_TC_04_verifyFrigidaireProfessionalProductInPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.verifyFiltersInPLP("Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Series ", " Frigidaire Professional ");
        PLPProductItemsPageActions.validateFrigidaireGalleryAndProfessionalProducts("Frigidaire Professional", "Frigidaire Professional");
        ExtentReportManager.getTest().pass("Verify Visibility of frigidaire professional filters in PLP");

    }


    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void EPIC_04_PLP_TC_04_verifyPopularFiltersInPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");

        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.validatePopularFiltersInPLP("Water Disp.", "Water Disp.");
        PLPProductItemsPageActions.validatePopularFiltersInPLP("Counter Depth", "Counter Depth");
        PLPProductItemsPageActions.validatePopularFiltersInPLP("Std. Depth", "Std. Depth");
        PLPProductItemsPageActions.validatePopularFiltersInPLP("Ice Maker", "Ice Maker");
        ExtentReportManager.getTest().pass("Successfully verify Popular filters in PLP");

    }

    @Test(groups = {"smoke", "regression"}, description = "verify Popular Filters Is Checked On Clicking the Related Filter In PLP")
    public void EPIC_04_PLP_TC_04_verify_Popular_Filters_Is_Checked_On_Clicling_the_RelatedFilterInPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Depth Type", "Counter-Depth");
        PLPProductItemsPageActions.validatePopularFilterTurnsRed("Counter Depth");
        ExtentReportManager.getTest().pass("verify Popular Filters Is Checked On Clicking the Related Filter In PLP");


    }


    @Test(groups = {"smoke", "regression"}, description = "verify counter depth filter is checked when counter depth in popular filter is selected")
    public void EPIC_04_PLP_TC_04_verify_Related_Filter_Is_Checked_On_Clicling_Popular_filter_In_PLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Depth Type ", " Counter-Depth ");
        PLPProductItemsPageActions.validateCheckboxCheckedWhenPopularFilterClicked("Counter Depth", "Depth Type", "Counter-Depth");
        ExtentReportManager.getTest().pass("verify counter depth filter is checked when counter depth in popular filter is selected");

    }

    @Test(groups = {"smoke", "regression"}, description = "verify popular filter turrns red in PLP")
    public void EPIC_04_PLP_TC_04_verify_Popular_Filters_Is_Checked_On_Clicling_the_RelatedFilter1InPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Features", "Standard-Depth");
        // PLPProductItemsPageActions.getFeatureSpecsLocator()
        PLPProductItemsPageActions.validatePopularFilterTurnsRed(" Std. Depth ");
        ExtentReportManager.getTest().pass("Successfully verify popular filter turrns red in PLP");


    }


    @Test(groups = {"smoke", "regression"}, description = "verify cross button (Below Hide Filters) when User clicks on particular filters in PLP")
    public void EPIC_04_PLP_TC_04_verify_Related_Filter_Is_Checked_On_Clicling_Popular_filter1_In_PLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Depth Type", "Standard-Depth");
        PLPProductItemsPageActions.validateCheckboxCheckedWhenPopularFilterClicked("Std. Depth", "Depth Type", "Standard-Depth");
        ExtentReportManager.getTest().pass("Successfully Verify product dimensions for standard width");

    }


    @Test(groups = {"smoke", "regression"}, description = "verify Popular filter 'Ice Maker' successfully turned red in PLP")
    public void EPIC_04_PLP_TC_04_verify_Popular_Filters_Is_Checked_On_Clicling_the_RelatedFilter2InPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Features ", " Ice Maker ");
        PLPProductItemsPageActions.validatePopularFilterTurnsRed("Ice Maker");
        ExtentReportManager.getTest().pass("Successfully Popular filter 'Ice Maker' successfully turned red");


    }


    @Test(groups = {"smoke", "regression"}, description = "verify Checkbox for 'Ice Maker' is now checked after Popular Filter click")
    public void EPIC_04_PLP_TC_04_verify_Related_Filter_Is_Checked_On_Clicling_Popular_filter2_In_PLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Depth Type ", " Ice Maker ");
        PLPProductItemsPageActions.validateCheckboxCheckedWhenPopularFilterClicked("Ice Maker", "Features", "Ice Maker");
        ExtentReportManager.getTest().pass("Successfully Checkbox for 'Ice Maker' is now checked after Popular Filter click");

    }


    @Test(groups = {"smoke", "regression"}, description = "verify Popular filter 'Water Disp.' successfully turned red")
    public void EPIC_04_PLP_TC_04_verify_Popular_Filters_Is_Checked_On_Clicling_the_RelatedFilter3InPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Features", "Water Dispenser");
        PLPProductItemsPageActions.validatePopularFilterTurnsRed("Water Disp.");
        ExtentReportManager.getTest().pass("Successfully verify Popular filter 'Water Disp.' successfully turned red");


    }


    @Test(groups = {"smoke", "regression"}, description = "Checkbox for 'Water Dispenser' is now checked after Popular Filter click")
    public void EPIC_04_PLP_TC_04_verify_Related_Filter_Is_Checked_On_Clicling_Popular_filter3_In_PLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter(FrigidaireConstants.frigidaireWeb, "Depth Type", "Water Dispenser");
        PLPProductItemsPageActions.validateCheckboxCheckedWhenPopularFilterClicked("Water Disp.", "Features", "Water Dispenser");
        ExtentReportManager.getTest().pass("Successfully verify Checkbox for 'Water Dispenser' is now checked after Popular Filter click");

    }


    @Test(groups = {"smoke", "regression"}, description = "verify Availability of products in PLP")
    public void EPIC_04_PLP_TC_04_verify_Availaibility_In_PLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.validateAvailabilityOfProductsInPLP();
        ExtentReportManager.getTest().pass("Successfully verify Availability of products in PLP");

    }

    @Test(groups = {"smoke", "regression"}, description = "verify Checkbox Unchecked After Cross Click")
    public void EPIC_04_PLP_TC_04_verify_CrossBtn_In_PLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.validateCheckboxUncheckedAfterCrossClick("Series", "Frigidaire Gallery", "Frigidaire Gallery");
        PLPProductItemsPageActions.validateCheckboxUncheckedAfterCrossClick("Series", "Frigidaire Professional", "Frigidaire Professional");
        PLPProductItemsPageActions.validateCheckboxUncheckedAfterCrossClick("Series", "Frigidaire", "Frigidaire");
        ExtentReportManager.getTest().pass("Successfully verify Checkbox Unchecked After Cross Click");

    }


}
