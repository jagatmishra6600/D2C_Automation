package com.automation.frigidaire.pages;

import com.automation.frigidaire.utils.WaitUtils;
import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.By;

public class FrigidairePdpPageActions {

    private final By productIdOnPDP = By.xpath("//h2[contains(@class, 'prod_id')]");
    private final By productTitleOnPDP = By.xpath("//h2[contains(@class, 'prod_id')]/preceding-sibling::h1");
    private final By productPriceOnPDP = By.xpath("//span[contains(@class, 'Utility-TextPrice-Sale-Lrg')]");
    private final By productReviewNumberOnPDP = By.xpath("(//div[contains(@class, 'numReviews')]/div)[1]");
    private final By productColorOnPDP = By.xpath("//div[@id='color']");
    private final By pdpHeight = By.xpath("//p[contains(text(),'Height')]/span[2]");
    private final By pdpWidth = By.xpath("//p[contains(text(),'Width')]/span[2]");
    private final By pdpDepth = By.xpath("//p[contains(text(),'Depth')]/span[2]");
    private final By quickSpecificationBtnOnPDP = By.xpath("//strong[text()='Quick Specs']/../../../following-sibling::div/span/span");
    private final By quickSpecSeeAll = By.xpath("//p[text()='See all']");
    private final By overViewAndFeatures = By.xpath("//strong[text()='Overview & Features']");


    public boolean isProductIdMatchingWithPLP() {
        WaitUtils.untilVisible(productIdOnPDP);
        String actualTitle = WebElementUtil.getText(productIdOnPDP).trim();
        String expectedTitle = FrigidairePlpPageActions.getSelectedProductId().trim();
        return actualTitle.equalsIgnoreCase(expectedTitle);
    }

    public boolean isProductTitleMatchingWithPLP() {
        WaitUtils.untilVisible(productTitleOnPDP);
        String actualTitle = WebElementUtil.getText(productTitleOnPDP).trim();
        String expectedTitle = FrigidairePlpPageActions.getSelectedProductTitle().trim();
        return actualTitle.toLowerCase().contains(expectedTitle.toLowerCase());
    }

    public boolean isProductPriceMatchingWithPLP() {
        WaitUtils.untilVisible(productPriceOnPDP);
        String actualTitle = WebElementUtil.getText(productPriceOnPDP).trim();
        String expectedTitle = FrigidairePlpPageActions.getSelectedProductPrice().trim();
        return actualTitle.equalsIgnoreCase(expectedTitle);
    }

    public boolean isProductReviewMatchingWithPLP() {
        WaitUtils.untilVisible(productReviewNumberOnPDP);
        String actualTitle = WebElementUtil.getText(productReviewNumberOnPDP).trim();
        String expectedTitle = FrigidairePlpPageActions.getSelectedProductReviewNumber().trim();
        return actualTitle.equalsIgnoreCase(expectedTitle);
    }

    public boolean isProductColorVisibleOnPDP() {
        WebElementUtil.isDisplayed(productColorOnPDP);
        return true;
    }

    public FrigidairePdpPageActions clickQuickSpec() {
        WebElementUtil.scrollIntoView(overViewAndFeatures);
        WebElementUtil.clickElement(quickSpecificationBtnOnPDP);
        return this;
    }

    public boolean isSeeAllVisibleInQuickSpec() {
        WebElementUtil.isDisplayed(quickSpecSeeAll);
        return true;
    }

    public boolean isHeightMatchingWithPLP() {
        WaitUtils.untilVisible(pdpHeight);

        String actualHeight = WebElementUtil.getText(pdpHeight).trim();
        String expectedHeight = FrigidairePlpPageActions.getSelectedHeight().trim();

        return actualHeight.equalsIgnoreCase(expectedHeight);
    }

    public boolean iswidthMatchingWithPLP() {
        WaitUtils.untilVisible(pdpWidth);

        String actualWidth = WebElementUtil.getText(pdpWidth).trim();
        String expectedWidth = FrigidairePlpPageActions.getSelectedWidth().trim();

        return actualWidth.equalsIgnoreCase(expectedWidth);
    }

    public boolean isDepthMatchingWithPLP() {
        WaitUtils.untilVisible(pdpDepth);

        String actualDepth = WebElementUtil.getText(pdpDepth).trim();
        String expectedDepth = FrigidairePlpPageActions.getSelectedDepth().trim();

        return actualDepth.equalsIgnoreCase(expectedDepth);
    }

}