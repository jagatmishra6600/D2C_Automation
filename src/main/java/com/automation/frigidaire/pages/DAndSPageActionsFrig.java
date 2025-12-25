package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.CartLocatorsFrig;
import com.automation.frigidaire.locators.DandSLocatorsFrig;

import org.openqa.selenium.By;
import org.testng.Assert;

import static com.automation.utils.WebElementUtil.*;
import static com.automation.utils.WaitUtils.*;

public class DAndSPageActionsFrig {

    DandSLocatorsFrig dandsPage_Locator = new DandSLocatorsFrig();
    CartLocatorsFrig cartPage_Locator = new CartLocatorsFrig();

    public boolean isItemAddedToCartVisibleOnDnSPage(String expectedText) {
        isDisplayed(dandsPage_Locator.itemAddedToCartText);
        String actualText =  getText(dandsPage_Locator.itemAddedToCartText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isProductIdMatchingWithPLP() {
        untilVisible(dandsPage_Locator.productIdText);
        String actualTitle = getText(dandsPage_Locator.productIdText).trim();
        String expectedTitle = PlpPageActionsFrig.getProvidedProductId().trim();
        return actualTitle.toLowerCase().contains(expectedTitle.toLowerCase());
    }

    public boolean isProductTitleMatchingWithPLP() {
        untilVisible(dandsPage_Locator.productTitleText);
        String actualTitle = getText(dandsPage_Locator.productTitleText).trim();
        String expectedTitle = PlpPageActionsFrig.getProvidedProductTitle().trim();
        return actualTitle.toLowerCase().contains(expectedTitle.toLowerCase());
    }

    public boolean isProductPriceMatchingWithPLP() {
        untilVisible(dandsPage_Locator.productPriceText);
        String actualPrice = getText(dandsPage_Locator.productPriceText).trim();
        actualPrice = actualPrice.replaceAll("\\.\\d+$", "");
        String expectedPrice = PlpPageActionsFrig.getProvidedProductPrice().trim();
        expectedPrice = expectedPrice.replaceAll("(\\.00|00)$", "");
        return actualPrice.equalsIgnoreCase(expectedPrice);
    }

    public boolean isOptionToReceiveTheOrderTextVisibleAndCorrect(String expectedText) {
        isDisplayed(dandsPage_Locator.optionToReceiveOrderText);
        String actualText =  getText(dandsPage_Locator.optionToReceiveOrderText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean validateDeliveryOptionIsSelected(String expectedClassName){
        String actualClassName = getAttributeValue(dandsPage_Locator.deliveryOptionBox, "class");
        return actualClassName.toLowerCase().contains(expectedClassName.toLowerCase());
    }

    public boolean isDeliveryAndServicesTextVisibleAndCorrect(String expectedText) {
        isDisplayed(dandsPage_Locator.deliveryAndServiceSectionHeading);
        String actualText =  getText(dandsPage_Locator.deliveryAndServiceSectionHeading).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean clickDeliveryOnlyAndCheckTheUpdatedTotalPrice() {

        String deliveryText = getText(dandsPage_Locator.deliveryOnlyOptionPrice).trim();
        float deliveryPrice = deliveryText.equalsIgnoreCase("Free")
                ? 0
                : converStringToFloat(deliveryText);

        float startingTotal = getPrice(dandsPage_Locator.totalPrice);

        scrollToElementCenter(dandsPage_Locator.deliveryOnlyOption);

        clickElement(dandsPage_Locator.deliveryOnlyOption);

        float afterClickTotal = getPrice(dandsPage_Locator.totalPrice);

        return afterClickTotal == startingTotal + deliveryPrice;
    }

    public boolean isRequireInstallationPartsTextVisibleAndCorrect(String expectedText) {
        scrollToElementCenter(dandsPage_Locator.deliveryOnlyOption);
        clickElement(dandsPage_Locator.deliveryOnlyOption);
        scrollToElementCenter(dandsPage_Locator.requireInstallationPartsText);
        isDisplayed(dandsPage_Locator.requireInstallationPartsText);
        String actualText =  getText(dandsPage_Locator.requireInstallationPartsText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean clickPartAndCheckTheUpdatedTotalPrice() {

        scrollToElementCenter(dandsPage_Locator.deliveryOnlyOption);
        clickElement(dandsPage_Locator.deliveryOnlyOption);

        actionMethod(dandsPage_Locator.partPrice,dandsPage_Locator.totalPrice, dandsPage_Locator.partCheckBox, dandsPage_Locator.partPriceOrderSummary, dandsPage_Locator.partCheckBox);
        return true;
    }

    public boolean clickDeliveryAndInstallationAndCheckTheUpdatedTotalPrice() {

        String deliveryText = getText(dandsPage_Locator.deliveryAndInstallationOptionPrice).trim();
        float deliveryAndInstallationPrice = deliveryText.equalsIgnoreCase("Free")
                ? 0
                : converStringToFloat(deliveryText);

        float startingTotal = getPrice(dandsPage_Locator.totalPrice);

        scrollToElementCenter(dandsPage_Locator.deliveryAndInstallationOption);

        clickElement(dandsPage_Locator.deliveryAndInstallationOption);

        scrollToElementCenter(dandsPage_Locator.totalPrice);

        float afterClickTotal = getPrice(dandsPage_Locator.totalPrice);

        return afterClickTotal == startingTotal + deliveryAndInstallationPrice;
    }

    public DAndSPageActionsFrig clickAdditionalDetailsLink() {
        scrollToElementCenter(dandsPage_Locator.deliveryAndInstallationOption);
        clickElement(dandsPage_Locator.deliveryAndInstallationOption);
        clickElement(dandsPage_Locator.additionalDetailsLink);
        return this;
    }

    public boolean isAdditionalDetailsTextVisibleAndCorrect(String expectedText) {
        isDisplayed(dandsPage_Locator.addtionalDetailsPopUpText);
        String actualText =  getText(dandsPage_Locator.addtionalDetailsPopUpText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public DAndSPageActionsFrig clickCloseButtonAdditionalDetails() {
        clickElement(dandsPage_Locator.popupcloseButton);
        return this;
    }

    public boolean isAddonServicesTextVisibleAndCorrect(String expectedText) {
        isDisplayed(dandsPage_Locator.addonServiceHeading);
        String actualText =  getText(dandsPage_Locator.addonServiceHeading).trim();
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
        scrollToElementCenter(dandsPage_Locator.protectionPlanHeading);
        isDisplayed(dandsPage_Locator.protectionPlanHeading);
        String actualText =  getText(dandsPage_Locator.protectionPlanHeading).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean validateDeclineOptionIsSelected(String expectedClassName){
        scrollToElementCenter(dandsPage_Locator.declineProtection);
        String actualClassName = getAttributeValue(dandsPage_Locator.declineProtection, "class");
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
        clickElement(dandsPage_Locator.inStorePickUpCheckBox);
        return this;
    }

    public boolean isInstorePickUpTextVisibleAndCorrect(String expectedText) {
        scrollToElementCenter(dandsPage_Locator.inStorePickUpHeading);
        isDisplayed(dandsPage_Locator.inStorePickUpHeading);
        String actualText =  getText(dandsPage_Locator.inStorePickUpHeading).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public CartPageActionsFrig clickSaveAndViewCartButton() {
        for (int attempt = 1; attempt <= 2; attempt++) {
            clickElement(dandsPage_Locator.saveAndViewCartButton);

            if (isCartPageLoaded()) {
                return new CartPageActionsFrig();
            }
        }
    	return new CartPageActionsFrig();
    }

    public boolean actionMethod(By elementPriceLocator, By totalPriceLocator, By elementCheckBoxLocator, By orderSummaryLocator, By defaultCheckBox) {

        scrollToElementCenter(elementPriceLocator);
        String price = getText(elementPriceLocator).trim();
        float finalPrice = price.equalsIgnoreCase("Free")
                ? 0
                : converStringToFloat(price);

        float startingTotal = getPrice(totalPriceLocator);

        scrollToElementCenter(elementCheckBoxLocator);

        clickElement(elementCheckBoxLocator);

        scrollToElementCenter(totalPriceLocator);

        float afterClickTotal = getPrice(totalPriceLocator);

        String priceOrderSummary = getText(orderSummaryLocator).trim();

        float finalOrderSummaryPrice = priceOrderSummary.equalsIgnoreCase("Free")
                ? 0
                : converStringToFloat(priceOrderSummary);

        Assert.assertEquals(finalPrice, finalOrderSummaryPrice, "Both the price doesn't matched");

        scrollToElementCenter(defaultCheckBox);
        forceClick(defaultCheckBox);

        return afterClickTotal == startingTotal + finalPrice;
    }
    
    private boolean isCartPageLoaded() {
    	return isDisplayed(cartPage_Locator.proceedToCheckOutButton);
    }

}
