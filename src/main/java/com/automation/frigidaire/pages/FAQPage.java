package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.FrigidaireFAQ;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class FAQPage {

    FrigidaireFAQ faq = new FrigidaireFAQ();

    // Defer WebDriver access to runtime to avoid early initialization during test class construction

    private final String headerTextFAQ = "Owner Center Resource Library";

    public void clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
    }

    public void verifyFAQHeaderText() {
        WebElementUtil.waitForElementToBeVisible(faq.headerTitle);

        WebElement headerElement = WebElementUtil.findElement(faq.headerTitle);
        String actualText = headerElement.getText();
        Assert.assertTrue(actualText.equals(headerTextFAQ),
                " Header text mismatch! Expected: '" + headerTextFAQ + "' but found: '" + actualText + "'");
    }

    public void verifyFAQSecond() {
        WebElementUtil.isDisplayed(faq.searchBox);
    }

    public void verifyAndClickAllCategoryTiles() {
        List<String> categories = Arrays.asList(
                "Accessories", "Filters", "General Knowledge",
                "Home Comfort", "Kitchen", "Laundry", "Online Orders and Delivery"
        );
        for (String category : categories) {
            clickCategoryTile(category);
        }
    }

    public void clickCategoryTile(String category) {
        By tileLocator = By.xpath("//a[@class='group']//h3[text()='" + category + "']");

        WebElementUtil.waitForElementToBeVisible(tileLocator);
        WebElement tileElement = WebElementUtil.findElement(tileLocator);
        Assert.assertTrue(tileElement.isDisplayed(), " Category tile not visible: " + category);

        WebElementUtil.clickElement(tileLocator);

        WebElementUtil.waitForElementToBeVisible(faq.subcategoryHeader);
        WebElement se = WebElementUtil.findElement(faq.subcategoryHeader);
        String actual = se.getText();
        Assert.assertTrue(actual.contains("Support for " + category));

        DriverManager.getDriver().navigate().back();
    }

    public void verifySearchBoxVisible() {

        WebElementUtil.zoomInOrOut(60);

        WebElementUtil.waitForElementToBeClickable(faq.kitchenLocators);
        WebElementUtil.clickElement(faq.kitchenLocators);

        WebElementUtil.waitForElementToBeClickable(faq.refrigeratorsLocators);
        WebElementUtil.clickElement(faq.refrigeratorsLocators);

        WebElement inputBox = WaitUtils.untilVisible(faq.searchBox);
        boolean visible = inputBox.isDisplayed();
        Assert.assertTrue(visible, "Search box should be visible but it is not. ");
    }

    public void verifySearchBoxVisibles() {

        WebElementUtil.zoomInOrOut(60);
        WebElementUtil.waitForElementToBeClickable(faq.homeComfort);
        WebElementUtil.clickElement(faq.homeComfort);

        WebElementUtil.waitForElementToBeClickable(faq.roomAC);
        WebElementUtil.clickElement(faq.roomAC);

        WebElement inputBox = WaitUtils.untilVisible(faq.searchBox);
        boolean visible = inputBox.isDisplayed();
        Assert.assertTrue(visible, "Search box should be visible but it is not.");
    }

    public void verifyAllFAQArticlesRoomAC() {

        WebElementUtil.isDisplayed(faq.articleLocatorRoomAc);

        WebElementUtil.waitForElementToBeVisible(faq.articleLocatorRoomAc);
        WebElement articleTextRoomAC = WebElementUtil.findElement(faq.articleLocatorRoomAc);
        String actualTextRoomAC = articleTextRoomAC.getText();

        WebElementUtil.clickElement(faq.articleLocatorRoomAc);

        WebElementUtil.waitForElementToBeVisible(faq.verifyArticleLocator);
        WebElement verifyArticleLocatorText = WebElementUtil.findElement(faq.verifyArticleLocator);
        String expectedText = verifyArticleLocatorText.getText();

        Assert.assertTrue(actualTextRoomAC.contains(expectedText));

    }

    public void verifyAllFAQArticlesRefrigerator() {

        WebElementUtil.isDisplayed(faq.articleLocatorRefrigerator);

        WebElementUtil.waitForElementToBeVisible(faq.articleLocatorRefrigerator);
        WebElement articleLocatorText = WebElementUtil.findElement(faq.articleLocatorRefrigerator);
        String actualText = articleLocatorText.getText();

        WebElementUtil.clickElement(faq.articleLocatorRefrigerator);

        WebElementUtil.waitForElementToBeVisible(faq.verifyArticleLocator);
        WebElement verifyArticleLocatorText = WebElementUtil.findElement(faq.verifyArticleLocator);
        String expectedText = verifyArticleLocatorText.getText();

        Assert.assertTrue(actualText.contains(expectedText));

    }

}


