package com.automation.fsus.EPIC_03_PDPPage;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.HomePageActionsFsus;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.familystoreus.pages.PdpPageActions_FSUS;
import com.automation.familystoreus.pages.PlpPageActions_FSUS;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WebElementUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_17_AQA_Pdppage_Productdetails extends BaseTest {

    private final HomePageActionsFsus homePage = new HomePageActionsFsus();
    private final PdpPageActions_FSUS pdpPage = new PdpPageActions_FSUS();
    private final PlpPageActions_FSUS plpPage = new PlpPageActions_FSUS();
    LoginPageActionsFsus loginPage = new LoginPageActionsFsus();
    private String currentUrl;


    @Test(groups = {"smoke", "regression"}, description = "Verify product details on PDP page for Vacuums")
    public void EPIC_03_PDPPage_TC_17_verifyProductDetailsOnPdpPageForVacuums() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        homePage.clickVacuums();
        plpPage.closePopupModel();
        plpPage.storeSelectedProductId();
        plpPage.storeSelectedProductTitle();
        plpPage.storeSelectedProductPrice();
        plpPage.storeProductDimensions();
        plpPage.clickFirstProduct();

        Assert.assertTrue(pdpPage.isProductIdMatchingWithPLP(), "Product id on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.isProductTitleMatchingWithPLP(), "Product Title on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.isProductPriceMatchingWithPLP(), "Product Price on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.isProductColorVisibleOnPDP(), "Product Color on PDP does not visible.");
        Assert.assertTrue(pdpPage.isHeightMatchingWithPLP(), "Product Height on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.iswidthMatchingWithPLP(), "Product Width on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.isDepthMatchingWithPLP(), "Product Depth on PDP does not match the selected product from PLP.");


        ExtentReportManager.getTest().pass("Verified visibility of product details on PDP page for window mounted AC");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify product details on PDP page for Laundry Washer")
    public void EPIC_03_PDPPage_TC_17_verifyProductDetailsOnPdpPageForLaundryWasher() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        homePage.clickWasher();
        plpPage.closePopupModel();
        plpPage.storeSelectedProductId();
        plpPage.storeSelectedProductTitle();
        plpPage.storeSelectedProductPrice();
        plpPage.storeProductDimensions();
        plpPage.clickFirstProduct();

        Assert.assertTrue(pdpPage.isProductIdMatchingWithPLP(), "Product id on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.isProductTitleMatchingWithPLP(), "Product Title on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.isProductPriceMatchingWithPLP(), "Product Price on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.isProductColorVisibleOnPDP(), "Product Color on PDP does not visible.");
        Assert.assertTrue(pdpPage.isHeightMatchingWithPLP(), "Product Height on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.iswidthMatchingWithPLP(), "Product Width on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.isDepthMatchingWithPLP(), "Product Depth on PDP does not match the selected product from PLP.");


        ExtentReportManager.getTest().pass("Verified visibility of product details on PDP page for laundry washer");
    }

}
