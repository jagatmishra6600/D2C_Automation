package com.automation.electrolux.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.electrolux.pages.FeaturePageActionsElux;
import com.automation.electrolux.pages.ProductDetailPageActionElux;
import com.automation.frigidaire.pages.FrigidairePlpPageActions;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class EPIC_03_TC_04_AQA_PDP_Features_Elux extends BaseTest {
    private final ProductDetailPageActionElux homePage = new ProductDetailPageActionElux();
    private final FeaturePageActionsElux pdpPage = new FeaturePageActionsElux();
    private final FrigidairePlpPageActions plpPage = new FrigidairePlpPageActions();

    @Test(groups = {"regression"}, description = "Verify features in the Overview & Features section with description and links for electrolux")
    public void EPIC_03_PDPPage_TC_04_verifyFeaturesSectionOnPDPElx() {
        homePage.navigateToHomePage();
        pdpPage.searchProduct("EHVS2510AW-C1");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        boolean isDescriptionDisplayed = pdpPage.validateFeatureDescription();
        Assert.assertTrue(isDescriptionDisplayed, "Description is not visible for features");

        ExtentReportManager.getTest().pass("Verify features in the Overview & Features section with description and links");
    }

    @Test(groups = {"regression"}, description = "Verify View All functionality and Show More button to reveal more banners for electrolux")
    public void EPIC_03_PDPPage_TC_05_verifyViewMoreFunctionalityInFeaturesSectionOnPDPElx() {
        homePage.navigateToHomePage();
        pdpPage.searchProduct("EHVS2510AW-C1");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        Assert.assertTrue(pdpPage.validateViewMoreButtonFunctionality(), "View More button is not working");

        ExtentReportManager.getTest().pass("Verify View All functionality and Show More button to reveal more banners");
    }
}
