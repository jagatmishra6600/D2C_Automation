package com.automation.electrolux.pages;

import com.automation.electrolux.locators.ElectroluxReviewLocators;
import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElectroluxReviewsPageActions {
    ElectroluxReviewLocators locators = new ElectroluxReviewLocators();

    private final By reviewPage = By.xpath("//h2[text()='Reviews']");
    private final By reviewSection = By.xpath("//div[@data-bv-show='rating_summary']");
    private final By productRating = By.xpath("//div[@class='pdp_info_wrapper']//div[@itemprop='ratingValue'] | //div[contains(@class,'bv_avgRating_component_container')]");
    private final By totalReviews = By.xpath("//div[@class='pdp_info_wrapper']//div[@class='bv_numReviews_text'] | //div[@class='bv_numReviews_component_container']//div[@class='bv_numReviews_text']");
    private final By ratingSnapshot = By.cssSelector(".bv_rating_content1");
    private final By banner = By.xpath("//cx-page-slot[contains(@class,'frigStaticPdpFeature')] | //cx-page-slot[contains(@class,'eluxStaticLuxPdpFeature')]");
    private final By star4 = By.cssSelector("div.bv-reviews-product-rating-star:nth-of-type(4)");
    private final By messagePopup = By.cssSelector("div.bv-rnr__sc-2kyvjj-5.jJMAoq > span, div.bv-rnr__sc-2kyvjj-5.fqNDpx > span");
    private final By reviewImagesSection = By.cssSelector("div.bv-rnr__sc-11cxkec-3.fwthKG");
    private final By reviewImages = By.cssSelector("div.bv-rnr__sc-1qec6v5-2.bmzJjw.photos-tile");
    private final By singleReviewImage = By.cssSelector("img.bv-rnr__f7tz1h-15.gwBVvU");
    private final By searchReviewBox = By.cssSelector("input#search-input.bv-rnr__sc-5jc2zu-2.dIySXf");
    private final By sortByRating = By.cssSelector("div.bv-rnr__sc-13ijx62-1.cokHYY");
    private final By thumbUp = By.cssSelector("button.bv-rnr__sc-314f1h-0.ipgIWW");
    private final By thumbDown = By.cssSelector("button.bv-rnr__sc-1tt2trz-0.kGAbXX");
    private final By reportButton = By.cssSelector(" button.reportbutton");
    private final By paginationInfo = By.cssSelector("div.bv-rnr__sc-11r39gb-2.cTgetK, div.bv-rnr__sc-11r39gb-2.kbTMsI");
    private final By loadMore = By.cssSelector("button.bv-rnr__sc-16j1lpy-3.bv-rnr__sc-17t5kn5-1.hkPgFo.iuGpzE, a.next");
    private final By closeModel = By.cssSelector("button.bv-rnr__sop07g-0.igckvK.modalCloseBtn");
    private final By outerHostSelector = By.cssSelector("div.bv-pdp-review.ng-star-inserted, app-elux-pdp-reviews, .bv-pdp-review.ng-star-inserted");

    public boolean isReviewSectionVisible() {
        WebElementUtil.waitForElementToBeVisible(locators.reviewSection, 10);
        return WebElementUtil.isDisplayed(locators.reviewSection);
    }

    public boolean isProductRatingVisible() {
        WebElementUtil.waitForElementToBeVisible(locators.productRating, 10);
        return WebElementUtil.isDisplayed(locators.productRating);
    }

    public boolean isTotalReviewsVisible() {
        WebElementUtil.waitForElementToBeVisible(locators.totalReviews, 10);
        return WebElementUtil.isDisplayed(locators.totalReviews);
    }

    public boolean isRatingSnapshotVisible() {
        WebElementUtil.waitForElementToBeVisible(locators.banner, 10);
        WebElementUtil.scrollIntoView(locators.banner);
        WebElementUtil.waitForElementToBeVisible(locators.reviewPage, 10);
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

