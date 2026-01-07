package com.automation.fsus.EPIC_04_PLP;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.familystoreus.pages.PLPProductItemsPageActionsFsus;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;

public class EPIC_04_TC_03_PLP_SortBy_Vacuums_Fsus extends BaseTest {

    LoginPageActionsFsus loginPage= new LoginPageActionsFsus();
    PLPProductItemsPageActionsFsus productCard = new PLPProductItemsPageActionsFsus();

    @Test(groups = {"smoke", "regression"}, description = "verify the products by Price Low to High")
    public void verifyPLPSortByLowToHigh() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Laundry");
        productCard.clickOnProductSubMenu("Electrolux Laundry");
        productCard.verifyProductItemPage("Laundry", "Laundry");
        productCard.clickOnSortByDropDownvalues("Price (low to high)", "Price (low to high)");
        productCard.verifyPriceLowToHighSort();
        ExtentReportManager.getTest().pass("Successfully sort products by Price Low to High");
    }

    @Test(groups = {"smoke", "regression"}, description = "verify the products by Price High to Low")
    public void verifyPLPSortByHighToLow() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Laundry");
        productCard.clickOnProductSubMenu("Electrolux Laundry");
        productCard.verifyProductItemPage("Laundry", "Laundry");
        productCard.clickOnSortByDropDownvalues("Price (high to low)", "Price (high to low)");
        productCard.verifyPriceHighToLowSort();
        ExtentReportManager.getTest().pass("Successfully sort products by Price High to Low");
    }

    @Test(groups = {"smoke", "regression"}, description = "verify the products by Biggest Savings")
    public void verifyPLPSortByBiggestSavings() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Laundry");
        productCard.clickOnProductSubMenu("Electrolux Laundry");
        productCard.verifyProductItemPage("Laundry", "Laundry");
        productCard.clickOnSortByDropDownvalues("Biggest Savings", "Biggest Savings");
        productCard.verifyBiggestSavingsSort();
        ExtentReportManager.getTest().pass("Successfully sort products by Biggest Savings");
    }


}

