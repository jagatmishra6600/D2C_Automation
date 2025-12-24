package com.automation.frigidaire.locators;

import org.openqa.selenium.By;

public class HomepageLocatorsFrig {
    public final By footer_Root = By.xpath("//footer");
    public final By cookie_AcceptButton = By.id("onetrust-accept-btn-handler");
    public final By frigidaireLogo = By.cssSelector("img[alt='Frigidaire Company Logo']");
    public final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    public final By navigationBarAirConditioners = By.xpath("//h5[@aria-label='Air Care']");
    public final By windowMounted = By.xpath("//h5[contains(text(), 'Window Mounted')]");
    public final By navigationBarKitchen = By.xpath("//h5[@aria-label='Kitchen']");
    public final By frenchDoor = By.xpath("//h5[contains(text(), 'French Door')]");
    public final By searchBox = By.xpath("//input[@aria-label='search']");
    public final By searchIcon = By.xpath("//*[contains(@class, 'elxIconsSearch ')]");
    public final By accesProductLink = By.xpath("(//a[contains(@title, 'Top Mount Refrigerator Ice Maker Kit')])[1]");
}
