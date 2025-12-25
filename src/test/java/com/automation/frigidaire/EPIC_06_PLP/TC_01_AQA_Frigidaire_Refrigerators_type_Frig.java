package com.automation.frigidaire.EPIC_06_PLP;

import com.automation.frigidaire.pages.FeaturesPageActionsFrig;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.PlpPageActionsFrig;
import com.automation.frigidaire.pages.RefrigeratorPageActionsFrig;
import com.automation.BaseTest;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01_AQA_Frigidaire_Refrigerators_type_Frig extends BaseTest {
    private final HomePageActionsFrig homePage = new HomePageActionsFrig();
    private final FeaturesPageActionsFrig pdpPage = new FeaturesPageActionsFrig();
    private final PlpPageActionsFrig plpPage = new PlpPageActionsFrig();
    private final RefrigeratorPageActionsFrig frigidairpage = new RefrigeratorPageActionsFrig();



@Test(groups = {"smoke", "regression"}, description = "Messages")
public void frigidaire_Refrigerators_type() {

    homePage.navigateToHomePage();
    WaitUtils.untilPageLoadComplete();
    frigidairpage.clickOnKitchen();
    frigidairpage.clickOnRefrigeratorSubcategory();
    Assert.assertTrue(frigidairpage.verifyFrenchdoorText(), "FrenchDoor text not found.");
    Assert.assertTrue(frigidairpage.verifySidebyside(), "Sidebyside text not found.");
    Assert.assertTrue(frigidairpage.verifySingleDoor(), "SingleDoor text not found.");
    Assert.assertTrue(frigidairpage.verifyTopfreezer(), "Topfreezer text not found.");
    Assert.assertTrue(frigidairpage.verifyBottomFreezer(), "BottomFreezer text not found.");
    Assert.assertTrue(frigidairpage.verifyCompact(), "Compact text not found.");
    Assert.assertTrue(frigidairpage.verifyWineandbeverage(), "Wineandbeverage text not found.");
    Assert.assertTrue(frigidairpage.verifyRefigeratorText(), "Refrigerator bold text not found.");

    Assert.assertTrue(frigidairpage.verifyShoptoprated(), "Bestseller  text not found.");

    Assert.assertTrue(frigidairpage.verifyBestseller(), "Bestseller  text not found.");
    Assert.assertTrue(frigidairpage.verifyFridgetext(), "text not found.");
    Assert.assertTrue(frigidairpage.verifyReviews(), "text not found.");
    Assert.assertTrue(frigidairpage.verifyPrice(), "text not found.");
    Assert.assertTrue(frigidairpage.verifyTitle(), "text not found.");
    Assert.assertTrue(frigidairpage.verifyMessage(), "text not found.");

    frigidairpage.clickOnSidebysidenext();
    frigidairpage.clickOnNextbutton();
    frigidairpage.clickOnLargestoragecapacity();
    frigidairpage.clickOnseeresult();
    frigidairpage.clickOnYourresult();

    Assert.assertTrue(frigidairpage.verifySelecteditemresult(), "text not found.");
    Assert.assertTrue(frigidairpage.verifyfrigidaireproffessional(), "text not found.");
    Assert.assertTrue(frigidairpage.verifytotalRatings(), "text not found.");
    Assert.assertTrue(frigidairpage.VerifyRefrigeratorproductname(), "text not found.");
    Assert.assertTrue(frigidairpage.verifyRefproductprices(), "text not found.");

    frigidairpage.clickOnmorefrenchdooroptions();

    WebElementUtil.switchToLatestTabAndClosePrevious();

    frigidairpage.clickOnrefrigeratorimage();

    Assert.assertTrue(frigidairpage.verifyPDProductRating(), "Product rating is not shown");
    Assert.assertTrue(frigidairpage.verifyPDPProductName(), "product name is not shown");
    Assert.assertTrue(frigidairpage.verifyPDPProductimage(), "product image is not shown");

    ExtentReportManager.getTest().pass("Login Page loaded Successfully and its Fields and Messages are verified");
}
}