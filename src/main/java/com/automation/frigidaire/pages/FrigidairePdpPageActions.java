package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.FE_PDP;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

public class FrigidairePdpPageActions {

    FE_PDP pdpPage_Locator = new FE_PDP();

    public boolean isProductIdMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.productIdOnPDP);
        String actualId = WebElementUtil.getText(pdpPage_Locator.productIdOnPDP).trim();
        String expectedId = PlpPageActions_Frig.getSelectedProductId().trim();
        return actualId.equalsIgnoreCase(expectedId);
    }

    public boolean isProductTitleMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.productTitleOnPDP);
        String actualTitle = WebElementUtil.getText(pdpPage_Locator.productTitleOnPDP).trim();
        String expectedTitle = PlpPageActions_Frig.getSelectedProductTitle().trim();
        return actualTitle.toLowerCase().contains(expectedTitle.toLowerCase());
    }

    public boolean isProductPriceMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.productPriceOnPDP);
        String actualPrice = WebElementUtil.getText(pdpPage_Locator.productPriceOnPDP).trim();
        actualPrice = actualPrice.replaceAll("\\.\\d+$", "");
        String expectedPrice = PlpPageActions_Frig.getSelectedProductPrice().trim();
        expectedPrice = expectedPrice.replaceAll("(\\.00|00)$", "");
        return actualPrice.equalsIgnoreCase(expectedPrice);
    }

    public boolean isProductReviewMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.productReviewNumberOnPDP);
        String actualReview = WebElementUtil.getText(pdpPage_Locator.productReviewNumberOnPDP).trim();
        String expectedReview = PlpPageActions_Frig.getSelectedProductReviewNumber().trim();
        return actualReview.equalsIgnoreCase(expectedReview);
    }

    public boolean isProductColorVisibleOnPDP() {
        WebElementUtil.isDisplayed(pdpPage_Locator.productColorOnPDP);
        return true;
    }

    public FrigidairePdpPageActions clickQuickSpec() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.overViewAndFeatures);
        WebElementUtil.clickElement(pdpPage_Locator.quickSpecificationBtnOnPDP);
        return this;
    }

    public boolean isSeeAllVisibleInQuickSpec() {
        WebElementUtil.isDisplayed(pdpPage_Locator.quickSpecSeeAll);
        return true;
    }

    public boolean isHeightMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.pdpHeight);

        String actualHeight = WebElementUtil.getText(pdpPage_Locator.pdpHeight).trim();
        String expectedHeight = PlpPageActions_Frig.getSelectedHeight().trim();

        return actualHeight.equalsIgnoreCase(expectedHeight);
    }

    public boolean iswidthMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.pdpWidth);

        String actualWidth = WebElementUtil.getText(pdpPage_Locator.pdpWidth).trim();
        String expectedWidth = PlpPageActions_Frig.getSelectedWidth().trim();

        return actualWidth.equalsIgnoreCase(expectedWidth);
    }

    public boolean isDepthMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.pdpDepth);

        String actualDepth = WebElementUtil.getText(pdpPage_Locator.pdpDepth).trim();
        String expectedDepth = PlpPageActions_Frig.getSelectedDepth().trim();

        return actualDepth.equalsIgnoreCase(expectedDepth);
    }

    public FrigidairePdpPageActions clickDeliveryOption() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.frenchdoorDelivery);
        WebElementUtil.clickElement(pdpPage_Locator.frenchdoorDelivery);
        return this;
    }

    public FrigidaireDAndSPageActions clickAddToCartButton() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.addToCartButton);
        WebElementUtil.clickElement(pdpPage_Locator.addToCartButton);
        return new FrigidaireDAndSPageActions();
    }


}
