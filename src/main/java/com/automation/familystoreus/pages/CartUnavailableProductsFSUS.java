package com.automation.familystoreus.pages;

import com.automation.electrolux.locators.CartLocatorsElux;
import com.automation.familystoreus.locators.CartPageLocator_FSUS;
import com.automation.frigidaire.utils.WebElementUtil;
import org.testng.Assert;

public class CartUnavailableProductsFSUS {

    CartPageLocator_FSUS cartUnavailablefsus_Locators = new CartPageLocator_FSUS();

    public void clickOnKitchentext() {
        WebElementUtil.clickElement(cartUnavailablefsus_Locators.Kitchentext);

    }

    public void clickOnSingledoor() {
        WebElementUtil.clickElement(cartUnavailablefsus_Locators.Singledoor);

    }

    public void clickOnrefrigeratoraddtocart() {
        WebElementUtil.clickElement(cartUnavailablefsus_Locators.refrigeratoraddtocart);

    }

    public void clickOnSaveandcontinueshopping() {
        WebElementUtil.clickElement(cartUnavailablefsus_Locators.Saveandcontinueshopping);

    }

    public void clickOnInduction() {
        WebElementUtil.clickElement(cartUnavailablefsus_Locators.Induction);

    }

    public void clickOnInductionaddtocart() {
        WebElementUtil.clickElement(cartUnavailablefsus_Locators.Inductionaddtocart);

    }

    public void clickOnGas() {
        WebElementUtil.clickElement(cartUnavailablefsus_Locators.Gas);

    }

    public void clickOnGasaddtocart() {
        WebElementUtil.clickElement(cartUnavailablefsus_Locators.Gasaddtocart);

    }

    public void clickOnLaundrytext() {
        WebElementUtil.clickElement(cartUnavailablefsus_Locators.Laundrytext);

    }

    public void clickOnWasherstext() {
        WebElementUtil.clickElement(cartUnavailablefsus_Locators.Washerstext);

    }

    public void clickOnWashersaddtocart() {
        WebElementUtil.clickElement(cartUnavailablefsus_Locators.Washersaddtocart);

    }

    public void clickOnSaveandviewcart() {
        WebElementUtil.clickElement(cartUnavailablefsus_Locators.Saveandviewcart);

    }

    public Boolean verifyEmptycart() {
        Assert.assertTrue(WebElementUtil.getText(cartUnavailablefsus_Locators.Emptycart).contains("Empty cart"), "Empty cart text is not found");
        return true;
    }






}
