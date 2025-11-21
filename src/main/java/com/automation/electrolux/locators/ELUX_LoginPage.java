package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class ELUX_LoginPage {

	 public static final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	 public static final By emailAddressInput = By.xpath("//input[@placeholder='Email address *' or @placeholder='jane.doe@company.com *']");
	 public static final By passwordInput = By.xpath("//input[@placeholder='Password *' or contains(@id,'gigya-password')]");
	 public static final By loginButton = By.cssSelector("input[value='Log in']");
	 public static final By loginToStoreTitle = By.xpath("//h2[normalize-space()='Log in to Frigidaire' or normalize-space()='Log in to Electrolux']");
	 public static final By loginTitleMessage = By.xpath("//label[normalize-space()='Log in with your email and password: *']");
	 public static final By showPasswordIcon = By.cssSelector("button[title='Show Password'] i");
	 public static final By keepMeLoggedInCheckbox = By.xpath("//input[@id='gigya-checkbox-remember']");
	 public static final By notRecommendedMessage = By.xpath("//label[contains(.,'shared or public device')]");
	 public static final By forgotPasswordLink = By.xpath("//a[@id='login-forgot-password-link']");
	 public static final By createAccountLink = By.xpath("//a[contains(.,'Create an account') and contains(@class,'button-style')]");
	 public static final By electroluxLinkedAccountMessage = By.xpath("//label[contains(.,'part of the Electrolux Group')]");
	 public static final By signInWithAppleButton = By.id("Apple_btn");
	 public static final By signInWithGoogleButton = By.id("Google_btn");
	 
}
