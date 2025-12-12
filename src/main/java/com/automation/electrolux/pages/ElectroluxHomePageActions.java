package com.automation.electrolux.pages;

import com.automation.electrolux.locators.EL_Homepage;
import com.automation.frigidaire.pages.*;
import com.automation.utils.ConfigReader;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.WebElement;


import static com.automation.utils.WaitUtils.untilClickable;

public class ElectroluxHomePageActions {

    EL_Homepage homePage_Locator = new EL_Homepage();

    private static String providedProductId;
    private static String providedProductTitle;
    private static String providedProductPrice;

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

    public ElectroluxHomePageActions clickSearchAndEnterProductId(String productId) {
        WebElementUtil.clickElement(homePage_Locator.searchBox);
        WebElementUtil.sendKeys(homePage_Locator.searchBox, productId);
        return this;
    }

    public ElectroluxHomePageActions clickSearchIcon() {
        WebElementUtil.clickElement(homePage_Locator.searchIcon);
        WebElementUtil.waitForElementToBeVisible(homePage_Locator.productTitle);
        return this;
    }

    public ElectroluxHomePageActions storeProvidedProductId() {
        WebElementUtil.scrollToElementCenter(homePage_Locator.productId);
        WaitUtils.untilVisible(homePage_Locator.productId);
        providedProductId = WebElementUtil.getText(homePage_Locator.productId);
        return this;
    }

    public ElectroluxHomePageActions storeProvidedProductTitle() {
        WebElementUtil.scrollToElementCenter(homePage_Locator.productTitle);
        WaitUtils.untilVisible(homePage_Locator.productTitle);
        providedProductTitle = WebElementUtil.getText(homePage_Locator.productTitle);
        return this;
    }

    public ElectroluxHomePageActions storeProvidedProductPrice() {
        WebElementUtil.scrollToElementCenter(homePage_Locator.productPrice);
        WaitUtils.untilVisible(homePage_Locator.productPrice);
        providedProductPrice = WebElementUtil.getText(homePage_Locator.productPrice);
        return this;
    }

    public ElectroluxPdpPageActions clickProvidedProduct() {
        WebElementUtil.scrollToElementCenter(homePage_Locator.productTitle);
        WebElementUtil.clickElement(homePage_Locator.productLink);
        return new ElectroluxPdpPageActions();
    }

    public static String getProvidedProductId() {
        return providedProductId;
    }

    public static String getProvidedProductTitle() {return providedProductTitle;}

    public static String getProvidedProductPrice() {return providedProductPrice;}

}