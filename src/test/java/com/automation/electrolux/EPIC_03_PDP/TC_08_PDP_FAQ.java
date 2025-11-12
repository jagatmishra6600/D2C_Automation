package com.automation.electrolux.EPIC_03_PDP;

import com.automation.electrolux.pages.ElectroluxFAQ;
import com.automation.electrolux.pages.ElectroluxProductCards;
<<<<<<< HEAD
import com.automation.utils.DriverManager;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WebElementUtil;
=======
import com.automation.electrolux.utils.DriverManager;
import com.automation.frigidaire.utils.ExtentReportManager;
import com.automation.frigidaire.utils.WebElementUtil;
>>>>>>> c6eb8d75fde6b68139cd97bec28b88f0b427ba85
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_08_PDP_FAQ  {
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
