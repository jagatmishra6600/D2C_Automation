package com.automation.frigidaire.locators;

import org.openqa.selenium.By;

public class DandSLocatorsFrig {
    public final By itemAddedToCartText = By.xpath("//span[text()='Item added to cart']");
    public final By productTitleText = By.xpath("//p[contains(@class, 'product-title')]");
    public final By productIdText = By.xpath("//p[contains(@class, 'product-title')]//..//following-sibling::p");
    public final By productPriceText = By.xpath("//span[contains(@class, 'TextPrice')]");
    public final By optionToReceiveOrderText = By.xpath("//h3[contains(@class,'card-title')]");
    public final By deliveryOptionBox = By.xpath("//div[text()='Delivery']/parent::div");
    public final By deliveryAndServiceSectionHeading = By.xpath("//h3[text()='Delivery & installation services']");
    public final By totalPrice = By.xpath("//div[normalize-space(text())='Total']/following-sibling::div");
    public final By deliveryOnlyOption = By.xpath("//div[normalize-space(text())='Delivery only (No Install)']/parent::div/preceding-sibling::div//input");
    public final By deliveryOnlyOptionPrice = By.xpath("//div[normalize-space(text())='Delivery only (No Install)']/../following-sibling::div//div[contains(@class, 'priceFree')]//span");
    public final By requireInstallationPartsText = By.xpath("//p[text()='Required installation parts']");
    public final By partCheckBox = By.xpath("//input[@id='912001026']");
    public final By partPrice = By.xpath("//input[@id='912001026']//..//following-sibling::div[@id='dnsPrice']");
    public final By deliveryAndInstallationOption = By.xpath("//div[normalize-space(text())='Delivery & installation']/parent::div/preceding-sibling::div//input");
    public final By deliveryAndInstallationOptionPrice = By.xpath("//div[normalize-space(text())='Delivery & installation']/../following-sibling::div//div[contains(@class, 'priceFree')]//span");
    public final By additionalDetailsLink = By.xpath("//a[@aria-label='delivery-installation-modal-open-button']");
    public final By addtionalDetailsPopUpText = By.xpath("//ngb-modal-window//span[contains(normalize-space(),'Delivery & appliance install')]");
    public final By popupcloseButton = By.xpath("//ngb-modal-window//button[@aria-label='Close']");
    public final By addonServiceHeading = By.xpath("//p[text()='Add-on services']");
    public final By haulAwayPrice =  By.xpath("//div[normalize-space(text())='Haul away / dispose old appliance']/../following-sibling::div/span");
    public final By haulAwayCheckBox = By.xpath("//div[normalize-space(text())='Haul away / dispose old appliance']/../preceding-sibling::div//input");
    public final By moveOldUnitPrice =  By.xpath("//div[normalize-space(text())='Move old unit to another room']/../following-sibling::div/span");
    public final By moveOldUnitCheckBox = By.xpath("//div[normalize-space(text())='Move old unit to another room']/../preceding-sibling::div//input");
    public final By protectionPlanHeading = By.xpath("//h3[normalize-space(text())='Select a protection plan']");
    public final By declineProtection = By.xpath("//div[contains(@class, 'decline')]//label");
    public final By oneYearPlanPrice =  By.xpath("//span[text()='1 year']/../../../../../following-sibling::div/div[2]");
    public final By oneYearCheckBox = By.xpath("//span[text()='1 year']/../parent::label");
    public final By threeYearsPlanPrice = By.xpath("//span[text()='3 years']/../../../../../following-sibling::div/div[3]");
    public final By threeYearsCheckBox = By.xpath("//span[text()='3 years']/../parent::label");
    public final By fiveYearsPlanPrice = By.xpath("//span[text()='5 years']/../../../../../following-sibling::div/div[4]");
    public final By fiveYearsCheckBox = By.xpath("//span[text()='5 years']/../parent::label");
    public final By saveAndViewCartButton = By.xpath("//button[normalize-space(text())='Save and view cart']");
    public final By inStorePickUpCheckBox = By.xpath("//div[text()='In-store Pickup']");
    public final By inStorePickUpHeading = By.xpath("//div[text()='In-store Pickup at Best Buy']");




}
