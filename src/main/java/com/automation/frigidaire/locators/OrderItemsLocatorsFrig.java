package com.automation.frigidaire.locators;

import org.openqa.selenium.By;

public class OrderItemsLocatorsFrig {

    public By orderItemsHeader = By.xpath("//h3[@class='Body-XXLargeBody_XXLarge hideInPrint ng-star-inserted']");
    public By orderProductName = By.xpath("//p[@class='font-Gotham-Bold checkout-package-name']");
    public By productPriceDiscount = By.xpath("//div[@class='checkout-package-price-right text-right salepricevirtual ng-star-inserted']");
    public By productPriceMRP = By.xpath("//div[@class='msrp-mobile f-16 text-right d-block ng-star-inserted']//s");
    public By productSku = By.xpath("(//div[@class='cx-item f-12 font-Gotham-Book crisp-charcoal'])[1]");
    public By productQuantity = By.xpath("//div[@class='cx-item font-Gotham-Book checkout-package-qty m-0']");
    public By orderAddOn = By.xpath("//div[@class='col-8 col-md-8 float-left paddingDnS0 pt-3 px-0']//div[@class='cx-name ng-star-inserted']");
    public By orderProtectionPlan = By.xpath("//div[@class='cx-name']");
    public By editButton = By.xpath("//span[text()='Edit']/parent::a");
}
