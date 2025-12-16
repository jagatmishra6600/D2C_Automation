package com.automation.familystoreus.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automation.familystoreus.locators.CustomerRegistrationLocatorsFsus;
import com.automation.familystoreus.locators.HomeLocatorsFsus;
import com.automation.models.FSCreateAccountData;
import com.automation.utils.ConfigReader;
import com.automation.utils.WebElementUtil;

public class CustomerRegistrationPageActionsFsus {

	 public CustomerRegistrationPageActionsFsus navigateToCreateAccountPage() {
		WebElementUtil.navigateTo(ConfigReader.getAppUrl()+"createAccount");
        try {
            WebElement acceptBtn = untilClickable(HomeLocatorsFsus.acceptButtonLocator, 15);
            if (acceptBtn != null) {
                acceptBtn.click();
            }
        } catch (Exception ignored) {
            // Cookie banner not present or not interactable; continue
        }
        return this;
	}
	 
	 public boolean isWelcomeTitleDisplayed() {
		 return WebElementUtil.isDisplayed(CustomerRegistrationLocatorsFsus.welcomeTitle);
	 }
	 
	 public boolean isMarketingBannerDisplayed() {
		 return WebElementUtil.isDisplayed(CustomerRegistrationLocatorsFsus.marketingBanner);
	 }
	 
	 public boolean isAlreadyHaveAnAccountMessageDisplayed() {
		 return WebElementUtil.getText(CustomerRegistrationLocatorsFsus.alreadyHaveAccountAndCompleteRegistrationMessage)
				 .contains("Already have an account?");
	 }
	 
	 public boolean isCompleteTheRegistrationMessageDisplayed() {
		 return WebElementUtil.getText(CustomerRegistrationLocatorsFsus.alreadyHaveAccountAndCompleteRegistrationMessage)
				 .contains("To join the program, please complete the registration form below:");
	 }
	 
	 public boolean isFirstNameFieldDisplayed() {
		 return WebElementUtil.isDisplayed(CustomerRegistrationLocatorsFsus.firstNameField);
	 }	
	 
	 public boolean isLastNameFieldDisplayed() {
		 return WebElementUtil.isDisplayed(CustomerRegistrationLocatorsFsus.lastNameField);
	 }
	 
	 public boolean isZipCodeFieldDisplayed() {
		 return WebElementUtil.isDisplayed(CustomerRegistrationLocatorsFsus.zipCodeField);
	 }

	 public boolean isEmailAddressFieldDisplayed() {
		 return WebElementUtil.isDisplayed(CustomerRegistrationLocatorsFsus.emailAddressField);
	 }
	 
	 public boolean isPasswordFieldDisplayed() {
		return WebElementUtil.isDisplayed(CustomerRegistrationLocatorsFsus.passwordField);
	 }
	 
	 public boolean isPasswordFieldShowPasswordEyeIconDisplayed() {
		 return WebElementUtil.isDisplayed(CustomerRegistrationLocatorsFsus.passwordFieldShowPasswordEyeIcon);
	 }
	 
	 public boolean isInvitationCodeFieldDisplayed() {
		 return WebElementUtil.isDisplayed(CustomerRegistrationLocatorsFsus.invitationCodeField);
	 }
	 
	 public boolean isAcknowledgementMessageDisplayed() {
		 return WebElementUtil.isDisplayed(CustomerRegistrationLocatorsFsus.acknowledgementMessage);
	 }
	 
	 public boolean isTermsAndConditionsMessageDisplayed() {
		 return WebElementUtil.isDisplayed(CustomerRegistrationLocatorsFsus.termsAndConditionsMessage);
	 }
	 
	 public boolean isConsentCheckBoxDisplayed() {
		 return WebElementUtil.isDisplayed(CustomerRegistrationLocatorsFsus.consentCheckBox);
	 }
	 
	 public boolean isCreateAccountButtonDisplayed() {
		 return WebElementUtil.isDisplayed(CustomerRegistrationLocatorsFsus.createAccountButton);
	 }
	 
	 public boolean isCancelButtonDisplayed() {
		 return WebElementUtil.isDisplayed(CustomerRegistrationLocatorsFsus.cancelButton);
	 }
	 
	 public boolean isLoginHereLinkDisplayed() {
		 return WebElementUtil.isDisplayed(CustomerRegistrationLocatorsFsus.alreadyHaveAccountLoginHereLink);
	 }
	 
	 public CustomerRegistrationPageActionsFsus enterEmailAddress(String emailAddress) {
		 WebElementUtil.isDisplayed(CustomerRegistrationLocatorsFsus.emailAddressField);
		 WebElementUtil.scrollIntoView(CustomerRegistrationLocatorsFsus.emailAddressField);
		 WebElementUtil.sendKeys(CustomerRegistrationLocatorsFsus.emailAddressField, emailAddress);
		 return this;
	 }
	 
	 public CustomerRegistrationPageActionsFsus enterPassword(String password) {
		 WebElementUtil.scrollIntoView(CustomerRegistrationLocatorsFsus.passwordField);
		 WebElementUtil.sendKeys(CustomerRegistrationLocatorsFsus.passwordField, password);
		 return this;
	 }
	 
	 public CustomerRegistrationPageActionsFsus enterFirstName(String firstName) {
		 WebElementUtil.scrollIntoView(CustomerRegistrationLocatorsFsus.firstNameField);
		 WebElementUtil.sendKeys(CustomerRegistrationLocatorsFsus.firstNameField, firstName);
		 return this;
	 }
	 
	 public CustomerRegistrationPageActionsFsus enterLastName(String lastName) {
		 WebElementUtil.scrollIntoView(CustomerRegistrationLocatorsFsus.lastNameField);
		 WebElementUtil.sendKeys(CustomerRegistrationLocatorsFsus.lastNameField, lastName);
		 return this;
	 }
	 
	 public HomePageActionsFsus clickCreateAccountButton() {
		 WebElementUtil.clickElement(CustomerRegistrationLocatorsFsus.createAccountButton);
		 return new HomePageActionsFsus();
	 }
	 
	 public CustomerRegistrationPageActionsFsus enterInvitationCode(String invitationCode) {
		 WebElementUtil.sendKeys(CustomerRegistrationLocatorsFsus.invitationCodeField, invitationCode);
		 return this;
	 }
	 
	 public CustomerRegistrationPageActionsFsus enterZipCode(String zipCode) {
		 if(zipCode==null || zipCode.isEmpty() || zipCode.equals("")) {
			 zipCode = "400001";
		 }
		 WebElementUtil.sendKeys(CustomerRegistrationLocatorsFsus.zipCodeField, zipCode);
		 return this;
	 }
	 
	 public HomePageActionsFsus createAccount(String emailAddress, String password, String firstName, String lastName,String invitationCode,String zipCode) {
		 return enterEmailAddress(emailAddress)
					 	.enterFirstName(firstName)
					 	.enterLastName(lastName)
					 	.enterPassword(password)
					 	.enterInvitationCode(invitationCode)
					 	.enterZipCode(zipCode)
					 	.clickCreateAccountButton();			 	
	 }
	 
	 public HomePageActionsFsus createAccount(FSCreateAccountData createAccountData) {
		 return enterEmailAddress(createAccountData.emailAddress())
					 	.enterFirstName(createAccountData.firstName())
					 	.enterLastName(createAccountData.lastName())
					 	.enterPassword(createAccountData.password())
					 	.enterInvitationCode(createAccountData.invitationCode())
					 	.enterZipCode(createAccountData.zipCode())
					 	.clickCreateAccountButton();			 	
	 }
	 
	 public CustomerRegistrationPageActionsFsus verifyCustomerRegistrationPageFieldsAndMessages() {
			Assert.assertTrue(isWelcomeTitleDisplayed()
					,"Welcome to Frigidaire and Electrolux Family Store! title is not displayed");
	 	Assert.assertTrue(isMarketingBannerDisplayed()
				,"Marketing Promotion Banner is not displayed");
	 	Assert.assertTrue(isAlreadyHaveAnAccountMessageDisplayed()
				,"'Already have an Account?' Message is not displayed");
	 	Assert.assertTrue(isCompleteTheRegistrationMessageDisplayed()
	 			,"'To Join the Program, Please complete the registration form below:' Message is not displayed");
	 	Assert.assertTrue(isFirstNameFieldDisplayed(),"First Name field is not displayed");
	 	Assert.assertTrue(isLastNameFieldDisplayed(),"Last Name field is not displayed");
	 	Assert.assertTrue(isZipCodeFieldDisplayed(),"ZipCode field is not displayed");
	 	Assert.assertTrue(isEmailAddressFieldDisplayed(),"Email Address field is not displayed");
	 	Assert.assertTrue(isPasswordFieldDisplayed(),"Password field is not displayed");
	 	Assert.assertTrue(isPasswordFieldShowPasswordEyeIconDisplayed(),"Show Password Eye Icon is not displayed");
	 	Assert.assertTrue(isInvitationCodeFieldDisplayed(),"Invitation Code field is not displayed");
	 	Assert.assertTrue(isAcknowledgementMessageDisplayed()
	 			,"'By registering I acknowledge these prices are exclusive to the Electrolux Family Store and cannot be shared or price-matched at any retailer. Doing so will result in the removal of my account.' message is not displayed");
	 	Assert.assertTrue(isTermsAndConditionsMessageDisplayed()
	 			,"'By creating an account, I agree to the Electrolux Terms and Conditions, Privacy Policy, and agree to receive promotional information.' message is not displayed");
	 	Assert.assertTrue(isConsentCheckBoxDisplayed(),"Consent Checkbox is not displayed");
	 	Assert.assertTrue(isCreateAccountButtonDisplayed(),"Create Account Button is not displayed");
	 	Assert.assertTrue(isCancelButtonDisplayed(),"Cancel Button is not displayed");
	 	Assert.assertTrue(isLoginHereLinkDisplayed()
				,"Already Have an Account? Login Here link is not displayed");
	 	return this;
	 }
	
	 
}
