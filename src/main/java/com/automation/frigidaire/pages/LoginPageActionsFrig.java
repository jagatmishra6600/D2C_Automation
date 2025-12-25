package com.automation.frigidaire.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import com.automation.electrolux.pages.LoginPageActionsElux;
import com.automation.frigidaire.locators.LoginLocatorsFrig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automation.utils.ConfigReader;


import static com.automation.utils.WaitUtils.*;
import static com.automation.utils.WebElementUtil.*;

public class LoginPageActionsFrig {

	 private LoginLocatorsFrig login_Locator = new LoginLocatorsFrig();
	 private final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");

	 public LoginPageActionsFrig navigateToLoginPage() {
		navigateTo(ConfigReader.getAppUrl()+"login");
       try {
           WebElement acceptBtn = untilClickable(acceptButtonLocator);
           if (acceptBtn != null) {
               acceptBtn.click();
           }
       } catch (Exception ignored) {
           // Cookie banner not present or not interactable; continue
       }
       return this;
	}
	
	 public HomePageActionsFrig login(String emailAddress, String password) {
		 return	 enterEmailAddress(emailAddress)
								.enterPassword(password)
								.clickLoginButton();
	 }
	 
	public LoginPageActionsFrig enterEmailAddress(String emailAddress) {
		sendKeys(login_Locator.emailAddressInput, emailAddress);
		return this;
	}
	
	public LoginPageActionsFrig enterPassword(String password) {
		sendKeys(login_Locator.passwordInput, password);
		return this;
	}
	
	public HomePageActionsFrig clickLoginButton() {
		clickElement(login_Locator.loginButton);
		return new HomePageActionsFrig();
	}
	
	public boolean isLoginPageLoaded() {
		return isDisplayed(login_Locator.loginButton);
	}
	
	public boolean isLoginToFrigidaireTitleDisplayed() {
		return isDisplayed(login_Locator.loginToStoreTitle);
	}
	
	public boolean isLoginTitleMessageDisplayed() {
		return isDisplayed(login_Locator.loginTitleMessage);
	}
	
	public boolean isEmailAddressFieldDisplayed() {
		return isDisplayed(login_Locator.emailAddressInput);
	}
	
	public boolean isPasswordFieldDisplayed() {
		return isDisplayed(login_Locator.passwordInput);
	}
	
	public boolean isShowPasswordIconDisplayed() {
		return isDisplayed(login_Locator.showPasswordIcon);
	}
	
	public boolean isKeepMeLoggedInCheckboxDisplayed() {
		return isDisplayed(login_Locator.keepMeLoggedInCheckbox);
	}
	
	public String getNotRecommendedLabelText() {
		return getText(login_Locator.notRecommendedMessage);
	}
	
	public boolean isForgotPasswordLinkDisplayed() {
		return isDisplayed(login_Locator.forgotPasswordLink);
	}
	
	public boolean isCreateAccountLinkDisplayed() {
		return isDisplayed(login_Locator.createAccountLink);
	}
	
	public String getElectroluxLinkedAccountMessage() {
		return getText(login_Locator.electroluxLinkedAccountMessage);
	}
	
	public boolean isAlternateLoginOptionsDisplayed() {
		return isSignInWithAppleButtonDisplayed() && isSignInWithGoogleButtonDisplayed();
	}
	
	public boolean isSignInWithAppleButtonDisplayed() {
		return isDisplayed(login_Locator.signInWithAppleButton);
	}
	
	public boolean isSignInWithGoogleButtonDisplayed() {
		return isDisplayed(login_Locator.signInWithGoogleButton);
	}
	
	public CreateAccountPageActionsFrig clickCreateAccountLink() {
		scrollIntoView(login_Locator.createAccountLink);
		clickElement(login_Locator.createAccountLink);
		return new CreateAccountPageActionsFrig();
	}
	
	public ForgotPasswordPageActionsFrig clickForgotPasswordLink() {
		clickElement(login_Locator.forgotPasswordLink);
		return new ForgotPasswordPageActionsFrig();
	}
	
	public boolean isLoginToStoreTitleDisplayed() {
		return isDisplayed(login_Locator.loginToStoreTitle);
	}

	public CreateAccountPageActionsFrig navigateToCreateAccountPage() {
		return navigateToLoginPage().clickCreateAccountLink();
	}
	
	public void verifyLoginPageFieldsAndMessages() {
		Assert.assertTrue(isLoginPageLoaded(), "User is not navigated to LoginPage");
       Assert.assertTrue(isLoginToFrigidaireTitleDisplayed(), "'Log in to Frigidaire' title is not present");
       Assert.assertTrue(isEmailAddressFieldDisplayed(), "Email Address field is not displayed");
       Assert.assertTrue(isPasswordFieldDisplayed(), "Password field is not displayed");
       Assert.assertTrue(isShowPasswordIconDisplayed(), "'Show Password' icon is not displayed");
       Assert.assertTrue(isKeepMeLoggedInCheckboxDisplayed(), "'Keep Me Logged In' checkbox is not displayed");
       Assert.assertTrue(isForgotPasswordLinkDisplayed(), "Forgot Password Link is not displayed");
       Assert.assertTrue(isCreateAccountLinkDisplayed(), "Create an Account Link is not displayed");
       Assert.assertEquals(getElectroluxLinkedAccountMessage(), "Frigidaire is part of the Electrolux Group. If you already have an account with Electrolux.com, you can use those details to log in."
       												,"Electrolux Linked Account Message Not Displayed");
       Assert.assertTrue(isAlternateLoginOptionsDisplayed(), "Sign in Options with Google or Apple is not Displayed");
       
	}

    public boolean validateLogoAfterLogin() {
        sendKeys(login_Locator.txt_Email, ConfigReader.getProperty("username"));
        sendKeys(login_Locator.txt_Password, ConfigReader.getProperty("password"));
        clickElement(login_Locator.btn_Login);
        return isDisplayed(login_Locator.login_HomeLogo);
    }

//    public boolean isLoginPageLoaded() {
//        WebElement loginButton = untilClickable(btn_Login);
//        return loginButton.isDisplayed();
//    }

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
            sendKeys(login_Locator.txt_Email, username);
            sendKeys(login_Locator.txt_Password, password);
            clickElement(login_Locator.btn_Login);
            untilVisible(login_Locator.login_HomeLogo);
            return isDisplayed(login_Locator.login_HomeLogo);
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * Check if error message is displayed for invalid login
     * @return true if error message is displayed, false otherwise
     */
    public boolean isLoginErrorDisplayed() {
        return isDisplayed(By.cssSelector(".error-message"));
    }

    /**
     * Get text of login error message
     * @return error message text or empty string if no error
     */
    public String getLoginErrorMessage() {
        return getText(By.cssSelector(".error-message"));
    }


    /**
     * Check if Remember Me checkbox exists
     * @return true if checkbox exists, false otherwise
     */
    public boolean isRememberMePresent() {
        return isDisplayed(By.id("rememberMe"));
    }

    /**
     * Toggle Remember Me checkbox
     * @return LoginPageActions instance for method chaining
     */
    public LoginPageActionsFrig toggleRememberMe() {
        clickElement(By.id("rememberMe"));
        return this;
    }

    /**
     * Navigate back to login page from any other page
     * @return LoginPageActions instance
     */
    public LoginPageActionsFrig returnToLoginPage() {
        if (!isLoginPageLoaded()) {
            navigateTo(ConfigReader.getProperty("login.url"));
        }
        return this;
    }
}
