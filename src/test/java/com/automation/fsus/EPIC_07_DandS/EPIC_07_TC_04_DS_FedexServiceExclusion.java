package com.automation.fsus.EPIC_07_DandS;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.FedexServiceExclusionPageActionFsus;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.utils.ExtentReportManager;
import org.testng.annotations.Test;

public class EPIC_07_TC_04_DS_FedexServiceExclusion extends BaseTest {

    FedexServiceExclusionPageActionFsus fedexService = new FedexServiceExclusionPageActionFsus();
    LoginPageActionsFsus loginPage = new LoginPageActionsFsus();

    @Test(groups = {"smoke", "regression"}, description = "Verify Air care Product Details in Product listing page", priority = 2)
    public void EPIC_04_PLP_TC_03_testForAirCare() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        fedexService.enterZipCode("85062");
        fedexService.searchProduct("FRFG1723AV");
        fedexService.clickProduct();
        fedexService.checkDeliveryOptions();
        fedexService.checkInstallationUnavailable();
        ExtentReportManager.getTest().pass("Verify Laundry product details in product listing page and click on image,productName and rating navigate to PDP");
    }

}
