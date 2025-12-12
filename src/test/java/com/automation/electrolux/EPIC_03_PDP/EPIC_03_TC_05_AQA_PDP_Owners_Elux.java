package com.automation.electrolux.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.electrolux.pages.FeaturePageActionsElux;
import com.automation.electrolux.pages.ProductDetailPageActionElux;
import com.automation.frigidaire.pages.FrigidairePlpPageActions;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_05_AQA_PDP_Owners_Elux extends BaseTest {
    private final ProductDetailPageActionElux homePage = new ProductDetailPageActionElux();
    private final FrigidairePlpPageActions plpPage = new FrigidairePlpPageActions();
    private final FeaturePageActionsElux elePage = new FeaturePageActionsElux();

    @Test(groups = {"regression"}, description = "Verify My Owners section on PDP page")
    public void EPIC_03_PDPPage_TC_05_verifyFeaturesSectionOnPDP() {
        homePage.navigateToHomePage();
        elePage.searchProduct("EHVS2510AW-C1");
        elePage.selectProductFromPLP();
        plpPage.closePopupModel();
        Assert.assertTrue(elePage.validateDownloadableDocuments(), "Downloadable documents are not visible or valid");

        ExtentReportManager.getTest().pass("Verify My Owners section on PDP page");
    }

}
