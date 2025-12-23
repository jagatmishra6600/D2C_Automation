package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.ShippingAddressLocatorsFrig;
import com.automation.utils.WebElementUtil;

public class ShippingAddressPageActionsFrig {

	ShippingAddressLocatorsFrig shipping_Locator = new ShippingAddressLocatorsFrig();
    
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
    
    public AccountLoginPageComponentActionsFrig clickLoginButton() {
    	WebElementUtil.scrollIntoView(shipping_Locator.loginButton);
    	WebElementUtil.clickElement(shipping_Locator.loginButton);
    	return new AccountLoginPageComponentActionsFrig();
    }
    
    public String getWelcomeBackGreetingMessage() {
    	WebElementUtil.isDisplayed(shipping_Locator.welcomeBackGreetingMessage);
    	return WebElementUtil.getText(shipping_Locator.welcomeBackGreetingMessage);
    }
    
    public boolean isLogoutLinkDisplayed() {
    	return WebElementUtil.isDisplayed(shipping_Locator.logoutLink);
    }


    public void verifyShippingDeatils()
    {
        WebElementUtil.waitForElementToBeVisible(shipping_Locator.SHPPING_ADRESS_POINT_ONE,10000);
        WebElementUtil.isDisplayed(shipping_Locator.SHPPING_ADRESS_POINT_ONE);
       // WebElementUtil.scrollToElementStable(shipping_Locator.SHIPPING_ADRESS_HEADING);



        WebElementUtil.waitForElementToBeVisible(shipping_Locator.SHIPPING_ADRESS_HEADING,10000);
        WebElementUtil.isDisplayed(shipping_Locator.SHIPPING_ADRESS_HEADING);

        WebElementUtil.scrollToElementStable(shipping_Locator.CONTINUE_TO_DELIVERY_BTN);
        WebElementUtil.waitForElementToBeVisible(shipping_Locator.CONTINUE_TO_DELIVERY_BTN,10000);
        WebElementUtil.isDisplayed(shipping_Locator.CONTINUE_TO_DELIVERY_BTN);


        WebElementUtil.scrollToElementStable(shipping_Locator.SHIPPING_ADRESS_HEADING);
        WebElementUtil.waitForElementToBeVisible(shipping_Locator.EMAIL_ADDRESS_TXT_FIELD,10000);
        WebElementUtil.isDisplayed(shipping_Locator.EMAIL_ADDRESS_TXT_FIELD);
        WebElementUtil.sendKeys(shipping_Locator.EMAIL_ADDRESS_TXT_FIELD,"automationtestengineer@maildrop.cc");
        WebElementUtil.waitForElementToBeVisible(shipping_Locator.FIRST_NAME);
        WebElementUtil.sendKeys(shipping_Locator.FIRST_NAME,"automationtestengineer@maildrop.cc");
        WebElementUtil.waitForElementToBeVisible(shipping_Locator.LAST_NAME);
        WebElementUtil.sendKeys(shipping_Locator.LAST_NAME,"cc");

        WebElementUtil.waitForElementToBeClickable(shipping_Locator.MANUALLY_ENTER_ADDRESS_LINK,10000);
        WebElementUtil.clickElement(shipping_Locator.MANUALLY_ENTER_ADDRESS_LINK);









    }


}
