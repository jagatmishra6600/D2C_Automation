package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.ShippingAddressLocatorsFrig;
import com.automation.models.ShippingAddressData;
import com.automation.utils.WaitUtils;
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


    public void verifyShippingDetails(String email, String FirstName , String LastName , String City,String State ,String phoneNumber , String ZipCode,String adressLine1) throws InterruptedException {
        WebElementUtil.waitForElementToBeVisible(shipping_Locator.SHPPING_ADRESS_POINT_ONE,10000);
        WebElementUtil.isDisplayed(shipping_Locator.SHPPING_ADRESS_POINT_ONE);
       // WebElementUtil.scrollToElementStable(shipping_Locator.SHIPPING_ADRESS_HEADING);



        WebElementUtil.waitForElementToBeVisible(shipping_Locator.SHIPPING_ADRESS_HEADING,10000);
        WebElementUtil.isDisplayed(shipping_Locator.SHIPPING_ADRESS_HEADING);

        WebElementUtil.scrollToElementStable(shipping_Locator.CONTINUE_TO_DELIVERY_DISABLE_BTN);
        WebElementUtil.waitForElementToBeVisible(shipping_Locator.CONTINUE_TO_DELIVERY_DISABLE_BTN,10000);
        WebElementUtil.isDisplayed(shipping_Locator.CONTINUE_TO_DELIVERY_DISABLE_BTN);


        WebElementUtil.scrollToElementStable(shipping_Locator.SHIPPING_ADRESS_HEADING);
        WebElementUtil.waitForElementToBeVisible(shipping_Locator.EMAIL_ADDRESS_TXT_FIELD,10000);
        WebElementUtil.isDisplayed(shipping_Locator.EMAIL_ADDRESS_TXT_FIELD);
        WebElementUtil.sendKeys(shipping_Locator.EMAIL_ADDRESS_TXT_FIELD,email);
        WebElementUtil.waitForElementToBeVisible(shipping_Locator.FIRST_NAME);
        WebElementUtil.sendKeys(shipping_Locator.FIRST_NAME,FirstName);
        WebElementUtil.waitForElementToBeVisible(shipping_Locator.LAST_NAME);
        WebElementUtil.sendKeys(shipping_Locator.LAST_NAME,LastName);
        WebElementUtil.scrollToElementStable(shipping_Locator.MANUALLY_ENTER_ADDRESS_LINK);
        WebElementUtil.waitForElementToBeClickable(shipping_Locator.MANUALLY_ENTER_ADDRESS_LINK,10000);
        WebElementUtil.clickElement(shipping_Locator.MANUALLY_ENTER_ADDRESS_LINK);
        WebElementUtil.waitForElementToBeVisible(shipping_Locator.ADRESS_LINE1,10000);
        WebElementUtil.isDisplayed(shipping_Locator.ADRESS_LINE1);
        WebElementUtil.sendKeys(shipping_Locator.ADRESS_LINE1,adressLine1);
        WebElementUtil.waitForElementToBeVisible(shipping_Locator.ADRESS_LINE2,10000);
        WebElementUtil.isDisplayed(shipping_Locator.ADRESS_LINE2);
        WebElementUtil.waitForElementToBeVisible(shipping_Locator.CITY,10000);
        WebElementUtil.isDisplayed(shipping_Locator.CITY);
        WebElementUtil.sendKeys(shipping_Locator.CITY,City);
        WebElementUtil.scrollToElementStable(shipping_Locator.STATE);
        WebElementUtil.waitForElementToBeClickable(shipping_Locator.STATE);
        WebElementUtil.isDisplayed(shipping_Locator.STATE);
        WebElementUtil.clickElement(shipping_Locator.STATE_TXTFIELD);
        WebElementUtil.sendKeys(shipping_Locator.STATE_TXTFIELD,State);
        WebElementUtil.clickElement(shipping_Locator.selectState(State));
        WebElementUtil.waitForElementToBeVisible(shipping_Locator.ZIPCODE,10);
        WebElementUtil.sendKeys(shipping_Locator.ZIPCODE,ZipCode);
        WebElementUtil.scrollToElementStable(shipping_Locator.PHONE_NUMBER);
        WebElementUtil.waitForElementToBeVisible(shipping_Locator.PHONE_NUMBER,10);
        WebElementUtil.sendKeys(shipping_Locator.PHONE_NUMBER,phoneNumber);
        Thread.sleep(4000);
        WebElementUtil.waitForElementToBeVisible(shipping_Locator.CONTINUE_TO_DELIVERY_BTN,10);
        WebElementUtil.clickElement(shipping_Locator.CONTINUE_TO_DELIVERY_BTN);
    }
    
    public ShippingAddressPageActionsFrig enterShippingAddressDetails(ShippingAddressData addressData) {
    	enterEmailAddress(addressData.emailAddress())
    	.enterFirstName(addressData.firstName())
    	.enterLastName(addressData.lastName())
    	.clickManuallyEnterAddressLink()
    	.enterAddressLine1(addressData.addressLine1())
    	.enterCity( addressData.city())
    	.selectState(addressData.state())
    	.enterZipCode("28088")
    	.enterPhoneNumber(addressData.phoneNumber());
    	WaitUtils.sleep(2000);
    	return this;
    }
    
    public ShippingAddressPageActionsFrig enterShippingAddressDetails(ShippingAddressData addressData, String zipCode) {
    	enterEmailAddress(addressData.emailAddress())
    	.enterFirstName(addressData.firstName())
    	.enterLastName(addressData.lastName())
    	.clickManuallyEnterAddressLink()
    	.enterAddressLine1(addressData.addressLine1())
    	.enterCity( addressData.city())
    	.selectState(addressData.state())
    	.enterZipCode(zipCode)
    	.enterPhoneNumber(addressData.phoneNumber());
    	WaitUtils.sleep(2000);
    	return this;
    }
    
    public ShippingAddressPageActionsFrig enterEmailAddress(String email) {
    	WebElementUtil.scrollIntoView(shipping_Locator.EMAIL_ADDRESS_TXT_FIELD);
    	WebElementUtil.sendKeys(shipping_Locator.EMAIL_ADDRESS_TXT_FIELD,email);
    	return this;
    }
    
    public ShippingAddressPageActionsFrig enterFirstName(String firstName) {
    	WebElementUtil.scrollIntoView(shipping_Locator.FIRST_NAME);
    	WebElementUtil.sendKeys(shipping_Locator.FIRST_NAME,firstName);
    	return this;
    }
    
    public ShippingAddressPageActionsFrig enterLastName(String lastName) {
    	WebElementUtil.scrollIntoView(shipping_Locator.LAST_NAME);
    	WebElementUtil.sendKeys(shipping_Locator.LAST_NAME,lastName);
    	return this;
    }
    
    public ShippingAddressPageActionsFrig clickManuallyEnterAddressLink() {
    	WebElementUtil.scrollIntoView(shipping_Locator.MANUALLY_ENTER_ADDRESS_LINK);
    	WebElementUtil.clickElement(shipping_Locator.MANUALLY_ENTER_ADDRESS_LINK);
    	return this;
    }
    
    public ShippingAddressPageActionsFrig enterCity(String city) {
    	WebElementUtil.scrollIntoView(shipping_Locator.CITY);	
    	WebElementUtil.sendKeys(shipping_Locator.CITY,city);
    	return this;
    }
    
    public ShippingAddressPageActionsFrig selectState(String state) {
    	WebElementUtil.scrollIntoView(shipping_Locator.STATE_TXTFIELD);	
    	WebElementUtil.clickElement(shipping_Locator.STATE_TXTFIELD);
    	WebElementUtil.sendKeys(shipping_Locator.STATE_TXTFIELD,state);
    	WebElementUtil.clickElement(shipping_Locator.selectState(state));
    	return this;
    }
    
    public ShippingAddressPageActionsFrig enterZipCode(String zipCode) {
    	WebElementUtil.scrollIntoView(shipping_Locator.ZIPCODE);	
    	WebElementUtil.sendKeys(shipping_Locator.ZIPCODE,zipCode);
    	return this;
    }
    
    public ShippingAddressPageActionsFrig enterPhoneNumber(String phoneNumber) {
    	WebElementUtil.scrollIntoView(shipping_Locator.PHONE_NUMBER);
    	WebElementUtil.sendKeys(shipping_Locator.PHONE_NUMBER,phoneNumber);
    	return this;
    }
    
    public DeliveryDatePageActionsFrig clickContinueToDeliveryButton() {
    	WebElementUtil.scrollIntoView(shipping_Locator.CONTINUE_TO_DELIVERY_BTN);
    	WebElementUtil.clickElement(shipping_Locator.CONTINUE_TO_DELIVERY_BTN);
    	if(WebElementUtil.isDisplayed(shipping_Locator.SAVE_AND_CONTINUE_BTN)) {
    		clickSaveAndContinueButton();
    	}
    	return new DeliveryDatePageActionsFrig();
    }
    
    public DeliveryDatePageActionsFrig clickSaveAndContinueButton() {
    	WebElementUtil.scrollIntoView(shipping_Locator.SAVE_AND_CONTINUE_BTN);
    	WebElementUtil.clickElement(shipping_Locator.SAVE_AND_CONTINUE_BTN);
    	return new DeliveryDatePageActionsFrig();
    }
    
    public ShippingAddressPageActionsFrig enterAddressLine1(String addressLine1) {
    	WebElementUtil.scrollIntoView(shipping_Locator.ADRESS_LINE1);
    	WebElementUtil.sendKeys(shipping_Locator.ADRESS_LINE1,addressLine1);
    	return this;
    }


}
