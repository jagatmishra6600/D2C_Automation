package com.automation.electrolux.locators;

import org.openqa.selenium.By;


public class DeliveryDatesLocatorsElux {
    public final By searchBox = By.xpath("//input[@aria-label=\"search\"]");
    public final By productPDP = By.xpath("//div[contains(@class,'Appliance-Card')]  | //div[contains(@class,'accessories-product')]//div[contains(@class,'Product-Name')]");
    public final By addToCartButton = By.xpath("//span[normalize-space()='Add to cart']/ancestor::button | //span[normalize-space()='Add to cart']/ancestor::a");
    public final By viewCartButton = By.xpath("//a[normalize-space()='View cart'] | //button[normalize-space()='Save and view cart']");
    public final By deliveryInstallationRadio = By.id("Refrigerators_Large_WaterLine_Install");
    public final By saveAndViewCartButton = By.xpath("//button[normalize-space()='Save and view cart']");
    public final By proceedToCheckoutButton = By.xpath("//button[normalize-space()='Proceed To Checkout']");
    public final By continueToDeliveryButton = By.id("continueToDeliveryButton");
    public final By shippingAddressForm = By.xpath("//span[text()='Shipping address']");
    public final By shippingEmail = By.id("email");
    public final By shippingFirstName = By.id("firstName");
    public final By shippingLastName = By.id("lastName");
    public final By shippingAddressLine1 = By.xpath("//input[@formcontrolname='line1' or @id='address-1' or contains(@placeholder,'Address')]");
    public final By shippingPhone = By.id("phone");
    public final By addressSuggestionOption = By.xpath("//ngb-typeahead-window//button[@role='option']");
    public final By deliveryCalendarHeader = By.xpath("//p[contains(text(),'Delivery and installation items')]");
    public final By deliveryDateAvailable = By.cssSelector("cx-delivery-label avaliableDates");

}
