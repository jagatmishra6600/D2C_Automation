package com.automation.electrolux.EPIC_05_CLP;

import com.automation.BaseTest;
import com.automation.electrolux.pages.EluctroluxCategoryListingPage;
import com.automation.frigidaire.pages.FeaturesPageActions;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.FrigidairePlpPageActions;
import com.automation.frigidaire.pages.FrigidaireRefrigeratorPage;
import com.automation.frigidaire.utils.WebElementUtil;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


    public class TC_01_CLP extends BaseTest {

        String washerDryersURL = "https://www.electrolux.com/en/washers-dryers/stacked-washer-and-dryer-units";
        String washerDryerssetURL = "https://www.electrolux.com/en/washer-dryer-sets";
        String washingmachineURL = "https://www.electrolux.com/en/washers-dryers/washing-machine";
        String DryersURL = "https://www.electrolux.com/en/washers-dryers/dryer";

        private final EluctroluxCategoryListingPage electroluxPage = new EluctroluxCategoryListingPage();



        private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
        private final FeaturesPageActions pdpPage = new FeaturesPageActions();
        private final FrigidairePlpPageActions plpPage = new FrigidairePlpPageActions();
        private final FrigidaireRefrigeratorPage frigidairpage = new FrigidaireRefrigeratorPage();



        @Test(groups = {"smoke", "regression"}, description = "Messages")
        public void verifyElectroluxCategoryListingPage() throws InterruptedException {

            homePage.navigateToHomePage();
            WaitUtils.untilPageLoadComplete();

            electroluxPage.clickOnLaundry();
      //      electroluxPage.clickOnFrontloadlaundry();
            Thread.sleep(2000);


            Assert.assertTrue(electroluxPage.verifyLaundryTowersText(), "Laundry Towers is not found on Laundry page.");
            Assert.assertTrue(electroluxPage.verifyWasherDryerSetsText(), "Washer and Dryer Sets is not found on Laundry page.");
            Assert.assertTrue(electroluxPage.verifyWashersText(), "Washers is not found on Laundry page.");
            Assert.assertTrue(electroluxPage.verifyDryersText(), "Dryers is not found on Laundry page.");

            electroluxPage.clickOnLaundryTowers();
            electroluxPage.verifyListingPage(washerDryersURL);

            electroluxPage.clickBackButton();
            electroluxPage.clickOnWasherDryerSets();
            electroluxPage.verifyListingPage(washerDryerssetURL);
            electroluxPage.clickBackButton();

            electroluxPage.clickOnWashers();
            electroluxPage.verifyListingPage(washingmachineURL);
            electroluxPage.clickBackButton();

            electroluxPage.clickOnDryers();
            electroluxPage.verifyListingPage(DryersURL);


            ExtentReportManager.getTest().pass("Login Page loaded Successfully and its Fields and Messages are verified");
        }
    }

