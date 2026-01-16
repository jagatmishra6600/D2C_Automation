package com.automation.electrolux.locators;
import org.openqa.selenium.By;

public class ReviewAndPayLocatorsElux {
   
	public final By creditCardRadioButton = By.xpath("//span[contains(.,'Credit Card')]/parent::label/input[@type='radio']");
	public final By paymentMethodSection = By.cssSelector("app-elux-payment-method");
	public final By cardNumberField = By.cssSelector("input[aria-label='Card number']");
	public final By expiryDateField = By.cssSelector("input[aria-label='Expiry date']");
	public final By securityCodeField = By.cssSelector("input[aria-label='Security code']");
	public final By nameOnCardField = By.cssSelector("input[name='holderName']");
	
//	public final By cardNumberField = By.cssSelector("span[data-cse='encryptedCardNumber']");
//	public final By expiryDateField = By.cssSelector("span[data-cse='encryptedExpiryDate']");
//	public final By securityCodeField = By.cssSelector("span[data-cse='encryptedSecurityCode']");
//	public final By nameOnCardField = By.cssSelector("span[data-cse='encryptedCardNumber']");
	public final By placeOrderButton = By.cssSelector("div.cx-place-order-button button");
	public final By creditCardTypeIcon = By.cssSelector("span[data-cse='encryptedCardNumber'] img");
	public final By checkCreditCardInformationMessage =  By.cssSelector("div.alert");
}
