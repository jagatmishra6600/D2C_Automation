package com.automation.frigidaire.locators;

import org.openqa.selenium.By;

public class ShippingAddressLocatorsFrig {

    public static final By CONTINUE_TO_DELIVERY_BTN = By.xpath("//button[@id='continueToDeliveryButton' and @disabled]");
    public static final By SHIPPING_ADRESS_HEADING = By.xpath("//span[text()='Shipping address']");
    public static final By FIRST_NAME = By.xpath("//input[@placeholder='First name*']");
    public static final By LAST_NAME = By.xpath("//input[@placeholder='Last name*']");
    public static final By ADRESS_LINE1 = By.xpath("//input[@placeholder='Address line 1*']");
    public static final By ADRESS_LINE2 = By.xpath("//input[@placeholder='Address line 2 (optional)']");
    public static final By CITY = By.xpath("//input[@placeholder='City*']");
    public static final By STATE = By.xpath("//ng-select[@placeholder='State*']//span[@class='ng-arrow-wrapper']");
    public static final By ZIPCODE = By.xpath("//input[@id='zipcode']");







}
