package com.automation.frigidaire.tests.EPIC_06_MyAccount;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.FrigidaireHomePageActions;
import com.automation.frigidaire.pages.FrigidaireLoginPageActions;
import com.automation.frigidaire.pages.FrigidaireMyAccount_AccountPreferencesPageActions;
import com.automation.utils.WebElementUtil;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExtentReportManager;

public class EPIC_06_TC_01_AQA_MyAccount_AccountPreferences extends BaseTest {
	 FrigidaireHomePageActions homePage = new FrigidaireHomePageActions();
	 FrigidaireLoginPageActions loginPage = new FrigidaireLoginPageActions();
	 FrigidaireMyAccount_AccountPreferencesPageActions accountPreferencePage = new FrigidaireMyAccount_AccountPreferencesPageActions();
	 String emailAddress = ConfigReader.getProperty("user.email");
	 String password = ConfigReader.getProperty("user.password");
	 
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify user navigation to the Account Preferences page")
	    public void EPIC_06_TC_01_S1_VerifyNavigationToMyAccountPreferencesPage() throws InterruptedException {	
		 	homePage.login(emailAddress, password)
		 			.navigateToAccountPreferencesPage();
	    	Assert.assertTrue(accountPreferencePage.isAccountPreferenceTabDisplayed(),"User can see the Account Preference Tab in My Accounts page");
	    	Assert.assertTrue(WebElementUtil.getCurrentUrl().contains("accountPreference"),"User is not Navigated to Account Preference page");
	    	ExtentReportManager.getTest().pass("Verified navigation to the Account Preferences page successfully.");  	    
	 } 
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify that the user can navigate through all tabs on the My Account page")
	    public void EPIC_06_TC_01_S2_VerifyTabularNavigationOnMyAccountPage() throws InterruptedException {
		 	homePage.login(emailAddress, password)
		 			.navigateToAccountPreferencesPage();
	    	Assert.assertTrue(accountPreferencePage.isAllTabsNavigationSuccessful(),"Navigation to one or more My Account tabs failed");
	    	ExtentReportManager.getTest().pass("User successfully navigated through all tabs on the My Account page and verified each tab loaded correctly.");  	    
	 } 
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify Shipping Details Section have Saved Addresses and Edit and Set To Default button in each of them")
	    public void EPIC_06_TC_01_S3_VerifyShippingDetailsSection() throws InterruptedException {
		 	homePage.login(emailAddress, password)
		 			.navigateToAccountPreferencesPage();
	    	Assert.assertTrue(accountPreferencePage.isShippingDetailsAddressBoxesDisplayed()
	    							,"Address Boxes are not displayed in the Shipping Details Section");
	    	Assert.assertTrue(accountPreferencePage.isAddressDetailsPresentForAllAddresses()
	    							,"Address Detail in one or more Address is not present");	
	    	Assert.assertTrue(accountPreferencePage.hasAllAddressBoxActionButtons()
	    							,"Address box is missing one or more buttons (Default/Set as Default, Edit, Delete).");
	    	ExtentReportManager.getTest().pass("User successfully navigated through all tabs on the My Account page and verified each tab loaded correctly.");  	    
	 }
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify that the Add New Address section displays all required fields, labels, checkboxes, dropdowns, and action buttons.")
	    public void EPIC_06_TC_01_S3_VerifyAddNewAddressSection() throws InterruptedException {
		    homePage.login(emailAddress, password)
					.navigateToAccountPreferencesPage();
	    	accountPreferencePage.clickAddNewAddressButton();
	    	
	    	Assert.assertTrue(accountPreferencePage.isAddNewShippingAddressLabelDisplayed(),"Add New Shipping Address Label is not Displayed");
	    	Assert.assertTrue(accountPreferencePage.isFirstNameFieldDisplayed(),"First Name Field is not Displayed in Add New Address Section");
	    	Assert.assertTrue(accountPreferencePage.isLastNameFieldDisplayed(),"Last Name Field is not Displayed in Add New Address Section");
	    	Assert.assertTrue(accountPreferencePage.isAddressLineFieldsDisplayed(),"Address Line Fields are not Displayed in Add New Address Section");
	    	Assert.assertTrue(accountPreferencePage.isCityFieldDisplayed(),"City Field is not Displayed in Add New Address Section");
	    	Assert.assertTrue(accountPreferencePage.isStateDropdownDisplayed(),"State Dropdown is not Displayed in Add New Address Section");
	    	Assert.assertTrue(accountPreferencePage.isZipCodeFieldDisplayed(),"Zip Code Field is not Displayed in Add New Address Section");
	    	Assert.assertTrue(accountPreferencePage.isPhoneNumberFieldDisplayed(),"Phone Number Field is not Displayed in Add New Address Section");
	    	Assert.assertTrue(accountPreferencePage.isMakeThisDefaultShippingAddressCheckboxDisplayed(),"Make this my Default Shipping Address Checkbox is not Displayed in Add New Address Section");
	    	Assert.assertTrue(accountPreferencePage.isSaveAddressButtonDisplayed(),"Save Address Button is not Displayed in Add New Address Section");
	    	Assert.assertTrue(accountPreferencePage.isCancelShippingAddressButtonDisplayed(),"Cancel Button is not Displayed in Add New Address Section");

	    	accountPreferencePage.clickCancelShippingAddressButton();
	    	Assert.assertFalse(accountPreferencePage.isAddNewShippingAddressLabelDisplayed(),"After Click On Cancel Button Add New Address Section did not close");

	    	ExtentReportManager.getTest().pass("Verified that all fields, labels, dropdowns, checkboxes, and action buttons in the Add New Address section are displayed correctly and the section closes on clicking Cancel.");  	    
	 }
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify that the Change My Password section displays all required fields, labels, password rules, and action buttons.")
	    public void EPIC_06_TC_01_S4_VerifyChangeMyPasswordSection() throws InterruptedException {
		 	homePage.login(emailAddress, password)
		 			.navigateToAccountPreferencesPage();

	    	Assert.assertTrue(accountPreferencePage.isCurrentPasswordSectionDisplayed(),"Current Password field or its label is not displayed on the Change Password section.");
	    	Assert.assertTrue(accountPreferencePage.isNewPasswordSectionDisplayed(),"New Password or Confirm Password fields/labels are not displayed on the Change Password section.");
	    	Assert.assertEquals(accountPreferencePage.getPasswordRequirementText(),"Password must contain at least 8 characters and 3 of the following: An uppercase letter, a lowercase letter, a number, a special symbol."
	    								,"Password Requirement text is not correct in the Change Password Page");
	    	Assert.assertTrue(accountPreferencePage.isSetPasswordButtonDisplayed(),"Set Password Button is not displayed in the Change Password section.");
	    	
	    	ExtentReportManager.getTest().pass("Verified that all fields, labels, password requirement text, and the Set Password button are displayed correctly in the Change My Password section.");  	    
	 }
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify the payment Details Section is present in the Account Preferences page")
	    public void EPIC_06_TC_01_S5_VerifyPaymentDetailsSection() throws InterruptedException {
		 	homePage.login(emailAddress, password)
		 			.navigateToAccountPreferencesPage();
	    	Assert.assertTrue(accountPreferencePage.isAddNewPaymentDuringCheckoutLabelDisplayed(),"'You can add new payment methods during checkout.' message is not present in Payment Details Section");
//	    	Assert.assertTrue(accountPreferencePage.areAllPaymentCardsValid(),"Card Details validation failed: One or more payment cards contain invalid name, masked number, expiry format, or missing logo.");
	    	ExtentReportManager.getTest().pass("Verified that all fields, labels, password requirement text, and the Set Password button are displayed correctly in the Change My Password section.");  	    
	 }
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify that the Help Section displays the correct support message and operating hours.")
	    public void EPIC_06_TC_01_S6_VerifyHelpSection() throws InterruptedException {
		 	homePage.login(emailAddress, password)
		 				.navigateToAccountPreferencesPage();
	    	Assert.assertTrue(accountPreferencePage.getNeedHelpBannerText().contains("Need help with your account? Chat with Us!"),
	    			"'Need help with your account? Chat with Us!' message is not displayed in the Help Section.");	
	    	Assert.assertTrue(accountPreferencePage.getNeedHelpBannerText().contains("Monday-Friday 8:30am-8:00pm ET"),
	    			"Help Section operating hours are not displayed");	    	
	    	ExtentReportManager.getTest().pass("Verified that the Help Section displays the support message and operating hours correctly.");  	    
	 }
	 
	 

}
