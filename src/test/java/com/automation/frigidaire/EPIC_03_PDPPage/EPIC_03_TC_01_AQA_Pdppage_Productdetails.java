package com.automation.frigidaire.EPIC_03_PDPPage;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.FrigidairePdpPageActions;
import com.automation.frigidaire.pages.PlpPageActions_Frig;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_01_AQA_Pdppage_Productdetails extends BaseTest {

    private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    private final FrigidairePdpPageActions pdpPage = new FrigidairePdpPageActions();
    private final PlpPageActions_Frig plpPage = new PlpPageActions_Frig();


    @Test(groups = {"smoke", "regression"}, description = "Verify product details on PDP page for window mounted AC")
    public void EPIC_03_PDPPage_TC_01_verifyProductDetailsOnPdpPageForWindowMountedAC() {
        homePage.navigateToHomePage();
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


        ExtentReportManager.getTest().pass("Verified visibility of product details on PDP page for window mounted AC");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify product details on PDP page for french door refrigerator")
    public void EPIC_03_PDPPage_TC_01_verifyProductDetailsOnPdpPageForFrenchDoorFridge() {
        homePage.navigateToHomePage();
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


        ExtentReportManager.getTest().pass("Verified visibility of product details on PDP page for french door refrigerator");
    }

}
