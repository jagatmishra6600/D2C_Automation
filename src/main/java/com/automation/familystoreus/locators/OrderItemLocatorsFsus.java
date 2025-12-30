package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class OrderItemLocatorsFsus {

    public By deliveryTypeBanner = By.xpath("//div[@class=\"item-group--label-checkout Utility-TextProduct-SKU-Lrg font-weight-bold hideInPrint\"]");
    public By productNames = By.xpath("(//div[@class=\"cx-name font-weight-bold p-0 col-md-8 col-sm-8\"]//a[@class='cx-link'])[1]");
    public By productDiscountPrice = By.xpath("(//div[@class='cx-value font-weight-bold text-right'])[1]");
    public By productMrpPrice = By.xpath("(//p[@class=\"mb-1 f-color-theme text-right strike-text f-12\"]//s)[1]");
    public By productSku = By.xpath("(//div[@class=\"product-code\"])[2]");
    public By productQuantity = By.xpath("(//div[@class='cx-item cx-item-qty'])[1]");
    public By productAddon = By.xpath("//div[@class=\"row m-0 mt-2\"]//div[@class=\"cx-item-list-desc col-8 pl-0 pr-0\"]//span");
    public By protectionPlan = By.xpath("//div[@class='cx-item-list-desc col-8 p-0']");
    public By editButton = By.xpath("//span[text()=' Edit ']//parent::a");
}
