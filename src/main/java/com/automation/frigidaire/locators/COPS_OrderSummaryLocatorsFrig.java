package com.automation.frigidaire.locators;

import org.openqa.selenium.By;

public class COPS_OrderSummaryLocatorsFrig {

    public By subtotalText(String text) {
        return By.xpath("//div[contains(normalize-space(), '" + text + "')]");
    }
    public By addToCartButtons = By.xpath("//span[normalize-space()='Add to cart']\n");
    public By saveAndViewCartButton = By.xpath("//a[normalize-space()='Save and view cart'] | //button[normalize-space()='Save and view cart']\n");
    public By addOnServiceText = By.xpath("//p[normalize-space()='Add-on services']");
    public By selectAddOnServices = By.xpath("//div[normalize-space()='Haul away / dispose old appliance']//parent::div/parent::div//input");
    public By protectionPlanText = By.xpath("//h3[text()=\" Select a protection plan\"]");
    public By selectProtectionPlan = By.xpath("//span[text()=\"1 year\"]");
}
