package com.automation.familystoreus.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.familystoreus.locators.HomeLocatorsFsus;
import com.automation.familystoreus.locators.LoginLocatorsFsus;
import com.automation.utils.ConfigReader;
import com.automation.utils.UserTestData;
import com.automation.utils.WebElementUtil;

public class LoginPageActionsFsus {

	 public LoginPageActionsFsus navigateToLoginPage() {
		WebElementUtil.navigateTo(ConfigReader.getAppUrl()+"/login");
		acceptCookies();
		return this;
	}
	 
	 public void acceptCookies() {
		 try {
	            WebElement acceptBtn = untilClickable(HomeLocatorsFsus.acceptButtonLocator, 10);
	            if (acceptBtn != null) {
	                acceptBtn.click();
	            }
	        } catch (Exception ignored) {
	            // Cookie banner not present or not interactable; continue
	        }
	 }
	 
	 public HomePageActionsFsus login(String emailAddress, String password) {
		 enterEmailAddress(emailAddress)
							 .enterPassword(password)
							 .clickTermsAndConditionsCheckbox()
							 .clickLoginButton();
		 var count = 0;
		 while(!waitUntilLoginButtonIsInvisible() && count<2) {
			 clickLoginButton();
			 count++;
		 }
		 return new HomePageActionsFsus();
	 }
	 
	 
	 public HomePageActionsFsus loginWithDefaultCredentials() {
		 navigateToLoginPage();
		 enterEmailAddress(UserTestData.getUserName())
							 .enterPassword(UserTestData.getPassword())
							 .clickTermsAndConditionsCheckbox()
							 .clickLoginButton();						  
		 var count = 0;
		 while(!waitUntilLoginButtonIsInvisible() && count<3) {
			 clickLoginButton();
			 count++;
		 }
		 return new HomePageActionsFsus();
	 }
	 
	 public LoginPageActionsFsus enterEmailAddress(String emailAddress) {
		 WebElementUtil.sendKeys(LoginLocatorsFsus.emailAddressInput,emailAddress);
		 return this;
	 }
	 
	 public LoginPageActionsFsus enterPassword(String password) {
		 WebElementUtil.sendKeys(LoginLocatorsFsus.passwordInput,password);
		 return this;
	 }
	 
	 public HomePageActionsFsus clickLoginButton() {
		 WebElementUtil.scrollIntoView(LoginLocatorsFsus.loginButton);
		 WebElementUtil.clickElement(LoginLocatorsFsus.loginButton);
		 return new HomePageActionsFsus();
	 }
	 
	 public LoginPageActionsFsus clickTermsAndConditionsCheckbox() {
		 WebElementUtil.scrollIntoView(LoginLocatorsFsus.termsAndConditionsCheckbox);
		 WebElementUtil.clickElement(LoginLocatorsFsus.termsAndConditionsCheckbox);
		 return this;
	 }
	 
	 private boolean waitUntilLoginButtonIsInvisible() {
		 try {
			 WebElementUtil.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(LoginLocatorsFsus.loginButton),5);
			 return true;
		 }
		 catch(Exception e){
			 return false;
		 }
	 }
	 
	 public CustomerRegistrationPageActionsFsus clickregisterWithInvitationCodeLink() {
		 WebElementUtil.scrollIntoView(LoginLocatorsFsus.registerWithInvitationCodeLink);
		 WebElementUtil.clickElement(LoginLocatorsFsus.registerWithInvitationCodeLink);
		 return new CustomerRegistrationPageActionsFsus();
	 }
	 
	 public ForgotPasswordPageActionsFsus clickForgotPasswordLink() {
		 WebElementUtil.scrollIntoView(LoginLocatorsFsus.forgotYourPasswordLink);
		 WebElementUtil.clickElement(LoginLocatorsFsus.forgotYourPasswordLink);
		 if(WebElementUtil.isDisplayed(LoginLocatorsFsus.forgotYourPasswordLink)) {
			 WebElementUtil.clickElement(LoginLocatorsFsus.forgotYourPasswordLink);
		 }
		 return new ForgotPasswordPageActionsFsus();
	 }
	 
	 public ForgotPasswordPageActionsFsus resetPassword(String emailAddress) {
		 return navigateToLoginPage().clickForgotPasswordLink().resetPassword(emailAddress);
	 }
	 
}
