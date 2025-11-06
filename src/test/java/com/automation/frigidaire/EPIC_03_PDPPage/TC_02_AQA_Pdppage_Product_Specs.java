package com.automation.frigidaire.EPIC_03_PDPPage;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.FrigidairePdpPageActions;
import com.automation.frigidaire.pages.FrigidairePlpPageActions;
import com.automation.frigidaire.utils.ExtentReportManager;
import com.automation.frigidaire.utils.WaitUtils;
import com.automation.frigidaire.utils.WebElementUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02_AQA_Pdppage_Product_Specs extends BaseTest {

    private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    private final FrigidairePdpPageActions pdpPage = new FrigidairePdpPageActions();
    private final FrigidairePlpPageActions plpPage = new FrigidairePlpPageActions();
    private String currentUrl;


    @Test(groups = {"smoke", "regression"}, description = "Verify product quick specification on PDP page for window mounted AC and Vacuums")
    public void EPIC_03_PDPPage_TC_02_verifyProductSpecificationOnPdpPageForWindowMountedACAndVacuums() {
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
        } else if (currentUrl.contains("electrolux")) {
            WaitUtils.untilPageLoadComplete();
            homePage.clickWindowMounted();
            plpPage.closePopupModel();
            plpPage.storeSelectedProductId();
            plpPage.clickFirstProduct();
            pdpPage.clickQuickSpec();

            Assert.assertTrue(pdpPage.isKeySpecificationHeadingVisibleOnPDP(), "Product key specification heading is not visible on PDP page");
            Assert.assertTrue(pdpPage.isHeightVisibleOnPDP(), "Product Height is not visible on PDP page");
            Assert.assertTrue(pdpPage.isWidthVisibleOnPDP(), "Product Width is not visible on PDP page");
            Assert.assertTrue(pdpPage.isDepthisibleOnPDP(), "Product Depth is not visible on PDP page");
            Assert.assertTrue(pdpPage.isAdditionalKeySpecTextVisibleOnPDP(), "Product Additional specification heading is not visible on PDP page");
            Assert.assertTrue(pdpPage.isGeneralSpecTextVisibleOnPDP(), "Product General specification heading is not visible on PDP page");

            pdpPage.clickViewFullSpecButton();
            Assert.assertTrue(pdpPage.isSpecTextVisibleOnPDP(), "Product Specification heading is not visible on PDP page");
            pdpPage.clickCloseSpecModel();
            pdpPage.clickDownloadFullSpec();

            Assert.assertTrue(pdpPage.isFullProductSpecMatchedTheProductId(), "Product id is not matched in Specification file");
        }
        ExtentReportManager.getTest().pass("Verified quick specification on PDP page for window mounted AC and Vacuums");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify product quick specification on PDP page for french door refrigerator and Washers")
    public void EPIC_03_PDPPage_TC_02_verifyProductSpecificationOnPdpPageForFrenchDoorFridgeAndWashers() {
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
        } else if (currentUrl.contains("electrolux")) {
            WaitUtils.untilPageLoadComplete();
            homePage.clickFrenchDoor();
            plpPage.closePopupModel();
            plpPage.storeSelectedProductId();
            plpPage.clickFirstProduct();
            pdpPage.clickQuickSpec();

            Assert.assertTrue(pdpPage.isKeySpecificationHeadingVisibleOnPDP(), "Product key specification heading is not visible on PDP page");
            Assert.assertTrue(pdpPage.isHeightVisibleOnPDP(), "Product Height is not visible on PDP page");
            Assert.assertTrue(pdpPage.isWidthVisibleOnPDP(), "Product Width is not visible on PDP page");
            Assert.assertTrue(pdpPage.isDepthisibleOnPDP(), "Product Depth is not visible on PDP page");
            Assert.assertTrue(pdpPage.isAdditionalKeySpecTextVisibleOnPDP(), "Product Additional specification heading is not visible on PDP page");
            Assert.assertTrue(pdpPage.isGeneralSpecTextVisibleOnPDP(), "Product General specification heading is not visible on PDP page");

            pdpPage.clickViewFullSpecButton();
            Assert.assertTrue(pdpPage.isSpecTextVisibleOnPDP(), "Product Specification heading is not visible on PDP page");
            pdpPage.clickCloseSpecModel();
            pdpPage.clickDownloadFullSpec();

            Assert.assertTrue(pdpPage.isFullProductSpecMatchedTheProductId(), "Product id is not matched in Specification file");
        }
        ExtentReportManager.getTest().pass("Verified quick specification on PDP page for french door refrigerator and Washers");
    }

}
