package com.automation.frigidaire.EPIC_02_Home;

import com.automation.frigidaire.pages.ContactPageActionsFrig;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.LoginPageActionsFrig;
import com.automation.BaseTest;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_02_TC_02_AQA_Homepage_Header_Frig extends BaseTest {

    HomePageActionsFrig homePage = new HomePageActionsFrig();
    LoginPageActionsFrig loginScreen = new LoginPageActionsFrig();
    ContactPageActionsFrig contactus = new ContactPageActionsFrig();

    @Test(groups = {"regression", "TC_02"}, description = "Verify the logo / brand icon displayed in the header")
    public void EPIC_02_HomePage_TC_02_S1_VerifyBandLogoDisplayed() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isBrancdLogoLoaded(), "The Frigidaire Logo did not load correctly.");
        ExtentReportManager.getTest().pass("Home page loaded successfully and logo was verified.");
    }

    @Test(groups = {"regression", "TC_02"}, description = "Verify on click on brand logo / icon from the header")
    public void EPIC_02_HomePage_TC_02_S2_ClickBandLogoHeader() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        Assert.assertTrue(homePage.validateUserNavigateBackToHomepage(), "Navigation back to home page failed.");
        ExtentReportManager.getTest().pass("Pass - Verify on click on brand logo / icon from the header");
    }

    @Test(groups = {"regression", "TC_02"}, description = "Verify the header for logged in / registered user.")
    public void EPIC_02_HomePage_TC_02_S3_VerifyHearForLoggedInUser() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        homePage.navigateToLoginPage();
        Assert.assertTrue(loginScreen.loginWithCredentials(ConfigReader.getProperty("username"), ConfigReader.getProperty("password")), "Login page did not load correctly and Logo is not displayed");
        ExtentReportManager.getTest().pass("Home page loaded successfully and logo was verified.");
    }

    @Test(groups = {"regression", "TC_02"}, description = "Verify \"Contact us\" link from header")
    public void EPIC_02_HomePage_TC_02_S4_VerifyContactUsLink() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isContactUsLinkDisplayed(), "The Frigidaire home page did not load correctly and contact us link is not displayed.");
        homePage.clickContactUsLink();
        Assert.assertTrue(contactus.isContactPageLoaded(), "Contact us page did not load correctly.");
        ExtentReportManager.getTest().pass("Contact Us link from from header was verified.");
    }

    @Test(groups = {"regression", "TC_02"}, description = "Verify zip code displayed in the header")
    public void EPIC_02_HomePage_TC_02_S5_VerifyZIP() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isZipCodeDisplayed(), "ZIP Code not loaded properly.");
        ExtentReportManager.getTest().pass("Default ZIP code is set to 28088");
    }

    @Test(groups = {"regression", "TC_02"}, description = "Verify update / change zip code in the header")
    public void EPIC_02_HomePage_TC_02_S6_VerifyZIPUpdate() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isZipCodeDisplayed(), "ZIP Code not loaded properly.");
        homePage.enterZipCode("28808");
        Assert.assertEquals(homePage.getDefaultZipCode(), "Deliver to: 28088", "Default ZIP code is not set to 28088");
        ExtentReportManager.getTest().pass("Home page loaded successfully and logo was verified.");
    }

    @Test(groups = {"regression", "TC_02"}, description = "Verify zip code when invalid zip code is entered")
    public void EPIC_02_HomePage_TC_02_S7_VerifyZIPUpdateInvalid() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.validateInvalidZIPWhenBlank(), "Invalid ZIP code message is not displayed when blank.");
        Assert.assertTrue(homePage.validateInvalidZIPWhenLessThan5Digits(), "Invalid ZIP code message is not displayed when invalid ZIP is entered.");
        ExtentReportManager.getTest().pass("Home page loaded successfully and logo was verified.");
    }

    @Test(groups = {"regression", "TC_02"}, description = "Verify mini cart icon in the header")
    public void EPIC_02_HomePage_TC_02_S8_VerifyMINICart() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isMiniCartDisplayed(), "Mini cart is not displayed in the header");
        homePage.addIteamToCart("IM117000");
        Assert.assertTrue(homePage.isMiniCartCountUpdated(), "Mini cart count is not updated after adding an item to the cart");
        ExtentReportManager.getTest().pass("Home page loaded successfully and logo was verified.");
    }

    @Test(groups = {"regression", "TC_02"}, description = "Verify onclick on \"mini cart\" icon")
    public void EPIC_02_HomePage_TC_02_S9_VerifyMINICartOnclick() {
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isMiniCartDisplayed(), "Mini cart is not displayed in the header");
        homePage.clickMiniCart();
        ExtentReportManager.getTest().pass("Mini cart click functionality verified");
    }
}
