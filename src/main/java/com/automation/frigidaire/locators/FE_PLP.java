package com.automation.frigidaire.locators;

import org.openqa.selenium.By;

public class FE_PLP {

    public final By closePopupButton = By.xpath("//span[contains(@id, 'close-modal')]");
    public final By plpProductId = By.xpath("(//div[@id='ReviewsPLPItemComponent']/preceding-sibling::div)[1] | (//div[@id='BvProductRating']/../preceding-sibling::div)[1]");
    public final By plpProductTitle = By.xpath("(//div[@id='ReviewsPLPItemComponent']/../following-sibling::div/a)[1] | (//div[@id='BvProductRating']/../../../../following-sibling::div/a)[1]");
    public final By plpProductPrice = By.xpath("(//div[contains(@class, 'container price')]//span[contains(@class, 'H3H3_Desktop')])[1] | (//span[contains(@class, 'H3H3_Desktop')])[1]");
    public final By plpProductReview = By.xpath("(//div[@id='ReviewsPLPItemComponent'])[1] | (//div[@id='BvProductRating'])[1]");
    public final By plpProductReviewNumber = By.xpath("(//div[contains(@class, 'numReviews')]/div)[1]");
    public final By plpHeight = By.xpath("(//span[contains(text(), 'H:')]/following-sibling::span)[1]");
    public final By plpWidth = By.xpath("(//span[contains(text(), 'W:')]/following-sibling::span)[1]");
    public final By plpDepth = By.xpath("(//span[contains(text(), 'D:')]/following-sibling::span)[1]");


    // Static locators accessible from any class
    public static final By EMAIL_POPUP = By.xpath("//span[@id=\"close-modal123\"]");
    public static final By ADD_TO_CART = By.xpath("//span[normalize-space()='Add to cart' and contains(@class,'ng-star-inserted')]");
    public static final By EARLIEST_DELIVERY = By.xpath("//span[contains(text(), 'Earliest delivery:') or contains(text(),'In stock!')]");
    public static final By TEMPORARILY_LOCATOR = By.xpath("//button[span[text()=\"Temporarily Out of Stock\"]]");
    public static final By EMAIL_FIELD_LOCATOR = By.xpath("//input[@name=\"Email\" and contains(@placeholder, \"Enter email\")]");
    public static final By NOTIFY_BTN_LOCATOR = By.xpath("//input[@id=\"submitBtn\" and @name=\"submitBtn\"]");
    public static final By EMAIL_VALIDATION_LOCATOR = By.xpath("//span[contains(normalize-space(.), \"You’re signed up\")]");
    public static final By TEMPORARILY_LOCATOR_AIR_CARE = By.xpath("//span[text()=\"Temporarily out of stock in your area.\"]");

    public static final By SORT_BY_DROPDOWN_BTN = By.xpath("//div[@id='sortByFacet']//div[@class='ng-select-container ng-has-value']");

    public static final By STANDARD_WIDTH = By.xpath("//b[text()=\"Standard Width \"]/ancestor::app-elux-product-facet-list//div[label[div[span[text()=' 36\" ']]]]/input");
    public static final By LOAD_MORE_BTN = By.xpath("//div[@class='row col-12 load-more']//button[text()=' Load more ']");
    public static final By PRODUCT_COUNT = By.xpath("//span[@name='ProductsCount' or @class='totalResults resultsBorder']");

    public static final By VIEW_FULL_SPECS_BTN = By.xpath("//button[text()='View full specs']");
    public static final By QUICK_SPECS = By.xpath("//div[@id='QuickSpecAccrd']");
    public static final By SPECIFICATIONS_HEADING = By.xpath("//h3[text()='Specifications']");

    public static final By RESET_ALL_BUTTON = By.xpath("//span[text()=\" Hide filters\"]/ancestor::div//span[text()=\" Reset all \"]");
    public static final By PRODUCT_UNIQUE_CODE = By.xpath("//h2[@class='prod_id Utility-TextProduct-SKU-Sm ng-star-inserted']");
    public static final By PRODUCT_TITLE = By.xpath("//h1[@class='H1H1_Desktop mt-34 category-heading']");

    public static final By AVAILABILITY_CHECKBOX = By.xpath(
            "//b[contains(text(),'Availability')]/ancestor::app-elux-product-facet-list" +
                    "//div//b[text()='Availability']/parent::div/child::div//input[@aria-label='Availability']"
    );

    public static final By ADD_TO_CART_FOR_PLP = By.xpath(
            "//div[@id='earliestDeliveryDateDiv']/parent::app-elx-earliest-delivery-day-common" +
                    "//following-sibling::div//span[contains(text(),'Add to cart')]"
    );

    public static By getFeatureLocator(String featureKey, String featureValue) {
        return By.xpath("//b[contains(text(),'" + featureKey + "')]/ancestor::app-elux-product-facet-list//div//input[@id='" + featureValue + "']");
    }

    public static By getSelectRoomSizeLocator(String featureKey) {
        return By.xpath("//div[@id='facet-drawer']//div[@id='roomSizeRange-wrapper']//span[text()='" + featureKey + "']/parent::div/preceding-sibling::div");
    }

    public static By getQuickSpecsFeatureLocator(String featureKey, String featureValue) {
        return By.xpath("//span[text()='" + featureKey + "']//parent::div//following-sibling::div//span[contains(text(),'" + featureValue + "')]");
    }

    public static By selectedFilterCross(String filterName) {
        return By.xpath("//span[@class='border border-light p-2 m-2 Body-MediumBody_Medium' and normalize-space(text())='" + filterName + "']//i");
    }


}
