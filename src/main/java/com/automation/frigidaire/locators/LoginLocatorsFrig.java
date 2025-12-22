package com.automation.frigidaire.locators;
import org.openqa.selenium.By;

public class LoginLocatorsFrig {
   
    public final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    public final By emailAddressInput = By.xpath("//input[@placeholder='Email address *' or @placeholder='jane.doe@company.com *']");
    public final By passwordInput = By.xpath("//input[@placeholder='Password *' or contains(@id,'gigya-password')]");
    public final By loginButton = By.cssSelector("input[value='Log in']");
    public final By loginToStoreTitle = By.xpath("//h2[normalize-space()='Log in to Frigidaire' or normalize-space()='Log in to Electrolux']");
    public final By loginTitleMessage = By.xpath("//label[normalize-space()='Log in with your email and password: *']");
    public final By showPasswordIcon = By.cssSelector("button[title='Show Password'] i");
    public final By keepMeLoggedInCheckbox = By.xpath("//input[@id='gigya-checkbox-remember']");
    public final By notRecommendedMessage = By.xpath("//label[contains(.,'shared or public device')]");
    public final By forgotPasswordLink = By.xpath("//a[@id='login-forgot-password-link']");
    public final By createAccountLink = By.xpath("//a[@id='createAccButton']");
    public final By electroluxLinkedAccountMessage = By.xpath("//label[contains(.,'part of the Electrolux Group')]");
    public final By signInWithAppleButton = By.id("Apple_btn");
    public final By signInWithGoogleButton = By.id("Google_btn");

    public final By txt_Email = By.cssSelector("input[placeholder='Email address *']");
    public final By txt_Password = By.cssSelector("input[placeholder='Password *']");
    public final By btn_Login = By.cssSelector("input[value='Log in']");
    public final By lnk_ForgotPassword = By.cssSelector("#login-forgot-password-link");
    public final By lnk_CreateAccount = By.cssSelector("#login-create-account-link");
    public final By login_HomeLogo = By.cssSelector("//img[@alt='Frigidaire Company Logo']");
	 

}
