package com.automation.frigidaire.EPIC_03_PDPPage;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.OutOfStockPageActionFrig;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EPIC_03_TC_07_PDP_Out_Of_Stock extends BaseTest {

    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    OutOfStockPageActionFrig productItems = new OutOfStockPageActionFrig();

    public void navigateToProduct() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        productItems.clickOnProductMenu("Air Care");
        productItems.clickOnProductMenu("Window Mounted AC");
        Assert.assertTrue(WebElementUtil.isDisplayed(By.xpath("//h1[normalize-space(text())='Window Mounted Air Conditioners']")), "Window Mounted Air Conditioners");
        productItems.closeEmailPopUp();
    }

    @DataProvider(name = "productStockDP")
    public Object[][] productStockDP() {
        return new Object[][]{
                {"FHWW085WE1"},
                {"FHWC064TE1"}
        };
    }

    @Test(groups = {"regression", "smoke"}, dataProvider = "productStockDP")
    public void verifyProductStockStatus(String productCode) throws InterruptedException {
        navigateToProduct();
        productItems.clickOnProductName(productCode);
        productItems.checkStock();
        ExtentReportManager.getTest().pass(
                "Verified stock availability for product: " + productCode
        );
    }

}
