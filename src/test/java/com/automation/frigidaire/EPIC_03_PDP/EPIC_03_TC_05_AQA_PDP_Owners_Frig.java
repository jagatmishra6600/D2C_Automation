package com.automation.frigidaire.EPIC_03_PDP;

import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.BaseTest;
import com.automation.frigidaire.pages.FeaturesPageActionsFrig;
import com.automation.frigidaire.pages.PlpPageActionsFrig;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_05_AQA_PDP_Owners_Frig extends BaseTest {
    private final HomePageActionsFrig homePage = new HomePageActionsFrig();
    private final FeaturesPageActionsFrig pdpPage = new FeaturesPageActionsFrig();
    private final PlpPageActionsFrig plpPage = new PlpPageActionsFrig();

    @Test(groups = {"regression"}, description = "Verify My Owners section on PDP page")
    public void EPIC_03_PDPPage_TC_05_verifyFeaturesSectionOnPDP() {
        homePage.navigateToHomePage();
        pdpPage.searchProduct("GRMC2273CF-C1");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        Assert.assertTrue(pdpPage.validateGuideAndManualSection(), "Guide & Manual Section is not visible");
        Assert.assertTrue(pdpPage.validateDownloadableDocumentsForAllLanguages(), "Downloadable documents are not visible or valid for all languages");

        ExtentReportManager.getTest().pass("Verify My Owners section on PDP page");
    }

    @Test(groups = {"regression"}, description = "Verify Service and Parts section")
    public void EPIC_03_PDPPage_TC_05_verifyServiceAndPartsSectionOnPDP() {
        homePage.navigateToHomePage();
        pdpPage.searchProduct("GRMC2273CF-C1");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        Assert.assertTrue(pdpPage.validateReplacementPartsTile(), "Replacement Parts tile validation failed.");
        Assert.assertTrue(pdpPage.validateRepairsServiceTile(), "Repairs & Service tile validation failed.");

        ExtentReportManager.getTest().pass("Verify Service and Parts section");
    }

}
