package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class OutOfStockLocatorsElux {

    public static final By emailPopUp = By.xpath("//span[@id=\"close-modal123\"]");
    public static final By freeDelivery = By.xpath("//p[contains(normalize-space(.), \"Free delivery\")]\n");
    public static final By earliestDelivery = By.xpath("//p[contains(text(), 'Earliest delivery')]");
    public static final By addToCart = By.xpath("//span[normalize-space()='Add to cart']");
    public static final By outOfStock = By.xpath("//span[contains(text(), 'Temporarily out of stock in your area.')]");
    public static final By emailField = By.xpath("//div[@id='container_EMAIL']//input[@name='Email']");
    public static final By notify = By.xpath("//div[@id='container_EMAIL']//input[@name='submitBtn']");
    public static final By notifyVerify = By.xpath("//span[contains(text(), 'You’re signed up')]");
}
