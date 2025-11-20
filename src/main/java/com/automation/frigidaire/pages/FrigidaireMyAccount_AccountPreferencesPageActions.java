package com.automation.frigidaire.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.utils.ConfigReader;
import com.automation.utils.WebElementUtil;

public class FrigidaireMyAccount_AccountPreferencesPageActions {

	 private final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");

	 private final By accountPreferenceTabButton = By.xpath("//button[@id='myaccountPreferenceComponentelx']");
	 private final By mySubscriptionTabButton = By.xpath("//button[@id='mysubcriptionsComponentelx']");
	 private final By myOrdersTabButton = By.xpath("//button[@id='myordersComponentelx']");
	 private final By myAppliancesTabButton = By.xpath("//button[@id='myappliancesComponentelx']");
	 private final By shippingDetailsAddressBoxes = By.cssSelector("div.address-wrapper");
	 private final By shippingDetailsTitle = By.cssSelector("#shippingAddress");
	 private final By shippingDetails_AddNewAddressButton = By.xpath("//button[contains(.,'Add New Address')]");
	 private final By addNewShippingAddressLabel = By.cssSelector("#shipping-address h3");
	 private final By addNewAddress_FirstNameField = By.cssSelector("input[placeholder='First name*']");
	 private final By addNewAddress_LastNameField = By.cssSelector("input[placeholder='Last name*']");
	 private final By addNewAddress_addressLine1Field = By.id("address-1");
	 private final By addNewAddress_addressLine2Field = By.id("address-2");
	 private final By addNewAddress_CityField = By.cssSelector("input[placeholder='City*']");
	 private final By addNewAddress_StateDropdown = By.cssSelector("ng-select.region-select");
	 private final By addNewAddress_ZipCodeField = By.cssSelector("input[placeholder='Postal Code/Zip']");
	 private final By addNewAddress_PhoneNumberField = By.cssSelector("input[formcontrolname='phone']");
	 private final By addNewAddress_MakeDefaultAddressCheckbox = By.cssSelector("input[type='checkbox'][formcontrolname='defaultAddress']");
	 private final By addNewAddress_SaveAddressButton = By.id("saveAddress");
	 private final By addNewAddress_CancelButton = By.xpath("//button[@type='button' and normalize-space()='Cancel']");
	 private final By changePassword_EnterYourCurrentPasswordLabel = By.xpath("//label[contains(.,'Enter your Current password.')]");
	 private final By changePassword_CurrentPasswordField = By.xpath("//input[@placeholder='Current password *']");
	 private final By changePassword_SetANewPasswordLabel = By.xpath("//label[contains(.,'Set a new password for your account.')]");
	 private final By changePassword_NewPasswordField = By.xpath("//input[@placeholder='New password *']");
	 private final By changePassword_ConfirmNewPasswordField = By.xpath("//input[@placeholder='Confirm new password *']");
	 private final By changePassword_PasswordRequirementText = By.xpath("//label[contains(.,'Password must contain')]");
	 private final By changePassword_setPasswordButton = By.xpath("//input[@type='submit' and @value='Set Password']");
	 private final By addNewPaymentDuringCheckoutLabel = By.xpath("//p[contains(.,'You can add new payment')]");
	 private final By needHelpBanner = By.cssSelector(".help-header");
	 private final By paymentDetails_PaymentCard = By.xpath("(//app-elux-my-account-payment-cards//div[contains(@class,'card') and contains(@class,'mt-2')])[1]");
	 private final By paymentDetails_PaymentCards = By.xpath("//app-elux-my-account-payment-cards//div[contains(@class,'card') and contains(@class,'mt-2')]");
	 private final By paymentDetails_PaymentCardsDetail = By.xpath("//app-elux-my-account-payment-cards//div[contains(@class,'card') and contains(@class,'mt-2')]//div[@class='card-body']");
	 public FrigidaireMyAccount_AccountPreferencesPageActions navigateToLoginPage() {
		WebElementUtil.navigateTo(ConfigReader.getProperty("app.url")+"login");
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
		return WebElementUtil.isDisplayed(accountPreferenceTabButton);
	}
	
	public boolean isAccountPreferenceTabSelected() {
	    String classProperty = WebElementUtil.getDomProperty(accountPreferenceTabButton, "className");
	    return classProperty != null && classProperty.contains("active");
	}
	
	public boolean isMyOrdersTabSelected() {
	    String classProperty = WebElementUtil.getDomProperty(myOrdersTabButton, "className");
	    return classProperty != null && classProperty.contains("active");
	}
	
	public boolean isMySubscriptionTabSelected() {
	    String classProperty = WebElementUtil.getDomProperty(mySubscriptionTabButton, "className");
	    return classProperty != null && classProperty.contains("active");
	}
	
	public boolean isMyAppliancesTabSelected() {
	    String classProperty = WebElementUtil.getDomProperty(myAppliancesTabButton, "className");
	    return classProperty != null && classProperty.contains("active");
	}
	
	public FrigidaireMyAccount_AccountPreferencesPageActions selectAccountPreferenceTab() {
	    WebElementUtil.clickElement(accountPreferenceTabButton);
	    if (!isAccountPreferenceTabSelected()) {
	        throw new IllegalStateException("Account Preference Tab Not Selected");
	    }
	    return this;
	}
	
	public FrigidaireMyAccount_AccountPreferencesPageActions selectMyOrdersTab() {
	    WebElementUtil.clickElement(myOrdersTabButton);
	    if (!isMyOrdersTabSelected()) {
	        throw new IllegalStateException("My Orders Tab Not Selected");
	    }
	    return this;
	}
	
	public FrigidaireMyAccount_AccountPreferencesPageActions selectMyAppliancesTab() {
	    WebElementUtil.clickElement(myAppliancesTabButton);
	    if (!isMyAppliancesTabSelected()) {
	        throw new IllegalStateException("My Appliances Tab Not Selected");
	    }
	    return this;
	}
	
	public FrigidaireMyAccount_AccountPreferencesPageActions selectMySubscriptionTab() {
	    WebElementUtil.clickElement(mySubscriptionTabButton);
	    if (!isMySubscriptionTabSelected()) {
	        throw new IllegalStateException("My Subscription Tab Not Selected");
	    }
	    return this;
	}
	
	public boolean isAllTabsNavigationSuccessful() {
	    try {
	        selectAccountPreferenceTab();
	        selectMyOrdersTab();
	        selectMyAppliancesTab();
	        selectMySubscriptionTab();
	        return true; 
	    } catch (Exception e) {
	        return false;
	    }
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
		WebElementUtil.scrollIntoView(shippingDetailsTitle);
		WebElementUtil.waitForCondition(ExpectedConditions.visibilityOfAllElementsLocatedBy(shippingDetailsAddressBoxes));
		return WebElementUtil.findElements(shippingDetailsAddressBoxes);
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
		var addressEditPencilButton = addressElement.findElements(By.cssSelector("div.default-address-label a.details.mr-2"));
		return addressEditPencilButton.get(0).isDisplayed();
	}
	
	public boolean isAddressDeleteButtonDisplayed(WebElement addressElement) {
		var addressDeleteButton = addressElement.findElements(By.cssSelector("div.default-address-label img[alt='Trash Can']"));
		return addressDeleteButton.get(0).isDisplayed();
	}
	
	public String getAddressDefaultButtonText(WebElement addressElement) {
		var defaultAddressElement = addressElement.findElements(By.cssSelector("div.default-address-label div"));
		return defaultAddressElement.get(0).getText().trim();
	}
	
	public FrigidaireMyAccount_AccountPreferencesPageActions clickAddNewAddressButton() {	
		WebElementUtil.waitForCondition(ExpectedConditions.visibilityOfAllElementsLocatedBy(shippingDetailsAddressBoxes));
		WebElementUtil.scrollIntoView(shippingDetails_AddNewAddressButton);
		WebElementUtil.clickElement(shippingDetails_AddNewAddressButton);
		return this;
	}
	
	public boolean isAddNewShippingAddressLabelDisplayed() {
		WebElementUtil.scrollIntoView(addNewShippingAddressLabel);
		return WebElementUtil.isDisplayed(addNewShippingAddressLabel);
	}
	
	public boolean isFirstNameFieldDisplayed() {
		return WebElementUtil.isDisplayed(addNewAddress_FirstNameField);
	}
	
	public boolean isLastNameFieldDisplayed() {
		return WebElementUtil.isDisplayed(addNewAddress_LastNameField);
	}
	
	public boolean isAddressLine1FieldDisplayed() {
		return WebElementUtil.isDisplayed(addNewAddress_addressLine1Field);
	}
	
	public boolean isAddressLine2FieldDisplayed() {
		return WebElementUtil.isDisplayed(addNewAddress_addressLine2Field);
	}
	
	public boolean isCityFieldDisplayed() {
		return WebElementUtil.isDisplayed(addNewAddress_CityField);
	}
	
	public boolean isStateDropdownDisplayed() {
		return WebElementUtil.isDisplayed(addNewAddress_StateDropdown);
	}
	
	public boolean isZipCodeFieldDisplayed() {
		return WebElementUtil.isDisplayed(addNewAddress_ZipCodeField);
	}
	
	public boolean isPhoneNumberFieldDisplayed() {
		return WebElementUtil.isDisplayed(addNewAddress_PhoneNumberField);
	}
	
	public boolean isMakeThisDefaultShippingAddressCheckboxDisplayed() {
		return WebElementUtil.isDisplayed(addNewAddress_MakeDefaultAddressCheckbox);
	}
	
	public boolean isSaveAddressButtonDisplayed() {
		return WebElementUtil.isDisplayed(addNewAddress_SaveAddressButton);
	}
	
	public boolean isCancelShippingAddressButtonDisplayed() {
		return WebElementUtil.isDisplayed(addNewAddress_CancelButton);
	}
	
	public FrigidaireMyAccount_AccountPreferencesPageActions clickSaveAddressButton() {
		WebElementUtil.clickElement(addNewAddress_SaveAddressButton);
		return this;
	}
	
	public FrigidaireMyAccount_AccountPreferencesPageActions clickCancelShippingAddressButton() {
		WebElementUtil.scrollIntoView(addNewAddress_CancelButton);
		WebElementUtil.clickElement(addNewAddress_CancelButton);
		WebElementUtil.waitForCondition(ExpectedConditions.invisibilityOfElementLocated(addNewShippingAddressLabel));
		return this;
	}
	
	public boolean isAddressLineFieldsDisplayed() {
		return isAddressLine1FieldDisplayed() && isAddressLine2FieldDisplayed();
	}
	
	public boolean isCurrentPasswordFieldDisplayed() {
		return WebElementUtil.isDisplayed(changePassword_CurrentPasswordField);
	}
	
	public boolean isEnterCurrentPasswordLabelDisplayed() {
		return WebElementUtil.isDisplayed(changePassword_EnterYourCurrentPasswordLabel);
	}
	
	public boolean isSetNewPasswordLabelDisplayed() {
		return WebElementUtil.isDisplayed(changePassword_SetANewPasswordLabel);
	}
	
	public boolean isNewPasswordFieldDisplayed() {
		return WebElementUtil.isDisplayed(changePassword_NewPasswordField);
	}
	
	public boolean isConfirmNewPasswordFieldDisplayed() {
		return WebElementUtil.isDisplayed(changePassword_ConfirmNewPasswordField);
	}
	
	public String getPasswordRequirementText() {
		return WebElementUtil.getText(changePassword_PasswordRequirementText);
	}
	
	public boolean isSetPasswordButtonDisplayed() {
		return WebElementUtil.isDisplayed(changePassword_setPasswordButton);	
	}
	
	public boolean isCurrentPasswordSectionDisplayed() {
		return isCurrentPasswordFieldDisplayed() && isEnterCurrentPasswordLabelDisplayed();
	}
	
	public boolean isNewPasswordSectionDisplayed() {
		return isSetNewPasswordLabelDisplayed() && isNewPasswordFieldDisplayed()	
				&& isConfirmNewPasswordFieldDisplayed();
	}
	
	public boolean isAddNewPaymentDuringCheckoutLabelDisplayed() {
		return WebElementUtil.isDisplayed(addNewPaymentDuringCheckoutLabel);	
	}
	
	public String getNeedHelpBannerText() {
		return WebElementUtil.getText(needHelpBanner);
	}
	
	public boolean isPaymentDetailsPaymentCardsDisplayed() {
		var paymentCardsList = getPaymentDetailsPaymentCardsList();
		if(paymentCardsList.size()>1 ) {
			return true;
		}
		return false;
	}
	
	public List<WebElement> getPaymentDetailsPaymentCardsList() {
		WebElementUtil.isDisplayed(addNewPaymentDuringCheckoutLabel);
		WebElementUtil.scrollIntoView(addNewPaymentDuringCheckoutLabel);
		WebElementUtil.waitForCondition(ExpectedConditions.visibilityOfAllElementsLocatedBy(paymentDetails_PaymentCards));
		return WebElementUtil.findElements(paymentDetails_PaymentCards);
	}
	
	public List<WebElement> getPaymentDetailsPaymentCardsDetailList() {
		WebElementUtil.isDisplayed(addNewPaymentDuringCheckoutLabel);
		WebElementUtil.scrollIntoView(addNewPaymentDuringCheckoutLabel);
		WebElementUtil.waitForCondition(ExpectedConditions.visibilityOfAllElementsLocatedBy(paymentDetails_PaymentCardsDetail));
		return WebElementUtil.findElements(paymentDetails_PaymentCardsDetail);
	}
	
	public boolean isPaymentCardDetailsValid(WebElement card) {
	    List<WebElement> fields = card.findElements(By.tagName("div"));

	    if (fields.size() < 3) return false;

	    String name = fields.get(0).getText().trim();
	    String maskedNumber = fields.get(1).getText().trim();
	    String expiry = fields.get(2).getText().trim();

	    var logoVisible = isCardLogoVisible(card);
	    return isNameValid(name)
	            && isMaskedNumberValid(maskedNumber)
	            && isExpiryValid(expiry)
	            && logoVisible;
	}
	
	private boolean isNameValid(String name) {
	    return name != null && !name.isEmpty();
	}
	
	private boolean isCardLogoVisible(WebElement card) {
	    try {
	        WebElement icon = card.findElement(By.tagName("cx-icon"));
	        return icon.isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
	
	private boolean isMaskedNumberValid(String number) {
	    // regex pattern: **** **** **** 0000 (last 4 digits visible)
	    return number.matches("\\*{4} \\*{4} \\*{4} \\d{4}");
	}
	
	private boolean isExpiryValid(String expiry) {
	    // Pattern like: Expires: 3 /2030
	    return expiry.matches("Expires:\\s*(0?[1-9]|1[0-2])\\s*/\\s*\\d{4}");
	}
	
	public boolean areAllPaymentCardsValid() {
	    List<WebElement> cards = getPaymentDetailsPaymentCardsDetailList();
	    if (cards.isEmpty()) return false;

	    for (WebElement card : cards) {
	        if (!isPaymentCardDetailsValid(card)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	 
}
