package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class PayPalLocatorsElux {

    public final By searchBox = By.xpath("//input[@aria-label=\"search\"]");
    public final By productPDP = By.xpath("//div[contains(@class,'Product-title')]");
    //    public final By productPDP = By.xpath("//div[contains(@class,'Appliance-Card')]  | //div[contains(@class,'accessories-product')]//div[contains(@class,'Product-Name')]"); //div[contains(@class,'Product-title')]
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
    public final By deliveryCalendarHeader = By.xpath("//div[contains(@class,'item-group--label-checkout') and contains(normalize-space(),'Delivery & installation items')]");
    public final By deliveryDateAvailable = By.xpath("//label[contains(@class,'cx-delivery-label') and not(contains(@class,'disabled'))]");

    public final By currentMonth = By.xpath("(//h2[contains(@class,'cx-month-year')]//span)[1]");
    public final By nextMonth = By.xpath("(//h2[contains(@class,'cx-month-year')]//span)[2]");
    public final By calender = By.cssSelector("div.cx-date-container");
    public final By deliveryComments = By.xpath("//textarea[@placeholder='Enter special instructions for our delivery team.']");
    public final By availableDates = By.cssSelector("cx-delivery-label avaliableDates");
    public final By continueToBillingButton = By.xpath("//button[normalize-space()='Continue to billing']");
    public final By selectableDates = By.xpath("//label[contains(@class,'cx-delivery-label') and not(contains(@class,'disabled'))]");
    public final By calDates = By.xpath("//input[@type='radio' and @formcontrolname='selectedSlot']");
    public final By orderItemHeadings = By.xpath("//div[contains(@class,'item-group--label-checkout')]/span");
    public final By homeDeliveryTitles = By.xpath("//div[contains(@class,'item-group--label-checkout')]/parent::div//following-sibling::div//a//p");
    public final By parcelDeliveryTitles = By.xpath("//div[contains(@class,'item-group--label-checkout')]//parent::div//following-sibling::div//cx-cart-item//div[contains(@class,'hideInPrint')]//a[@class='cx-link']");
    public final By parcelItemPrices = By.xpath("//div[@class='cx-item-list-items']//cx-cart-item//div[contains(@class,'hideInPrint')]//div[contains(@class,'pack-price-allign')]//p");
    public final By parcelItemImages = By.xpath("//div[@class='cx-item-list-items']//cx-cart-item//div[contains(@class,'hideInPrint')]//app-elux-image//img");
    public final By parcelSKU = By.xpath("//div[@class='cx-item-list-items']//div[contains(@class,'checkout-cart-block')]//div[contains(@class,'product-code')]");
    public final By parcelItemsColor = By.xpath("//div[@class='cx-item-list-items']//div[contains(@class,'checkout-cart-block')]//div[contains(@class,'product-color')]");
    public final By parcelItemsQty = By.xpath("//div[@class='cx-item-list-items']//div[contains(@class,'checkout-cart-block')]//p");
    public final By checkoutMessage = By.xpath("//div[contains(@class,'H4H4_Desktop')]");
    public final By continueBillingButton = By.xpath("//button[normalize-space()='Continue to billing']");
    public final By selectPayPayPal = By.xpath("//img[@alt='PayPal']//preceding-sibling::input");
    public final By payPalButton = By.xpath("//div[contains(@class,'adyen-checkout__paypal__button--paypal')]");

}
