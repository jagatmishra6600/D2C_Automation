package com.automation.fsus.EPIC_04_PLP;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.familystoreus.pages.ProductCardsPageActionFsus;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;

public class EPIC_04_TC_03_AQA_PLP_ProductCards extends BaseTest {

    ProductCardsPageActionFsus productCard = new ProductCardsPageActionFsus();
    LoginPageActionsFsus loginPage = new LoginPageActionsFsus();


    @Test(groups = {"smoke", "regression"}, description = "Verify Kitchen Product Details in Product listing page", priority = 1)
    public void EPIC_04_PLP_TC_03_testForKitchen(){
        loginPage.loginWithDefaultCredentials();
        productCard.clickOnProductMenu("Vacuums");
        productCard.clickOnProductSubMenu("Explore Vacuums");
        productCard.verifyProductItemPage("Vacuums", "Vacuums");
        productCard.checkPlpItem("Vacuums", 1);
        ExtentReportManager.getTest().pass("Verify vacuums product details in product listing page and click on image, product name and rating navigate to PDP");
    }

    @Test(groups = {"smoke", "regression"}, description = "Verify Air care Product Details in Product listing page", priority = 2)
    public void EPIC_04_PLP_TC_03_testForAirCare(){
        loginPage.loginWithDefaultCredentials();
        productCard.clickOnProductMenu("Laundry");
        productCard.clickOnProductSubMenu("Electrolux Laundry");
        productCard.verifyProductItemPage("Laundry", "Laundry");
        productCard.checkPlpItem("Laundry", 1);
        ExtentReportManager.getTest().pass("Verify Laundry product details in product listing page and click on image,productName and rating navigate to PDP");
    }
}
