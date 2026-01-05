package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class COPS_orderSummaryLocatorsFsus {

    public By searchBox = By.xpath("//input[@class='navSearchDirty']");
    public By searchButton = By.xpath("//cx-icon[@class=\"elxIconsSearch search cx-icon fas fa-search\"]");
    public By clickOnProductLink = By.xpath("//a[@class=\"text-decoration-none\"]");

    public By addToCart = By.xpath("//span[text()=' Add to cart ']");
    public By viewOrSaveCartButton = By.xpath("//a[normalize-space()='View cart']\n");
    public By proceedToCheckoutButton = By.xpath("//button[@class='proceedToCheckout btn btn-orange btn-block']");
    public By newAddress = By.xpath("//button[text()=\" Add New Address \"]");

    public By firstNameInput = By.xpath("//input[@id='firstName']");
    public By lastNameInput = By.xpath("//input[@id='lastName']");
    public By addressLine1Input = By.xpath("//input[@id='address-1']");
    public By addressTypeaheadOption = By.xpath("//button[@id='ngb-typeahead-0-1']");
    public By zipCodeInput = By.xpath("//input[@id='zipcode']");
    public By continueToDeliveryButton = By.xpath("//button[@name='continueToDeliveryButton']");
    public By saveAndContinueButton = By.xpath("//button[text()='Save & continue']");

    public By subtotalText(String text) {
        return By.xpath("//div[contains(normalize-space(), '" + text + "')]");
    }

    public By addOnServices = By.xpath("//p[text()=\"Add-on Service\"]");
    public By addOnServiceSelect = By.xpath("//div[text()=\" Haul away / dispose old appliance \"]//parent::div//parent::div[@class=\"d-flex\"]//div[@class=\"pb-2 d-block align-items-center flex-basis-50\"]//input");
    public By protectionPlansSelect = By.xpath("//div[text()=\"1 year\"]");

}
