package com.automation.electrolux.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.electrolux.pages.ElectroluxHomePageActions;
import com.automation.electrolux.pages.ElectroluxPdpPageActions;
import com.automation.electrolux.pages.ElectroluxPlpPageActions;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_02_AQA_Pdppage_Product_Specs extends BaseTest {

    private final ElectroluxHomePageActions homePage = new ElectroluxHomePageActions();
    private final ElectroluxPdpPageActions pdpPage = new ElectroluxPdpPageActions();
    private final ElectroluxPlpPageActions plpPage = new ElectroluxPlpPageActions();


    @Test(groups = {"smoke", "regression"}, description = "Verify product quick specification on PDP page for window mounted AC and Vacuums")
    public void EPIC_03_PDPPage_TC_02_verifyProductSpecificationOnPdpPageForWindowMountedACAndVacuums() {
        homePage.navigateToHomePage();
        WaitUtils.untilPageLoadComplete();
        homePage.clickVacuums();
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

        ExtentReportManager.getTest().pass("Verified quick specification on PDP page for window mounted AC and Vacuums");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify product quick specification on PDP page for french door refrigerator and Washers")
    public void EPIC_03_PDPPage_TC_02_verifyProductSpecificationOnPdpPageForFrenchDoorFridgeAndWashers() {
        homePage.navigateToHomePage();
        WaitUtils.untilPageLoadComplete();
        homePage.clickWasher();
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

        ExtentReportManager.getTest().pass("Verified quick specification on PDP page for french door refrigerator and Washers");
    }

}
