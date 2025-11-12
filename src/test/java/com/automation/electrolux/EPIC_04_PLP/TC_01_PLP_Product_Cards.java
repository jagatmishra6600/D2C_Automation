package com.automation.electrolux.EPIC_04_PLP;

import com.automation.electrolux.pages.ElectroluxProductCards;
import com.automation.utils.DriverManager;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;

public class TC_01_PLP_Product_Cards  {

    ElectroluxProductCards electroluxProductCards =new ElectroluxProductCards();

    @Test(groups = {"smoke", "regression"}, description = "Verify Vacuums Product Details in Product listing page")
    public void testForVacuums() throws InterruptedException {
        electroluxProductCards.navigateToHomePage();
        electroluxProductCards.clickOnProductMenu("Vacuums");
        electroluxProductCards.clickOnProductMenu("Shop All Vacuums");
        electroluxProductCards.verifyProductItemPage("Vacuums", "Vacuums");
        electroluxProductCards.closeEmailPopUp();
        electroluxProductCards.checkPlpItem("Vacuums");
        ExtentReportManager.getTest().pass("Verify Vacuums product details in product listing page and click on image/productName navigate to PDP");
        DriverManager.quitDriver();
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify Vacuums Product Details in Product listing page")
    public void testForLaundry() throws InterruptedException {
        electroluxProductCards.navigateToHomePage();
        electroluxProductCards.clickOnProductMenu("Laundry");
        electroluxProductCards.clickOnProductMenu("Washers");
        electroluxProductCards.verifyProductItemPage("Washers", "Washers");
        electroluxProductCards.checkPlpItem("Laundry");
        ExtentReportManager.getTest().pass("Verify Vacuums product details in product listing page and click on image/productName navigate to PDP");
        DriverManager.quitDriver();
    }
}
