package com.automation.frigidaire.pages;

import static com.automation.utils.WaitUtils.untilClickable;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.frigidaire.locators.AccountPreferencesLocatorsFrig;
import com.automation.frigidaire.locators.HomepageLocatorsFrig;
import static com.automation.utils.WebElementUtil.*;

public class AccountPreferencesPageActionsFrig {

	 private AccountPreferencesLocatorsFrig apLocator = new AccountPreferencesLocatorsFrig();
	 private HomepageLocatorsFrig homePageLocator = new HomepageLocatorsFrig();
	 private static final String CLASS_NAME_PROPERTY = "className";
	 private static final String ACTIVE = "active";
	 
	 public AccountPreferencesPageActionsFrig navigateToLoginPage() {
		navigateTo(com.automation.utils.ConfigReader.getAppUrl()+"login");
        try {
            WebElement acceptBtn = untilClickable(homePageLocator.acceptButtonLocator, 15);
            if (acceptBtn != null) {
                acceptBtn.click();
            }
        } catch (Exception ignored) {
            // Cookie banner not present or not interactable; continue
        }
        return this;
	}
	
	public boolean isAccountPreferenceTabDisplayed() {
		return isDisplayed(apLocator.accountPreferencesTabButton);
	}
	
	public boolean isAccountPreferenceTabSelected() {
	    String classProperty = getDomProperty(apLocator.accountPreferencesTabButton, CLASS_NAME_PROPERTY);
	    return classProperty != null && classProperty.contains(ACTIVE);
	}
	
	public boolean isMyOrdersTabSelected() {
	    String classProperty = getDomProperty(apLocator.myOrdersTabButton, CLASS_NAME_PROPERTY);
	    return classProperty != null && classProperty.contains(ACTIVE);
	}
	
	public boolean isMySubscriptionTabSelected() {
	    String classProperty = getDomProperty(apLocator.mySubscriptionsTabButton, CLASS_NAME_PROPERTY);
	    return classProperty != null && classProperty.contains(ACTIVE);
	}
	
	public boolean isMyAppliancesTabSelected() {
	    String classProperty = getDomProperty(apLocator.myAppliancesTabButton, CLASS_NAME_PROPERTY);
	    return classProperty != null && classProperty.contains(ACTIVE);
	}
	
	public AccountPreferencesPageActionsFrig selectAccountPreferenceTab() {
		clickElement(apLocator.accountPreferencesTabButton);
	    if (!isAccountPreferenceTabSelected()) {
	        throw new IllegalStateException("Account Preference Tab Not Selected");
	    }
	    return this;
	}
	
	public boolean isAccountPreferencesTabNavigationSuccessful() {
		clickElement(apLocator.accountPreferencesTabButton);
		return isAccountPreferenceTabSelected();
	}
	
	public AccountPreferencesPageActionsFrig selectMyOrdersTab() {
	    clickElement(apLocator.myOrdersTabButton);
	    if (!isMyOrdersTabSelected()) {
	        throw new IllegalStateException("My Orders Tab Not Selected");
	    }
	    return this;
	}
	
	public boolean isMyOrdersTabNavigationSuccessful() {
		clickElement(apLocator.myOrdersTabButton);
		return isMyOrdersTabSelected();
	}
	
	public AccountPreferencesPageActionsFrig selectMyAppliancesTab() {
	    clickElement(apLocator.myAppliancesTabButton);
	    if (!isMyAppliancesTabSelected()) {
	        throw new IllegalStateException("My Appliances Tab Not Selected");
	    }
	    return this;
	}
	
	public boolean isMyAppliancesTabNavigationSuccessful() {
		clickElement(apLocator.myAppliancesTabButton);
		return isMyAppliancesTabSelected();
	}
	
	public AccountPreferencesPageActionsFrig selectMySubscriptionTab() {
	    clickElement(apLocator.mySubscriptionsTabButton);
	    if (!isMySubscriptionTabSelected()) {
	        throw new IllegalStateException("My Subscription Tab Not Selected");
	    }
	    return this;
	}
	
	public boolean isMySubscriptionsTabNavigationSuccessful() {
		clickElement(apLocator.mySubscriptionsTabButton);
		return isMySubscriptionTabSelected();
	}
	
	public boolean isShippingDetailsAddressBoxesDisplayed() {
		var addressBoxes = getShippingDetailsAddressBoxList();
		return addressBoxes != null && addressBoxes.size() > 1;
	}
	
	public boolean isAddressDetailsPresentForAllAddresses() {
	    var addressBoxes = getShippingDetailsAddressBoxList();
	    for (WebElement address : addressBoxes) {
	        var addressDetails = address.findElements(By.cssSelector("div.pl-3"));
	        if (addressDetails.isEmpty() || !addressDetails.get(0).isDisplayed()) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public List<WebElement> getShippingDetailsAddressBoxList() {
		scrollIntoView(apLocator.shippingDetailsTitle);
		waitForCondition(ExpectedConditions.visibilityOfAllElementsLocatedBy(apLocator.shippingDetailsAddressBoxes));
		return findElements(apLocator.shippingDetailsAddressBoxes);
	}
	
	public boolean hasAllAddressBoxActionButtons() {
		var addressBoxes = getShippingDetailsAddressBoxList();
		
		if (addressBoxes == null || addressBoxes.isEmpty()) {
	        throw new IllegalStateException("Address Boxes are not displayed");
	    }
		
		var addressBox = addressBoxes.size() >= 2 ? addressBoxes.get(1) : addressBoxes.get(0);
		var isEditButtonDisplayed = isAddressEditPencilButtonDisplayed(addressBox);
		var isDeleteButtonDisplayed = isAddressDeleteButtonDisplayed(addressBox);
				
		if(addressBoxes.size()>=2) {
			var setAsDefaultText = getAddressSetAsDefaultButtonText(addressBox);
			return setAsDefaultText.equalsIgnoreCase("Set as Default")
	                && isEditButtonDisplayed && isDeleteButtonDisplayed;
		}
		else {
			var defaultButtonText = getAddressDefaultButtonText(addressBox);
			return defaultButtonText.equals("Default") 
					&& isEditButtonDisplayed && isDeleteButtonDisplayed;
		}
	}
	
	public String getAddressSetAsDefaultButtonText(WebElement addressElement) {
		var setAsDefaultAddressElement = addressElement.findElements(By.cssSelector("div.default-address-label span"));
		return setAsDefaultAddressElement.get(0).getText().trim();
	}
	
	public boolean isAddressEditPencilButtonDisplayed(WebElement addressElement) {
	    var addressEditButton = addressElement.findElements(
	        By.cssSelector("div.default-address-label a.details.mr-2")
	    );
	    return !addressEditButton.isEmpty() && addressEditButton.get(0).isDisplayed();
	}
	
	public boolean isAddressDeleteButtonDisplayed(WebElement addressElement) {
	    var addressDeleteButton = addressElement.findElements(
	        By.cssSelector("div.default-address-label img[alt='Trash Can']")
	    );

	    return !addressDeleteButton.isEmpty() && addressDeleteButton.get(0).isDisplayed();
	}
	
	public String getAddressDefaultButtonText(WebElement addressElement) {
		var defaultAddressElement = addressElement.findElements(By.cssSelector("div.default-address-label div"));
		return defaultAddressElement.get(0).getText().trim();
	}
	
	public AccountPreferencesPageActionsFrig clickAddNewAddressButton() {	
		waitForCondition(ExpectedConditions.visibilityOfAllElementsLocatedBy(apLocator.shippingDetailsAddressBoxes));
		scrollIntoView(apLocator.shippingDetails_AddNewAddressButton);
		clickElement(apLocator.shippingDetails_AddNewAddressButton);
		return this;
	}
	
	public boolean isAddNewShippingAddressLabelDisplayed() {
		scrollIntoView(apLocator.addNewShippingAddressLabel);
		return isDisplayed(apLocator.addNewShippingAddressLabel);
	}
	
	public boolean isFirstNameFieldDisplayed() {
		return isDisplayed(apLocator.addNewAddress_FirstNameField);
	}
	
	public boolean isLastNameFieldDisplayed() {
		return isDisplayed(apLocator.addNewAddress_LastNameField);
	}
	
	public boolean isAddressLine1FieldDisplayed() {
		return isDisplayed(apLocator.addNewAddress_addressLine1Field);
	}
	
	public boolean isAddressLine2FieldDisplayed() {
		return isDisplayed(apLocator.addNewAddress_addressLine2Field);
	}
	
	public boolean isCityFieldDisplayed() {
		return isDisplayed(apLocator.addNewAddress_CityField);
	}
	
	public boolean isStateDropdownDisplayed() {
		return isDisplayed(apLocator.addNewAddress_StateDropdown);
	}
	
	public boolean isZipCodeFieldDisplayed() {
		return isDisplayed(apLocator.addNewAddress_ZipCodeField);
	}
	
	public boolean isPhoneNumberFieldDisplayed() {
		return isDisplayed(apLocator.addNewAddress_PhoneNumberField);
	}
	
	public boolean isMakeThisDefaultShippingAddressCheckboxDisplayed() {
		return isDisplayed(apLocator.addNewAddress_MakeDefaultAddressCheckbox);
	}
	
	public boolean isSaveAddressButtonDisplayed() {
		scrollIntoView(apLocator.addNewAddress_SaveAddressButton);
		return isDisplayed(apLocator.addNewAddress_SaveAddressButton);
	}
	
	public boolean isCancelShippingAddressButtonDisplayed() {
		scrollIntoView(apLocator.addNewAddress_CancelButton);
		return isDisplayed(apLocator.addNewAddress_CancelButton);
	}
	
	public AccountPreferencesPageActionsFrig clickSaveAddressButton() {
		clickElement(apLocator.addNewAddress_SaveAddressButton);
		return this;
	}
	
	public AccountPreferencesPageActionsFrig clickCancelShippingAddressButton() {
		scrollIntoView(apLocator.addNewAddress_CancelButton);
		clickElement(apLocator.addNewAddress_CancelButton);
		waitForCondition(ExpectedConditions.invisibilityOfElementLocated(apLocator.addNewShippingAddressLabel),5);
		return this;
	}
	
	public boolean isAddressLineFieldsDisplayed() {
		return isAddressLine1FieldDisplayed() && isAddressLine2FieldDisplayed();
	}
	
	public boolean isCurrentPasswordFieldDisplayed() {
		scrollIntoView(apLocator.changePassword_CurrentPasswordField);
		return isDisplayed(apLocator.changePassword_CurrentPasswordField);
	}
	
	public boolean isEnterCurrentPasswordLabelDisplayed() {
		return isDisplayed(apLocator.changePassword_EnterYourCurrentPasswordLabel);
	}
	
	public boolean isSetNewPasswordLabelDisplayed() {
		return isDisplayed(apLocator.changePassword_SetANewPasswordLabel);
	}
	
	public boolean isNewPasswordFieldDisplayed() {
		return isDisplayed(apLocator.changePassword_NewPasswordField);
	}
	
	public boolean isConfirmNewPasswordFieldDisplayed() {
		return isDisplayed(apLocator.changePassword_ConfirmNewPasswordField);
	}
	
	public String getPasswordRequirementText() {
		return getText(apLocator.changePassword_PasswordRequirementText);
	}
	
	public boolean isSetPasswordButtonDisplayed() {
		return isDisplayed(apLocator.changePassword_setPasswordButton);	
	}
	
	public boolean isCurrentPasswordSectionDisplayed() {
		return isCurrentPasswordFieldDisplayed() && isEnterCurrentPasswordLabelDisplayed();
	}
	
	public boolean isNewPasswordSectionDisplayed() {
		return isSetNewPasswordLabelDisplayed() && isNewPasswordFieldDisplayed()	
				&& isConfirmNewPasswordFieldDisplayed();
	}
	
	public boolean isAddNewPaymentDuringCheckoutLabelDisplayed() {
		return isDisplayed(apLocator.addNewPaymentDuringCheckoutLabel);	
	}
	
	public String getNeedHelpBannerText() {
		return getText(apLocator.needHelpBanner);
	}
	
	public boolean isUserNavigatedToAccountPreferencesPage() {
		return getCurrentUrl().contains("accountPreference");
	}
	 
}
