package com.automation.frigidaire.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.PdpPageActionsFrig;
import com.automation.frigidaire.pages.PlpPageActionsFrig;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_02_AQA_Pdppage_Product_Specs_Frig extends BaseTest {

    private final HomePageActionsFrig homePage = new HomePageActionsFrig();
    private final PdpPageActionsFrig pdpPage = new PdpPageActionsFrig();
    private final PlpPageActionsFrig plpPage = new PlpPageActionsFrig();
    private String currentUrl;


    @Test(groups = {"smoke", "regression"}, description = "Verify product quick specification on PDP page for window mounted AC")
    public void EPIC_03_PDPPage_TC_02_verifyProductSpecificationOnPdpPageForWindowMountedAC() {
        homePage.navigateToHomePage();
        currentUrl = WebElementUtil.getCurrentUrl();
        if (currentUrl.contains("frigidaire")) {
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
        }

        ExtentReportManager.getTest().pass("Verified quick specification on PDP page for window mounted AC");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify product quick specification on PDP page for french door refrigerator and Washers")
    public void EPIC_03_PDPPage_TC_02_verifyProductSpecificationOnPdpPageForFrenchDoorFridge() {
        homePage.navigateToHomePage();
        currentUrl = WebElementUtil.getCurrentUrl();
        if (currentUrl.contains("frigidaire")) {
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
        }

        ExtentReportManager.getTest().pass("Verified quick specification on PDP page for french door refrigerator");
    }

}
