package com.automation.fsus.EPIC_07_DandS;

import com.automation.familystoreus.pages.DeliveryInstallationPageActions_Fsus;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;

public class EPIC_07_TC_01_DandS_Fsus {

    LoginPageActionsFsus loginPage = new LoginPageActionsFsus();
    DeliveryInstallationPageActions_Fsus DIPage = new DeliveryInstallationPageActions_Fsus();


    @Test(groups = {"smoke", "regression"}, description = "To verify Included Parts section within Delivery & installation section")
    public void EPIC_05_DandS_TC_01_test_Included_Parts_Section_Within_Delivery_Installation_Section() throws InterruptedException {

        loginPage.loginWithDefaultCredentials();
        DIPage.searchProduct("FRFG1723AV");
        DIPage.clickProduct();


//        navigateToVacuumsProducts("electrolux", "Laundry", "Washers");
//        DeliveryInstallationPageActions.selectProductAndAddToCart(3);
//        DeliveryInstallationPageActions.verifyHeadingAndSubLinksinDAndSPage("Professional Installation");
//        DeliveryInstallationPageActions.verifyPopupTextIsVisible();
//        DeliveryInstallationPageActions.verifyProtectionPlanSection("electrolux");
//        DeliveryInstallationPageActions.isDeclineProtectionVisible();
//        DeliveryInstallationPageActions.validateProtectionPlanPrice("electrolux","1 year");
//        DeliveryInstallationPageActions.validateProtectionPlanPrice("electrolux","3 years");
//        DeliveryInstallationPageActions.validateProtectionPlanPrice("electrolux","5 years");
//        ExtentReportManager.getTest().pass("Successfully verify the D and S page in Electrolux");

    }
}
