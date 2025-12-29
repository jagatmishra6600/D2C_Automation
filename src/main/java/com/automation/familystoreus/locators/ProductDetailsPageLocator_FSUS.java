package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class ProductDetailsPageLocator_FSUS {
    public final By productIdOnPDP = By.xpath("//p[contains(@class, 'prod_id')]");
    public final By productTitleOnPDP = By.xpath("//p[contains(@class, 'prod_name Product-title')]");
    public final By productPriceOnPDP = By.xpath("//span[contains(@class, 'H3H3_Desktop ')]");
    public final By productColorOnPDP = By.xpath("//span[@class='colorHeading']");
    public final By pdpHeight = By.xpath("//div[normalize-space(text())='Height']/preceding-sibling::div");
    public final By pdpWidth = By.xpath("//div[normalize-space(text())='Width']/preceding-sibling::div");
    public final By pdpDepth = By.xpath("//div[normalize-space(text())='Depth']/preceding-sibling::div");
    public final By quickSpecificationBtnOnPDP = By.xpath("//span[text()='Specs']");
    public final By keySpecificationHeading = By.xpath("//h2[text()='Key specifications']");
    public final By additionalKeySpecText = By.xpath("//h3[text()='Additional specifications']");
    public final By generalSpecText = By.xpath("//h4[text()='General Specifications']");
    public final By fullSpecDownload = By.xpath("//a[text()=' Download Full Product Specs Sheet ']");
    public final By viewFullSpecBtn = By.xpath("//button[text()='View full specs']");
    public final By specificationText = By.xpath("//h3[text()='Specifications']");
    public final By closeModelButton = By.xpath("//h3[text()='Specifications']/following-sibling::img");
    public final By addToCartButton = By.xpath("(//span[normalize-space(text())='Add to cart'])[1]");
    public final By viewCartButton = By.xpath("//app-elux-add-to-cart-popup//a[text()='View cart']");

}
