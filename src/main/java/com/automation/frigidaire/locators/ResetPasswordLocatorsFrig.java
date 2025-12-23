package com.automation.frigidaire.locators;
import org.openqa.selenium.By;

public class ResetPasswordLocatorsFrig {
   
	public final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	public final By submitButton = By.cssSelector("input[value='Submit']");
	public final By newPasswordInput = By.cssSelector("input[placeholder='New password *']");
	public final By confirmPasswordInput = By.cssSelector("input[placeholder='Confirm password *']");
	public final By changePasswordTitle = By.xpath("//h2[normalize-space()='Change Password']");
	public final By newPasswordShowHideIcon = By.xpath("//input[@placeholder='New password *']/parent::div//button[@title='Show Password']");
	public final By confirmPasswordShowHideIcon = By.xpath("//input[@placeholder='Confirm password *']/parent::div//button[@title='Show Password']");
	public final By resetPasswordSucccessScreenMessage = By.xpath("//div[@id='gigya-reset-password-success-screen']//label/parent::div");
	public final By loginToYourAccountLink = By.cssSelector("a#reset-password-login-link");
	 
}
