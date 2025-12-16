package com.automation.electrolux.pages;

import com.automation.electrolux.locators.CartLocatorsElux;
import com.automation.utils.WebElementUtil;

public class CartPageActionsElux {

    CartLocatorsElux cartPage_Locator = new CartLocatorsElux();

    public boolean isOrderSummaryTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.isDisplayed(cartPage_Locator.orderSummaryText);
        String actualText =  WebElementUtil.getText(cartPage_Locator.orderSummaryText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isSubtotalTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.subtotalText);
        WebElementUtil.isDisplayed(cartPage_Locator.subtotalText);
        String actualText =  WebElementUtil.getText(cartPage_Locator.subtotalText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isSubtotalPriceVisible() {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.subtotalPrice);
        return WebElementUtil.isDisplayed(cartPage_Locator.subtotalPrice);
    }

    public boolean isHomeDeliveryTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.homeDeliveryText);
        WebElementUtil.isDisplayed(cartPage_Locator.homeDeliveryText);
        String actualText =  WebElementUtil.getText(cartPage_Locator.homeDeliveryText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isHomeDeliveryPriceVisible() {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.homeDeliveryPrice);
        return WebElementUtil.isDisplayed(cartPage_Locator.homeDeliveryPrice);
    }

    public boolean isInstallationPartTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.installationPartsText);
        WebElementUtil.isDisplayed(cartPage_Locator.installationPartsText);
        String actualText =  WebElementUtil.getText(cartPage_Locator.installationPartsText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isInstallationPriceVisible() {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.installationPartsPrice);
        return WebElementUtil.isDisplayed(cartPage_Locator.installationPartsPrice);
    }

    public boolean isTotalTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.totalText);
        WebElementUtil.isDisplayed(cartPage_Locator.totalText);
        String actualText =  WebElementUtil.getText(cartPage_Locator.totalText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isTotalPriceVisible() {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.totalPrice);
        return WebElementUtil.isDisplayed(cartPage_Locator.totalPrice);
    }

    public boolean isPromoCodeTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.promoCodeText);
        WebElementUtil.isDisplayed(cartPage_Locator.promoCodeText);
        String actualText =  WebElementUtil.getText(cartPage_Locator.promoCodeText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public CartPageActionsElux clickProceedToCheckOutButton() {
        WebElementUtil.clickElement(cartPage_Locator.proceedToCheckOutButton);
        return this;
    }
}
