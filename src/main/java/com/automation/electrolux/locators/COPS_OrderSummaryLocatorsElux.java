package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class COPS_OrderSummaryLocatorsElux {

    public By searchBoxs = By.xpath("//input[@placeholder='Search']");
    public By searchButton = By.xpath("//cx-icon[contains(@class,'elxIconsSearch')]");

    public By productNames = By.xpath("//div[contains(@class,'Product-title')]");
    public By accessoriesTab = By.xpath("//button[contains(text(), \"Accessories\")]");

    public By haulAwayServiceCheckbox = By.xpath("//div[normalize-space()='Haul away / dispose old appliance']/parent::div/parent::div//div[@id='serviceInputContainer']//input");
    public By declineProtectionPlan = By.xpath("//div[normalize-space()='1 year']/parent::div[contains(@class,'-years')]");
    public By addToCartButtons = By.xpath("//span[normalize-space()='Add to cart']");
    public By viewCartLink = By.xpath("//*[normalize-space(text())=\"Save and view cart\" or normalize-space(text())=\"View cart\"]\n");
    public By proceedtoCheckoutButton = By.xpath("//button[normalize-space()='Proceed To Checkout']");

    public By emailInput = By.xpath("//input[@id='email']");
    public By firstNameInput = By.xpath("//input[@id='firstName']");
    public By lastNameInput = By.xpath("//input[@id='lastName']");
    public By addressInput = By.xpath("//input[@id='address-1']");
    public By addressSuggest = By.xpath("//button[@id=\"ngb-typeahead-0-0\"]");
    public By manuallyEnterAddress = By.xpath("//a[text()=\"Manually enter address\"]");
    public By zipCode = By.xpath("//input[@id=\"zipcode\"]");
    public By phoneInput = By.xpath("//input[@id='phone']");
    public By continuetoDeliveryButton = By.xpath("//button[@id='continueToDeliveryButton']");
    public By continueAndSave = By.xpath("//button[text()=\"Save & continue\"]");

    public By subtotalTextVerify(String text) {
        return By.xpath("//div[contains(normalize-space(), '" + text + "')]");
    }

}
