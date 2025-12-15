package com.automation.electrolux.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.electrolux.pages.HomePageActionsElux;
import com.automation.electrolux.pages.PdpPageActionsElux;
import com.automation.electrolux.pages.PlpPageActionsElux;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_01_AQA_Pdppage_Productdetails_Elux extends BaseTest {

    private final HomePageActionsElux homePage = new HomePageActionsElux();
    private final PdpPageActionsElux pdpPage = new PdpPageActionsElux();
    private final PlpPageActionsElux plpPage = new PlpPageActionsElux();
    private String currentUrl;


    @Test(groups = {"smoke", "regression"}, description = "Verify product details on PDP page for Vacuums")
    public void EPIC_03_PDPPage_TC_01_verifyProductDetailsOnPdpPageForVacuums() {
        homePage.navigateToHomePage();
        homePage.clickVacuums();
        plpPage.closePopupModel();
        plpPage.storeSelectedProductId();
        plpPage.storeSelectedProductTitle();
        plpPage.storeSelectedProductPrice();
        plpPage.clickFirstProduct();

        Assert.assertTrue(pdpPage.isProductIdMatchingWithPLP(), "Product id on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.isProductTitleMatchingWithPLP(), "Product Title on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.isProductPriceMatchingWithPLP(), "Product Price on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.isProductColorVisibleOnPDP(), "Product Color on PDP does not visible.");


        ExtentReportManager.getTest().pass("Verified visibility of product details on PDP page for window mounted AC");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify product details on PDP page for Laundry Washer")
    public void EPIC_03_PDPPage_TC_01_verifyProductDetailsOnPdpPageForLaundryWasher() {
        homePage.navigateToHomePage();
        homePage.clickWasher();
        plpPage.closePopupModel();
        plpPage.storeSelectedProductId();
        plpPage.storeSelectedProductTitle();
        plpPage.storeSelectedProductPrice();
        plpPage.clickFirstProduct();

        Assert.assertTrue(pdpPage.isProductIdMatchingWithPLP(), "Product id on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.isProductTitleMatchingWithPLP(), "Product Title on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.isProductPriceMatchingWithPLP(), "Product Price on PDP does not match the selected product from PLP.");
        Assert.assertTrue(pdpPage.isProductColorVisibleOnPDP(), "Product Color on PDP does not visible.");


        ExtentReportManager.getTest().pass("Verified visibility of product details on PDP page for french door refrigerator");
    }

}
