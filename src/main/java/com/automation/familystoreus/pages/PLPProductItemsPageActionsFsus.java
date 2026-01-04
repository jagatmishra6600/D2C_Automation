package com.automation.familystoreus.pages;

import com.automation.familystoreus.locators.PLPProductItemsLocatorFsus;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PLPProductItemsPageActionsFsus {


    PLPProductItemsLocatorFsus plpProductItemsLocatorFsus = new PLPProductItemsLocatorFsus();

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

    public void closeEmailPopUp() {
        try {
            WebElement popup = null;
            try {
                popup = WaitUtils.untilVisible(plpProductItemsLocatorFsus.emailPopUp);
            } catch (TimeoutException e) {
                System.out.println("No email popup detected. Continuing test...");
            }

            if (popup != null && popup.isDisplayed()) {
                WebElementUtil.clickElement(plpProductItemsLocatorFsus.emailPopUp);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("Exception while handling email popup: " + e.getMessage());
        }
    }

    public void clickOnProductMenu(String text) {
        WebDriver driver = DriverManager.getDriver();
        By locator = By.xpath("//span[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(locator));
    }

    public void standardWidthClick() throws InterruptedException {
        WaitUtils.untilVisible(plpProductItemsLocatorFsus.standardWidth, 60);
        WebElementUtil.clickElement(plpProductItemsLocatorFsus.standardWidth);
        Thread.sleep(3000);
    }

    public void clickOnSortByDropDownvalues(String text, String assertValue) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        WaitUtils.untilVisible(plpProductItemsLocatorFsus.sortByDropdownBtn, 60000);
        WebElementUtil.clickElement(plpProductItemsLocatorFsus.sortByDropdownBtn);

        String selectedSortBy = WebElementUtil.findElement(getSortOptionByText(text)).getText();
        WaitUtils.untilVisible(getSortOptionByText(text), 60);
        Assert.assertEquals(selectedSortBy, assertValue);

        WebElementUtil.clickElement(getSortOptionByText(text));
        Thread.sleep(6000);
    }

    public void clickOnLoadMoreBtn() throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        WaitUtils.untilVisible(plpProductItemsLocatorFsus.loadMoreBtn, 60);
        WebElement element = WebElementUtil.findElement(plpProductItemsLocatorFsus.loadMoreBtn);
        WebElementUtil.scrollAndClickUsingJSE(driver, element);
        Thread.sleep(7000);
    }

    public void loadMoreProducts(WebDriver driver) {
        try {
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            WebElement loadMoreElement = WebElementUtil.findElement(plpProductItemsLocatorFsus.loadMoreBtn);

            if (loadMoreElement.isDisplayed()) {
                WebElementUtil.scrollAndClickUsingJSE(driver, loadMoreElement);
                Thread.sleep(5000);
                WebElement productCountElement =
                        WaitUtils.untilVisible(plpProductItemsLocatorFsus.productCount, 40000);
                Assert.assertTrue(productCountElement.isDisplayed());
            }
        } catch (Exception e) {
            System.out.println("Load More not present");
        }
    }

    public By getSortOptionByText(String optionText) {
        return By.xpath("//div[@role='listbox']//span[text()='" + optionText + "']");
    }

    public void validateAvailabilityOfProductsInPLP() {
        WebDriver driver = DriverManager.getDriver();
        WebElementUtil.clickElementUsingJSE(driver, plpProductItemsLocatorFsus.availabilityCheckbox);
        loadMoreProducts(driver);
    }

    public void validateProductIsInStock(By locator) {
        WebElement element = WebElementUtil.waitForElementToBeVisible(locator);
        Assert.assertTrue(element.isDisplayed(), "product is not in Stock!!!");
    }

    public void searchProducts(String skuNumber) {
        WaitUtils.sleep(3000);
        WaitUtils.untilPageLoadComplete();

        WebElementUtil.waitForElementToBeVisible(plpProductItemsLocatorFsus.searchBoxs, 10);
        WebElementUtil.sendKeys(plpProductItemsLocatorFsus.searchBoxs, skuNumber);

        WebElementUtil.waitForElementToBeClickable(plpProductItemsLocatorFsus.searchButton, 10);
        WebElementUtil.clickElement(plpProductItemsLocatorFsus.searchButton);
    }
}
