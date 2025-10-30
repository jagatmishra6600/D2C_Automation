package com.automation.frigidaire.pages;


import com.automation.frigidaire.enums.FrigidaireConstants;
import com.automation.frigidaire.utils.DriverManager;
import com.automation.frigidaire.utils.WaitUtils;
import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PLPProductItemsPageActions {

    WebDriver driver = DriverManager.getDriver();

    private final By emailPopUp = By.xpath("//span[@id=\"close-modal123\"]");
    private final By addToCart = By.xpath("//span[text()=\" Add to cart \" and @class=\"ng-star-inserted\"]");
    private final By earliestDelivery = By.xpath("//span[contains(text(), 'Earliest delivery:') or contains(text(),'In stock!')]");
    private final By temporarilyLocator = By.xpath("//button[span[text()=\"Temporarily Out of Stock\"]]");
    private final By emailFieldLocator = By.xpath("//input[@name=\"Email\" and contains(@placeholder, \"Enter email\")]");
    private final By notifyBtnLocator = By.xpath("//input[@id=\"submitBtn\" and @name=\"submitBtn\"]");
    private final By emailValidationLocator = By.xpath("//span[contains(normalize-space(.), \"You’re signed up\")]");
    private final By temporarilyLocatorAirCare= By.xpath("//span[text()=\"Temporarily out of stock in your area.\"]");

    private final By sortByDropdownBtn = By.xpath("//div[@id='sortByFacet']//div[@class='ng-select-container ng-has-value']");
   
    private final By standardWidth = By.xpath("//b[text()=\"Standard Width \"]/ancestor::app-elux-product-facet-list//div[label[div[span[text()=' 36\" ']]]]/input\n");
    // private final By standardWidthProductCount=By.xpath("//span[contains(text(),'W:')]/following-sibling::span[@class='font-weight-bold']");
    private final By loadMoreBtn = By.xpath("//div[@class='row col-12 load-more']//button[text()=' Load more ']");
    private final By productCount = By.xpath("//span[@name='ProductsCount']");

    private final By viewFullSpecsBtn = By.xpath("//button[text()='View full specs']");
    private final By quickSpecs = By.xpath("//div[@id='QuickSpecAccrd']");
    private final By specificationsHeading = By.xpath("//h3[text()='Specifications']");

    private final By resetAllButton = By.xpath("//span[text()=\" Hide filters\"]/ancestor::div//span[text()=\" Reset all \"]");
    private final By productUniqueCode = By.xpath("//h2[@class='prod_id Utility-TextProduct-SKU-Sm ng-star-inserted']");
    private final By productTitle = By.xpath("//h1[@class='H1H1_Desktop mt-34 category-heading']");

    private final By availabilityCheckbox = By.xpath(
            "//b[contains(text(),'Availability')]" +
                    "/ancestor::app-elux-product-facet-list" +
                    "//div//b[text()='Availability']" +
                    "/parent::div/child::div//input[@aria-label='Availability']"
    );

    private final By addToCartForPLP = By.xpath("//div[@id='earliestDeliveryDateDiv']/parent::app-elx-earliest-delivery-day-common//following-sibling::div//span[contains(text(),'Add to cart')]");

    private By getFeatureLocator(String featureKey, String featureValue) {
        return By.xpath("//b[contains(text(),'"+featureKey+"')]/ancestor::app-elux-product-facet-list//div//input[@id='"+featureValue+"']");


    }

    private By getQuiickSpecsFeatureLocator(String featureKey, String featureValue) {
        return By.xpath("//span[text()='" + featureKey + "']//parent::div//following-sibling::div//span[contains(text(),'" + featureValue + "')]");



    }
    private By selectedFilterCross(String filterName) {
        return By.xpath("//span[@class='border border-light p-2 m-2 Body-MediumBody_Medium' and normalize-space(text())='" + filterName + "']//i");
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

    public void closeEmailPopUp() {
        WaitUtils.untilVisible(emailPopUp, 60);
        Assert.assertTrue(WebElementUtil.isDisplayed(emailPopUp), "Email popup should be displayed before closing.");
        WebElementUtil.clickElement(emailPopUp);
        Assert.assertFalse(WebElementUtil.isDisplayed(emailPopUp), "Email popup should not be displayed after closing.");


    }
    public void clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
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


    public WebElement verifyFiltersInPLP(String text) {
        WebDriver driver = DriverManager.getDriver();
        String dynamicXpath = "//b[contains(text(),'" + text + "')]";
        WebElement element = driver.findElement(By.xpath(dynamicXpath));
        WebElementUtil.scrollToElement(driver, element);
        Assert.assertTrue(element.isDisplayed(), "Element with text '" + text + "' is not displayed.");
        return element;
    }

    public void verifyProductItemPage(String text, String assertValue) {
        By locator = By.xpath("//h1[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        String s1 = WebElementUtil.getText(locator);
        Assert.assertEquals(s1, assertValue);
    }

    public void verifyFiltersInProductItems(String text, int time, String assertValue) {

        try {
            WebDriver driver = DriverManager.getDriver();
            WebElementUtil.zoomInOrOut(25);
            String actualElement = driver.findElement(productFilterItem(text)).getText();
            System.out.println(actualElement);
            System.out.println(assertValue);
            Assert.assertEquals(actualElement, assertValue);
            System.out.println("Pass!!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public void verifySortBy(String text, int time, String assertValue) {

        try {
            WebDriver driver = DriverManager.getDriver();
            WebElementUtil.zoomInOrOut(100);
            System.out.println("scrolled successfully");
            String actualElement = driver.findElement(productSortBy(text)).getText();

            Assert.assertEquals(actualElement, assertValue);
            System.out.println("verified!!!!!!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void selectSortByDropDown(String text, int time, String assertValue) {

        try {
            WaitUtils.untilVisible(sortByDropdownBtn, 30);
            WebElementUtil.clickElement(sortByDropdownBtn);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public PLPProductItemsPageActions clickOnProductMenuItem(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
        return this;
    }


    public By productFilterItem(String text) {
        By locator = By.xpath("//b[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
        return locator;
    }

    public By productSortBy(String text) {
        By locator = By.xpath("//span[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
        return locator;
    }

    public void verifyHideAndShowAllFilters(String text) {
        By locator = By.xpath("//span[normalize-space(text())='" + text + "']");
        WebElement element = WebElementUtil.waitForElementToBeVisible(locator);
        Assert.assertTrue(element.isDisplayed(), "Not able to load Filter in the page");
        WebElementUtil.clickElement(locator);
    }

    public void verifyHideFilters(String text) {
        By locator = By.xpath("//span[normalize-space(text())='" + text + "']");
        WebElement element = WebElementUtil.waitForElementToBeVisible(locator);
        Assert.assertTrue(element.isDisplayed(), "Not able to load Filter in the page");

    }




    public void standardWidthClick() throws InterruptedException {
        WaitUtils.untilVisible(standardWidth, 60);
        WebElementUtil.clickElement(standardWidth);
        Thread.sleep(3000);
//        for(WebElement element: elements){
//            System.out.println(element.getText());
//        }
    }


    public void verifyProductWidthHeightAndDepth() throws InterruptedException {

        WebDriver driver = DriverManager.getDriver();
        By width = By.xpath("//b[text()=\"Standard Width \"]/ancestor::app-elux-product-facet-list//div[label[div[span[contains(text(),' 36')]]]]/input");
        WaitUtils.untilVisible(width, 60);
        WebElementUtil.clickElement(width);
        Thread.sleep(6000);
        List<WebElement> products = driver.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
        int totalProducts = products.size();
        System.out.println("Total products found: " + totalProducts);
        for (int i = 0; i < totalProducts; i++) {
            String productXpath = "//div[@id='PlpItem" + i + "']//span[@class='product-dimension-attr-styles' and contains(text(),'W')]/following-sibling::span";
            List<WebElement> sizeElements = driver.findElements(By.xpath(productXpath));
            if (!sizeElements.isEmpty()) {
                String sizeText = sizeElements.get(0).getText().trim();
                System.out.println("Product " + i + " - Size found: " + sizeText);
                Assert.assertTrue(sizeText.contains("36") || sizeText.contains("35"), "Invalid size found for product " + i + ": " + sizeText);
            } else {
                Assert.fail("Size element not found for product " + i);
            }
        }
    }


    public void verifyProductPrice(double minPrice, double maxPrice, String priceRange) {
        WebDriver driver = DriverManager.getDriver();
        // Define the price filter range (user-defined)


        // XPath for selecting the price filter input field
        By price = By.xpath("//b[contains(text(),'Price')]/ancestor::app-elux-product-facet-list//div[label/div/span[contains(text(),'" + priceRange + "')]]/input");

        try {
            // Wait until the price filter element is visible and interactable
            WaitUtils.untilVisible(price, 60);
            WebElementUtil.clickElement(price); // Click the price filter to apply the filter
            Thread.sleep(6000); // Wait for the filter to apply (try to avoid Thread.sleep in actual code)

            // Find all products listed in the price range
            List<WebElement> products = driver.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
            int totalProducts = products.size();
            System.out.println("Total products found: " + totalProducts);
            for (int i = 0; i < totalProducts; i++) {
                String priceXpath = "//div[@id='PlpItem" + i + "']//div[@class='container price d-flex justify-content-flex-start align-items-center']/span[@class='H3H3_Desktop color-promo-green']";
                WebElement priceElement = driver.findElement(By.xpath(priceXpath));
                if (priceElement != null) {
                    String priceText = priceElement.getText().trim();
                    double priceValue = parsePrice(priceText);
                    System.out.println("Product " + i + " - Price: ₹" + priceValue);
                    Assert.assertTrue(priceValue >= minPrice && priceValue <= maxPrice,
                            "Product " + i + " has an invalid price. Expected price between $" + minPrice + " and $" + maxPrice + ", but found $" + priceValue);
                } else {
                    Assert.fail("Price element not found for product " + i);
                }
            }
        } catch (Exception e) {
            // Catch and log any exceptions during the process
            e.printStackTrace();
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }

    // Helper method to parse the price string and convert it to a numeric value (double)
    private double parsePrice(String priceText) {
        // Remove currency symbol (₹) and commas
        priceText = priceText.replaceAll("[^\\d.]", "");
        return Double.parseDouble(priceText);
    }



    public void featureFilter(String featureKey, String featureValue) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();

        String xpath1 = "//b[contains(text(),'"+featureKey+"')]/ancestor::app-elux-product-facet-list//div//input[@id='"+featureValue+"']";

        String xpath2 = "//b[contains(text(),'" + featureKey + "')]/ancestor::app-elux-product-facet-list//div[label[div[span[contains(text(),'" + featureValue + "')]]]]//input/following-sibling::label";

        WebElement elementToClick = null;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            elementToClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath1)));

        } catch (TimeoutException e1) {
            try {
                elementToClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath2)));

            } catch (TimeoutException e2) {
                System.err.println("Both XPaths failed to locate the element.");
                throw e2;
            }
        }

        boolean isChecked = elementToClick.isSelected();


        Assert.assertFalse(isChecked, "Checkbox for filter '" + featureValue + "' should be unchecked before clicking.");
        WebElementUtil.scrollAndClickUsingJSE(driver, elementToClick);
        Thread.sleep(3000);
    }


    public void verifySelectedFilters(String filterText) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Dynamic XPath using the input text
        String xpath = "//span[text()=' Hide filters']/ancestor::div//span[text()='" + filterText + "']";

        try {
            WebElement filterElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            Assert.assertTrue(filterElement.isDisplayed(),
                    "The filter '" + filterText + "' is not displayed under selected filters.");
            System.out.println(" Filter '" + filterText + "' is visible under selected filters.");
        } catch (TimeoutException e) {
            Assert.fail("The filter '" + filterText + "' was not found under selected filters.");
        }
        WebElement verifyResetAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        Assert.assertTrue(verifyResetAll.isDisplayed(), "The Hidden filter is not displayed.");
        WebElementUtil.clickElement(resetAllButton);

        Thread.sleep(6000);
        List<WebElement> filtersAfterReset = driver.findElements(By.xpath(xpath));
        Assert.assertTrue(filtersAfterReset.isEmpty(),
                "The filter '" + filterText + "' should NOT be visible after clicking Reset All.");
        System.out.println(" Filter '" + filterText + "' is no longer selected after Reset All.");

    }


    public void verifyExpandAndCollapseFilter(String facetName, String filterValue) throws InterruptedException {


        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // XPath for the facet section title (e.g., Series)
        By facetLocator = expandAndCollapseFilter(facetName);
        System.out.println("Wait done");
        String filterValueXPath = "//b[normalize-space(text())='" + facetName + "']" +
                "/ancestor::app-elux-product-facet-list" +
                "//span[normalize-space(text())='" + filterValue + "']";
        System.out.println(filterValueXPath);
        // Ensure the filter value is initially visible (expanded)
        try {
            // WebElementUtil.scrollAndClickUsingJSE(driver,driver.findElement((facetLocator)));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(filterValueXPath)));
            System.out.println("Filter value is visible before collapse as expected.");
        } catch (TimeoutException e) {
            throw new AssertionError("Filter value was not visible before collapsing. Test invalid.");
        }


        System.out.println(facetLocator);
        WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(facetLocator));
        System.out.println("clicked on facet Locator");
        boolean isInvisible = true;
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(filterValueXPath)));
            System.out.println("Filter value is no longer visible after collapsing — PASS");
        } catch (TimeoutException e) {
            isInvisible = false;
            System.out.println("Filter value is still visible after collapsing — FAIL");
        }

        Assert.assertTrue(isInvisible, "Filter value should be invisible after collapsing the filter group.");

        // Optional: small pause for visual verification in UI
        Thread.sleep(1000);
    }

    public void clickOnSortByDropDownvalues(String text, String assertValue) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        WaitUtils.untilVisible(sortByDropdownBtn, 10000);
        //WebElementUtil.clickElementUsingJSE(driver,sortByDropdownBtn);
        WebElementUtil.clickElement(sortByDropdownBtn);
        String selectedSortBy = driver.findElement(getSortOptionByText(text)).getText();
        System.out.println(selectedSortBy);
        Thread.sleep(3000);
        WaitUtils.untilVisible(getSortOptionByText(text), 60);
        Assert.assertEquals(selectedSortBy, assertValue);
        WebElementUtil.clickElement(getSortOptionByText(text));
        Thread.sleep(6000);

    }

    public void clickOnLoadMoreBtn() throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();


        WaitUtils.untilVisible(loadMoreBtn, 60);

        WebElement element = driver.findElement(loadMoreBtn);
        WebElementUtil.scrollToElement(driver, element);
        WaitUtils.untilClickable(element, 4000);
        WebElementUtil.scrollAndClickUsingJSE(driver, element);

        System.out.println("clicked on load more btn ");

        // System.out.println("clicked on load more btn--------- ");
        Thread.sleep(7000);
        WebElementUtil.scrollUp(driver, 6000);

    }

    public By expandAndCollapseFilter(String text) {

        return By.xpath("//b[normalize-space(text())='" + text +
                "' and @class='text-capitalize widthFMob']" +
                "/ancestor::div[@class='acc-header-srp Body-LargeBody_Large-Bold widthMob row']" +
                "//img[@class='header-icon']");


    }

    public By getSortOptionByText(String optionText) {
        String xpath = String.format("//div[@role='listbox']//span[text()='" + optionText + "']");
        return By.xpath(xpath);
    }


    public void verifyPriceLowToHighSort() {
        WebDriver driver = DriverManager.getDriver();
        try {
            loadMoreProducts(driver);
            List<WebElement> products = driver.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
            int totalProducts = products.size();
            System.out.println("Total products found: " + totalProducts);

            // Create a list to store product prices
            List<Double> productPrices = new ArrayList<>();

            for (int i = 0; i < totalProducts; i++) {
                String priceXpath = "//div[@id='PlpItem" + i + "']//div[@class='container price d-flex justify-content-flex-start align-items-center']/span[@class='H3H3_Desktop color-promo-green' or @class='H3H3_Desktop']";
                WebElement priceElement = driver.findElement(By.xpath(priceXpath));

                if (priceElement != null) {
                    String priceText = priceElement.getText().trim();
                    double priceValue = parsePrice(priceText);
                    System.out.println("Product " + i + " - Price: $" + priceValue);
                    productPrices.add(priceValue);
                } else {
                    Assert.fail("Price element not found for product " + i);
                }
            }

            // Now, verify that the prices are in ascending order
            for (int i = 0; i < productPrices.size() - 1; i++) {
                Assert.assertTrue(productPrices.get(i) <= productPrices.get(i + 1),
                        "Prices are not in ascending order. Product " + i + " price: $" + productPrices.get(i) +
                                ", Product " + (i + 1) + " price: $" + productPrices.get(i + 1));
            }

        } catch (Exception e) {
            // Catch and log any exceptions during the process
            e.printStackTrace();
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }


    public void verifyBiggestSavingsSort() {
        WebDriver driver = DriverManager.getDriver();
        try {
            loadMoreProducts(driver);
            List<WebElement> products = driver.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
            int totalProducts = products.size();
            System.out.println("Total products found: " + totalProducts);
            List<Double> productSavings = new ArrayList<>();
            List<Integer> productIndexes = new ArrayList<>();

            for (int i = 0; i < totalProducts; i++) {

                String actualPriceXpath = "//div[@id='PlpItem" + i + "']//div[@class='container price d-flex justify-content-flex-start align-items-center']//s[@class='Utility-TextStrike-Through-Price']";
                WebElement actualPriceElement = driver.findElement(By.xpath(actualPriceXpath));
                String discountedPriceXpath = "//div[@id='PlpItem" + i + "']//div[@class='container price d-flex justify-content-flex-start align-items-center']/span[@class='H3H3_Desktop color-promo-green' or @class='H3H3_Desktop']";
                WebElement discountedPriceElement = driver.findElement(By.xpath(discountedPriceXpath));
                if (actualPriceElement != null && discountedPriceElement != null) {
                    String actualPriceText = actualPriceElement.getText().trim();
                    String discountedPriceText = discountedPriceElement.getText().trim();
                    double actualPrice = parsePrice(actualPriceText);
                    double discountedPrice = parsePrice(discountedPriceText);
                    double savings = actualPrice - discountedPrice;
                    System.out.println("Product " + i + " - Actual Price: ₹" + actualPrice + ", Discounted Price: ₹" + discountedPrice + ", Savings: ₹" + savings);
                    productSavings.add(savings);
                    productIndexes.add(i);
                } else {
                    Assert.fail("Price elements not found for product " + i);
                }
            }

            for (int i = 0; i < productSavings.size() - 1; i++) {
                Assert.assertTrue(productSavings.get(i) >= productSavings.get(i + 1),
                        "Savings are not in descending order. Product " + productIndexes.get(i) + " savings: ₹" + productSavings.get(i) +
                                ", Product " + productIndexes.get(i + 1) + " savings: ₹" + productSavings.get(i + 1));
            }

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }

    public void verifyPriceHighToLowSort() {
        WebDriver driver = DriverManager.getDriver();
        try {
            loadMoreProducts(driver);
            List<WebElement> products = driver.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
            int totalProducts = products.size();
            System.out.println("Total products found: " + totalProducts);

            List<Double> productPrices = new ArrayList<>();

            for (int i = 0; i < totalProducts; i++) {
                String priceXpath = "//div[@id='PlpItem" + i + "']//div[@class='container price d-flex justify-content-flex-start align-items-center']/span[@class='H3H3_Desktop color-promo-green' or @class='H3H3_Desktop']";
                WebElement priceElement = driver.findElement(By.xpath(priceXpath));

                if (priceElement != null) {
                    String priceText = priceElement.getText().trim();
                    double priceValue = parsePrice(priceText);
                    System.out.println("Product " + i + " - Price: $" + priceValue);
                    productPrices.add(priceValue);
                } else {
                    Assert.fail("Price element not found for product " + i);
                }
            }

            // Verify that prices are in descending order (High → Low)
            for (int i = 0; i < productPrices.size() - 1; i++) {
                Assert.assertTrue(productPrices.get(i) >= productPrices.get(i + 1),
                        "Prices are not in descending order. Product " + i + " price: $" + productPrices.get(i) +
                                ", Product " + (i + 1) + " price: $" + productPrices.get(i + 1));
            }

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }

    public void loadMoreProducts(WebDriver driver) {
        try {


            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            WebElement productCountElement = null;
            WebElement loadMoreElement = driver.findElement(loadMoreBtn);

            if (loadMoreElement.isDisplayed()) {
                WebElementUtil.scrollAndClickUsingJSE(driver, loadMoreElement);
                Thread.sleep(5000);
                productCountElement = WaitUtils.untilVisible((productCount), 40000);
                WebElementUtil.scrollToElement(driver, productCountElement);
                Assert.assertTrue(productCountElement.isDisplayed(), "Not displayed");
                System.out.println(productCountElement.getText());

            } else {
                productCountElement = WaitUtils.untilVisible((productCount), 40000);
                WebElementUtil.scrollToElement(driver, productCountElement);
                Assert.assertTrue(productCountElement.isDisplayed(), "Not displayed");
                System.out.println(productCountElement.getText());
            }
        } catch (Exception e) {
            System.out.println("Load More not present");

        }
    }

    public void verifyProductCount(WebDriver driver, WebElement element) {


        try {
            // Find all products on the page
            List<WebElement> products = driver.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
            int totalProducts = products.size();
            System.out.println("Total products found: " + totalProducts);

            // Loop through each product and verify its count based on index (i + 1)
            for (int i = 0; i < totalProducts; i++) {

                String productXPath = "//div[@id='PlpItem" + i + "']";
                WebElement productElement = driver.findElement(By.xpath(productXPath));
                int expectedCount = i + 1;  // The count should be (index + 1)
            }


            int actualTotalCount = totalProducts;  // This should match the total number of products shown
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


    public void validateFrigidaireGalleryAndProfessionalProducts(String text, String assertValue) {


        WebDriver driver = DriverManager.getDriver();
        loadMoreProducts(driver);
        List<WebElement> products = driver.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
        int totalProducts = products.size();
        System.out.println("Total products found: " + totalProducts);
        for (int i = 0; i < totalProducts; i++) {
            try {

                String productXPath = "//div[starts-with(@id,'PlpItem" + i + "')]//div[@id='racBrandImg']//img[@alt='" + text + "']";
                WebElement productImage = driver.findElement(By.xpath(productXPath));
                Assert.assertTrue(productImage.isDisplayed(), "Image not displayed for product at index " + i);
                String altText = productImage.getAttribute("alt");
                Assert.assertEquals(altText, assertValue, "Image alt text mismatch");

                System.out.println("Product image is correctly displayed for product at index " + i);

            } catch (Exception e) {
                System.out.println("Error while validating product image at index " + i + ": " + e.getMessage());
            }
        }
    }


    public void openAllProductsAndValidate(String featureName, String featureKey, String featureValue) {
        try {
            WebDriver driver = DriverManager.getDriver();
            loadMoreProducts(driver);
            verifyProductCount(driver, driver.findElement(productCount));

            List<WebElement> products = driver.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
            int totalProducts = products.size();
            System.out.println("Total products found: " + totalProducts);
            String mainWindow = driver.getWindowHandle();
            for (int i = 0; i < totalProducts; i++) {
                try {
                    // Dynamic XPath — always picks the first image
                    String imgXpath = "(//div[@class='container-fluid px-2 plp']//div[@id='PlpItem" + i + "']//app-elux-image//img)[1]";
                    WebElement imageElement = WaitUtils.untilVisible((By.xpath(imgXpath)), 40000);

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


    private void validateProduct(int index, String featureName, String featureKey, String featureValue) {
        try {
            WebDriver driver = DriverManager.getDriver();
            System.out.println("Validating product index " + index);
            System.out.println("Current URL: " + driver.getCurrentUrl());
            WebElement productUniqueCodeElement = WaitUtils.untilVisible(productUniqueCode, 30000);
            System.out.println(productUniqueCodeElement);
            Assert.assertTrue(productUniqueCodeElement.isDisplayed(), "Unique Product Code not displayed");


            System.out.println("unique prod check");
            // Wait for and click the "Quick Specs" button
            WaitUtils.untilVisible(quickSpecs, 30000);
            WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(quickSpecs));
            System.out.println("quick specs check");

            WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(viewFullSpecsBtn));
            WebElement specifications = WaitUtils.untilVisible(specificationsHeading, 30000);


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

    private void validateACProduct(int index, String featureName, String featureKey, String featureValue) {
        try {
            WebDriver driver = DriverManager.getDriver();
            System.out.println("Validating product index " + index);
            System.out.println("Current URL: " + driver.getCurrentUrl());

            WebElement productUniqueCodeElement = WaitUtils.untilVisible(productUniqueCode, 30000);
            System.out.println(productUniqueCodeElement);
            Assert.assertTrue(productUniqueCodeElement.isDisplayed(), "Unique Product Code not displayed");


            System.out.println("unique prod check");

            WaitUtils.untilVisible(quickSpecs, 30000);
            WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(quickSpecs));
            System.out.println("quick specs check");


            WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(viewFullSpecsBtn));
            WebElement specifications = WaitUtils.untilVisible(specificationsHeading, 30000);
            WebElementUtil.mouseHover(driver, specifications);

            WebElement featureNameElement = WaitUtils.untilVisible(getFeatureSpecsLocator(featureName), 30000);


            WebElementUtil.scrollToElement(driver, featureNameElement);
            Assert.assertTrue(featureNameElement.isDisplayed(), featureName + " feature element is not displayed.");


            WebElement featureElement = WaitUtils.untilVisible(getFeatureLocator(featureKey, featureValue), 30000);
            String elementText = featureElement.getText().trim();


            Assert.assertEquals(elementText, featureValue, "Value Mismatch");

            System.out.println("Feature value for " + featureKey + ": " + elementText);

        } catch (Exception e) {
            System.out.println("Validation failed for product index " + index + ": " + e.getMessage());
        }
    }


    public By getFeatureSpecsLocator(String text) {
        return By.xpath("//h5[text()='" + text + "']");
    }

    public static WebElement getPopularfiltersLocator(WebDriver driver, String text) {

        By dynamicLocator = By.xpath("//div[@id='fixedPosition']//div[contains(text(),'" + text + "')]");


        return driver.findElement(dynamicLocator);
    }

    public void validatePopularFiltersInPLP(String text, String assertValue) {
        try {

            WebDriver driver = DriverManager.getDriver();

            Boolean check = getPopularfiltersLocator(driver, text).isDisplayed();
            Assert.assertTrue(check, "popular filter not  displayed in PLP ");


        } catch (Exception e) {
            System.out.println("Not able to display Popular filters");
        }
    }


    public void validatePopularFilterTurnsRed(String filterName) {
        WebDriver driver = DriverManager.getDriver();


        WebElement filterElement = getPopularfiltersLocator(driver, filterName);
        WebElementUtil.scrollToElement(driver, filterElement);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));


        try {
            boolean isRed = wait.until(d -> {
                WebElement parent = (WebElement) ((JavascriptExecutor) driver)
                        .executeScript("return arguments[0].parentElement;", filterElement);
                String parentClass = parent != null ? parent.getAttribute("class") : "";
                return parentClass.contains("popularFilteSelected");
            });

            Assert.assertTrue(isRed,
                    " Popular filter '" + filterName + "' did not turn red/active after clicking checkbox.");
            System.out.println(" Popular filter '" + filterName + "' successfully turned red (#EA1947).");

        } catch (TimeoutException e) {
            Assert.fail(" Popular filter '" + filterName + "' did not turn red/active within timeout.");
        }
    }


    public void validateCheckboxCheckedWhenPopularFilterClicked(String popularFilterName, String filterCategory, String filterName) {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        By filterLocator = By.xpath("//div[@id='fixedPosition']//div[contains(text(),'" + popularFilterName + "')]");
        By checkboxLocator = By.xpath("//b[contains(text(),'" + filterCategory + "')]/ancestor::app-elux-product-facet-list" +
                "//div[label[div[span[contains(text(),'" + filterName + "')]]]]//input");


        WebElement popularFilter = wait.until(ExpectedConditions.elementToBeClickable(filterLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", popularFilter);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", popularFilter);
        System.out.println("Clicked on Popular Filter: " + popularFilterName);


        wait.until(ExpectedConditions.stalenessOf(popularFilter)); // wait until old reference becomes stale
        System.out.println(" Waiting for PLP filter DOM to stabilize...");


        WebElement freshFilter = wait.until(ExpectedConditions.presenceOfElementLocated(filterLocator));


        boolean turnedRed = wait.until(d -> {
            try {
                WebElement parent = (WebElement) ((JavascriptExecutor) driver)
                        .executeScript("return arguments[0].parentElement;", freshFilter);
                if (parent == null) return false;
                String parentClass = parent.getAttribute("class");
                return parentClass != null && parentClass.contains("popularFilteSelected");
            } catch (StaleElementReferenceException e) {
                WebElement reloadedFilter = driver.findElement(filterLocator);
                WebElement parent = (WebElement) ((JavascriptExecutor) driver)
                        .executeScript("return arguments[0].parentElement;", reloadedFilter);
                String cls = parent != null ? parent.getAttribute("class") : "";
                return cls.contains("popularFilteSelected");
            }
        });
        Assert.assertTrue(turnedRed, " Popular filter '" + popularFilterName + "' did not turn red after clicking.");
        System.out.println(" Popular Filter '" + popularFilterName + "' turned red/active after click.");


        wait.until(ExpectedConditions.presenceOfElementLocated(checkboxLocator));
        WebElement checkbox = driver.findElement(checkboxLocator);


        wait.until(d -> {
            try {
                return checkbox.isSelected();
            } catch (StaleElementReferenceException e) {
                WebElement freshCheckbox = driver.findElement(checkboxLocator);
                return freshCheckbox.isSelected();
            }
        });

        Assert.assertTrue(checkbox.isSelected(),
                " Checkbox for '" + filterName + "' under '" + filterCategory + "' is not checked after clicking Popular Filter.");
        System.out.println(" Checkbox for '" + filterName + "' is now checked after Popular Filter click.");
    }


    public void validateAvailabilityOfProductsInPLP() {
        WebDriver driver = DriverManager.getDriver();
        WebElementUtil.clickElementUsingJSE(driver, availabilityCheckbox);
        loadMoreProducts(driver);
        openAndValidateAvailibilityOfProducts();


    }

    public void openAndValidateAvailibilityOfProducts() {

        try {
            WebDriver driver = DriverManager.getDriver();
            List<WebElement> products = driver.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
            int totalProducts = products.size();
            System.out.println("Total products found: " + totalProducts);
            String mainWindow = driver.getWindowHandle();
            for (int i = 0; i < totalProducts; i++) {
                try {

                    String imgXpath = "(//div[@class='container-fluid px-2 plp']//div[@id='PlpItem" + i + "']//app-elux-image//img)[1]";
                    WebElement imageElement = WaitUtils.untilVisible((By.xpath(imgXpath)), 40000);

                    System.out.println(" Opening product index: " + i);
                    Actions actions = new Actions(driver);
                    actions.keyDown(Keys.CONTROL).click(imageElement).keyUp(Keys.CONTROL).build().perform();
                    Thread.sleep(10000);


                    WebElementUtil.switchToNewTab(driver, mainWindow);
                    validateProductIsInStock(addToCartForPLP);

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


    public void validateProductIsInStock(By locator)
    {
        WebElement element = WebElementUtil.waitForElementToBeVisible(locator);
        Assert.assertTrue(element.isDisplayed(), "product is not in Stock!!!");

    }



    public void validateSelectedFilterAppearsAfterCheckboxClick(String filterCategory, String filterName) {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


        By pill = selectedFilterCross(filterName);
        WebElement pillElement = wait.until(ExpectedConditions.visibilityOfElementLocated(pill));
        Assert.assertTrue(pillElement.isDisplayed(), " Selected filter pill not visible for: " + filterName);

        System.out.println(" Selected filter pill is visible for: " + filterName);

    }


    public void validateCheckboxUncheckedAfterCrossClick(String filterCategory, String filterName ,String crossFilterName) {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        By pillCross = selectedFilterCross(crossFilterName);

        By checkbox = getFeatureLocator(filterCategory, filterName);
        wait.until(ExpectedConditions.elementToBeClickable(checkbox));
        WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(checkbox));




        WebElement crossElement = wait.until(ExpectedConditions.elementToBeClickable(pillCross));
        WebElementUtil.scrollToElement(driver,crossElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", crossElement);
        System.out.println("Clicked on Cross (X) for: " + filterName);


        wait.until(ExpectedConditions.invisibilityOfElementLocated(selectedFilterCross(crossFilterName)));


        WebElement freshCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(checkbox));
        boolean isUnchecked = !freshCheckbox.isSelected();

        Assert.assertTrue(isUnchecked, " Checkbox for " + filterName + " is still checked after removing filter.");
        System.out.println("Checkbox for " + filterName + " is unchecked after clicking cross.");
    }

    }









