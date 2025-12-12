package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.FE_DandS;
import com.automation.frigidaire.locators.FE_PDP;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FrigidaireDAndSPageActions {

    FE_DandS dandsPage_Locator = new FE_DandS();

    public boolean isItemAddedToCartVisibleOnDnSPage(String expectedText) {
        WebElementUtil.isDisplayed(dandsPage_Locator.itemAddedToCartText);
        String actualText =  WebElementUtil.getText(dandsPage_Locator.itemAddedToCartText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isProductIdMatchingWithPLP() {
        WaitUtils.untilVisible(dandsPage_Locator.productIdText);
        String actualTitle = WebElementUtil.getText(dandsPage_Locator.productIdText).trim();
        String expectedTitle = PlpPageActions_Frig.getProvidedProductId().trim();
        return actualTitle.toLowerCase().contains(expectedTitle.toLowerCase());
    }

    public boolean isProductTitleMatchingWithPLP() {
        WaitUtils.untilVisible(dandsPage_Locator.productTitleText);
        String actualTitle = WebElementUtil.getText(dandsPage_Locator.productTitleText).trim();
        String expectedTitle = PlpPageActions_Frig.getProvidedProductTitle().trim();
        return actualTitle.toLowerCase().contains(expectedTitle.toLowerCase());
    }

    public boolean isProductPriceMatchingWithPLP() {
        WaitUtils.untilVisible(dandsPage_Locator.productPriceText);
        String actualPrice = WebElementUtil.getText(dandsPage_Locator.productPriceText).trim();
        actualPrice = actualPrice.replaceAll("\\.\\d+$", "");
        String expectedPrice = PlpPageActions_Frig.getProvidedProductPrice().trim();
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
                : WebElementUtil.convertPriceToFloat(deliveryText);

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

        String deliveryText = WebElementUtil.getText(dandsPage_Locator.partPrice).trim();
        float partPrice = deliveryText.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.convertPriceToFloat(deliveryText);

        float startingTotal = WebElementUtil.getPrice(dandsPage_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.partCheckBox);

        WebElementUtil.clickElement(dandsPage_Locator.partCheckBox);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.totalPrice);

        float afterClickTotal = WebElementUtil.getPrice(dandsPage_Locator.totalPrice);

        WebElementUtil.clickElement(dandsPage_Locator.partCheckBox);

        return afterClickTotal == startingTotal + partPrice;
    }

    public boolean clickDeliveryAndInstallationAndCheckTheUpdatedTotalPrice() {

        String deliveryText = WebElementUtil.getText(dandsPage_Locator.deliveryAndInstallationOptionPrice).trim();
        float deliveryAndInstallationPrice = deliveryText.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.convertPriceToFloat(deliveryText);

        float startingTotal = WebElementUtil.getPrice(dandsPage_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.deliveryAndInstallationOption);

        WebElementUtil.clickElement(dandsPage_Locator.deliveryAndInstallationOption);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.totalPrice);

        float afterClickTotal = WebElementUtil.getPrice(dandsPage_Locator.totalPrice);

        return afterClickTotal == startingTotal + deliveryAndInstallationPrice;
    }

    public FrigidaireDAndSPageActions clickAdditionalDetailsLink() {
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

    public FrigidaireDAndSPageActions clickCloseButtonAdditionalDetails() {
        WebElementUtil.clickElement(dandsPage_Locator.popupcloseButton);
        return this;
    }

    public boolean isAddonServicesTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.isDisplayed(dandsPage_Locator.addonServiceHeading);
        String actualText =  WebElementUtil.getText(dandsPage_Locator.addonServiceHeading).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean clickHaulAwayCheckBoxAndCheckTheUpdatedTotalPrice() {

        String haulawayPrice = WebElementUtil.getText(dandsPage_Locator.haulAwayPrice).trim();
        float finalHaulAwayPrice = haulawayPrice.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.convertPriceToFloat(haulawayPrice);

        float startingTotal = WebElementUtil.getPrice(dandsPage_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.haulAwayCheckBox);

        WebElementUtil.clickElement(dandsPage_Locator.haulAwayCheckBox);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.totalPrice);

        float afterClickTotal = WebElementUtil.getPrice(dandsPage_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.haulAwayCheckBox);

        WebElementUtil.clickElement(dandsPage_Locator.haulAwayCheckBox);

        return afterClickTotal == startingTotal + finalHaulAwayPrice;
    }

    public boolean clickMoveOldUnitCheckBoxAndCheckTheUpdatedTotalPrice() {

        String moveOldUnitPrice = WebElementUtil.getText(dandsPage_Locator.moveOldUnitPrice).trim();
        float finalmoveOldUnitPricePrice = moveOldUnitPrice.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.convertPriceToFloat(moveOldUnitPrice);

        float startingTotal = WebElementUtil.getPrice(dandsPage_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.moveOldUnitCheckBox);

        WebElementUtil.clickElement(dandsPage_Locator.moveOldUnitCheckBox);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.totalPrice);

        float afterClickTotal = WebElementUtil.getPrice(dandsPage_Locator.totalPrice);

        return afterClickTotal == startingTotal + finalmoveOldUnitPricePrice;
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

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.oneYearPlanPrice);
        String oneYearPrice = WebElementUtil.getText(dandsPage_Locator.oneYearPlanPrice).trim();
        float finaloneYearPrice = oneYearPrice.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.convertPriceToFloat(oneYearPrice);

        float startingTotal = WebElementUtil.getPrice(dandsPage_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.oneYearCheckBox);

        WebElementUtil.clickElement(dandsPage_Locator.oneYearCheckBox);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.totalPrice);

        float afterClickTotal = WebElementUtil.getPrice(dandsPage_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.declineProtection);
        WebElementUtil.forceClick(dandsPage_Locator.declineProtection);

        return afterClickTotal == startingTotal + finaloneYearPrice;
    }

    public boolean clickThreeYearProtectionAndCheckTheUpdatedTotalPrice() {

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.threeYearsPlanPrice);
        String threeYearPrice = WebElementUtil.getText(dandsPage_Locator.threeYearsPlanPrice).trim();
        float finalthreeYearPrice = threeYearPrice.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.convertPriceToFloat(threeYearPrice);

        float startingTotal = WebElementUtil.getPrice(dandsPage_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.threeYearsCheckBox);

        WebElementUtil.clickElement(dandsPage_Locator.threeYearsCheckBox);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.totalPrice);

        float afterClickTotal = WebElementUtil.getPrice(dandsPage_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.declineProtection);
        WebElementUtil.forceClick(dandsPage_Locator.declineProtection);

        return afterClickTotal == startingTotal + finalthreeYearPrice;
    }

    public boolean clickFiveYearProtectionAndCheckTheUpdatedTotalPrice() {
        WebElementUtil.forceClick(dandsPage_Locator.declineProtection);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.fiveYearsPlanPrice);
        String fiveYearPrice = WebElementUtil.getText(dandsPage_Locator.fiveYearsPlanPrice).trim();
        float finalFiveYearPrice = fiveYearPrice.equalsIgnoreCase("Free")
                ? 0
                : WebElementUtil.convertPriceToFloat(fiveYearPrice);

        float startingTotal = WebElementUtil.getPrice(dandsPage_Locator.totalPrice);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.fiveYearsCheckBox);

        WebElementUtil.forceClick(dandsPage_Locator.fiveYearsCheckBox);

        WebElementUtil.scrollToElementCenter(dandsPage_Locator.totalPrice);

        float afterClickTotal = WebElementUtil.getPrice(dandsPage_Locator.totalPrice);

        return afterClickTotal == startingTotal + finalFiveYearPrice;
    }

    public FrigidaireDAndSPageActions clickInstorePickup() {
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
        WebElementUtil.scrollToElementCenter(dandsPage_Locator.saveAndViewCartButton);
        WebElementUtil.clickElement(dandsPage_Locator.saveAndViewCartButton);
        return new CartPageActionsFrig();
    }

}
