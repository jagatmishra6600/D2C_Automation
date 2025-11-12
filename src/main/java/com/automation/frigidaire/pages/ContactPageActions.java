package com.automation.frigidaire.pages;

import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;

public class ContactPageActions {

    private final By banner_ContactUs = By.cssSelector("div[class='title mb-1'] h1");

    public boolean isContactPageLoaded() {
        return WebElementUtil.isDisplayed(banner_ContactUs);
    }
}
