package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class ELUX_ForgotPasswordPage {

	 public static final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	 public static final By resetPasswordButton = By.xpath("//input[@value='Reset Password' or @value='Send reset link']");
	 public static final By emailAddressInput = By.xpath("//input[@placeholder='Email address *' or @placeholder='jane.doe@company.com *']");	
	 public static final By checkYourEmailMessage = By.xpath("//h2[normalize-space()='Check your email' or normalize-space() = 'Check your inbox']//ancestor::div[contains(@id,'forgot-password-success')]");
	 public static final By resetPasswordTitle = By.xpath("//h2[normalize-space()='Reset Password']");	 
	 public static final By confirmEmailAddressMessage = By.xpath("//h2[contains(.,'Reset Password')]/parent::div/label");
	 public static final By backToLoginLink = By.cssSelector("#forgot-password-back-link");
	 public static final By createAnAccountLink = By.cssSelector("#login-create-account-link");
	 public static final By dontHaveAccountMessage = By.xpath("//label[@id='dont-have-account' and @class='resetPassLabel']");
	 public static final By helpLineBanner = By.cssSelector("app-elux-question-banner");
}
