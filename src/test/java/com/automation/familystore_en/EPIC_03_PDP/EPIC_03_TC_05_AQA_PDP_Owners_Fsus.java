package com.automation.familystore_en.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.familystore_en.pages.FeaturesPageActionsFsus;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.FrigidairePlpPageActions;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_05_AQA_PDP_Owners_Fsus extends BaseTest {

    private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    private final FeaturesPageActionsFsus pdpPage = new FeaturesPageActionsFsus();
    private final FrigidairePlpPageActions plpPage = new FrigidairePlpPageActions();

    @Test(groups = {"regression"}, description = "Verify My Owners section on PDP page")
    public void EPIC_03_PDPPage_TC_05_verifyFeaturesSectionOnPDP() {
        homePage.navigateToHomePage();
        pdpPage.searchProduct("EHVS75S1AO");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        Assert.assertTrue(pdpPage.validateDownloadableDocuments(), "Downloadable documents are not visible or valid");

        ExtentReportManager.getTest().pass("Verify My Owners section on PDP page");
    }


}
