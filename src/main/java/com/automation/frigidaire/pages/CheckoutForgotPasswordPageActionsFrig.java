package com.automation.frigidaire.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.frigidaire.locators.ForgotPasswordLocatorsFrig;
import com.automation.utils.ConfigReader;
import com.automation.utils.WebElementUtil;

public class CheckoutForgotPasswordPageActionsFrig {

	private final ForgotPasswordLocatorsFrig fpLocator = new ForgotPasswordLocatorsFrig();
	private final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	 
	 public CheckoutForgotPasswordPageActionsFrig navigateToForgotPasswordPage() {
		WebElementUtil.navigateTo(ConfigReader.getAppUrl()+"forgotPassword");
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
	 
	 public boolean isResetPasswordButtonDisplayed() {
		 return WebElementUtil.isDisplayed(fpLocator.resetPasswordButton);			 
	 }
	 
	 public CheckoutForgotPasswordPageActionsFrig enterEmailAddress(String emailAddress) {
		WebElementUtil.sendKeys(fpLocator.emailAddressInput, emailAddress);
		return this;
	 }
	 
	 public String getCheckYourEmailMessage() {
		 return WebElementUtil.getText(fpLocator.checkYourEmailMessage).replaceAll("\\s+", " ");
	 }
	 
	 public boolean isCheckYourEmailMessageDisplayed() {
		 return WebElementUtil.isDisplayed(fpLocator.checkYourEmailMessage);	
	 }
	 
	 public boolean isCheckYourInboxMessageDisplayed() {
		 return WebElementUtil.isDisplayed(fpLocator.checkYourEmailMessage);	
	 }
	 
	 public CheckoutForgotPasswordPageActionsFrig clickResetPasswordButton() {
		 WebElementUtil.clickElement(fpLocator.resetPasswordButton);
		 return this;
	 }
	 
	 public CheckoutForgotPasswordPageActionsFrig resetPassword(String emailAddress) {
		 return enterEmailAddress(emailAddress).clickResetPasswordButton();
	 }	 	 
}
