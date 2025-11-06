package com.automation.frigidaire.pages;

import com.automation.frigidaire.enums.FrigidaireConstants;
import com.automation.frigidaire.utils.DriverManager;
import com.automation.frigidaire.utils.WaitUtils;
import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class FAQPage {
    // Defer WebDriver access to runtime to avoid early initialization during test class construction
    By headerLocator = By.xpath("//h1[normalize-space(text())='Owner Center Resource Library']");
    By searchBox = By.xpath("//input[@name=\"queryString\"]");
    By homeComfort=By.xpath("//h3[text()=\"Home Comfort\"]");
    By roomAC=By.xpath("//h3[text()=\"Room AC\"]");
    By refrigeratorsLocators=By.xpath("//h3[text()=\"Refrigerators\"]");
    By kitchenLocators=By.xpath("//h3[text()=\"Kitchen\"]");

    public void clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
    }
    public void verifyFAQHeaderText() {
        String expectedText = "Owner Center Resource Library";
        WebElementUtil.waitForElementToBeVisible(headerLocator);

        WebElement headerElement = WebElementUtil.findElement(headerLocator);
        String actualText = headerElement.getText();
        Assert.assertTrue(actualText.equals(expectedText),
                " Header text mismatch! Expected: '" + expectedText + "' but found: '" + actualText + "'");
    }
    public void verifyFAQSecond(){
        WebElement searchElement = WebElementUtil.findElement(searchBox);
        Assert.assertTrue(searchElement.isDisplayed());
    }

    public void verifyAndClickAllCategoryTiles(){
        List<String> categories = Arrays.asList(
                "Accessories", "Filters", "General Knowledge",
                "Home Comfort", "Kitchen", "Laundry", "Online Orders and Delivery"
        );
        for (String category : categories) {
            clickCategoryTile(category);
        }
    }

    public void clickCategoryTile(String category){
        By tileLocator = By.xpath("//a[@class='group']//h3[text()='" + category + "']");

        WebElementUtil.waitForElementToBeVisible(tileLocator);
        WebElement tileElement = WebElementUtil.findElement(tileLocator);
        Assert.assertTrue(tileElement.isDisplayed(), " Category tile not visible: " + category);

        WebElementUtil.clickElement(tileLocator);
        System.out.println(" Clicked on category tile: " + category);

        By subcategoryHeader = By.xpath("//h1[contains(normalize-space(text()), 'Support for')]");
        WebElementUtil.waitForElementToBeVisible(subcategoryHeader);
        WebElement se= WebElementUtil.findElement(subcategoryHeader);
        String actual= se.getText();

        Assert.assertTrue(actual.contains("Support for "+category));
        WebElementUtil.waitForElementToBeVisible(subcategoryHeader);

        DriverManager.getDriver().navigate().back();
    }
    public void verifySearchBoxVisible(){

        WebElementUtil.zoomInOrOut(60);
        WebElementUtil.waitForElementToBeClickable(kitchenLocators);
        WebElementUtil.clickElement(kitchenLocators);

        WebElementUtil.waitForElementToBeClickable(refrigeratorsLocators);
        WebElementUtil.clickElement(refrigeratorsLocators);

       WebElement element = WaitUtils.untilVisible(By.xpath("//input[@name='queryString']"));
       // element.sendKeys("Test");
        boolean visible = element.isDisplayed();
        System.out.println("Search box visibility: " + visible);
        Assert.assertTrue(visible, "Search box should be visible but it is not. ");
    }

    public void verifySearchBoxVisibles(){

        WebElementUtil.zoomInOrOut(60);
        WebElementUtil.waitForElementToBeClickable(homeComfort);
        WebElementUtil.clickElement(homeComfort);
        WebElementUtil.waitForElementToBeClickable(roomAC);
        WebElementUtil.clickElement(roomAC);
        WebElement searchBox = WaitUtils.untilVisible(By.xpath("//input[@name='queryString']"));



        //WaitUtils.untilVisible(searchBox, 10);
        boolean visible = searchBox.isDisplayed();
        System.out.println("Search box visibility: " + visible);
        Assert.assertTrue(visible, "Search box should be visible but it is not.");
    }

    public void verifyAllFAQArticlesRoomAC() {

        By articleLocator = By.xpath("//div[h2[text()='Recommended articles for Room AC']]//a[2]");
        WebElementUtil.waitForElementToBeVisible(articleLocator);
        WebElementUtil.clickElement(articleLocator);

        WebElement articleLocatorValue= WebElementUtil.findElement(articleLocator);
        String actual=articleLocatorValue.getText();
        System.out.println(actual);
        WaitUtils.untilVisible(articleLocatorValue);
        Assert.assertTrue(FrigidaireConstants.storeFAQRoomAC().contains(actual));
    }

    public void verifyAllFAQArticlesRefrigerator(){
        By articleLocator = By.xpath("//div[h2[text()='Recommended articles for Refrigerators']]//a[2]");
        WebElementUtil.waitForElementToBeVisible(articleLocator);
        WebElementUtil.clickElement(articleLocator);

        WebElement articleLocatorValue= WebElementUtil.findElement(articleLocator);
        WaitUtils.untilVisible(articleLocatorValue);
        String actual=articleLocatorValue.getText();
        System.out.println(actual);
        Assert.assertTrue(FrigidaireConstants.storeFAQRefrigerator().contains(actual));
    }

}


