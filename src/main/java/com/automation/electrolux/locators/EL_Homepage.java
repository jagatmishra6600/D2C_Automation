package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class EL_Homepage {
    public final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    public final By navigationBarVacuums = By.xpath("//h5[@aria-label='Vacuums']");
    public final By allVacuums = By.xpath("(//a[contains(@href, 'vacuum-cleaners')]//div[contains(@class, 'second-level-nav') and contains(text(), 'Vacuums')])[1]");
    public final By navigationBarLaundry = By.xpath("(//h5[@aria-label='Laundry'])[1]");
    public final By washer = By.xpath("(//h5[contains(text(), 'Washers')])[1]");
}
