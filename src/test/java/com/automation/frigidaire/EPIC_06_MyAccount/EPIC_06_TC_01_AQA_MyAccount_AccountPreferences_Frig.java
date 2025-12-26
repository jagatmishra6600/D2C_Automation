package com.automation.frigidaire.EPIC_06_MyAccount;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import com.automation.BaseTest;
import com.automation.frigidaire.pages.AccountPreferencesPageActionsFrig;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.utils.ExtentReportManager;

public class EPIC_06_TC_01_AQA_MyAccount_AccountPreferences_Frig extends BaseTest {
	 HomePageActionsFrig homePage = new HomePageActionsFrig();
	 AccountPreferencesPageActionsFrig accountPreferencePage = new AccountPreferencesPageActionsFrig();
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify user navigation to the Account Preferences page")
	    public void TC_01_S1_VerifyNavigationToMyAccountPreferencesPage() {	
		 	loginAndNavigateToAccountPreferencesPage();
	    	assertTrue(accountPreferencePage.isAccountPreferenceTabDisplayed(),"User can see the Account Preference Tab in My Accounts page");
	    	assertTrue(accountPreferencePage.isUserNavigatedToAccountPreferencesPage(),"User is not Navigated to Account Preference page");
	    	ExtentReportManager.getTest().pass("Verified navigation to the Account Preferences page successfully.");  	    
	 } 
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify that the user can navigate through all tabs on the Account Preferences Page")
	    public void TC_01_S2_VerifyTabularNavigationOnAccountPreferencesPage() {
		 	loginAndNavigateToAccountPreferencesPage();
	    	assertTrue(accountPreferencePage.isAccountPreferencesTabNavigationSuccessful(),"User is not navigated to Account Preferences Tab");
	    	assertTrue(accountPreferencePage.isMyOrdersTabNavigationSuccessful(),"User is not navigated to My Orders Tab");
	    	assertTrue(accountPreferencePage.isMySubscriptionsTabNavigationSuccessful(),"User is not navigated to My Subscriptions Tab");
	    	assertTrue(accountPreferencePage.isMyAppliancesTabNavigationSuccessful(),"User is not navigated to My Appliances Tab");
	    	ExtentReportManager.getTest().pass("User successfully navigated through all tabs on the My Account page and verified each tab loaded correctly.");  	    
	 } 
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify Shipping Details Section have Saved Addresses and Edit and Set To Default button in each of them in the Account Preferences Page")
	    public void TC_01_S3_VerifyShippingDetailsSectionInAccountPreferencesPage() {
		 	loginAndNavigateToAccountPreferencesPage();
	    	assertTrue(accountPreferencePage.isShippingDetailsAddressBoxesDisplayed()
	    							,"Address Boxes are not displayed in the Shipping Details Section");
	    	assertTrue(accountPreferencePage.isAddressDetailsPresentForAllAddresses()
	    							,"Address Detail in one or more Address is not present");	
	    	assertTrue(accountPreferencePage.hasAllAddressBoxActionButtons()
	    							,"Address box is missing one or more buttons (Default/Set as Default, Edit, Delete).");
	    	ExtentReportManager.getTest().pass("User successfully navigated through all tabs on the My Account page and verified each tab loaded correctly.");  	    
	 }
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify that the Add New Address section displays all required fields, labels, checkboxes, dropdowns, and action buttons in the Account Preferences Page.")
	    public void TC_01_S3_VerifyAddNewAddressSectionInAccountPreferencesPage() {
		 	loginAndNavigateToAccountPreferencesPage();
	    	accountPreferencePage.clickAddNewAddressButton();
	    	
	    	assertTrue(accountPreferencePage.isAddNewShippingAddressLabelDisplayed(),"Add New Shipping Address Label is not Displayed");
	    	assertTrue(accountPreferencePage.isFirstNameFieldDisplayed(),"First Name Field is not Displayed in Add New Address Section");
	    	assertTrue(accountPreferencePage.isLastNameFieldDisplayed(),"Last Name Field is not Displayed in Add New Address Section");
	    	assertTrue(accountPreferencePage.isAddressLineFieldsDisplayed(),"Address Line Fields are not Displayed in Add New Address Section");
	    	assertTrue(accountPreferencePage.isCityFieldDisplayed(),"City Field is not Displayed in Add New Address Section");
	    	assertTrue(accountPreferencePage.isStateDropdownDisplayed(),"State Dropdown is not Displayed in Add New Address Section");
	    	assertTrue(accountPreferencePage.isZipCodeFieldDisplayed(),"Zip Code Field is not Displayed in Add New Address Section");
	    	assertTrue(accountPreferencePage.isPhoneNumberFieldDisplayed(),"Phone Number Field is not Displayed in Add New Address Section");
	    	assertTrue(accountPreferencePage.isMakeThisDefaultShippingAddressCheckboxDisplayed(),"Make this my Default Shipping Address Checkbox is not Displayed in Add New Address Section");
	    	assertTrue(accountPreferencePage.isSaveAddressButtonDisplayed(),"Save Address Button is not Displayed in Add New Address Section");
	    	assertTrue(accountPreferencePage.isCancelShippingAddressButtonDisplayed(),"Cancel Button is not Displayed in Add New Address Section");

	    	accountPreferencePage.clickCancelShippingAddressButton();
	    	assertFalse(accountPreferencePage.isAddNewShippingAddressLabelDisplayed(),"After Click On Cancel Button Add New Address Section did not close");

	    	ExtentReportManager.getTest().pass("Verified that all fields, labels, dropdowns, checkboxes, and action buttons in the Add New Address section are displayed correctly and the section closes on clicking Cancel.");  	    
	 }
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify that the Change My Password section displays all required fields, labels, password rules, and action buttons in the Account Preferences Page.")
	    public void TC_01_S4_VerifyChangeMyPasswordSectionInAccountPreferencesPage() {
		 	loginAndNavigateToAccountPreferencesPage();

	    	assertTrue(accountPreferencePage.isCurrentPasswordSectionDisplayed(),"Current Password field or its label is not displayed on the Change Password section.");
	    	assertTrue(accountPreferencePage.isNewPasswordSectionDisplayed(),"New Password or Confirm Password fields/labels are not displayed on the Change Password section.");
	    	assertEquals(accountPreferencePage.getPasswordRequirementText(),"Password must contain at least 8 characters and 3 of the following: An uppercase letter, a lowercase letter, a number, a special symbol."
	    								,"Password Requirement text is not correct in the Change Password Page");
	    	assertTrue(accountPreferencePage.isSetPasswordButtonDisplayed(),"Set Password Button is not displayed in the Change Password section.");
	    	
	    	ExtentReportManager.getTest().pass("Verified that all fields, labels, password requirement text, and the Set Password button are displayed correctly in the Change My Password section.");  	    
	 }
	 
	 @Test(groups = {"smoke", "regression"}, description = "Verify that the Help Section displays the correct support message and operating hours in the Account Preferences Page")
	    public void TC_01_S5_VerifyHelpSectionInAccountPreferencesPage() {
		 	loginAndNavigateToAccountPreferencesPage();
	    	assertTrue(accountPreferencePage.getNeedHelpBannerText().contains("Need help with your account? Chat with Us!"),
	    			"'Need help with your account? Chat with Us!' message is not displayed in the Help Section.");	
	    	assertTrue(accountPreferencePage.getNeedHelpBannerText().contains("Monday-Friday 8:30am-8:00pm ET"),
	    			"Help Section operating hours are not displayed");	    	
	    	ExtentReportManager.getTest().pass("Verified that the Help Section displays the support message and operating hours correctly.");  	    
	 }
	 
	 private void loginAndNavigateToAccountPreferencesPage() {
		 homePage.loginWithDefaultCredentials()
			.navigateToAccountPreferencesPage();
	 }
	
	 
}
