package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.ProductDetailsLocatorsFrig;
import com.automation.utils.DriverManager;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static com.automation.utils.WaitUtils.*;
import static com.automation.utils.WebElementUtil.*;


public class ProductDetailPageActionsFrig {

    ProductDetailsLocatorsFrig productDetails = new ProductDetailsLocatorsFrig();
    SoftAssert softAssert = new SoftAssert();


    public void verifyProductItemPage(String str, String assertValue) {
        By locator = By.xpath("//h1[normalize-space(text())='" + str + "']");
        waitForElementToBeVisible(locator);
        String s1 = getText(locator);
        Assert.assertEquals(s1, assertValue);
    }

    public void clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        waitForElementToBeVisible(locator);
        waitForElementToBeClickable(locator);
        clickElement(locator);
    }

    public void verifyAndClickElements(int i) throws InterruptedException {
        zoomInOrOut(70);

        verifyAndClickIfNeeded(productDetails.productImage(i), "Product Image");
        verifyAndClickIfNeeded(productDetails.name(i), "Product Name");
        verifyAndClickIfNeeded(productDetails.productRating(i), "Product Rating");
    }

    private void verifyAndClickIfNeeded(By xpath, String elementName) {
        implicitWait(3);
        try {
            WebElement element = waitForElementToBeVisible(xpath);


            if (element.isDisplayed()) {
                element.click();
                waitForElementToBeVisible(productDetails.skuPDPPage);
                isDisplayed(productDetails.skuPDPPage);

                implicitWait(10);
                DriverManager.getDriver().navigate().back();
                implicitWait(10);
            }
        } catch (Exception e) {
            System.out.println(elementName + " NOT found or not displayed. Xpath: " + xpath);
        }
    }

    public void checkPlpItem(String ProductName, int i) throws InterruptedException {
        zoomInOrOut(70);
        implicitWait(10);
        if (ProductName.equalsIgnoreCase("Kitchen")) {
            scrollToElementStable(productDetails.name(i));
            checkProductDetail(i);
            verifyKitchenDetails(i);
            verifyAndClickElements(i);
        } else if (ProductName.equalsIgnoreCase("Air Care")) {
            scrollToElementStable(productDetails.name(i));
            checkProductDetail(i);
            verifyAirCareDetails(i);
            verifyAndClickElements(i);
        }

    }

    public void checkProductDetail(int i) {

        verifyElementDisplayed(productDetails.skuNumber(i), "SKU Number");
        verifyElementDisplayed(productDetails.leftCornerTag(i), "Left Corner Tag");
        verifyElementDisplayed(productDetails.productName(i), "Product Name");

        verifyElementDisplayed(productDetails.productImage(i), "Product Image");
        verifyElementDisplayed(productDetails.tagImage(i), "Tag Image");

        verifyElementDisplayed(productDetails.productRating(i), "Product Rating");
        verifyElementDisplayed(productDetails.dimensionLabels(i), "Dimension Label");

        verifyElementDisplayed(productDetails.featureSection(i), "Feature Section");
        verifyElementDisplayed(productDetails.discountPrice(i), "Discount Price");
        verifyElementDisplayed(productDetails.originalPrice(i), "Original Price");
        verifyElementDisplayed(productDetails.msrpTooltipIcon(i), "MSRP Tooltip Icon");

        verifyElementDisplayed(productDetails.compareCheckbox(i), "Compare Checkbox");
    }

    public void verifyKitchenDetails(int i) {
        verifyElementDisplayed(productDetails.kitAndAccessory(i), "Kit and Accessory");
        verifyElementDisplayed(productDetails.colorOption(i), "Color Option");
    }

    public void verifyAirCareDetails(int i) {
        verifyElementDisplayed(productDetails.addToCartButton(i), "Add to Cart");
    }


    public void verifyElementDisplayed(By xpath, String elementName) {
        try {
            WebElement element = waitForElementToBeVisible(xpath);
            boolean isDisplayed = element.isDisplayed();
            softAssert.assertTrue(isDisplayed, elementName + " should be displayed.");
        } catch (Exception e) {
            softAssert.fail(elementName + " not found or not displayed. Exception: " + e.getMessage());
        }
    }

}
