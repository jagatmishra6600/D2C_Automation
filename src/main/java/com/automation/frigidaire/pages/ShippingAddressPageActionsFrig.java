package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.ShippingAddressLocatorsFrig;
import com.automation.utils.*;

import static com.automation.utils.WaitUtils.*;
import static com.automation.utils.WebElementUtil.*;

public class ShippingAddressPageActionsFrig {

    ShippingAddressLocatorsFrig shipping_Locator = new ShippingAddressLocatorsFrig();

    public boolean isLoginSectionDisplayed() {
        return isDisplayed(shipping_Locator.loginSection);
    }

    public String getAlreadyHaveAccountMessage() {
        isDisplayed(shipping_Locator.alreadyHaveAccountMessage);
        return getText(shipping_Locator.alreadyHaveAccountMessage);
    }

    public String getFasterCheckoutLoginMessage() {
        isDisplayed(shipping_Locator.fasterCheckoutLoginMessage);
        return getText(shipping_Locator.fasterCheckoutLoginMessage);
    }

    public boolean isLoginButtonDisplayed() {
        return isDisplayed(shipping_Locator.loginButton);
    }

    public AccountLoginPageComponentActionsFrig clickLoginButton() {
        scrollIntoView(shipping_Locator.loginButton);
        clickElement(shipping_Locator.loginButton);
        return new AccountLoginPageComponentActionsFrig();
    }

    public String getWelcomeBackGreetingMessage() {
        isDisplayed(shipping_Locator.welcomeBackGreetingMessage);
        return getText(shipping_Locator.welcomeBackGreetingMessage);
    }

    public boolean isLogoutLinkDisplayed() {
        return isDisplayed(shipping_Locator.logoutLink);
    }


    public void verifyShippingDetails(String email, String FirstName, String LastName, String City, String State, String phoneNumber, String ZipCode, String adressLine1) throws InterruptedException {
        waitForElementToBeVisible(shipping_Locator.SHPPING_ADRESS_POINT_ONE);
        isDisplayed(shipping_Locator.SHPPING_ADRESS_POINT_ONE);
        waitForElementToBeVisible(shipping_Locator.SHIPPING_ADRESS_HEADING);
        isDisplayed(shipping_Locator.SHIPPING_ADRESS_HEADING);
        scrollToElementStable(shipping_Locator.CONTINUE_TO_DELIVERY_DISABLE_BTN);
        waitForElementToBeVisible(shipping_Locator.CONTINUE_TO_DELIVERY_DISABLE_BTN);
        isDisplayed(shipping_Locator.CONTINUE_TO_DELIVERY_DISABLE_BTN);
        scrollToElementStable(shipping_Locator.SHIPPING_ADRESS_HEADING);
        waitForElementToBeVisible(shipping_Locator.EMAIL_ADDRESS_TXT_FIELD);
        isDisplayed(shipping_Locator.EMAIL_ADDRESS_TXT_FIELD);
        WebElementUtil.sendKeys(shipping_Locator.EMAIL_ADDRESS_TXT_FIELD, email);
        waitForElementToBeVisible(shipping_Locator.FIRST_NAME);
        sendKeys(shipping_Locator.FIRST_NAME, FirstName);
        waitForElementToBeVisible(shipping_Locator.LAST_NAME);
        sendKeys(shipping_Locator.LAST_NAME, LastName);
        scrollToElementStable(shipping_Locator.MANUALLY_ENTER_ADDRESS_LINK);
        waitForElementToBeClickable(shipping_Locator.MANUALLY_ENTER_ADDRESS_LINK);
        clickElement(shipping_Locator.MANUALLY_ENTER_ADDRESS_LINK);
        waitForElementToBeVisible(shipping_Locator.ADRESS_LINE1);
        isDisplayed(shipping_Locator.ADRESS_LINE1);
        sendKeys(shipping_Locator.ADRESS_LINE1, adressLine1);
        waitForElementToBeVisible(shipping_Locator.ADRESS_LINE2);
        isDisplayed(shipping_Locator.ADRESS_LINE2);
        waitForElementToBeVisible(shipping_Locator.CITY);
        isDisplayed(shipping_Locator.CITY);
        sendKeys(shipping_Locator.CITY, City);
        scrollToElementStable(shipping_Locator.STATE);
        waitForElementToBeClickable(shipping_Locator.STATE);
        isDisplayed(shipping_Locator.STATE);
        clickElement(shipping_Locator.STATE_TXTFIELD);
        sendKeys(shipping_Locator.STATE_TXTFIELD, State);
        clickElement(shipping_Locator.selectState(State));
        waitForElementToBeVisible(shipping_Locator.ZIPCODE);
        sendKeys(shipping_Locator.ZIPCODE, ZipCode);
        scrollToElementStable(shipping_Locator.PHONE_NUMBER);
        waitForElementToBeVisible(shipping_Locator.PHONE_NUMBER);
        sendKeys(shipping_Locator.PHONE_NUMBER, phoneNumber);
        Thread.sleep(4000);
        waitForElementToBeVisible(shipping_Locator.CONTINUE_TO_DELIVERY_BTN);
        clickElement(shipping_Locator.CONTINUE_TO_DELIVERY_BTN);


    }


}
