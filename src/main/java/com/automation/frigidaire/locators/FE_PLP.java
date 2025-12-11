package com.automation.frigidaire.locators;

import org.openqa.selenium.By;

public class FE_PLP {

    public final By closePopupButton = By.xpath("//span[contains(@id, 'close-modal')]");
    public final By plpProductId = By.xpath("(//div[@id='ReviewsPLPItemComponent']/preceding-sibling::div)[1]");
    public final By plpProductTitle = By.xpath("(//div[@id='ReviewsPLPItemComponent']/../following-sibling::div/a)[1]");
    public final By plpProductPrice = By.xpath("(//div[contains(@class, 'container price')]//span[contains(@class, 'H3H3_Desktop')])[1]");
    public final By plpProductReview = By.xpath("(//div[@id='ReviewsPLPItemComponent'])[1]");
    public final By plpProductReviewNumber = By.xpath("(//div[contains(@class, 'numReviews')]/div)[1]");
    public final By plpHeight = By.xpath("(//span[contains(text(), 'H:')]/following-sibling::span)[1]");
    public final By plpWidth = By.xpath("(//span[contains(text(), 'W:')]/following-sibling::span)[1]");
    public final By plpDepth = By.xpath("(//span[contains(text(), 'D:')]/following-sibling::span)[1]");
    public final By frenchdoorProductId = By.xpath("//div[text()='FRFG1723AV']/following-sibling::div");
    public final By frenchdoorProductIdText = By.xpath("//div[text()='FRFG1723AV']");
    public final By frenchdoorProductTitle =By.xpath("//div[text()='FRFG1723AV']/../following-sibling::div[contains(@class, 'Product-Name')]");
    public final By frenchdoorProductPrice = By.xpath("//div[text()='FRFG1723AV']/../../following-sibling::div[contains(@class, 'card-footer')]/div/div/span[contains(@class, 'H3H3_Desktop')]");
}
