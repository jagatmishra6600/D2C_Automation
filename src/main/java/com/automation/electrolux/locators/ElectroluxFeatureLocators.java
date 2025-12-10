package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class ElectroluxFeatureLocators {
    public final By productPDP = By.xpath("//div[contains(@class,'Appliance-Card')] | //div[contains(@class,'accessories-product')]");
    public final By viewMoreButton = By.xpath("//button[contains(text(),' View more')]");
    public final By searchBox = By.xpath("//input[@aria-label=\"search\"]");
    public final By viewMoreFeatures = By.cssSelector(".viewMoreFeatures");
    public final By featureDescription = By.cssSelector(".pdp_description");
    public final By featureBtnSection = By.cssSelector(".text-center.ng-tns-c132592201-0.ng-star-inserted");
    public final By singleLangDocuments = By.xpath("//div[contains(@class,'Card-Title')]//a");


}
