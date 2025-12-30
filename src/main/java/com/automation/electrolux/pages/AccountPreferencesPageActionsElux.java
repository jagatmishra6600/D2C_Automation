package com.automation.electrolux.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.electrolux.locators.AccountPreferencesLocatorsElux;
import com.automation.utils.ConfigReader;
import static com.automation.utils.WaitUtils.*;
import static com.automation.utils.WebElementUtil.*;

public class AccountPreferencesPageActionsElux {

	private AccountPreferencesLocatorsElux apLocators = new AccountPreferencesLocatorsElux();
	private final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	private static final String PROPERTY_VALUE_ACTIVE = "active";
	private static final String PROPERTY_CLASS_NAME = "className";
	public AccountPreferencesPageActionsElux navigateToLoginPage() {
		navigateTo(ConfigReader.getProperty("app.url")+"login");
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
	
	public boolean isAccountPreferenceTabDisplayed() {
		return isDisplayed(apLocators.accountPreferenceTabButton);
	}
	
	public boolean isAccountPreferenceTabSelected() {
	    String classProperty = getDomProperty(apLocators.accountPreferenceTabButton, PROPERTY_CLASS_NAME);
	    return classProperty != null && classProperty.contains(PROPERTY_VALUE_ACTIVE);
	}
	
	public boolean isMyOrdersTabSelected() {
	    String classProperty = getDomProperty(apLocators.myOrdersTabButton, PROPERTY_CLASS_NAME);
	    return classProperty != null && classProperty.contains(PROPERTY_VALUE_ACTIVE);
	}
	
	public boolean isMySubscriptionTabSelected() {
	    String classProperty = getDomProperty(apLocators.mySubscriptionTabButton, PROPERTY_CLASS_NAME);
	    return classProperty != null && classProperty.contains(PROPERTY_VALUE_ACTIVE);
	}
	
	public boolean isMyAppliancesTabSelected() {
	    String classProperty = getDomProperty(apLocators.myAppliancesTabButton, PROPERTY_CLASS_NAME);
	    return classProperty != null && classProperty.contains(PROPERTY_VALUE_ACTIVE);
	}
	
	public AccountPreferencesPageActionsElux selectAccountPreferenceTab() {
	    clickElement(apLocators.accountPreferenceTabButton);
	    return this;
	}
	
	public AccountPreferencesPageActionsElux selectMyOrdersTab() {
	    clickElement(apLocators.myOrdersTabButton);
	    return this;
	}
	
	public AccountPreferencesPageActionsElux selectMyAppliancesTab() {
	    clickElement(apLocators.myAppliancesTabButton);
	    return this;
	}
	
	public AccountPreferencesPageActionsElux selectMySubscriptionTab() {
	    clickElement(apLocators.mySubscriptionTabButton);
	    return this;
	}
	
	public boolean isAccountPreferencesTabNavigationSuccessful() {
		selectAccountPreferenceTab();
		return isAccountPreferenceTabSelected();
	}
	
	public boolean isMyOrdersTabNavigationSuccessful() {
		selectMyOrdersTab();
		return isMyOrdersTabSelected();
	}
	
	public boolean isMyAppliancesTabNavigationSuccessful() {
		selectMyAppliancesTab();
		return isMyAppliancesTabSelected();
	}
	
	public boolean isMySubscriptionsTabNavigationSuccessful() {
		selectMySubscriptionTab();
		return isMySubscriptionTabSelected();
	}
	
	public boolean isShippingDetailsAddressBoxesDisplayed() {
		var addressBoxes = getShippingDetailsAddressBoxList();
		return addressBoxes != null && addressBoxes.size() > 1;
	}
	
	public boolean isAddressDetailsPresentForAllAddresses() {
	    var addressBoxes = getShippingDetailsAddressBoxList();
	    for (WebElement address : addressBoxes) {
	        var addressDetails = address.findElements(By.xpath(".//div[contains(@class,'address-details')]"));
	        if (addressDetails.isEmpty() || !addressDetails.get(0).isDisplayed()) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public List<WebElement> getShippingDetailsAddressBoxList() {
		scrollIntoView(apLocators.shippingDetailsTitle);
		waitForCondition(ExpectedConditions.visibilityOfAllElementsLocatedBy(apLocators.shippingDetailsAddressBoxes));
		return findElements(apLocators.shippingDetailsAddressBoxes);
	}
	
	public boolean hasAllAddressBoxActionButtons() {
		waitForPageLoad();
		var addressBoxes = getShippingDetailsAddressBoxList();
		
		if (addressBoxes == null || addressBoxes.isEmpty()) {
			throw new IllegalStateException("Address Boxes did not load Successfully");
	    }
		
		var addressBox = addressBoxes.size() >= 2 ? addressBoxes.get(1) : addressBoxes.get(0);
		var isEditButtonDisplayed = isAddressEditPencilButtonDisplayed(addressBox);
		var isDeleteButtonDisplayed = isAddressDeleteButtonDisplayed(addressBox);
				
		if(addressBoxes.size()>=2) {
			return getAddressSetAsDefaultButtonDisplayed(addressBox)
	                && isEditButtonDisplayed && isDeleteButtonDisplayed;
		}
		else {
			return getAddressMyDefaultButtonDisplayed(addressBox) 
					&& isEditButtonDisplayed && isDeleteButtonDisplayed;
		}
	}
	
	public boolean getAddressSetAsDefaultButtonDisplayed(WebElement addressElement) {
		var setAsDefaultAddressElement = addressElement.findElements(By.xpath("//div[contains(@class,'address-buttons')]//a[contains(.,'Set as Default')]"));
		return setAsDefaultAddressElement.get(0).isDisplayed();
	}
	
	public boolean isAddressEditPencilButtonDisplayed(WebElement addressElement) {
		var editButtonXpathLocator = "//div[contains(@class,'address-buttons')]//a[contains(.,'Edit')]";
		var addressEditPencilButton = addressElement.findElements(By.xpath(editButtonXpathLocator));
		if(addressEditPencilButton.isEmpty()) {
			addressEditPencilButton = addressElement.findElements(By.xpath(editButtonXpathLocator));		
		}
		return addressEditPencilButton.get(0).isDisplayed();
	}
	
	public boolean isAddressDeleteButtonDisplayed(WebElement addressElement) {
		var removeButtonXpathLocator = "//div[contains(@class,'address-buttons')]//a[contains(.,'Remove')]";
		var addressDeleteButton = addressElement.findElements(By.xpath(removeButtonXpathLocator));
		if(addressDeleteButton.isEmpty()) {
			addressDeleteButton = addressElement.findElements(By.xpath(removeButtonXpathLocator));		
		}
		return addressDeleteButton.get(0).isDisplayed();
	}
	
	public boolean getAddressMyDefaultButtonDisplayed(WebElement addressElement) {
		var defaultAddressElement = addressElement.findElements(By.xpath("//div[contains(@class,'address-buttons')]//a[contains(.,'My Default')]"));
		return defaultAddressElement.get(0).isDisplayed();
	}
	
	public AccountPreferencesPageActionsElux clickAddNewAddressButton() {	
		waitForCondition(ExpectedConditions.visibilityOfAllElementsLocatedBy(apLocators.shippingDetailsAddressBoxes));
		scrollIntoView(apLocators.shippingDetails_AddNewAddressButton);
		clickElement(apLocators.shippingDetails_AddNewAddressButton);
		return this;
	}
	
	public boolean isAddNewShippingAddressLabelDisplayed() {
		scrollIntoView(apLocators.addNewShippingAddressLabel);
		return isDisplayed(apLocators.addNewShippingAddressLabel);
	}
	
	public boolean isFirstNameFieldDisplayed() {
		return isDisplayed(apLocators.addNewAddress_FirstNameField);
	}
	
	public boolean isLastNameFieldDisplayed() {
		return isDisplayed(apLocators.addNewAddress_LastNameField);
	}
	
	public boolean isAddressLine1FieldDisplayed() {
		return isDisplayed(apLocators.addNewAddress_addressLine1Field);
	}
	
	public boolean isAddressLine2FieldDisplayed() {
		return isDisplayed(apLocators.addNewAddress_addressLine2Field);
	}
	
	public boolean isCityFieldDisplayed() {
		return isDisplayed(apLocators.addNewAddress_CityField);
	}
	
	public boolean isStateDropdownDisplayed() {
		return isDisplayed(apLocators.addNewAddress_StateDropdown);
	}
	
	public boolean isZipCodeFieldDisplayed() {
		return isDisplayed(apLocators.addNewAddress_ZipCodeField);
	}
	
	public boolean isPhoneNumberFieldDisplayed() {
		return isDisplayed(apLocators.addNewAddress_PhoneNumberField);
	}
	
	public boolean isMakeThisDefaultShippingAddressCheckboxDisplayed() {
		return isDisplayed(apLocators.addNewAddress_MakeDefaultAddressCheckbox);
	}
	
	public boolean isSaveAddressButtonDisplayed() {
		return isDisplayed(apLocators.addNewAddress_SaveAddressButton);
	}
	
	public boolean isCancelShippingAddressButtonDisplayed() {
		return isDisplayed(apLocators.addNewAddress_CancelButton);
	}
	
	public AccountPreferencesPageActionsElux clickSaveAddressButton() {
		clickElement(apLocators.addNewAddress_SaveAddressButton);
		return this;
	}
	
	public AccountPreferencesPageActionsElux clickCancelShippingAddressButton() {
		scrollIntoView(apLocators.addNewAddress_CancelButton);
		clickElement(apLocators.addNewAddress_CancelButton);
		untilInvisible(apLocators.addNewShippingAddressLabel,5);
		return this;
	}
	
	public boolean isAddressLineFieldsDisplayed() {
		return isAddressLine1FieldDisplayed() && isAddressLine2FieldDisplayed();
	}
	
	public boolean isCurrentPasswordFieldDisplayed() {
		return isDisplayed(apLocators.changePassword_CurrentPasswordField);
	}
	
	public boolean isEnterCurrentPasswordLabelDisplayed() {
		return isDisplayed(apLocators.changePassword_EnterYourCurrentPasswordLabel);
	}
	
	public boolean isSetNewPasswordLabelDisplayed() {
		return isDisplayed(apLocators.changePassword_SetANewPasswordLabel);
	}
	
	public boolean isNewPasswordFieldDisplayed() {
		return isDisplayed(apLocators.changePassword_NewPasswordField);
	}
	
	public boolean isConfirmNewPasswordFieldDisplayed() {
		return isDisplayed(apLocators.changePassword_ConfirmNewPasswordField);
	}
	
	public String getPasswordRequirementText() {
		return getText(apLocators.changePassword_PasswordRequirementText);
	}
	
	public boolean isSetPasswordButtonDisplayed() {
		return isDisplayed(apLocators.changePassword_setPasswordButton);	
	}
	
	public boolean isCurrentPasswordSectionDisplayed() {
		scrollIntoView(apLocators.changePassword_EnterYourCurrentPasswordLabel);
		return isCurrentPasswordFieldDisplayed() && isEnterCurrentPasswordLabelDisplayed();
	}
	
	public boolean isNewPasswordSectionDisplayed() {
		return isSetNewPasswordLabelDisplayed() && isNewPasswordFieldDisplayed()	
				&& isConfirmNewPasswordFieldDisplayed();
	}
	
	public boolean isAddNewPaymentDuringCheckoutLabelDisplayed() {
		return isDisplayed(apLocators.addNewPaymentDuringCheckoutLabel);	
	}
	
	public String getNeedHelpBannerText() {
		return getText(apLocators.needHelpBanner);
	}
	
	public boolean isMailSectionDisplayed() {
		scrollIntoView(apLocators.mail_Heading);
	    return isDisplayed(apLocators.mail_Heading)
	        && isDisplayed(apLocators.mail_KitchenLaundryAddressBlock)
	        && isDisplayed(apLocators.mail_SmallKitchenAppliancesAddressBlock);
	}
	
	public boolean isPhoneSectionDisplayed() {
		scrollIntoView(apLocators.phone_Heading);
	    return isDisplayed(apLocators.phone_Heading)
	        && isDisplayed(apLocators.phone_KitchenLaundryPhoneBlock)
	        && isDisplayed(apLocators.phone_SmallKitchenAppliancesPhoneBlock);
	}
	
	public String getKitchenLaundryPhoneSectionText() {
		scrollIntoView(apLocators.phone_Heading);
		return getText(apLocators.phone_KitchenLaundryPhoneBlock);	
	}
	
	public String getSmallKitchenAppliancePhoneSectionText() {
		scrollIntoView(apLocators.phone_Heading);
		return getText(apLocators.phone_SmallKitchenAppliancesPhoneBlock);	
	}
	
	public boolean isUserNavigatedToAccountPreferencesPage() {
		return getCurrentUrl().contains("accountPreference");
	}
}
