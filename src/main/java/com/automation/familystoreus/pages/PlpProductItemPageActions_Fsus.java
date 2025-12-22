package com.automation.familystoreus.pages;

import com.automation.familystoreus.locators.PlpFiltersLocator_Fsus;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PlpProductItemPageActions_Fsus {

    WebDriver driver= DriverManager.getDriver();

    public void clickOnProductMenu(String text) {
        By clickNavFilter = PlpFiltersLocator_Fsus.navBarFilter(text);
        WebElement element = driver.findElement(clickNavFilter);
        element.click();
    }

    public void verifyProductItemPage(String text) {
        By locator = PlpFiltersLocator_Fsus.hideAndShowFilter(text);
        WebElementUtil.waitForElementToBeVisible(locator, 60);
        WebElementUtil.getText(locator);
        WebElementUtil.isDisplayed(locator);
    }

    public void verifyHideAndShowAllFilters(String text){
        By locator = PlpFiltersLocator_Fsus.hideAndShowFilter(text);
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.isDisplayed(locator);
        WebElementUtil.clickElement(locator);
    }

    public void verifyHideFilters(String text) {
        By locator =PlpFiltersLocator_Fsus.hideAndShowFilter(text);
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.isDisplayed(locator);
    }

    public void verifyFilterValuesAreHiddenAfterCollapse( String facetName, String filterValue) throws InterruptedException {

        //  WaitUtils.untilVisible(PlpFiltersLocator_Fsus.expandAndCollapseFilter(facetName));
        WebElementUtil.scrollToElementStable(PlpFiltersLocator_Fsus.expandAndCollapseFilter(facetName));
        WebElementUtil.waitForElementToBeVisible(PlpFiltersLocator_Fsus.expandAndCollapseFilter(facetName));
        WebElementUtil.waitForElementToBeClickable(PlpFiltersLocator_Fsus.expandAndCollapseFilter(facetName));
       // WebElementUtil.clickElementUsingJSE(PlpFiltersLocator_Fsus.expandAndCollapseFilter(facetName));
        WebElementUtil.clickElement(PlpFiltersLocator_Fsus.expandAndCollapseFilter(facetName));
        WaitUtils.untilInvisible(PlpFiltersLocator_Fsus.filterName(filterValue),5000);
        Assert.assertFalse(WebElementUtil.isDisplayed(PlpFiltersLocator_Fsus.filterName(filterValue)), "Filter value should NOT be visible after collapse");


    }
    public void verifyFilterValuesAreVisibleAfterExpand( String facetName, String filterValue) throws InterruptedException {

        //  WaitUtils.untilVisible(PlpFiltersLocator_Fsus.expandAndCollapseFilter(facetName));
        WebElementUtil.scrollToElementStable(PlpFiltersLocator_Fsus.expandAndCollapseFilter(facetName));
        WebElementUtil.waitForElementToBeVisible(PlpFiltersLocator_Fsus.expandAndCollapseFilter(facetName));
        WebElementUtil.waitForElementToBeClickable(PlpFiltersLocator_Fsus.expandAndCollapseFilter(facetName));
        // WebElementUtil.clickElementUsingJSE(PlpFiltersLocator_Fsus.expandAndCollapseFilter(facetName));
        WebElementUtil.clickElement(PlpFiltersLocator_Fsus.expandAndCollapseFilter(facetName));
        WaitUtils.untilInvisible(PlpFiltersLocator_Fsus.filterName(filterValue),5000);
        Assert.assertTrue(WebElementUtil.isDisplayed(PlpFiltersLocator_Fsus.filterName(filterValue)), "Filter value should be visible after expand");


    }
}
