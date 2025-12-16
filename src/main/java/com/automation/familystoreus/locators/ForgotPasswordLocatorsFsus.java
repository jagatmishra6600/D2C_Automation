package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class ForgotPasswordLocatorsFsus {
	
	 public static final By emailAddressInput = By.xpath("//input[@placeholder='E-Mail Address']");	 
	 public static final By sendNewPasswordButton = By.xpath("//button[contains(.,'Send New Password')]");
	 public static final By resetPasswordEmailSentMessage = By.xpath("//div[@class='forgot-password-link-message']//span");	 
}

