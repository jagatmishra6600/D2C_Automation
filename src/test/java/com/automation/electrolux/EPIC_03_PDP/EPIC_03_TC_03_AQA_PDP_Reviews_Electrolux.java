package com.automation.electrolux.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.electrolux.pages.ElectroluxFeaturePageActions;
import com.automation.electrolux.pages.ElectroluxReviewsPageActions;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.FrigidairePlpPageActions;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_03_AQA_PDP_Reviews_Electrolux extends BaseTest {
    private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    private final ElectroluxFeaturePageActions page = new ElectroluxFeaturePageActions();
    private final FrigidairePlpPageActions plpPage = new FrigidairePlpPageActions();
    private final ElectroluxReviewsPageActions reviewsPage = new ElectroluxReviewsPageActions();

    @Test(groups = {"smoke", "regression"}, description = "Verify Reviews on PDP page")
    public void testReviewsFunctionality() {
        homePage.navigateToHomePage();
        page.searchProduct("EHVS2510AW-C1");
        page.selectProductFromPLP();
        plpPage.closePopupModel();
        Assert.assertTrue(reviewsPage.isReviewSectionVisible(), "Review section is not visible on PDP page");
        Assert.assertTrue(reviewsPage.isProductRatingVisible(), "Rating is not visible on PDP page");
        Assert.assertTrue(reviewsPage.isTotalReviewsVisible(), "Total Rating is not visible on PDP page");
        Assert.assertTrue(reviewsPage.isRatingSnapshotVisible(), "Rating Snapshot is not visible on PDP page");
        Assert.assertTrue(reviewsPage.isMessageDisplayed(), "Message popup is not displayed");
        Assert.assertTrue(reviewsPage.isReviewStarButtonDisplayed(), "Review star button is not displayed");
        Assert.assertTrue(reviewsPage.isReviewImagesDisplayed(), "Review images are not displayed in reviews section");
        Assert.assertTrue(reviewsPage.isSearchReviewBox(), "Search review box is not displayed in reviews section");
        Assert.assertTrue(reviewsPage.isSortByRatingDisplayed(), "Sort by rating is not displayed in reviews section");
        Assert.assertTrue(reviewsPage.isThumbUpButtonDisplayed(), "Thumb up button is not displayed in reviews section");
        Assert.assertTrue(reviewsPage.isThumbDownButtonDisplayed(), "Thumb down button is not displayed in reviews section");
        Assert.assertTrue(reviewsPage.isReportButtonDisplayed(), "Report button is not displayed in reviews section");
        Assert.assertTrue(reviewsPage.isPaginationInfoDisplayed(), "Pagination info is not displayed in reviews section");
        Assert.assertTrue(reviewsPage.isLoadMoreButtonDisplayed(), "Load more button is not displayed in reviews section");

        ExtentReportManager.getTest().pass("Verify Reviews on PDP page");
    }
}
