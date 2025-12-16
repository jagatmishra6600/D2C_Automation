package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class ProductDetailLocatorsElux {

    public final By emailPopUp = By.xpath("//span[@id=\"close-modal123\"]");
    public final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");

    public final By skuNumber(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='Product-Card-Sku']");
    }

    public final By leftCornerTag(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='mb-4 highlight-wapper']/div");
    }

    public final By productImage(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//div[contains(@class,'Product-Image-Placeholder')]//img");
    }

    public final By productName(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//div[contains(@class,'product-card-inner-row')]");
    }

    public final By colorOption(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//div[contains(@class,'Product-Color-Swatch-wrapper')]/a");
    }

    public final By rating(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//div[@id='BvProductRating']");
    }

    public final By feature(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//div[@id='badge']/div");
    }

    public final By discountPrice(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//span[contains(@class,'saleprice')]");
    }

    public final By originalPrice(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//s");
    }

    public final By priceIcon(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//app-elux-tooltip//img");
    }

    public final By compareBox(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//input[@type='checkbox']");
    }

    public final By skuPDP = By.xpath("//div[@id=\"EluxBreadcrumb\"]//span[@class=\"ng-star-inserted\"]//span");


}
