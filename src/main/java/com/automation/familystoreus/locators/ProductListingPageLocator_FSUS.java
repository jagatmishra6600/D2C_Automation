package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class ProductListingPageLocator_FSUS {

    public final By closePopupButton = By.xpath("//span[contains(@id, 'close-modal')]");
    public final By plpProductId = By.xpath("(//div[@class='ElementsStar-Rating']/../preceding-sibling::div//div)[1]");
    public final By plpProductTitle = By.xpath("(//div[@class='ElementsStar-Rating']/../../../../following-sibling::div/a/div)[1]");
    public final By plpProductPrice = By.xpath("(//span[contains(@class, 'H3H3_Desktop')])[1]");
    public final By plpProductReview = By.xpath("(//div[@class='ElementsStar-Rating'])[1]");
    public final By plpHeight = By.xpath("(//span[contains(text(), 'H:')]/following-sibling::span)[1]");
    public final By plpWidth = By.xpath("(//span[contains(text(), 'W:')]/following-sibling::span)[1]");
    public final By plpDepth = By.xpath("(//span[contains(text(), 'D:')]/following-sibling::span)[1]");

}
