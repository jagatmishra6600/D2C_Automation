package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class DandSLocatorsElux {
    public final By pageHeading = By.xpath("//p[text()='Delivery, installation & service options']");
    public final By productTitle = By.xpath("//p[contains(@class, 'product-title')]");
    public final By productPrice = By.xpath("//div[contains(@class, 'product-price')]//span[1]");
    public final By deliverAndServicesHeading = By.xpath("//h3[text()='Delivery & installation services']");
    public final By totalPrice = By.xpath("//div[normalize-space(text())='Total']/following-sibling::div");
    public final By deliveryOnlyPrice =  By.xpath("//div[normalize-space(text())='Delivery only (No Install)']/../following-sibling::div");
    public final By deliveryOnlyCheckBox = By.xpath("//div[normalize-space(text())='Delivery only (No Install)']/../preceding-sibling::div//input");
    public final By requireInstallationPartsText = By.xpath("//p[text()='Required installation parts']");
    public final By partCheckBox = By.xpath("//input[@id='2SSFILHOSE']");
    public final By partPrice = By.xpath("//input[@id='2SSFILHOSE']//..//following-sibling::div//span");
    public final By professionalInstallationPrice =  By.xpath("//div[normalize-space(text())='Professional Installation']/../following-sibling::div");
    public final By professionalInstallationCheckBox = By.xpath("//div[normalize-space(text())='Professional Installation']/../preceding-sibling::div//input");
    public final By additionalDetailsLink = By.xpath("//cx-page-slot//a[@aria-label='delivery-installation-modal-open-button']");
    public final By deliveryAndAppliancesInstallText =  By.xpath("//ngb-modal-window//span[text()='Delivery & Appliance Install']");
    public final By closePopUpButton = By.xpath("//ngb-modal-window//button[@aria-label='Close']");
    public final By addOnServiceText = By.xpath("//p[text()='Add-on Services']");
    public final By haulAwayPrice =  By.xpath("//div[normalize-space(text())='Haul away / dispose old appliance']/../following-sibling::div/span");
    public final By haulAwayCheckBox = By.xpath("//div[normalize-space(text())='Haul away / dispose old appliance']/../preceding-sibling::div//input");
    public final By moveOldUnitPrice =  By.xpath("//div[normalize-space(text())='Move old unit to another room']/../following-sibling::div/span");
    public final By moveOldUnitCheckBox = By.xpath("//div[normalize-space(text())='Move old unit to another room']/../preceding-sibling::div//input");
    public final By doorSwingPrice =  By.xpath("//div[normalize-space(text())='Door swing reversal']/../following-sibling::div/span");
    public final By doorSwingCheckBox = By.xpath("//div[normalize-space(text())='Door swing reversal']/../preceding-sibling::div//input");
    public final By availableProtectionPlanText = By.xpath("//h3[normalize-space(text())='Available protection plan.']");
    public final By declineProtection = By.xpath("//div[contains(@class, 'decline')]//label");
    public final By oneYearPlanPrice =  By.xpath("//div[text()='1 year']/../../following-sibling::div");
    public final By oneYearCheckBox = By.xpath("//div[text()='1 year']/../parent::label");
    public final By threeYearsPlanPrice = By.xpath("//div[text()='3 years']/../../following-sibling::div");
    public final By threeYearsCheckBox = By.xpath("//div[text()='3 years']/../parent::label");
    public final By fiveYearsPlanPrice = By.xpath("//div[text()='5 years']/../../following-sibling::div");
    public final By fiveYearsCheckBox = By.xpath("//div[text()='5 years']/../parent::label");
    public final By saveAndViewCartButton = By.xpath("//button[@aria-label='Save and view cart']");
    public final By partPriceOrderSummary = By.xpath("//div[text()='Installation parts']/following-sibling::div");
    public final By addOnServicesPriceOrderSummary = By.xpath("//div[normalize-space(text())='Add-on Services']/following-sibling::div");
    public final By protectionPlanPriceOrderSummary = By.xpath("//div[normalize-space(text())='Protection Plan']/following-sibling::div");

}
