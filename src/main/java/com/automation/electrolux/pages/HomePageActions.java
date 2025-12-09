package com.automation.electrolux.pages;

import com.automation.electrolux.locators.ELUX_Homepage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.UserTestData;
import com.automation.utils.WaitUtils;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import static com.automation.utils.WaitUtils.untilClickable;

public class HomePageActions {

    private void acceptCookiesIfPresent() {
        try {
            try { WaitUtils.untilPresent(ELUX_Homepage.cookie_AcceptButton, 15); } catch (Exception ignored) {}
            if (WebElementUtil.isDisplayed(ELUX_Homepage.cookie_AcceptButton)) {
                WebElementUtil.clickElement(ELUX_Homepage.cookie_AcceptButton);
                WaitUtils.sleep(500);
            }
        } catch (Exception ignored) {}
    }

    public HomePageActions navigateToHomePage() {
        WebElementUtil.navigateTo(ConfigReader.getAppUrl());
        acceptCookiesIfPresent();
        return this;
    }

    public boolean isHomePageLoaded() {
        // isDisplayed now handles the wait internally
        return WebElementUtil.isDisplayed(ELUX_Homepage.electroluxLogo)
        		&& WebElementUtil.isDisplayed(ELUX_Homepage.homePageTemplate);
    }

    public boolean isLoginDisplayed() {
        return WebElementUtil.isDisplayed(ELUX_Homepage.mainMenu_Login_OrderStatus);
    }

    public HomePageActions clickLoginOrderStatusLink() {
    	WebElementUtil.clickElement(ELUX_Homepage.mainMenu_Login_OrderStatus);
    	if(!WebElementUtil.isDisplayed(ELUX_Homepage.mainMenu_Login_OrderStatus_CreateAccount)) {
    		WebElementUtil.clickElement(ELUX_Homepage.mainMenu_Login_OrderStatus);
    	}
    	return this;
    }

    public LoginPageActions navigateToLoginPage() {
    	WebElementUtil.hoverElement(ELUX_Homepage.mainMenu_Login_OrderStatus);
    	WebElementUtil.clickElement(ELUX_Homepage.mainMenu_Login_OrderStatus_Login);
    	return new LoginPageActions();
    }

	public boolean isUserGreetingDropdownDisplayed() {
		return WebElementUtil.isDisplayed(ELUX_Homepage.userGreetingDropdownButton);
	}
	
	public String getGreetingMessage() {
		return WebElementUtil.getText(ELUX_Homepage.userGreetingDropdownButton)
					.replace("\n", " ").trim();	
	}
	
	public HomePageActions login(String emailAddress, String password) throws InterruptedException {
		return navigateToHomePage().navigateToLoginPage()
									.login(emailAddress, password);
	}
	
	public HomePageActions loginWithDefaultCredentials() {
		return navigateToHomePage().navigateToLoginPage()
									.login(UserTestData.getUserName(), UserTestData.getPassword());
	}
	
	public ForgotPasswordPageActions navigateToResetPasswordPage() {
    	return navigateToHomePage().navigateToLoginPage().clickForgotPasswordLink();
    }
}