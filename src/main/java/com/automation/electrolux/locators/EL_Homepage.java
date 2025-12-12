package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class EL_Homepage {
    public final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    public final By navigationBarVacuums = By.xpath("//h5[@aria-label='Vacuums']");
    public final By allVacuums = By.xpath("(//a[contains(@href, 'vacuum-cleaners')]//div[contains(@class, 'second-level-nav') and contains(text(), 'Vacuums')])[1]");
    public final By navigationBarLaundry = By.xpath("(//h5[@aria-label='Laundry'])[1]");
    public final By washer = By.xpath("(//h5[contains(text(), 'Washers')])[1]");
    public final By searchBox = By.xpath("//input[@aria-label='search']");
    public final By searchIcon = By.xpath("//*[contains(@class, 'elxIconsSearch ')]");
    public final By productTitle = By.xpath("//div[contains(@class, 'Product-title')]");
    public final By productLink = By.xpath("//div[contains(text(), '500 Series Front Load Washer - 4.5 Cu. Ft.')]/parent::a");
    public final By productId = By.xpath("//div[text()='ELFW7537AT']");
    public final By productPrice = By.xpath("//span[contains(@class, 'H3H3_Desktop saleprice')]");
}
