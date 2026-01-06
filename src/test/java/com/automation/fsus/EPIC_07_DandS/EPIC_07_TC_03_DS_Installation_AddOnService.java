package com.automation.fsus.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.FedexServiceExclusionPageActionFsus;
import com.automation.familystoreus.pages.InstallationAddOnServicePageActionFsus;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;

public class EPIC_07_TC_03_DS_Installation_AddOnService extends BaseTest {

    FedexServiceExclusionPageActionFsus fedexService = new FedexServiceExclusionPageActionFsus();
    InstallationAddOnServicePageActionFsus addOnService = new InstallationAddOnServicePageActionFsus();
    LoginPageActionsFsus loginPage = new LoginPageActionsFsus();

    @Test(groups = {"smoke", "regression"}, description = "Verify Delivery and installation page", priority = 2)
    public void EPIC_04_PLP_TC_03_testForAddOnService() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        fedexService.searchProduct("FRFG1723AV");
        fedexService.clickProduct();
        addOnService.verifyDeliveryOnlyElements();
        fedexService.checkDeliveryOptions();
        addOnService.verifyAddOnService();
        addOnService.selectHaul();
        addOnService.selectMove();
        ExtentReportManager.getTest().pass("Verify Delivery and installation page");
    }
}
