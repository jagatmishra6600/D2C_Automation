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
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        WebElementUtil.scrollToElementStable(locator);
        WebElementUtil.waitForElementToBeVisible(locator,20);
        WebElementUtil.waitForElementToBeClickable(locator,20);
        WebElementUtil.clickElement(locator);
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

    public void verifyProductItemPage(String str, String assertValue) throws InterruptedException {
        By locator = By.xpath("//h1[normalize-space(text())='" + str + "']");
        WaitUtils.untilPageLoadComplete();
        Thread.sleep(16000);
        WebElementUtil.scrollToElementStable(locator);
        WebElementUtil.waitForElementToBeVisible(locator,10);
        String s1 = WebElementUtil.getText(locator);
        Assert.assertEquals(s1, assertValue);
    }


    public void clickOnProductSubMenu(String text) {
        By locator = By.xpath("(//span[normalize-space()='" + text + "'])[1]");
        WebElementUtil.scrollToElementStable(locator);
        WebElementUtil.waitForElementToBeVisible(locator,20);
        WebElementUtil.waitForElementToBeClickable(locator,20);
        WebElementUtil.clickElement(locator);
    }

    public void verifyPriceHighToLowSort() {
        WebDriver driver = DriverManager.getDriver();

        try {
            loadMoreProducts(driver);
            List<WebElement> products = WebElementUtil.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
            int totalProducts = products.size();
            System.out.println("Total products found: " + totalProducts);

            List<Double> productPrices = new ArrayList<>();

            for (int i = 0; i < totalProducts; i++) {
                String priceXpath;


                priceXpath = "//div[@id='PlpItem" + i + "']//span[@class=\"H3H3_Desktop saleprice\"or @class=\"H3H3_Desktop\"]";
                System.out.println(priceXpath);


                WebElement priceElement = WebElementUtil.findElement(By.xpath(priceXpath));

                if (priceElement != null) {
                    String priceText = priceElement.getText().trim();
                    double priceValue = parsePrice(priceText);
                    System.out.println("Product " + i + " - Price: $" + priceValue);
                    productPrices.add(priceValue);
                } else {
                    Assert.fail("Price element not found for product " + i);
                }
            }

            for (int i = 0; i < productPrices.size() - 1; i++) {
                Assert.assertTrue(productPrices.get(i) >= productPrices.get(i + 1), "Prices are not in descending order. Product " + i + " price: $" + productPrices.get(i) + ", Product " + (i + 1) + " price: $" + productPrices.get(i + 1));
            }

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }


    private double parsePrice(String priceText) {
        if (priceText == null || priceText.trim().isEmpty()) {
            return 0.0;
        }

        try {
            priceText = priceText.replaceAll("[^0-9.]", "");
            if (priceText.isEmpty()) return 0.0;
            return Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            System.out.println(" Could not parse price text: '" + priceText + "'");
            return 0.0;
        }
    }
    public void verifyPriceLowToHighSort() {
        WebDriver driver = DriverManager.getDriver();

        try {
            loadMoreProducts(driver);

            List<WebElement> products =
                    WebElementUtil.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));

            int totalProducts = products.size();
            System.out.println("Total products found: " + totalProducts);

            List<Double> productPrices = new ArrayList<>();

            for (int i = 0; i < totalProducts; i++) {

                String priceXpath =
                        "//div[@id='PlpItem" + i + "']//span[contains(@class,'H3H3_Desktop')]";

                WebElement priceElement = WebElementUtil.findElement(By.xpath(priceXpath));

                if (priceElement != null) {
                    String priceText = priceElement.getText().trim();
                    double priceValue = parsePrice(priceText);

                    System.out.println("Product " + i + " - Price: $" + priceValue);
                    productPrices.add(priceValue);
                } else {
                    Assert.fail("Price element not found for product " + i);
                }
            }

            // Verify ascending order
            for (int i = 0; i < productPrices.size() - 1; i++) {
                Assert.assertTrue(
                        productPrices.get(i) <= productPrices.get(i + 1),
                        "Prices not sorted Low to High at index " + i
                );
            }

            System.out.println("Verified Price Low to High sorting for Electrolux");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    public void verifyBiggestSavingsSort() {
        WebDriver driver = DriverManager.getDriver();

        try {
            loadMoreProducts(driver);

            List<WebElement> products =
                    WebElementUtil.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));

            int totalProducts = products.size();
            List<Double> productSavings = new ArrayList<>();

            for (int i = 0; i < totalProducts; i++) {

                String actualPriceXpath =
                        "//div[@id='PlpItem" + i + "']//span[@class='H3H3_Desktop' or @class='CTA-Text-ELE-Blue-Mid']";

                String discountedPriceXpath =
                        "//div[@id='PlpItem" + i + "']//span[@class='-savings Body-MediumBody_Medium-Spec-List']";

                List<WebElement> actualPriceElements =
                        WebElementUtil.findElements(By.xpath(actualPriceXpath));

                List<WebElement> discountedPriceElements =
                        WebElementUtil.findElements(By.xpath(discountedPriceXpath));

                double actualPrice =
                        parsePrice(getTextSafe(actualPriceElements, 0));

                String discountedText = getTextSafe(discountedPriceElements, 0);

                // Assuming the savings text is in the format "47% savings"
                double savings = 0.0;
                if (discountedText != null && !discountedText.isEmpty()) {
                    // Extract the percentage number from the string (remove % and convert to double)
                    String savingsString = discountedText.replaceAll("[^\\d.]", "");
                    try {
                        savings = Double.parseDouble(savingsString);
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing savings for product " + i);
                        continue;
                    }
                }

                System.out.println(
                        "Product " + i +
                                " - Actual: $" + actualPrice +
                                ", Discounted: " + discountedText +
                                ", Savings: " + savings + "%"
                );

                productSavings.add(savings);
            }

            // Verify descending order
            for (int i = 0; i < productSavings.size() - 1; i++) {
                Assert.assertTrue(
                        productSavings.get(i) >= productSavings.get(i + 1),
                        "Biggest Savings not sorted correctly at index " + i
                );
            }

            System.out.println("Verified Biggest Savings sorting for Electrolux");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }


    private String getTextSafe(List<WebElement> elements, int index) {
        try {
            if (elements != null && elements.size() > index) {
                return elements.get(index).getText().trim();
            }
        } catch (Exception ignored) {
        }
        return "";
    }

    private final By viewFullSpecsBtn = By.xpath("//button[text()='View full specs']");
    public void verifyHideAndShowAllFilters(String text) throws InterruptedException {
        By locator = By.xpath("//span[normalize-space(text())='" + text + "']");

        WebElementUtil.waitForElementToBeVisible(locator,30);
        Thread.sleep(5000);
        WebElementUtil.scrollToElementStable(locator);
        WebElementUtil.isDisplayed(locator);
        WebElementUtil.clickElement(locator);
    }

    public void verifyHideFilters(String text) {
        By locator = By.xpath("//span[normalize-space(text())='" + text + "']");
        WebElement element = WebElementUtil.waitForElementToBeVisible(locator,30);
        Assert.assertTrue(element.isDisplayed(), "Not able to load Filter in the page");

    }

    public void verifyExpandAndCollapseFilter(String facetName, String filterValue) {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        String facetXPath =
                "//span[normalize-space(text())='" + facetName + "']";

        String facetArrowXPath =
                facetXPath + "/ancestor::div[contains(@class,'acc-header-srp')]//img";

        String filterValueXPath =
                facetXPath +
                        "/ancestor::app-elux-product-facet-list" +
                        "//span[normalize-space(text())='" + filterValue + "']";

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(filterValueXPath)));
        } catch (TimeoutException e) {
            throw new AssertionError("Filter value was not visible before collapsing. Test invalid.");
        }

        WebElement arrow = WebElementUtil.findElement(By.xpath(facetArrowXPath));
        WebElementUtil.scrollAndClickUsingJSE(driver, arrow);

        boolean isInvisible = true;
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(filterValueXPath)));
        } catch (TimeoutException e) {
            isInvisible = false;
        }

        Assert.assertTrue(isInvisible,
                "Filter value should be invisible after collapsing the filter group.");
        //  WebElementUtil.scrollAndClickUsingJSE(driver, arrow);
    }

    private final By productCount = By.xpath("//span[@name='ProductsCount' or @class='totalResults resultsBorder']");

    public void openAllProductsAndValidate(String featureName, String featureKey, String featureValue) {
        try {
            WebDriver driver = DriverManager.getDriver();
            WebElementUtil.zoomInOrOut(25);
            loadMoreProducts(driver);
            WebElementUtil.zoomInOrOut(25);
            verifyProductCount(driver, WebElementUtil.findElement(productCount));

            List<WebElement> products = WebElementUtil.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
            int totalProducts = products.size();
            System.out.println("Total products found: " + totalProducts);
            String mainWindow = driver.getWindowHandle();
            for (int i = 0; i < totalProducts; i++) {
                try {
                    String imgXpath = "(//div[@class='container-fluid px-0 plp' or @class='container-fluid px-2 plp']//div[@id='PlpItem" + i + "']//app-elux-image//img)[1]";
                    WebElement imageElement = WaitUtils.untilVisible((By.xpath(imgXpath)), 8000);

                    System.out.println(" Opening product index: " + i);
                    Actions actions = new Actions(driver);
                    actions.keyDown(Keys.CONTROL).click(imageElement).keyUp(Keys.CONTROL).build().perform();
                    Thread.sleep(10000);
                    WebElementUtil.switchToNewTab(driver, mainWindow);
                    validateProduct(i, featureName, featureKey, featureValue);
                    driver.close();
                    driver.switchTo().window(mainWindow);

                } catch (Exception e) {
                    System.out.println("Skipping product index " + i + ": " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println("Error iterating over products: " + e.getMessage());
        }
    }

    private final By resetAllButton = By.xpath("//span[text()=\" Hide Filters\"]/ancestor::div//span[text()=\" Reset all \"]");

    private void validateProduct(int index, String featureName, String featureKey, String featureValue) {
        try {
            WebDriver driver = DriverManager.getDriver();
            System.out.println("Validating product index " + index);
            System.out.println("Current URL: " + driver.getCurrentUrl());
            WebElementUtil.scrollAndClickUsingJSE(driver, WebElementUtil.findElement(viewFullSpecsBtn));
            WebElement featureNameElement = WaitUtils.untilVisible(getFeatureSpecsLocator(featureName), 30000);
            WebElementUtil.scrollToElement(driver, featureNameElement);
            Assert.assertTrue(featureNameElement.isDisplayed(), featureName + " feature element is not displayed.");
            WebElement featureElement = WaitUtils.untilVisible(getQuiickSpecsFeatureLocator(featureKey, featureValue), 1);
            String elementText = featureElement.getText().trim();
            Assert.assertEquals(elementText, featureValue, "Value Mismatch");
            System.out.println("Feature value for " + featureKey + ": " + elementText);
        } catch (Exception e) {
            System.out.println("Validation failed for product index " + index + ": " + e.getMessage());
        }
    }
    public void expandFilterIfCollapsed(String facetName, String filterValue) {

        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        String facetXPath =
                "//span[normalize-space(text())='" + facetName + "']";

        String facetArrowXPath =
                facetXPath + "/ancestor::div[contains(@class,'acc-header-srp')]//img";

        String filterValueXPath =
                facetXPath +
                        "/ancestor::app-elux-product-facet-list" +
                        "//span[normalize-space(text())='" + filterValue + "']";

        boolean isCollapsed = false;

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(filterValueXPath)));
        } catch (TimeoutException e) {

            isCollapsed = true;
        }

        if (isCollapsed) {
            WebElement arrow = WebElementUtil.findElement(By.xpath(facetArrowXPath));
            WebElementUtil.scrollAndClickUsingJSE(driver, arrow);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(filterValueXPath)));
        }
    }

    public By getFeatureSpecsLocator(String text) {
        return By.xpath("//h5[text()='" + text + "']");
    }

    private By getQuiickSpecsFeatureLocator(String featureKey, String featureValue) {
        return By.xpath("//span[text()='" + featureKey + "']//parent::div//following-sibling::div//span[contains(text(),'" + featureValue + "')]");


    }
    public void verifyProductCount(WebDriver driver, WebElement element) {


        try {
            List<WebElement> products = WebElementUtil.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
            int totalProducts = products.size();
            System.out.println("Total products found: " + totalProducts);
            for (int i = 0; i < totalProducts; i++) {

                String productXPath = "//div[@id='PlpItem" + i + "']";
                WebElement productElement = WebElementUtil.findElement(By.xpath(productXPath));
                int expectedCount = i + 1;
            }


            int actualTotalCount = totalProducts;
            System.out.println("Verifying total product count: " + actualTotalCount);
            String productCountText = element.getText().trim();
            System.out.println("Product count text: " + productCountText);
            String expectedTotalCountStr = productCountText.replaceAll("[^0-9]", "");
            System.out.println("Extracted product count: " + expectedTotalCountStr);
            int expectedTotalCount = Integer.parseInt(expectedTotalCountStr);
            Assert.assertEquals(actualTotalCount, expectedTotalCount, "Mismatch in total product count!");
        } catch (Exception e) {
            System.out.println("Error verifying product counts: " + e.getMessage());
        }
    }
    public void featureFilter( String featureKey, String featureValue) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String xpath1 = "//span[contains(text(),'" + featureKey + "')]/ancestor::app-elux-product-facet-list//input[normalize-space(@id)='" + featureValue + "']";
        try {
            WebElement  elementToClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath1)));
            boolean isChecked = elementToClick.isSelected();
            Assert.assertFalse(isChecked, " Checkbox for filter '" + featureValue + "' should be unchecked before clicking.");
            WebElementUtil.scrollAndClickUsingJSE(driver, elementToClick);
            Thread.sleep(3000);
        }catch (TimeoutException e1) {
        }
    }


    public void verifySelectedFilters(String filterText) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String xpath = "//span[text()=' Hide Filters']/ancestor::div//span[text()='" + filterText + "']";

        try {
            WebElement filterElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Assert.assertTrue(filterElement.isDisplayed(), "The filter '" + filterText + "' is not displayed under selected filters.");

        } catch (TimeoutException e) {
            Assert.fail("The filter '" + filterText + "' was not found under selected filters.");
        }
        WebElement verifyResetAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        Assert.assertTrue(verifyResetAll.isDisplayed(), "The Hidden filter is not displayed.");

        WebElementUtil.scrollAndClickUsingJSE(driver,driver.findElement(resetAllButton));

        Thread.sleep(6000);
        List<WebElement> filtersAfterReset = WebElementUtil.findElements(By.xpath(xpath));
        Assert.assertTrue(filtersAfterReset.isEmpty(), "The filter '" + filterText + "' should NOT be visible after clicking Reset All.");


    }

    public void openAllProductsAndValidateColor( String color ,String expectedColor) {
        try {
            WebDriver driver = DriverManager.getDriver();
            loadMoreProducts(driver);
            verifyProductCount(driver, driver.findElement(PLPProductItemsLocatorFsus.PRODUCT_COUNT));

            List<WebElement> products = driver.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
            int totalProducts = products.size();
            System.out.println("Total filtered products found: " + totalProducts);
            String mainWindow = driver.getWindowHandle();

            for (int i = 0; i < totalProducts; i++) {
                try {
                    String imgXpath = "(//div[@id='PlpItem" + i + "']//app-elux-image//img)[1]";
                    WebElement imageElement = WaitUtils.untilVisible((By.xpath(imgXpath)), 20000);

                    System.out.println(" Opening product index: " + i);
                    new Actions(driver).keyDown(Keys.CONTROL).click(imageElement).keyUp(Keys.CONTROL).perform();

                    Thread.sleep(5000);
                    WebElementUtil.switchToNewTab(driver, mainWindow);

                    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300);");

                    validateProductColor(i,color, expectedColor);

                    driver.close();
                    driver.switchTo().window(mainWindow);

                } catch (Exception e) {
                    System.out.println("Skipping product index " + i + ": " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println("Error iterating over products: " + e.getMessage());
        }
    }
    public void validateProductColor(int index, String color, String expectedColor) {
        WebDriver driver = DriverManager.getDriver();
        try {
            By electroluxColorLocator = By.xpath(
                    "//span[normalize-space()='"+color+"']");

            WebElement colorElement = WaitUtils.untilVisible(electroluxColorLocator, 15000);
            WebElementUtil.scrollToElementStable(electroluxColorLocator);
            String actualColor = colorElement.getText().trim().toLowerCase();
            expectedColor = expectedColor.trim().toLowerCase();


            System.out.println("Product " + index + " | Expected Color: " + expectedColor + " | Actual Color: " + actualColor);

            Assert.assertEquals(actualColor, expectedColor,
                    "Color mismatch for product " + index + ": Expected [" + expectedColor + "] but found [" + actualColor + "]");



        } catch (Exception e) {
            System.out.println(" Error validating color for product "  + e.getMessage());
        }
    }

    public void verifyFiltersInPLP(String text) {
        String dynamicXpath = "//span[contains(text(),'" + text + "')]";
        By locator = By.xpath(dynamicXpath);
        WebElementUtil.scrollToElementStable(locator);
        WebElementUtil.isDisplayed(locator);
    }
    public void validateCheckboxUncheckedAfterCrossClick(String filterCategory, String filterName, String crossFilterName) {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        By pillCross =  plpProductItemsLocatorFsus.selectedFilterCross(crossFilterName);
        By checkbox = plpProductItemsLocatorFsus.getFeatureLocator(filterCategory, filterName);
        WaitUtils.untilClickable(checkbox,15000);
        WebElementUtil.scrollAndClickUsingJSE(driver, WebElementUtil.findElement(checkbox));
        WebElement crossElement = wait.until(ExpectedConditions.elementToBeClickable(pillCross));
        WebElementUtil.scrollAndClickUsingJSE(driver,crossElement);
        wait.until(ExpectedConditions.invisibilityOfElementLocated( plpProductItemsLocatorFsus.selectedFilterCross(crossFilterName)));
        WebElement freshCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(checkbox));
        boolean isUnchecked = !freshCheckbox.isSelected();
        Assert.assertTrue(isUnchecked, " Checkbox for " + filterName + " is still checked after removing filter.");

    }
}
