package com.automation.frigidaire.EPIC_03_PDPPage;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.BaseTest;
import com.automation.frigidaire.pages.FeaturesPageActions;
import com.automation.frigidaire.pages.FrigidairePlpPageActions;
<<<<<<< HEAD
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WebElementUtil;
=======
import com.automation.frigidaire.utils.ExtentReportManager;
import com.automation.frigidaire.utils.WebElementUtil;
>>>>>>> c6eb8d75fde6b68139cd97bec28b88f0b427ba85
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_05_AQA_PDP_Owners extends BaseTest {
    private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    private final FeaturesPageActions pdpPage = new FeaturesPageActions();
    private final FrigidairePlpPageActions plpPage = new FrigidairePlpPageActions();
    String currentUrl;

    @Test(groups = {"regression"}, description = "Verify My Owners section on PDP page")
    public void EPIC_03_PDPPage_TC_05_verifyFeaturesSectionOnPDP() {
        homePage.navigateToHomePage();
        currentUrl = WebElementUtil.getCurrentUrl();
        if (currentUrl.contains("frigidaire")) {
            pdpPage.searchProduct("GRMC2273CF-C1");
            pdpPage.selectProductFromPLP();
            plpPage.closePopupModel();
            Assert.assertTrue(pdpPage.validateGuideAndManualSection(), "Guide & Manual Section is not visible");
            Assert.assertTrue(pdpPage.validateDownloadableDocumentsForAllLanguages(), "Downloadable documents are not visible or valid for all languages");
        } else if (currentUrl.contains("electrolux")) {
            pdpPage.searchProduct("EHVS2510AW-C1");
            pdpPage.selectProductFromPLP();
            plpPage.closePopupModel();
            Assert.assertTrue(pdpPage.validateDownloadableDocuments(), "Downloadable documents are not visible or valid");
        }

        ExtentReportManager.getTest().pass("Verify My Owners section on PDP page");
    }

    @Test(groups = {"regression"}, description = "Verify Service and Parts section")
    public void EPIC_03_PDPPage_TC_05_verifyServiceAndPartsSectionOnPDP() {
        homePage.navigateToHomePage();
        currentUrl = WebElementUtil.getCurrentUrl();
        if (currentUrl.contains("frigidaire")) {
            pdpPage.searchProduct("EHVS2510AW-C1");
            pdpPage.selectProductFromPLP();
            plpPage.closePopupModel();
            Assert.assertTrue(pdpPage.validateReplacementPartsTile(), "Replacement Parts tile validation failed.");
            Assert.assertTrue(pdpPage.validateRepairsServiceTile(), "Repairs & Service tile validation failed.");
        } else if (currentUrl.contains("electrolux")) {

        }

        ExtentReportManager.getTest().pass("Verify Service and Parts section");
    }

}
