package com.automation.frigidaire.locators;

import org.openqa.selenium.By;

public class FrigidaireFAQ {

    public final By headerTitle = By.xpath("//h1[normalize-space(text())='Owner Center Resource Library']");
    public final By searchBox = By.xpath("//input[@name=\"queryString\"]");
    public final By homeComfort=By.xpath("//h3[text()=\"Home Comfort\"]");
    public final By roomAC=By.xpath("//h3[text()=\"Room AC\"]");
    public final By refrigeratorsLocators=By.xpath("//h3[text()=\"Refrigerators\"]");
    public final By kitchenLocators=By.xpath("//h3[text()=\"Kitchen\"]");
    public final By subcategoryHeader = By.xpath("//h1[contains(normalize-space(text()), 'Support for')]");
    public final By articleLocatorRefrigerator = By.xpath("//div[h2[text()='Recommended articles for Refrigerators']]//a[2]");
    public final By articleLocatorRoomAc = By.xpath("//div[h2[text()='Recommended articles for Room AC']]//a[2]");
    public final By verifyArticleLocator=By.xpath("//h1[@class=\"font-heading-xl empty:hidden\"]");

}
