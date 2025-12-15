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


    @Test(groups = {"smoke", "regression"}, description = "Verify Kitchen Product Details in Product listing page", priority = 1)
    public void EPIC_03_PDP_TC_07_testForVacuumsInStock() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        productCard.clickOnProductMenu("Vacuums");
        productCard.clickOnProductSubMenu("Explore Vacuums");
        productCard.verifyProductItemPage("Vacuums", "Vacuums");
        outOfStockPageActionFsus.selectInStock("Yes");
        outOfStockPageActionFsus.checkInStock();
        ExtentReportManager.getTest().pass("Verify vacuums product details in product listing page and click on image, product name and rating navigate to PDP");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify Air care Product Details in Product listing page", priority = 2)
    public void EPIC_03_PDP_TC_07_testForVacuumsOutStock() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        productCard.clickOnProductMenu("Vacuums");
        productCard.clickOnProductSubMenu("Explore Vacuums");
        productCard.verifyProductItemPage("Vacuums", "Vacuums");
        outOfStockPageActionFsus.selectInStock("No");
        outOfStockPageActionFsus.checkOutStock();
        outOfStockPageActionFsus.checkEmailAddress();
        ExtentReportManager.getTest().pass("Verify Laundry product details in product listing page and click on image,productName and rating navigate to PDP");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify Air care Product Details in Product listing page", priority = 2)
    public void EPIC_03_PDP_TC_07_testForLaundryInStock() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        productCard.clickOnProductMenu("Laundry");
        productCard.clickOnProductMenu("Electrolux Laundry");
        productCard.verifyProductItemPage("Laundry", "Laundry");
        outOfStockPageActionFsus.selectInStock("Yes");
        outOfStockPageActionFsus.checkInStock();
        //productCard.checkPlpItem("Laundry", 1);
        ExtentReportManager.getTest().pass("Verify Laundry product details in product listing page and click on image,productName and rating navigate to PDP");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify Air care Product Details in Product listing page", priority = 2)
    public void EPIC_03_PDP_TC_07_testForLaundryOutStock() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        productCard.clickOnProductMenu("Laundry");
        productCard.clickOnProductMenu("Electrolux Laundry");
        productCard.verifyProductItemPage("Laundry", "Laundry");
        outOfStockPageActionFsus.selectInStock("No");
        outOfStockPageActionFsus.checkInStock();
        //productCard.checkPlpItem("Laundry", 1);
        ExtentReportManager.getTest().pass("Verify Laundry product details in product listing page and click on image,productName and rating navigate to PDP");
    }

}
