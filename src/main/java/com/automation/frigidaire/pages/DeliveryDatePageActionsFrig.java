package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.DeliveryDatesLocatorsFrig;
import static com.automation.utils.WebElementUtil.*;
import static com.automation.utils.WaitUtils.*;

import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DeliveryDatePageActionsFrig {
    DeliveryDatesLocatorsFrig locators = new DeliveryDatesLocatorsFrig();

    public void searchProduct(String productName) {
        waitForElementToBeClickable(locators.searchBox);
        sendKeys(locators.searchBox, productName + Keys.ENTER);
    }

    public void selectProductFromPLP() {
        waitForElementToBeVisible(locators.productPDP);
        waitForElementToBeClickable(locators.productPDP);
        scrollIntoView(locators.productPDP);
        clickElement(locators.productPDP);
    }

    public void clickAddToCart() {
        waitForElementToBeVisible(locators.addToCartButton);
        scrollToElementStable(locators.addToCartButton);
        waitForElementToBeClickable(locators.addToCartButton);
        clickElement(locators.addToCartButton);
    }
    public void selectDeliveryAndSaveAndViewCart() {
        // Select delivery & installation radio
        waitForElementToBeVisible(locators.deliveryInstallationRadio);
        scrollToElementStable(locators.deliveryInstallationRadio);
        waitForElementToBeClickable(locators.deliveryInstallationRadio);
        clickElement(locators.deliveryInstallationRadio);

        // Click Save and view cart
        scrollToElementStable(locators.saveAndViewCartButton);
        waitForElementToBeClickable(locators.saveAndViewCartButton);
        clickElement(locators.saveAndViewCartButton);
    }

    public void clickProceedToCheckout() {
        waitForElementToBeVisible(locators.proceedToCheckoutButton);
        waitForElementToBeClickable(locators.proceedToCheckoutButton);
        clickElement(locators.proceedToCheckoutButton);
        waitForElementToBeVisible(locators.shippingAddressForm);
    }

//     * Clicks the "Continue to delivery" button after shipping details are entered.
//            * Returns true if the click succeeded, false otherwise.
//     */
    public void clickContinueToDelivery() {

        clickContinueToDelivery(
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
            scrollToElementStable(locators.shippingEmail);
            waitForElementToBeVisible(locators.shippingEmail);
            sendKeys(locators.shippingEmail, email);

            // Fill first name and last name
            scrollToElementStable(locators.shippingFirstName);
            waitForElementToBeVisible(locators.shippingFirstName);
            sendKeys(locators.shippingFirstName, firstName);

            waitForElementToBeVisible(locators.shippingLastName);
            sendKeys(locators.shippingLastName, lastName);

            // Fill address line
            scrollToElementStable(locators.shippingAddressLine1);
            waitForElementToBeVisible(locators.shippingAddressLine1);
            sendKeys(locators.shippingAddressLine1, addressLine1);


            waitForElementToBeVisible(locators.addressSuggestionOption);
            clickElement(locators.addressSuggestionOption);

            // Fill phone
            scrollToElementStable(locators.shippingPhone);
            waitForElementToBeVisible(locators.shippingPhone);
            sendKeys(locators.shippingPhone, phone);

            // Click continue button
            scrollToElementStable(locators.continueToDeliveryButton);
            waitForElementToBeClickable(locators.continueToDeliveryButton);
            clickElement(locators.continueToDeliveryButton);

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
            waitForElementToBeVisible(locators.deliveryCalendarHeader);

            // Get all available date labels
            List<WebElement> availableDates = findElements(locators.deliveryDateAvailable);

            if (availableDates.isEmpty()) {
                System.out.println("No available delivery dates found.");
                return false;
            }

            System.out.println("Found " + availableDates.size() + " available delivery dates.");

            // Iterate through each date
            for (int i = 0; i < availableDates.size(); i++) {

                WebElement date = availableDates.get(i);

                // Scroll the element into stable center view
                scrollToElementStable((By) date);

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
                availableDates = findElements(
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
