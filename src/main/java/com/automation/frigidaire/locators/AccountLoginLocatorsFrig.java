package com.automation.frigidaire.locators;
import org.openqa.selenium.By;

public class AccountLoginLocatorsFrig {
   
    public final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    public final By forgotPasswordLink = By.cssSelector("a[title='Forgot Password']");
    public final By createAccountLink = By.xpath("//a[contains(.,'Create an account')]");
    public final By accountLoginTitle = By.xpath("//h2[normalize-space()='Account Login']");
    public final By continueAsGuestLink = By.xpath("//a[normalize-space()='Continue as guest']");
}
