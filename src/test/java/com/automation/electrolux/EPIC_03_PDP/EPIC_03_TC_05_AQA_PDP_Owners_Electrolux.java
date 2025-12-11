package com.automation.electrolux.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.electrolux.pages.ElectroluxFeaturePageActions;
import com.automation.electrolux.pages.ElectroluxProductCards;
import com.automation.frigidaire.pages.FeaturesPageActions;
import com.automation.frigidaire.pages.PlpPageActions_Frig;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_05_AQA_PDP_Owners_Electrolux extends BaseTest {
    private final ElectroluxProductCards homePage = new ElectroluxProductCards();
    private final FeaturesPageActions pdpPage = new FeaturesPageActions();
    private final PlpPageActions_Frig plpPage = new PlpPageActions_Frig();
    private final ElectroluxFeaturePageActions elePage = new ElectroluxFeaturePageActions();

    @Test(groups = {"regression"}, description = "Verify My Owners section on PDP page")
    public void EPIC_03_PDPPage_TC_05_verifyFeaturesSectionOnPDP() {
        homePage.navigateToHomePage();
        pdpPage.searchProduct("EHVS2510AW-C1");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        Assert.assertTrue(elePage.validateDownloadableDocuments(), "Downloadable documents are not visible or valid");

        ExtentReportManager.getTest().pass("Verify My Owners section on PDP page");
    }

}
