package com.automation.electrolux.pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;

import com.automation.electrolux.locators.ReviewAndPayLocatorsElux;
import com.automation.utils.WebElementUtil;

public class ReviewAndPayPageActionsElux {
	
	ReviewAndPayLocatorsElux reviewAndPayLocators = new ReviewAndPayLocatorsElux();
	
	public ReviewAndPayPageActionsElux selectCreditCardPaymentOption() {
		WebElementUtil.scrollIntoView(reviewAndPayLocators.creditCardRadioButton);
		WebElementUtil.clickElement(reviewAndPayLocators.creditCardRadioButton);
		return this;
	}
	
	public boolean isPaymentSectionDisplayed() {
		return WebElementUtil.isDisplayed(reviewAndPayLocators.paymentMethodSection);
	}
	
	public ReviewAndPayPageActionsElux enterCreditCardDetails(String cardNumber, String expiryDate, String securityCode,String name) {
		return enterCreditCardNumber(cardNumber)
				.enterCardExpiryDate(expiryDate)
				.enterSecurityCodeNumber(securityCode)
				.enterNameOnCard(name);
		
	}
	
	public ReviewAndPayPageActionsElux enterCreditCardDetails(List<String> cardDetails) {
		if(cardDetails.size()!=4) {
			throw new IllegalArgumentException("Input list does not contain all the required information about card - CreditCardNumber,Card ExpiryDate, Security Code, Name on Card");
		}
		return enterCreditCardNumber(cardDetails.get(0))
				.enterCardExpiryDate(cardDetails.get(1))
				.enterSecurityCodeNumber(cardDetails.get(2))
				.enterNameOnCard(cardDetails.get(3));
		
	}
	
	public ReviewAndPayPageActionsElux enterCreditCardNumber(String creditCardNumber) {
	    WebElementUtil.performInFrame("//iframe[contains(@title,'card number')]", () -> 
	       WebElementUtil.sendKeys(reviewAndPayLocators.cardNumberField,creditCardNumber)
	    );
	    return this;
	}
	
	public Boolean isCreditCardNumberFieldDisplayed() {
		By cardNumberIframeLocator = By.xpath("//iframe[contains(@title,'card number')]");
		if(!WebElementUtil.isDisplayed(cardNumberIframeLocator)) {
			return false;
		}
		return WebElementUtil.performInFrame(cardNumberIframeLocator, () -> 
	       WebElementUtil.isDisplayed(reviewAndPayLocators.cardNumberField)
	    );
	}
	
	public ReviewAndPayPageActionsElux enterCardExpiryDate(String expiryDate) {
		WebElementUtil.performInFrame("//iframe[contains(@title,'expiry date')]", () -> 
	       WebElementUtil.sendKeys(reviewAndPayLocators.expiryDateField,expiryDate)
	    );
	    return this;
	}
	
	public Boolean isCreditCardExpiryFieldDisplayed() {
		By cardExpiryIframeLocator = By.xpath("//iframe[contains(@title,'expiry date')]");
		if(!WebElementUtil.isDisplayed(cardExpiryIframeLocator)) {
			return false;
		}
		return WebElementUtil.performInFrame(cardExpiryIframeLocator, () -> 
	       WebElementUtil.isDisplayed(reviewAndPayLocators.expiryDateField)
	    );
	}
	
	public ReviewAndPayPageActionsElux enterSecurityCodeNumber(String securityCode) {
		WebElementUtil.performInFrame("//iframe[contains(@title,'security code')]", () -> 
	       WebElementUtil.sendKeys(reviewAndPayLocators.securityCodeField,securityCode)
	    );
	    return this;
	}
	
	public Boolean isCreditCardSecurityCodeFieldDisplayed() {
		By securityCodeIframeLocator = By.xpath("//iframe[contains(@title,'security code')]");
		if(!WebElementUtil.isDisplayed(securityCodeIframeLocator)) {
			return false;
		}
		return WebElementUtil.performInFrame(securityCodeIframeLocator, () -> 
	       WebElementUtil.isDisplayed(reviewAndPayLocators.securityCodeField)
	    );
	}
	
	public ReviewAndPayPageActionsElux enterNameOnCard(String name) {
		WebElementUtil.scrollIntoView(reviewAndPayLocators.nameOnCardField);
		WebElementUtil.sendKeys(reviewAndPayLocators.nameOnCardField, name);
		return this;
	}
	
	public boolean isNameOnCardFieldDisplayed() {
		return WebElementUtil.isDisplayed(reviewAndPayLocators.nameOnCardField);
	}
	
	public ReviewAndPayPageActionsElux clickPlaceOrderButton() {
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
	
	public ReviewAndPayPageActionsElux verifyAllCreditCardDetailFieldsDisplayed() {
		assertTrue(isCreditCardNumberFieldDisplayed(),"Credit Card Number field is not displayed in the Review & Pay page");
		assertTrue(isCreditCardExpiryFieldDisplayed(),"Credit Card Expiry field is not displayed in the Review & Pay page");
		assertTrue(isCreditCardSecurityCodeFieldDisplayed(),"Credit Card Security Code field is not displayed in the Review & Pay page");
		assertTrue(isNameOnCardFieldDisplayed(),"Credit Card Name On Card field is not displayed in the Review & Pay page");
		return this;
	}
}
