package com.automation.electrolux.pages;

import com.automation.electrolux.locators.EL_Homepage;
import com.automation.frigidaire.pages.*;
import com.automation.utils.ConfigReader;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.WebElement;


import static com.automation.utils.WaitUtils.untilClickable;

public class ElectroluxHomePageActions {

    EL_Homepage homePage_Locator = new EL_Homepage();

    public ElectroluxHomePageActions navigateToHomePage() {
        WebElementUtil.navigateTo(ConfigReader.getAppUrl());
        try {
            WebElement acceptBtn = untilClickable(homePage_Locator.acceptButtonLocator, 15);
            if (acceptBtn != null) {
                acceptBtn.click();
            }
        } catch (Exception ignored) {
            // Cookie banner not present or not interactable; continue
        }
        return this;
    }

    public ElectroluxPlpPageActions clickVacuums() {
        WebElementUtil.clickElement(homePage_Locator.navigationBarVacuums);
        WebElementUtil.clickElement(homePage_Locator.allVacuums);
        return new ElectroluxPlpPageActions();
    }

    public ElectroluxPlpPageActions clickWasher() {
        WebElementUtil.clickElement(homePage_Locator.navigationBarLaundry);
        WebElementUtil.clickElement(homePage_Locator.washer);
        return new ElectroluxPlpPageActions();
    }
}