package com.automation.electrolux.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automation.electrolux.locators.CreateAccountLocatorsElux;
import com.automation.models.CreateAccountData;
import com.automation.utils.ConfigReader;
import com.automation.utils.WebElementUtil;

public class CreateAccountPageActionsElux {

	 public CreateAccountPageActionsElux navigateToCreateAccountPage() {
		WebElementUtil.navigateTo(ConfigReader.getAppUrl()+"createAccount");
       try {
           WebElement acceptBtn = untilClickable(CreateAccountLocatorsElux.acceptButtonLocator, 15);
           if (acceptBtn != null) {
               acceptBtn.click();
           }
       } catch (Exception ignored) {
           // Cookie banner not present or not interactable; continue
       }
       return this;
	}
	 
	 public boolean isCreateAccountPageLoaded() {
		 return isCreateAccountButtonDisplayed();
	 }
	 
	 public boolean isCreateAnAccountTitleDisplayed() {
		 return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.createAccountTitle);
	 }
	 
	 public String getCreateAccountSignUpMessage() {
		 return WebElementUtil.getText(CreateAccountLocatorsElux.accessToExclusiveSignUpMessage);
	 }
	 
	 public boolean isEmailAddressFieldDisplayed() {
		return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.emailAddressField);
	 }
		
	 public boolean isPasswordFieldDisplayed() {
		return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.passwordField);
	 }
	 
	 public boolean isConfirmPasswordFieldDisplayed() {
		return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.confirmPasswordField);
	 }
	 
	 public boolean isFirstNameFieldDisplayed() {
		 return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.firstNameField);
	 }	
	 
	 public boolean isLastNameFieldDisplayed() {
		 return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.lastNameField);
	 }
	 
	 public boolean isConfirmPasswordFieldShowPasswordIconDisplayed() {
		 return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.confirmFieldShowPasswordIcon);
	 }
	 
	 public boolean isPasswordFieldShowPasswordIconDisplayed() {
		 return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.passwordFieldShowPasswordIcon);
	 }
	 
	 public boolean isShowPasswordIconsDisplayed() {
		 WebElementUtil.scrollIntoView(CreateAccountLocatorsElux.passwordFieldShowPasswordIcon);
		 return isConfirmPasswordFieldShowPasswordIconDisplayed() &&
				 isPasswordFieldShowPasswordIconDisplayed();
	 }
	 
	 public String getElectroluxLinkedAccountMessage() {
		 return WebElementUtil.getText(CreateAccountLocatorsElux.electroluxLinkedAccountMessage);
	 }
	 
	 public boolean isTermsAndConditionsLinkDisplayed() {
		 return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.termsAndConditionsLink);
	 }
	 
	 public boolean isPrivacyPolicyLinkDisplayed() {
		 return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.privacyPolicyLink);
	 }
	 
	 public boolean isCreateAccountButtonDisplayed() {
		 return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.createAccountButton);
	 }
	 
	 public boolean isHaveAnAccountAlreadyLinkDisplayed() {
		 return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.haveAccountAlreadyLink);
	 }
	 
	 public boolean isAlternateLoginOptionsDisplayed() {
		return isSignInWithAppleButtonDisplayed() && isSignInWithGoogleButtonDisplayed();
	 }
		
	 public boolean isSignInWithAppleButtonDisplayed() {
		return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.signInWithAppleButton);
	 }
		
	 public boolean isSignInWithGoogleButtonDisplayed() {
		return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.signInWithGoogleButton);
	 }
	 
	 public CreateAccountPageActionsElux enterEmailAddress(String emailAddress) {
		 WebElementUtil.sendKeys(CreateAccountLocatorsElux.emailAddressField, emailAddress);
		 return this;
	 }
	 
	 public CreateAccountPageActionsElux enterPassword(String password) {
		 WebElementUtil.sendKeys(CreateAccountLocatorsElux.passwordField, password);
		 return this;
	 }
	 
	 public CreateAccountPageActionsElux enterConfirmPassword(String password) {
		 WebElementUtil.sendKeys(CreateAccountLocatorsElux.confirmPasswordField, password);
		 return this;
	 }
	 public CreateAccountPageActionsElux enterFirstName(String firstName) {
		 WebElementUtil.sendKeys(CreateAccountLocatorsElux.firstNameField, firstName);
		 return this;
	 }
	 
	 public CreateAccountPageActionsElux enterLastName(String lastName) {
		 WebElementUtil.sendKeys(CreateAccountLocatorsElux.lastNameField, lastName);
		 return this;
	 }
	 
	 public CreateAccountPageActionsElux createAccount(String emailAddress, String password, String firstName, String lastName) {
		 return enterEmailAddress(emailAddress)
					 	.enterFirstName(firstName)
					 	.enterLastName(lastName)
					 	.enterPassword(password)
					 	.enterConfirmPassword(password)
					 	.clickCreateAccountButton();
	 }
	 
	 public CreateAccountPageActionsElux createAccount(CreateAccountData data) {
		 return enterEmailAddress(data.emailAddress())
					 	.enterFirstName(data.firstName())
					 	.enterLastName(data.lastName())
					 	.enterPassword(data.password())
					 	.enterConfirmPassword(data.password())
					 	.clickCreateAccountButton();
	 }
	 
	 
	 
	 public CreateAccountPageActionsElux clickCreateAccountButton() {
		 WebElementUtil.scrollIntoView(CreateAccountLocatorsElux.createAccountButton);
		 WebElementUtil.clickElement(CreateAccountLocatorsElux.createAccountButton);
		 return this;
	 }
	 
	 public String getVerificationEmailSentMessage() {
		 WebElementUtil.isDisplayed(CreateAccountLocatorsElux.verificationEmailSentMessage);
		 WebElementUtil.scrollIntoView(CreateAccountLocatorsElux.verificationEmailSentMessage);
		 return WebElementUtil.getText(CreateAccountLocatorsElux.verificationEmailSentMessage);
	 }
	 
	 public boolean isHereToHelpBannerDisplayed() {
		 return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.hereToHelpBanner);
	 }
	 
	 public boolean isHereToHelpBannerPhoneSectionDisplayed() {
		 return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.hereToHelpBannerPhoneSection);
	 }
	 
	 public boolean isHereToHelpBannerChatSectionDisplayed() {
		 return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.hereToHelpBannerChatSection);
	 }
	 
	 public boolean isAlreadyHaveAccountLinkDisplayed() {
			 return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.alreadyHaveAnAccountLink);
	 }
	 
	 public boolean isCreateAccountSignUpMessageDisplayed() {
		 return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.createAccountSignUpMessage);
	 }
	 
	 public boolean isElectroluxGroupLinkedAccountMessageDisplayed() {
		 return WebElementUtil.isDisplayed(CreateAccountLocatorsElux.electroluxLinkedAccountMessage);
	 }
	 
	 public boolean isAccountBenefitsLabelsDisplayed() {
		    return !WebElementUtil.findElements(CreateAccountLocatorsElux.accountBenefitsLabelList)
		    					.isEmpty();
		}
	 
	 public void verifyCreateAccountPageFieldAndMessages() {
		 Assert.assertTrue(isCreateAnAccountTitleDisplayed(),"Create An Account title is not displayed");
	 	Assert.assertEquals(getCreateAccountSignUpMessage(),"Get access to exclusive savings, easy order tracking and faster checkout."
	 			,"Create Account Sign Up Message 'Get access to exclusive savings' is not displayed");    	
	 	Assert.assertTrue(isEmailAddressFieldDisplayed(),"Email Address Field is not displayed");
	 	Assert.assertTrue(isPasswordFieldDisplayed(),"Password Field is not displayed");
	 	Assert.assertTrue(isConfirmPasswordFieldDisplayed(),"Confirm Password Field is not displayed");
	 	Assert.assertTrue(isFirstNameFieldDisplayed(),"First Name Field is not displayed");
	 	Assert.assertTrue(isLastNameFieldDisplayed(),"Last Name Field is not displayed");
	 	Assert.assertTrue(isShowPasswordIconsDisplayed(),"Show Password Icons for Confirm Password and Password Fields are not Displayed");
	 	Assert.assertTrue(isElectroluxGroupLinkedAccountMessageDisplayed(),"Electrolux Group Linked Account Message is not Displayed");
	 	Assert.assertTrue(isTermsAndConditionsLinkDisplayed(),"Terms and Conditions Link is not displayed");
	 	Assert.assertTrue(isPrivacyPolicyLinkDisplayed(),"Privacy Policy Link is not displayed");
	 	Assert.assertTrue(isCreateAccountButtonDisplayed(),"Submit Button is not displayed");
	 	Assert.assertTrue(isAlreadyHaveAccountLinkDisplayed(),"Already have an account Log in link is not displayed");
	 	Assert.assertTrue(isAlternateLoginOptionsDisplayed(),"Sign in Options with Google or Apple is not Displayed");
	 	Assert.assertTrue(isAccountBenefitsLabelsDisplayed(),"Account Benefits are not mentioned in Create Account Page");
	 	Assert.assertTrue(isHereToHelpBannerDisplayed(),"We're here to help banner is not displayed");
	 	Assert.assertTrue(isHereToHelpBannerPhoneSectionDisplayed(),"Help Banner with Phone Section is not displayed");
	 	Assert.assertTrue(isHereToHelpBannerChatSectionDisplayed(),"Help Banner with Chat Section is not displayed");
		}
	 
}
