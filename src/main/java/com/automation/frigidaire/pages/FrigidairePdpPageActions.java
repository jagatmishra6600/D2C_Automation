package com.automation.frigidaire.pages;

import com.automation.frigidaire.utils.BrowserUtils;
import com.automation.frigidaire.utils.DriverManager;
import com.automation.frigidaire.utils.WaitUtils;
import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.By;

public class FrigidairePdpPageActions {

    private final By productIdOnPDP = By.xpath("//h2[contains(@class, 'prod_id')] | //p[contains(@class, 'prod_id')]");
    private final By productTitleOnPDP = By.xpath("//h2[contains(@class, 'prod_id')]/preceding-sibling::h1 | //p[contains(@class, 'prod_name Product-title')]");
    private final By productPriceOnPDP = By.xpath("//span[contains(@class, 'Utility-TextPrice-Sale-Lrg')] | //span[contains(@class, 'H3H3_Desktop ')]");
    private final By productReviewNumberOnPDP = By.xpath("(//div[contains(@class, 'numReviews')]/div)[1]");
    private final By productColorOnPDP = By.xpath("//div[@id='color'] | //span[@class='colorHeading']");
    private final By pdpHeight = By.xpath("//p[contains(text(),'Height')]/span[2] | //div[normalize-space(text())='Height']");
    private final By pdpWidth = By.xpath("//p[contains(text(),'Width')]/span[2] | //div[normalize-space(text())='Width']");
    private final By pdpDepth = By.xpath("//p[contains(text(),'Depth')]/span[2] | //div[normalize-space(text())='Depth']");
    private final By quickSpecificationBtnOnPDP = By.xpath("//strong[text()='Quick Specs']/../../../following-sibling::div/span/span | //span[text()='Specs']");
    private final By quickSpecSeeAll = By.xpath("//p[text()='See all']");
    private final By overViewAndFeatures = By.xpath("//strong[text()='Overview & Features'] | //span[text()='Overview']");
    private final By keySpecificationHeading = By.xpath("//h2[text()='Key specifications']");
    private final By additionalKeySpecText = By.xpath("//h3[text()='Additional specifications']");
    private final By generalSpecText = By.xpath("//h4[text()='General Specifications']");
    private final By fullSpecDownload = By.xpath("//a[text()=' Download Full Product Specs Sheet ']");
    private final By viewFullSpecBtn = By.xpath("//button[text()='View full specs']");
    private final By specificationText = By.xpath("//h3[text()='Specifications']");
    private final By closeModelButton = By.xpath("//h3[text()='Specifications']/following-sibling::img");




    public boolean isProductIdMatchingWithPLP() {
        WaitUtils.untilVisible(productIdOnPDP);
        String actualId = WebElementUtil.getText(productIdOnPDP).trim();
        String expectedId = FrigidairePlpPageActions.getSelectedProductId().trim();
        return actualId.equalsIgnoreCase(expectedId);
    }

    public boolean isProductTitleMatchingWithPLP() {
        WaitUtils.untilVisible(productTitleOnPDP);
        String actualTitle = WebElementUtil.getText(productTitleOnPDP).trim();
        String expectedTitle = FrigidairePlpPageActions.getSelectedProductTitle().trim();
        return actualTitle.toLowerCase().contains(expectedTitle.toLowerCase());
    }

    public boolean isProductPriceMatchingWithPLP() {
        WaitUtils.untilVisible(productPriceOnPDP);
        String actualPrice = WebElementUtil.getText(productPriceOnPDP).trim();
        actualPrice = actualPrice.replaceAll("\\.\\d+$", "");
        String expectedPrice = FrigidairePlpPageActions.getSelectedProductPrice().trim();
        expectedPrice = expectedPrice.replaceAll("(\\.00|00)$", "");
        return actualPrice.equalsIgnoreCase(expectedPrice);
    }

    public boolean isProductReviewMatchingWithPLP() {
        WaitUtils.untilVisible(productReviewNumberOnPDP);
        String actualReview = WebElementUtil.getText(productReviewNumberOnPDP).trim();
        String expectedReview = FrigidairePlpPageActions.getSelectedProductReviewNumber().trim();
        return actualReview.equalsIgnoreCase(expectedReview);
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

    public boolean isKeySpecificationHeadingVisibleOnPDP() {
        WaitUtils.untilVisible(keySpecificationHeading);
        WebElementUtil.isDisplayed(keySpecificationHeading);
        return true;
    }

    public boolean isHeightVisibleOnPDP() {
        WaitUtils.untilVisible(pdpHeight);
        WebElementUtil.isDisplayed(pdpHeight);
        return true;
    }

    public boolean isWidthVisibleOnPDP() {
        WaitUtils.untilVisible(pdpWidth);
        WebElementUtil.isDisplayed(pdpWidth);
        return true;
    }

    public boolean isDepthisibleOnPDP() {
        WaitUtils.untilVisible(pdpDepth);
        WebElementUtil.isDisplayed(pdpDepth);
        return true;
    }

    public boolean isAdditionalKeySpecTextVisibleOnPDP() {
        WaitUtils.untilVisible(additionalKeySpecText);
        WebElementUtil.isDisplayed(additionalKeySpecText);
        return true;
    }

    public boolean isGeneralSpecTextVisibleOnPDP() {
        WaitUtils.untilVisible(generalSpecText);
        WebElementUtil.isDisplayed(generalSpecText);
        return true;
    }

    public FrigidairePdpPageActions clickViewFullSpecButton() {
        WebElementUtil.scrollIntoView(viewFullSpecBtn);
        WebElementUtil.clickElement(viewFullSpecBtn);
        return this;
    }

    public boolean isSpecTextVisibleOnPDP() {
        WaitUtils.untilVisible(specificationText);
        WebElementUtil.isDisplayed(specificationText);
        return true;
    }

    public FrigidairePdpPageActions clickCloseSpecModel() {
        WebElementUtil.clickElement(closeModelButton);
        return this;
    }

    public FrigidairePdpPageActions clickDownloadFullSpec() {
        WebElementUtil.scrollIntoView(keySpecificationHeading,50);
        WebElementUtil.clickElement(fullSpecDownload);
        return this;
    }

    public boolean isFullProductSpecMatchedTheProductId() {
        String parentWindow = BrowserUtils.switchToNewWindow();

        String pdfUrl = DriverManager.getDriver().getCurrentUrl();
        String fileName = pdfUrl.substring(pdfUrl.lastIndexOf('/') + 1);
        String productCode = fileName.split("_")[0];

        String expectedProductId = FrigidairePlpPageActions.getSelectedProductId().trim();

        return expectedProductId.contains(productCode);
    }

}