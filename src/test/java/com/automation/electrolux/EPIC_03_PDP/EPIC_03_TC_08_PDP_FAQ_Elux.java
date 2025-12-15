package com.automation.electrolux.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.electrolux.pages.FAQPageActionsElux;
import com.automation.electrolux.pages.HomePageActionsElux;
import com.automation.electrolux.pages.ProductDetailPageActionsElux;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_08_PDP_FAQ_Elux extends BaseTest {
    HomePageActionsElux homePageActionsElux = new HomePageActionsElux();
    ProductDetailPageActionsElux electroluxProductCards=new ProductDetailPageActionsElux();
    FAQPageActionsElux electroluxFAQ=new FAQPageActionsElux();

    @Test(groups = {"smoke", "regression"}, description = "Verify FAQ Section in the PDP")
    public void testForVacuumsFAQ(){
        homePageActionsElux.navigateToHomePage();
        electroluxProductCards.clickOnProductMenu("Vacuums");
        electroluxProductCards.clickOnProductMenu("Shop All Vacuums");
        Assert.assertTrue(WebElementUtil.isDisplayed(By.xpath("//h1[normalize-space(text())='Vacuums']")),"Vacuums");
        electroluxProductCards.closeEmailPopUp();
        electroluxFAQ.productNameClick("EHVS65S1AO");
        electroluxFAQ.productFAQsSection();
        ExtentReportManager.getTest().pass("Verify FAQ Section in the PDP");
    }
}
