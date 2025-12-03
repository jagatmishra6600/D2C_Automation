package com.automation.familystoreus.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import org.openqa.selenium.WebElement;

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
		 navigateToLoginPage();
		 var isLoggedIn = enterEmailAddress(emailAddress)
							 .enterPassword(password)
							 .clickTermsAndConditionsCheckbox()
							 .clickLoginButton()
							 .isUserGreetingDropdownDisplayed();
 
		 if(!isLoggedIn) {
			 return clickLoginButton();
		 }
		 return new FsusHomePageActions();
	 }
	 
	 
	 public FsusHomePageActions loginWithDefaultCredentials() {
		 navigateToLoginPage();
		 var isLoggedIn = enterEmailAddress(UserTestData.FS_USERNAME)
							 .enterPassword(UserTestData.PASSWORD)
							 .clickTermsAndConditionsCheckbox()
							 .clickLoginButton()
							 .isUserGreetingDropdownDisplayed();
 
		 if(!isLoggedIn) {
			 return clickLoginButton();
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
	 
	 
}
