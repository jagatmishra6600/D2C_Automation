package com.automation.frigidaire.pages;

import static com.automation.utils.WaitUtils.*;
import static com.automation.utils.WebElementUtil.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.automation.utils.ConfigReader;

public class CreateAccountPageActionsFrig {

	private final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");

	 private final By submitButton = By.xpath("//input[@value='Submit' or @value='Create account']");
	 private final By createAccountTitle = By.xpath("//h2[normalize-space()='Create an account']");
	 private final By createAccountSignUpMessage = By.xpath("//h2[contains(.,'Sign up and make')]");
	 private final By emailAddressField = By.xpath("//input[@placeholder='Email address *' or @placeholder='jane.doe@company.com *']");
	 private final By passwordField = By.xpath("//input[@placeholder='Password *' or contains(@id,'gigya-password-1')]");
	 private final By confirmPasswordField = By.xpath("//input[@placeholder='Confirm Password *' or contains(@id,'gigya-password-10') or contains(@id,'gigya-password-5')]");
	 private final By firstNameField = By.xpath("//input[@placeholder='First Name *' or @placeholder='Jane *']");
	 private final By lastNameField = By.xpath("//input[@placeholder='Last Name *' or @placeholder='Doe *']");
	 private final By confirmFieldShowPasswordIcon = By.xpath("//input[@placeholder='Confirm Password *' or contains(@id,'gigya-password-5') or contains(@id,'gigya-password-10')]/parent::div//i");
	 private final By passwordFieldShowPasswordIcon = By.xpath("//input[@placeholder='Password *' or contains(@id,'gigya-password-1')]/parent::div//i");
	 private final By electroluxLinkedAccountMessage = By.xpath("//label[contains(.,'Electrolux group') or contains(.,'Electrolux Group')]");
	 private final By termsAndConditionsLink = By.xpath("//a[@id='register-terms-link']");
	 private final By privacyPolicyLink = By.xpath("//a[@id='register-privacy-link']");
	 private final By haveAccountAlreadyLink = By.id("register-already-have-act-link");
	 private final By signInWithAppleButton = By.id("Apple_btn");
	 private final By signInWithGoogleButton = By.id("Google_btn");
	 private final By verificationEmailSentMessage = By.cssSelector("#gigya-verification-sent-screen label");
	 private final By hereToHelpBanner = By.cssSelector("app-elux-question-banner");
	 private final By hereToHelpBannerPhoneSection = By.cssSelector("app-elux-question-banner .phoneSection");
	 private final By hereToHelpBannerChatSection = By.cssSelector("app-elux-question-banner .chatSection");
	 private final By alreadyHaveAnAccountLink = By.xpath("//label[contains(.,'Already have an account')]//a");
	 private final By createAccountAccessToExclusiveSignUpMessage = By.xpath("//label[contains(.,'Get access to exclusive savings')]");
	 
	 public CreateAccountPageActionsFrig navigateToCreateAccountPage() {
		navigateTo(ConfigReader.getAppUrl()+"createAccount");
       try {
           WebElement acceptBtn = untilClickable(acceptButtonLocator);
           if (acceptBtn != null) {
               acceptBtn.click();
           }
       } catch (Exception ignored) {
           // Cookie banner not present or not interactable; continue
       }
       return this;
	}
	 
	 public boolean isCreateAccountPageLoaded() {
		 return isSubmitButtonDisplayed();
	 }
	 
	 public boolean isCreateAnAccountTitleDisplayed() {
		 return isDisplayed(createAccountTitle);	 
	 }
	 
	 public String getCreateAccountSignUpMessage() {
		 var brand = ConfigReader.getProperty("brand");
		 if(brand.equalsIgnoreCase("electrolux")) {
			 return getText(createAccountAccessToExclusiveSignUpMessage);
		 }
		 else if(brand.equalsIgnoreCase("frigidaire")) {
			 return getText(createAccountAccessToExclusiveSignUpMessage);
		 }
		 else {
			 throw new IllegalStateException("Invalid Environment");
		 }
	 }
	 
	 public boolean isEmailAddressFieldDisplayed() {
		return isDisplayed(emailAddressField);
	 }
		
	 public boolean isPasswordFieldDisplayed() {
		return isDisplayed(passwordField);
	 }
	 
	 public boolean isConfirmPasswordFieldDisplayed() {
		return isDisplayed(confirmPasswordField);
	 }
	 
	 public boolean isFirstNameFieldDisplayed() {
		 return isDisplayed(firstNameField);
	 }	
	 
	 public boolean isLastNameFieldDisplayed() {
		 return isDisplayed(lastNameField);
	 }
	 
	 public boolean isConfirmPasswordFieldShowPasswordIconDisplayed() {
		 return isDisplayed(confirmFieldShowPasswordIcon);
	 }
	 
	 public boolean isPasswordFieldShowPasswordIconDisplayed() {
		 return isDisplayed(passwordFieldShowPasswordIcon);
	 }
	 
	 public boolean isShowPasswordIconsDisplayed() {
		 scrollIntoView(passwordFieldShowPasswordIcon);
		 return isConfirmPasswordFieldShowPasswordIconDisplayed() &&
				 isPasswordFieldShowPasswordIconDisplayed();
	 }
	 
	 public String getElectroluxLinkedAccountMessage() {
		 return getText(electroluxLinkedAccountMessage);
	 }
	 
	 public boolean isTermsAndConditionsLinkDisplayed() {
		 return isDisplayed(termsAndConditionsLink);
	 }
	 
	 public boolean isPrivacyPolicyLinkDisplayed() {
		 return isDisplayed(privacyPolicyLink);
	 }
	 
	 public boolean isSubmitButtonDisplayed() {
		 return isDisplayed(submitButton);
	 }
	 
	 public boolean isHaveAnAccountAlreadyLinkDisplayed() {
		 return isDisplayed(haveAccountAlreadyLink);
	 }
	 
	 public boolean isAlternateLoginOptionsDisplayed() {
		return isSignInWithAppleButtonDisplayed() && isSignInWithGoogleButtonDisplayed();
	 }
		
	 public boolean isSignInWithAppleButtonDisplayed() {
		return isDisplayed(signInWithAppleButton);
	 }
		
	 public boolean isSignInWithGoogleButtonDisplayed() {
		return isDisplayed(signInWithGoogleButton);
	 }
	 
	 public CreateAccountPageActionsFrig enterEmailAddress(String emailAddress) {
		 sendKeys(emailAddressField, emailAddress);
		 return this;
	 }
	 
	 public CreateAccountPageActionsFrig enterPassword(String password) {
		 sendKeys(passwordField, password);
		 return this;
	 }
	 
	 public CreateAccountPageActionsFrig enterConfirmPassword(String password) {
		 sendKeys(confirmPasswordField, password);
		 return this;
	 }
	 public CreateAccountPageActionsFrig enterFirstName(String firstName) {
		 sendKeys(firstNameField, firstName);
		 return this;
	 }
	 
	 public CreateAccountPageActionsFrig enterLastName(String lastName) {
		 sendKeys(lastNameField, lastName);
		 return this;
	 }
	 
	 public CreateAccountPageActionsFrig createAccount(String emailAddress, String password, String firstName, String lastName) {
		 return enterEmailAddress(emailAddress)
					 	.enterFirstName(firstName)
					 	.enterLastName(lastName)
					 	.enterPassword(password)
					 	.enterConfirmPassword(password)
					 	.clickSubmitButton();
	 }
	 
	 public CreateAccountPageActionsFrig clickSubmitButton() {
		 scrollIntoView(submitButton);
		 clickElement(submitButton);
		 return this;
	 }
	 
	 public String getVerificationEmailSentMessage() {
		 isDisplayed(verificationEmailSentMessage);
		 scrollIntoView(verificationEmailSentMessage);
		 return getText(verificationEmailSentMessage);
	 }
	 
	 public boolean isHereToHelpBannerDisplayed() {
		 return isDisplayed(hereToHelpBanner);
	 }
	 
	 public boolean isHereToHelpBannerPhoneSectionDisplayed() {
		 return isDisplayed(hereToHelpBannerPhoneSection);
	 }
	 
	 public boolean isHereToHelpBannerChatSectionDisplayed() {
		 return isDisplayed(hereToHelpBannerChatSection);
	 }
	 
	 public boolean isAlreadyHaveAccountLinkDisplayed() {
		 var environment = ConfigReader.getProperty("app.url");
		 if(environment.contains("electrolux")) {
			 return isDisplayed(alreadyHaveAnAccountLink);
		 }
		 else if(environment.contains("frigidaire")) {
			 return isDisplayed(haveAccountAlreadyLink);
		 }
		 else {
			 throw new IllegalStateException("Invalid Environment");
		 }
	 }
	 
	 public boolean isCreateAccountSignUpMessageDisplayed() {
		 return isDisplayed(createAccountSignUpMessage);
	 }
	 
	 public boolean isElectroluxGroupLinkedAccountMessageDisplayed() {
		 return isDisplayed(electroluxLinkedAccountMessage);
	 }
	 
	 public void verifyCreateAccountPageFieldAndMessages() {
		 Assert.assertTrue(isCreateAnAccountTitleDisplayed(), "Create An Account title is not displayed");
         Assert.assertEquals(getCreateAccountSignUpMessage(),"Get access to exclusive savings, easy order tracking and faster checkout."
	 			,"Create Account Sign Up Message 'Get access to exclusive savings' is not displayed");    	
	 	 Assert.assertTrue(isEmailAddressFieldDisplayed(), "Email Address Field is not displayed");
         Assert.assertTrue(isPasswordFieldDisplayed(), "Password Field is not displayed");
         Assert.assertTrue(isConfirmPasswordFieldDisplayed(), "Confirm Password Field is not displayed");
         Assert.assertTrue(isFirstNameFieldDisplayed(), "First Name Field is not displayed");
         Assert.assertTrue(isLastNameFieldDisplayed(), "Last Name Field is not displayed");
         Assert.assertTrue(isShowPasswordIconsDisplayed(), "Show Password Icons for Confirm Password and Password Fields are not Displayed");
         Assert.assertEquals(getElectroluxLinkedAccountMessage(), "*Frigidaire is part of the Electrolux Group. If you already have an account with Electrolux.com, you can use those details to log in."
        							, "Electrolux linked Account Message is not Displayed");
         Assert.assertTrue(isTermsAndConditionsLinkDisplayed(), "Terms and Conditions Link is not displayed");
         Assert.assertTrue(isPrivacyPolicyLinkDisplayed(), "Privacy Policy Link is not displayed");
         Assert.assertTrue(isSubmitButtonDisplayed(), "Submit Button is not displayed");
         Assert.assertTrue(isHaveAnAccountAlreadyLinkDisplayed(), "Have an Account Already link is not displayed");
         Assert.assertTrue(isAlternateLoginOptionsDisplayed(), "Sign in Options with Google or Apple is not Displayed");
         Assert.assertTrue(isHereToHelpBannerDisplayed(), "We're here to help banner is not displayed");
         Assert.assertTrue(isHereToHelpBannerPhoneSectionDisplayed(), "Help Banner with Phone Section is not displayed");
         Assert.assertTrue(isHereToHelpBannerChatSectionDisplayed(), "Help Banner with Chat Section is not displayed");
	 }
	 
}
