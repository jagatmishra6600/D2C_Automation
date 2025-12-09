package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class DSPageInstallationLocatorsElux {

    public static final By addOnService = By.xpath("//p[text()=\"Add-on Services\" or text()=\"Add-on services\"]\n");
    public static final By addOnMessage = By.xpath("//p[contains(text(), \"You must uninstall your appliance for haul-away or moving.\")]\n");

    public static final By haulText = By.xpath("//div[text()=\" Haul away / dispose old appliance \"]");
    public static final By haulCheckBox = By.xpath("//div[text()=\" Haul away / dispose old appliance \"]//parent::div//parent::div//input");
    public static final By haulDescription = By.xpath("//div[text()=\" Haul away / dispose old appliance \"]//parent::div//cx-paragraph//p//p");
    public static final By haulPrice = By.xpath("//div[text()=\" Haul away / dispose old appliance \"]//parent::div//parent::div//div//span");

    public static final By moveOld = By.xpath("//div[text()=\" Move old unit to another room \"]");
    public static final By moveOldCheckBox = By.xpath("//div[text()=\" Move old unit to another room \"]//parent::div//parent::div//input");
    public static final By moveOldDescription = By.xpath("//div[text()=\" Move old unit to another room \"]//parent::div//cx-paragraph//p//p");
    public static final By moveOldPrice = By.xpath("//div[text()=\" Move old unit to another room \"]//parent::div//parent::div//div//span");

    public static final By subTotal = By.xpath("//div[text()=\" Subtotal \"]//parent::div//b\n");
    public static final By subTotalAddOnServicePrice = By.xpath("//div[normalize-space(text())=\"Add-on Services\" or normalize-space(text())=\"Add-on services\"]/following-sibling::div\n");

    public static final By requiredInstallation = By.xpath("//p[text()=\"Required installation parts\"]\n");
    public static final By listOfAvailable = By.xpath("//p[text()=\"Required installation parts\"]//parent::p//parent::cx-paragraph//parent::cx-page-slot//parent::div//div//div[2]\n");
    public static final By checkBoxRequired = By.xpath("//p[text()=\"Required installation parts\"]//parent::p//parent::cx-paragraph//parent::cx-page-slot//parent::div//input\n");
    public static final By priceRequired = By.xpath("//p[normalize-space(.)='Required installation parts']/parent::p/parent::cx-paragraph/parent::cx-page-slot/parent::div//div//div//span[contains(@class,'price')]");
    public static final By installationPriceInSubTotal = By.xpath("//div[@class=\"row py-1 Body-MediumBody_Medium ng-star-inserted\"]//div[2]");

    public static final By totalPrice = By.xpath("//div[normalize-space() = \"Total\"]/following-sibling::div");
    public static final By total = By.xpath("//div[@class=\"row\"]//div[text()=\" Total \"]/following-sibling::div");


    public static final By deliveryInstallation = By.xpath("//div[text()=\" Delivery & installation \"]");
    public static final By deliveryInstallationTag = By.xpath("//div[normalize-space(text())=\"Delivery & installation\"]//parent::div//cx-page-slot[@class=\"pl-2 RecommendSlot has-components ng-star-inserted\"]//cx-paragraph//p");
    public static final By deliveryInstallationDescription = By.xpath("//div[normalize-space(text())=\"Delivery & installation\"]//parent::div//cx-page-slot[@class=\"pl-2 Body-SmallBody_Small whatThis2 has-components\"]//p//p");
    public static final By deliveryInstallationPrice = By.xpath("//div[normalize-space(text())=\"Delivery & installation\"]//parent::div//parent::div//div[@id=\"deliveryInstalltn\"]//div//span");
    public static final By deliveryInstallationViewLink = By.xpath("//div[normalize-space(text())=\"Delivery & installation\"]//parent::div//p[@class=\"f-12 ml-2\"]//a");
    public static final By deliveryInstallationRadioButton = By.xpath("//input[@id=\"Refrigerators_Large_WaterLine_Install\"]");

    public static final By professionalInstallation = By.xpath("//div[normalize-space(text())=\"Professional Installation\"]");
    public static final By professionalInstallationTag = By.xpath("//cx-page-slot[@class=\"RecommendSlot has-components\"]//cx-paragraph//p");
    public static final By professionalInstallationDescription = By.xpath("//div[text()=\" Professional Installation \"]//parent::div//cx-page-slot//cx-paragraph//p//p");
    public static final By professionalInstallationPrice = By.xpath("//div[text()=\" Professional Installation \"]//parent::div//parent::div//div[@class=\"ml-auto p-2 d-flex align-items-center H4H4_Desktop\"]//span");
    public static final By professionalInstallationViewLink = By.xpath("//div[text()=\" Professional Installation \"]//parent::div//parent::div//p//a");
    public static final By professionalInstallationRadioButton = By.xpath("//input[@id=\"Laundry_Washers_FrontLoad_Electric_Install\"]");

    public static final By doorSwing = By.xpath("//div[normalize-space(text())='Door swing reversal']\n");
    public static final By doorSwingRadioButton = By.xpath("//div[normalize-space(text())='Door swing reversal']//parent::div//parent::div//div[@id=\"serviceInputContainer\"]//input\n");
    public static final By doorSwingPrice = By.xpath("//div[normalize-space(text())='Door swing reversal']//parent::div//parent::div//div[@class=\"ml-auto p-2 d-flex align-items-center H4H4_Desktop\"]//span");


}
