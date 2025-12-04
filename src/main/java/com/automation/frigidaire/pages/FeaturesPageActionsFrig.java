package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.FeaturesLocatorsFrig;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FeaturesPageActionsFrig {
    FeaturesLocatorsFrig locators = new FeaturesLocatorsFrig();


    public void searchProduct(String productName) {
        WebElementUtil.waitForElementToBeClickable(locators.searchBox, 20);
        WebElementUtil.sendKeys(locators.searchBox, productName + Keys.ENTER);
    }

    /**
     * Clicks the Add to cart button on the PDP. Waits for visibility and clickability first.
     * Returns true if click succeeded, false otherwise.
     */
    public void clickAddToCart() {
        WebElementUtil.waitForElementToBeVisible(locators.addToCartButton, 10);
        WebElementUtil.scrollToElementStable(locators.addToCartButton);
        WebElementUtil.waitForElementToBeClickable(locators.addToCartButton, 10);
        WebElementUtil.clickElement(locators.addToCartButton);
    }

    /**
     * Selects the Delivery & Installation option and then clicks Save and view cart.
     * Returns true on successful click of the Save and view cart button; false otherwise.
     */
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

    /**
     * Clicks the "Proceed to checkout" button in the cart/order summary area.
     * Returns true if the click succeeded, false otherwise.
     */
    public void clickProceedToCheckout() {
        WebElementUtil.waitForElementToBeVisible(locators.proceedToCheckoutButton, 20);
        WebElementUtil.waitForElementToBeClickable(locators.proceedToCheckoutButton);
        WebElementUtil.clickElement(locators.proceedToCheckoutButton);
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
            WebElementUtil.scrollToElementStable(locators.shippingEmail);
            WebElementUtil.waitForElementToBeVisible(locators.shippingEmail);
            WebElementUtil.sendKeys(locators.shippingEmail, email);

            // Fill first name and last name
            WebElementUtil.scrollToElementStable(locators.shippingFirstName);
            WebElementUtil.waitForElementToBeVisible(locators.shippingFirstName);
            WebElementUtil.sendKeys(locators.shippingFirstName, firstName);

            WebElementUtil.waitForElementToBeVisible(locators.shippingLastName);
            WebElementUtil.sendKeys(locators.shippingLastName, lastName);

            // Fill address line
            WebElementUtil.scrollToElementStable(locators.shippingAddressLine1);
            WebElementUtil.waitForElementToBeVisible(locators.shippingAddressLine1);
            WebElementUtil.sendKeys(locators.shippingAddressLine1, addressLine1);


            WebElementUtil.waitForElementToBeVisible(locators.addressSuggestionOption);
            WebElementUtil.clickElement(locators.addressSuggestionOption);

            // Fill phone
            WebElementUtil.scrollToElementStable(locators.shippingPhone);
            WebElementUtil.waitForElementToBeVisible(locators.shippingPhone);
            WebElementUtil.sendKeys(locators.shippingPhone, phone);

            // Click continue button
            WebElementUtil.scrollToElementStable(locators.continueToDeliveryButton);
            WebElementUtil.waitForElementToBeClickable(locators.continueToDeliveryButton);
            WebElementUtil.clickElement(locators.continueToDeliveryButton);

            return true;
        } catch (Exception e) {
            System.err.println("Failed to fill shipping form and click Continue to delivery: " + e.getMessage());
            return false;
        }
    }

    public void selectProductFromPLP() {
        WebElementUtil.waitForElementToBeVisible(locators.productPDP, 10);
        WebElementUtil.waitForElementToBeClickable(locators.productPDP, 10);
        WebElementUtil.scrollIntoView(locators.productPDP);
        WebElementUtil.clickElement(locators.productPDP);
    }

    public boolean validateFeatureTitle(){
        WebElementUtil.scrollToElementStable(locators.featureHeading);
        WebElementUtil.waitForElementToBeVisible(locators.featureHeading);
        WebElementUtil.clickElement(locators.featureHeading);
        return WebElementUtil.isDisplayed(locators.featureHeading);
    }

    public boolean validateFeatureBanner() {
        WebElementUtil.scrollToElementStable(locators.featureHeading);
        WebElementUtil.clickElement(locators.featureHeading);
        WebElementUtil.scrollToElementStable(locators.viewAll);
        WebElementUtil.waitForElementToBeVisible(locators.viewAll);
        WebElementUtil.clickElement(locators.viewAll);
        WebElementUtil.waitForElementToBeVisible(locators.featureBanner);
        return WebElementUtil.isDisplayed(locators.featureBanner);
    }

    private By getSectionHeadingLocator(String featureText) {
        return By.xpath("//*[contains(text(),'"+featureText+"')]");
    }

    public void verifyFeatureNavigation() {
        int featureCount = WebElementUtil.findElements(locators.featureListItems).size();
        for (int i = 0; i < featureCount; i++) {
            By featureItemBy = By.xpath("(//div[contains(@class,'featureList')]//span[contains(@class,'cursor-pointer')])[" + (i + 1) + "]");
            String featureText = WebElementUtil.getExactText(featureItemBy);
            System.out.println("🔹 Clicking feature: " + featureText);
            WebElementUtil.scrollToElementStable(locators.featureHeading);
            WebElementUtil.waitForElementToBeClickable(featureItemBy);
            WebElementUtil.clickElement(featureItemBy);
            By sectionHeading = getSectionHeadingLocator(featureText);
            WebElementUtil.waitForElementToBeVisible(sectionHeading);
            if (!WebElementUtil.isDisplayed(sectionHeading)) {
                throw new AssertionError("Section for feature '" + featureText + "' is not visible or in viewport after navigation.");
            }
            WebElementUtil.scrollToElementStable(locators.featureHeading);
            System.out.println("Feature '" + featureText + "' navigated successfully.");
        }
    }

    public boolean validateFeatureDescription() {
        WebElementUtil.waitForElementToBeVisible(locators.featureDescription);
        String description = WebElementUtil.getText(locators.featureDescription);
        return description != null && !description.trim().isEmpty();
    }

    public boolean validateViewMoreButtonFunctionality() {
        WebElementUtil.scrollToElementStable(locators.viewMoreButton);
        WebElementUtil.waitForElementToBeVisible(locators.viewMoreButton);
        WebElementUtil.clickElement(locators.viewMoreButton);
        WebElementUtil.scrollToElementStable(locators.viewMoreFeatures);
        WebElementUtil.waitForElementToBeVisible(locators.viewMoreFeatures);
        WebElementUtil.clickElement(locators.viewMoreFeatures);
        return WebElementUtil.isDisplayed(locators.viewMoreFeatures);
    }

    public boolean validateGuideAndManualSection() {
        WebElementUtil.waitForElementToBeVisible(locators.ownerTitle);
        WebElementUtil.waitForElementToBeVisible(locators.ownerSection);
        WebElementUtil.scrollToElementStable(locators.ownerSection);
        return WebElementUtil.isDisplayed(locators.ownerSection);
    }

    /**
     * Returns a list of all available language names in the Guides & Manuals section.
     */
    private List<String> getAvailableLanguageNames() {
        List<WebElement> elements = WebElementUtil.findElements(locators.languageTabs);
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
        WebElement parent = WebElementUtil.waitForElementToBeVisible(parentBox);
        String tabClass = parent.getAttribute("class");

        // Click only if not active
        if (!tabClass.contains("active")) {
            WebElementUtil.clickElement(languageTab);
            WebElementUtil.waitForAttributeToContain(parentBox, "class", "active", 1000);
        }

        // Validate document links
        List<WebElement> docs = WebElementUtil.findElements(locators.documentLinks);

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
        List<WebElement> docs = WebElementUtil.findElements(locators.singleLangDocuments);

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
        WebElementUtil.scrollToElementStable(locators.replacementPartsTile);
        if (!WebElementUtil.isDisplayed(locators.replacementPartsTile)) {
            System.err.println("Replacement Parts tile is not visible.");
            return false;
        }
        if (!WebElementUtil.isDisplayed(locators.replacementPartsButton) || !WebElementUtil.waitForElementToBeClickable(locators.replacementPartsButton).isEnabled()) {
            System.err.println("Replacement Parts button is not clickable.");
            return false;
        }
        return true;
    }

    public boolean validateRepairsServiceTile() {
        WebElementUtil.scrollToElementStable(locators.repairsServiceTile);
        if (!WebElementUtil.isDisplayed(locators.repairsServiceTile)) {
            System.err.println("Repairs & Service tile is not visible.");
            return false;
        }
        if (!WebElementUtil.isDisplayed(locators.repairsServiceButton) || !WebElementUtil.waitForElementToBeClickable(locators.repairsServiceButton).isEnabled()) {
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
