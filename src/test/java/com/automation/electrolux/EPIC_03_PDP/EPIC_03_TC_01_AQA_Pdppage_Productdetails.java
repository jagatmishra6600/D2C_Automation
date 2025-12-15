package com.automation.electrolux.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.electrolux.pages.ElectroluxHomePageActions;
import com.automation.electrolux.pages.ElectroluxPdpPageActions;
import com.automation.electrolux.pages.ElectroluxPlpPageActions;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_01_AQA_Pdppage_Productdetails extends BaseTest {

    private final ElectroluxHomePageActions homePage = new ElectroluxHomePageActions();
    private final ElectroluxPdpPageActions pdpPage = new ElectroluxPdpPageActions();
    private final ElectroluxPlpPageActions plpPage = new ElectroluxPlpPageActions();


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
