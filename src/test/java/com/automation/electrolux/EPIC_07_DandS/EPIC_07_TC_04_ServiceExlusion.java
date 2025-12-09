package com.automation.electrolux.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.electrolux.pages.EL_DSPageServiceExclusion;
import com.automation.electrolux.pages.ElectroluxHomePageActions;
import com.automation.electrolux.pages.ElectroluxProductCards;
import com.automation.utils.DriverManager;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_07_TC_04_ServiceExlusion extends BaseTest{

    EL_DSPageServiceExclusion elDsPageServiceExclusion = new EL_DSPageServiceExclusion();
    ElectroluxProductCards electroluxProductCards =new ElectroluxProductCards();
    ElectroluxHomePageActions electroluxHomePageActions = new ElectroluxHomePageActions();

    public void navigateToDSPageElectrolux() throws InterruptedException {
        electroluxHomePageActions.navigateToHomePage();
        electroluxProductCards.clickOnProductMenu("Laundry");
        electroluxProductCards.clickOnProductMenu("Washers");
        Assert.assertTrue(WebElementUtil.isDisplayed(By.xpath("//h1[normalize-space(text())='Washers']")), "Washers");
        elDsPageServiceExclusion.clickProductBySKU("ELFW7537AW");
    }

    @Test(groups = {"smoke", "regression"}, priority = 1)
    public void  EPIC_04_PLP_TC_03_testForFEDEX() throws InterruptedException {
        navigateToDSPageElectrolux();
        elDsPageServiceExclusion.zipCodeChange("85062");
        elDsPageServiceExclusion.zipCodePop();
        elDsPageServiceExclusion.deliveryOnlyIsAvailable();
        elDsPageServiceExclusion.installationUnavailable();
        ExtentReportManager.getTest().pass("Verified Delivery page after change the zip code for FEDEX/AIT");
        DriverManager.quitDriver();
    }
}
