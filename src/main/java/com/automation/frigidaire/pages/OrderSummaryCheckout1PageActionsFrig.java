package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.OrderSummaryForCheckOutPage1Frig;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

public class OrderSummaryCheckout1PageActionsFrig {

    OrderSummaryForCheckOutPage1Frig orderSummary =new OrderSummaryForCheckOutPage1Frig();

    public boolean isOrderSummaryTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.isDisplayed(orderSummary.orderSummaryText);
        String actualText =  WebElementUtil.getText(orderSummary.orderSummaryText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isSubtotalTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(orderSummary.subtotalText);
        WebElementUtil.isDisplayed(orderSummary.subtotalText);
        String actualText =  WebElementUtil.getText(orderSummary.subtotalText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isSubtotalPriceVisible() {
        WebElementUtil.scrollToElementCenter(orderSummary.subtotalPrice);
        return WebElementUtil.isDisplayed(orderSummary.subtotalPrice);
    }

    public boolean isInstallationPartTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(orderSummary.installationPartsText);
        WebElementUtil.isDisplayed(orderSummary.installationPartsText);
        String actualText =  WebElementUtil.getText(orderSummary.installationPartsText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isInstallationPriceVisible() {
        WebElementUtil.scrollToElementCenter(orderSummary.installationPartsPrice);
        return WebElementUtil.isDisplayed(orderSummary.installationPartsPrice);
    }

    public boolean isTotalTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(orderSummary.totalText);
        WebElementUtil.isDisplayed(orderSummary.totalText);
        String actualText =  WebElementUtil.getText(orderSummary.totalText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isTotalPriceVisible() {
        WebElementUtil.scrollToElementCenter(orderSummary.totalPrice);
        return WebElementUtil.isDisplayed(orderSummary.totalPrice);
    }

    public boolean isPromoCodeTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(orderSummary.promoCodeText);
        WebElementUtil.isDisplayed(orderSummary.promoCodeText);
        String actualText =  WebElementUtil.getText(orderSummary.promoCodeText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public ShippingAddressPageActionsFrig clickProceedToCheckOutButton() {
        WebElementUtil.scrollIntoView(orderSummary.proceedToCheckOutButton);
        WebElementUtil.clickElement(orderSummary.proceedToCheckOutButton);
        return new ShippingAddressPageActionsFrig();
    }

    public OrderSummaryCheckout1PageActionsFrig clickEmptyCartButton() {
        WebElementUtil.scrollToElementCenter(orderSummary.emptyCartButton);
        WebElementUtil.clickElement(orderSummary.emptyCartButton);
        WebElementUtil.clickElement(orderSummary.confirmButton);
        return this;
    }

    public boolean isYourCartEmptyTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(orderSummary.yourCartIsEmptyText);
        WebElementUtil.isDisplayed(orderSummary.yourCartIsEmptyText);
        String actualText =  WebElementUtil.getText(orderSummary.yourCartIsEmptyText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public OrderSummaryCheckout1PageActionsFrig clickRemoveFromCartButton() {
        WebElementUtil.scrollToElementCenter(orderSummary.productRemoveCloseButton);
        WebElementUtil.clickElement(orderSummary.productRemoveCloseButton);
        WebElementUtil.clickElement(orderSummary.removeButton);
        WebElementUtil.isDisplayed(orderSummary.yourCartIsEmptyText);
        return this;
    }
}
