package com.automation.electrolux.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.electrolux.pages.ElectroluxFAQ;
import com.automation.electrolux.pages.ElectroluxHomePageActions;
import com.automation.electrolux.pages.ElectroluxProductCards;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_08_PDP_FAQ extends BaseTest {
    ElectroluxHomePageActions electroluxHomePageActions = new ElectroluxHomePageActions();
    ElectroluxProductCards electroluxProductCards=new ElectroluxProductCards();
    ElectroluxFAQ electroluxFAQ=new ElectroluxFAQ();

    @Test(groups = {"smoke", "regression"}, description = "Verify FAQ Section in the PDP")
    public void testForVacuumsFAQ(){
        electroluxHomePageActions.navigateToHomePage();
        electroluxProductCards.clickOnProductMenu("Vacuums");
        electroluxProductCards.clickOnProductMenu("Shop All Vacuums");
        Assert.assertTrue(WebElementUtil.isDisplayed(By.xpath("//h1[normalize-space(text())='Vacuums']")),"Vacuums");
        electroluxProductCards.closeEmailPopUp();
        electroluxFAQ.productNameClick("EHVS65S1AO");
        electroluxFAQ.productFAQsSection();
        ExtentReportManager.getTest().pass("Verify FAQ Section in the PDP");
    }
}
