package com.automation.electrolux.pages;

import com.automation.electrolux.locators.ProductDetailLocatorsElux;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import static com.automation.utils.WaitUtils.untilClickable;

public class ProductDetailPageActionsElux {

    ProductDetailLocatorsElux elPDP = new ProductDetailLocatorsElux();


    SoftAssert softAssert = new SoftAssert();

    public void closeEmailPopUp() {
        try {
            WaitUtils.untilVisible(elPDP.emailPopUp, 60);
            WebElementUtil.clickElement(elPDP.emailPopUp);
        } catch (Exception e) {
            System.out.println(" ");
        }
    }

    public ProductDetailPageActionsElux navigateToHomePage() {
        WebElementUtil.navigateTo(ConfigReader.getAppUrl());
        try {
            WebElement acceptBtn = untilClickable(elPDP.acceptButtonLocator, 15);
            if (acceptBtn != null) {
                acceptBtn.click();
            }
        } catch (Exception ignored) {
            // Cookie banner not present or not interactable; continue
        }
        return this;
    }

    public void clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        WaitUtils.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
    }

    public void verifyProductItemPage(String str, String assertValue) {
        By locator = By.xpath("//h1[normalize-space(text())='" + str + "']");
        WaitUtils.waitForElementToBeVisible(locator);
        String s1 = WebElementUtil.getText(locator);
        Assert.assertEquals(s1, assertValue);
    }

    public void verifyElementDisplayed(By xpath, String elementName) {
        try {
            WebElement element = WaitUtils.waitForElementToBeVisible(xpath,20);

            boolean isDisplayed = element.isDisplayed();
            softAssert.assertTrue(isDisplayed, elementName + " should be displayed.");
        } catch (Exception e) {
            softAssert.fail(elementName + " not found or not displayed.");
        }
    }

    public void verifyProductDetails(int i) {

        verifyElementDisplayed(elPDP.skuNumber(i), "SKU Number");
        verifyElementDisplayed(elPDP.leftCornerTag(i), "Left Corner Tag");
        verifyElementDisplayed(elPDP.productImage(i), "Image");
        verifyElementDisplayed(elPDP.productName(i), "Name");
        verifyElementDisplayed(elPDP.colorOption(i), "Color");
        verifyElementDisplayed(elPDP.rating(i), "Rating");
        verifyElementDisplayed(elPDP.feature(i), "Feature");
        verifyElementDisplayed(elPDP.discountPrice(i), "Discount Price");
        verifyElementDisplayed(elPDP.originalPrice(i), "Original Price");
        verifyElementDisplayed(elPDP.priceIcon(i), "Price Icon");
        verifyElementDisplayed(elPDP.compareBox(i), "Compare Box");
    }


    public void verifyAndClickElements(int i){
        WebElementUtil.zoomInOrOut(80);

        verifyAndClickIfNeeded(elPDP.productImage(i), "Product Image");
        verifyAndClickIfNeeded(elPDP.productName(i), "Product Name");
        verifyAndClickIfNeeded(elPDP.rating(i), "Product Rating");
    }
    private void verifyAndClickIfNeeded( By xpath, String elementName){
        try {
            WebElement element = WaitUtils.waitForElementToBeVisible(xpath, 20);
            if (element.isDisplayed()) {
                WaitUtils.untilClickable(xpath,10);
                element.click();
                WaitUtils.waitForElementToBeVisible(elPDP.skuPDP,10);
                WebElementUtil.isDisplayed(elPDP.skuPDP);

                WaitUtils.sleep(3);
                DriverManager.getDriver().navigate().back();
                WaitUtils.sleep(3);
            }
        } catch (Exception e) {
            System.out.println(elementName + " NOT found or not displayed. Xpath: " + xpath);
        }
    }

    public void checkPlpItem(String ProductName, int i)  {
        WebElementUtil.zoomInOrOut(80);
        WaitUtils.implicitWait(10);

        if(ProductName.equalsIgnoreCase("Vacuums")){
            WebElementUtil.scrollToElementStable(elPDP.productName(i));
            verifyProductDetails(i);
            verifyAndClickElements(i);
        } else if (ProductName.equalsIgnoreCase("Laundry")) {
            WebElementUtil.scrollToElementStable(elPDP.productName(i));
            verifyProductDetails(i);
            verifyAndClickElements(i);
        }

    }

}