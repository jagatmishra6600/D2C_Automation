package com.automation.familystoreus.pages;

import com.automation.familystoreus.locators.CartPageLocator_FSUS;
import com.automation.utils.WebElementUtil;

public class CartPageAction_FSUS {

    CartPageLocator_FSUS cartPage_Locator = new CartPageLocator_FSUS();

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


    public CartPageAction_FSUS clickProceedToCheckOutButton() {
        WebElementUtil.clickElement(cartPage_Locator.proceedToCheckOutButton);
        return this;
    }

    public CartPageAction_FSUS clickEmptyCartButton() {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.emptyCartButton);
        WebElementUtil.clickElement(cartPage_Locator.emptyCartButton);
        return this;
    }

    public boolean isYourCartEmptyTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.yourCartIsEmptyText);
        WebElementUtil.isDisplayed(cartPage_Locator.yourCartIsEmptyText);
        String actualText =  WebElementUtil.getText(cartPage_Locator.yourCartIsEmptyText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public CartPageAction_FSUS clickRemoveFromCartButton() {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.productRemoveCloseButton);
        WebElementUtil.clickElement(cartPage_Locator.productRemoveCloseButton);
        WebElementUtil.isDisplayed(cartPage_Locator.yourCartIsEmptyText);
        return this;
    }


}
