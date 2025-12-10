package com.automation.frigidaire.locators;

import org.openqa.selenium.By;

public class FE_PDP {
    public final By productIdOnPDP = By.xpath("//h2[contains(@class, 'prod_id')] | //p[contains(@class, 'prod_id')]");
    public final By productTitleOnPDP = By.xpath("//h2[contains(@class, 'prod_id')]/preceding-sibling::h1 | //p[contains(@class, 'prod_name Product-title')]");
    public final By productPriceOnPDP = By.xpath("//span[contains(@class, 'Utility-TextPrice-Sale-Lrg')] | //span[contains(@class, 'H3H3_Desktop ')]");
    public final By productReviewNumberOnPDP = By.xpath("(//div[contains(@class, 'numReviews')]/div)[1]");
    public final By productColorOnPDP = By.xpath("//div[@id='color'] | //span[@class='colorHeading']");
    public final By pdpHeight = By.xpath("//p[contains(text(),'Height')]/span[2] | //div[normalize-space(text())='Height']");
    public final By pdpWidth = By.xpath("//p[contains(text(),'Width')]/span[2] | //div[normalize-space(text())='Width']");
    public final By pdpDepth = By.xpath("//p[contains(text(),'Depth')]/span[2] | //div[normalize-space(text())='Depth']");
    public final By quickSpecificationBtnOnPDP = By.xpath("//strong[text()='Quick Specs']/../../../following-sibling::div/span/span");
    public final By quickSpecSeeAll = By.xpath("//p[text()='See all']");
    public final By overViewAndFeatures = By.xpath("//strong[text()='Overview & Features']");
    public final By frenchdoorDelivery = By.xpath("//span[normalize-space(text()) = 'Delivery']");
    public final By addToCartButton = By.xpath("(//span[normalize-space(text()) = 'Add to cart'])[2]");
}
