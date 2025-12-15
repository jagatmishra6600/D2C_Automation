package com.automation.electrolux.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.electrolux.pages.FeaturePageActionsElux;
import com.automation.electrolux.pages.ProductDetailPageActionsElux;
import com.automation.frigidaire.pages.PlpPageActionsFrig;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_05_AQA_PDP_Owners_Elux extends BaseTest {
    private final ProductDetailPageActionsElux homePage = new ProductDetailPageActionsElux();
    private final PlpPageActionsFrig plpPage = new PlpPageActionsFrig();
    private final FeaturePageActionsElux pdpPage = new FeaturePageActionsElux();

    @Test(groups = {"regression"}, description = "Verify My Owners section on PDP page")
    public void EPIC_03_PDPPage_TC_05_verifyFeaturesSectionOnPDP() {
        homePage.navigateToHomePage();
        pdpPage.searchProduct("EHVS2510AW-C1");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        Assert.assertTrue(pdpPage.validateDownloadableDocuments(), "Downloadable documents are not visible or valid");

        ExtentReportManager.getTest().pass("Verify My Owners section on PDP page");
    }

}
