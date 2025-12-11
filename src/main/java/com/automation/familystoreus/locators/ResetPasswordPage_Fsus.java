package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class ResetPasswordPage_Fsus {
	
	 public static final By submitButton = By.xpath("//button[normalize-space()='Submit']");
	 public static final By newPasswordInput = By.cssSelector("input[placeholder='Password']");
	 public static final By confirmPasswordInput = By.cssSelector("input[placeholder='Confirm Password']");
	 public static final By resetPasswordTitle = By.xpath("//h1[normalize-space()='Reset Password']");
	 public static final By resetPasswordSuccessMessage = By.cssSelector(".reset-password-link-message");
	 public static final By loginLink = By.xpath("//a[@href='/login']");
	 
}

