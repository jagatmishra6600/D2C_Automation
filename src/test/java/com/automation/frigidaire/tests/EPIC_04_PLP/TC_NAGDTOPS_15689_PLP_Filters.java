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
        productItemsPageActions.closeEmailPopUp();

    }


    @Test(groups = {"smoke", "regression"}, description = "Verify hide/show filters functionality")
    public void testHideShowFilters() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.verifyHideAndShowAllFilters("Hide filters");
        productItemsPageActions.verifyHideAndShowAllFilters("Show all filters");
        productItemsPageActions.verifyHideFilters("Hide filters");
    }


    @Test(groups = {"smoke", "regression"}, description = "Verify product dimensions for standard width")
    public void testStandardWidthDimensions() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.standardWidthClick();
        productItemsPageActions.verifyProductWidthHeightAndDepth();
    }

    @Test(groups = {"regression"}, description = "Verify feature filters functionality")
    public void testFeatureFilters() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.featureFilter("Features ", " Ice Maker ");
        productItemsPageActions.featureFilter("Series ", " Frigidaire Gallery ");
        productItemsPageActions.featureFilter("Depth Type ", " Counter-Depth ");
        productItemsPageActions.featureFilter("color ", " Stainless Steel ");
        productItemsPageActions.featureFilter("Price ", "$1,500-$1,999");
        //productItemsPageActions.verifyProductPrice(1500,1999,"$1,500-$1,999" );
    }


    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void testExpandAndCollapseFilter() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators");
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
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.featureFilter("Series ", " Frigidaire Gallery ");
        productItemsPageActions.verifySelectedFilters("Frigidaire Gallery ");

    }

    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void verifyPLPUpdatesWhenSingleFilterSelected() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.featureFilter("Features ", " Ice Maker ");
        productItemsPageActions.openAllProductsAndValidate("Ice Maker","Ice Maker","Yes");


    }

    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void verifyPLPUpdatesForWaterDispenserFeature() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.featureFilter("Features ", " Water Dispenser ");
        productItemsPageActions.openAllProductsAndValidate("Dispenser","Water Dispenser","Yes");


    }

    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void verifyPLPUpdatesForADAComplaintFeature() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.featureFilter("Features ", " ADA Compliant ");
        productItemsPageActions.openAllProductsAndValidate("Certifications and Approvals","ADA Compliant","Yes");


    }


    @Test(groups = {"regression"}, description = "Verify expand and collapse of filter sections")
    public void verifyPLPUpdatesForEnergyStarCertifiedFeature() throws InterruptedException {
        navigateToFrenchDoorRefrigerators("Kitchen","French Door");
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        productItemsPageActions.featureFilter("Features ", " ENERGY STAR Certified ");
        productItemsPageActions.openAllProductsAndValidate("Certifications and Approvals","ENERGY STAR Certified","Yes");


    }




   // @Test(groups = {"smoke", "regression"}, description = "Should load the Frigidaire home page successfully")
    public void testHomePageLoad() throws InterruptedException  {

        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productCategoryPageActions.clickOnProductMenu("Kitchen");
        productCategoryPageActions.clickOnProductMenu("French Door");
        productItemsPageActions.closeEmailPopUp();
        productItemsPageActions.verifyProductItemPage("French Door Refrigerators");
        productItemsPageActions.verifyFiltersInProductItems("Availability",60,"Availability");


//        productItemsPageActions.verifyHideAndShowAllFilters("Hide filters");
//        productItemsPageActions.verifyHideAndShowAllFilters("Show all filters");
       // productItemsPageActions.standardWidthClick();
//        productItemsPageActions.verifyProductWidthHeightAndDepth();
//        productItemsPageActions.featureFilter("Features "," Ice Maker ");
//        productItemsPageActions.featureFilter("Series "," Frigidaire Gallery ");
//        productItemsPageActions.featureFilter("Depth Type "," Counter-Depth ");
//        productItemsPageActions.featureFilter("Price "," $1,000-$1,499 ");
//        productItemsPageActions.featureFilter("color "," Stainless Steel ");
        //productItemsPageActions.verifyExpandAndCollapseFilter("Series","Frigidaire");
          //productItemsPageActions.verifyProductPrice(1500,1999,"$1,500-$1,999" );




    }
    @Test(groups = {"smoke", "regression"}, description = "Should load the Frigidaire home page successfully")
    public void verifyFiltersInProductItems()
    {
      // productItemsPageActions.verifyFiltersInProductItems("Availability",60);

    }

}
