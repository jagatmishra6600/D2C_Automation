package com.automation.frigidaire.tests.EPIC_03_PDPPage;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.FrigidairePdpPageActions;
import com.automation.frigidaire.pages.FrigidairePlpPageActions;
import com.automation.frigidaire.tests.BaseTest;
import com.automation.frigidaire.utils.ExtentReportManager;
import com.automation.frigidaire.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02_AQA_Pdppage_Product_Specs extends BaseTest {

    private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    private final FrigidairePdpPageActions pdpPage = new FrigidairePdpPageActions();
    private final FrigidairePlpPageActions plpPage = new FrigidairePlpPageActions();


    @Test(groups = {"smoke", "regression"}, description = "Verify product quick specification on PDP page for window mounted AC")
    public void verifyProductDetailsOnPdpPageForWindowMountedAC() {
        homePage.navigateToHomePage();
        WaitUtils.untilPageLoadComplete();
        homePage.clickWindowMounted();
        plpPage.closePopupModel();
        plpPage.storeProductDimensions();
        plpPage.clickFirstProduct();
        pdpPage.clickQuickSpec();
        Assert.assertTrue(pdpPage.isHeightMatchingWithPLP(), "Product height on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.iswidthMatchingWithPLP(), "Product width on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.isDepthMatchingWithPLP(), "Product depth on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.isSeeAllVisibleInQuickSpec(), "See all does not visible under Quick Specs");

        ExtentReportManager.getTest().pass("Verified quick specification on PDP page for window mounted AC");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify product quick specification on PDP page for french door refrigerator")
    public void verifyProductDetailsOnPdpPageForFrenchDoorFridge() {
        homePage.navigateToHomePage();
        WaitUtils.untilPageLoadComplete();
        homePage.clickFrenchDoor();
        plpPage.closePopupModel();
        plpPage.storeProductDimensions();
        plpPage.clickFirstProduct();
        pdpPage.clickQuickSpec();
        Assert.assertTrue(pdpPage.isHeightMatchingWithPLP(), "Product height on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.iswidthMatchingWithPLP(), "Product width on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.isDepthMatchingWithPLP(), "Product depth on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.isSeeAllVisibleInQuickSpec(), "See all does not visible under Quick Specs");

        ExtentReportManager.getTest().pass("Verified quick specification on PDP page for french door refrigerator");
    }

}
