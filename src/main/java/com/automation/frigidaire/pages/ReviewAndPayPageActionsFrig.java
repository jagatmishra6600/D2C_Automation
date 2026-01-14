package com.automation.frigidaire.pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;

import com.automation.frigidaire.locators.ReviewAndPayLocatorsFrig;
import com.automation.utils.WebElementUtil;

public class ReviewAndPayPageActionsFrig {
	
	ReviewAndPayLocatorsFrig reviewAndPayLocators = new ReviewAndPayLocatorsFrig();
	
	public ReviewAndPayPageActionsFrig selectCreditCardPaymentOption() {
		WebElementUtil.scrollIntoView(reviewAndPayLocators.creditCardRadioButton);
		WebElementUtil.clickElement(reviewAndPayLocators.creditCardRadioButton);
		return this;
	}
	
	public boolean isPaymentSectionDisplayed() {
		return WebElementUtil.isDisplayed(reviewAndPayLocators.paymentMethodSection);
	}
	
	public ReviewAndPayPageActionsFrig enterCreditCardDetails(String cardNumber, String expiryDate, String securityCode,String name) {
		return enterCreditCardNumber(cardNumber)
				.enterCardExpiryDate(expiryDate)
				.enterSecurityCodeNumber(securityCode)
				.enterNameOnCard(name);
		
	}
	
	public ReviewAndPayPageActionsFrig enterCreditCardDetails(List<String> cardDetails) {
		if(cardDetails.size()!=4) {
			throw new IllegalArgumentException("Input list does not contain all the required information about card - CreditCardNumber,Card ExpiryDate, Security Code, Name on Card");
		}
		return enterCreditCardNumber(cardDetails.get(0))
				.enterCardExpiryDate(cardDetails.get(1))
				.enterSecurityCodeNumber(cardDetails.get(2))
				.enterNameOnCard(cardDetails.get(3));
		
	}
	
	public ReviewAndPayPageActionsFrig enterCreditCardNumber(String creditCardNumber) {
	    WebElementUtil.performInFrame("//iframe[contains(@title,'card number')]", () -> 
	       WebElementUtil.sendKeys(reviewAndPayLocators.cardNumberField,creditCardNumber)
	    );
	    return this;
	}
	
	public Boolean isCreditCardNumberFieldDisplayed() {
		By cardNumberIframeLocator = By.xpath("//iframe[contains(@title,'card number')]");
		return WebElementUtil.performInFrame(cardNumberIframeLocator, () -> 
	       WebElementUtil.isDisplayed(reviewAndPayLocators.cardNumberField)
	    );
	}
	
	public ReviewAndPayPageActionsFrig enterCardExpiryDate(String expiryDate) {
		WebElementUtil.performInFrame("//iframe[contains(@title,'expiry date')]", () -> 
	       WebElementUtil.sendKeys(reviewAndPayLocators.expiryDateField,expiryDate)
	    );
	    return this;
	}
	
	public Boolean isCreditCardExpiryFieldDisplayed() {
		By cardExpiryIframeLocator = By.xpath("//iframe[contains(@title,'expiry date')]");
		return WebElementUtil.performInFrame(cardExpiryIframeLocator, () -> 
	       WebElementUtil.isDisplayed(reviewAndPayLocators.expiryDateField)
	    );
	}
	
	public ReviewAndPayPageActionsFrig enterSecurityCodeNumber(String securityCode) {
		WebElementUtil.performInFrame("//iframe[contains(@title,'security code')]", () -> 
	       WebElementUtil.sendKeys(reviewAndPayLocators.securityCodeField,securityCode)
	    );
	    return this;
	}
	
	public Boolean isCreditCardSecurityCodeFieldDisplayed() {
		By securityCodeIframeLocator = By.xpath("//iframe[contains(@title,'security code')]");
		return WebElementUtil.performInFrame(securityCodeIframeLocator, () -> 
	       WebElementUtil.isDisplayed(reviewAndPayLocators.securityCodeField)
	    );
	}
	
	public ReviewAndPayPageActionsFrig enterNameOnCard(String name) {
		WebElementUtil.scrollIntoView(reviewAndPayLocators.nameOnCardField);
		WebElementUtil.sendKeys(reviewAndPayLocators.nameOnCardField, name);
		return this;
	}
	
	public boolean isNameOnCardFieldDisplayed() {
		return WebElementUtil.isDisplayed(reviewAndPayLocators.nameOnCardField);
	}
	
	public ReviewAndPayPageActionsFrig clickPlaceOrderButton() {
		WebElementUtil.scrollIntoView(reviewAndPayLocators.placeOrderButton);
		WebElementUtil.clickElement(reviewAndPayLocators.placeOrderButton);
		return this;
	}
	
	public String getCreditCardType() {
		WebElementUtil.scrollIntoView(reviewAndPayLocators.creditCardTypeIcon);
		return WebElementUtil.getDomProperty(reviewAndPayLocators.creditCardTypeIcon,"alt");
	}
	
	public boolean isCheckCreditCardInformationMessageDisplayed() {
		WebElementUtil.scrollIntoView(reviewAndPayLocators.checkCreditCardInformationMessage);
		return WebElementUtil.isDisplayed(reviewAndPayLocators.checkCreditCardInformationMessage);	
	}
	
	public String getCheckCreditCardInformationMessage() {
		WebElementUtil.scrollIntoView(reviewAndPayLocators.checkCreditCardInformationMessage);
		return WebElementUtil.getText(reviewAndPayLocators.checkCreditCardInformationMessage);
	}
	
	public ReviewAndPayPageActionsFrig verifyAllCreditCardDetailFieldsDisplayed() {
		assertTrue(isCreditCardNumberFieldDisplayed(),"Credit Card Number field is not displayed in the Review & Pay page");
		assertTrue(isCreditCardExpiryFieldDisplayed(),"Credit Card Expiry field is not displayed in the Review & Pay page");
		assertTrue(isCreditCardSecurityCodeFieldDisplayed(),"Credit Card Security Code field is not displayed in the Review & Pay page");
		assertTrue(isNameOnCardFieldDisplayed(),"Credit Card Name On Card field is not displayed in the Review & Pay page");
		return this;
	}
}
