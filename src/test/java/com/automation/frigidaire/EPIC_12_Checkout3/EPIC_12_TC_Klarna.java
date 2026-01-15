package com.automation.frigidaire.EPIC_12_Checkout3;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.*;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_12_TC_Klarna extends BaseTest{

    HomePageActionsFrig homePage = new HomePageActionsFrig();
    FEDEX_AITPageActionsFrig fedexPage = new FEDEX_AITPageActionsFrig();
    OutOfStockPageActionsFrig productItems = new OutOfStockPageActionsFrig();
    KlarnaPageActionFrig klarnaFrig = new KlarnaPageActionFrig();

    @Test(groups = {"smoke", "regression"}, description = "Verify Klarna payment option ")
    public void testKlarnaPayment(){
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        fedexPage.searchProducts("GRMC2273CF-C1");
        productItems.closeEmailPopUp();
        klarnaFrig.clickProduct();
        fedexPage.checkoutPageFirst();
        fedexPage.shippingAddress("28088");
        WaitUtils.sleep(5000);
        klarnaFrig.checkoutPage();
        klarnaFrig.openKlarnaWindow();
        Assert.assertTrue(klarnaFrig.isTitleVisible(),"Title is not visible");
        ExtentReportManager.getTest().pass("Verify Klarna payment option ");
    }
}
