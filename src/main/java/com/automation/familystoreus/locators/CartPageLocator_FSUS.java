package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class CartPageLocator_FSUS {

    public final By orderSummaryText = By.xpath("//h4[normalize-space(text())='Order summary']");
    public final By subtotalText = By.xpath("//div[normalize-space(text())='Subtotal']");
    public final By subtotalPrice = By.xpath("//div[normalize-space(text())='Subtotal']/following-sibling::div[contains(@class, 'summary-amount')]");
    public final By homeDeliveryText =  By.xpath("//div[normalize-space(text())='Home Delivery']");
    public final By homeDeliveryPrice = By.xpath("//div[normalize-space(text())='Home Delivery']/following-sibling::div[contains(@class, 'summary-amount')]");
    public final By totalText = By.xpath("//div[normalize-space(text())='Total']");
    public final By totalPrice = By.xpath("//div[normalize-space(text())='Total']/following-sibling::div[contains(@class, 'summary-amount')]");
    public final By proceedToCheckOutButton = By.xpath("(//button[normalize-space(text())='Proceed to checkout'])[2]");
    public final By emptyCartButton = By.xpath("//button[@class='emptyCartBtn']");
    public final By yourCartIsEmptyText = By.xpath("//p[text()='Your shopping cart is empty']");
    public final By productRemoveCloseButton = By.xpath("//a[contains(@href, '/en/p')]//..//..//following-sibling::div[4]//button");
    public final By removeButton = By.xpath("//app-elux-cart-confirm-modal//button//p[text()='Remove']");
    public final By productCount = By.xpath("//cx-item-counter//input[@type='number']");
    public final By increaseButton = By.xpath("//cx-item-counter//button[@type='button' and normalize-space(text())='+']");
    public final By decreaseButton = By.xpath("//cx-item-counter//button[@type='button' and normalize-space(text())='-']");

// Product unavailable from cart locators

    public final By Kitchentext = By.xpath("(//*[@class='undefined' and text()=' Kitchen '])[1]");
    public final By Singledoor = By.xpath("(//*[@class='White_Smoke secondarycategory text-wrap zeplinStyleChild ng-star-inserted' and text()=' Single Door '])[1]");
    public final By refrigeratoraddtocart = By.xpath("(//*[@class='ng-star-inserted'and text()=' Add to cart '])[1]");
    public final By Saveandcontinueshopping = By.xpath("//*[@class='btn btn-secondary btn-block ng-star-inserted']");
    public final By Induction = By.xpath("(//*[@class='White_Smoke secondarycategory text-wrap zeplinStyleChild ng-star-inserted' and text()=' Induction '])[1]");
    public final By Inductionaddtocart = By.xpath("(//*[@class='ng-star-inserted' and text()=' Add to cart '])[1]");
    public final By Gas = By.xpath("(//*[@class='White_Smoke secondarycategory text-wrap zeplinStyleChild ng-star-inserted' and text()=' Gas '])[1]");
    public final By Gasaddtocart = By.xpath("(//*[@class='ng-star-inserted' and text()=' Add to cart '])[1]");
    public final By Laundrytext = By.xpath("(//*[@class='undefined'])[2]");
    public final By Washerstext = By.xpath("(//*[@class='White_Smoke secondarycategory text-wrap zeplinStyleChild ng-star-inserted' and text()=' Washers '])[1]");
    public final By Washersaddtocart = By.xpath("(//*[@class='ng-star-inserted' and text()=' Add to cart '])[1]");
    public final By Saveandviewcart = By.xpath("//*[@class='btn btn-orange btn-block saveViewCart ng-star-inserted']");
    public final By Emptycart = By.xpath("//*[@class='emptyCartBtn']");



}
