package com.automation.electrolux.EPIC_05_CLP;

import com.automation.BaseTest;
import com.automation.electrolux.pages.EluctroluxCategoryListingPage;
import com.automation.frigidaire.pages.FeaturesPageActions;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.FrigidaireRefrigeratorPage;
import com.automation.frigidaire.utils.WebElementUtil;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


    public class TC_01_CLP extends BaseTest {


        private final EluctroluxCategoryListingPage electroluxPage = new EluctroluxCategoryListingPage();
        private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();


        @Test(groups = {"smoke", "regression"}, description = "ListingPage")
        public void verifyElectroluxCategoryListingPage() throws InterruptedException {

            homePage.navigateToHomePage();
            WaitUtils.untilPageLoadComplete();

            electroluxPage.clickOnLaundry();
           electroluxPage.clickOnFrontloadLaundry();
            Thread.sleep(2000);


            Assert.assertTrue(electroluxPage.verifyLaundryTowersText(), "Laundry Towers is not found on Laundry page.");
            Assert.assertTrue(electroluxPage.verifyWasherDryerSetsText(), "Washer and Dryer Sets is not found on Laundry page.");
            Assert.assertTrue(electroluxPage.verifyWashersText(), "Washers is not found on Laundry page.");
            Assert.assertTrue(electroluxPage.verifyDryersText(), "Dryers is not found on Laundry page.");

            electroluxPage.clickOnLaundryTowers();
            Assert.assertTrue(electroluxPage.verifyLaundryTowersTitle());
            electroluxPage.verifyListingPage();
            electroluxPage.clickBackButton();

            electroluxPage.clickOnWasherDryerSets();
            Assert.assertTrue(electroluxPage.verifyWasherDryerSetsTitle());
            electroluxPage.verifyListingPage();
            electroluxPage.clickBackButton();

            electroluxPage.clickOnWashers();
            Assert.assertTrue(electroluxPage.verifyWashersTitle());
            electroluxPage.verifyListingPage();
            electroluxPage.clickBackButton();

            electroluxPage.clickOnDryers();
            Assert.assertTrue(electroluxPage.verifyDryersTitle());
            electroluxPage.verifyListingPage();


            ExtentReportManager.getTest().pass("Login Page loaded Successfully and its Fields and Messages are verified");
        }
    }

