package com.automation.electrolux.pages;

import com.automation.electrolux.locators.DeliveryDatesLocatorsElux;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DeliveryDatePageActionsElux {
    DeliveryDatesLocatorsElux locators = new DeliveryDatesLocatorsElux();

    public void searchProduct(String productName) {
        WebElementUtil.waitForElementToBeClickable(locators.searchBox, 20);
        WebElementUtil.sendKeys(locators.searchBox, productName + Keys.ENTER);
    }

    public void selectProductFromPLP() {
        WebElementUtil.waitForElementToBeVisible(locators.productPDP, 10);
        WebElementUtil.waitForElementToBeClickable(locators.productPDP, 10);
        WebElementUtil.scrollIntoView(locators.productPDP);
        WebElementUtil.clickElement(locators.productPDP);
    }

    public void clickAddToCart() {
        WebElementUtil.waitForElementToBeVisible(locators.addToCartButton, 10);
        WebElementUtil.scrollToElementStable(locators.addToCartButton);
        WebElementUtil.waitForElementToBeClickable(locators.addToCartButton, 10);
        WebElementUtil.clickElement(locators.addToCartButton);
        WebElementUtil.waitForElementToBeVisible(locators.viewCartButton, 10);
        WebElementUtil.scrollToElementStable(locators.addToCartButton);
        WebElementUtil.clickElement(locators.viewCartButton);
    }
    public void selectDeliveryAndSaveAndViewCart() {
        // Select delivery & installation radio
        WebElementUtil.waitForElementToBeVisible(locators.deliveryInstallationRadio, 10);
        WebElementUtil.scrollToElementStable(locators.deliveryInstallationRadio);
        WebElementUtil.waitForElementToBeClickable(locators.deliveryInstallationRadio);
        WebElementUtil.clickElement(locators.deliveryInstallationRadio);

        // Click Save and view cart
        WebElementUtil.scrollToElementStable(locators.saveAndViewCartButton);
        WebElementUtil.waitForElementToBeClickable(locators.saveAndViewCartButton, 20);
        WebElementUtil.clickElement(locators.saveAndViewCartButton);
    }

    public void clickProceedToCheckout() {
        WebElementUtil.waitForElementToBeVisible(locators.proceedToCheckoutButton, 20);
        WebElementUtil.waitForElementToBeClickable(locators.proceedToCheckoutButton);
        WebElementUtil.clickElement(locators.proceedToCheckoutButton);
        WebElementUtil.waitForElementToBeVisible(locators.shippingAddressForm, 20);
    }

//     * Clicks the "Continue to delivery" button after shipping details are entered.
//            * Returns true if the click succeeded, false otherwise.
//     */
    public boolean clickContinueToDelivery() {

        return clickContinueToDelivery(
                "pandey.devishankar@knacksystems.com",
                "Bhavani",
                "Pandey",
                "969 Cox Rd Gastonia",
                "9427876292"
        );
    }

    /**
     * Fills shipping form fields then clicks Continue to delivery.
     * Returns true if the click succeeded and no exception was thrown.
     */
    public boolean clickContinueToDelivery(String email, String firstName, String lastName, String addressLine1, String phone) {

        try {
            // Fill email
            WebElementUtil.scrollToElementStable(locators.shippingEmail);
            WebElementUtil.waitForElementToBeVisible(locators.shippingEmail, 10);
            WebElementUtil.sendKeys(locators.shippingEmail, email);

            // Fill first name and last name
            WebElementUtil.scrollToElementStable(locators.shippingFirstName);
            WebElementUtil.waitForElementToBeVisible(locators.shippingFirstName, 10);
            WebElementUtil.sendKeys(locators.shippingFirstName, firstName);

            WebElementUtil.waitForElementToBeVisible(locators.shippingLastName, 10);
            WebElementUtil.sendKeys(locators.shippingLastName, lastName);

            // Fill address line
            WebElementUtil.scrollToElementStable(locators.shippingAddressLine1);
            WebElementUtil.waitForElementToBeVisible(locators.shippingAddressLine1, 10);
            WebElementUtil.sendKeys(locators.shippingAddressLine1, addressLine1);


            WebElementUtil.waitForElementToBeVisible(locators.addressSuggestionOption, 10);
            WebElementUtil.clickElement(locators.addressSuggestionOption);

            // Fill phone
            WebElementUtil.scrollToElementStable(locators.shippingPhone);
            WebElementUtil.waitForElementToBeVisible(locators.shippingPhone, 10);
            WebElementUtil.sendKeys(locators.shippingPhone, phone);

            // Click continue button
            WebElementUtil.scrollToElementStable(locators.continueToDeliveryButton);
            WebElementUtil.waitForElementToBeClickable(locators.continueToDeliveryButton,10);
            WebElementUtil.clickElement(locators.continueToDeliveryButton);

            return true;
        } catch (Exception e) {
            System.err.println("Failed to fill shipping form and click Continue to delivery: " + e.getMessage());
            return false;
        }
    }

    /**
     * Single unified helper that returns true if any delivery date is enabled/available and clickable.
     * It will try radio inputs first, then label->input fallback. It clicks the first available slot and
     * verifies the slot becomes selected.
     */
    public boolean validateAllAvailableDeliveryDates() {
        WebElementUtil driver = null;
        WebDriverWait wait = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(10));

        try {
            // Wait for calendar section to be visible
            WebElementUtil.waitForElementToBeVisible(locators.deliveryCalendarHeader);

            // Get all available date labels
            List<WebElement> availableDates = WebElementUtil.findElements(locators.deliveryDateAvailable);

            if (availableDates.isEmpty()) {
                System.out.println("No available delivery dates found.");
                return false;
            }

            System.out.println("Found " + availableDates.size() + " available delivery dates.");

            // Iterate through each date
            for (int i = 0; i < availableDates.size(); i++) {

                WebElement date = availableDates.get(i);

                // Scroll the element into stable center view
                WebElementUtil.scrollToElementStable((By) date);

                // Wait for label to be clickable
                wait.until(ExpectedConditions.elementToBeClickable(date));

                String labelText = date.getText().trim();
                System.out.println("Clicking date: " + labelText);

                // Click date
                date.click();

                // Identify hidden input: label has "for=xxx"
                String inputId = date.getAttribute("for");

                // Validate checkbox/radio behind label
                if (inputId != null && !inputId.isEmpty()) {
                    By inputLocator = By.id(inputId);
                    WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(inputLocator));

                    // Wait until selected
                    wait.until(d -> input.isSelected() ||
                            Boolean.parseBoolean(input.getAttribute("checked")));

                    if (!input.isSelected()) {
                        System.out.println("Date not selected properly: " + labelText);
                        return false;
                    }

                } else {
                    // If input ID missing, fallback check on label
                    wait.until(d -> date.getAttribute("class").contains("selected") ||
                            "true".equals(date.getAttribute("aria-checked")));
                }

                System.out.println("✔ Successfully validated date: " + labelText);

                // Re-fetch available dates after each click because DOM refreshes
                availableDates = WebElementUtil.findElements(
                        By.cssSelector("label.cx-delivery-label.avaliableDates")
                );
            }

            return true;

        } catch (Exception e) {
            System.err.println("Failure while validating available delivery dates.");
            e.printStackTrace();
            return false;
        }
    }


}
