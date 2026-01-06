package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

public class productCardsLocatorsFsus {

    public By productItemPage(String str) {
        return By.xpath("//h1[normalize-space(text())='" + str + "']");
    }

    public By productMenu(String str) {
        return By.xpath("//h5[normalize-space(text())='" + str + "']");
    }

    public By productSubProduct(String str) {
       return By.xpath("//span[normalize-space(text())='" + str + "']");
    }


    public By leftCornerTag(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='col- highlight-wapper']");
    }

    public By image(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='col- Product-Image-Placeholder']//a");
    }

    public By color(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='col- Product-Color-Swatch-wrapper my-2 d-flex justify-content-center']//a");
    }

    public By sku(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='col- product-card mt-4 mx-3']//div[@class='col-md-5 col-5 p-0 productSkuReview']//div");
    }

    public By rating(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='col- product-card mt-4 mx-3']//div[@class='col-md-7 col-7 p-0 text-right']//div[@class='bv_main_container']");
    }

    public By dimension(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='col- pimLabels d-flex mx-3']//span[@class='col-']//span");
    }

    public By name(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='col- mb-3 mx-3 mt-4 productName']//div");
    }

    public By feature(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='Optional-badges mx-3 1']//div[@class='row']//div");
    }

    public By addToCart(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='col- my-3 mx-3 buttonPLPDesktop']//span");
    }

    public By compareCheckbox(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='col- my-3 mx-3 form-check comparePLP']");
    }

    public By discountPrice(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//span[@class='H3H3_Desktop']");
    }

    public By savingPercentage(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//span[@class='-savings Body-MediumBody_Medium-Spec-List']");
    }

    public By originalPrice(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='MSRP d-flex align-items-end']//span");
    }

    public By priceIcon(int i) {
        return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='MSRP d-flex align-items-end']//div[@class='tooltip-wrapper']//img");
    }
    public By skuPDP = By.xpath("//div[@class=\"pdp-breadcrumb breadcrumb ng-star-inserted\"]//span[@class=\"ng-star-inserted\"]//span");
}
