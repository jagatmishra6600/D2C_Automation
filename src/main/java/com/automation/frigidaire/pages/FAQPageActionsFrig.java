package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.FAQLocatorsFrig;
import com.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import static com.automation.utils.WebElementUtil.*;
import static com.automation.utils.WaitUtils.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FAQPageActionsFrig {

    FAQLocatorsFrig faq = new FAQLocatorsFrig();

    // Defer WebDriver access to runtime to avoid early initialization during test class construction

    private final String headerTextFAQ = "Owner Center Resource Library";

    public void clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        waitForElementToBeVisible(locator);
        waitForElementToBeClickable(locator);
        clickElement(locator);
    }

    public void verifyFAQHeaderText() {
        waitForElementToBeVisible(faq.headerTitle);

        WebElement headerElement = findElement(faq.headerTitle);
        assert headerElement != null;
        Assert.assertEquals(headerElement.getText(), headerTextFAQ, " Header text mismatch! Expected: '" + headerTextFAQ + "' but found:");
    }

    public void verifyFAQSecond() {
        isDisplayed(faq.searchBox);
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

        waitForElementToBeVisible(tileLocator);
        isDisplayed(tileLocator);

        clickElement(tileLocator);

        waitForElementToBeVisible(faq.subcategoryHeader);
        WebElement se = findElement(faq.subcategoryHeader);
        Assert.assertTrue(se != null && se.getText().contains("Support for " + category));

        DriverManager.getDriver().navigate().back();
    }

    public void verifySearchBoxVisible() {

        zoomInOrOut(60);

        waitForElementToBeVisible(faq.kitchenLocators);
        waitForElementToBeClickable(faq.kitchenLocators);
        clickElement(faq.kitchenLocators);

        waitForElementToBeClickable(faq.refrigeratorsLocators);
        clickElement(faq.refrigeratorsLocators);

        WebElement inputBox = untilVisible(faq.searchBox);
        boolean visible = inputBox.isDisplayed();
        Assert.assertTrue(visible, "Search box should be visible but it is not. ");
    }

    public void verifySearchBoxVisibles() {

        zoomInOrOut(60);
        waitForElementToBeVisible(faq.homeComfort);
        waitForElementToBeClickable(faq.homeComfort);
        clickElement(faq.homeComfort);

        waitForElementToBeClickable(faq.roomAC);
        clickElement(faq.roomAC);

        WebElement inputBox = untilVisible(faq.searchBox);
        boolean visible = inputBox.isDisplayed();
        Assert.assertTrue(visible, "Search box should be visible but it is not.");
    }

    public void verifyAllFAQArticlesRoomAC() {

        isDisplayed(faq.articleLocatorRoomAc);

        waitForElementToBeVisible(faq.articleLocatorRoomAc);
        WebElement articleTextRoomAC = findElement(faq.articleLocatorRoomAc);
        String actualTextRoomAC = articleTextRoomAC != null ? articleTextRoomAC.getText() : null;

        clickElement(faq.articleLocatorRoomAc);

        waitForElementToBeVisible(faq.verifyArticleLocator);
        WebElement verifyArticleLocatorText = findElement(faq.verifyArticleLocator);
        String expectedText = verifyArticleLocatorText != null ? verifyArticleLocatorText.getText() : null;

        Assert.assertTrue(actualTextRoomAC != null && actualTextRoomAC.contains(Objects.requireNonNull(expectedText)));

    }

    public void verifyAllFAQArticlesRefrigerator() {

        isDisplayed(faq.articleLocatorRefrigerator);

        waitForElementToBeVisible(faq.articleLocatorRefrigerator);
        WebElement articleLocatorText = findElement(faq.articleLocatorRefrigerator);
        String actualText = articleLocatorText != null ? articleLocatorText.getText() : null;

        clickElement(faq.articleLocatorRefrigerator);

        waitForElementToBeVisible(faq.verifyArticleLocator);
        WebElement verifyArticleLocatorText = findElement(faq.verifyArticleLocator);
        String expectedText = verifyArticleLocatorText != null ? verifyArticleLocatorText.getText() : null;

        Assert.assertTrue(actualText != null && actualText.contains(Objects.requireNonNull(expectedText)));

    }

}


