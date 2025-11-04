package com.automation.electrolux.tests.EPIC_03_PDP;

import com.automation.electrolux.pages.ElectroluxFAQ;
import com.automation.electrolux.pages.ElectroluxProductCards;
import com.automation.electrolux.utils.DriverManager;
import com.automation.frigidaire.tests.BaseTest;
import com.automation.frigidaire.utils.ExtentReportManager;
import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_08_PDP_FAQ extends BaseTest {
    ElectroluxProductCards electroluxProductCards=new ElectroluxProductCards();
    ElectroluxFAQ electroluxFAQ=new ElectroluxFAQ();

    @Test(groups = {"smoke", "regression"}, description = "Verify FAQ Section in the PDP")
    public void testForVacuumsFAQ(){
        electroluxProductCards.navigateToHomePage();
        electroluxProductCards.clickOnProductMenu("Vacuums");
        electroluxProductCards.clickOnProductMenu("Shop All Vacuums");
        Assert.assertTrue(WebElementUtil.isDisplayed(By.xpath("//h1[normalize-space(text())='Vacuums']")),"Vacuums");
        electroluxProductCards.closeEmailPopUp();
        electroluxFAQ.productNameClick("Ergorapido™ Vacuum with Free Replacement Filters");
        electroluxFAQ.productFAQsSection();
        ExtentReportManager.getTest().pass("Verify FAQ Section in the PDP");
        DriverManager.quitDriver();
    }
}
