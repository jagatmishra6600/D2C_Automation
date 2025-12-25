package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.PDPLocatorsFrig;
import static com.automation.utils.WaitUtils.*;
import static com.automation.utils.WebElementUtil.*;

public class PdpPageActionsFrig {

    PDPLocatorsFrig pdpPage_Locator = new PDPLocatorsFrig();

    public boolean isProductIdMatchingWithPLP() {
        untilVisible(pdpPage_Locator.productIdOnPDP);
        String actualId = getText(pdpPage_Locator.productIdOnPDP).trim();
        String expectedId = PlpPageActionsFrig.getSelectedProductId().trim();
        return actualId.equalsIgnoreCase(expectedId);
    }

    public boolean isProductTitleMatchingWithPLP() {
        untilVisible(pdpPage_Locator.productTitleOnPDP);
        String actualTitle = getText(pdpPage_Locator.productTitleOnPDP).trim();
        String expectedTitle = PlpPageActionsFrig.getSelectedProductTitle().trim();
        return actualTitle.toLowerCase().contains(expectedTitle.toLowerCase());
    }

    public boolean isProductPriceMatchingWithPLP() {
        untilVisible(pdpPage_Locator.productPriceOnPDP);
        String actualPrice = getText(pdpPage_Locator.productPriceOnPDP).trim();
        actualPrice = actualPrice.replaceAll("\\.\\d+$", "");
        String expectedPrice = PlpPageActionsFrig.getSelectedProductPrice().trim();
        expectedPrice = expectedPrice.replaceAll("(\\.00|00)$", "");
        return actualPrice.equalsIgnoreCase(expectedPrice);
    }

    public boolean isProductReviewMatchingWithPLP() {
        untilVisible(pdpPage_Locator.productReviewNumberOnPDP);
        String actualReview = getText(pdpPage_Locator.productReviewNumberOnPDP).trim();
        String expectedReview = PlpPageActionsFrig.getSelectedProductReviewNumber().trim();
        return actualReview.equalsIgnoreCase(expectedReview);
    }

    public boolean isProductColorVisibleOnPDP() {
        isDisplayed(pdpPage_Locator.productColorOnPDP);
        return true;
    }

    public PdpPageActionsFrig clickQuickSpec() {
        scrollToElementCenter(pdpPage_Locator.overViewAndFeatures);
        clickElement(pdpPage_Locator.quickSpecificationBtnOnPDP);
        return this;
    }

    public boolean isSeeAllVisibleInQuickSpec() {
        isDisplayed(pdpPage_Locator.quickSpecSeeAll);
        return true;
    }

    public boolean isHeightMatchingWithPLP() {
        untilVisible(pdpPage_Locator.pdpHeight);

        String actualHeight = getText(pdpPage_Locator.pdpHeight).trim();
        String expectedHeight = PlpPageActionsFrig.getSelectedHeight().trim();

        return actualHeight.equalsIgnoreCase(expectedHeight);
    }

    public boolean iswidthMatchingWithPLP() {
        untilVisible(pdpPage_Locator.pdpWidth);

        String actualWidth = getText(pdpPage_Locator.pdpWidth).trim();
        String expectedWidth = PlpPageActionsFrig.getSelectedWidth().trim();

        return actualWidth.equalsIgnoreCase(expectedWidth);
    }

    public boolean isDepthMatchingWithPLP() {
        untilVisible(pdpPage_Locator.pdpDepth);

        String actualDepth = getText(pdpPage_Locator.pdpDepth).trim();
        String expectedDepth = PlpPageActionsFrig.getSelectedDepth().trim();

        return actualDepth.equalsIgnoreCase(expectedDepth);
    }

    public PdpPageActionsFrig clickDeliveryOption() {
        scrollToElementCenter(pdpPage_Locator.frenchdoorDelivery);
        clickElement(pdpPage_Locator.frenchdoorDelivery);
        return this;
    }

    public DAndSPageActionsFrig clickAddToCartButton() {
        scrollToElementCenter(pdpPage_Locator.addToCartButton);
        clickElement(pdpPage_Locator.addToCartButton);
        return new DAndSPageActionsFrig();
    }

    public PdpPageActionsFrig clickAddToCart() {
        scrollToElementCenter(pdpPage_Locator.addToCartButton);
        clickElement(pdpPage_Locator.addToCartButton);
        return this;
    }

    public CartPageActionsFrig clickViewCartButton() {
        scrollToElementCenter(pdpPage_Locator.viewCartButton);
        clickElement(pdpPage_Locator.viewCartButton);
        return new CartPageActionsFrig();
    }


}
