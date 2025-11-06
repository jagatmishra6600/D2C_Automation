package com.automation.frigidaire.pages;

import static com.automation.frigidaire.utils.WaitUtils.untilClickable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.frigidaire.utils.ConfigReader;
import com.automation.frigidaire.utils.WebElementUtil;

public class FrigidaireCreateAccountPageActions {

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
	 
	 public FrigidaireCreateAccountPageActions navigateToCreateAccountPage() {
		WebElementUtil.navigateTo(ConfigReader.getProperty("app.url")+"createAccount");
        try {
            WebElement acceptBtn = untilClickable(acceptButtonLocator, 15);
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
		 return WebElementUtil.isDisplayed(createAccountTitle);	 
	 }
	 
	 public String getCreateAccountSignUpMessage() {
		 var environment = ConfigReader.getProperty("app.url");
		 if(environment.contains("electrolux")) {
			 return WebElementUtil.getText(createAccountAccessToExclusiveSignUpMessage);
		 }
		 else if(environment.contains("frigidaire")) {
			 return WebElementUtil.getText(createAccountAccessToExclusiveSignUpMessage);
		 }
		 else {
			 throw new IllegalStateException("Invalid Environment");
		 }
	 }
	 
	 public boolean isEmailAddressFieldDisplayed() {
		return WebElementUtil.isDisplayed(emailAddressField);
	 }
		
	 public boolean isPasswordFieldDisplayed() {
		return WebElementUtil.isDisplayed(passwordField);
	 }
	 
	 public boolean isConfirmPasswordFieldDisplayed() {
		return WebElementUtil.isDisplayed(confirmPasswordField);
	 }
	 
	 public boolean isFirstNameFieldDisplayed() {
		 return WebElementUtil.isDisplayed(firstNameField);
	 }	
	 
	 public boolean isLastNameFieldDisplayed() {
		 return WebElementUtil.isDisplayed(lastNameField);
	 }
	 
	 public boolean isConfirmPasswordFieldShowPasswordIconDisplayed() {
		 return WebElementUtil.isDisplayed(confirmFieldShowPasswordIcon);
	 }
	 
	 public boolean isPasswordFieldShowPasswordIconDisplayed() {
		 return WebElementUtil.isDisplayed(passwordFieldShowPasswordIcon);
	 }
	 
	 public boolean isShowPasswordIconsDisplayed() {
		 return isConfirmPasswordFieldShowPasswordIconDisplayed() &&
				 isPasswordFieldShowPasswordIconDisplayed();
	 }
	 
	 public String getElectroluxLinkedAccountMessage() {
		 return WebElementUtil.getText(electroluxLinkedAccountMessage);
	 }
	 
	 public boolean isTermsAndConditionsLinkDisplayed() {
		 return WebElementUtil.isDisplayed(termsAndConditionsLink);
	 }
	 
	 public boolean isPrivacyPolicyLinkDisplayed() {
		 return WebElementUtil.isDisplayed(privacyPolicyLink);
	 }
	 
	 public boolean isSubmitButtonDisplayed() {
		 return WebElementUtil.isDisplayed(submitButton);
	 }
	 
	 public boolean isHaveAnAccountAlreadyLinkDisplayed() {
		 return WebElementUtil.isDisplayed(haveAccountAlreadyLink);
	 }
	 
	 public boolean isAlternateLoginOptionsDisplayed() {
		return isSignInWithAppleButtonDisplayed() && isSignInWithGoogleButtonDisplayed();
	 }
		
	 public boolean isSignInWithAppleButtonDisplayed() {
		return WebElementUtil.isDisplayed(signInWithAppleButton);
	 }
		
	 public boolean isSignInWithGoogleButtonDisplayed() {
		return WebElementUtil.isDisplayed(signInWithGoogleButton);
	 }
	 
	 public FrigidaireCreateAccountPageActions enterEmailAddress(String emailAddress) {
		 WebElementUtil.sendKeys(emailAddressField, emailAddress);
		 return this;
	 }
	 
	 public FrigidaireCreateAccountPageActions enterPassword(String password) {
		 WebElementUtil.sendKeys(passwordField, password);
		 return this;
	 }
	 
	 public FrigidaireCreateAccountPageActions enterConfirmPassword(String password) {
		 WebElementUtil.sendKeys(confirmPasswordField, password);
		 return this;
	 }
	 public FrigidaireCreateAccountPageActions enterFirstName(String firstName) {
		 WebElementUtil.sendKeys(firstNameField, firstName);
		 return this;
	 }
	 
	 public FrigidaireCreateAccountPageActions enterLastName(String lastName) {
		 WebElementUtil.sendKeys(lastNameField, lastName);
		 return this;
	 }
	 
	 public FrigidaireCreateAccountPageActions createAccount(String emailAddress, String password, String firstName, String lastName) {
		 return enterEmailAddress(emailAddress)
					 	.enterFirstName(firstName)
					 	.enterLastName(lastName)
					 	.enterPassword(password)
					 	.enterConfirmPassword(password)
					 	.clickSubmitButton();
	 }
	 
	 public FrigidaireCreateAccountPageActions clickSubmitButton() {
		 WebElementUtil.scrollIntoView(submitButton);
		 WebElementUtil.clickElement(submitButton);
		 return this;
	 }
	 
	 public String getVerificationEmailSentMessage() {
		 WebElementUtil.scrollIntoView(verificationEmailSentMessage);
		 return WebElementUtil.getText(verificationEmailSentMessage);
	 }
	 
	 public boolean isHereToHelpBannerDisplayed() {
		 return WebElementUtil.isDisplayed(hereToHelpBanner);
	 }
	 
	 public boolean isHereToHelpBannerPhoneSectionDisplayed() {
		 return WebElementUtil.isDisplayed(hereToHelpBannerPhoneSection);
	 }
	 
	 public boolean isHereToHelpBannerChatSectionDisplayed() {
		 return WebElementUtil.isDisplayed(hereToHelpBannerChatSection);
	 }
	 
	 public boolean isAlreadyHaveAccountLinkDisplayed() {
		 var environment = ConfigReader.getProperty("app.url");
		 if(environment.contains("electrolux")) {
			 return WebElementUtil.isDisplayed(alreadyHaveAnAccountLink);
		 }
		 else if(environment.contains("frigidaire")) {
			 return WebElementUtil.isDisplayed(haveAccountAlreadyLink);
		 }
		 else {
			 throw new IllegalStateException("Invalid Environment");
		 }
	 }
	 
	 public boolean isCreateAccountSignUpMessageDisplayed() {
		 return WebElementUtil.isDisplayed(createAccountSignUpMessage);
	 }
	 
	 public boolean isElectroluxGroupLinkedAccountMessageDisplayed() {
		 return WebElementUtil.isDisplayed(electroluxLinkedAccountMessage);
	 }
	 
	 
}
