package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.CartLocatorsFrig;
import com.automation.frigidaire.utils.WebElementUtil;

public class CartUnavailableProductsFrig extends CartLocatorsFrig {

    public void clickOnSmallAppliances() {
        WebElementUtil.clickElement(SmallAppliances);

    }
    public void clickOnEspressomaker() {
        WebElementUtil.clickElement(Espressomaker);

    }
    public void clickOnSaveandViewCart() {
        WebElementUtil.clickElement(SaveandViewCart);

    }
    public void clickOnCancelbutton() {
        WebElementUtil.clickElement(Cancelbutton);

    }
    public void clickOnRetrominifridge() {
        WebElementUtil.clickElement(Retrominifridge);

    }
    public void clickOnitemaddtocart() {
        WebElementUtil.clickElement(itemaddtocart);

    }
    public void clickOnMinifridgetwo() {
        WebElementUtil.clickElement(Minifridgetwo);

    }
    public void clickOnAccessories() {
        WebElementUtil.clickElement(Accessories);

    }
    public void clickOnIcemakers() {
        WebElementUtil.clickElement(Icemakers);

    }
    public void clickOnIcemakersproduct() {
        WebElementUtil.clickElement(Icemakersproduct);

    }
    public boolean verifyYourCart() {
        WebElementUtil.isDisplayed(YourCart);
        return true;

    }


    }
