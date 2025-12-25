package com.automation.electrolux.pages;

import com.automation.electrolux.locators.ReviewLocatorsElux;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.WebElement;

public class ReviewsPageActionsElux {
    ReviewLocatorsElux locators = new ReviewLocatorsElux();

    public boolean isReviewSectionVisible() {
        WaitUtils.waitForElementToBeVisible(locators.reviewSection);
        return WebElementUtil.isDisplayed(locators.reviewSection);
    }

    public boolean isProductRatingVisible() {
        WaitUtils.waitForElementToBeVisible(locators.productRating);
        return WebElementUtil.isDisplayed(locators.productRating);
    }

    public boolean isTotalReviewsVisible() {
        WaitUtils.waitForElementToBeVisible(locators.totalReviews);
        return WebElementUtil.isDisplayed(locators.totalReviews);
    }

    public boolean isRatingSnapshotVisible() {
        WaitUtils.waitForElementToBeVisible(locators.banner);
        WebElementUtil.scrollIntoView(locators.banner);
        WaitUtils.waitForElementToBeVisible(locators.reviewPage);
        WebElementUtil.scrollIntoView(locators.reviewPage);
        WebElement ele = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.ratingSnapshot);
        return ele.isDisplayed();
    }

    public boolean isReviewStarButtonDisplayed() {
        WaitUtils.waitForElementToBeVisible(locators.outerHostSelector);
        WebElement ele = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.star4);
        return ele.isDisplayed();
    }

    public boolean isMessageDisplayed() {
        WaitUtils.waitForElementToBeVisible(locators.outerHostSelector);
        WebElement ele = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.messagePopup);
        return ele.isDisplayed();
    }

    public boolean isReviewImagesDisplayed() {
        WaitUtils.waitForElementToBeVisible(locators.outerHostSelector);
        WebElement section = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.reviewImagesSection);
        if (section == null || !section.isDisplayed()) return false;
        WebElement image = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.reviewImages);
        if (image != null) image.click();
        WebElement singleImg = WebElementUtil.validateInsideShadowDom(locators.outerHostSelector, locators.singleReviewImage);
        return singleImg != null && singleImg.isDisplayed();
    }

    public boolean isSearchReviewBox() {
        WaitUtils.waitForElementToBeVisible(locators.outerHostSelector);
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

