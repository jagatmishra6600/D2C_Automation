package com.automation.electrolux.locators;
import org.openqa.selenium.By;

public class ShippingAddressLocatorsElux {
   public final By loginSection = By.cssSelector("shipping-address-cdc-login");
   public final By alreadyHaveAccountMessage = By.cssSelector("shipping-address-cdc-login h4");
   public final By fasterCheckoutLoginMessage = By.cssSelector("shipping-address-cdc-login span.loginMessage");
   public final By loginButton = By.xpath("//shipping-address-cdc-login//button[contains(.,'Log In')]");
   public final By welcomeBackGreetingMessage = By.xpath("//shipping-address-cdc-login//h5[contains(.,'Welcome back')]");
   public final By logoutLink = By.xpath("//a[contains(.,'Log out')]");
}
