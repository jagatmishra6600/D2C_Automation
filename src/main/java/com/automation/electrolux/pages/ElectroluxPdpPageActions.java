package com.automation.electrolux.pages;

import com.automation.electrolux.locators.EL_PDP;
import com.automation.utils.BrowserUtils;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;

public class ElectroluxPdpPageActions {

    EL_PDP pdpPage_Locator = new EL_PDP();

    public boolean isProductIdMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.productIdOnPDP);
        String actualId = WebElementUtil.getText(pdpPage_Locator.productIdOnPDP).trim();
        String expectedId = ElectroluxPlpPageActions.getSelectedProductId().trim();
        return actualId.equalsIgnoreCase(expectedId);
    }

    public boolean isProductTitleMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.productTitleOnPDP);
        String actualTitle = WebElementUtil.getText(pdpPage_Locator.productTitleOnPDP).trim();
        String expectedTitle = ElectroluxPlpPageActions.getSelectedProductTitle().trim();
        return actualTitle.toLowerCase().contains(expectedTitle.toLowerCase());
    }

    public boolean isProductPriceMatchingWithPLP() {
        WaitUtils.untilVisible(pdpPage_Locator.productPriceOnPDP);
        String actualPrice = WebElementUtil.getText(pdpPage_Locator.productPriceOnPDP).trim();
        actualPrice = actualPrice.replaceAll("\\.\\d+$", "");
        String expectedPrice = ElectroluxPlpPageActions.getSelectedProductPrice().trim();
        expectedPrice = expectedPrice.replaceAll("(\\.00|00)$", "");
        return actualPrice.equalsIgnoreCase(expectedPrice);
    }

    public boolean isProductColorVisibleOnPDP() {
        WebElementUtil.isDisplayed(pdpPage_Locator.productColorOnPDP);
        return true;
    }

    public ElectroluxPdpPageActions clickQuickSpec() {
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

    public ElectroluxPdpPageActions clickViewFullSpecButton() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.generalSpecText);
        WebElementUtil.clickElement(pdpPage_Locator.viewFullSpecBtn);
        return this;
    }

    public boolean isSpecTextVisibleOnPDP() {
        WaitUtils.untilVisible(pdpPage_Locator.specificationText);
        WebElementUtil.isDisplayed(pdpPage_Locator.specificationText);
        return true;
    }

    public ElectroluxPdpPageActions clickCloseSpecModel() {
        WebElementUtil.clickElement(pdpPage_Locator.closeModelButton);
        return this;
    }

    public ElectroluxPdpPageActions clickDownloadFullSpec() {
        WebElementUtil.scrollToElementCenter(pdpPage_Locator.keySpecificationHeading);
        WebElementUtil.clickElement(pdpPage_Locator.fullSpecDownload);
        return this;
    }

    public boolean isFullProductSpecMatchedTheProductId() {
        String parentWindow = BrowserUtils.switchToNewWindow();

        String pdfUrl = DriverManager.getDriver().getCurrentUrl();
        String fileName = pdfUrl.substring(pdfUrl.lastIndexOf('/') + 1);
        String productCode = fileName.split("_")[0];

        String expectedProductId = ElectroluxPlpPageActions.getSelectedProductId().trim();

        return expectedProductId.contains(productCode);
    }

}
