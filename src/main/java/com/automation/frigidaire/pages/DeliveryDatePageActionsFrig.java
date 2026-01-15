package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.DeliveryDatesLocatorsFrig;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableCache;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DeliveryDatePageActionsFrig {
    static DeliveryDatesLocatorsFrig locators = new DeliveryDatesLocatorsFrig();

    public void searchProduct(String productName) {
        WebElementUtil.waitForElementToBeClickable(locators.searchBox, 20);
        WebElementUtil.sendKeys(locators.searchBox, productName + Keys.ENTER);
        WaitUtils.waitForPageLoad();
    }

    public void selectProductFromPLP() {
        WaitUtils.waitForPageLoad();
        WebElementUtil.waitForElementToBeVisible(locators.productPDP, 20);
        WebElementUtil.waitForElementToBeClickable(locators.productPDP, 10);
        WebElementUtil.scrollIntoView(locators.productPDP);
        WebElementUtil.clickElement(locators.productPDP);
    }

    public void clickAddToCart() {
        WebElementUtil.waitForElementToBeVisible(locators.addToCartButton, 20);
        WebElementUtil.scrollToElementStable(locators.addToCartButton);
        WebElementUtil.waitForElementToBeClickable(locators.addToCartButton, 10);
        WebElementUtil.clickElement(locators.addToCartButton);
    }

    public void clickSaveAndViewCart() {
        WebElementUtil.waitForElementToBeVisible(locators.saveAndViewCartButton, 20);
        WebElementUtil.scrollToElementStable(locators.saveAndViewCartButton);
        WebElementUtil.waitForElementToBeClickable(locators.saveAndViewCartButton, 20);
        WebElementUtil.clickElement(locators.saveAndViewCartButton);
    }

    public void selectDeliveryAndSaveAndViewCart() {
        // Select delivery & installation radio
        WebElementUtil.waitForElementToBeVisible(locators.deliveryInstallationRadio, 30);
        WebElementUtil.scrollToElementStable(locators.deliveryInstallationRadio);
        WebElementUtil.waitForElementToBeClickable(locators.deliveryInstallationRadio);
        WebElementUtil.clickElement(locators.deliveryInstallationRadio);

        // Click Save and view cart
        WebElementUtil.scrollToElementStable(locators.saveAndViewCartButton);
        WebElementUtil.waitForElementToBeClickable(locators.saveAndViewCartButton, 30);
        WebElementUtil.clickElement(locators.saveAndViewCartButton);
    }

    public void clickProceedToCheckout() {
        WebElementUtil.waitForElementToBeVisible(locators.proceedToCheckoutButton, 30);
        WebElementUtil.waitForElementToBeClickable(locators.proceedToCheckoutButton);
        WebElementUtil.clickElement(locators.proceedToCheckoutButton);
        WebElementUtil.waitForElementToBeVisible(locators.shippingAddressForm, 20);
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
        WebDriverWait wait = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(20));

        try {
            // Wait for calendar section to be visible
            WebElement ele = WebElementUtil.waitForElementToBeVisible(locators.deliveryCalendarHeader, 30);
            boolean isDisplay = ele.isDisplayed();

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

                // Wait for label to be clickable
                WebElementUtil.waitForElementToBeClickable(date);

                String labelText = date.getText().trim();
                System.out.println("Clicking date: " + labelText);

                // Click date
                date.click();


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


    public boolean validateCurrentDeliveryMonths() {
        java.time.LocalDate now = java.time.LocalDate.now();

        // Also month names only (no year) as a looser match
        String currentMonthName = now.format(java.time.format.DateTimeFormatter.ofPattern("MMMM", java.util.Locale.ENGLISH));

        String currentMonth = WebElementUtil.getText(locators.currentMonth);

        if (!currentMonth.contains(currentMonthName)) {
            System.out.println("Current month mismatch. Expected to contain: " + currentMonthName + ", but found: " + currentMonth);
            return false;
        }

        return true;
    }

    public boolean validateNextDeliveryMonths() {
        java.time.LocalDate now = java.time.LocalDate.now();

        String nextMonthName = now.plusMonths(1).format(java.time.format.DateTimeFormatter.ofPattern("MMMM", java.util.Locale.ENGLISH));
        String nextMonth = WebElementUtil.getText(locators.nextMonth);

        if (!nextMonth.contains(nextMonthName)) {
            System.out.println("Next month mismatch. Expected to contain: " + nextMonthName + ", but found: " + nextMonth);
            return false;
        }

        return true;
    }

    public boolean validateUnavailableDatesAreGreyedAndNotSelectable() {

        List<WebElement> disabledLabels =
                WebElementUtil.findElements(
                        By.cssSelector("label.cx-delivery-label.disabled"));

        if (disabledLabels.isEmpty()) {
            throw new AssertionError("No unavailable (disabled) delivery dates found!");
        }

        JavascriptExecutor js =
                (JavascriptExecutor) DriverManager.getDriver();

        for (WebElement label : disabledLabels) {

            // Label must be displayed
            if (!label.isDisplayed()) {
                return false;
            }

            // Must have disabled class
            String classes = label.getAttribute("class");
            if (!classes.contains("disabled")) {
                return false;
            }

            // Must not be clickable (pointer-events: none)
            String pointerEvents =
                    (String) js.executeScript(
                            "return window.getComputedStyle(arguments[0]).pointerEvents;",
                            label);

            if (!"none".equals(pointerEvents)) {
                return false;
            }

            // Associated input must NOT be selected
            String forAttr = label.getAttribute("for");
            if (forAttr != null && !forAttr.isEmpty()) {
                WebElement input =
                        DriverManager.getDriver().findElement(By.id(forAttr));

                if (input.isSelected() || input.isEnabled()) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean validateContinueToBillingEnabledOnDateSelection() {
        try {
            // Wait for at least one selectable delivery date
            List<WebElement> availableDates = WebElementUtil.waitForElementsToBeVisible(locators.availableDates);

            if (availableDates.isEmpty()) {
                throw new RuntimeException("No selectable delivery dates found.");
            }

            // Pick the first available date
            WebElement dateToSelect = availableDates.get(0);

            // Scroll + ensure clickable
            WebElementUtil.scrollToElementStable(dateToSelect);
            WebElementUtil.waitForElementToBeVisible(dateToSelect);

            WebElementUtil.waitForElementToBeClickable(dateToSelect);
            dateToSelect.click();

            // Final verification
            WebElement continueButton = WebElementUtil.findElement(locators.continueToBillingButton);

            return continueButton.isDisplayed() && continueButton.isEnabled();

        } catch (TimeoutException e) {
            System.err.println("Continue to billing button did not become enabled.");
            return false;
        }
    }

    public boolean validateDeliveryCommentsBelowCalendar() {

        try {
            // Wait for delivery calendar container
            WebElement calendar = WebElementUtil.waitForElementToBeVisible(locators.calender);

            // Wait for Delivery Comments textarea
            WebElement commentsTextarea =
                    WebElementUtil.waitForElementToBeVisible(locators.deliveryComments);

            // Basic visibility & enabled validation
            if (!commentsTextarea.isDisplayed() || !commentsTextarea.isEnabled()) {
                return false;
            }

            // Validate placeholder text
            String placeholder = commentsTextarea.getAttribute("placeholder");
            if (!"Enter special instructions for our delivery team.".equals(placeholder)) {
                return false;
            }

            // Validate textarea is located BELOW calendar
            int calendarBottomY =
                    calendar.getLocation().getY() + calendar.getSize().getHeight();

            int textareaTopY =
                    commentsTextarea.getLocation().getY();

            return textareaTopY > calendarBottomY;

        } catch (TimeoutException e) {
            System.err.println("Delivery Comments textarea not found or not visible.");
            return false;
        }
    }


    public boolean validateOnlyOneCalendarDateSelection() {
        try {
            // Wait for selectable date labels (enabled dates)
            List<WebElement> dateLabels =
                    WebElementUtil.findElements(locators.selectableDates);

            if (dateLabels.size() < 2) {
                throw new RuntimeException("Less than 2 selectable delivery dates available");
            }

            // Click first selectable date
            WebElement firstDate = dateLabels.get(0);
            WebElementUtil.scrollToElementStable(firstDate);
            firstDate.click();

            // Validate exactly ONE radio is selected
            List<WebElement> radiosAfterFirstClick =
                    WebElementUtil.findElements(locators.calDates);

            int selectedCount = 0;
            for (WebElement radio : radiosAfterFirstClick) {
                if (radio.isSelected()) {
                    selectedCount++;
                }
            }

            if (selectedCount != 1) {
                return false;
            }

            // Click second selectable date
            WebElement secondDate = dateLabels.get(1);
            WebElementUtil.scrollToElementStable(secondDate);
            secondDate.click();

            // Validate again exactly ONE radio is selected
            List<WebElement> radiosAfterSecondClick =
                    WebElementUtil.findElements(locators.calDates);

            selectedCount = 0;
            for (WebElement radio : radiosAfterSecondClick) {
                if (radio.isSelected()) {
                    selectedCount++;
                }
            }

            return selectedCount == 1;

        } catch (Exception e) {
            System.err.println("Failed to validate single calendar date selection");
            e.printStackTrace();
            return false;
        }
    }


    public boolean isEachLineItemDisplayedInItsOwnTile() {

        // Headings (Home delivery, Parcel items)
        List<WebElement> headings = WebElementUtil.findElements(locators.orderItemHeadings);

        if (headings.isEmpty()) {
            return false;
        }

        // Validate first group
        List<WebElement> firstGroupTitles = WebElementUtil.findElements(locators.homeDeliveryTitles);
        if (firstGroupTitles.isEmpty()) {
            return false;
        }

        for (WebElement title : firstGroupTitles) {
            if (!title.isDisplayed()) {
                return false;
            }
        }

        // Validate remaining groups (only if they exist)
        if (headings.size() > 1) {
            List<WebElement> nextGroupTitles = WebElementUtil.findElements(locators.parcelDeliveryTitles);

            if (nextGroupTitles.isEmpty()) {
                return false;
            }

            for (WebElement title : nextGroupTitles) {
                if (!title.isDisplayed()) {
                    return false;
                }
            }
        }

        return true;
    }


    public boolean areParcelItemPricesDisplayed() {

        List<WebElement> prices = WebElementUtil.findElements(locators.parcelItemPrices);

        // If parcel items exist, prices must exist
        if (prices.isEmpty()) {
            return false;
        }

        for (WebElement price : prices) {

            // Price must be visible
            if (!price.isDisplayed()) {
                return false;
            }

            // Price must not be empty
            String priceText = price.getText();
            if (priceText == null || priceText.trim().isEmpty()) {
                return false;
            }
        }

        return true;
    }


    public boolean areParcelItemImagesDisplayed() {

        List<WebElement> images = WebElementUtil.findElements(locators.parcelItemImages);

        // If parcel items exist, images must exist
        if (images.isEmpty()) {
            return false;
        }

        for (WebElement image : images) {

            // Image must be visible
            if (!image.isDisplayed()) {
                return false;
            }

            // Optional: ensure image source is present
            String src = image.getAttribute("src");
            if (src == null || src.trim().isEmpty()) {
                return false;
            }
        }

        return true;
    }


    public boolean areParcelItemSKUsDisplayed() {

        List<WebElement> skuElements = WebElementUtil.findElements(locators.parcelSKU);

        // If parcel items exist, SKU must exist
        if (skuElements.isEmpty()) {
            return false;
        }

        for (WebElement sku : skuElements) {

            // SKU must be visible
            if (!sku.isDisplayed()) {
                return false;
            }

            // SKU text must not be empty
            String skuText = sku.getText();
            if (skuText == null || skuText.trim().isEmpty()) {
                return false;
            }
        }

        return true;
    }


    public boolean areParcelItemColorsDisplayed() {

        List<WebElement> colorElements = WebElementUtil.findElements(locators.parcelItemsColor);

        // If parcel items exist, color must exist
        if (colorElements.isEmpty()) {
            return false;
        }

        for (WebElement color : colorElements) {

            // Color must be visible
            if (!color.isDisplayed()) {
                return false;
            }

            // Color text must not be empty
            String colorText = color.getText();
            if (colorText == null || colorText.trim().isEmpty()) {
                return false;
            }
        }

        return true;
    }


    public boolean areParcelItemQuantitiesDisplayed() {

        List<WebElement> qtyElements = WebElementUtil.findElements(locators.parcelItemsQty);

        // If parcel items exist, quantity must exist
        if (qtyElements.isEmpty()) {
            return false;
        }

        for (WebElement qty : qtyElements) {

            // Quantity must be visible
            if (!qty.isDisplayed()) {
                return false;
            }

            // Quantity text must not be empty
            String qtyText = qty.getText();
            if (qtyText == null || qtyText.trim().isEmpty()) {
                return false;
            }

        }

        return true;
    }


    public boolean isAirConditionerShippingMessageDisplayed() {

        WebElement messageElement = WebElementUtil.findElement(locators.checkoutMessage);

        if (!messageElement.isDisplayed()) {
            return false;
        }

        // Get the FULL visible text (browser concatenates it)
        String actualText = messageElement.getText().replaceAll("\\s+", " ").trim();

        String expectedText =
                "Air Conditioners ordered by 1 pm local will ship the same business day, otherwise ships next business day " +
                        "View the Shipping & Return Policy for details.";

        expectedText = expectedText.replaceAll("\\s+", " ").trim();

        return actualText.contains(expectedText);
    }
    
    public DeliveryDatePageActionsFrig selectFirstAvailableDeliveryDate() {
    	WebElementUtil.scrollIntoView(locators.firstAvailableDeliveryDate);
    	WebElementUtil.clickElement(locators.firstAvailableDeliveryDate);
    	return this;
    }
    
    public ReviewAndPayPageActionsFrig clickContinueToBillingButton() {
    	WebElementUtil.scrollIntoView(locators.continueToBillingButton);
    	WebElementUtil.clickElement(locators.continueToBillingButton);
    	return new ReviewAndPayPageActionsFrig();
    }

}
