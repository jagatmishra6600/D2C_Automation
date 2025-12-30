package com.automation.frigidaire.pages;

import com.automation.electrolux.locators.CLPLocatorsElux;
import com.automation.frigidaire.locators.CartLocatorsFrig;
import com.automation.frigidaire.utils.WebElementUtil;
import org.testng.Assert;

public class CartUnavailableProductsFrig
{
    CartLocatorsFrig cartUnavailable_Locator = new CartLocatorsFrig();

    public void clickOnSmallAppliances() {
        WebElementUtil.clickElement(cartUnavailable_Locator.SmallAppliances);

    }
    public void clickOnEspressomaker() {
        WebElementUtil.clickElement(cartUnavailable_Locator.Espressomaker);

    }
    public void clickOnSaveandViewCart() {
        WebElementUtil.clickElement(cartUnavailable_Locator.SaveandViewCart);

    }
    public void clickOnCancelbutton() {
        WebElementUtil.clickElement(cartUnavailable_Locator.Cancelbutton);

    }
    public void clickOnRetrominifridge() {
        WebElementUtil.clickElement(cartUnavailable_Locator.Retrominifridge);

    }
    public void clickOnitemaddtocart() {
        WebElementUtil.clickElement(cartUnavailable_Locator.itemaddtocart);

    }
    public void clickOnMinifridgetwo() {
        WebElementUtil.clickElement(cartUnavailable_Locator.Minifridgetwo);

    }
    public void clickOnAccessories() {
        WebElementUtil.clickElement(cartUnavailable_Locator.Accessories);

    }
    public void clickOnIcemakers() {
        WebElementUtil.clickElement(cartUnavailable_Locator.Icemakers);

    }
    public void clickOnIcemakersproduct() {
        WebElementUtil.clickElement(cartUnavailable_Locator.Icemakersproduct);
        }


    public boolean verifyYourCart() {
        Assert.assertTrue(WebElementUtil.getText(cartUnavailable_Locator.YourCart).contains(" Empty cart"), "Empty cart text is not found");
        return true;

    }
    }
