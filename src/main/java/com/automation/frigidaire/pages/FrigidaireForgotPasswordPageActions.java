package com.automation.frigidaire.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.utils.ConfigReader;
import com.automation.utils.WebElementUtil;

public class FrigidaireForgotPasswordPageActions {

	private final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	 private final By resetPasswordButton = By.xpath("//input[@value='Reset Password' or @value='Send reset link']");
	 private final By emailAddressInput = By.xpath("//input[@placeholder='Email address *' or @placeholder='jane.doe@company.com *']");	
	 private final By checkYourEmailMessage = By.xpath("//h2[normalize-space()='Check your email' or normalize-space() = 'Check your inbox']//ancestor::div[contains(@id,'forgot-password-success')]");
	 
	 public FrigidaireForgotPasswordPageActions navigateToForgotPasswordPage() {
		WebElementUtil.navigateTo(ConfigReader.getAppUrl()+"forgotPassword");
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
	 
	 public boolean isResetPasswordButtonDisplayed() {
		 return WebElementUtil.isDisplayed(resetPasswordButton);			 
	 }
	 
	 public FrigidaireForgotPasswordPageActions enterEmailAddress(String emailAddress) {
		WebElementUtil.sendKeys(emailAddressInput, emailAddress);
		return this;
	 }
	 
	 public String getCheckYourEmailMessage() {
		 return WebElementUtil.getText(checkYourEmailMessage).replaceAll("\\s+", " ");
	 }
	 
	 public boolean isCheckYourEmailMessageDisplayed() {
		 return WebElementUtil.isDisplayed(checkYourEmailMessage);	
	 }
	 
	 public boolean isCheckYourInboxMessageDisplayed() {
		 return WebElementUtil.isDisplayed(checkYourEmailMessage);	
	 }
	 
	 public FrigidaireForgotPasswordPageActions clickResetPasswordButton() {
		 WebElementUtil.clickElement(resetPasswordButton);
		 return this;
	 }
	 
	 public FrigidaireForgotPasswordPageActions resetPassword(String emailAddress) {
		 return enterEmailAddress(emailAddress).clickResetPasswordButton();
	 }
	 
	 
	
	
	 
}
