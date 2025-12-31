package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class ResetPasswordLocatorsElux {
	 public static final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	 public static final By submitButton = By.cssSelector("input[value='Submit']");
	 public static final By newPasswordInput = By.cssSelector("input[placeholder='New password *']");
	 public static final By confirmPasswordInput = By.cssSelector("input[placeholder='Confirm password']");
	 public static final By changePasswordTitle = By.xpath("//h2[normalize-space()='Change Password']");
	 public static final By newPasswordShowHideIcon = By.xpath("//input[@placeholder='New password *']/parent::div//button[@title='Show Password']");
	 public static final By confirmPasswordShowHideIcon = By.xpath("//input[@placeholder='Confirm password']/parent::div//button[@title='Show Password']");
	 public static final By setNewPasswordMessage = By.xpath("//label[contains(.,'Set a new password')]");
	 public static final By passwordRulesMessage = By.xpath("//label[contains(.,'Password needs')]");
	 public static final By credentialsUpdateAccrossGroupMessage = By.xpath("//label[contains(.,'reset will update')]");
	 public static final By resetPasswordSucccessScreenMessage = By.xpath("//div[@id='gigya-reset-password-success-screen']//label/parent::div");
	 public static final By loginToYourAccountLink = By.cssSelector("a#reset-password-login-link");
	
}
