package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.FE_PDP;
import com.automation.utils.BrowserUtils;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;

public class FrigidairePdpPageActions {

    FE_PDP pdpPage_Locator = new FE_PDP();

    public boolean isProductIdMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.productIdOnPDP);
        String actualId = WebElementUtil.getText(pdpPage_Locator.productIdOnPDP).trim();
        String expectedId = FrigidairePlpPageActions.getSelectedProductId().trim();
        return actualId.equalsIgnoreCase(expectedId);
    }

    public boolean isProductTitleMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.productTitleOnPDP);
        String actualTitle = WebElementUtil.getText(pdpPage_Locator.productTitleOnPDP).trim();
        String expectedTitle = FrigidairePlpPageActions.getSelectedProductTitle().trim();
        return actualTitle.toLowerCase().contains(expectedTitle.toLowerCase());
    }

    public boolean isProductPriceMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.productPriceOnPDP);
        String actualPrice = WebElementUtil.getText(pdpPage_Locator.productPriceOnPDP).trim();
        actualPrice = actualPrice.replaceAll("\\.\\d+$", "");
        String expectedPrice = FrigidairePlpPageActions.getSelectedProductPrice().trim();
        expectedPrice = expectedPrice.replaceAll("(\\.00|00)$", "");
        return actualPrice.equalsIgnoreCase(expectedPrice);
    }

    public boolean isProductReviewMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.productReviewNumberOnPDP);
        String actualReview = WebElementUtil.getText(pdpPage_Locator.productReviewNumberOnPDP).trim();
        String expectedReview = FrigidairePlpPageActions.getSelectedProductReviewNumber().trim();
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
        String expectedHeight = FrigidairePlpPageActions.getSelectedHeight().trim();

        return actualHeight.equalsIgnoreCase(expectedHeight);
    }

    public boolean iswidthMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.pdpWidth);

        String actualWidth = WebElementUtil.getText(pdpPage_Locator.pdpWidth).trim();
        String expectedWidth = FrigidairePlpPageActions.getSelectedWidth().trim();

        return actualWidth.equalsIgnoreCase(expectedWidth);
    }

    public boolean isDepthMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.pdpDepth);

        String actualDepth = WebElementUtil.getText(pdpPage_Locator.pdpDepth).trim();
        String expectedDepth = FrigidairePlpPageActions.getSelectedDepth().trim();

        return actualDepth.equalsIgnoreCase(expectedDepth);
    }
}
