package com.automation.frigidaire.locators;

import org.openqa.selenium.By;

public class OutOfStockLocatorsFrig {

    public final By emailPopUp = By.xpath("//span[@id=\"close-modal123\"]");
    public final By earliestDelivery = By.xpath("//span[contains(text(), 'Earliest delivery:') or contains(text(),'In stock!')]");
    public final By addToCart = By.xpath("//span[normalize-space()='Add to cart']");
    public final By outOfStock = By.xpath("//span[contains(text(), 'Temporarily out of stock in your area.')]");
    public final By emailField = By.xpath("//div[@id='container_EMAIL']//input[@name='Email']");
    public final By notifyButton = By.xpath("//div[@id='container_EMAIL']//input[@name='submitBtn']");
    public final By notifyVerify = By.xpath("//span[contains(text(), 'You’re signed up')]");

}
