package com.automation.frigidaire.pages;

import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.WebElement;
import com.automation.frigidaire.locators.FE_PLP;

import static com.automation.utils.WaitUtils.untilClickable;

public class FrigidairePlpPageActions {

    FE_PLP plpPage_Locator = new FE_PLP();

    private static String selectedProductId;
    private static String selectedProductTitle;
    private static String selectedProductPrice;
    private static String selectedProductReviewNumber;
    private static String selectedHeight;
    private static String selectedWidth;
    private static String selectedDepth;

    public FrigidairePlpPageActions closePopupModel() {

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

    public FrigidairePlpPageActions storeSelectedProductId() {
        WaitUtils.untilVisible(plpPage_Locator.plpProductId);
        selectedProductId = WebElementUtil.getText(plpPage_Locator.plpProductId);
        return this;
    }

    public FrigidairePlpPageActions storeSelectedProductTitle() {
        WaitUtils.untilVisible(plpPage_Locator.plpProductTitle);
        selectedProductTitle = WebElementUtil.getText(plpPage_Locator.plpProductTitle);
        return this;
    }

    public FrigidairePlpPageActions storeSelectedProductPrice() {
        WaitUtils.untilVisible(plpPage_Locator.plpProductPrice);
        selectedProductPrice = WebElementUtil.getText(plpPage_Locator.plpProductPrice);
        return this;
    }

    public FrigidairePlpPageActions storeSelectedProductReviewNumber() {
        WaitUtils.untilVisible(plpPage_Locator.plpProductReviewNumber);
        selectedProductReviewNumber = WebElementUtil.getText(plpPage_Locator.plpProductReviewNumber);
        return this;
    }

    public FrigidairePlpPageActions storeProductDimensions() {
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

}