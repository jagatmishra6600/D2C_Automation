package com.automation.electrolux.pages;

import com.automation.electrolux.locators.ShippingAddressLocatorsElux;
import com.automation.utils.WebElementUtil;

public class ShippingAddressPageActionsElux {

	ShippingAddressLocatorsElux shipping_Locator = new ShippingAddressLocatorsElux();
    
    public boolean isLoginSectionDisplayed() {
    	return WebElementUtil.isDisplayed(shipping_Locator.loginSection);
    }
    
    public String getAlreadyHaveAccountMessage() {
		 WebElementUtil.isDisplayed(shipping_Locator.alreadyHaveAccountMessage);
		 return WebElementUtil.getText(shipping_Locator.alreadyHaveAccountMessage);
    }
    
    public String getFasterCheckoutLoginMessage() {
		 WebElementUtil.isDisplayed(shipping_Locator.fasterCheckoutLoginMessage);
		 return WebElementUtil.getText(shipping_Locator.fasterCheckoutLoginMessage);
    }
    
    public boolean isLoginButtonDisplayed() {
    	return WebElementUtil.isDisplayed(shipping_Locator.loginButton);	 
    }
    
    public AccountLoginPageComponentActionsElux clickLoginButton() {
    	WebElementUtil.scrollIntoView(shipping_Locator.loginButton);
    	WebElementUtil.clickElement(shipping_Locator.loginButton);
    	return new AccountLoginPageComponentActionsElux();
    }
    
    public String getWelcomeBackGreetingMessage() {
    	WebElementUtil.isDisplayed(shipping_Locator.welcomeBackGreetingMessage);
    	return WebElementUtil.getText(shipping_Locator.welcomeBackGreetingMessage);
    }
    
    public boolean isLogoutLinkDisplayed() {
    	return WebElementUtil.isDisplayed(shipping_Locator.logoutLink);
    }
}
