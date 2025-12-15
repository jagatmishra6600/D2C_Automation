package com.automation.familystoreus.pages;

import com.automation.familystoreus.locators.productCardsLocatorsFsus;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ProductCardsPageActionFsus {

    productCardsLocatorsFsus productDetails = new productCardsLocatorsFsus();
    SoftAssert softAssert=new SoftAssert();


    public void verifyProductItemPage(String str, String assertValue) {
        By locator = By.xpath("//h1[normalize-space(text())='" + str + "']");
        WebElementUtil.waitForElementToBeVisible(locator,10);
        String s1 = WebElementUtil.getText(locator);
        Assert.assertEquals(s1, assertValue);
    }

    public void clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator,10);
        WebElementUtil.waitForElementToBeClickable(locator,10);
        WebElementUtil.clickElement(locator);
    }
    public void clickOnProductSubMenu(String text) {
        By locator = By.xpath("//span[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator,10);
        WebElementUtil.waitForElementToBeClickable(locator,10);
        WebElementUtil.clickElement(locator);
    }

    public void verifyAndClickElements(int i) {
        WebElementUtil.zoomInOrOut(70);

        verifyAndClickIfNeeded(productDetails.image(i), "Product Image");
        verifyAndClickIfNeeded(productDetails.name(i), "Product Name");
        verifyAndClickIfNeeded(productDetails.rating(i), "Product Rating");
    }
    private void verifyAndClickIfNeeded( By xpath, String elementName){
        WaitUtils.implicitWait(3);
        try {
            WebElement element = WebElementUtil.waitForElementToBeVisible(xpath,10);


            if (element.isDisplayed()) {
                element.click();
                WebElementUtil.waitForElementToBeVisible(productDetails.skuPDP,10);
                WebElementUtil.isDisplayed(productDetails.skuPDP);

                WaitUtils.implicitWait(2);
                DriverManager.getDriver().navigate().back();
                WaitUtils.implicitWait(2);
            }
        } catch (Exception e) {
            System.out.println(elementName + " NOT found or not displayed. Xpath: " + xpath);
        }
    }

    public void checkPlpItem(String ProductName, int i){
        WebElementUtil.zoomInOrOut(70);
        WaitUtils.implicitWait(10);
        if(ProductName.equalsIgnoreCase("Vacuums")){
            WebElementUtil.scrollToElementStable(productDetails.name(i));
            checkProductDetail(i);
            verifyAndClickElements(i);
        } else if (ProductName.equalsIgnoreCase("Laundry")) {
            WebElementUtil.scrollToElementStable(productDetails.name(i));
            checkProductDetail(i);
            verifyAndClickElements(i);
        }

    }
    public void checkProductDetail(int i) {

        verifyElementDisplayed(productDetails.sku(i), "SKU Number");
        verifyElementDisplayed(productDetails.leftCornerTag(i), "Left Corner Tag");
        verifyElementDisplayed(productDetails.name(i), "Product Name");
        verifyElementDisplayed(productDetails.color(i), "Color Option");
        verifyElementDisplayed(productDetails.image(i), "Product Image");
        verifyElementDisplayed(productDetails.rating(i), "Product Rating");
        verifyElementDisplayed(productDetails.dimension(i), "Dimension Label");
        verifyElementDisplayed(productDetails.feature(i), "Feature Section");
        verifyElementDisplayed(productDetails.discountPrice(i), "Discount Price");
        verifyElementDisplayed(productDetails.originalPrice(i), "Original Price");
        verifyElementDisplayed(productDetails.savingPercentage(i), "Saving Percentage");
        verifyElementDisplayed(productDetails.priceIcon(i), "Price Icon");
        verifyElementDisplayed(productDetails.addToCart(i), "Add to Cart");
        verifyElementDisplayed(productDetails.compareCheckbox(i), "Compare Checkbox");
    }

    public void verifyElementDisplayed(By xpath, String elementName) {
        try {
            WebElementUtil.waitForElementToBeVisible(xpath,10);
            boolean isDisplayed = WebElementUtil.isDisplayed(xpath);
            softAssert.assertTrue(isDisplayed, elementName + " should be displayed.");
        } catch (Exception e) {
            softAssert.fail(elementName + " not found or not displayed. Exception: " + e.getMessage());
        }
    }

}
