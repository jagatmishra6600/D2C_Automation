package com.automation.electrolux.EPIC_04_PLP;

import com.automation.BaseTest;
import com.automation.electrolux.pages.ElectroluxProductCards;
import com.automation.utils.ExtentReportManager;

import org.testng.annotations.Test;

public class EPIC_04_TC_01_PLP_Product_Cards extends BaseTest {

    ElectroluxProductCards electroluxProductCards =new ElectroluxProductCards();

    @Test(groups = {"smoke", "regression"}, description = "Verify Vacuums Product Details in Product listing page")
    public void testForVacuums() throws InterruptedException {
        electroluxProductCards.navigateToHomePage();
        electroluxProductCards.clickOnProductMenu("Vacuums");
        electroluxProductCards.clickOnProductMenu("Shop All Vacuums");
        electroluxProductCards.verifyProductItemPage("Vacuums", "Vacuums");
        electroluxProductCards.closeEmailPopUp();
        electroluxProductCards.checkPlpItem("Vacuums", 1);
        ExtentReportManager.getTest().pass("Verify Vacuums product details in product listing page and click on image, product name and rating navigate to PDP");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify Vacuums Product Details in Product listing page")
    public void testForLaundry() throws InterruptedException {
        electroluxProductCards.navigateToHomePage();
        electroluxProductCards.clickOnProductMenu("Laundry");
        electroluxProductCards.clickOnProductMenu("Washers");
        electroluxProductCards.verifyProductItemPage("Washers", "Washers");
        electroluxProductCards.checkPlpItem("Laundry", 2);
        ExtentReportManager.getTest().pass("Verify Vacuums product details in product listing page and click on image, product name and rating navigate to PDP");
    }
}
