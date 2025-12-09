package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class EL_DSPagesService {


    public static final By addToCartButton = By.xpath("//span[normalize-space(text()) = 'Add to cart']\n");

    public static final By zipCodeField = By.xpath("//div[@class=\"pdp-hide-header-visible\"]//span[@class=\"zipcode\"]");
    public static final By zipCodeInput = By.xpath("//input[@placeholder=\"Zip code...\"] | //div[@class=\"position-relative\"]//input");
    public static final By zipCodeButton = By.xpath("//button[@id=\"deliverToRibbonZipCodeButton\"]\n");

    public static final By zipPopUp = By.xpath("//div[@class=\"dy-modal-contents\"]//a");

    public static final By deliverySubTitle = By.xpath("//h3[text()=\"Delivery & installation services\"]\n");
    public static final By deliveryRadioButton = By.xpath("//input[@id=\"Laundry_Washers_FrontLoad_Electric_Unbox\"] \n" +
            "| //input[@id=\"Refrigerators_Large_WaterLine_Unbox\"]\n");
    public static final By deliveryDescription = By.xpath("//div[normalize-space(text())='Delivery only (No Install)']/parent::div//parent::div[@class=\"serviceSelected ng-star-inserted\"]//div[@class=\"standardInstallationItems mb-4 ng-star-inserted\"]//div//cx-page-slot//cx-paragraph//p");
    public static final By deliveryPrice = By.xpath("//div[text()=\" Delivery only (No Install) \"]//parent::div//parent::div[@class=\"d-flex\"]//div[@class=\"mt-2 pl-0 Utility-TextPrice-Sm col-2 deliveryInstalltn\"]//div[@class=\"priceFree\"]//span");

    public static final By requiredInstallation = By.xpath("//p[text()=\"Required installation parts\"]\n");
    public static final By listOfAvailable = By.xpath("//p[text()=\"Required installation parts\"]//parent::p//parent::cx-paragraph//parent::cx-page-slot//parent::div//div//div[2]\n");
    public static final By checkBoxRequired = By.xpath("//p[text()=\"Required installation parts\"]//parent::p//parent::cx-paragraph//parent::cx-page-slot//parent::div//input\n");
    public static final By priceRequired = By.xpath("//p[text()=\"Required installation parts\"]//parent::p//parent::cx-paragraph//parent::cx-page-slot//parent::div//div//div[@class=\"p-0 pt-1 f-18 Utility-TextPrice-Sm dnsPrice bold d-flex flex-column col-md-2 col-2\"]//span");

    public static final By installationUnavailable = By.xpath("//div[normalize-space(text()) = 'Installation unavailable in your area.']");


}
