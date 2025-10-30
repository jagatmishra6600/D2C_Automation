package com.automation.frigidaire.tests.EPIC_04_PLP;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions;
import com.automation.frigidaire.pages.PLPProductItemsPageActions;
import com.automation.frigidaire.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NAGDTOPS_15689_PLP_Filters extends BaseTest {
    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductCategoryPageActions productCategoryPageActions=new ProductCategoryPageActions();
    PLPProductItemsPageActions PLPProductItemsPageActions =new PLPProductItemsPageActions();

    public void navigateToFrenchDoorRefrigerators(String prodCategory , String subProdCategory ) throws InterruptedException {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu(prodCategory);
        productCategoryPageActions.clickOnProductMenu(subProdCategory);
       // productItemsPageActions.closeEmailPopUp();

    }


    @Test(groups = {"smoke", "regression"}, description = "Verify hide/show filters functionality")
    public void testHideShowFilters() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.verifyHideAndShowAllFilters("Hide filters");
        PLPProductItemsPageActions.verifyHideAndShowAllFilters("Show all filters");
        PLPProductItemsPageActions.verifyHideFilters("Hide filters");
    }


    @Test(groups = {"smoke", "regression"}, description = "Verify product dimensions for standard width")
    public void testStandardWidthDimensions() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.standardWidthClick();
        PLPProductItemsPageActions.verifyProductWidthHeightAndDepth();
    }




    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void testExpandAndCollapseFilter() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter("Series", "Frigidaire");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter("color", "Stainless Steel");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter("Depth Type", "Counter-Depth");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter("Features", "Ice Maker");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter("Standard Width", "30\"");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter("Height", "70\"");
        PLPProductItemsPageActions.verifyExpandAndCollapseFilter("Price", "$1,000-$1,499");

    }


    @Test(groups = {"regression"}, description = "Verify reset all filter")
    public void testResetAll() throws InterruptedException  {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter("Series ", " Frigidaire Gallery ");
        PLPProductItemsPageActions.verifySelectedFilters("Frigidaire Gallery ");

    }

    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void verifyPLPUpdatesWhenSingleFilterSelected() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter("Features ", " Ice Maker ");
        PLPProductItemsPageActions.openAllProductsAndValidate("Ice Maker","Ice Maker","Yes");


    }

    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void verifyPLPUpdatesForWaterDispenserFeature() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter("Features ", " Water Dispenser ");
        PLPProductItemsPageActions.openAllProductsAndValidate("Dispenser","Water Dispenser","Yes");


    }

    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void verifyPLPUpdatesForADAComplaintFeature() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter("Features ", " ADA Compliant ");
        PLPProductItemsPageActions.openAllProductsAndValidate("Certifications and Approvals","ADA Compliant","Yes");


    }


    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void verifyPLPUpdatesForEnergyStarCertifiedFeature() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.featureFilter("Features ", " ENERGY STAR Certified ");
        PLPProductItemsPageActions.openAllProductsAndValidate("Certifications and Approvals","ENERGY STAR Certified","Yes");


    }

    @Test(groups = {"regression"}, description = "Verify Visibility of every filters in PLP")
    public void verifyVisibilityOfFiltersInPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.verifyFiltersInPLP("Availability");
        PLPProductItemsPageActions.verifyFiltersInPLP("Series");
        PLPProductItemsPageActions.verifyFiltersInPLP("color");
        PLPProductItemsPageActions.verifyFiltersInPLP("Depth Type");
        PLPProductItemsPageActions.verifyFiltersInPLP("Features");
        PLPProductItemsPageActions.verifyFiltersInPLP("Standard Width");
        PLPProductItemsPageActions.verifyFiltersInPLP("Height");
        PLPProductItemsPageActions.verifyFiltersInPLP("Price");




    }

    @Test(groups = {"regression"}, description = "Verify Visibility of every filters in PLP")
    public void verifyFrigidaireGalleryProductInPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.verifyFiltersInPLP("Availability");
        PLPProductItemsPageActions.featureFilter("Series ", " Frigidaire Gallery ");
        PLPProductItemsPageActions.validateFrigidaireGalleryAndProfessionalProducts("Frigidaire Gallery","Frigidaire Gallery");

    }

    @Test(groups = {"regression"}, description = "Verify Visibility of every filters in PLP")
    public void verifyFrigidaireProfessionalProductInPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        PLPProductItemsPageActions.verifyFiltersInPLP("Availability");
        PLPProductItemsPageActions.featureFilter("Series ", " Frigidaire Professional ");
        PLPProductItemsPageActions.validateFrigidaireGalleryAndProfessionalProducts("Frigidaire Professional","Frigidaire Professional");

    }


    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verifyPopularFiltersInPLP()
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
        //productItemsPageActions.closeEmailPopUp();
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
       PLPProductItemsPageActions.validatePopularFiltersInPLP("Water Disp.","Water Disp.");
       PLPProductItemsPageActions.validatePopularFiltersInPLP("Counter Depth","Counter Depth");
       PLPProductItemsPageActions.validatePopularFiltersInPLP("Std. Depth","Std. Depth");
        PLPProductItemsPageActions.validatePopularFiltersInPLP("Ice Maker","Ice Maker");

    }

    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_Popular_Filters_Is_Checked_On_Clicling_the_RelatedFilterInPLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
        //productItemsPageActions.closeEmailPopUp();
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
        PLPProductItemsPageActions.featureFilter("Depth Type ", " Counter-Depth ");
        PLPProductItemsPageActions.validatePopularFilterTurnsRed("Counter Depth");


    }



    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_Related_Filter_Is_Checked_On_Clicling_Popular_filter_In_PLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
//        productItemsPageActions.closeEmailPopUp();
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
        PLPProductItemsPageActions.featureFilter("Depth Type ", " Counter-Depth ");
        PLPProductItemsPageActions.validateCheckboxCheckedWhenPopularFilterClicked("Counter Depth","Depth Type", "Counter-Depth");

    }

    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_Popular_Filters_Is_Checked_On_Clicling_the_RelatedFilter1InPLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
//        productItemsPageActions.closeEmailPopUp();
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
        PLPProductItemsPageActions.featureFilter("Features ", " Standard-Depth ");
        PLPProductItemsPageActions.validatePopularFilterTurnsRed(" Std. Depth ");


    }


    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_Related_Filter_Is_Checked_On_Clicling_Popular_filter1_In_PLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
//        productItemsPageActions.closeEmailPopUp();
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
        PLPProductItemsPageActions.featureFilter("Depth Type ", " Standard-Depth ");
        PLPProductItemsPageActions.validateCheckboxCheckedWhenPopularFilterClicked("Std. Depth","Depth Type", "Standard-Depth");

    }


    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_Popular_Filters_Is_Checked_On_Clicling_the_RelatedFilter2InPLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
//        productItemsPageActions.closeEmailPopUp();
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
        PLPProductItemsPageActions.featureFilter("Features ", " Ice Maker ");
        PLPProductItemsPageActions.validatePopularFilterTurnsRed("Ice Maker");


    }



    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_Related_Filter_Is_Checked_On_Clicling_Popular_filter2_In_PLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
//        productItemsPageActions.closeEmailPopUp();
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
        PLPProductItemsPageActions.featureFilter("Depth Type ", " Ice Maker ");
        PLPProductItemsPageActions.validateCheckboxCheckedWhenPopularFilterClicked("Ice Maker","Features", "Ice Maker");

    }





    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_Popular_Filters_Is_Checked_On_Clicling_the_RelatedFilter3InPLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
//        productItemsPageActions.closeEmailPopUp();
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
        PLPProductItemsPageActions.featureFilter("Features ", " Water Dispenser ");
        PLPProductItemsPageActions.validatePopularFilterTurnsRed("Water Disp.");


    }


    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_Related_Filter_Is_Checked_On_Clicling_Popular_filter3_In_PLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
//        productItemsPageActions.closeEmailPopUp();
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
        PLPProductItemsPageActions.featureFilter("Depth Type ", " Water Dispenser ");
        PLPProductItemsPageActions.validateCheckboxCheckedWhenPopularFilterClicked("Water Disp.","Features", "Water Dispenser");

    }



    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_Availaibility_In_PLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
       // productItemsPageActions.closeEmailPopUp();
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
        PLPProductItemsPageActions.validateAvailabilityOfProductsInPLP();

    }

    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_CrossBtn_In_PLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
//        productItemsPageActions.closeEmailPopUp();
        PLPProductItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        PLPProductItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");

        PLPProductItemsPageActions.validateCheckboxUncheckedAfterCrossClick("Series", "Frigidaire Gallery","Frigidaire Gallery");

        PLPProductItemsPageActions.validateCheckboxUncheckedAfterCrossClick("Series", "Frigidaire Professional","Frigidaire Professional");

        PLPProductItemsPageActions.validateCheckboxUncheckedAfterCrossClick("Series", "Frigidaire","Frigidaire");

    }




}
