package com.automation.frigidaire.EPIC_03_PDPPage;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.FrigidairePlpPageActions;
import com.automation.BaseTest;
import com.automation.frigidaire.pages.FeaturesPageActions;
import com.automation.frigidaire.utils.ExtentReportManager;
import com.automation.frigidaire.utils.WebElementUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_04_AQA_PDP_Features extends BaseTest {
    private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    private final FeaturesPageActions pdpPage = new FeaturesPageActions();
    private final FrigidairePlpPageActions plpPage = new FrigidairePlpPageActions();
    String currentUrl;


    @Test(groups = {"regression"}, description = "Verify features in the Overview & Features section with description and links")
    public void EPIC_03_PDPPage_TC_04_verifyFeaturesSectionOnPDP() {
        homePage.navigateToHomePage();
        currentUrl = WebElementUtil.getCurrentUrl();
        if (currentUrl.contains("frigidaire")) {
            pdpPage.searchProduct("GRMC2273CF-C1");
            pdpPage.selectProductFromPLP();
            plpPage.closePopupModel();
            Assert.assertTrue(pdpPage.validateFeatureTitle(), "Feature Section is not visible");
            pdpPage.verifyFeatureNavigation();
            boolean isDescriptionDisplayed = pdpPage.validateFeatureDescription();
            Assert.assertTrue(isDescriptionDisplayed, "Description is not visible for features");
        } else if (currentUrl.contains("electrolux")) {
            pdpPage.searchProduct("EHVS2510AW-C1");
            pdpPage.selectProductFromPLP();
            plpPage.closePopupModel();
            boolean isDescriptionDisplayed = pdpPage.validateFeatureDescription();
            Assert.assertTrue(isDescriptionDisplayed, "Description is not visible for features");
        }

        ExtentReportManager.getTest().pass("Verify features in the Overview & Features section with description and links");
    }

    @Test(groups = {"regression"}, description = "Verify View All functionality and Show More button to reveal more banners")
    public void EPIC_03_PDPPage_TC_05_verifyViewMoreFunctionalityInFeaturesSectionOnPDP() {
        homePage.navigateToHomePage();
        currentUrl = WebElementUtil.getCurrentUrl();
        if (currentUrl.contains("frigidaire")) {
            pdpPage.searchProduct("GRMC2273CF-C1");
            pdpPage.selectProductFromPLP();
            plpPage.closePopupModel();
            Assert.assertTrue(pdpPage.validateFeatureBanner(), "Feature Banner is not showing");
            Assert.assertTrue(pdpPage.validateViewMoreButtonFunctionality(), "View MFore button is not working");
        } else if (currentUrl.contains("electrolux")) {
            pdpPage.searchProduct("EHVS2510AW-C1");
            pdpPage.selectProductFromPLP();
            plpPage.closePopupModel();
            Assert.assertTrue(pdpPage.validateViewMoreButtonFunctionality(), "View More button is not working");
        }

        ExtentReportManager.getTest().pass("Verify View All functionality and Show More button to reveal more banners");
    }
}
