package com.automation.frigidaire.pages;

import static com.automation.frigidaire.utils.WaitUtils.untilClickable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.frigidaire.utils.ConfigReader;
import com.automation.frigidaire.utils.WebElementUtil;

public class FrigidaireLoginPageActions {

	 private final By acceptButtonLocator = By.xpath("//button[@id='onetrust-accept-btn-handler']");

	 private final By emailAddressInput = By.cssSelector("input[placeholder='Email address *']");
	 private final By passwordInput = By.cssSelector("input[placeholder='Password *']");
	 private final By loginButton = By.cssSelector("input[value='Log in']");
	 
	 
	 public FrigidaireLoginPageActions navigateToLoginPage() {
		WebElementUtil.navigateTo(ConfigReader.getProperty("app.url")+"login");
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
	
	 public FrigidaireHomePageActions login(String emailAddress, String password) {
		 return enterEmailAddress(emailAddress)
							 .enterPassword(password)
							 .clickLoginButton();
	 }
	 
	public FrigidaireLoginPageActions enterEmailAddress(String emailAddress) {
		WebElementUtil.sendKeys(emailAddressInput, emailAddress);
		return this;
	}
	
	public FrigidaireLoginPageActions enterPassword(String password) {
		WebElementUtil.sendKeys(passwordInput, password);
		return this;
	}
	
	public FrigidaireHomePageActions clickLoginButton() {
		WebElementUtil.clickElement(loginButton);
		return new FrigidaireHomePageActions();
	}
}
