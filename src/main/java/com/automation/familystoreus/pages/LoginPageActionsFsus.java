package com.automation.familystoreus.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.familystoreus.locators.FSUS_Homepage;
import com.automation.familystoreus.locators.FSUS_LoginPage;
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
	            WebElement acceptBtn = untilClickable(FSUS_Homepage.acceptButtonLocator, 10);
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
		 WebElementUtil.sendKeys(FSUS_LoginPage.emailAddressInput,emailAddress);
		 return this;
	 }
	 
	 public LoginPageActionsFsus enterPassword(String password) {
		 WebElementUtil.sendKeys(FSUS_LoginPage.passwordInput,password);
		 return this;
	 }
	 
	 public HomePageActionsFsus clickLoginButton() {
		 WebElementUtil.scrollIntoView(FSUS_LoginPage.loginButton);
		 WebElementUtil.clickElement(FSUS_LoginPage.loginButton);
		 return new HomePageActionsFsus();
	 }
	 
	 public LoginPageActionsFsus clickTermsAndConditionsCheckbox() {
		 WebElementUtil.scrollIntoView(FSUS_LoginPage.termsAndConditionsCheckbox);
		 WebElementUtil.clickElement(FSUS_LoginPage.termsAndConditionsCheckbox);
		 return this;
	 }
	 
	 private boolean waitUntilLoginButtonIsInvisible() {
		 try {
			 WebElementUtil.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(FSUS_LoginPage.loginButton),5);
			 return true;
		 }
		 catch(Exception e){
			 return false;
		 }
	 }
	 
	 public CustomerRegistrationPageActionsFsus clickregisterWithInvitationCodeLink() {
		 WebElementUtil.scrollIntoView(FSUS_LoginPage.registerWithInvitationCodeLink);
		 WebElementUtil.clickElement(FSUS_LoginPage.registerWithInvitationCodeLink);
		 return new CustomerRegistrationPageActionsFsus();
	 }
	 
	 public ForgotPasswordPageActionsFsus clickForgotPasswordLink() {
		 WebElementUtil.scrollIntoView(FSUS_LoginPage.forgotYourPasswordLink);
		 WebElementUtil.clickElement(FSUS_LoginPage.forgotYourPasswordLink);
		 if(WebElementUtil.isDisplayed(FSUS_LoginPage.forgotYourPasswordLink)) {
			 WebElementUtil.clickElement(FSUS_LoginPage.forgotYourPasswordLink);
		 }
		 return new ForgotPasswordPageActionsFsus();
	 }
	 
	 public ForgotPasswordPageActionsFsus resetPassword(String emailAddress) {
		 return navigateToLoginPage().clickForgotPasswordLink().resetPassword(emailAddress);
	 }
	 
}
