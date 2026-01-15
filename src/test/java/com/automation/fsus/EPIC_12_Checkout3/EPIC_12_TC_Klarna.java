package com.automation.fsus.EPIC_12_Checkout3;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.COPS_OrderSummaryPageActions_Fsus;
import com.automation.familystoreus.pages.KlarnaPageActionFsus;
import com.automation.familystoreus.pages.LoginPageActionsFsus;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_12_TC_Klarna extends BaseTest {

    LoginPageActionsFsus loginPage = new LoginPageActionsFsus();
    COPS_OrderSummaryPageActions_Fsus orderSummaryPage = new COPS_OrderSummaryPageActions_Fsus();
    KlarnaPageActionFsus klarnaFsus = new KlarnaPageActionFsus();

    @Test(groups = {"smoke", "regression"}, description = "Verify Klarna payment page")
    public void testKlarnaPayment() {
        loginPage.loginWithDefaultCredentials();
        loginPage.acceptCookies();
        orderSummaryPage.searchProducts("GRMC2273CF-C1");
        orderSummaryPage.clickOnProductBundle();
        WaitUtils.sleep(5000);
        orderSummaryPage.clickOnProceedCheckout();
        orderSummaryPage.enterAddressDetails("Tom","Walker", "28088");
        klarnaFsus.checkoutPage("7894561234");
        klarnaFsus.openKlarnaWindow();
        Assert.assertTrue(klarnaFsus.isTitleVisible(),"Title is not visible");
        ExtentReportManager.getTest().pass("Verify Klarna payment page ");
    }
}
