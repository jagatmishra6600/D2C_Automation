package com.automation.frigidaire.pages;

import static com.automation.frigidaire.utils.WaitUtils.untilClickable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.frigidaire.utils.ConfigReader;
import com.automation.frigidaire.utils.WebElementUtil;

public class FrigidaireForgotPasswordPageActions {

	 private final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	 private final By resetPasswordButton = By.cssSelector("input[value='Reset Password']");
	 private final By emailAddressInput = By.cssSelector("input[placeholder='Email address *']");
	
	 private final By checkYourEmailMessage = By.xpath("//h2[normalize-space()='Check your email']/parent::div");
	 
	 public FrigidaireForgotPasswordPageActions navigateToForgotPasswordPage() {
		WebElementUtil.navigateTo(ConfigReader.getProperty("app.url")+"forgotPassword");
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
	 
	 public FrigidaireForgotPasswordPageActions clickResetPasswordButton() {
		 WebElementUtil.clickElement(resetPasswordButton);
		 return this;
	 }
	 
	 public FrigidaireForgotPasswordPageActions resetPassword(String emailAddress) {
		 return enterEmailAddress(emailAddress).clickResetPasswordButton();
	 }
	 
	 
	
	
	 
}
