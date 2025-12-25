package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.ReviewsLocatorsFrig;
import org.openqa.selenium.WebElement;

import static com.automation.utils.WaitUtils.*;
import static com.automation.utils.WebElementUtil.*;


public class ReviewsPageActionsFrig {
    ReviewsLocatorsFrig locators = new ReviewsLocatorsFrig();


    public boolean isReviewSectionVisible() {
        waitForElementToBeVisible(locators.reviewSection);
        return isDisplayed(locators.reviewSection);
    }

    public boolean isProductRatingVisible() {
        waitForElementToBeVisible(locators.productRating);
        return isDisplayed(locators.productRating);
    }

    public boolean isTotalReviewsVisible() {
        waitForElementToBeVisible(locators.totalReviews);
        return isDisplayed(locators.totalReviews);
    }

    public boolean isRatingSnapshotVisible() {
        waitForElementToBeVisible(locators.banner);
        scrollIntoView(locators.banner);
        waitForElementToBeVisible(locators.reviewPage);
        scrollToElementStable(locators.reviewPage);
        WebElement ele = validateInsideShadowDom(locators.outerHostSelector, locators.ratingSnapshot);
        return ele != null && ele.isDisplayed();
    }

    public boolean isReviewStarButtonDisplayed() {
       WebElement ele = validateInsideShadowDom(locators.outerHostSelector, locators.star4);
        return ele != null && ele.isDisplayed();
    }

    public boolean isMessageDisplayed() {
        WebElement ele = validateInsideShadowDom(locators.outerHostSelector, locators.messagePopup);
        return ele != null && ele.isDisplayed();
    }

    public boolean isReviewImagesDisplayed() {
        WebElement ele = validateInsideShadowDom(locators.outerHostSelector, locators.reviewImagesSection);
        if (ele == null || !ele.isDisplayed()) {
            return false;
        }

        WebElement image = validateInsideShadowDom(locators.outerHostSelector, locators.reviewImages);
        image.click();

        WebElement singleImg = validateInsideShadowDom(locators.outerHostSelector, locators.singleReviewImage);
        return singleImg != null && ele.isDisplayed();
    }

    public boolean isSearchReviewBox() {
        WebElement close = validateInsideShadowDom(locators.outerHostSelector, locators.closeModel);
        close.click();

        WebElement ele = validateInsideShadowDom(locators.outerHostSelector, locators.searchReviewBox);
        return ele != null && ele.isDisplayed();
    }

    public boolean isRatingFilterDisplayed() {
        WebElement ele = validateInsideShadowDom(locators.outerHostSelector, locators.ratingFilter);
        return ele != null && ele.isDisplayed();
    }

    public boolean isSortByRatingDisplayed() {
        WebElement ele = validateInsideShadowDom(locators.outerHostSelector, locators.sortByRating);
        return ele != null && ele.isDisplayed();
    }

    public boolean isThumbUpButtonDisplayed() {
        WebElement ele = validateInsideShadowDom(locators.outerHostSelector, locators.thumbUp);
        return ele != null && ele.isDisplayed();
    }

    public boolean isThumbDownButtonDisplayed() {
        WebElement ele = validateInsideShadowDom(locators.outerHostSelector, locators.thumbDown);
        return ele != null && ele.isDisplayed();
    }

    public boolean isReportButtonDisplayed() {
        WebElement ele = validateInsideShadowDom(locators.outerHostSelector, locators.reportButton);
        return ele != null && ele.isDisplayed();
    }

    public boolean isPaginationInfoDisplayed() {
        WebElement ele = validateInsideShadowDom(locators.outerHostSelector, locators.paginationInfo);
        return ele != null && ele.isDisplayed();
    }

    public boolean isLoadMoreButtonDisplayed() {
        WebElement ele = validateInsideShadowDom(locators.outerHostSelector, locators.loadMore);
        return ele != null && ele.isDisplayed();
    }

}
