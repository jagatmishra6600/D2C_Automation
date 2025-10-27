package com.automation.frigidaire.pages;

import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FeaturesPageActions {

    private final By featureHeading = By.xpath("//strong[text()='Overview & Features']//parent::h4//parent::span");
    private final By viewAll = By.xpath("//p[text()='View all']");
    private final By featureBanner = By.cssSelector(".featureBanner");
    private final By viewMoreButton = By.xpath("//button[contains(text(),' View more')]");
    private final By searchBox = By.xpath("//input[@aria-label=\"search\"]");
    private final By searchButton = By.cssSelector(".searchIconHeader");
    private final By productPDP = By.cssSelector(".plp-item");
    private final By viewMoreFeatures = By.cssSelector(".viewMoreFeatures");
    private final By featureListItems = By.cssSelector(".featureList .cursor-pointer");
    private final By featureDescription = By.cssSelector(".pdp_description");

    private final By ownerSection = By.cssSelector(".owners-section");
    private final By ownerTitle = By.xpath("//h3[text()='Guides & Manuals']");
    private final By languageTabs = By.xpath("//span[contains(@class,'Body-MediumBody_Medium_Centered')]");
    private final By documentLinks = By.xpath("//div[contains(@class,'Body-MediumBody_Medium-Link')]//a");

    // Locators for Service & Parts section
    private final By replacementPartsTile = By.xpath("//h4[text()='Replacement Parts']");
    private final By replacementPartsButton = By.xpath("//h4[text()='Replacement Parts']//parent::p//parent::cx-paragraph//following-sibling::cx-link//a");
    private final By repairsServiceTile = By.xpath("//h4[text()='Repairs & Service']");
    private final By repairsServiceButton = By.xpath("//h4[text()='Repairs & Service']//parent::p//parent::cx-paragraph//following-sibling::cx-link//a");

    public void searchProduct(String productName) {
        WebElementUtil.waitForElementToBeVisible(searchBox);
        WebElementUtil.sendKeys(searchBox, productName);
        WebElementUtil.waitForElementToBeClickable(searchButton);
        WebElementUtil.clickElement(searchButton);
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
}
