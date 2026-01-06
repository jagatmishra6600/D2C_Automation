package com.automation.fsus.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.familystoreus.pages.OutOfStockPageActionFsus;
import com.automation.familystoreus.pages.ProductCardsPageActionFsus;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;

public class EPIC_03_TC_07_PDP_Out_Of_Stock extends BaseTest {

    ProductCardsPageActionFsus productCard = new ProductCardsPageActionFsus();
    OutOfStockPageActionFsus outOfStockPageActionFsus = new OutOfStockPageActionFsus();
    LoginPageActionsFsus loginPage = new LoginPageActionsFsus();


    @Test(groups = {"smoke", "regression"}, description = "Verify Vacuums Product In stock or out of stock", priority = 1)
    public void EPIC_03_PDP_TC_07_testForVacuumsInStock(){
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Vacuums");
        productCard.clickOnProductSubMenu("Explore Vacuums");
        productCard.verifyProductItemPage("Vacuums", "Vacuums");
        outOfStockPageActionFsus.selectInStock("Yes", "Vacuums");
        outOfStockPageActionFsus.checkInStock();
        ExtentReportManager.getTest().pass("Verify Vacuums Product In stock or out of stock");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify Vacuums Product In stock or out of stock", priority = 2)
    public void EPIC_03_PDP_TC_07_testForVacuumsOutStock(){
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Vacuums");
        productCard.clickOnProductSubMenu("Explore Vacuums");
        productCard.verifyProductItemPage("Vacuums", "Vacuums");
        outOfStockPageActionFsus.selectInStock("No", "Vacuums");
        outOfStockPageActionFsus.checkOutStock();
        outOfStockPageActionFsus.checkEmailAddress();
        ExtentReportManager.getTest().pass("Verify Vacuums Product In stock or out of stock");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify Laundry Product In stock or out of stock", priority = 3)
    public void EPIC_03_PDP_TC_07_testForLaundryInStock(){
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Laundry");
        productCard.clickOnProductSubMenu("Electrolux Laundry");
        productCard.verifyProductItemPage("Laundry", "Laundry");
        outOfStockPageActionFsus.selectInStock("Yes","Laundry");
        outOfStockPageActionFsus.checkInStock();
        ExtentReportManager.getTest().pass("Verify Laundry Product In stock or out of stock");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify Laundry Product In stock or out of stock", priority = 4)
    public void EPIC_03_PDP_TC_07_testForLaundryOutStock(){
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Laundry");
        productCard.clickOnProductSubMenu("Electrolux Laundry");
        productCard.verifyProductItemPage("Laundry", "Laundry");
        outOfStockPageActionFsus.selectInStock("No","Laundry");
        outOfStockPageActionFsus.checkOutStock();
        ExtentReportManager.getTest().pass("Verify Laundry Product In stock or out of stock");
    }

}
