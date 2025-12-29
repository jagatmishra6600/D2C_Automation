package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.FEDEX_AITLocatorsFrig;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

public class FEDEX_AITPageActionsFrig {

    FEDEX_AITLocatorsFrig fedexAit = new FEDEX_AITLocatorsFrig();


    public void searchProducts(String skuNumber){
        WaitUtils.sleep(3000);
        WaitUtils.waitForPageLoad();
        WebElementUtil.waitForElementToBeVisible(fedexAit.searchBoxs, 10);
        WebElementUtil.sendKeys(fedexAit.searchBoxs, skuNumber);

        WaitUtils.sleep(3000);
        WebElementUtil.waitForElementToBeClickable(fedexAit.searchButton,10);
        WebElementUtil.clickElement(fedexAit.searchButton);

        WaitUtils.sleep(3000);
        WebElementUtil.scrollToElementStable(fedexAit.productLink(skuNumber));
        WebElementUtil.waitForElementToBeVisible(fedexAit.productLink(skuNumber), 10);
        WebElementUtil.waitForElementToBeClickable(fedexAit.productLink(skuNumber), 10);
        WebElementUtil.clickElement(fedexAit.productLink(skuNumber));
        WaitUtils.sleep(5000);
    }

    public void clickProduct(){

        WebElementUtil.zoomInOrOut(80);
        WaitUtils.sleep(3000);
        WebElementUtil.scrollToElementStable(fedexAit.addToCartButtons);
        WebElementUtil.waitForElementToBeVisible(fedexAit.addToCartButtons, 10);
        WebElementUtil.waitForElementToBeClickable(fedexAit.addToCartButtons, 10);
        WebElementUtil.clickElement(fedexAit.addToCartButtons);

        WaitUtils.sleep(5000);
        WaitUtils.waitForPageLoad();
        WebElementUtil.scrollToElementStable(fedexAit.saveAndViewCartButton);
        WebElementUtil.waitForElementToBeVisible(fedexAit.saveAndViewCartButton, 10);
        WebElementUtil.waitForElementToBeClickable(fedexAit.saveAndViewCartButton, 10);
        WebElementUtil.clickElement(fedexAit.saveAndViewCartButton);
        WaitUtils.sleep(3000);
    }
    public void checkoutPageFirst(){

        WaitUtils.sleep(5000);
        WebElementUtil.scrollToElementCenter(fedexAit.proceedToCheckoutButton);
        WebElementUtil.waitForElementToBeVisible(fedexAit.proceedToCheckoutButton, 10);
        WebElementUtil.waitForElementToBeClickable(fedexAit.proceedToCheckoutButton, 10);
        WebElementUtil.clickElement(fedexAit.proceedToCheckoutButton);

        WebElementUtil.waitForElementToBeVisible(fedexAit.secureCheckoutHeader, 10);
        WebElementUtil.isDisplayed(fedexAit.secureCheckoutHeader);

    }

    public void shippingAddress(String zipCode){

        WaitUtils.sleep(3000);
        WebElementUtil.scrollToElementStable(fedexAit.shippingAddressText);
        WebElementUtil.waitForElementToBeVisible(fedexAit.shippingAddressText, 10);

        WebElementUtil.waitForElementToBeVisible(fedexAit.emailInput, 10);
        WebElementUtil.sendKeys(fedexAit.emailInput, "demo@1gmail.com");

        WebElementUtil.waitForElementToBeVisible(fedexAit.firstNameInput, 10);
        WebElementUtil.sendKeys(fedexAit.firstNameInput, "test");

        WebElementUtil.waitForElementToBeVisible(fedexAit.lastNameInput, 10);
        WebElementUtil.sendKeys(fedexAit.lastNameInput, "tester");

        WebElementUtil.waitForElementToBeVisible(fedexAit.addressLine1Input, 10);
        WebElementUtil.sendKeys(fedexAit.addressLine1Input, zipCode);

        WebElementUtil.waitForElementToBeVisible(fedexAit.addressSuggestion, 5);
        WebElementUtil.clickElement(fedexAit.addressSuggestion);

        WebElementUtil.waitForElementToBeVisible(fedexAit.manualAddressLink, 5);
        WebElementUtil.clickElement(fedexAit.manualAddressLink);

        WaitUtils.sleep(3000);
        WebElementUtil.waitForElementToBeVisible(fedexAit.zipCodeInput, 10);
        WebElementUtil.sendKeys(fedexAit.zipCodeInput, zipCode);

        WebElementUtil.waitForElementToBeVisible(fedexAit.phoneInput, 10);
        WebElementUtil.sendKeys(fedexAit.phoneInput, "1234567890");

        WebElementUtil.scrollToElementStable(fedexAit.continueToDeliveryButton);
        WebElementUtil.waitForElementToBeVisible(fedexAit.continueToDeliveryButton, 10);
        WebElementUtil.waitForElementToBeClickable(fedexAit.continueToDeliveryButton, 10);
        WebElementUtil.clickElement(fedexAit.continueToDeliveryButton);

        WebElementUtil.waitForElementToBeVisible(fedexAit.saveAndContinue, 10);
        WebElementUtil.clickElement(fedexAit.saveAndContinue);

    }

    public void checkoutPageSecond(){

        WebElementUtil.waitForElementToBeVisible(fedexAit.deliveryOnlyItemsTitle,10);
        WebElementUtil.isDisplayed(fedexAit.deliveryOnlyItemsTitle);

        WebElementUtil.waitForElementToBeVisible(fedexAit.deliverToZipCode,10);
        WebElementUtil.isDisplayed(fedexAit.deliverToZipCode);

        WebElementUtil.waitForElementToBeVisible(fedexAit.deliveryMessage,10);
        WebElementUtil.isDisplayed(fedexAit.deliveryMessage);

        WebElementUtil.waitForElementToBeVisible(fedexAit.estimatedDeliveryDate,10);
        WebElementUtil.isDisplayed(fedexAit.estimatedDeliveryDate);

        WebElementUtil.waitForElementToBeVisible(fedexAit.deliveryCommentsTextBox,10);
        WebElementUtil.isDisplayed(fedexAit.deliveryCommentsTextBox);

    }
}

