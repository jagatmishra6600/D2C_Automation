package com.automation.frigidaire.EPIC_03_PDPPage;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.FrigidairePdpPageActions;
import com.automation.frigidaire.pages.PlpPageActions_Frig;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_02_AQA_Pdppage_Product_Specs extends BaseTest {

    private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    private final FrigidairePdpPageActions pdpPage = new FrigidairePdpPageActions();
    private final PlpPageActions_Frig plpPage = new PlpPageActions_Frig();


    @Test(groups = {"smoke", "regression"}, description = "Verify product quick specification on PDP page for window mounted AC")
    public void EPIC_03_PDPPage_TC_02_verifyProductSpecificationOnPdpPageForWindowMountedAC() {
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

    @Test(groups = {"smoke", "regression"}, description = "Verify product quick specification on PDP page for french door refrigerator and Washers")
    public void EPIC_03_PDPPage_TC_02_verifyProductSpecificationOnPdpPageForFrenchDoorFridge() {
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
