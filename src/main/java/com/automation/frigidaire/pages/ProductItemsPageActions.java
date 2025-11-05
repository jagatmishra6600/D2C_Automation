package com.automation.frigidaire.pages;

import com.automation.frigidaire.enums.FrigidaireConstants;
import com.automation.frigidaire.utils.DriverManager;
import com.automation.frigidaire.utils.WaitUtils;
import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.NoSuchElementException;

public class ProductItemsPageActions {

    WebDriver driver = DriverManager.getDriver();

    private final By emailPopUp = By.xpath("//span[@id=\"close-modal123\"]");
    private final By addToCart = By.xpath("//span[text()=\" Add to cart \" and @class=\"ng-star-inserted\"]");
    private final By earliestDelivery = By.xpath("//span[contains(text(), 'Earliest delivery:') or contains(text(),'In stock!')]");
    private final By temporarilyLocator = By.xpath("//button[span[text()=\"Temporarily Out of Stock\"]]");
    private final By emailFieldLocator = By.xpath("//input[@name=\"Email\" and contains(@placeholder, \"Enter email\")]");
    private final By notifyBtnLocator = By.xpath("//input[@id=\"submitBtn\" and @name=\"submitBtn\"]");
    private final By emailValidationLocator = By.xpath("//span[contains(normalize-space(.), \"You’re signed up\")]");
    private final By temporarilyLocatorAirCare= By.xpath("//span[text()=\"Temporarily out of stock in your area.\"]");

    public void verifyProductItemPage(String str, String assertValue) {
        By locator = By.xpath("//h1[normalize-space(text())='" + str + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        String s1 = WebElementUtil.getText(locator);
        Assert.assertEquals(s1, assertValue);
    }

    public boolean productIsInStock(String productName) {
        WebElementUtil.zoomInOrOut(10);
        boolean isAvailable = false;
        try {
            By locator = By.xpath("//span[normalize-space(text())='" + productName + "']");
            WebElementUtil.waitForElementToBeClickable(locator);
            WebElementUtil.clickElement(locator);
            isAvailable = true;
        } catch (Exception e) {
            System.out.println("Product NOT FOUND in product list: " + productName);
        }
        WebElementUtil.zoomInOrOut(60);
        return isAvailable;
    }

    public void clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
    }

    public void closeEmailPopUp() {
        WaitUtils.untilVisible(emailPopUp, 60);
        WebElementUtil.clickElement(emailPopUp);
    }

    public void checkAndHandleNotifyMeForKitchen(String productName, String email) {
        boolean inStock = productIsInStock(productName);
        if (inStock) {
                verifyProductInOutStockAndNotifyForKitchen(email);
        } else {
            System.out.println("Product '" + productName + "' is not listed (likely out of stock). Skipping Notify Me tests.");
        }
    }

    public void verifyProductInOutStockAndNotifyForKitchen(String email) {
        try {
            WebElementUtil.waitForElementToBeVisible(addToCart);
            String button = WebElementUtil.getText(addToCart).trim();

            if(button.equalsIgnoreCase(FrigidaireConstants.ADD_TO_CART)){
                WebElementUtil.waitForElementToBeVisible(earliestDelivery);
                String actual = WebElementUtil.getText(earliestDelivery).trim();
                String partialText = FrigidaireConstants.EARLIEST_DATE;
                String partialTextSecond = FrigidaireConstants.IN_STOCK;

                Assert.assertTrue(actual.contains(partialText) || actual.contains(partialTextSecond),
                        "Text does not contain expected substring.");
                System.out.println(actual);

            }
        } catch (Exception e) {
            // Out-of-stock scenario
            WebElementUtil.waitForElementToBeVisible(temporarilyLocator);
            String actual = WebElementUtil.getText(temporarilyLocator).trim();
            String partialText = FrigidaireConstants.TEMPORARILY;
            System.out.println(actual);
            Assert.assertTrue(actual.contains(partialText), "Text does not contain expected substring.");
            try {
                // Notify Me functionality
                WebElement emailField = driver.findElement(emailFieldLocator);
                WebElement notifyBtn = driver.findElement(notifyBtnLocator);
                WaitUtils.untilVisible(emailField);
                emailField.clear();
                emailField.sendKeys(email);
                WaitUtils.untilClickable(notifyBtn);
                notifyBtn.click();

                WebElementUtil.waitForElementToBeVisible(emailValidationLocator);
                WebElement getEmailValidationLocator= driver.findElement(emailValidationLocator);
                String actualEmailValidationText= getEmailValidationLocator.getText();
                System.out.println(actualEmailValidationText);

                Assert.assertTrue(actualEmailValidationText.contains("You’re signed up!"));
                System.out.println(actualEmailValidationText);
                System.out.println("Message displayed: ");

            } catch (Exception notifyException) {
                Assert.fail("Notify Me functionality failed due to exception: " + notifyException.getMessage());
            }
        }
    }

    public void checkAndHandleNotifyMeForAirConditioners(String productName, String email) {
        boolean inStock = productIsInStock(productName);
        if (inStock) {
                verifyProductInOutStockAndNotifyForAirConditioners(email);
        } else {
            System.out.println("Product '" + productName + "' is not listed (likely out of stock). Skipping Notify Me tests.");
        }
    }

    public void verifyProductInOutStockAndNotifyForAirConditioners(String email) {

        try {
            WebElementUtil.waitForElementToBeVisible(addToCart);
            String button = WebElementUtil.getText(addToCart).trim();

            // In-stock scenario
            if (button.equalsIgnoreCase("Add to cart")) {
                WebElementUtil.waitForElementToBeVisible(earliestDelivery);
                String actual = WebElementUtil.getText(earliestDelivery).trim();
                String partialText = "Earliest delivery:";
                String partialTextSecond = "In stock";

                Assert.assertTrue(actual.contains(partialText) || actual.contains(partialTextSecond),
                        "Text does not contain expected substring.");

                System.out.println(actual);

            }
        } catch (Exception e) {
            // Out-of-stock scenario
            WebElementUtil.waitForElementToBeVisible(temporarilyLocatorAirCare);
            String actual = WebElementUtil.getText(temporarilyLocatorAirCare).trim();
            String partialText = FrigidaireConstants.TEMPORARILY_AIR;
            System.out.println(actual);
            Assert.assertTrue(actual.contains(partialText), "Text does not contain expected substring.");

            try {
                // Notify Me functionality
                WebDriver driver = DriverManager.getDriver();
                WebElement emailField = driver.findElement(emailFieldLocator);
                WebElement notifyBtn = driver.findElement(notifyBtnLocator);
                WaitUtils.untilVisible(emailField);
                emailField.clear();
                emailField.sendKeys(email);
                WaitUtils.untilClickable(notifyBtn);
                notifyBtn.click();

                WebElementUtil.waitForElementToBeVisible(emailValidationLocator);
                WebElement emailValidationLocatorText= driver.findElement(emailValidationLocator);
                String actualEmailValidationText= emailValidationLocatorText.getText();
                System.out.println(actualEmailValidationText);
                Assert.assertTrue(actualEmailValidationText.contains("You’re signed up!"));

            } catch (Exception notifyException) {
                Assert.fail("Notify Me functionality failed due to exception: " + notifyException.getMessage());
            }
        }
    }


}
