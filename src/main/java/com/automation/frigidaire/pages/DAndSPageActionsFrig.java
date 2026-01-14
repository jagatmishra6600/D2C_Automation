package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.CartLocatorsFrig;
import com.automation.frigidaire.locators.DandSLocatorsFrig;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DAndSPageActionsFrig {

    DandSLocatorsFrig dandsPage_Locator = new DandSLocatorsFrig();
    CartLocatorsFrig cartPage_Locator = new CartLocatorsFrig();

    public boolean isItemAddedToCartVisibleOnDnSPage(String expectedText) {
        WebElementUtil.isDisplayed(dandsPage_Locator.itemAddedToCartText);
        String actualText =  WebElementUtil.getText(dandsPage_Locator.itemAddedToCartText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isProductIdMatchingWithPLP() {
        WaitUtils.untilVisible(dandsPage_Locator.productIdText);
        String actualTitle = WebElementUtil.getText(dandsPage_Locator.productIdText).trim();
        String expectedTitle = PlpPageActionsFrig.getProvidedProductId().trim();
        return actualTitle.toLowerCase().contains(expectedTitle.toLowerCase());
    }

    public boolean isProductTitleMatchingWithPLP() {
        WaitUtils.untilVisible(dandsPage_Locator.productTitleText);
        String actualTitle = WebElementUtil.getText(dandsPage_Locator.productTitleText).trim();
        String expectedTitle = PlpPageActionsFrig.getProvidedProductTitle().trim();
        return actualTitle.toLowerCase().contains(expectedTitle.toLowerCase());
    }

    public boolean isProductPriceMatchingWithPLP() {
        WaitUtils.untilVisible(dandsPage_Locator.productPriceText);
        String actualPrice = WebElementUtil.getText(dandsPage_Locator.productPriceText).trim();
        actualPrice = actualPrice.replaceAll("\\.\\d+$", "");
        String expectedPrice = PlpPageActionsFrig.getProvidedProductPrice().trim();
        expectedPrice = expectedPrice.replaceAll("(\\.00|00)$", "");
        return actualPrice.equalsIgnoreCase(expectedPrice);
    }

    public boolean isOptionToReceiveTheOrderTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.isDisplayed(dandsPage_Locator.optionToReceiveOrderText);
        String actualText =  WebElementUtil.getText(dandsPage_Locator.optionToReceiveOrderText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean validateDeliveryOptionIsSelected(String expectedClassName){
        String actualClassName = WebElementUtil.getAttributeValue(dandsPage_Locator.deliveryOptionBox, "class");
        return actualClassName.toLowerCase().contains(expectedClassName.toLowerCase());
    }

    public boolean isDeliveryAndServicesTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.isDisplayed(dandsPage_Locator.deliveryAndServiceSectionHeading);
        String actualText =  WebElementUtil.getText(dandsPage_Locator.deliveryAndServiceSectionHeading).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean clickDeliveryOnlyAndCheckTheUpdatedTotalPrice() {

        String deliveryText = WebElementUtil.getText(dandsPage_Locator.deliveryOnlyOptionPrice).trim();
        float deliveryPrice = deliveryText.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.converStringToFloat(deliveryText);

        float startingTotal = WebElementUtil.getPrice(dandsPage_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.deliveryOnlyOption);

        WebElementUtil.clickElement(dandsPage_Locator.deliveryOnlyOption);

        float afterClickTotal = WebElementUtil.getPrice(dandsPage_Locator.totalPrice);

        return afterClickTotal == startingTotal + deliveryPrice;
    }

    public boolean isRequireInstallationPartsTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(dandsPage_Locator.deliveryOnlyOption);
        WebElementUtil.clickElement(dandsPage_Locator.deliveryOnlyOption);
        WebElementUtil.scrollToElementCenter(dandsPage_Locator.requireInstallationPartsText);
        WebElementUtil.isDisplayed(dandsPage_Locator.requireInstallationPartsText);
        String actualText =  WebElementUtil.getText(dandsPage_Locator.requireInstallationPartsText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean clickPartAndCheckTheUpdatedTotalPrice() {

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.deliveryOnlyOption);
        WebElementUtil.clickElement(dandsPage_Locator.deliveryOnlyOption);

        actionMethod(dandsPage_Locator.partPrice,dandsPage_Locator.totalPrice, dandsPage_Locator.partCheckBox, dandsPage_Locator.partPriceOrderSummary, dandsPage_Locator.partCheckBox);
        return true;
    }

    public boolean clickDeliveryAndInstallationAndCheckTheUpdatedTotalPrice() {

        String deliveryText = WebElementUtil.getText(dandsPage_Locator.deliveryAndInstallationOptionPrice).trim();
        float deliveryAndInstallationPrice = deliveryText.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.converStringToFloat(deliveryText);

        float startingTotal = WebElementUtil.getPrice(dandsPage_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.deliveryAndInstallationOption);

        WebElementUtil.clickElement(dandsPage_Locator.deliveryAndInstallationOption);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.totalPrice);

        float afterClickTotal = WebElementUtil.getPrice(dandsPage_Locator.totalPrice);

        return afterClickTotal == startingTotal + deliveryAndInstallationPrice;
    }

    public DAndSPageActionsFrig clickAdditionalDetailsLink() {
        WebElementUtil.scrollToElementCenter(dandsPage_Locator.deliveryAndInstallationOption);
        WebElementUtil.clickElement(dandsPage_Locator.deliveryAndInstallationOption);
        WebElementUtil.clickElement(dandsPage_Locator.additionalDetailsLink);
        return this;
    }

    public boolean isAdditionalDetailsTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.isDisplayed(dandsPage_Locator.addtionalDetailsPopUpText);
        String actualText =  WebElementUtil.getText(dandsPage_Locator.addtionalDetailsPopUpText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public DAndSPageActionsFrig clickCloseButtonAdditionalDetails() {
        WebElementUtil.clickElement(dandsPage_Locator.popupcloseButton);
        return this;
    }

    public boolean isAddonServicesTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.isDisplayed(dandsPage_Locator.addonServiceHeading);
        String actualText =  WebElementUtil.getText(dandsPage_Locator.addonServiceHeading).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean clickHaulAwayCheckBoxAndCheckTheUpdatedTotalPrice() {
        actionMethod(dandsPage_Locator.haulAwayPrice, dandsPage_Locator.totalPrice, dandsPage_Locator.haulAwayCheckBox, dandsPage_Locator.addOnServicesPriceOrderSummary, dandsPage_Locator.haulAwayCheckBox);
        return true;
    }

    public boolean clickMoveOldUnitCheckBoxAndCheckTheUpdatedTotalPrice() {
        actionMethod(dandsPage_Locator.moveOldUnitPrice,dandsPage_Locator.totalPrice,dandsPage_Locator.moveOldUnitCheckBox, dandsPage_Locator.addOnServicesPriceOrderSummary, dandsPage_Locator.moveOldUnitCheckBox);
        return true;
    }


    public boolean isProtectionPlanTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(dandsPage_Locator.protectionPlanHeading);
        WebElementUtil.isDisplayed(dandsPage_Locator.protectionPlanHeading);
        String actualText =  WebElementUtil.getText(dandsPage_Locator.protectionPlanHeading).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean validateDeclineOptionIsSelected(String expectedClassName){
        WebElementUtil.scrollToElementCenter(dandsPage_Locator.declineProtection);
        String actualClassName = WebElementUtil.getAttributeValue(dandsPage_Locator.declineProtection, "class");
        return actualClassName.toLowerCase().contains(expectedClassName.toLowerCase());
    }

    public boolean clickOneYearProtectionAndCheckTheUpdatedTotalPrice() {
        actionMethod(dandsPage_Locator.oneYearPlanPrice,dandsPage_Locator.totalPrice, dandsPage_Locator.oneYearCheckBox, dandsPage_Locator.protectionPlanPriceOrderSummary, dandsPage_Locator.declineProtection);
        return true;
    }

    public boolean clickThreeYearProtectionAndCheckTheUpdatedTotalPrice() {
        actionMethod(dandsPage_Locator.threeYearsPlanPrice,dandsPage_Locator.totalPrice, dandsPage_Locator.threeYearsCheckBox, dandsPage_Locator.protectionPlanPriceOrderSummary, dandsPage_Locator.declineProtection);
        return true;
    }

    public boolean clickFiveYearProtectionAndCheckTheUpdatedTotalPrice() {
        actionMethod(dandsPage_Locator.fiveYearsPlanPrice,dandsPage_Locator.totalPrice, dandsPage_Locator.fiveYearsCheckBox, dandsPage_Locator.protectionPlanPriceOrderSummary, dandsPage_Locator.declineProtection);
        return true;
    }

    public DAndSPageActionsFrig clickInstorePickup() {
        WebElementUtil.clickElement(dandsPage_Locator.inStorePickUpCheckBox);
        return this;
    }

    public boolean isInstorePickUpTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(dandsPage_Locator.inStorePickUpHeading);
        WebElementUtil.isDisplayed(dandsPage_Locator.inStorePickUpHeading);
        String actualText =  WebElementUtil.getText(dandsPage_Locator.inStorePickUpHeading).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public CartPageActionsFrig clickSaveAndViewCartButton() {
    	WebElementUtil.isDisplayed(dandsPage_Locator.saveAndViewCartButton);
        for (int attempt = 1; attempt <= 2; attempt++) {
            WebElementUtil.clickElement(dandsPage_Locator.saveAndViewCartButton);

            if (isCartPageLoaded()) {
                return new CartPageActionsFrig();
            }
        }
    	return new CartPageActionsFrig();
    }

    public boolean actionMethod(By elementPriceLocator, By totalPriceLocator, By elementCheckBoxLocator, By orderSummaryLocator, By defaultCheckBox) {

        WebElementUtil.scrollToElementCenter(elementPriceLocator);
        String price = WebElementUtil.getText(elementPriceLocator).trim();
        float finalPrice = price.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.converStringToFloat(price);

        float startingTotal = WebElementUtil.getPrice(totalPriceLocator);

        WebElementUtil.scrollToElementCenter(elementCheckBoxLocator);

        WebElementUtil.clickElement(elementCheckBoxLocator);

        WebElementUtil.scrollToElementCenter(totalPriceLocator);

        float afterClickTotal = WebElementUtil.getPrice(totalPriceLocator);

        String priceOrderSummary = WebElementUtil.getText(orderSummaryLocator).trim();

        float finalOrderSummaryPrice = priceOrderSummary.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.converStringToFloat(priceOrderSummary);

        Assert.assertEquals(finalPrice, finalOrderSummaryPrice, "Both the price doesn't matched");

        WebElementUtil.scrollToElementCenter(defaultCheckBox);
        WebElementUtil.forceClick(defaultCheckBox);

        return afterClickTotal == startingTotal + finalPrice;
    }
    
    private boolean isCartPageLoaded() {
    	return WebElementUtil.isDisplayed(cartPage_Locator.proceedToCheckOutButton);
    }

}
