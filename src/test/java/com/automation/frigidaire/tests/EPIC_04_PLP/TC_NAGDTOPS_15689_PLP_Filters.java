package com.automation.frigidaire.tests.EPIC_04_PLP;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.ProductCategoryPageActions;
import com.automation.frigidaire.pages.ProductItemsPageActions;
import com.automation.frigidaire.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NAGDTOPS_15689_PLP_Filters extends BaseTest {
    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    ProductCategoryPageActions productCategoryPageActions=new ProductCategoryPageActions();
    ProductItemsPageActions productItemsPageActions =new ProductItemsPageActions();

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
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.verifyHideAndShowAllFilters("Hide filters");
        productItemsPageActions.verifyHideAndShowAllFilters("Show all filters");
        productItemsPageActions.verifyHideFilters("Hide filters");
    }


    @Test(groups = {"smoke", "regression"}, description = "Verify product dimensions for standard width")
    public void testStandardWidthDimensions() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.standardWidthClick();
        productItemsPageActions.verifyProductWidthHeightAndDepth();
    }




    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void testExpandAndCollapseFilter() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.verifyExpandAndCollapseFilter("Series", "Frigidaire");
        productItemsPageActions.verifyExpandAndCollapseFilter("color", "Stainless Steel");
        productItemsPageActions.verifyExpandAndCollapseFilter("Depth Type", "Counter-Depth");
        productItemsPageActions.verifyExpandAndCollapseFilter("Features", "Ice Maker");
        productItemsPageActions.verifyExpandAndCollapseFilter("Standard Width", "30\"");
        productItemsPageActions.verifyExpandAndCollapseFilter("Height", "70\"");
        productItemsPageActions.verifyExpandAndCollapseFilter("Price", "$1,000-$1,499");

    }


    @Test(groups = {"regression"}, description = "Verify reset all filter")
    public void testResetAll() throws InterruptedException  {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.featureFilter("Series ", " Frigidaire Gallery ");
        productItemsPageActions.verifySelectedFilters("Frigidaire Gallery ");

    }

    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void verifyPLPUpdatesWhenSingleFilterSelected() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.featureFilter("Features ", " Ice Maker ");
        productItemsPageActions.openAllProductsAndValidate("Ice Maker","Ice Maker","Yes");


    }

    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void verifyPLPUpdatesForWaterDispenserFeature() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.featureFilter("Features ", " Water Dispenser ");
        productItemsPageActions.openAllProductsAndValidate("Dispenser","Water Dispenser","Yes");


    }

    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void verifyPLPUpdatesForADAComplaintFeature() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.featureFilter("Features ", " ADA Compliant ");
        productItemsPageActions.openAllProductsAndValidate("Certifications and Approvals","ADA Compliant","Yes");


    }


    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void verifyPLPUpdatesForEnergyStarCertifiedFeature() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.featureFilter("Features ", " ENERGY STAR Certified ");
        productItemsPageActions.openAllProductsAndValidate("Certifications and Approvals","ENERGY STAR Certified","Yes");


    }

    @Test(groups = {"regression"}, description = "Verify Visibility of every filters in PLP")
    public void verifyVisibilityOfFiltersInPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.verifyFiltersInPLP("Availability");
        productItemsPageActions.verifyFiltersInPLP("Series");
        productItemsPageActions.verifyFiltersInPLP("color");
        productItemsPageActions.verifyFiltersInPLP("Depth Type");
        productItemsPageActions.verifyFiltersInPLP("Features");
        productItemsPageActions.verifyFiltersInPLP("Standard Width");
        productItemsPageActions.verifyFiltersInPLP("Height");
        productItemsPageActions.verifyFiltersInPLP("Price");




    }

    @Test(groups = {"regression"}, description = "Verify Visibility of every filters in PLP")
    public void verifyFrigidaireGalleryProductInPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.verifyFiltersInPLP("Availability");
        productItemsPageActions.featureFilter("Series ", " Frigidaire Gallery ");
        productItemsPageActions.validateFrigidaireGalleryAndProfessionalProducts("Frigidaire Gallery","Frigidaire Gallery");

    }

    @Test(groups = {"regression"}, description = "Verify Visibility of every filters in PLP")
    public void verifyFrigidaireProfessionalProductInPLP() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.verifyFiltersInPLP("Availability");
        productItemsPageActions.featureFilter("Series ", " Frigidaire Professional ");
        productItemsPageActions.validateFrigidaireGalleryAndProfessionalProducts("Frigidaire Professional","Frigidaire Professional");

    }


    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verifyPopularFiltersInPLP()
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
        //productItemsPageActions.closeEmailPopUp();
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
       productItemsPageActions.validatePopularFiltersInPLP("Water Disp.","Water Disp.");
       productItemsPageActions.validatePopularFiltersInPLP("Counter Depth","Counter Depth");
       productItemsPageActions.validatePopularFiltersInPLP("Std. Depth","Std. Depth");
        productItemsPageActions.validatePopularFiltersInPLP("Ice Maker","Ice Maker");

    }

    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_Popular_Filters_Is_Checked_On_Clicling_the_RelatedFilterInPLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
        //productItemsPageActions.closeEmailPopUp();
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
        productItemsPageActions.featureFilter("Depth Type ", " Counter-Depth ");
        productItemsPageActions.validatePopularFilterTurnsRed("Counter Depth");


    }



    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_Related_Filter_Is_Checked_On_Clicling_Popular_filter_In_PLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
//        productItemsPageActions.closeEmailPopUp();
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
        productItemsPageActions.featureFilter("Depth Type ", " Counter-Depth ");
        productItemsPageActions.validateCheckboxCheckedWhenPopularFilterClicked("Counter Depth","Depth Type", "Counter-Depth");

    }

    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_Popular_Filters_Is_Checked_On_Clicling_the_RelatedFilter1InPLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
//        productItemsPageActions.closeEmailPopUp();
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
        productItemsPageActions.featureFilter("Features ", " Standard-Depth ");
        productItemsPageActions.validatePopularFilterTurnsRed(" Std. Depth ");


    }


    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_Related_Filter_Is_Checked_On_Clicling_Popular_filter1_In_PLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
//        productItemsPageActions.closeEmailPopUp();
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
        productItemsPageActions.featureFilter("Depth Type ", " Standard-Depth ");
        productItemsPageActions.validateCheckboxCheckedWhenPopularFilterClicked("Std. Depth","Depth Type", "Standard-Depth");

    }


    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_Popular_Filters_Is_Checked_On_Clicling_the_RelatedFilter2InPLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
//        productItemsPageActions.closeEmailPopUp();
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
        productItemsPageActions.featureFilter("Features ", " Ice Maker ");
        productItemsPageActions.validatePopularFilterTurnsRed("Ice Maker");


    }



    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_Related_Filter_Is_Checked_On_Clicling_Popular_filter2_In_PLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
//        productItemsPageActions.closeEmailPopUp();
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
        productItemsPageActions.featureFilter("Depth Type ", " Ice Maker ");
        productItemsPageActions.validateCheckboxCheckedWhenPopularFilterClicked("Ice Maker","Features", "Ice Maker");

    }





    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_Popular_Filters_Is_Checked_On_Clicling_the_RelatedFilter3InPLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
//        productItemsPageActions.closeEmailPopUp();
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
        productItemsPageActions.featureFilter("Features ", " Water Dispenser ");
        productItemsPageActions.validatePopularFilterTurnsRed("Water Disp.");


    }


    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_Related_Filter_Is_Checked_On_Clicling_Popular_filter3_In_PLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
//        productItemsPageActions.closeEmailPopUp();
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
        productItemsPageActions.featureFilter("Depth Type ", " Water Dispenser ");
        productItemsPageActions.validateCheckboxCheckedWhenPopularFilterClicked("Water Disp.","Features", "Water Dispenser");

    }



    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_Availaibility_In_PLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
       // productItemsPageActions.closeEmailPopUp();
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");
        productItemsPageActions.validateAvailabilityOfProductsInPLP();

    }

    @Test(groups = {"smoke", "regression"}, description = "verify Popular filters in PLP")
    public void verify_CrossBtn_In_PLP() throws InterruptedException
    {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
//        productItemsPageActions.closeEmailPopUp();
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators","French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");

        productItemsPageActions.validateCheckboxUncheckedAfterCrossClick("Series", "Frigidaire Gallery","Frigidaire Gallery");

        productItemsPageActions.validateCheckboxUncheckedAfterCrossClick("Series", "Frigidaire Professional","Frigidaire Professional");

        productItemsPageActions.validateCheckboxUncheckedAfterCrossClick("Series", "Frigidaire","Frigidaire");

    }




}
