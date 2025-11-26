package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class ELUX_Homepage {
	
	  public static final By mainMenu_Login_OrderStatus = By.xpath("(//div[contains(.,'Log in / Order status')])[1]");
	  public static final By mainMenu_Login_OrderStatus_Login = By.xpath("//*[@class='dropdown-login-cta']//button[contains(.,'Log in')]");
	  public static final By mainMenu_Login_OrderStatus_CreateAccount = By.xpath("//*[@class='dropdown-login-cta']//button[contains(.,'Create an account')]");
	  public static final By electroluxLogo = By.cssSelector("img[alt='Electrolux']");
	  public static final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	  public static final By homePageTemplate = By.xpath("//cx-page-layout[contains(@class,'ElxSecondaryPageTemplate')]");
	  public static final By userGreetingDropdownButton = By.xpath("(//a[@role='link' and contains(.,'Hello')])[1]");
	  public static final By cookie_AcceptButton = By.id("onetrust-accept-btn-handler");
	      
}
