package com.automation.frigidaire.locators;

import org.openqa.selenium.By;

public class FeaturesLocatorsFrig {

    public final By productPDP = By.xpath("//div[contains(@class,'accessories-product')]");
    public final By featureHeading = By.xpath("//strong[text()='Overview & Features']//parent::h4//parent::span");
    public final By viewAll = By.xpath("//p[text()='View all']");
    public final By featureBanner = By.cssSelector(".featureBanner");
    public final By viewMoreButton = By.xpath("//button[contains(text(),' View more')]");
    public final By searchBox = By.xpath("//input[@aria-label=\"search\"]");
    public final By viewMoreFeatures = By.cssSelector(".viewMoreFeatures");
    public final By featureListItems = By.cssSelector(".featureList .cursor-pointer");
    public final By featureDescription = By.cssSelector(".pdp_description");

    public final By ownerSection = By.cssSelector(".owners-section");
    public final By ownerTitle = By.xpath("//h3[text()='Guides & Manuals']");
    public final By languageTabs = By.xpath("//span[contains(@class,'Body-MediumBody_Medium_Centered')]");
    public final By documentLinks = By.xpath("//div[contains(@class,'Body-MediumBody_Medium-Link')]//a");
    public final By singleLangDocuments = By.xpath("//div[contains(@class,'Card-Title')]//a");

    // Locators for Service & Parts section
    public final By replacementPartsTile = By.xpath("//h4[text()='Replacement Parts']");
    public final By replacementPartsButton = By.xpath("//h4[text()='Replacement Parts']//parent::p//parent::cx-paragraph//following-sibling::cx-link//a");
    public final By repairsServiceTile = By.xpath("//h4[text()='Repairs & Service']");
    public final By repairsServiceButton = By.xpath("//h4[text()='Repairs & Service']//parent::p//parent::cx-paragraph//following-sibling::cx-link//a");

    // Locator for Add to cart button (handles <a> or <button> with inner span text)
    public final By addToCartButton = By.xpath("//span[normalize-space()='Add to cart']/ancestor::a");

    // Locators for Delivery & Installation and Save & view cart
    public final By deliveryInstallationRadio = By.id("Refrigerators_Large_WaterLine_Install");
    public final By saveAndViewCartButton = By.xpath("//button[normalize-space()='Save and view cart']");
    // Locator for Proceed to checkout button on the Cart/Order Summary
    public final By proceedToCheckoutButton = By.xpath("//button[normalize-space()='Proceed to checkout']");
    // Locator for Continue to delivery button on the shipping/address step
    public final By continueToDeliveryButton = By.id("continueToDeliveryButton");

    // Shipping address fields (used on checkout shipping step)
    public final By shippingEmail = By.id("email");
    public final By shippingFirstName = By.id("firstName");
    public final By shippingLastName = By.id("lastName");
    public final By shippingAddressLine1 = By.xpath("//input[@formcontrolname='line1' or @id='address-1' or contains(@placeholder,'Address')]");
    public final By shippingPhone = By.id("phone");
    public final By addressSuggestionOption = By.xpath("//ngb-typeahead-window//button[@role='option']");

    // Delivery date selection elements
    public final By deliveryCalendarHeader = By.xpath("//p[contains(text(),'Delivery and installation items')]");
    public final By deliveryDateAvailable = By.cssSelector("cx-delivery-label avaliableDates");
    public final By deliveryAvailableLabels = By.xpath("//label[contains(@class,'cx-delivery-label') and not(contains(@class,'disabled'))]");
}
