package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class ELUX_CreateAccountPage {

	public static final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");

	 public static final By createAccountButton = By.xpath("//input[@value='Submit' or @value='Create account']");
	 public static final By createAccountTitle = By.xpath("//h2[normalize-space()='Create an account']");
	 public static final By createAccountSignUpMessage = By.xpath("//h2[contains(.,'Sign up and make')]");
	 public static final By emailAddressField = By.xpath("//input[@placeholder='Email address *' or @placeholder='jane.doe@company.com *']");
	 public static final By passwordField = By.xpath("//input[@placeholder='Password *' or contains(@id,'gigya-password-1')]");
	 public static final By confirmPasswordField = By.xpath("//input[@placeholder='Confirm Password *' or contains(@id,'gigya-password-5')]");
	 public static final By firstNameField = By.xpath("//input[@placeholder='First Name *' or @placeholder='Jane *']");
	 public static final By lastNameField = By.xpath("//input[@placeholder='Last Name *' or @placeholder='Doe *']");
	 public static final By confirmFieldShowPasswordIcon = By.xpath("//input[@placeholder='Confirm Password *' or contains(@id,'gigya-password-5')]/parent::div//i");
	 public static final By passwordFieldShowPasswordIcon = By.xpath("//input[@placeholder='Password *' or contains(@id,'gigya-password-1')]/parent::div//i");
	 public static final By electroluxLinkedAccountMessage = By.xpath("//label[contains(.,'Electrolux group') or contains(.,'Electrolux Group')]");
	 public static final By termsAndConditionsLink = By.xpath("//a[@id='register-terms-link']");
	 public static final By privacyPolicyLink = By.xpath("//a[@id='register-privacy-link']");
	 public static final By haveAccountAlreadyLink = By.id("register-already-have-act-link");
	 public static final By signInWithAppleButton = By.id("Apple_btn");
	 public static final By signInWithGoogleButton = By.id("Google_btn");
	 public static final By verificationEmailSentMessage = By.cssSelector("#gigya-verification-sent-screen label");
	 public static final By hereToHelpBanner = By.cssSelector("app-elux-question-banner");
	 public static final By hereToHelpBannerPhoneSection = By.cssSelector("app-elux-question-banner .phoneSection");
	 public static final By hereToHelpBannerChatSection = By.cssSelector("app-elux-question-banner .chatSection");
	 public static final By alreadyHaveAnAccountLink = By.xpath("//label[contains(.,'Already have an account')]//a");
	 public static final By accessToExclusiveSignUpMessage = By.xpath("//label[contains(.,'Get access to exclusive savings')]");	
	 public static final By accountBenefitsLabelList = By.xpath("//label[contains(.,'Why create an account')]/parent::div//div//label");
}
