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

}
