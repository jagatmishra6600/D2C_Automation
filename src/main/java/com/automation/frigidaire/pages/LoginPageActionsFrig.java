package com.automation.frigidaire.pages;

import static com.automation.utils.WaitUtils.untilClickable;

import com.automation.electrolux.pages.LoginPageActionsElux;
import com.automation.frigidaire.locators.LoginLocatorsFrig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automation.utils.ConfigReader;
import com.automation.utils.WebElementUtil;

import static com.automation.utils.WaitUtils.untilClickable;
import static com.automation.utils.WaitUtils.untilVisible;

public class LoginPageActionsFrig {

	 private LoginLocatorsFrig login_Locator = new LoginLocatorsFrig();
	 private final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");

	 public LoginPageActionsFrig navigateToLoginPage() {
		WebElementUtil.navigateTo(ConfigReader.getAppUrl()+"login");
       try {
           WebElement acceptBtn = untilClickable(acceptButtonLocator, 15);
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
		WebElementUtil.sendKeys(login_Locator.emailAddressInput, emailAddress);
		return this;
	}
	
	public LoginPageActionsFrig enterPassword(String password) {
		WebElementUtil.sendKeys(login_Locator.passwordInput, password);
		return this;
	}
	
	public HomePageActionsFrig clickLoginButton() {
		WebElementUtil.clickElement(login_Locator.loginButton);
		return new HomePageActionsFrig();
	}
	
	public boolean isLoginPageLoaded() {
		return WebElementUtil.isDisplayed(login_Locator.loginButton);
	}
	
	public boolean isLoginToFrigidaireTitleDisplayed() {
		return WebElementUtil.isDisplayed(login_Locator.loginToStoreTitle);
	}
	
	public boolean isLoginTitleMessageDisplayed() {
		return WebElementUtil.isDisplayed(login_Locator.loginTitleMessage);
	}
	
	public boolean isEmailAddressFieldDisplayed() {
		return WebElementUtil.isDisplayed(login_Locator.emailAddressInput);
	}
	
	public boolean isPasswordFieldDisplayed() {
		return WebElementUtil.isDisplayed(login_Locator.passwordInput);
	}
	
	public boolean isShowPasswordIconDisplayed() {
		return WebElementUtil.isDisplayed(login_Locator.showPasswordIcon);
	}
	
	public boolean isKeepMeLoggedInCheckboxDisplayed() {
		return WebElementUtil.isDisplayed(login_Locator.keepMeLoggedInCheckbox);
	}
	
	public String getNotRecommendedLabelText() {
		return WebElementUtil.getText(login_Locator.notRecommendedMessage);
	}
	
	public boolean isForgotPasswordLinkDisplayed() {
		return WebElementUtil.isDisplayed(login_Locator.forgotPasswordLink);
	}
	
	public boolean isCreateAccountLinkDisplayed() {
		return WebElementUtil.isDisplayed(login_Locator.createAccountLink);
	}
	
	public String getElectroluxLinkedAccountMessage() {
		return WebElementUtil.getText(login_Locator.electroluxLinkedAccountMessage);
	}
	
	public boolean isAlternateLoginOptionsDisplayed() {
		return isSignInWithAppleButtonDisplayed() && isSignInWithGoogleButtonDisplayed();
	}
	
	public boolean isSignInWithAppleButtonDisplayed() {
		return WebElementUtil.isDisplayed(login_Locator.signInWithAppleButton);
	}
	
	public boolean isSignInWithGoogleButtonDisplayed() {
		return WebElementUtil.isDisplayed(login_Locator.signInWithGoogleButton);
	}
	
	public CreateAccountPageActionsFrig clickCreateAccountLink() {
		WebElementUtil.scrollIntoView(login_Locator.createAccountLink);
		WebElementUtil.clickElement(login_Locator.createAccountLink);
		return new CreateAccountPageActionsFrig();
	}
	
	public ForgotPasswordPageActionsFrig clickForgotPasswordLink() {
		WebElementUtil.clickElement(login_Locator.forgotPasswordLink);
		return new ForgotPasswordPageActionsFrig();
	}
	
	public boolean isLoginToStoreTitleDisplayed() {
		return WebElementUtil.isDisplayed(login_Locator.loginToStoreTitle);
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
        WebElementUtil.sendKeys(login_Locator.txt_Email, ConfigReader.getProperty("username"));
        WebElementUtil.sendKeys(login_Locator.txt_Password, ConfigReader.getProperty("password"));
        WebElementUtil.clickElement(login_Locator.btn_Login);
        return WebElementUtil.isDisplayed(login_Locator.login_HomeLogo);
    }

//    public boolean isLoginPageLoaded() {
//        WebElement loginButton = untilClickable(btn_Login, 10);
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
            WebElementUtil.sendKeys(login_Locator.txt_Email, username);
            WebElementUtil.sendKeys(login_Locator.txt_Password, password);
            WebElementUtil.clickElement(login_Locator.btn_Login);
            untilVisible(login_Locator.login_HomeLogo,20);
            return WebElementUtil.isDisplayed(login_Locator.login_HomeLogo);
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
    public LoginPageActionsFrig toggleRememberMe() {
        WebElementUtil.clickElement(By.id("rememberMe"));
        return this;
    }

    /**
     * Navigate back to login page from any other page
     * @return LoginPageActions instance
     */
    public LoginPageActionsFrig returnToLoginPage() {
        if (!isLoginPageLoaded()) {
            WebElementUtil.navigateTo(ConfigReader.getProperty("login.url"));
        }
        return this;
    }
}
