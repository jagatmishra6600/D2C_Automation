package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class Elux_CLP {
    
    protected final By Laundry = By.xpath("(//div[@class='Desktop-Nav']//h5[@aria-label='Laundry'])[1]");
    protected final By Frontloadlaundry = By.xpath("//*[@class='second-level-nav undefined ' and text()=' Front Load Laundry ']");
    protected final By LaundryTowers = By.xpath("//div[@class='title mb-1']/span[text()='Laundry Towers']");
    protected final By WasherDryerSets = By.xpath("//div[@class='title mb-1']/span[text()='Washer and Dryer Sets']");
    protected final By Washers = By.xpath("//div[@class='title mb-1']/span[text()='Washers']");
    protected final By Dryers = By.xpath("//div[@class='title mb-1']/span[text()='Dryers']");
    protected final By Hidefilters = By.xpath("//div[@class='facet-main']//span[text()=' Hide filters']");
    protected final By Results = By.xpath("//div[@class='facet-main']//span[contains(text(),'Results')]");
    protected final By Sortby = By.xpath("//div[@class='facet-main']//span[contains(text(),'Sort by :')]");





}
