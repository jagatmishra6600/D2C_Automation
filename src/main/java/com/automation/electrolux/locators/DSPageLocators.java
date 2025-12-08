package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class DSPageLocators {

    public static final By addToCartButton = By.xpath("//span[text()=\" Add to cart \"]");

    public static final By zipCodeField = By.xpath("//div[@class=\"pdp-hide-header-visible\"]//span[@class=\"zipcode\"]");
    public static final By zipCodeInput = By.xpath("//input[@placeholder=\"Zip code...\"]\n");
    public static final By zipCodeInputElux = By.xpath("//div[@class=\"position-relative\"]//input");
    public static final By zipCodeButton = By.xpath("//button[@id=\"deliverToRibbonZipCodeButton\"]\n");

    public static final By zipPopUp = By.xpath("//div[@class=\"dy-modal-contents\"]//a");

    public static final By deliverySubTitle = By.xpath("//h3[text()=\"Delivery & installation services\"]\n");
    public static final By deliveryRadioButton = By.xpath("//input[@id=\"Laundry_Washers_FrontLoad_Electric_Unbox\"] \n" +
            "| //input[@id=\"Refrigerators_Large_WaterLine_Unbox\"]\n");
    //    public static final By deliveryDescription = By.xpath("//div[normalize-space(text())='Delivery only (No Install)']/parent::div//cx-paragraph//p//p | \n" +
//            "//div[normalize-space(text())='Delivery only (No Install)']/parent::div//cx-paragraph//p\n");
    public static final By deliveryDescription = By.xpath("//div[@class=\"standardInstallationItems mb-4 ng-star-inserted\"]//div//cx-page-slot//cx-paragraph//p//p");
    public static final By deliveryPrice = By.xpath("//div[text()=\" Delivery only (No Install) \"]//parent::div//parent::div//div[@class=\"priceFree\"]//span\n");
    //public static final By deliveryPrice = By.xpath("//div[text()=\" Delivery only (No Install) \"]//parent::div//parent::div//div[@class=\"pt-2 Utility-TextPrice-Sm col-2 px-0 deliveryInstaltnprice\"]//span");

    public static final By requiredInstallation = By.xpath("//p[text()=\"Required installation parts\"]\n");
    public static final By listOfAvailable = By.xpath("//p[text()=\"Required installation parts\"]//parent::p//parent::cx-paragraph//parent::cx-page-slot//parent::div//div//div[2]\n");
    public static final By checkBoxRequired = By.xpath("//p[text()=\"Required installation parts\"]//parent::p//parent::cx-paragraph//parent::cx-page-slot//parent::div//input\n");
    public static final By priceRequired = By.xpath("//p[text()=\"Required installation parts\"]//parent::p//parent::cx-paragraph//parent::cx-page-slot//parent::div//div//div[@id=\"dnsPrice\"]//span\n");

    public static final By installationUnavailable = By.xpath("//div[normalize-space(text()) = 'Installation unavailable in your area.']");

}
