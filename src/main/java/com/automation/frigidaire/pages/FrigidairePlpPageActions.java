package com.automation.frigidaire.pages;

import com.automation.frigidaire.utils.WaitUtils;
import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.automation.frigidaire.utils.WaitUtils.untilClickable;

public class FrigidairePlpPageActions {

    private final By closePopupButton = By.xpath("//span[contains(@id, 'close-modal')]");
    private final By plpProductId = By.xpath("(//div[@id='ReviewsPLPItemComponent']/preceding-sibling::div)[1]");
    private final By plpProductTitle = By.xpath("(//div[@id='ReviewsPLPItemComponent']/../following-sibling::div/a)[1]");
    private final By plpProductPrice = By.xpath("(//div[contains(@class, 'container price')]//span[contains(@class, 'H3H3_Desktop')])[1]");
    private final By plpProductReview = By.xpath("(//div[@id='ReviewsPLPItemComponent'])[1]");
    private final By plpProductReviewNumber = By.xpath("(//div[contains(@class, 'numReviews')]/div)[1]");
    private final By plpHeight = By.xpath("(//span[contains(text(), 'H:')]/following-sibling::span)[1]");
    private final By plpWidth = By.xpath("(//span[contains(text(), 'W:')]/following-sibling::span)[1]");
    private final By plpDepth = By.xpath("(//span[contains(text(), 'D:')]/following-sibling::span)[1]");


    private static String selectedProductId;
    private static String selectedProductTitle;
    private static String selectedProductPrice;
    private static String selectedProductReviewNumber;
    private static String selectedHeight;
    private static String selectedWidth;
    private static String selectedDepth;

    public FrigidairePlpPageActions closePopupModel() {

        try {
            WaitUtils.untilVisible(closePopupButton, 20);
            WebElement closeBtn = untilClickable(closePopupButton, 20);
            if (closeBtn != null) {
                closeBtn.click();
            }
        } catch (Exception ignored) {

        }
        return this;
    }

    public FrigidairePlpPageActions storeSelectedProductId() {
        WaitUtils.untilVisible(plpProductId);
        selectedProductId = WebElementUtil.getText(plpProductId);
        return this;
    }

    public FrigidairePlpPageActions storeSelectedProductTitle() {
        WaitUtils.untilVisible(plpProductTitle);
        selectedProductTitle = WebElementUtil.getText(plpProductTitle);
        return this;
    }

    public FrigidairePlpPageActions storeSelectedProductPrice() {
        WaitUtils.untilVisible(plpProductPrice);
        selectedProductPrice = WebElementUtil.getText(plpProductPrice);
        return this;
    }

    public FrigidairePlpPageActions storeSelectedProductReviewNumber() {
        WaitUtils.untilVisible(plpProductReviewNumber);
        selectedProductReviewNumber = WebElementUtil.getText(plpProductReviewNumber);
        return this;
    }

    public FrigidairePlpPageActions storeProductDimensions() {
        WaitUtils.untilVisible(plpHeight);
        WaitUtils.untilVisible(plpWidth);
        WaitUtils.untilVisible(plpDepth);

        selectedHeight = WebElementUtil.getText(plpHeight);
        selectedWidth =  WebElementUtil.getText(plpWidth);
        selectedDepth = WebElementUtil.getText(plpDepth);

        return this;
    }

    public FrigidairePdpPageActions clickFirstProduct() {
        WebElementUtil.scrollIntoView(plpProductReview);
        WebElementUtil.clickElement(plpProductReview);
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