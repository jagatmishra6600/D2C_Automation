package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class CheckoutLocatorsFsus {
    public final By deliveryTypeBanner = By.cssSelector("div.item-group--label-checkout");
    public final By EditOrder = By.cssSelector("a.cx-link.ng-star-inserted");
    public final By orderTitle =By.cssSelector("p.font-ElectroluxSans-SemiBold.checkout-package-name");
    public final By orderSKU = By.xpath("//p[contains(@class,'package-code')]");
    public final By orderQty = By.xpath("//div[contains(@class,'checkout-package-qty')]");
    public final By orderPrice = By.xpath("//s[contains(@class,'Utility-TextStrike-Through-Price')]");
    public final By discountPrice = By.xpath("//div[contains(@class,'checkout-package-price')]");
    public final By protectionPlan = By.cssSelector("div.row.m-0.pt-3.paddingMDnS.Body-MediumBody_Medium.ng-star-inserted");
    public final By addOnService = By.cssSelector("div.row.m-0.pt-3.paddingMDnS.Body-MediumBody_Medium.ng-star-inserted");

    // Included in your purchase block
    public final By includedSection = By.xpath("//p[normalize-space()='Included in your purchase']");
    public final By includedItemTitles = By.xpath("//p[normalize-space()='Included in your purchase']//parent::div//following-sibling::div//p");
    public final By includedItemSKUs = By.xpath("//p[normalize-space()='Included in your purchase']//parent::div//following-sibling::div//div//p//parent::a//parent::div//following-sibling::div[contains(@class,'cx-code')]");
    public final By includedItemColor = By.xpath("//p[normalize-space()='Included in your purchase']//parent::div//following-sibling::div//div//div//parent::a//parent::div//following-sibling::div//div[contains(@class,'cx-item')]");

    // delivery addon line
    public final By addOnServices = By.xpath("//cx-page-slot[@position='More services Paragraph']//following-sibling::div[contains(@class,'delivery-installation-options')]//input");
    public final By deliveryInstallationRadio = By.id("Refrigerators_Large_WaterLine_Install");
    public final By saveAndViewCartButton = By.xpath("//button[normalize-space()='Save and view cart']");
    public final By selectProtectionPlan = By.xpath("//span[text()='1 year']//ancestor::label");
    public final By cartPage = By.xpath("//h1[contains(normalize-space(),'Your Cart')]");

}
