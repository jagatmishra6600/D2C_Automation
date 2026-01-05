package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class InstallationAddOnServiceLocatorsFsus {

    public By pageTitle = By.xpath("//p[text()='Delivery, installation & service options']");
    public By freeDeliveryMessage = By.xpath("//span[text()='Your order qualifies for FREE delivery!']");
    public By sectionTitle = By.xpath("//h3[text()='Delivery & installation services']");
    public By professionalInstallationTitle = By.xpath("//div[text()=' Professional installation ']");
    public By professionalInstallationRadio = By.xpath("//input[@id='Refrigerators_Large_WaterLine_Install']");
    public By professionalInstallationDescription = By.xpath("//p[@class='ng-star-inserted']//p[@class='mb-0']");
    public By professionalInstallationPrice = By.xpath("//div[text()=' Professional installation ']/parent::div/parent::div//div[@id='deliveryInstalltn']//div[@class='priceFree ng-star-inserted']//span");
    public By professionalInstallationTag = By.xpath("//div[@class='pl-2 RecommendSlot ng-star-inserted']//p");

    public By addOnServiceTitle = By.xpath("//p[text()='Add-on Service']");
    public By addOnServiceMessage = By.xpath("//p[@class='ng-star-inserted']//p//small[@class='Body-SmallBody_Small']");
    public By haulAwayLabel = By.xpath("//div[text()=' Haul away / dispose old appliance ']");
    public By haulAwayCheckbox = By.xpath("//div[text()=' Haul away / dispose old appliance ']//parent::div//parent::div//div//input[@class='form-check-input ml-0 ng-untouched ng-pristine ng-valid']");
    public By haulAwayDescription = By.xpath("//div[text()=' Haul away / dispose old appliance ']//parent::div//parent::div//div[@class='whatsThis']//cx-page-slot//cx-paragraph//p[@class='ng-star-inserted']//p");
    public By haulAwayPrice = By.xpath("//div[text()=' Haul away / dispose old appliance ']//parent::div//parent::div//div[@class='ml-auto p-2 d-block align-items-center H4H4_Desktop']//span");
    public By moveUnitLabel = By.xpath("//div[text()=' Move old unit to another room ']");
    public By moveUnitCheckbox = By.xpath("//div[text()=' Move old unit to another room ']//parent::div//parent::div//div//input[@class='form-check-input ml-0 ng-untouched ng-pristine ng-valid']");
    public By moveUnitDescription = By.xpath("//div[text()=' Move old unit to another room ']//parent::div//parent::div//div[@class='whatsThis']//cx-page-slot//cx-paragraph//p[@class='ng-star-inserted']//p");
    public By moveUnitPrice = By.xpath("//div[text()=' Move old unit to another room ']//parent::div//parent::div//div[@class='ml-auto p-2 d-block align-items-center H4H4_Desktop']//span");

    public By subTotalLabel = By.xpath("//b[text()=\" Sub total \"]");
    public By subTotalPrice = By.xpath("//b[text()=\" Sub total \"]//parent::div//following-sibling::div[@class=\"Body_Large-Title col-6 col-md-6 p-0 text-right\"]//b");
    public By subTotalAddOnServicePrice = By.xpath("//div[@class=\"col-6 col-md-6 p-0 text-right ng-star-inserted\"]");
    public By totalLabel = By.xpath("//div[text()=\" Total \"]//following-sibling::div[@class=\"Body_Large-Title col-6 col-md-6 p-0 text-right\"]");

}
