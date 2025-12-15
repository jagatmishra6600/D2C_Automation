package com.automation.fsus.EPIC_03_PDPPage;

import com.automation.BaseTest;
import com.automation.electrolux.pages.ElectroluxHomePageActions;
import com.automation.electrolux.pages.ElectroluxPdpPageActions;
import com.automation.electrolux.pages.ElectroluxPlpPageActions;
import com.automation.familystoreus.pages.HomePageActionsFsus;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.familystoreus.pages.PdpPageActions_FSUS;
import com.automation.familystoreus.pages.PlpPageActions_FSUS;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_18_AQA_Pdppage_Product_Specs extends BaseTest {

    private final HomePageActionsFsus homePage = new HomePageActionsFsus();
    private final PdpPageActions_FSUS pdpPage = new PdpPageActions_FSUS();
    private final PlpPageActions_FSUS plpPage = new PlpPageActions_FSUS();
    LoginPageActionsFsus loginPage = new LoginPageActionsFsus();


    @Test(groups = {"smoke", "regression"}, description = "Verify product quick specification on PDP page for Vacuums")
    public void EPIC_03_PDPPage_TC_18_verifyProductSpecificationOnPdpPageForVacuums() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();

        homePage.clickVacuums();
        plpPage.closePopupModel();
        plpPage.storeSelectedProductId();
        plpPage.clickFirstProduct();
        pdpPage.clickSpec();

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

        ExtentReportManager.getTest().pass("Verified quick specification on PDP page for Vacuums");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify product quick specification on PDP page for french door refrigerator and Washers")
    public void EPIC_03_PDPPage_TC_18_verifyProductSpecificationOnPdpPageForWashers() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        homePage.clickWasher();
        plpPage.closePopupModel();
        plpPage.storeSelectedProductId();
        plpPage.clickFirstProduct();
        pdpPage.clickSpec();

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

        ExtentReportManager.getTest().pass("Verified quick specification on PDP page for Washers");
    }

}
