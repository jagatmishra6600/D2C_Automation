package com.automation.frigidaire.tests.EPIC_02_HomePage;

import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02_AQA_Homepage_Header {

    FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    @Test(groups = {"regression"}, description = "Verify the logo / brand icon displayed in the header")
    public void TC_01_S1_VerifyBandLogoDisplayed() {
        //Shopper should see site specific brand logo / icon displayed in the header.

        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        ExtentReportManager.getTest().pass("Home page loaded successfully and logo was verified.");
    }

    @Test(groups = {"regression"}, description = "Verify on click on brand logo / icon from the header")
    public void TC_01_S2_ClickBandLogoHeader() {
        //    Shopper should be navigated back to home page onclick on brand logo / icon, when shopper is in another page throughout the site.

        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        ExtentReportManager.getTest().pass("Home page loaded successfully and logo was verified.");
    }

    @Test(groups = {"regression"}, description = "Verify the header for logged in / registered user.")
    public void TC_01_S3_VerifyHearForLoggedInUser() {
        //    Given I am a shopper
        //    And I am registered user
        //    When I login using my credentials (Registered Email ID and Password)
        //    Then shopper should able to see his / her first name displayed next to "Hello" label in the header
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        ExtentReportManager.getTest().pass("Home page loaded successfully and logo was verified.");
    }

    @Test(groups = {"regression"}, description = "Verify \"Contact us\" link from header")
    public void TC_01_S4_VerifyContactUsLink() {
        //    1. Shopper should see "Contact us" link in the header
        //    2. On click shopper should be navigated to contact us page.
        homePage.navigateToHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "The Frigidaire home page did not load correctly.");
        ExtentReportManager.getTest().pass("Home page loaded successfully and logo was verified.");
    }


    //    Verify zip code displayed in the header
             //    Shopper should see zip code option in the header. Default zip code set to 28088.

    //    Verify update / change zip code in the header
            //            Onclick on zipcode from header, shopper should see:
            //            1. a flyout displaying "Please enter your shipping zip code. Delivery options and availability are based on your delivery area." text along with "Zipcode" text field and "Set" CTA by default disabled.
            //            2. Enter the zip-code, "Set" cta should get enabled.
            //            Onclick on "Set CTA, zip code should get updated in the header as well as in the session.


    //    Verify zip code when invalid zip code is entered
            //     Shopper enters an invalid zip-code or leaves zip code field as blank, then " Invalid zip code" message should be displayed to the shopper.

    //    Verify mini cart icon in the header
            //    Shopper should see:
            //            1. Mini cart button
            //            2. Mini cart should show the count of the products added to the cart.

    //    Verify onclick on "mini cart" icon
            //    Shopper should be navigated to cart details page.

}


