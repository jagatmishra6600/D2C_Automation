package com.automation.frigidaire.tests.EPIC_03_PDPPage;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.FrigidairePdpPageActions;
import com.automation.frigidaire.pages.FrigidairePlpPageActions;
import com.automation.frigidaire.tests.BaseTest;
import com.automation.frigidaire.utils.ExtentReportManager;
import com.automation.frigidaire.utils.WaitUtils;
import com.automation.frigidaire.utils.WebElementUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01_AQA_Pdppage_Productdetails extends BaseTest {

    private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    private final FrigidairePdpPageActions pdpPage = new FrigidairePdpPageActions();
    private final FrigidairePlpPageActions plpPage = new FrigidairePlpPageActions();
    private String currentUrl;


    @Test(groups = {"smoke", "regression"}, description = "Verify product details on PDP page for window mounted AC and Vacuums")
    public void verifyProductDetailsOnPdpPageForWindowMountedAC() {
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
        else if (currentUrl.contains("electrolux")){
            homePage.clickWindowMounted();
            plpPage.closePopupModel();
            plpPage.storeSelectedProductId();
            plpPage.storeSelectedProductTitle();
            plpPage.storeSelectedProductPrice();
            plpPage.clickFirstProduct();

            Assert.assertTrue(pdpPage.isProductIdMatchingWithPLP(), "Product id on PDP does not match the selected product from PLP.");
            Assert.assertTrue(pdpPage.isProductTitleMatchingWithPLP(), "Product Title on PDP does not match the selected product from PLP.");
            Assert.assertTrue(pdpPage.isProductPriceMatchingWithPLP(), "Product Price on PDP does not match the selected product from PLP.");
            Assert.assertTrue(pdpPage.isProductColorVisibleOnPDP(), "Product Color on PDP does not visible.");
        }

        ExtentReportManager.getTest().pass("Verified visibility of product details on PDP page for window mounted AC");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify product details on PDP page for french door refrigerator")
    public void verifyProductDetailsOnPdpPageForFrenchDoorFridge() {
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
        else if (currentUrl.contains("electrolux")){
            homePage.clickFrenchDoor();
            plpPage.closePopupModel();
            plpPage.storeSelectedProductId();
            plpPage.storeSelectedProductTitle();
            plpPage.storeSelectedProductPrice();
            plpPage.clickFirstProduct();

            Assert.assertTrue(pdpPage.isProductIdMatchingWithPLP(), "Product id on PDP does not match the selected product from PLP.");
            Assert.assertTrue(pdpPage.isProductTitleMatchingWithPLP(), "Product Title on PDP does not match the selected product from PLP.");
            Assert.assertTrue(pdpPage.isProductPriceMatchingWithPLP(), "Product Price on PDP does not match the selected product from PLP.");
            Assert.assertTrue(pdpPage.isProductColorVisibleOnPDP(), "Product Color on PDP does not visible.");
        }

        ExtentReportManager.getTest().pass("Verified visibility of product details on PDP page for french door refrigerator");
    }

}
