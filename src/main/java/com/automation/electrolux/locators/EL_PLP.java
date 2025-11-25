package com.automation.electrolux.locators;

import org.openqa.selenium.By;

public class EL_PLP {

    public final By closePopupButton = By.xpath("//span[contains(@id, 'close-modal')]");
    public final By plpProductId = By.xpath("(//div[@id='BvProductRating']/../preceding-sibling::div)[1]");
    public final By plpProductTitle = By.xpath("(//div[@id='BvProductRating']/../../../../following-sibling::div/a)[1]");
    public final By plpProductPrice = By.xpath("(//span[contains(@class, 'H3H3_Desktop')])[1]");
    public final By plpProductReview = By.xpath("(//div[@id='BvProductRating'])[1]");
}
