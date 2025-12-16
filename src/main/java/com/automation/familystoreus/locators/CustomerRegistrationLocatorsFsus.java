package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class CustomerRegistrationLocatorsFsus {
	
	 public static final By welcomeTitle = By.xpath("//h1[contains(.,'Welcome')]");
	 public static final By marketingBanner = By.cssSelector("app-home-page-banner");
	 public static final By alreadyHaveAccountAndCompleteRegistrationMessage = By.xpath("//cx-paragraph//strong");
	 public static final By alreadyHaveAccountLoginHereLink = By.xpath("//cx-paragraph//strong//a");
	 public static final By firstNameField = By.xpath("//input[@id='first']");
	 public static final By lastNameField = By.xpath("//input[@id='last']");
	 public static final By zipCodeField = By.xpath("//input[@id='postalCode']");
	 public static final By emailAddressField = By.xpath("//input[@id='email']");
	 public static final By passwordField = By.xpath("//input[@id='password']");
	 public static final By passwordFieldShowPasswordEyeIcon = By.xpath("//input[@id='password']//parent::div//img[contains(@alt,'Eyeball')]");
	 public static final By invitationCodeField = By.xpath("//input[@id='inviteCode']");
	 public static final By termsAndConditionsMessage = By.xpath("//p[contains(text(),'I agree')]");
	 public static final By acknowledgementMessage = By.xpath("//p[contains(text(),'I acknowledge')]");
	 public static final By consentCheckBox = By.xpath("//input[@id='promoConsentCheck']");
	 public static final By createAccountButton = By.id("createAccountBtn");
	 public static final By cancelButton = By.xpath("//button[@type='reset' and contains(.,'Cancel')]");
	 	
}

