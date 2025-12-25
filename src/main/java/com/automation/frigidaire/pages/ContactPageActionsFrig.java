package com.automation.frigidaire.pages;

import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;

import static com.automation.utils.WebElementUtil.isDisplayed;

public class ContactPageActionsFrig {

    private final By banner_ContactUs = By.cssSelector("div[class='title mb-1'] h1");

    public boolean isContactPageLoaded() {
        return isDisplayed(banner_ContactUs);
    }
}
