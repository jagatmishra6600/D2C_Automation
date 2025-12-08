package com.automation.familystoreus.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.familystoreus.locators.FSUS_Homepage;
import com.automation.familystoreus.locators.FSUS_LoginPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.UserTestData;
import com.automation.utils.WebElementUtil;

public class FsusLoginPageActions {

	 public FsusLoginPageActions navigateToLoginPage() {
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
	 
	 public FsusHomePageActions login(String emailAddress, String password) {
		 enterEmailAddress(emailAddress)
							 .enterPassword(password)
							 .clickTermsAndConditionsCheckbox()
							 .clickLoginButton();
		 var count = 0;
		 while(!waitUntilLoginButtonIsInvisible() && count<2) {
			 clickLoginButton();
			 count++;
		 }
		 return new FsusHomePageActions();
	 }
	 
	 
	 public FsusHomePageActions loginWithDefaultCredentials() throws InterruptedException {
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
		 return new FsusHomePageActions();
	 }
	 
	 public FsusLoginPageActions enterEmailAddress(String emailAddress) {
		 WebElementUtil.sendKeys(FSUS_LoginPage.emailAddressInput,emailAddress);
		 return this;
	 }
	 
	 public FsusLoginPageActions enterPassword(String password) {
		 WebElementUtil.sendKeys(FSUS_LoginPage.passwordInput,password);
		 return this;
	 }
	 
	 public FsusHomePageActions clickLoginButton() {
		 WebElementUtil.scrollIntoView(FSUS_LoginPage.loginButton);
		 WebElementUtil.clickElement(FSUS_LoginPage.loginButton);
		 return new FsusHomePageActions();
	 }
	 
	 public FsusLoginPageActions clickTermsAndConditionsCheckbox() {
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
	 
	 public FsusCustomerRegistrationPageActions clickregisterWithInvitationCodeLink() {
		 WebElementUtil.scrollIntoView(FSUS_LoginPage.registerWithInvitationCodeLink);
		 WebElementUtil.clickElement(FSUS_LoginPage.registerWithInvitationCodeLink);
		 return new FsusCustomerRegistrationPageActions();
	 }
	 
}
