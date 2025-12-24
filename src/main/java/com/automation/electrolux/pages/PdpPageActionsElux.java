package com.automation.electrolux.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import org.openqa.selenium.WebElement;

import com.automation.electrolux.locators.PDPLocatorsElux;
import com.automation.utils.BrowserUtils;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

public class PdpPageActionsElux {

    PDPLocatorsElux pdpPage_Locator = new PDPLocatorsElux();

    public boolean isProductIdMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.productIdOnPDP);
        String actualId = WebElementUtil.getText(pdpPage_Locator.productIdOnPDP).trim();
        String expectedId = PlpPageActionsElux.getSelectedProductId().trim();
        return actualId.equalsIgnoreCase(expectedId);
    }

    public boolean isProductTitleMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.productTitleOnPDP);
        String actualTitle = WebElementUtil.getText(pdpPage_Locator.productTitleOnPDP).trim();
        String expectedTitle = PlpPageActionsElux.getSelectedProductTitle().trim();
        return actualTitle.toLowerCase().contains(expectedTitle.toLowerCase());
    }

    public boolean isProductPriceMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.productPriceOnPDP);
        String actualPrice = WebElementUtil.getText(pdpPage_Locator.productPriceOnPDP).trim();
        actualPrice = actualPrice.replaceAll("\\.\\d+$", "");
        String expectedPrice = PlpPageActionsElux.getSelectedProductPrice().trim();
        expectedPrice = expectedPrice.replaceAll("(\\.00|00)$", "");
        return actualPrice.equalsIgnoreCase(expectedPrice);
    }

    public boolean isProductColorVisibleOnPDP() {
        WebElementUtil.isDisplayed(pdpPage_Locator.productColorOnPDP);
        return true;
    }

    public PdpPageActionsElux clickQuickSpec() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.overViewAndFeatures);
        WebElementUtil.clickElement(pdpPage_Locator.quickSpecificationBtnOnPDP);
        return this;
    }

    public boolean isKeySpecificationHeadingVisibleOnPDP() {
        WaitUtils.untilVisible(pdpPage_Locator.keySpecificationHeading);
        WebElementUtil.isDisplayed(pdpPage_Locator.keySpecificationHeading);
        return true;
    }

    public boolean isHeightVisibleOnPDP() {
        WaitUtils.untilVisible(pdpPage_Locator.pdpHeight);
        WebElementUtil.isDisplayed(pdpPage_Locator.pdpHeight);
        return true;
    }

    public boolean isWidthVisibleOnPDP() {
        WaitUtils.untilVisible(pdpPage_Locator.pdpWidth);
        WebElementUtil.isDisplayed(pdpPage_Locator.pdpWidth);
        return true;
    }

    public boolean isDepthisibleOnPDP() {
        WaitUtils.untilVisible(pdpPage_Locator.pdpDepth);
        WebElementUtil.isDisplayed(pdpPage_Locator.pdpDepth);
        return true;
    }

    public boolean isAdditionalKeySpecTextVisibleOnPDP() {
        WaitUtils.untilVisible(pdpPage_Locator.additionalKeySpecText);
        WebElementUtil.isDisplayed(pdpPage_Locator.additionalKeySpecText);
        return true;
    }

    public boolean isGeneralSpecTextVisibleOnPDP() {
        WaitUtils.untilVisible(pdpPage_Locator.generalSpecText);
        WebElementUtil.isDisplayed(pdpPage_Locator.generalSpecText);
        return true;
    }

    public PdpPageActionsElux clickViewFullSpecButton() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.generalSpecText);
        WebElementUtil.clickElement(pdpPage_Locator.viewFullSpecBtn);
        return this;
    }

    public boolean isSpecTextVisibleOnPDP() {
        WaitUtils.untilVisible(pdpPage_Locator.specificationText);
        WebElementUtil.isDisplayed(pdpPage_Locator.specificationText);
        return true;
    }

    public PdpPageActionsElux clickCloseSpecModel() {
        WebElementUtil.clickElement(pdpPage_Locator.closeModelButton);
        return this;
    }

    public PdpPageActionsElux clickDownloadFullSpec() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.keySpecificationHeading);
        WebElementUtil.clickElement(pdpPage_Locator.fullSpecDownload);
        return this;
    }

    public boolean isFullProductSpecMatchedTheProductId() {
        String parentWindow = BrowserUtils.switchToNewWindow();

        String pdfUrl = DriverManager.getDriver().getCurrentUrl();
        String fileName = pdfUrl.substring(pdfUrl.lastIndexOf('/') + 1);
        String productCode = fileName.split("_")[0];

        String expectedProductId = PlpPageActionsElux.getSelectedProductId().trim();

        return expectedProductId.contains(productCode);
    }

    public boolean isProvidedProductIdMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.selectedProductId);
        String actualId = WebElementUtil.getText(pdpPage_Locator.selectedProductId).trim();
        String expectedId = HomePageActionsElux.getProvidedProductId().trim();
        return actualId.equalsIgnoreCase(expectedId);
    }

    public boolean isProvidedProductTitleMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.selectedProductName);
        String actualId = WebElementUtil.getText(pdpPage_Locator.selectedProductName).trim();
        String expectedId = HomePageActionsElux.getProvidedProductTitle().trim();
        return actualId.equalsIgnoreCase(expectedId);
    }

    public boolean isProvidedProductPriceMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.selectedProductPrice);
        String actualPrice = WebElementUtil.getText(pdpPage_Locator.selectedProductPrice).trim();
        actualPrice = actualPrice.replaceAll("\\.\\d+$", "");
        String expectedPrice = HomePageActionsElux.getProvidedProductPrice().trim();
        expectedPrice = expectedPrice.replaceAll("(\\.00|00)$", "");
        return actualPrice.equalsIgnoreCase(expectedPrice);
    }

    public DeliveryAndServicePageActionsElux clickAddToCartButton() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.addToCartButton);
        WebElementUtil.clickElement(pdpPage_Locator.addToCartButton);
        return new DeliveryAndServicePageActionsElux();
    }
    
    public PdpPageActionsElux closePopupModel() {

        try {
            WaitUtils.untilVisible(pdpPage_Locator.closePopupButton, 20);
            WebElement closeBtn = untilClickable(pdpPage_Locator.closePopupButton, 20);
            if (closeBtn != null) {
                closeBtn.click();
            }
        } catch (Exception ignored) {

        }
        return this;
    }

}
