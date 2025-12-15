package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class FedexServicelocatorsFsus {

    public By zipCode = By.xpath("//span[@class='Set-delivery-area']");
    public By zipInputBox = By.xpath("//input[@placeholder='Enter delivery zip code']");
    public By zipButton = By.xpath("//button[@name='deliverToRibbonZipCodeButton']");
    public By productName = By.xpath("//div[@class=\"col- my-3 mx-3 mb-5\"]//a");

    public By addToCartButton = By.xpath("//app-elux-action-button[@class='luxuryProductDetails productDetails ng-star-inserted']//a");

    public By deliveryOption = By.xpath("//h3[text()=\"Delivery & installation services\"]");
    public By radioButton = By.xpath("//input[@id=\"Refrigerators_Large_WaterLine_Unbox\"]");
    public By deliveryOnlyText = By.xpath("//div[normalize-space(text())='Delivery only (No Install)']\n");
    public By descriptionText = By.xpath("//div[normalize-space(.)='Delivery only (No Install)']/ancestor::div[@class='d-flex']//p//p");
    public By deliveryPrice = By.xpath("//div[normalize-space(.)='Delivery only (No Install)']/ancestor::div[@class='d-flex']//div[@id='deliveryInstalltn']//div[@class='priceFree ng-star-inserted']//span");

    public By requiredInstallationParts = By.xpath("//p[@class='InstallationPart']");
    public By installationList = By.xpath("//div[@class='d-flex stainlessSteel']//div[@class='p-1 col-md-9 col-9 d-flex install font-Gotham-Book f-12 mb-3']");
    public By installationCheckbox = By.xpath("//div[@class='d-flex stainlessSteel']//input[@name='flexRadioDefault']");
    public By installationPrice = By.xpath("//div[@class='d-flex stainlessSteel']//div[@id='dnsPrice']//span");
    public By searchBox = By.xpath("//input[@class='navSearchDirty']");

}
