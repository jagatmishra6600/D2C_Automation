package com.automation.frigidaire.EPIC_12_Checkout3;

import static org.testng.Assert.*;


import org.testng.annotations.Test;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.ReviewAndPayPageActionsFrig;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.UserTestData;

@Test
public class EPIC_12_TC_01_AQA_Checkout3_CreditCard_ReviewDetails_Frig extends BaseTest {
	HomePageActionsFrig homePage = new HomePageActionsFrig();
	ReviewAndPayPageActionsFrig reviewAndPayPage = new ReviewAndPayPageActionsFrig();

	@Test(groups = { "smoke","regression" }, description = "Verify credit card payment details section on the Review and Pay page and validate the error message when placing order with invalid credit card details.")
	public void EPIC_12_Checkout3_TC_01_VerifyCreditCardDetailsSectionAndErrorMessageForInvalidCard() {
		var cardType = "American Express";
		var expectedCheckCreditCardInfoMessage = "We were unable to process your payment for this order. Please check your credit card information or contact your card issuer to verify.";
		navigateToReviewAndPayPage();
		assertTrue(reviewAndPayPage.isPaymentSectionDisplayed(),"User is not navigated to Review And Pay Page : Payment Section is not displayed");
		reviewAndPayPage.selectCreditCardPaymentOption()
						.verifyAllCreditCardDetailFieldsDisplayed()
						.enterCreditCardDetails(UserTestData.getCreditCardDetailsList());
		assertEquals(reviewAndPayPage.getCreditCardType(),cardType,"Card Type is not identified correctly in the Card Number Field");
		reviewAndPayPage.clickPlaceOrderButton();
		assertTrue(reviewAndPayPage.isCheckCreditCardInformationMessageDisplayed(),"Check your Credit Card Information Message is not appeared after placing order with invalid card details");
		assertEquals(reviewAndPayPage.getCheckCreditCardInformationMessage(),expectedCheckCreditCardInfoMessage,"Check your card information message is not correct");
		
		ExtentReportManager.getTest().pass("Successfully validated credit card details section on the Review and Pay page, "
			  + "including card type identification and appropriate error message for placing order with invalid credit card details.");
	}

	private void navigateToReviewAndPayPage() {
		homePage.navigateToHomePage()
		.clickFrenchDoor().closePopupModel().clickProvidedProduct()
		.clickDeliveryOption().clickAddToCartButton()
		.clickSaveAndViewCartButton().clickProceedToCheckOutButton()
		.enterShippingAddressDetails(UserTestData.getRandomUSAddressData())
		.clickContinueToDeliveryButton()
		.selectFirstAvailableDeliveryDate()
		.clickContinueToBillingButton();
	}
}
