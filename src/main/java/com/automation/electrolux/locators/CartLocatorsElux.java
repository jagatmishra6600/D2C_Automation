package com.automation.electrolux.locators;
import org.openqa.selenium.By;

public class CartLocatorsElux {
    public final By orderSummaryText = By.xpath("//h4[normalize-space(text())='Order Summary']");
    public final By subtotalText = By.xpath("//div[normalize-space(text())='Subtotal']");
    public final By subtotalPrice = By.xpath("//div[normalize-space(text())='Subtotal']/following-sibling::div[contains(@class, 'summary-amount')]");
    public final By homeDeliveryText =  By.xpath("//div[normalize-space(text())='Home delivery']");
    public final By homeDeliveryPrice = By.xpath("//div[normalize-space(text())='Home delivery']/following-sibling::div[contains(@class, 'summary-amount')]");
    public final By installationPartsText =  By.xpath("//div[normalize-space(text())='Installation parts']");
    public final By installationPartsPrice = By.xpath("//div[normalize-space(text())='Installation parts']/following-sibling::div[contains(@class, 'summary-amount')]");
    public final By totalText = By.xpath("//div[normalize-space(text())='Total']");
    public final By totalPrice = By.xpath("//div[normalize-space(text())='Total']/following-sibling::div[contains(@class, 'summary-amount')]");
    public final By promoCodeText = By.xpath("//h6[normalize-space(text())='Promo code']");
    public final By proceedToCheckOutButton = By.xpath("//button[normalize-space(text())='Proceed to Checkout']");
    public final By emptyCartButton = By.xpath("//button[@class='emptyCartBtn']");
    public final By yourCartIsEmptyText = By.xpath("//p[text()='Your shopping cart is empty']");
    public final By productRemoveCloseButton = By.xpath("//a[contains(@href, '/en/p')]//..//..//following-sibling::div[4]//button");
    public final By removeButton = By.xpath("//app-elux-cart-confirm-modal//button//p[text()='Remove']");
    public final By productCount = By.xpath("//cx-item-counter//input[@type='number']");
    public final By increaseButton = By.xpath("//cx-item-counter//button[@type='button' and normalize-space(text())= '+']");
    public final By decreaseButton = By.xpath("//cx-item-counter//button[@type='button' and normalize-space(text())= '-']");

    // Cart unavailable products locators

    public final By Filterandaccessories = By.xpath("(//*[@class='navMenuHeading undefined' and text()=' Filters & Accessories '])[1]");
    public final By Accessories = By.xpath("(//*[text()=' Accessories '])[1]");
    public final By Addtocartproduct1 = By.xpath("(//*[text()=' Add to cart '])[1]");
    public final By Cancelbutton = By.xpath("//*[@class='fr-close cursor-pointer']");
    public final By Addtocartproduct2 = By.xpath("(//*[text()=' Add to cart '])[2]");
    public final By Addtocartproduct3 = By.xpath("(//*[text()=' Add to cart '])[3]");
    public final By Airfilter = By.xpath("(//h5[text()=' Air Filters '])[1]");
    public final By Addtocartproduct = By.xpath("//*[text()=' Add to cart ']");
    public final By Dishwasher = By.xpath("(//*[text()=' Dishwasher '])[2]");
    public final By Dishwasherproduct = By.xpath("(//*[text()=' Add to cart '])[1]");
    public final By Viewcart = By.xpath("//*[@class='btn btn-block btn-orange view-cart']");
    public final By emptycart = By.xpath("//*[@class='emptyCartBtn']");

}
