package com.automation.frigidaire.tests.EPIC_03_PDPPage;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.FeaturesPageActions;
import com.automation.frigidaire.pages.FrigidairePlpPageActions;
import com.automation.frigidaire.tests.BaseTest;
import com.automation.frigidaire.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_05_AQA_PDP_Owners extends BaseTest {
    private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    private final FeaturesPageActions pdpPage = new FeaturesPageActions();
    private final FrigidairePlpPageActions plpPage = new FrigidairePlpPageActions();

    @Test(groups = {"regression"}, description = "Verify My Owners section on PDP page")
    public void verifyFeaturesSectionOnPDP() {
        homePage.navigateToHomePage();
        pdpPage.searchProduct("GRMC2273CF-C1");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        Assert.assertTrue(pdpPage.validateGuideAndManualSection(), "Guide & Manual Section is not visible");
        Assert.assertTrue(pdpPage.validateDownloadableDocumentsForAllLanguages(), "Downloadable documents are not visible or valid for all languages");

        ExtentReportManager.getTest().pass("Verify My Owners section on PDP page");
    }

    @Test(groups = {"regression"}, description = "Verify Service and Parts section")
    public void verifyServiceAndPartsSectionOnPDP() {
        homePage.navigateToHomePage();
        pdpPage.searchProduct("GRMC2273CF-C1");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        Assert.assertTrue(pdpPage.validateReplacementPartsTile(), "Replacement Parts tile validation failed.");
        Assert.assertTrue(pdpPage.validateRepairsServiceTile(), "Repairs & Service tile validation failed.");

        ExtentReportManager.getTest().pass("Verify Service and Parts section");
    }


}
