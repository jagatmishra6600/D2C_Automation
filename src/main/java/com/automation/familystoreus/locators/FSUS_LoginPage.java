package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class FSUS_LoginPage {
	
	public static final By emailAddressInput = By.xpath("//input[@id='userId']");	 
	public static final By passwordInput = By.xpath("//input[@id='password']");
	public static final By loginButton = By.xpath("//button[normalize-space()='Log In']");
	public static final By termsAndConditionsCheckbox = By.cssSelector("#termsAndConditionsCheck");
	public static final By forgotYourPasswordLink = By.xpath("//a[contains(.,'Forgot your password')]");
	public static final By registerWithInvitationCodeLink = By.xpath("//a[contains(.,'Register with your invitation code')]");
	 
}
