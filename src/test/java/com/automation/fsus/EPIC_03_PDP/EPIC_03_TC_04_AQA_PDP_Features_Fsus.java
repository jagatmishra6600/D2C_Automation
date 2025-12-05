package com.automation.fsus.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.FeaturesPageActionsFsus;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.FrigidairePlpPageActions;
import com.automation.familystoreus.pages.FsusLoginPageActions;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_04_AQA_PDP_Features_Fsus extends BaseTest {

    private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    private final FeaturesPageActionsFsus pdpPage = new FeaturesPageActionsFsus();
    private final FrigidairePlpPageActions plpPage = new FrigidairePlpPageActions();
    private final FsusLoginPageActions loginPage = new FsusLoginPageActions();

    @Test(groups = {
            "regression" }, description = "Verify features in the Overview & Features section with description and links for fsus")
    public void EPIC_03_PDPPage_TC_04_verifyFeaturesSectionOnPDPElx() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        homePage.navigateToHomePage();
        pdpPage.searchProduct("EHVS75S1AO");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        boolean isDescriptionDisplayed = pdpPage.validateFeatureDescription();
        Assert.assertTrue(isDescriptionDisplayed, "Description is not visible for features");

        ExtentReportManager.getTest()
                .pass("Verify features in the Overview & Features section with description and links");
    }

    @Test(groups = {
            "regression" }, description = "Verify View All functionality and Show More button to reveal more banners for fsus")
    public void EPIC_03_PDPPage_TC_05_verifyViewMoreFunctionalityInFeaturesSectionOnPDPElx()
            throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        homePage.navigateToHomePage();
        pdpPage.searchProduct("EHVS75S1AOEHVS75S1AO");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        Assert.assertTrue(pdpPage.validateViewMoreButtonFunctionality(), "View More button is not working");

        ExtentReportManager.getTest().pass("Verify View All functionality and Show More button to reveal more banners");
    }
}
