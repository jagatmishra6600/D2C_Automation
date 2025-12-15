package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class CLPLocatorsElux {

    public final By Laundry = By.xpath("(//div[@class='Desktop-Nav']//h5[@aria-label='Laundry'])[1]");
    public final By FrontloadLaundry = By.xpath("(//div[@class='btn-link-icon-blue elux-navBold-with-icon second-level-nav' and text()=' Front Load Laundry '])[1]");
    public final By LaundryTowers = By.xpath("//div[@class='title mb-1']/span[text()='Laundry Towers']");
    public final By WasherDryerSets = By.xpath("//div[@class='title mb-1']/span[text()='Washer and Dryer Sets']");
    public final By Washers = By.xpath("//div[@class='title mb-1']/span[text()='Washers']");
    public final By Dryers = By.xpath("//div[@class='title mb-1']/span[text()='Dryers']");
    public final By Hidefilters = By.xpath("//div[@class='facet-main']//span[text()=' Hide filters']");
    public final By Results = By.xpath("//div[@class='facet-main']//span[contains(text(),'Results')]");
    public final By Sortby = By.xpath("//div[@class='facet-main']//span[contains(text(),'Sort by :')]");
    public final By categoryTitle = By.xpath("//*[@class='elxCategoryHeading has-components']//h1");

}

