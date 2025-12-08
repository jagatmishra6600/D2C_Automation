package com.automation.electrolux.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.electrolux.pages.ElectroluxOutOfStock;
import com.automation.electrolux.pages.ElectroluxProductCards;
import com.automation.utils.DriverManager;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_07_PDP_Stock extends BaseTest {
    ElectroluxProductCards electroluxProductCards = new ElectroluxProductCards();
    ElectroluxOutOfStock electroluxOutOfStock = new ElectroluxOutOfStock();

    @Test(groups = {"smoke", "regression"}, description = "Verify Vacuums Product Details in Product listing page and validation for stock")
    public void testForVacuumsForStock() throws InterruptedException {
        electroluxProductCards.navigateToHomePage();
        electroluxOutOfStock.clickOnProductMenu("Vacuums");
        electroluxOutOfStock.clickOnProductMenu("Shop All Vacuums");
        Assert.assertTrue(WebElementUtil.isDisplayed(By.xpath("//h1[normalize-space(text())='Vacuums']")),"Vaccums");
        electroluxOutOfStock.closeEmailPopUp();
        electroluxOutOfStock.checkPlpItem("Vacuums","EHVS65S1AO");
        ExtentReportManager.getTest().pass("Verify Vacuums Product Details in Product listing page and validation for stock");
        DriverManager.quitDriver();
    }

    @Test(groups = {"smoke", "regression"},description = "Verify Laundry Product Details in Product listing page and validation for stock")
    public void testForLaundryForStock() throws InterruptedException {
        electroluxProductCards.navigateToHomePage();
        electroluxOutOfStock.clickOnProductMenu("Laundry");
        electroluxOutOfStock.clickOnProductMenu("Washers");
        Assert.assertTrue(WebElementUtil.isDisplayed(By.xpath("//h1[normalize-space(text())='Washers']")),"Washers");
        electroluxOutOfStock.checkPlpItem("Laundry", "ELFW7437AG");
        ExtentReportManager.getTest().pass("Verify Laundry Product Details in Product listing page and validation for stock");
        DriverManager.quitDriver();
    }

    @Test(groups = {"smoke", "regression"},description = "Verify Laundry Product Details in Product listing page and validation for stock")
    public void testForLaundryTemporarily() throws InterruptedException {
        electroluxProductCards.navigateToHomePage();
        electroluxOutOfStock.clickOnProductMenu("Laundry");
        electroluxOutOfStock.clickOnProductMenu("Washers");
        Assert.assertTrue(WebElementUtil.isDisplayed(By.xpath("//h1[normalize-space(text())='Washers']")),"Washers");
        electroluxOutOfStock.checkPlpItem("Laundry", "ELFW7537AW");
        ExtentReportManager.getTest().pass("Verify Laundry Product Details in Product listing page and validation for stock");
        DriverManager.quitDriver();
    }
}
