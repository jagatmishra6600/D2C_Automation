package com.automation.fsus.EPIC_04_PLP;

import com.automation.electrolux.pages.HomePageActions;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.familystoreus.pages.PlpProductItemPageActions_Fsus;
import com.automation.familystoreus.pages.ProductCategoryPageActions_Fsus;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WebElementUtil;
import org.testng.annotations.Test;

public class EPIC_04_TC_04_Vacuums_Filter_Fsus {
    HomePageActions homePage = new HomePageActions();
    PlpProductItemPageActions_Fsus plpProductItemPageActionsFsus = new PlpProductItemPageActions_Fsus();
    ProductCategoryPageActions_Fsus productCategoryPageActionsFsus = new ProductCategoryPageActions_Fsus();
    LoginPageActionsFsus loginPage = new LoginPageActionsFsus();

    public void navigateToVacuumsProducts( String prodCategory , String subProdCategory ){
        loginPage.loginWithDefaultCredentials();
       // homePage.navigateToHomePage();
        productCategoryPageActionsFsus.clickOnProductMenu(prodCategory);
        productCategoryPageActionsFsus.clickOnProductMenu(subProdCategory);
        WebElementUtil.zoomInOrOut(25);
        plpProductItemPageActionsFsus.verifyProductItemPage("Vacuums");
    }


    @Test(groups = {"smoke", "regression"}, description = "Product menu Shop All Vacuums displayed before clicking.")
    public void testHideShowFilters() throws InterruptedException {
        navigateToVacuumsProducts("Vacuums","Shop All Vacuums");
        // PLPProductItemsPageActions.verifyFiltersInProductItems("Availability", 60, "Availability");
        plpProductItemPageActionsFsus.verifyHideAndShowAllFilters("Hide filters");
        plpProductItemPageActionsFsus.verifyHideAndShowAllFilters("Show filters");
        plpProductItemPageActionsFsus.verifyHideFilters("Hide filters");
        ExtentReportManager.getTest().pass("Successfully verify Product menu Shop All Vacuums displayed before clicking.");
    }


}
