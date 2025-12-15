package com.automation.electrolux.pages;

import com.automation.electrolux.locators.ReviewLocatorsElux;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.WebElement;

public class ReviewsPageActionsElux {
    ReviewLocatorsElux locators = new ReviewLocatorsElux();

    public boolean isReviewSectionVisible() {
        WebElementUtil.waitForElementToBeVisible(locators.reviewSection, 20);
        return WebElementUtil.isDisplayed(locators.reviewSection);
    }

    public boolean isProductRatingVisible() {
        WebElementUtil.waitForElementToBeVisible(locators.productRating, 20);
        return WebElementUtil.isDisplayed(locators.productRating);
    }

    public boolean isTotalReviewsVisible() {
        WebElementUtil.waitForElementToBeVisible(locators.totalReviews, 20);
        return WebElementUtil.isDisplayed(locators.totalReviews);
    }

    public boolean isRatingSnapshotVisible() {
        WebElementUtil.waitForElementToBeVisible(locators.banner, 20);
        WebElementUtil.scrollIntoView(locators.banner);
        WebElementUtil.waitForElementToBeVisible(locators.reviewPage, 20);
        WebElementUtil.scrollIntoView(locators.reviewPage);
        WebElement ele = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.ratingSnapshot);
        return ele.isDisplayed();
    }

    public boolean isReviewStarButtonDisplayed() {
        WebElement ele = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.star4);
        return ele.isDisplayed();
    }

    public boolean isMessageDisplayed() {
        WebElement ele = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.messagePopup);
        return ele.isDisplayed();
    }

    public boolean isReviewImagesDisplayed() {
        WebElement ele = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.reviewImagesSection);
        ele.isDisplayed();

        WebElement image = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.reviewImages);
        image.click();

        WebElement singleImg = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.singleReviewImage);
        return singleImg.isDisplayed();
    }

    public boolean isSearchReviewBox() {
        WebElement close = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.closeModel);
        close.click();

        WebElement ele = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.searchReviewBox);
        return ele.isDisplayed();
    }

    public boolean isSortByRatingDisplayed() {
        WebElement ele = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.sortByRating);
        return ele.isDisplayed();
    }

    public boolean isThumbUpButtonDisplayed() {
        WebElement ele = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.thumbUp);
        return ele.isDisplayed();
    }

    public boolean isThumbDownButtonDisplayed() {
        WebElement ele = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.thumbDown);
        return ele.isDisplayed();
    }

    public boolean isReportButtonDisplayed() {
        WebElement ele = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.reportButton);
        return ele.isDisplayed();
    }

    public boolean isPaginationInfoDisplayed() {
        WebElement ele = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.paginationInfo);
        return ele.isDisplayed();
    }

    public boolean isLoadMoreButtonDisplayed() {
        WebElement ele = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.loadMore);
        return ele.isDisplayed();
    }

}

