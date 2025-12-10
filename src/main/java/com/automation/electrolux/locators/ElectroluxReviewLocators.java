package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class ElectroluxReviewLocators {

    public final By reviewPage = By.xpath("//h2[text()='Reviews']");
    public final By reviewSection = By.xpath("//div[@data-bv-show='rating_summary']");
    public final By productRating = By.xpath("//div[@class='pdp_info_wrapper']//div[@itemprop='ratingValue'] | //div[contains(@class,'bv_avgRating_component_container')]");
    public final By totalReviews = By.xpath("//div[@class='pdp_info_wrapper']//div[@class='bv_numReviews_text'] | //div[@class='bv_numReviews_component_container']//div[@class='bv_numReviews_text']");
    public final By ratingSnapshot = By.cssSelector(".bv_rating_content1");
    public final By banner = By.xpath("//cx-page-slot[contains(@class,'frigStaticPdpFeature')] | //cx-page-slot[contains(@class,'eluxStaticLuxPdpFeature')]");
    public final By star4 = By.cssSelector("div.bv-reviews-product-rating-star:nth-of-type(4)");
    public final By messagePopup = By.cssSelector("div.bv-rnr__sc-2kyvjj-5.jJMAoq > span, div.bv-rnr__sc-2kyvjj-5.fqNDpx > span");
    public final By reviewImagesSection = By.cssSelector("div.bv-rnr__sc-11cxkec-3.fwthKG");
    public final By reviewImages = By.cssSelector("div.bv-rnr__sc-1qec6v5-2.bmzJjw.photos-tile");
    public final By singleReviewImage = By.cssSelector("img.bv-rnr__f7tz1h-15.gwBVvU");
    public final By searchReviewBox = By.cssSelector("input#search-input.bv-rnr__sc-5jc2zu-2.dIySXf");
    public final By sortByRating = By.cssSelector("div.bv-rnr__sc-13ijx62-1.cokHYY");
    public final By thumbUp = By.cssSelector("button.bv-rnr__sc-314f1h-0.ipgIWW");
    public final By thumbDown = By.cssSelector("button.bv-rnr__sc-1tt2trz-0.kGAbXX");
    public final By reportButton = By.cssSelector(" button.reportbutton");
    public final By paginationInfo = By.cssSelector("div.bv-rnr__sc-11r39gb-2.cTgetK, div.bv-rnr__sc-11r39gb-2.kbTMsI");
    public final By loadMore = By.cssSelector("button.bv-rnr__sc-16j1lpy-3.bv-rnr__sc-17t5kn5-1.hkPgFo.iuGpzE, a.next");
    public final By closeModel = By.cssSelector("button.bv-rnr__sop07g-0.igckvK.modalCloseBtn");
    public final By outerHostSelector = By.cssSelector("div.bv-pdp-review.ng-star-inserted, app-elux-pdp-reviews, .bv-pdp-review.ng-star-inserted");

}
