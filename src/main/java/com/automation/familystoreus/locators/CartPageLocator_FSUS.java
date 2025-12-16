package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class CartPageLocator_FSUS {

    public final By orderSummaryText = By.xpath("//h4[normalize-space(text())='Order summary']");
    public final By subtotalText = By.xpath("//div[normalize-space(text())='Subtotal']");
    public final By subtotalPrice = By.xpath("//div[normalize-space(text())='Subtotal']/following-sibling::div[contains(@class, 'summary-amount')]");
    public final By homeDeliveryText =  By.xpath("//div[normalize-space(text())='Home Delivery']");
    public final By homeDeliveryPrice = By.xpath("//div[normalize-space(text())='Home Delivery']/following-sibling::div[contains(@class, 'summary-amount')]");
    public final By totalText = By.xpath("//div[normalize-space(text())='Total']");
    public final By totalPrice = By.xpath("//div[normalize-space(text())='Total']/following-sibling::div[contains(@class, 'summary-amount')]");
    public final By proceedToCheckOutButton = By.xpath("(//button[normalize-space(text())='Proceed to checkout'])[2]");


}
