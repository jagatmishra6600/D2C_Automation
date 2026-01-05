package com.automation.frigidaire.locators;

import org.openqa.selenium.By;

public class FEDEX_AITLocatorsFrig {


    public By searchBoxs = By.xpath("//input[@placeholder='Search...']");
    public By searchButton = By.xpath("//img[@class=\"elxIconsSearch search\"]");

    public By productLink(String productCode) {
        return By.xpath("//div[text()='" + productCode + "']//parent::div//following-sibling::div[@class='col- Product-Name my-2 min-height-v12']//a");}

    public By addToCartButtons = By.xpath("//span[normalize-space()='Add to cart']\n");
    public By saveAndViewCartButton = By.xpath("//a[normalize-space()='Save and view cart'] | //button[normalize-space()='Save and view cart']\n");
    public By proceedToCheckoutButton = By.xpath("//button[normalize-space()='Proceed to checkout']");

    public By secureCheckoutHeader = By.xpath("//h1[normalize-space()='Secure checkout']");
    public By shippingAddressText = By.xpath("//span[contains(normalize-space(),'Shipping address')]");
    public By emailInput = By.xpath("//input[@id='email']");
    public By firstNameInput = By.xpath("//input[@id='firstName']");
    public By lastNameInput = By.xpath("//input[@id='lastName']");
    public By addressLine1Input = By.xpath("//input[@id='address-1']");
    public By addressSuggestion = By.xpath("//button[@id='ngb-typeahead-0-0']");
    public By manualAddressLink = By.xpath("//a[normalize-space()='Manually enter address']");
    public By zipCodeInput = By.xpath("//input[@id='zipcode']");
    public By phoneInput = By.xpath("//input[@id='phone']");
    public By continueToDeliveryButton = By.xpath("//button[@id=\"continueToDeliveryButton\"]");

    public By saveAndContinue = By.xpath("//button[normalize-space()='Save & continue']");
    public By deliveryOnlyitems = By.xpath("//p[normalize-space()='Delivery Only Items']");

    public By deliveryOnlyItemsTitle = By.xpath("//p[contains(normalize-space(),'Delivery Only Items')]");
    public By deliverToZipCode = By.xpath("(//span[@class='Delivery-Installation-Policy Body-MediumBody_Medium ng-star-inserted'])[1]");
    public By deliveryMessage = By.xpath("(//span[@class='Delivery-Installation-Policy Body-MediumBody_Medium'])[1]");
    public By estimatedDeliveryDate = By.xpath("//span[contains(@class,'Delivery-Installation-Policy')]//b[contains(@class,'estimated_delivery-date')]");
    public By deliveryCommentsTextBox = By.xpath("//textarea[@placeholder=\"Enter special instructions for our delivery team.\"]");


}
