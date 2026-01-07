package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class OutOfStockLocatorsFsus {

    public By resetAll = By.xpath("//span[text()=\" Reset all \"]");
    public By inStockFilter = By.xpath("//span[text()=\"In stock\"]\n");
    public By checkBoxFilter(String filterText) {
        return By.xpath("//span[normalize-space(text())='" + filterText + "']/parent::label/parent::div//input");
    }
    public By productName = By.xpath("//div[@id=\"PlpItem2\"]//div[@class=\"col- mb-3 mx-3 mt-4 productName\"]//a");
    public By addToCartBtn = By.xpath("(//span[normalize-space()='Add to cart'])[1]");
    public By msg1 = By.xpath("//p[@class='outofStockTitle d-flex m-0 mt-1 ng-star-inserted']//span");
    public By msg2 = By.xpath("//p[@class='outofStockSubText ng-star-inserted']");
    public By emailField = By.xpath("//input[@id='notifyMeEmailControl']");
    public By submitBtn = By.xpath("//input[@id='submitBtn']");

    public By collapseButton = By.xpath("//span[normalize-space(.)='In stock']/ancestor::div[contains(@class,'acc-header-srp')]//div[contains(@class,'text-right paddingMob0')]");

}
