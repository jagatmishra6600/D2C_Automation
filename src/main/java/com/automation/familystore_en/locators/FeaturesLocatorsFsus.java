package com.automation.familystore_en.locators;

import org.openqa.selenium.By;

public class FeaturesLocatorsFsus {

    public final By productPDP = By.xpath("//div[contains(@class,'Appliance-Card')]");
    public final By viewMoreButton = By.xpath("//button[contains(text(),' View more')]");
    public final By searchBox = By.xpath("//input[@aria-label=\"search\"]");
    public final By viewMoreFeatures = By.cssSelector(".viewMoreFeatures");
    public final By featureDescription = By.cssSelector(".pdp_description");
    public final By featureBtnSection = By.cssSelector(".eluxStaticLuxPdpFeature");
    public final By singleLangDocuments = By.xpath("//div[contains(@class,'Card-Title')]//a");

}
