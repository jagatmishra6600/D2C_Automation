package com.automation.frigidaire.EPIC_11_CheckoutPage_2;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.FEDEX_AITPageActionsFrig;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.OutOfStockPageActionsFrig;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class EPIC_11_TC_03_FEDEX_AIT extends BaseTest {

    HomePageActionsFrig homePage = new HomePageActionsFrig();
    FEDEX_AITPageActionsFrig fedexPage = new FEDEX_AITPageActionsFrig();
    OutOfStockPageActionsFrig productItems = new OutOfStockPageActionsFrig();

    @Test(groups = {"smoke", "regression"}, description = "Verify FEDEX and AIT Delivery")
    public void EPIC_04_PLP_TC_03_testFedexDelivery(){

        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");

        fedexPage.searchProducts("GRMC2273CF-C1");
        productItems.closeEmailPopUp();
        fedexPage.clickProduct();

        List<String> kitchenProducts = Arrays.asList("FHWW184WE2", "FHWC064TE1");
        for (String product : kitchenProducts) {
            fedexPage.searchProducts(product);
            fedexPage.clickProduct();
        }

        fedexPage.checkoutPageFirst();
        fedexPage.shippingAddress("85062");
        fedexPage.checkoutPageSecond();

        ExtentReportManager.getTest().pass("Verify FEDEX and AIT Delivery");
    }
}
