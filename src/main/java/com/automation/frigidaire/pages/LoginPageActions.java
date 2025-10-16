package com.automation.frigidaire.pages;

import com.automation.frigidaire.utils.ConfigReader;
import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.automation.frigidaire.utils.WaitUtils.untilClickable;

public class LoginPageActions {

    private final By txt_Email = By.cssSelector("input[placeholder='Email address *']");
    private final By txt_Password = By.cssSelector("input[placeholder='Password *']");
    private final By btn_Login = By.cssSelector("input[value='Log in']");

    private final By lnk_ForgotPassword = By.cssSelector("#login-forgot-password-link");
    private final By lnk_CreateAccount = By.cssSelector("#login-create-account-link");

    private final By login_HomeLogo = By.cssSelector("//img[@alt='Frigidaire Company Logo']");


    public boolean validateLogoAfterLogin() {
        WebElementUtil.sendKeys(txt_Email, ConfigReader.getProperty("username"));
        WebElementUtil.sendKeys(txt_Password, ConfigReader.getProperty("password"));
        WebElementUtil.clickElement(btn_Login);
       return WebElementUtil.isDisplayed(login_HomeLogo);
    }

    public boolean isLoginPageLoaded() {
        WebElement loginButton = untilClickable(btn_Login, 10);
        return loginButton.isDisplayed();
    }

    /**
     * Login with credentials from config file
     * @return true if login successful, false otherwise
     */
    public boolean loginWithDefaultCredentials() {
        return loginWithCredentials(
            ConfigReader.getProperty("username"),
            ConfigReader.getProperty("password")
        );
    }

    /**
     * Login with provided credentials
     * @param username email/username to login with
     * @param password password to login with
     * @return true if login successful, false otherwise
     */
    public boolean loginWithCredentials(String username, String password) {
        try {
            WebElementUtil.sendKeys(txt_Email, username);
            WebElementUtil.sendKeys(txt_Password, password);
            WebElementUtil.clickElement(btn_Login);
            return WebElementUtil.isDisplayed(login_HomeLogo);
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * Check if error message is displayed for invalid login
     * @return true if error message is displayed, false otherwise
     */
    public boolean isLoginErrorDisplayed() {
        return WebElementUtil.isDisplayed(By.cssSelector(".error-message"));
    }

    /**
     * Get text of login error message
     * @return error message text or empty string if no error
     */
    public String getLoginErrorMessage() {
        return WebElementUtil.getText(By.cssSelector(".error-message"));
    }


    /**
     * Check if Remember Me checkbox exists
     * @return true if checkbox exists, false otherwise
     */
    public boolean isRememberMePresent() {
        return WebElementUtil.isDisplayed(By.id("rememberMe"));
    }

    /**
     * Toggle Remember Me checkbox
     * @return LoginPageActions instance for method chaining
     */
    public LoginPageActions toggleRememberMe() {
        WebElementUtil.clickElement(By.id("rememberMe"));
        return this;
    }

    /**
     * Navigate back to login page from any other page
     * @return LoginPageActions instance
     */
    public LoginPageActions returnToLoginPage() {
        if (!isLoginPageLoaded()) {
            WebElementUtil.navigateTo(ConfigReader.getProperty("login.url"));
        }
        return this;
    }
}