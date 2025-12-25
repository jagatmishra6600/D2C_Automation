package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.OrderSummaryForCheckOutPage1Frig;

import static com.automation.utils.WebElementUtil.*;
import static com.automation.utils.WaitUtils.*;


public class OrderSummaryCheckout1PageActionsFrig {

    OrderSummaryForCheckOutPage1Frig orderSummary =new OrderSummaryForCheckOutPage1Frig();

    public boolean isOrderSummaryTextVisibleAndCorrect(String expectedText) {
        isDisplayed(orderSummary.orderSummaryText);
        String actualText =  getText(orderSummary.orderSummaryText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isSubtotalTextVisibleAndCorrect(String expectedText) {
        scrollToElementCenter(orderSummary.subtotalText);
        isDisplayed(orderSummary.subtotalText);
        String actualText =  getText(orderSummary.subtotalText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isSubtotalPriceVisible() {
        scrollToElementCenter(orderSummary.subtotalPrice);
        return isDisplayed(orderSummary.subtotalPrice);
    }

    public boolean isInstallationPartTextVisibleAndCorrect(String expectedText) {
        scrollToElementCenter(orderSummary.installationPartsText);
        isDisplayed(orderSummary.installationPartsText);
        String actualText =  getText(orderSummary.installationPartsText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isInstallationPriceVisible() {
        scrollToElementCenter(orderSummary.installationPartsPrice);
        return isDisplayed(orderSummary.installationPartsPrice);
    }

    public boolean isTotalTextVisibleAndCorrect(String expectedText) {
        scrollToElementCenter(orderSummary.totalText);
        isDisplayed(orderSummary.totalText);
        String actualText =  getText(orderSummary.totalText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isTotalPriceVisible() {
        scrollToElementCenter(orderSummary.totalPrice);
        return isDisplayed(orderSummary.totalPrice);
    }

    public boolean isPromoCodeTextVisibleAndCorrect(String expectedText) {
        scrollToElementCenter(orderSummary.promoCodeText);
        isDisplayed(orderSummary.promoCodeText);
        String actualText =  getText(orderSummary.promoCodeText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public ShippingAddressPageActionsFrig clickProceedToCheckOutButton() {
        scrollIntoView(orderSummary.proceedToCheckOutButton);
        clickElement(orderSummary.proceedToCheckOutButton);
        return new ShippingAddressPageActionsFrig();
    }

    public OrderSummaryCheckout1PageActionsFrig clickEmptyCartButton() {
        scrollToElementCenter(orderSummary.emptyCartButton);
        clickElement(orderSummary.emptyCartButton);
        clickElement(orderSummary.confirmButton);
        return this;
    }

    public boolean isYourCartEmptyTextVisibleAndCorrect(String expectedText) {
        scrollToElementCenter(orderSummary.yourCartIsEmptyText);
        isDisplayed(orderSummary.yourCartIsEmptyText);
        String actualText =  getText(orderSummary.yourCartIsEmptyText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public OrderSummaryCheckout1PageActionsFrig clickRemoveFromCartButton() {
        scrollToElementCenter(orderSummary.productRemoveCloseButton);
        clickElement(orderSummary.productRemoveCloseButton);
        clickElement(orderSummary.removeButton);
        isDisplayed(orderSummary.yourCartIsEmptyText);
        return this;
    }
}
