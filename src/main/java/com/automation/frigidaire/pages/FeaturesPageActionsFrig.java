package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.FeaturesLocatorsFrig;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.automation.utils.WebElementUtil.*;
import static com.automation.utils.WaitUtils.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FeaturesPageActionsFrig {
    FeaturesLocatorsFrig locators = new FeaturesLocatorsFrig();


    public void searchProduct(String productName) {
        waitForElementToBeClickable(locators.searchBox);
        sendKeys(locators.searchBox, productName + Keys.ENTER);
    }

    /**
     * Clicks the Add to cart button on the PDP. Waits for visibility and clickability first.
     * Returns true if click succeeded, false otherwise.
     */
    public void clickAddToCart() {
        waitForElementToBeVisible(locators.addToCartButton);
        scrollToElementStable(locators.addToCartButton);
        waitForElementToBeClickable(locators.addToCartButton);
        clickElement(locators.addToCartButton);
    }

    /**
     * Selects the Delivery & Installation option and then clicks Save and view cart.
     * Returns true on successful click of the Save and view cart button; false otherwise.
     */
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

    /**
     * Clicks the "Proceed to checkout" button in the cart/order summary area.
     * Returns true if the click succeeded, false otherwise.
     */
    public void clickProceedToCheckout() {
        waitForElementToBeVisible(locators.proceedToCheckoutButton);
        waitForElementToBeClickable(locators.proceedToCheckoutButton);
        clickElement(locators.proceedToCheckoutButton);
        waitForElementToBeVisible(locators.shippingAddressForm);
    }

    /**
     * Clicks the "Continue to delivery" button after shipping details are entered.
     * Returns true if the click succeeded, false otherwise.
     */
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

    public void selectProductFromPLP() {
        waitForElementToBeVisible(locators.productPDP);
        waitForElementToBeClickable(locators.productPDP);
        scrollIntoView(locators.productPDP);
        clickElement(locators.productPDP);
    }

    public boolean validateFeatureTitle(){
        waitForElementToBeVisible(locators.featureHeading);
        scrollToElementStable(locators.featureHeading);
        clickElement(locators.featureHeading);
        return isDisplayed(locators.featureHeading);
    }

    public boolean validateFeatureBanner() {
        scrollToElementStable(locators.featureHeading);
        clickElement(locators.featureHeading);
        scrollToElementStable(locators.viewAll);
        waitForElementToBeVisible(locators.viewAll);
        clickElement(locators.viewAll);
        waitForElementToBeVisible(locators.featureBanner);
        return isDisplayed(locators.featureBanner);
    }

    private By getSectionHeadingLocator(String featureText) {
        return By.xpath("//*[contains(text(),'"+featureText+"')]");
    }

    public void verifyFeatureNavigation() {
        int featureCount = findElements(locators.featureListItems).size();
        for (int i = 0; i < featureCount; i++) {
            By featureItemBy = By.xpath("(//div[contains(@class,'featureList')]//span[contains(@class,'cursor-pointer')])[" + (i + 1) + "]");
            String featureText = getExactText(featureItemBy);
            System.out.println("🔹 Clicking feature: " + featureText);
            scrollToElementStable(locators.featureHeading);
            waitForElementToBeClickable(featureItemBy);
            clickElement(featureItemBy);
            By sectionHeading = getSectionHeadingLocator(featureText);
            waitForElementToBeVisible(sectionHeading);
            if (!isDisplayed(sectionHeading)) {
                throw new AssertionError("Section for feature '" + featureText + "' is not visible or in viewport after navigation.");
            }
            scrollToElementStable(locators.featureHeading);
            System.out.println("Feature '" + featureText + "' navigated successfully.");
        }
    }

    public boolean validateFeatureDescription() {
        waitForElementToBeVisible(locators.featureDescription);
        String description = getText(locators.featureDescription);
        return description != null && !description.trim().isEmpty();
    }

    public boolean validateViewMoreButtonFunctionality() {
        scrollToElementStable(locators.viewMoreButton);
        waitForElementToBeVisible(locators.viewMoreButton);
        clickElement(locators.viewMoreButton);
        scrollToElementStable(locators.viewMoreFeatures);
        waitForElementToBeVisible(locators.viewMoreFeatures);
        clickElement(locators.viewMoreFeatures);
        return isDisplayed(locators.viewMoreFeatures);
    }

    public boolean validateGuideAndManualSection() {
        waitForElementToBeVisible(locators.ownerTitle);
        waitForElementToBeVisible(locators.ownerSection);
        scrollToElementStable(locators.ownerSection);
        return isDisplayed(locators.ownerSection);
    }

    /**
     * Returns a list of all available language names in the Guides & Manuals section.
     */
    private List<String> getAvailableLanguageNames() {
        List<WebElement> elements = findElements(locators.languageTabs);
        List<String> names = new ArrayList<>();
        for (WebElement el : elements) {
            String name = el.getText().trim();
            if (!name.isEmpty() && !names.contains(name)) names.add(name);
        }
        return names;
    }

    public boolean validateDownloadableDocumentsForAllLanguages() {
        boolean allValid = true;
        List<String> languages = getAvailableLanguageNames();
        System.out.println("Languages found: " + languages);

        for (String language : languages) {
            System.out.println("🔹 Validating documents for language: " + language);
            if (!validateDownloadableDocumentsForLanguage(language)) {
                System.err.println("Document validation failed for: " + language);
                allValid = false;
            } else {
                System.out.println("Document validation passed for: " + language);
            }
        }
        return allValid;
    }

    public boolean validateDownloadableDocumentsForLanguage(String language) {
        if (language == null || language.trim().isEmpty()) language = "English";

        By languageTab = By.xpath("//span[normalize-space(text())='" + language + "']");
        By parentBox = By.xpath("//span[normalize-space(text())='" + language + "']/ancestor::div[contains(@class,'spl-box')]");
        WebElement parent = waitForElementToBeVisible(parentBox);
        String tabClass = parent.getAttribute("class");

        // Click only if not active
        if (!tabClass.contains("active")) {
            clickElement(languageTab);
            waitForAttributeToContain(parentBox, "class", "active", 1000);
        }

        // Validate document links
        List<WebElement> docs = findElements(locators.documentLinks);

        if (docs.isEmpty()) {
            System.err.println("No documents found for language: " + language);
            return false;
        }

        for (WebElement doc : docs) {
            String docName = doc.getText().trim();
            String href = doc.getAttribute("href");

            if (!doc.isDisplayed() || !doc.isEnabled()) {
                System.err.println("Document not visible/enabled: " + docName + " (" + language + ")");
                return false;
            }
            if (href == null || !href.toLowerCase().contains(".pdf")) {
                System.err.println("Document not a PDF: " + docName + " (" + language + ") href=" + href);
                return false;
            }
        }
        return true;
    }

    public boolean validateDownloadableDocuments() {
        // Validate document links
        List<WebElement> docs = findElements(locators.singleLangDocuments);

        if (docs.isEmpty()) {
            System.err.println("No documents found: ");
            return false;
        }

        for (WebElement doc : docs) {
            String docName = doc.getText().trim();
            String href = doc.getAttribute("href");
            if (!doc.isDisplayed() || !doc.isEnabled()) {
                System.err.println("Document not visible/enabled: " + docName );
                return false;
            }
            if (href == null || !href.toLowerCase().contains(".pdf")) {
                System.err.println("Document not a PDF: " + docName + "href=" + href);
                return false;
            }
        }
        return true;
    }

    public boolean validateReplacementPartsTile() {
        waitForElementToBeVisible(locators.replacementPartsTile);
        scrollToElementStable(locators.replacementPartsTile);
        if (!isDisplayed(locators.replacementPartsTile)) {
            System.err.println("Replacement Parts tile is not visible.");
            return false;
        }
        if (!isDisplayed(locators.replacementPartsButton) || !waitForElementToBeClickable(locators.replacementPartsButton).isEnabled()) {
            System.err.println("Replacement Parts button is not clickable.");
            return false;
        }
        return true;
    }

    public boolean validateRepairsServiceTile() {
        waitForElementToBeVisible(locators.repairsServiceTile);
        scrollToElementStable(locators.repairsServiceTile);
        if (!isDisplayed(locators.repairsServiceTile)) {
            System.err.println("Repairs & Service tile is not visible.");
            return false;
        }
        if (!isDisplayed(locators.repairsServiceButton) || !waitForElementToBeClickable(locators.repairsServiceButton).isEnabled()) {
            System.err.println("Repairs & Service button is not clickable.");
            return false;
        }
        return true;
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
