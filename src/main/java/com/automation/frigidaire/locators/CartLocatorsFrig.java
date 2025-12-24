package com.automation.frigidaire.locators;
import org.openqa.selenium.By;

public class CartLocatorsFrig {
    public final By orderSummaryText = By.xpath("//h4[normalize-space(text())='Order summary']");
    public final By subtotalText = By.xpath("//div[normalize-space(text())='Subtotal']");
    public final By subtotalPrice = By.xpath("//div[normalize-space(text())='Subtotal']/following-sibling::div[contains(@class, 'summary-amount')]");
    public final By installationPartsText =  By.xpath("//div[normalize-space(text())='Installation parts']");
    public final By installationPartsPrice = By.xpath("//div[normalize-space(text())='Installation parts']/following-sibling::div[contains(@class, 'summary-amount')]");
    public final By totalText = By.xpath("//div[normalize-space(text())='Total']");
    public final By totalPrice = By.xpath("//div[normalize-space(text())='Total']/following-sibling::div[contains(@class, 'summary-amount')]");
    public final By promoCodeText = By.xpath("//h6[normalize-space(text())='Promo code']");
    public final By proceedToCheckOutButton = By.xpath("(//button[normalize-space(text())='Proceed to checkout'])[2]");
    public final By emptyCartButton = By.xpath("//button[contains(@class, 'emptyCartBtn')]");
    public final By confirmButton = By.xpath("//app-elux-cart-empty-modal//button//p[contains(text(),'Yes')]");
    public final By yourCartIsEmptyText = By.xpath("//p[text()='Your shopping cart is empty']");
    public final By productRemoveCloseButton = By.xpath("//a[contains(@href, '/en/p')]//..//..//following-sibling::div[3]//button");
    public final By removeButton = By.xpath("//app-elux-cart-confirm-modal//button//p[text()='Remove']");
    public final By productCount = By.xpath("//cx-item-counter//input[@type='number']");
    public final By increaseButton = By.xpath("//cx-item-counter//button[@type='button']//img[contains(@src, 'plus')]");
    public final By decreaseButton = By.xpath("//cx-item-counter//button[@type='button']//img[contains(@src, 'minus')]");


}
