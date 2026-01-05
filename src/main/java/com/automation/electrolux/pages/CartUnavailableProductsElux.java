package com.automation.electrolux.pages;

import com.automation.electrolux.locators.CartLocatorsElux;
import com.automation.frigidaire.locators.CartLocatorsFrig;
import com.automation.frigidaire.utils.WebElementUtil;
import org.testng.Assert;

public class CartUnavailableProductsElux {

    CartLocatorsElux cartUnavailable_Locators = new CartLocatorsElux();

    public void clickOnFilterandaccessories() {
        WebElementUtil.clickElement(cartUnavailable_Locators.Filterandaccessories);

    }
    public void clickOnAccessories() {
        WebElementUtil.clickElement(cartUnavailable_Locators.Accessories);

    }
    public void clickOnAddtocartproduct1() {
        WebElementUtil.clickElement(cartUnavailable_Locators.Addtocartproduct1);

    }
    public void clickOnCancelbutton() {
        WebElementUtil.clickElement(cartUnavailable_Locators.Cancelbutton);

    }
    public void clickOnAddtocartproduct2() {
        WebElementUtil.clickElement(cartUnavailable_Locators.Addtocartproduct2);

    }

    public void clickOnAddtocartproduct3() {
        WebElementUtil.clickElement(cartUnavailable_Locators.Addtocartproduct3);

    }
    public void clickOnAirfilter() {
        WebElementUtil.clickElement(cartUnavailable_Locators.Airfilter);

    }
    public void clickOnAddtocartproduct() {
        WebElementUtil.clickElement(cartUnavailable_Locators.Addtocartproduct);

    }
    public void clickOnDishwasher() {
        WebElementUtil.clickElement(cartUnavailable_Locators.Dishwasher);

    }
    public void clickOnDishwasherproduct() {
        WebElementUtil.clickElement(cartUnavailable_Locators.Dishwasherproduct);

    }

    public void clickOnViewcart() {
        WebElementUtil.clickElement(cartUnavailable_Locators.Viewcart);

    }
    public Boolean verifyemptycart() {
        Assert.assertTrue(WebElementUtil.getText(cartUnavailable_Locators.emptycart).contains(""), "Empty cart text is not found");
        return true;
    }








}
