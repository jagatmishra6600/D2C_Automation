package com.automation.fsus.EPIC_03_PDP;

import com.automation.BaseTest;
import com.automation.familystoreus.pages.FsusLoginPageActions;
import com.automation.familystoreus.pages.ReviewsPageActionsFsus;
import com.automation.frigidaire.pages.FeaturesPageActionsFrig;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.FrigidairePlpPageActions;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EPIC_03_TC_03_AQA_PDP_Reviews_Fsus extends BaseTest {

    private final FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
    private final FeaturesPageActionsFrig pdpPage = new FeaturesPageActionsFrig();
    private final FrigidairePlpPageActions plpPage = new FrigidairePlpPageActions();
    private final ReviewsPageActionsFsus reviewsPage = new ReviewsPageActionsFsus();
    private final FsusLoginPageActions loginPage = new FsusLoginPageActions();

    @Test(groups = { "smoke", "regression" }, description = "Verify Reviews on PDP page")
    public void testReviewsFunctionality() throws InterruptedException {
        loginPage.loginWithDefaultCredentials();
        homePage.navigateToHomePage();
        pdpPage.searchProduct("GRMC2273CF-C1");
        pdpPage.selectProductFromPLP();
        plpPage.closePopupModel();
        Assert.assertTrue(reviewsPage.isReviewSectionVisible(), "Review section is not visible on PDP page");
        Assert.assertTrue(reviewsPage.isProductRatingVisible(), "Rating is not visible on PDP page");
        Assert.assertTrue(reviewsPage.isTotalReviewsVisible(), "Total Rating is not visible on PDP page");
        Assert.assertTrue(reviewsPage.isRatingSnapshotVisible(), "Rating Snapshot is not visible on PDP page");
        Assert.assertTrue(reviewsPage.isMessageDisplayed(), "Message popup is not displayed");
        Assert.assertTrue(reviewsPage.isReviewStarButtonDisplayed(), "Review star button is not displayed");
        Assert.assertTrue(reviewsPage.isSearchReviewBox(), "Search review box is not displayed in reviews section");
        Assert.assertTrue(reviewsPage.isRatingFilterDisplayed(), "Rating filter is not displayed in reviews section");
        Assert.assertTrue(reviewsPage.isSortByRatingDisplayed(), "Sort by rating is not displayed in reviews section");
        Assert.assertTrue(reviewsPage.isPaginationInfoDisplayed(),
                "Pagination info is not displayed in reviews section");
        Assert.assertTrue(reviewsPage.isLoadMoreButtonDisplayed(),
                "Load more button is not displayed in reviews section");

        ExtentReportManager.getTest().pass("Verify Reviews on PDP page");
    }
}
