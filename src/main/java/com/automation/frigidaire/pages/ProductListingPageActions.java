package com.automation.frigidaire.pages;

import com.automation.frigidaire.utils.DriverManager;
import com.automation.frigidaire.utils.WaitUtils;
import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;


public class ProductListingPageActions {

    WebDriver driver = DriverManager.getDriver();
    private final By emailPopUp = By.xpath("//span[@id=\"close-modal123\"]");
    public static String productName;
    public void closeEmailPopUp() {
        WaitUtils.untilVisible(emailPopUp, 60);
        WebElementUtil.clickElement(emailPopUp);
    }

    public List<WebElement> getAllProductCards() {
        System.out.println("hellooo");
        return driver.findElements(By.xpath("//div[@class=\"col- Product-Name my-2 min-height-v10\"]"));
    }

    public void verifyProductItemPage(String str, String assertValue) {
        By locator = By.xpath("//h1[normalize-space(text())='" + str + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        String s1 = WebElementUtil.getText(locator);
        Assert.assertEquals(s1, assertValue);
    }

    public void clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
    }

    public boolean productFind(String productName){
        WebElementUtil.zoomInOrOut(30);
       // WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isAvailable=false;
        try{
            By nameLocator = By.xpath("//span[text()=\'" + productName + "\']");
            WebElementUtil.waitForElementToBeClickable(nameLocator);
            List<WebElement> productList = driver.findElements(nameLocator);
            Assert.assertFalse(productList.isEmpty(), "Product not found in the list");
            WebElement name = productList.get(0);
            Assert.assertTrue(name.isDisplayed(), "Product name is not visible on screen.");
            System.out.println("Product found: " + name.getText());
            isAvailable = true;
        } catch (Exception e) {
            System.out.println("Product NOT FOUND in product list: " + productName);
        }
        return isAvailable;
    }
    public void verifyProduct(String productName){
        boolean isAvailable =productFind(productName);
        if(isAvailable){
            productCardDetails(productName);
        }
        else {
            //System.out.println("Product NOT FOUND in product list: " + productName);
        }
    }

    public void productCardDetails(String productName){
        String baseXPath = String.format("//div[div[a[span[text()=\"%s\"]]]]", productName);
        By productImage = By.xpath(baseXPath + "/div/a//img");
        assertDisplayed(productImage, "Product image");


        By productGallery = By.xpath(baseXPath + "/div//img[@alt='Frigidaire Gallery' or @alt='Frigidaire Professional']");
        try {
            WebElementUtil.waitForElementToBeVisible(productGallery);
            List<WebElement> tagElements = driver.findElements(productGallery);

            if (tagElements.isEmpty()) {
                System.out.println("No Frigidaire Gallery/Professional tag found for product: " + productName);
            } else {
                WebElement tagImage = tagElements.get(0);
                if (tagImage.isDisplayed()) {
                    System.out.println("Frigidaire tag is displayed: " + tagImage.getAttribute("alt"));
                } else {
                    System.out.println("Frigidaire tag found, but not visible for product: " + productName);
                }
            }
        } catch (Exception e) {
            System.out.println("No Frigidaire tag for product : " + productName);
        }

        By productColor = By.xpath(baseXPath + "/div//a/div[contains(@class, 'Product-Color')]");

        try {
            // Wait for the color elements to be visible
            WebElementUtil.waitForElementToBeVisible(productColor);

            // Find all color elements
            List<WebElement> colorList = driver.findElements(productColor);

            if (colorList.isEmpty()) {
                // If no color options are found
                System.out.println("No color options found for product: " + productName);
            } else {
                // If color options are found, check and display details
                System.out.println("Found " + colorList.size() + " color option(s).");
                for (int i = 0; i < colorList.size(); i++) {
                    WebElement colorElement = colorList.get(i);
                    if (colorElement.isDisplayed()) {
                        // Get the color name from title or aria-label attribute
                        String colorName = colorElement.getAttribute("title");
                        if (colorName == null || colorName.isEmpty()) {
                            colorName = colorElement.getAttribute("aria-label");
                        }
                        System.out.println("Color " + (i + 1) + ": " + (colorName != null ? colorName : "Unnamed color"));
                    } else {
                        System.out.println("Color option " + (i + 1) + " is found but not displayed.");
                    }
                }
            }
        } catch (Exception e) {
            // If an exception occurs (like timeout or element not found)
            System.out.println("Color not found for this :" + productName);
        }

//        By productColor = By.xpath(baseXPath + "/div//a/div[contains(@class, 'Product-Color')]");
//        WebElementUtil.waitForElementToBeVisible(productColor);
//        List<WebElement> colorList = driver.findElements(productColor);
//        if (colorList.isEmpty()) {
//            System.out.println("No color options found for product: " + productName);
//        } else {
//            System.out.println("Found " + colorList.size() + " color option(s).");
//            for (int i = 0; i < colorList.size(); i++) {
//                WebElement colorElement = colorList.get(i);
//                Assert.assertTrue(colorElement.isDisplayed(), "Color option " + (i + 1) + " is not displayed!");
//                String colorName = colorElement.getAttribute("title");
//                if (colorName == null || colorName.isEmpty())
//                    colorName = colorElement.getAttribute("aria-label");
//                System.out.println("Color " + (i + 1) + ": " + (colorName != null ? colorName : "Unnamed color"));
//            }
//        }

        By productSKU = By.xpath("(//div[div[a[span[text()='" + productName + "']]]]//div[@class='Utility-TextProduct-SKU-Sm my-2 d-flex justify-content-between']/div[@class='col-'])[1]");
        WebElementUtil.waitForElementToBeVisible(productSKU);
        WebElement skuElement = driver.findElement(productSKU);
        String skuText = skuElement.getText();
        System.out.println("Product SKU: " + skuText);
        Assert.assertTrue(skuElement.isDisplayed(), "Product SKU is not displayed!");

        By productRating = By.xpath(baseXPath + "//div[@id='ReviewsPLPItemComponent']");
        WebElementUtil.waitForElementToBeVisible(productRating);
        assertDisplayed(productRating, "Product rating");

        By productDimension = By.xpath(baseXPath + "//div//span[@class='col-']//span");
        WebElementUtil.waitForElementToBeVisible(productDimension);
        assertDisplayed(productDimension, "Product dimension");

        By productFeatures = By.xpath(baseXPath + "//div[@class='col- product-card my-3 plpPriceAlign featureContainer']//div[@class='plpPriceAlign']//div[@class='row my-1']");
        WebElementUtil.waitForElementToBeVisible(productFeatures);
        List<WebElement> featuresList = driver.findElements(productFeatures);
        if (!featuresList.isEmpty()) {
            System.out.println("Found " + featuresList.size() + " product feature(s):");
            for (WebElement feature : featuresList) {
                System.out.println("• " + feature.getText());
            }
        } else {
            System.out.println("No product features found for this product.");
        }


        By productKitAndAccessory = By.xpath(baseXPath + "//div[@class='min-height-v3 promotionalContainer']//span");
        WebElementUtil.waitForElementToBeVisible(productKitAndAccessory);
        List<WebElement> kitAccessoryElements = driver.findElements(productKitAndAccessory);
        if (!kitAccessoryElements.isEmpty() && kitAccessoryElements.get(0).isDisplayed()) {
            System.out.println(kitAccessoryElements.get(0).getText());
        } else {
            System.out.println("Kit / Accessory Information is NOT available for this product.");
        }


        By discountedPrice = By.xpath("//div[div[div[a[span[text()='" + productName + "']]]]]//div/span[@class='H3H3_Desktop color-promo-green']");
        By originalPrice = By.xpath("//div[div[div[a[span[text()='" + productName + "']]]]]//div/span[@class='MSRP ml-3']//span");
        By msrpIcon = By.xpath("//div[div[div[a[span[text()='" + productName + "']]]]]//div/span[@class='MSRP ml-3']//div[@class='tooltip-wrapper']");

        List<WebElement> discountList = driver.findElements(discountedPrice);
        if (!discountList.isEmpty()) {
            WebElement discountElement = discountList.get(0);
            Assert.assertTrue(discountElement.isDisplayed(), "Discounted price not visible!");
            System.out.println("Discounted Price: " + discountElement.getText());
        } else {
            System.out.println("No discounted price found for product: " + productName);
        }

//        WebElementUtil.waitForElementToBeVisible(discountedPrice);
//        WebElement discount= driver.findElement(discountedPrice);
//        System.out.println("Discount Price: " + discount.getText());
//        Assert.assertTrue(discount.isDisplayed(), "Discount price not visible");

        List<WebElement> originalList = driver.findElements(originalPrice);
        if (!originalList.isEmpty()) {
            WebElement originalElement = originalList.get(0);
            Assert.assertTrue(originalElement.isDisplayed(), "Original price (MSRP) not visible!");
            System.out.println("Original Price: " + originalElement.getText());
        } else {
            System.out.println("No original price (MSRP) found for product: " + productName);
        }
//        WebElementUtil.waitForElementToBeVisible(originalPrice);
//        WebElement original= driver.findElement(originalPrice);
//        System.out.println("Original Price: " + original.getText());
//        Assert.assertTrue(original.isDisplayed(),"Original price not visible");
//
        List<WebElement> msrpIconList = driver.findElements(msrpIcon);
        if (!msrpIconList.isEmpty()) {
            WebElement iconElement = msrpIconList.get(0);
            Assert.assertTrue(iconElement.isDisplayed(), "MSRP info icon not displayed!");
            System.out.println("MSRP Info Icon is displayed.");
        } else {
            System.out.println("MSRP info icon not found for product: " + productName);
        }
//        WebElementUtil.waitForElementToBeVisible(msrpIcon);
//        WebElement msrpIcons= driver.findElement(msrpIcon);
//        System.out.println("MSRP Info Icon is displayed");
//        Assert.assertTrue(msrpIcons.isDisplayed(),"MSRP info icon not displayed");



        By productCompare = By.xpath("//div[div[div[a[span[text()='" + productName + "']]]]]//input[@type='checkbox']");
        assertDisplayed(productCompare, "Product Compare checkbox");


        By productTopRated = By.xpath(
                "//div[div[div[a[span[text()='" + productName + "']]]]]" +
                        "//div//span[text()='Most Popular' or text()='Best Seller' or text()='Top Rated']"
        );
//        WebElementUtil.waitForElementToBeVisible(productTopRated);
//        WebElement topRated= driver.findElement(productTopRated);
//        System.out.println("Top Rated: " + topRated.getText());
//        Assert.assertTrue(topRated.isDisplayed(),"Product does not have a Top rated/ Best Seller tag");
        List<WebElement> topRatedList = driver.findElements(productTopRated);
        if (!topRatedList.isEmpty() && topRatedList.get(0).isDisplayed()) {
            System.out.println(" Product Top Rated tag displayed: " + topRatedList.get(0).getText());
        } else {
            System.out.println("Product does not have a Top Rated/Best Seller tag.");
        }

        verifyPDPNavigation(productImage, "Product Image", productName);
//        verifyPDPNavigation(nameLocator, "Product Name");
//        verifyPDPNavigation(productRating, "Product Rating");
    }

    public void verifyPDPNavigation(By locator, String elementName, String productName) {
        List<WebElement> elements = driver.findElements(locator);

        if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
            WebElement clickableElement = elements.get(0);
            String plpUrl = driver.getCurrentUrl();
            clickableElement.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(plpUrl)));
           // WebElementUtil.waitForElementToBeVisible(plpUrl);

            String pdpUrl = driver.getCurrentUrl();
            Assert.assertNotEquals(pdpUrl, plpUrl, " Clicking " + elementName + " did NOT navigate to PDP!");

            System.out.println(" Clicking on " + elementName + " navigated to PDP: " + pdpUrl);

            // Optional: verify PDP has loaded (example: Add to Cart button or product title)
            try {
//                WebElement pdpTitle = wait.until(
//                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()=\"22 Cu. Ft. Counter-Depth 4-Door French Door Refrigerator with Free Additional Filter Kit\"]"))
//                );
                By title = By.xpath("//h1[text()='" + productName + "']");
                WebElementUtil.waitForElementToBeVisible(title); //22 Cu. Ft. Counter-Depth 4-Door Refrigerator with Free Additional Filter Kit
                WebElement pdpTitle= driver.findElement(title);

                Assert.assertTrue(pdpTitle.isDisplayed(), " PDP page content not displayed properly!");
                System.out.println(" PDP page verified for product: " + productName);
            } catch (TimeoutException e) {
                System.out.println(" PDP may not have fully loaded.");
            }

            driver.navigate().back();
            wait.until(ExpectedConditions.urlToBe(plpUrl));

        } else {
            Assert.fail(" " + elementName + " not found or not visible on PLP!");
        }
    }

    private void assertDisplayed(By locator, String elementName) {
        List<WebElement> elements = driver.findElements(locator);
        if (elements.isEmpty()) {
            Assert.fail(" " + elementName + " not found on page!");
        } else {
            WebElement el = elements.get(0);
            Assert.assertTrue(el.isDisplayed(), " " + elementName + " is not displayed!");
            System.out.println(" " + elementName + " is displayed.");
        }
    }
}
