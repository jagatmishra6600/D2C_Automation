package com.automation.fsus.EPIC_04_PLP;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.familystoreus.pages.PLPProductItemsPageActionsFsus;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;

public class EPIC_04_TC_02_PLP_Filters_Vacuums_Fsus extends BaseTest {

    LoginPageActionsFsus loginPage= new LoginPageActionsFsus();
    PLPProductItemsPageActionsFsus productCard = new PLPProductItemsPageActionsFsus();

    @Test(groups = {"smoke", "regression"}, description = "verify the PLP filter set for Vacuums")
    public void verifyPLPFilterVacuums() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        productCard.clickOnProductMenu("Laundry");
        productCard.clickOnProductSubMenu("Electrolux Laundry");
        productCard.verifyProductItemPage("Laundry", "Laundry");
        productCard.verifyHideAndShowAllFilters("Hide Filters");
        productCard.verifyHideAndShowAllFilters("Show filtres");
        productCard.verifyHideFilters("Hide Filters");
        ExtentReportManager.getTest().pass("Successfully verify Product menu Shop All Vacuums displayed before clicking.");

    }

}
