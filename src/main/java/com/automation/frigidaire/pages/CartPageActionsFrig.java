package com.automation.frigidaire.pages;


import com.automation.frigidaire.locators.CartLocatorsFrig;
import com.automation.utils.WebElementUtil;

public class CartPageActionsFrig {

    CartLocatorsFrig cartPage_Locator = new CartLocatorsFrig();

    public boolean isOrderSummaryTextVisibleAndCorrect(String expectedText) {
        return false;
    }

    public boolean isSubtotalTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.subtotalText);
        WebElementUtil.isDisplayed(cartPage_Locator.subtotalText);
        String actualText = WebElementUtil.getText(cartPage_Locator.subtotalText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isSubtotalPriceVisible() {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.subtotalPrice);
        return WebElementUtil.isDisplayed(cartPage_Locator.subtotalPrice);
    }

    public boolean isInstallationPartTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.installationPartsText);
        WebElementUtil.isDisplayed(cartPage_Locator.installationPartsText);
        String actualText = WebElementUtil.getText(cartPage_Locator.installationPartsText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isInstallationPriceVisible() {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.installationPartsPrice);
        return WebElementUtil.isDisplayed(cartPage_Locator.installationPartsPrice);
    }

    public boolean isTotalTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.totalText);
        WebElementUtil.isDisplayed(cartPage_Locator.totalText);
        String actualText = WebElementUtil.getText(cartPage_Locator.totalText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public boolean isTotalPriceVisible() {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.totalPrice);
        return WebElementUtil.isDisplayed(cartPage_Locator.totalPrice);
    }

    public boolean isPromoCodeTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.promoCodeText);
        WebElementUtil.isDisplayed(cartPage_Locator.promoCodeText);
        String actualText = WebElementUtil.getText(cartPage_Locator.promoCodeText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public ShippingAddressPageActionsFrig clickProceedToCheckOutButton() {
        WebElementUtil.scrollIntoView(cartPage_Locator.proceedToCheckOutButton);
        WebElementUtil.clickElement(cartPage_Locator.proceedToCheckOutButton);
        return new ShippingAddressPageActionsFrig();
    }

    public CartPageActionsFrig clickEmptyCartButton() {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.emptyCartButton);
        WebElementUtil.clickElement(cartPage_Locator.emptyCartButton);
        WebElementUtil.clickElement(cartPage_Locator.confirmButton);
        return this;
    }

    public boolean isYourCartEmptyTextVisibleAndCorrect(String expectedText) {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.yourCartIsEmptyText);
        WebElementUtil.isDisplayed(cartPage_Locator.yourCartIsEmptyText);
        String actualText = WebElementUtil.getText(cartPage_Locator.yourCartIsEmptyText).trim();
        return actualText.toLowerCase().contains(expectedText.toLowerCase());
    }

    public CartPageActionsFrig clickRemoveFromCartButton() {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.productRemoveCloseButton);
        WebElementUtil.clickElement(cartPage_Locator.productRemoveCloseButton);
        WebElementUtil.clickElement(cartPage_Locator.removeButton);
        WebElementUtil.isDisplayed(cartPage_Locator.yourCartIsEmptyText);
        return this;
    }

    public boolean increaseQuantityAndValidateCount() {
        WebElementUtil.scrollToElementCenter(cartPage_Locator.productCount);
        float initialValue = WebElementUtil.getValueOfDom(cartPage_Locator.productCount);

        float expectedValue = initialValue;

        for (int i = 1; i <= 4; i++) {

            WebElementUtil.forceClick(cartPage_Locator.increaseButton);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            expectedValue += 1;

            float currentValue = WebElementUtil.getValueOfDom(cartPage_Locator.productCount);

            if (currentValue != expectedValue) {
                return false;
            }
        }

        return WebElementUtil.getValueOfDom(cartPage_Locator.productCount) == initialValue + 4;
    }

    public boolean decreaseQuantityAndValidateCount() {

        WebElementUtil.scrollToElementCenter(cartPage_Locator.productCount);
        float initialValue = WebElementUtil.getValueOfDom(cartPage_Locator.productCount);

        float expectedValue = initialValue;

        for (int i = 1; i <= 4; i++) {

            WebElementUtil.forceClick(cartPage_Locator.decreaseButton);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            expectedValue -= 1;

            float currentValue = WebElementUtil.getValueOfDom(cartPage_Locator.productCount);

            if (currentValue != expectedValue) {
                return false;
            }
        }

        return WebElementUtil.getValueOfDom(cartPage_Locator.productCount) == initialValue - 4;
    }


        public void clickOnPromoDropdown () {
            WebElementUtil.waitForElementToBeVisible(cartPage_Locator.promoDropdown, 40);
            WebElementUtil.scrollToElementCenter(cartPage_Locator.promoDropdown);
            WebElementUtil.clickElement(cartPage_Locator.promoDropdown);
        }

        public void applyPromoCode (String promoCode){
            WebElementUtil.waitForElementToBeVisible(cartPage_Locator.promoCodeInputField, 20);
            WebElementUtil.scrollToElementCenter(cartPage_Locator.promoCodeInputField);
            WebElementUtil.sendKeys(cartPage_Locator.promoCodeInputField, promoCode);

            WebElementUtil.waitForElementToBeClickable(cartPage_Locator.applyPromoCodeButton);
            WebElementUtil.clickElement(cartPage_Locator.applyPromoCodeButton);
        }

        public String getPromoErrorMessage () {
            WebElementUtil.waitForElementToBeVisible(cartPage_Locator.promoErrorMessage, 20);
            WebElementUtil.scrollToElementCenter(cartPage_Locator.promoErrorMessage);
            return WebElementUtil.getText(cartPage_Locator.promoErrorMessage);
        }
}



