package com.automation.frigidaire.locators;

import org.openqa.selenium.By;

public class ProductDetailsLocatorsFrig {


        public final By name(int i) {
            return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='col- Product-Name my-2 min-height-v10']/a");
        }

        public final By skuNumber(int i) {
            return By.xpath("//div[@id='PlpItem" + i + "']//div[contains(@class, 'Utility-TextProduct-SKU-Sm')]/div[1]");
        }

        public final By leftCornerTag(int i) {
            return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='col- highlight-wapper d-flex f-gap-10']/span");
        }

        public final By productName(int i) {
            return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='col- Product-Name my-2 min-height-v10']/a");
        }

        public final By productImage(int i) {
            return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='col- Product-Image-Placeholder']/a//img[1]");
        }

        public final By tagImage(int i) {
            return By.xpath("//div[@id='PlpItem" + i + "']//img[@alt='Frigidaire Gallery' or @alt='Frigidaire Professional']");
        }

        public final By productRating(int i) {
            return By.xpath("//div[@id='PlpItem" + i + "']//div[@id='ReviewsPLPItemComponent']");
        }

        public final By dimensionLabels(int i) {
            return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='col- pimLabels d-flex min-height-v2 mb-3']//span[@class='col-']//span");
        }

        public final By featureSection(int i) {
            return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='col- product-card my-3 plpPriceAlign featureContainer']/div/div");
        }

        public final By discountPrice(int i) {
            return By.xpath("//div[@id='PlpItem" + i + "']//div/span[@class='H3H3_Desktop color-promo-green']");
        }

        public final By originalPrice(int i) {
            return By.xpath("//div[@id='PlpItem" + i + "']//*[self::span[@class='MSRP ml-3'] or self::span[@class='H3H3_Desktop']]");
        }

        public final By msrpTooltipIcon(int i) {
            return By.xpath("//div[@id='PlpItem" + i + "']//span[@class='MSRP ml-3']//div[@class='tooltip-wrapper']");
        }

        public final By compareCheckbox(int i) {
            return By.xpath("//div[@id='PlpItem" + i + "']//input[@type='checkbox']");
        }

        public final By kitAndAccessory(int i) {
            return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='min-height-v3 promotionalContainer']//span");
        }

        public final By colorOption(int i) {
            return By.xpath("//div[@id='PlpItem" + i + "']//div[@class='col- Product-Color-Swatch-wrapper d-flex hidden-class-rac']/a");
        }

        public final By addToCartButton(int i) {
            return By.xpath("//div[@id='PlpItem" + i + "']//div//div//button");
        }


       public final By skuPDPPage = By.xpath("//div[@id='overview']//span[@class='ng-star-inserted']//span");


}
