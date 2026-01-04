package com.automation.frigidaire.locators;
import org.openqa.selenium.By;

public class AccountPreferencesLocatorsFrig {
	
    public final By accountPreferencesTabButton = By.xpath("//button[@id='myaccountPreferenceComponentelx']");
    public final By mySubscriptionsTabButton = By.xpath("//button[@id='mysubcriptionsComponentelx']");
    public final By myOrdersTabButton = By.xpath("//button[@id='myordersComponentelx']");
    public final By myAppliancesTabButton = By.xpath("//button[@id='myappliancesComponentelx']");
    public final By shippingDetailsAddressBoxes = By.cssSelector("div.address-wrapper");
    public final By shippingDetailsTitle = By.cssSelector("#shippingAddress");
    public final By shippingDetails_AddNewAddressButton = By.xpath("//button[contains(.,'Add New Address')]");
    public final By addNewShippingAddressLabel = By.cssSelector("#shipping-address h3");
    public final By addNewAddress_FirstNameField = By.cssSelector("input[placeholder='First name*']");
    public final By addNewAddress_LastNameField = By.cssSelector("input[placeholder='Last name*']");
    public final By addNewAddress_addressLine1Field = By.id("address-1");
    public final By addNewAddress_addressLine2Field = By.id("address-2");
    public final By addNewAddress_CityField = By.cssSelector("input[placeholder='City*']");
    public final By addNewAddress_StateDropdown = By.cssSelector("ng-select.region-select");
    public final By addNewAddress_ZipCodeField = By.cssSelector("input[placeholder='Postal Code/Zip']");
    public final By addNewAddress_PhoneNumberField = By.cssSelector("input[formcontrolname='phone']");
    public final By addNewAddress_MakeDefaultAddressCheckbox = By.cssSelector("input[type='checkbox'][formcontrolname='defaultAddress']");
    public final By addNewAddress_SaveAddressButton = By.id("saveAddress");
    public final By addNewAddress_CancelButton = By.xpath("//button[@type='button' and normalize-space()='Cancel']");
    public final By changePassword_EnterYourCurrentPasswordLabel = By.xpath("//label[contains(.,'Enter your Current password.')]");
    public final By changePassword_CurrentPasswordField = By.xpath("//input[@placeholder='Current password *']");
    public final By changePassword_SetANewPasswordLabel = By.xpath("//label[contains(.,'Set a new password for your account.')]");
    public final By changePassword_NewPasswordField = By.xpath("//input[@placeholder='New password *']");
    public final By changePassword_ConfirmNewPasswordField = By.xpath("//input[@placeholder='Confirm new password *']");
    public final By changePassword_PasswordRequirementText = By.xpath("//label[contains(.,'Password must contain')]");
    public final By changePassword_setPasswordButton = By.xpath("//input[@type='submit' and @value='Set Password']");
    public final By addNewPaymentDuringCheckoutLabel = By.xpath("//p[contains(.,'You can add new payment')]");
    public final By needHelpBanner = By.cssSelector(".help-header");
    public final By paymentDetails_PaymentCard = By.xpath("(//app-elux-my-account-payment-cards//div[contains(@class,'card') and contains(@class,'mt-2')])[1]");
    public final By paymentDetails_PaymentCards = By.xpath("//app-elux-my-account-payment-cards//div[contains(@class,'card') and contains(@class,'mt-2')]");
    public final By paymentDetails_PaymentCardsDetail = By.xpath("//app-elux-my-account-payment-cards//div[contains(@class,'card') and contains(@class,'mt-2')]//div[@class='card-body']");
}
