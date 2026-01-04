package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class OrderSummaryForCheckOutPage1Elux {




        public final By orderSummaryText = By.xpath("//h4[normalize-space(text())='Order summary']");
        public final By subtotalText = By.xpath("//div[normalize-space(text())='Subtotal']");
        public final By subtotalPrice = By.xpath("//div[normalize-space(text())='Subtotal']/following-sibling::div[contains(@class, 'summary-amount')]");
        public final By installationPartsText =  By.xpath("//div[normalize-space(text())='Installation parts']");
        public final By installationPartsPrice = By.xpath("//div[normalize-space(text())='Installation parts']/following-sibling::div[contains(@class, 'summary-amount')]");
        public final By totalText = By.xpath("//div[normalize-space(text())='Total']");
        public final By totalPrice = By.xpath("//div[normalize-space(text())='Total']/following-sibling::div[contains(@class, 'summary-amount')]");
        public final By promoCodeText = By.xpath("//h6[normalize-space(text())='Promo code']");
        public final By proceedToCheckOutButton = By.xpath("//button[normalize-space(text())='Proceed to Checkout']");
        public final By emptyCartButton = By.xpath("//button[contains(@class, 'emptyCartBtn')]");
        public final By confirmButton = By.xpath("//app-elux-cart-empty-modal//button//p[contains(text(),'Yes')]");
        public final By yourCartIsEmptyText = By.xpath("//p[text()='Your shopping cart is empty']");
        public final By productRemoveCloseButton = By.xpath("//a[contains(@href, '/en/p')]//..//..//following-sibling::div[3]//button");
        public final By removeButton = By.xpath("//app-elux-cart-confirm-modal//button//p[text()='Remove']");
        public final By saveAndContinueBtn = By.xpath("//button[normalize-space()='Save & continue']");
        public final By packageSavingPrice = By.xpath("//div[normalize-space()='You saved']/following-sibling::div");
        public final By cartdiscountPrice = By.xpath("//div[normalize-space()='Cart discounts']/following-sibling::div");
        public final By cartSavings = By.xpath("//div[normalize-space()='Cart savings']/following-sibling::div");
        public final By deliveryPriceOrFree = By.xpath("//div[text()='Home delivery']/following-sibling::div");
        public final By salesTax = By.xpath("//div[normalize-space()='Sales tax']/following-sibling::div");
        public final By installationPartPrice = By.xpath("//div[normalize-space()='Installation parts']/following-sibling::div");
        public final By addOnServicesPrice = By.xpath("//div[normalize-space()='Add-on services']/following-sibling::div");
        public final By parcelShippingPrice = By.xpath("//div[text()='Parcel Shipping']/following-sibling::div");
        public final By tapProtectionPlanPrice = By.xpath("//div[normalize-space()='tap protection plan']/following-sibling::div");
        public final By subTotalText = By.xpath("//div[normalize-space()='Subtotal']");
        public final By subTotalPrice = By.xpath("//div[text()=' Subtotal ']/following-sibling::div[contains(@class, 'cx-summary-amount')]");






}
