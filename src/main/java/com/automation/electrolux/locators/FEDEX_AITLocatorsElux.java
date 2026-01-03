package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class FEDEX_AITLocatorsElux {

    public By deliveryOnlyItems = By.xpath("//div[@class='item-group--label-checkout ng-star-inserted']");
    public By deliverToZipcode = By.xpath("//div[@class='delivery-date-selection']//div[@class='delivery-date-selection cx-delivery-fedex ng-star-inserted']//div[@class='ng-star-inserted']//u");
    public By messages = By.xpath("//div[contains(text(), 'Once your order is placed, in 48-72hrs you will receive an email and/or text message')]");
    public By estimatedDelivery = By.xpath("//div[@class='delivery-date-selection']//following-sibling::div[@class='ng-star-inserted']");
    public By deliveryCommentsTextbox = By.xpath("//textarea[@placeholder='Enter special instructions for our delivery team.']");

}
