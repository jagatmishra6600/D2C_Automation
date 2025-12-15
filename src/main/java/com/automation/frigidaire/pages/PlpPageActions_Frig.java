package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.FE_PLP;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import static com.automation.utils.WaitUtils.untilClickable;

public class PlpPageActions_Frig {

    FE_PLP plpPage_Locator = new FE_PLP();

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

    public PlpPageActions_Frig closePopupModel() {

        try {
            WaitUtils.untilVisible(plpPage_Locator.closePopupButton, 20);
            WebElement closeBtn = untilClickable(plpPage_Locator.closePopupButton, 20);
            if (closeBtn != null) {
                closeBtn.click();
            }
        } catch (Exception ignored) {

        }
        return this;
    }

    public PlpPageActions_Frig storeSelectedProductId() {
        WaitUtils.untilVisible(plpPage_Locator.plpProductId);
        selectedProductId = WebElementUtil.getText(plpPage_Locator.plpProductId);
        return this;
    }

    public PlpPageActions_Frig storeSelectedProductTitle() {
        WaitUtils.untilVisible(plpPage_Locator.plpProductTitle);
        selectedProductTitle = WebElementUtil.getText(plpPage_Locator.plpProductTitle);
        return this;
    }

    public PlpPageActions_Frig storeSelectedProductPrice() {
        WaitUtils.untilVisible(plpPage_Locator.plpProductPrice);
        selectedProductPrice = WebElementUtil.getText(plpPage_Locator.plpProductPrice);
        return this;
    }

    public PlpPageActions_Frig storeSelectedProductReviewNumber() {
        WaitUtils.untilVisible(plpPage_Locator.plpProductReviewNumber);
        selectedProductReviewNumber = WebElementUtil.getText(plpPage_Locator.plpProductReviewNumber);
        return this;
    }

    public PlpPageActions_Frig storeProductDimensions() {
        WaitUtils.untilVisible(plpPage_Locator.plpHeight);
        WaitUtils.untilVisible(plpPage_Locator.plpWidth);
        WaitUtils.untilVisible(plpPage_Locator.plpDepth);

        selectedHeight = WebElementUtil.getText(plpPage_Locator.plpHeight);
        selectedWidth =  WebElementUtil.getText(plpPage_Locator.plpWidth);
        selectedDepth = WebElementUtil.getText(plpPage_Locator.plpDepth);

        return this;
    }

    public FrigidairePdpPageActions clickFirstProduct() {
        WebElementUtil.scrollIntoView(plpPage_Locator.plpProductReview);
        WebElementUtil.clickElement(plpPage_Locator.plpProductReview);
        return new FrigidairePdpPageActions();
    }

    public boolean checkProvidedIdIsVisibleOnPlpPage() {
        WaitUtils.untilVisible(plpPage_Locator.frenchdoorProductId);
        return WebElementUtil.isElementPresented(plpPage_Locator.frenchdoorProductId);
    }

    public PlpPageActions_Frig storeProvidedProductId() {
        WaitUtils.untilVisible(plpPage_Locator.frenchdoorProductIdText);
        providedProductId = WebElementUtil.getText(plpPage_Locator.frenchdoorProductIdText);
        return this;
    }

    public PlpPageActions_Frig storeProvidedProductTitle() {
        WaitUtils.untilVisible(plpPage_Locator.frenchdoorProductTitle);
        providedProductTitle = WebElementUtil.getText(plpPage_Locator.frenchdoorProductTitle);
        return this;
    }

    public PlpPageActions_Frig storeProvidedProductPrice() {
        WaitUtils.untilVisible(plpPage_Locator.frenchdoorProductPrice);
        providedProductPrice = WebElementUtil.getText(plpPage_Locator.frenchdoorProductPrice);
        return this;
    }

    public FrigidairePdpPageActions clickProvidedProduct() {
        WebElementUtil.scrollToElementCenter(plpPage_Locator.frenchdoorProductId);
        WebElementUtil.clickElement(plpPage_Locator.frenchdoorProductId);
        return new FrigidairePdpPageActions();
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