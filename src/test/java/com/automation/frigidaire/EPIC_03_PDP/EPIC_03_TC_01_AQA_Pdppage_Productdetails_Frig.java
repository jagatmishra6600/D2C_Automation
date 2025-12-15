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

public class EPIC_03_TC_01_AQA_Pdppage_Productdetails_Frig extends BaseTest {

    private final HomePageActionsFrig homePage = new HomePageActionsFrig();
    private final PdpPageActionsFrig pdpPage = new PdpPageActionsFrig();
    private final PlpPageActionsFrig plpPage = new PlpPageActionsFrig();
    private String currentUrl;


    @Test(groups = {"smoke", "regression"}, description = "Verify product details on PDP page for window mounted AC")
    public void EPIC_03_PDPPage_TC_01_verifyProductDetailsOnPdpPageForWindowMountedAC() {
        homePage.navigateToHomePage();
        currentUrl = WebElementUtil.getCurrentUrl();
        if (currentUrl.contains("frigidaire")) {
            WaitUtils.untilPageLoadComplete();
            homePage.clickWindowMounted();
            plpPage.closePopupModel();
            plpPage.storeSelectedProductId();
            plpPage.storeSelectedProductTitle();
            plpPage.storeSelectedProductPrice();
            plpPage.storeSelectedProductReviewNumber();
            plpPage.clickFirstProduct();
            Assert.assertTrue(pdpPage.isProductIdMatchingWithPLP(), "Product id on PDP does not match the selected product from PLP.");
            Assert.assertTrue(pdpPage.isProductTitleMatchingWithPLP(), "Product Title on PDP does not match the selected product from PLP.");
            Assert.assertTrue(pdpPage.isProductPriceMatchingWithPLP(), "Product Price on PDP does not match the selected product from PLP.");
            Assert.assertTrue(pdpPage.isProductReviewMatchingWithPLP(), "Product Review Number on PDP does not match the selected product from PLP.");
            Assert.assertTrue(pdpPage.isProductColorVisibleOnPDP(), "Product Color on PDP does not visible.");
        }

        ExtentReportManager.getTest().pass("Verified visibility of product details on PDP page for window mounted AC");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify product details on PDP page for french door refrigerator")
    public void EPIC_03_PDPPage_TC_01_verifyProductDetailsOnPdpPageForFrenchDoorFridge() {
        homePage.navigateToHomePage();
        currentUrl = WebElementUtil.getCurrentUrl();
        if (currentUrl.contains("frigidaire")) {
            WaitUtils.untilPageLoadComplete();
            homePage.clickFrenchDoor();
            plpPage.closePopupModel();
            plpPage.storeSelectedProductId();
            plpPage.storeSelectedProductTitle();
            plpPage.storeSelectedProductPrice();
            plpPage.storeSelectedProductReviewNumber();
            plpPage.clickFirstProduct();

            Assert.assertTrue(pdpPage.isProductIdMatchingWithPLP(), "Product id on PDP does not match the selected product from PLP.");
            Assert.assertTrue(pdpPage.isProductTitleMatchingWithPLP(), "Product Title on PDP does not match the selected product from PLP.");
            Assert.assertTrue(pdpPage.isProductPriceMatchingWithPLP(), "Product Price on PDP does not match the selected product from PLP.");
            Assert.assertTrue(pdpPage.isProductReviewMatchingWithPLP(), "Product Review Number on PDP does not match the selected product from PLP.");
            Assert.assertTrue(pdpPage.isProductColorVisibleOnPDP(), "Product Color on PDP does not visible.");
        }

        ExtentReportManager.getTest().pass("Verified visibility of product details on PDP page for french door refrigerator");
    }

}
