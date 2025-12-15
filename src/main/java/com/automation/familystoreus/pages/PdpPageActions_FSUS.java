package com.automation.familystoreus.pages;

import com.automation.electrolux.locators.EL_PDP;
import com.automation.electrolux.pages.DeliveryAndServicePageActionElux;
import com.automation.electrolux.pages.ElectroluxHomePageActions;
import com.automation.familystoreus.locators.ProductDetailsPageLocator_FSUS;
import com.automation.frigidaire.pages.FrigidairePlpPageActions;
import com.automation.utils.BrowserUtils;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

public class PdpPageActions_FSUS {

    ProductDetailsPageLocator_FSUS pdpPage_Locator = new ProductDetailsPageLocator_FSUS();

    public boolean isProductIdMatchingWithPLP() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.productIdOnPDP);
        WaitUtils.untilVisible(pdpPage_Locator.productIdOnPDP);
        String actualId = WebElementUtil.getText(pdpPage_Locator.productIdOnPDP).trim();
        String expectedId = PlpPageActions_FSUS.getSelectedProductId().trim();
        return actualId.equalsIgnoreCase(expectedId);
    }

    public boolean isProductTitleMatchingWithPLP() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.productTitleOnPDP);
        WaitUtils.untilVisible(pdpPage_Locator.productTitleOnPDP);
        String actualTitle = WebElementUtil.getText(pdpPage_Locator.productTitleOnPDP).trim();
        String expectedTitle = PlpPageActions_FSUS.getSelectedProductTitle().trim();
        return actualTitle.toLowerCase().contains(expectedTitle.toLowerCase());
    }

    public boolean isProductPriceMatchingWithPLP() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.productPriceOnPDP);
        WaitUtils.untilVisible(pdpPage_Locator.productPriceOnPDP);
        String actualPrice = WebElementUtil.getText(pdpPage_Locator.productPriceOnPDP).trim();
        actualPrice = actualPrice.replaceAll("\\.\\d+$", "");
        String expectedPrice = PlpPageActions_FSUS.getSelectedProductPrice().trim();
        expectedPrice = expectedPrice.replaceAll("(\\.00|00)$", "");
        return actualPrice.equalsIgnoreCase(expectedPrice);
    }

    public boolean isProductColorVisibleOnPDP() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.productColorOnPDP);
        WebElementUtil.isDisplayed(pdpPage_Locator.productColorOnPDP);
        return true;
    }

    public PdpPageActions_FSUS clickSpec() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.quickSpecificationBtnOnPDP);
        WebElementUtil.clickElement(pdpPage_Locator.quickSpecificationBtnOnPDP);
        return this;
    }

    public boolean isKeySpecificationHeadingVisibleOnPDP() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.keySpecificationHeading);
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
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.additionalKeySpecText);
        WaitUtils.untilVisible(pdpPage_Locator.additionalKeySpecText);
        WebElementUtil.isDisplayed(pdpPage_Locator.additionalKeySpecText);
        return true;
    }

    public boolean isGeneralSpecTextVisibleOnPDP() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.generalSpecText);
        WaitUtils.untilVisible(pdpPage_Locator.generalSpecText);
        WebElementUtil.isDisplayed(pdpPage_Locator.generalSpecText);
        return true;
    }

    public PdpPageActions_FSUS clickViewFullSpecButton() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.viewFullSpecBtn);
        WebElementUtil.clickElement(pdpPage_Locator.viewFullSpecBtn);
        return this;
    }

    public boolean isSpecTextVisibleOnPDP() {
        WaitUtils.untilVisible(pdpPage_Locator.specificationText);
        WebElementUtil.isDisplayed(pdpPage_Locator.specificationText);
        return true;
    }

    public PdpPageActions_FSUS clickCloseSpecModel() {
        WebElementUtil.clickElement(pdpPage_Locator.closeModelButton);
        return this;
    }

    public PdpPageActions_FSUS clickDownloadFullSpec() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.fullSpecDownload);
        WebElementUtil.clickElement(pdpPage_Locator.fullSpecDownload);
        return this;
    }

    public boolean isFullProductSpecMatchedTheProductId() {
        String parentWindow = BrowserUtils.switchToNewWindow();

        String pdfUrl = DriverManager.getDriver().getCurrentUrl();
        String fileName = pdfUrl.substring(pdfUrl.lastIndexOf('/') + 1);
        String productCode = fileName.split("_")[0];

        String expectedProductId = PlpPageActions_FSUS.getSelectedProductId().trim();

        return expectedProductId.contains(productCode);
    }


    public DeliveryAndServicePageAction_FSUS clickAddToCartButton() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.addToCartButton);
        WebElementUtil.clickElement(pdpPage_Locator.addToCartButton);
        return new DeliveryAndServicePageAction_FSUS();
    }

    public boolean isHeightMatchingWithPLP() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.pdpHeight);
        WaitUtils.untilVisible(pdpPage_Locator.pdpHeight);

        String actualHeight = WebElementUtil.getText(pdpPage_Locator.pdpHeight).trim();
        String expectedHeight = FrigidairePlpPageActions.getSelectedHeight().trim();

        return actualHeight.equalsIgnoreCase(expectedHeight);
    }

    public boolean iswidthMatchingWithPLP() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.pdpWidth);
        WaitUtils.untilVisible(pdpPage_Locator.pdpWidth);

        String actualWidth = WebElementUtil.getText(pdpPage_Locator.pdpWidth).trim();
        String expectedWidth = FrigidairePlpPageActions.getSelectedWidth().trim();

        return actualWidth.equalsIgnoreCase(expectedWidth);
    }

    public boolean isDepthMatchingWithPLP() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.pdpDepth);
        WaitUtils.untilVisible(pdpPage_Locator.pdpDepth);

        String actualDepth = WebElementUtil.getText(pdpPage_Locator.pdpDepth).trim();
        String expectedDepth = FrigidairePlpPageActions.getSelectedDepth().trim();

        return actualDepth.equalsIgnoreCase(expectedDepth);
    }

}
