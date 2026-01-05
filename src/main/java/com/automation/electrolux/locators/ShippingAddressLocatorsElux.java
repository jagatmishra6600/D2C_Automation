package com.automation.electrolux.locators;
import org.openqa.selenium.By;

public class ShippingAddressLocatorsElux {
   public final By loginSection = By.cssSelector("shipping-address-cdc-login");
   public final By alreadyHaveAccountMessage = By.cssSelector("shipping-address-cdc-login h4");
   public final By fasterCheckoutLoginMessage = By.cssSelector("shipping-address-cdc-login span.loginMessage");
   public final By loginButton = By.xpath("//shipping-address-cdc-login//button[contains(.,'Log In')]");
   public final By welcomeBackGreetingMessage = By.xpath("//shipping-address-cdc-login//h5[contains(.,'Welcome back')]");
   public final By logoutLink = By.xpath("//a[contains(.,'Log out')]");





























    public final By SHPPING_ADRESS_POINT_ONE = By.xpath("//span[text()='Shipping address']");
    public final By EMAIL_ADDRESS_TXT_FIELD = By.xpath("//input[@id='email' or @name='email']");

    public final By MANUALLY_ENTER_ADDRESS_LINK = By.xpath("//a[text()='Manually enter address']");
    public final By CONTINUE_TO_DELIVERY_BTN=By.xpath("//span[normalize-space()='Continue to delivery']");
    public static final By CONTINUE_TO_DELIVERY_DISABLE_BTN = By.xpath("//button[@id='continueToDeliveryButton' and @disabled]");
    public static final By SHIPPING_ADRESS_HEADING = By.xpath("//span[text()='Shipping address']");
    public static final By FIRST_NAME = By.xpath("//input[@id='firstName' or @name='firstName']");
    public static final By LAST_NAME = By.xpath(" //input[@id='lastName' or @name='lastName']");
    public static final By ADRESS_LINE1 = By.xpath("//input[@placeholder='Address line 1*']");
    public static final By ADRESS_LINE2 = By.xpath("//input[@placeholder='Address line 2 (optional)']");
    public static final By CITY = By.xpath("//input[@placeholder='City*']");
    public static final By STATE = By.xpath("//ng-select[@placeholder='State*']//span[@class='ng-arrow-wrapper']");
    public static final By ZIPCODE = By.xpath("//input[@id='zipcode']");
    public static final By PHONE_NUMBER = By.xpath("//input[@id='phone']");
    public static final By STATE_TXTFIELD = By.xpath("//ng-select[@placeholder='State*']//div//input");
    public static final By SAVE_AND_CONTINUE_BTN = By.xpath("//button[text()='Save & continue']");
    public By selectState(String text) {
        return By.xpath(String.format("//span[text()='%s']", text));
    }



}
