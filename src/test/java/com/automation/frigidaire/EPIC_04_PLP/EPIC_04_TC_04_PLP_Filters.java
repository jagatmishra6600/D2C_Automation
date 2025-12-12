package com.automation.frigidaire.EPIC_04_PLP;

import com.automation.BaseTest;

import com.automation.frigidaire.locators.FrigidaireConstants;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions_Frig;
import com.automation.frigidaire.pages.PLPProductItemsPageActions_Frig;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_04_TC_04_PLP_Filters extends BaseTest {
    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductCategoryPageActions_Frig productCategoryPageActionsFrig = new ProductCategoryPageActions_Frig();
    PLPProductItemsPageActions_Frig PLPProductItemsPageActions_Frig = new PLPProductItemsPageActions_Frig();

    public void navigateToFrenchDoorRefrigerators(String webSite, String prodCategory, String subProdCategory) throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActionsFrig.clickOnProductMenu(webSite, prodCategory);
        productCategoryPageActionsFrig.clickOnProductMenu(webSite, subProdCategory);
        PLPProductItemsPageActions_Frig.closeEmailPopUp();

    }


    @Test(groups = {"smoke", "regression"}, description = "Verify hide/show filters functionality")
    public void EPIC_04_PLP_TC_04_testHideShowFilters() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.verifyHideAndShowAllFilters("Hide filters");
        PLPProductItemsPageActions_Frig.verifyHideAndShowAllFilters("Show all filters");
        PLPProductItemsPageActions_Frig.verifyHideFilters("Hide filters");
        ExtentReportManager.getTest().pass("Successfully hide/show filters functionality for FrenchDoor");
    }


    @Test(groups = {"smoke", "regression"}, description = "Verify product dimensions for height")
    public void EPIC_04_PLP_TC_04_testForHeightDimensions() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        //PLPProductItemsPageActions.standardWidthClick();
        PLPProductItemsPageActions_Frig.featureFilter(FrigidaireConstants.frigidaireWeb, "Height", "70");
        PLPProductItemsPageActions_Frig.verifyProductWidthHeightAndDepth("H", "70\"");
        ExtentReportManager.getTest().pass("SuccessfullyVerify product dimensions for height");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify product dimensions for height")
    public void EPIC_04_PLP_TC_04_testForHeightWithRatioDimensions() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        //PLPProductItemsPageActions.standardWidthClick();
        PLPProductItemsPageActions_Frig.featureFilter(FrigidaireConstants.frigidaireWeb, "Height", "67 9/10\"");
        PLPProductItemsPageActions_Frig.verifyProductWidthHeightAndDepth("H", "67 9/10\"");
        ExtentReportManager.getTest().pass("Successfully Verify product dimensions for height");
    }


    @Test(groups = {"regression"}, description = "Verify every filter is with its sub-filter")
    public void EPIC_04_PLP_TC_04_testExpandAndCollapseFilter() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "Series", "Frigidaire");
        PLPProductItemsPageActions_Frig.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "color", "Stainless Steel");
        PLPProductItemsPageActions_Frig.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "Depth Type", "Counter-Depth");
        PLPProductItemsPageActions_Frig.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "Features", "Ice Maker");
        PLPProductItemsPageActions_Frig.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "Standard Width", "30\"");
        PLPProductItemsPageActions_Frig.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "Height", "70\"");
        PLPProductItemsPageActions_Frig.verifyExpandAndCollapseFilter(FrigidaireConstants.frigidaireWeb, "Price", "$1,000-$1,499");
        ExtentReportManager.getTest().pass("Successfully Verify every filter is with its sub-filter");

    }


    @Test(groups = {"regression"}, description = "Verify reset all filter")
    public void EPIC_04_PLP_TC_04_testResetAll() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.featureFilter(FrigidaireConstants.frigidaireWeb, "Series ", " Frigidaire Gallery ");
        PLPProductItemsPageActions_Frig.verifySelectedFilters("Frigidaire Gallery ");
        ExtentReportManager.getTest().pass("Successfully Verify reset all filter");

    }

    @Test(groups = {"regression"}, description = "Verify Ice maker filter with its functionality")
    public void EPIC_04_PLP_TC_04_verifyPLPUpdatesWhenSingleFilterSelected() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.featureFilter(FrigidaireConstants.frigidaireWeb, "Features ", " Ice Maker ");
        PLPProductItemsPageActions_Frig.openAllProductsAndValidate("Ice Maker", "Ice Maker", "Yes");
        ExtentReportManager.getTest().pass("Verify Ice maker filter with its functionality");


    }

    @Test(groups = {"regression"}, description = "Verify water dispenser filter with its functionality")
    public void EPIC_04_PLP_TC_04_verifyPLPUpdatesForWaterDispenserFeature() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.featureFilter(FrigidaireConstants.frigidaireWeb, "Features ", " Water Dispenser ");
        PLPProductItemsPageActions_Frig.openAllProductsAndValidate("Dispenser", "Water Dispenser", "Yes");
        ExtentReportManager.getTest().pass("Verify water dispenser filter with its functionality");


    }

    @Test(groups = {"regression"}, description = "Verify ADA Complaint filter with its functionality")
    public void EPIC_04_PLP_TC_04_verifyPLPUpdatesForADAComplaintFeature() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.featureFilter(FrigidaireConstants.frigidaireWeb, "Features ", " ADA Compliant ");
        PLPProductItemsPageActions_Frig.openAllProductsAndValidate("Certifications and Approvals", "ADA Compliant", "Yes");
        ExtentReportManager.getTest().pass("Verify ADA Complaint filter with its functionality");


    }


    @Test(groups = {"regression"}, description = "Verify ENERGY STAR Certified filter with its functionality")
    public void EPIC_04_PLP_TC_04_verifyPLPUpdatesForEnergyStarCertifiedFeature() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.featureFilter(FrigidaireConstants.frigidaireWeb, "Features ", " ENERGY STAR Certified ");
        PLPProductItemsPageActions_Frig.openAllProductsAndValidate("Certifications and Approvals", "ENERGY STAR Certified", "Yes");
        ExtentReportManager.getTest().pass("Verify ENERGY STAR Certified filter with its functionality");


    }

    @Test(groups = {"regression"}, description = "Verify filter with its functionality")
    public void EPIC_04_PLP_TC_04_verifyVisibilityOfFiltersInPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.verifyFiltersInPLP("Availability");
        PLPProductItemsPageActions_Frig.verifyFiltersInPLP("Series");
        PLPProductItemsPageActions_Frig.verifyFiltersInPLP("color");
        PLPProductItemsPageActions_Frig.verifyFiltersInPLP("Depth Type");
        PLPProductItemsPageActions_Frig.verifyFiltersInPLP("Features");
        PLPProductItemsPageActions_Frig.verifyFiltersInPLP("Standard Width");
        PLPProductItemsPageActions_Frig.verifyFiltersInPLP("Height");
        PLPProductItemsPageActions_Frig.verifyFiltersInPLP("Price");
        ExtentReportManager.getTest().pass("Successfully Verify filter with its functionality");


    }

    @Test(groups = {"regression"}, description = "Verify Visibility of frigidaire gallery filters in PLP")
    public void EPIC_04_PLP_TC_04_verifyFrigidaireGalleryProductInPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.verifyFiltersInPLP("Availability");
        PLPProductItemsPageActions_Frig.featureFilter(FrigidaireConstants.frigidaireWeb, "Series ", " Frigidaire Gallery ");
        PLPProductItemsPageActions_Frig.validateFrigidaireGalleryAndProfessionalProducts("Frigidaire Gallery", "Frigidaire Gallery");
        ExtentReportManager.getTest().pass("Verify Visibility of frigidaire gallery filters in PLP");

    }

    @Test(groups = {"regression"}, description = "Verify Visibility of frigidaire professional filters in PLP")
    public void EPIC_04_PLP_TC_04_verifyFrigidaireProfessionalProductInPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.verifyFiltersInPLP("Availability");
        PLPProductItemsPageActions_Frig.featureFilter(FrigidaireConstants.frigidaireWeb, "Series ", " Frigidaire Professional ");
        PLPProductItemsPageActions_Frig.validateFrigidaireGalleryAndProfessionalProducts("Frigidaire Professional", "Frigidaire Professional");
        ExtentReportManager.getTest().pass("Verify Visibility of frigidaire professional filters in PLP");

    }


    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void EPIC_04_PLP_TC_04_verifyPopularFiltersInPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");

        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.validatePopularFiltersInPLP("Water Disp.", "Water Disp.");
        PLPProductItemsPageActions_Frig.validatePopularFiltersInPLP("Counter Depth", "Counter Depth");
        PLPProductItemsPageActions_Frig.validatePopularFiltersInPLP("Std. Depth", "Std. Depth");
        PLPProductItemsPageActions_Frig.validatePopularFiltersInPLP("Ice Maker", "Ice Maker");
        ExtentReportManager.getTest().pass("Successfully verify Popular filters in PLP");

    }

    @Test(groups = {"smoke", "regression"}, description = "verify Popular Filters Is Checked On Clicking the Related Filter In PLP")
    public void EPIC_04_PLP_TC_04_verify_Popular_Filters_Is_Checked_On_Clicling_the_RelatedFilterInPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.featureFilter(FrigidaireConstants.frigidaireWeb, "Depth Type", "Counter-Depth");
        PLPProductItemsPageActions_Frig.validatePopularFilterTurnsRed("Counter Depth");
        ExtentReportManager.getTest().pass("verify Popular Filters Is Checked On Clicking the Related Filter In PLP");


    }


    @Test(groups = {"smoke", "regression"}, description = "verify counter depth filter is checked when counter depth in popular filter is selected")
    public void EPIC_04_PLP_TC_04_verify_Related_Filter_Is_Checked_On_Clicling_Popular_filter_In_PLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.featureFilter(FrigidaireConstants.frigidaireWeb, "Depth Type ", " Counter-Depth ");
        PLPProductItemsPageActions_Frig.validateCheckboxCheckedWhenPopularFilterClicked("Counter Depth", "Depth Type", "Counter-Depth");
        ExtentReportManager.getTest().pass("verify counter depth filter is checked when counter depth in popular filter is selected");

    }

    @Test(groups = {"smoke", "regression"}, description = "verify popular filter turrns red in PLP")
    public void EPIC_04_PLP_TC_04_verify_Popular_Filters_Is_Checked_On_Clicling_the_RelatedFilter1InPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.featureFilter(FrigidaireConstants.frigidaireWeb, "Features", "Standard-Depth");
        // PLPProductItemsPageActions.getFeatureSpecsLocator()
        PLPProductItemsPageActions_Frig.validatePopularFilterTurnsRed(" Std. Depth ");
        ExtentReportManager.getTest().pass("Successfully verify popular filter turrns red in PLP");


    }


    @Test(groups = {"smoke", "regression"}, description = "verify cross button (Below Hide Filters) when User clicks on particular filters in PLP")
    public void EPIC_04_PLP_TC_04_verify_Related_Filter_Is_Checked_On_Clicling_Popular_filter1_In_PLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.featureFilter(FrigidaireConstants.frigidaireWeb, "Depth Type", "Standard-Depth");
        PLPProductItemsPageActions_Frig.validateCheckboxCheckedWhenPopularFilterClicked("Std. Depth", "Depth Type", "Standard-Depth");
        ExtentReportManager.getTest().pass("Successfully Verify product dimensions for standard width");

    }


    @Test(groups = {"smoke", "regression"}, description = "verify Popular filter 'Ice Maker' successfully turned red in PLP")
    public void EPIC_04_PLP_TC_04_verify_Popular_Filters_Is_Checked_On_Clicling_the_RelatedFilter2InPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.featureFilter(FrigidaireConstants.frigidaireWeb, "Features ", " Ice Maker ");
        PLPProductItemsPageActions_Frig.validatePopularFilterTurnsRed("Ice Maker");
        ExtentReportManager.getTest().pass("Successfully Popular filter 'Ice Maker' successfully turned red");


    }


    @Test(groups = {"smoke", "regression"}, description = "verify Checkbox for 'Ice Maker' is now checked after Popular Filter click")
    public void EPIC_04_PLP_TC_04_verify_Related_Filter_Is_Checked_On_Clicling_Popular_filter2_In_PLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.featureFilter(FrigidaireConstants.frigidaireWeb, "Depth Type ", " Ice Maker ");
        PLPProductItemsPageActions_Frig.validateCheckboxCheckedWhenPopularFilterClicked("Ice Maker", "Features", "Ice Maker");
        ExtentReportManager.getTest().pass("Successfully Checkbox for 'Ice Maker' is now checked after Popular Filter click");

    }


    @Test(groups = {"smoke", "regression"}, description = "verify Popular filter 'Water Disp.' successfully turned red")
    public void EPIC_04_PLP_TC_04_verify_Popular_Filters_Is_Checked_On_Clicling_the_RelatedFilter3InPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.featureFilter(FrigidaireConstants.frigidaireWeb, "Features", "Water Dispenser");
        PLPProductItemsPageActions_Frig.validatePopularFilterTurnsRed("Water Disp.");
        ExtentReportManager.getTest().pass("Successfully verify Popular filter 'Water Disp.' successfully turned red");


    }


    @Test(groups = {"smoke", "regression"}, description = "Checkbox for 'Water Dispenser' is now checked after Popular Filter click")
    public void EPIC_04_PLP_TC_04_verify_Related_Filter_Is_Checked_On_Clicling_Popular_filter3_In_PLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.featureFilter(FrigidaireConstants.frigidaireWeb, "Depth Type", "Water Dispenser");
        PLPProductItemsPageActions_Frig.validateCheckboxCheckedWhenPopularFilterClicked("Water Disp.", "Features", "Water Dispenser");
        ExtentReportManager.getTest().pass("Successfully verify Checkbox for 'Water Dispenser' is now checked after Popular Filter click");

    }


    @Test(groups = {"smoke", "regression"}, description = "verify Availability of products in PLP")
    public void EPIC_04_PLP_TC_04_verify_Availaibility_In_PLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.validateAvailabilityOfProductsInPLP();
        ExtentReportManager.getTest().pass("Successfully verify Availability of products in PLP");

    }

    @Test(groups = {"smoke", "regression"}, description = "verify Checkbox Unchecked After Cross Click")
    public void EPIC_04_PLP_TC_04_verify_CrossBtn_In_PLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("frigidaire", "Kitchen", "French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators", "French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions_Frig.validateCheckboxUncheckedAfterCrossClick("Series", "Frigidaire Gallery", "Frigidaire Gallery");
        PLPProductItemsPageActions_Frig.validateCheckboxUncheckedAfterCrossClick("Series", "Frigidaire Professional", "Frigidaire Professional");
        PLPProductItemsPageActions_Frig.validateCheckboxUncheckedAfterCrossClick("Series", "Frigidaire", "Frigidaire");
        ExtentReportManager.getTest().pass("Successfully verify Checkbox Unchecked After Cross Click");

    }

    @Test(groups = {"smoke", "regression"}, description = "verify Color of products in PLP")
    public void verifyColorFilter() throws InterruptedException
    {
        navigateToFrenchDoorRefrigerators("frigidaire","Kitchen","French Door");
        PLPProductItemsPageActions_Frig.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions_Frig.verifyFiltersInProductItems("Availability",60,"Availability");
        PLPProductItemsPageActions_Frig.clickOnProductMenu("White");
        PLPProductItemsPageActions_Frig.openAllProductsAndValidateColor("frigidaire","White","White");
        ExtentReportManager.getTest().pass("Successfully verify Color of products in PLP");

    }


}
