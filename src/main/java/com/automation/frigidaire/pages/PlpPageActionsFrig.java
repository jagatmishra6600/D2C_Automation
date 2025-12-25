package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.PLPLocatorsFrig;
import static com.automation.utils.WebElementUtil.*;
import static com.automation.utils.WaitUtils.*;

import org.openqa.selenium.WebElement;

public class PlpPageActionsFrig {

    PLPLocatorsFrig plpPage_Locator = new PLPLocatorsFrig();

    private static String selectedProductId;
    private static String selectedProductTitle;
    private static String selectedProductPrice;
    private static String selectedProductReviewNumber;
    private static String selectedHeight;
    private static String selectedWidth;
    private static String selectedDepth;
    private static String providedProductTitle;
    private static String providedProductPrice;
    private static String providedProductId;

    public PlpPageActionsFrig closePopupModel() {

        try {
            untilVisible(plpPage_Locator.closePopupButton);
            WebElement closeBtn = untilClickable(plpPage_Locator.closePopupButton);
            if (closeBtn != null) {
                closeBtn.click();
            }
        } catch (Exception ignored) {

        }
        return this;
    }

    public PlpPageActionsFrig storeSelectedProductId() {
        untilVisible(plpPage_Locator.plpProductId);
        selectedProductId = getText(plpPage_Locator.plpProductId);
        return this;
    }

    public PlpPageActionsFrig storeSelectedProductTitle() {
        untilVisible(plpPage_Locator.plpProductTitle);
        selectedProductTitle = getText(plpPage_Locator.plpProductTitle);
        return this;
    }

    public PlpPageActionsFrig storeSelectedProductPrice() {
        untilVisible(plpPage_Locator.plpProductPrice);
        selectedProductPrice = getText(plpPage_Locator.plpProductPrice);
        return this;
    }

    public PlpPageActionsFrig storeSelectedProductReviewNumber() {
        untilVisible(plpPage_Locator.plpProductReviewNumber);
        selectedProductReviewNumber = getText(plpPage_Locator.plpProductReviewNumber);
        return this;
    }

    public PlpPageActionsFrig storeProductDimensions() {
        untilVisible(plpPage_Locator.plpHeight);
        untilVisible(plpPage_Locator.plpWidth);
        untilVisible(plpPage_Locator.plpDepth);

        selectedHeight = getText(plpPage_Locator.plpHeight);
        selectedWidth =  getText(plpPage_Locator.plpWidth);
        selectedDepth = getText(plpPage_Locator.plpDepth);

        return this;
    }

    public PdpPageActionsFrig clickFirstProduct() {
        scrollIntoView(plpPage_Locator.plpProductReview);
        clickElement(plpPage_Locator.plpProductReview);
        return new PdpPageActionsFrig();
    }

    public boolean checkProvidedIdIsVisibleOnPlpPage() {
        untilVisible(plpPage_Locator.frenchdoorProductId);
        return isElementPresented(plpPage_Locator.frenchdoorProductId);
    }

    public PlpPageActionsFrig storeProvidedProductId() {
        untilVisible(plpPage_Locator.frenchdoorProductIdText);
        providedProductId = getText(plpPage_Locator.frenchdoorProductIdText);
        return this;
    }

    public PlpPageActionsFrig storeProvidedProductTitle() {
        untilVisible(plpPage_Locator.frenchdoorProductTitle);
        providedProductTitle = getText(plpPage_Locator.frenchdoorProductTitle);
        return this;
    }

    public PlpPageActionsFrig storeProvidedProductPrice() {
        untilVisible(plpPage_Locator.frenchdoorProductPrice);
        providedProductPrice = getText(plpPage_Locator.frenchdoorProductPrice);
        return this;
    }

    public PdpPageActionsFrig clickProvidedProduct() {
        scrollToElementCenter(plpPage_Locator.frenchdoorProductId);
        clickElement(plpPage_Locator.frenchdoorProductId);
        return new PdpPageActionsFrig();
    }


    public static String getSelectedProductId() {
        return selectedProductId;
    }

    public static String getSelectedProductTitle() {
        return selectedProductTitle;
    }

    public static String getSelectedProductPrice() {
        return selectedProductPrice;
    }

    public static String getSelectedProductReviewNumber() {
        return selectedProductReviewNumber;
    }

    public static String getSelectedHeight() {
        return selectedHeight;
    }

    public static String getSelectedWidth() {
        return selectedWidth;
    }

    public static String getSelectedDepth() {
        return selectedDepth;
    }

    public static String getProvidedProductTitle() {
        return providedProductTitle;
    }

    public static String getProvidedProductPrice() {
        return providedProductPrice;
    }

    public static String getProvidedProductId() {return providedProductId;}

}