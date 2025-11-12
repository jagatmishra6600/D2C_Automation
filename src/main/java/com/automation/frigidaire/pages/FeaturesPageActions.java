package com.automation.frigidaire.pages;

import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FeaturesPageActions {

    private final By searchButton = By.cssSelector(".searchClose");
    private final By productPDP = By.xpath("//div[contains(@class,'Appliance-Card')] | //div[contains(@class,'accessories-product')]");
    private final By featureHeading = By.xpath("//strong[text()='Overview & Features']//parent::h4//parent::span");
    private final By viewAll = By.xpath("//p[text()='View all']");
    private final By featureBanner = By.cssSelector(".featureBanner");
    private final By viewMoreButton = By.xpath("//button[contains(text(),' View more')]");
    private final By searchBox = By.xpath("//input[@aria-label=\"search\"]");
    private final By viewMoreFeatures = By.cssSelector(".viewMoreFeatures");
    private final By featureListItems = By.cssSelector(".featureList .cursor-pointer");
    private final By featureDescription = By.cssSelector(".pdp_description");

    private final By ownerSection = By.cssSelector(".owners-section");
    private final By ownerTitle = By.xpath("//h3[text()='Guides & Manuals']");
    private final By languageTabs = By.xpath("//span[contains(@class,'Body-MediumBody_Medium_Centered')]");
    private final By documentLinks = By.xpath("//div[contains(@class,'Body-MediumBody_Medium-Link')]//a");
    private final By singleLangDocuments = By.xpath("//div[contains(@class,'Card-Title')]//a");

    // Locators for Service & Parts section
    private final By replacementPartsTile = By.xpath("//h4[text()='Replacement Parts']");
    private final By replacementPartsButton = By.xpath("//h4[text()='Replacement Parts']//parent::p//parent::cx-paragraph//following-sibling::cx-link//a");
    private final By repairsServiceTile = By.xpath("//h4[text()='Repairs & Service']");
    private final By repairsServiceButton = By.xpath("//h4[text()='Repairs & Service']//parent::p//parent::cx-paragraph//following-sibling::cx-link//a");

    // Locator for Add to cart button (handles <a> or <button> with inner span text)
    private final By addToCartButton = By.xpath("//span[normalize-space()='Add to cart']/ancestor::a | //button[normalize-space()='Add to cart']");

    // Locators for Delivery & Installation and Save & view cart
    private final By deliveryInstallationRadio = By.id("Refrigerators_Large_WaterLine_Install");
    private final By saveAndViewCartButton = By.xpath("//button[normalize-space()='Save and view cart']");
    // Locator for Proceed to checkout button on the Cart/Order Summary
    private final By proceedToCheckoutButton = By.xpath("//button[normalize-space()='Proceed to checkout']");
    // Locator for Continue to delivery button on the shipping/address step
    private final By continueToDeliveryButton = By.id("continueToDeliveryButton");

    // Shipping address fields (used on checkout shipping step)
    private final By shippingEmail = By.id("email");
    private final By shippingFirstName = By.id("firstName");
    private final By shippingLastName = By.id("lastName");
    private final By shippingAddressLine1 = By.xpath("//input[@formcontrolname='line1' or @id='address-1' or contains(@placeholder,'Address')]");
    private final By shippingPhone = By.id("phone");
    private final By addressSuggestionOption = By.xpath("//ngb-typeahead-window//button[@role='option'] | //div[contains(@class,'dropdown-menu')]//button[@role='option']");

    // Delivery date selection elements
    private final By deliveryCalendarHeader = By.xpath("//h2[contains(text(),'Delivery date')]");
    private final By deliveryAvailableInputs = By.xpath("//input[@type='radio' and @formcontrolname='selectedSlot' and not(@disabled)]");
    private final By deliveryAvailableLabels = By.xpath("//label[contains(@class,'cx-delivery-label') and not(contains(@class,'disabled'))]");

    // --- Login locators (added) ---
    private final By loginLink = By.xpath("//a[text()='Log in / Order status ']");
    private final By loginBtn = By.xpath("//button[text()='Log in']");
    private final By loginEmailInput = By.xpath("//input[@aria-label='Email address']");
    private final By loginPasswordInput = By.xpath("//*[@id=\"gigya-login-form\"]/div[2]/div[3]/div[2]/div/input");
    private final By loginButton = By.xpath("//button[normalize-space()='Log in'] | //input[@type='submit' and (translate(@value,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz')='log in' or contains(translate(@value,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'log in'))] | //button[@type='submit' and contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'log in')]");


    public void searchProduct(String productName) {
        WebElementUtil.waitForElementToBeVisible(searchBox);
        WebElementUtil.sendKeys(searchBox, productName + Keys.ENTER);
    }

    /**
     * Clicks the Add to cart button on the PDP. Waits for visibility and clickability first.
     * Returns true if click succeeded, false otherwise.
     */
    public void clickAddToCart() {
        // Ensure the button is in viewport first (covers sticky headers/overlays)
        WebElementUtil.scrollIntoView(addToCartButton, 200);
        WebElementUtil.waitForElementToBeVisible(addToCartButton);
        WebElementUtil.waitForElementToBeClickable(addToCartButton);
        WebElementUtil.clickElement(addToCartButton);
    }

    /**
     * Selects the Delivery & Installation option and then clicks Save and view cart.
     * Returns true on successful click of the Save and view cart button; false otherwise.
     */
    public void selectDeliveryAndSaveAndViewCart() {
        // Select delivery & installation radio
        WebElementUtil.scrollIntoView(deliveryInstallationRadio, 200);
        WebElementUtil.waitForElementToBeClickable(deliveryInstallationRadio);
        WebElementUtil.clickElement(deliveryInstallationRadio);

        // Click Save and view cart
        WebElementUtil.scrollIntoView(saveAndViewCartButton, 200);
        WebElementUtil.waitForElementToBeClickable(saveAndViewCartButton, 20);
        WebElementUtil.clickElement(saveAndViewCartButton);
    }

    /**
     * Clicks the "Proceed to checkout" button in the cart/order summary area.
     * Returns true if the click succeeded, false otherwise.
     */
    public void clickProceedToCheckout() {
        WebElementUtil.waitForElementToBeVisible(proceedToCheckoutButton, 20);
        WebElementUtil.waitForElementToBeClickable(proceedToCheckoutButton);
        WebElementUtil.clickElement(proceedToCheckoutButton);
    }

    /**
     * Clicks the "Continue to delivery" button after shipping details are entered.
     * Returns true if the click succeeded, false otherwise.
     */
    public boolean clickContinueToDelivery() {
        // default test data (can be overridden by the overloaded method below)
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
            WebElementUtil.scrollIntoView(shippingEmail, 200);
            WebElementUtil.waitForElementToBeVisible(shippingEmail);
            WebElementUtil.sendKeys(shippingEmail, email);

            // Fill first name and last name
            WebElementUtil.scrollIntoView(shippingFirstName, 200);
            WebElementUtil.waitForElementToBeVisible(shippingFirstName);
            WebElementUtil.sendKeys(shippingFirstName, firstName);

            WebElementUtil.waitForElementToBeVisible(shippingLastName);
            WebElementUtil.sendKeys(shippingLastName, lastName);

            // Fill address line (autocomplete fields sometimes require typing then selecting; we type then select suggestion if present)
            WebElementUtil.scrollIntoView(shippingAddressLine1, 200);
            WebElementUtil.waitForElementToBeVisible(shippingAddressLine1);
            WebElementUtil.sendKeys(shippingAddressLine1, addressLine1);


            WebElementUtil.waitForElementToBeVisible(addressSuggestionOption);
            WebElementUtil.clickElement(addressSuggestionOption);

            // Fill phone
            WebElementUtil.scrollIntoView(shippingPhone, 200);
            WebElementUtil.waitForElementToBeVisible(shippingPhone);
            WebElementUtil.sendKeys(shippingPhone, phone);

            // Click continue button
            WebElementUtil.scrollIntoView(continueToDeliveryButton, 200);
            WebElementUtil.waitForElementToBeClickable(continueToDeliveryButton);
            WebElementUtil.clickElement(continueToDeliveryButton);

            return true;
        } catch (Exception e) {
            System.err.println("Failed to fill shipping form and click Continue to delivery: " + e.getMessage());
            return false;
        }
    }

    public void selectProductFromPLP() {
        WebElementUtil.waitForElementToBeVisible(productPDP);
        WebElementUtil.clickElement(productPDP);
    }

    public boolean validateFeatureTitle(){
        WebElementUtil.scrollIntoView(featureHeading, 200);
        WebElementUtil.waitForElementToBeVisible(featureHeading);
        WebElementUtil.clickElement(featureHeading);
        return WebElementUtil.isDisplayed(featureHeading);
    }

    public boolean validateFeatureBanner() {
        WebElementUtil.scrollIntoView(featureHeading, 200);
        WebElementUtil.clickElement(featureHeading);
        WebElementUtil.scrollIntoView(viewAll, 200);
        WebElementUtil.waitForElementToBeVisible(viewAll);
        WebElementUtil.clickElement(viewAll);
        WebElementUtil.waitForElementToBeVisible(featureBanner);
        return WebElementUtil.isDisplayed(featureBanner);
    }

    private By getSectionHeadingLocator(String featureText) {
        return By.xpath("//*[contains(text(),'"+featureText+"')]");
    }

    public void verifyFeatureNavigation() {
        int featureCount = WebElementUtil.findElements(featureListItems).size();
        for (int i = 0; i < featureCount; i++) {
            By featureItemBy = By.xpath("(//div[contains(@class,'featureList')]//span[contains(@class,'cursor-pointer')])[" + (i + 1) + "]");
            String featureText = WebElementUtil.getExactText(featureItemBy);
            System.out.println("🔹 Clicking feature: " + featureText);
            WebElementUtil.scrollIntoView(featureItemBy, 200);
            WebElementUtil.waitForElementToBeClickable(featureItemBy);
            WebElementUtil.clickElement(featureItemBy);
            By sectionHeading = getSectionHeadingLocator(featureText);
            WebElementUtil.waitForElementToBeVisible(sectionHeading);
            if (!WebElementUtil.isDisplayed(sectionHeading)) {
                throw new AssertionError("Section for feature '" + featureText + "' is not visible or in viewport after navigation.");
            }
            WebElementUtil.scrollIntoView(featureHeading, 200);
            System.out.println("Feature '" + featureText + "' navigated successfully.");
        }
    }

    public boolean validateFeatureDescription() {
        WebElementUtil.waitForElementToBeVisible(featureDescription);
        String description = WebElementUtil.getText(featureDescription);
        return description != null && !description.trim().isEmpty();
    }

    public boolean validateViewMoreButtonFunctionality() {
        WebElementUtil.scrollIntoView(viewMoreButton, 200);
        WebElementUtil.waitForElementToBeVisible(viewMoreButton);
        WebElementUtil.clickElement(viewMoreButton);
        WebElementUtil.scrollIntoView(viewMoreFeatures, 200);
        WebElementUtil.waitForElementToBeVisible(viewMoreFeatures);
        WebElementUtil.clickElement(viewMoreFeatures);
        return WebElementUtil.isDisplayed(viewMoreFeatures);
    }

    public boolean validateGuideAndManualSection() {
        WebElementUtil.waitForElementToBeVisible(ownerTitle);
        WebElementUtil.waitForElementToBeVisible(ownerSection);
        WebElementUtil.scrollIntoView(ownerSection, 200);
        return WebElementUtil.isDisplayed(ownerSection);
    }

    /**
     * Returns a list of all available language names in the Guides & Manuals section.
     */
    private List<String> getAvailableLanguageNames() {
        List<WebElement> elements = WebElementUtil.findElements(languageTabs);
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
        List<WebElement> docs = WebElementUtil.findElements(documentLinks);

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
        List<WebElement> docs = WebElementUtil.findElements(singleLangDocuments);

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
        WebElementUtil.scrollIntoView(replacementPartsTile, 200);
        if (!WebElementUtil.isDisplayed(replacementPartsTile)) {
            System.err.println("Replacement Parts tile is not visible.");
            return false;
        }
        if (!WebElementUtil.isDisplayed(replacementPartsButton) || !WebElementUtil.waitForElementToBeClickable(replacementPartsButton).isEnabled()) {
            System.err.println("Replacement Parts button is not clickable.");
            return false;
        }
        return true;
    }

    public boolean validateRepairsServiceTile() {
        WebElementUtil.scrollIntoView(repairsServiceTile, 200);
        if (!WebElementUtil.isDisplayed(repairsServiceTile)) {
            System.err.println("Repairs & Service tile is not visible.");
            return false;
        }
        if (!WebElementUtil.isDisplayed(repairsServiceButton) || !WebElementUtil.waitForElementToBeClickable(repairsServiceButton).isEnabled()) {
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
    public boolean validateDeliveryDateEnabledAndClickable() {
        // Best-effort wait for delivery calendar to appear
        try {
            WebElementUtil.waitForElementToBeVisible(deliveryCalendarHeader);
        } catch (Exception ignored) {
            // continue if header isn't present
        }

        int attempts = 0;
        while (attempts < 3) {
            try {
                // Try radio inputs first
                List<WebElement> inputs = WebElementUtil.findElements(deliveryAvailableInputs);
                if (!inputs.isEmpty()) {
                    WebElement first = inputs.get(0);
                    String id = first.getAttribute("id");
                    if (id != null && !id.trim().isEmpty()) {
                        By inputBy = By.id(id);
                        WebElementUtil.scrollIntoView(inputBy, 200);
                        WebElementUtil.waitForElementToBeClickable(inputBy);
                        WebElementUtil.clickElement(inputBy);
                        WebElement clicked = WebElementUtil.waitForElementToBeClickable(inputBy);
                        return clicked.isSelected();
                    }
                }

                // Fallback: try label elements which are not disabled
                List<WebElement> labels = WebElementUtil.findElements(deliveryAvailableLabels);
                if (!labels.isEmpty()) {
                    WebElement firstLabel = labels.get(0);
                    String forAttr = firstLabel.getAttribute("for");
                    if (forAttr != null && !forAttr.trim().isEmpty()) {
                        By inputBy = By.id(forAttr);
                        WebElementUtil.scrollIntoView(inputBy, 200);
                        WebElementUtil.waitForElementToBeClickable(inputBy);
                        WebElementUtil.clickElement(inputBy);
                        WebElement clicked = WebElementUtil.waitForElementToBeClickable(inputBy);
                        return clicked.isSelected();
                    } else {
                        // If label has no 'for', try clicking the label itself and then check the nested input
                        WebElementUtil.scrollIntoView(By.xpath("(//label[contains(@class,'cx-delivery-label') and not(contains(@class,'disabled'))])[1]"), 200);
                        WebElementUtil.clickElement(By.xpath("(//label[contains(@class,'cx-delivery-label') and not(contains(@class,'disabled'))])[1]"));
                        // After clicking label try to find any enabled input
                        List<WebElement> postInputs = WebElementUtil.findElements(deliveryAvailableInputs);
                        if (!postInputs.isEmpty()) {
                            return postInputs.get(0).isSelected();
                        }
                    }
                }

                // nothing found; wait a bit and retry
                attempts++;
                try { Thread.sleep(500); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); }
            } catch (Exception e) {
                attempts++;
                try { Thread.sleep(500); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); }
            }
        }

        return false;
    }

}
