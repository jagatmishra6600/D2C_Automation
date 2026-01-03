package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class COPS_OrderItemsLocatorsElux {

    public By deliveryTypeBanner = By.xpath("//div[@class='item-group--label-checkout Utility-TextProduct-SKU-Lrg hideInPrint']");
    public By productsName = By.xpath("//div[@class=\"product-name pb-3 ng-star-inserted\"]//a");
    public By productPrice = By.xpath("//div[@class='product-name pb-3 ng-star-inserted']//div[@class=\"ng-star-inserted\"]//s[@class=\"Utility-TextStrike-Through-Price ng-star-inserted\"]");
    public By productDiscount = By.xpath("//div[@class='product-name pb-3 ng-star-inserted']//div[@class=\"cx-value Utility-TextPrice-Sm price-block ng-star-inserted\"]//p//span//div");
    public By productSku = By.xpath("(//div[@class='cx-info-container row']//div[@class='col-12 pr-0 2']//div[@class=\"product-code Utility-TextProduct-SKU-Sm pb-2 ng-star-inserted\"])[2]");
    public By productQuantity = By.xpath("(//div[@class='d-flex justify-content-between Body-MediumBody_Medium']//p)[1]");
    public By addOnServices = By.xpath("//div[@class=\"row m-0 mt-2 ng-star-inserted\"]//div[@class='cx-item-list-desc col-8 pl-0 Body-MediumBody_Medium']//div");
    public By protectionPlan = By.xpath("//div[@class=\"row m-0 mt-2 ng-star-inserted\"]//div[@class='cx-item-list-desc col-8 p-0 Body-MediumBody_Medium']");
    public By editButton = By.xpath("//span[text()='Edit']/parent::a");
}
