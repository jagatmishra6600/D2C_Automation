package com.automation.frigidaire.locators;
import org.openqa.selenium.By;

public class ForgotPasswordLocatorsFrig {
   
	public final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	public final By resetPasswordButton = By.xpath("//input[@value='Reset Password' or @value='Send reset link']");
	public final By emailAddressInput = By.xpath("//input[@placeholder='Email address *' or @placeholder='jane.doe@company.com *']");	
	public final By checkYourEmailMessage = By.xpath("//h2[normalize-space()='Check your email' or normalize-space() = 'Check your inbox']//ancestor::div[contains(@id,'forgot-password-success')]");
	 
}
