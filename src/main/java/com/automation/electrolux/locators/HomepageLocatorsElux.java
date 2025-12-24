package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class HomepageLocatorsElux {
    public static final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    public static final By navigationBarVacuums = By.xpath("//h5[@aria-label='Vacuums']");
    public static final By allVacuums = By.xpath("(//a[contains(@href, 'vacuum-cleaners')]//div[contains(@class, 'second-level-nav') and contains(text(), 'Vacuums')])[1]");
    public static final By navigationBarLaundry = By.xpath("(//h5[@aria-label='Laundry'])[1]");
    public static final By washer = By.xpath("(//h5[contains(text(), 'Washers')])[1]");
    public static final By searchBox = By.xpath("//input[@aria-label='search']");
    public static final By searchIcon = By.xpath("//*[contains(@class, 'elxIconsSearch ')]");
    public static final By productTitle = By.xpath("//div[contains(@class, 'Product-title')]");
    public static final By productLink = By.xpath("//div[contains(text(), '500 Series Front Load Washer - 4.5 Cu. Ft.')]/parent::a");
    public static final By productId = By.xpath("//div[text()='ELFW7537AT']");
    public static final By productPrice = By.xpath("//span[contains(@class, 'H3H3_Desktop saleprice')]");
    public static final By mainMenu_Login_OrderStatus = By.xpath("(//div[contains(.,'Log in / Order status')])[1]");
    public static final By mainMenu_Login_OrderStatus_Login = By.xpath("//*[@class='dropdown-login-cta']//button[contains(.,'Log in')]");
    public static final By mainMenu_Login_OrderStatus_CreateAccount = By.xpath("//*[@class='dropdown-login-cta']//button[contains(.,'Create an account')]");
    public static final By electroluxLogo = By.cssSelector("img[alt='Electrolux']");
    public static final By homePageTemplate = By.xpath("//cx-page-layout[contains(@class,'ElxSecondaryPageTemplate')]");
    public static final By userGreetingDropdownButton = By.xpath("(//a[@role='link' and contains(.,'Hello')])[1]");
    public static final By cookie_AcceptButton = By.id("onetrust-accept-btn-handler");
    public static final By accesProductLink = By.xpath("(//a[contains(@title, 'PureAdvantage')])[1]");

}
