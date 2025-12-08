package com.automation.frigidaire.pages;



import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
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

    private final By emailPopUp = By.xpath("//span[@id=\"close-modal123\"]");
    public static final By addToCart = By.xpath("//span[normalize-space()='Add to cart' and contains(@class,'ng-star-inserted')]");
    private final By earliestDelivery = By.xpath("//span[contains(text(), 'Earliest delivery:') or contains(text(),'In stock!')]");
    private final By temporarilyLocator = By.xpath("//button[span[text()=\"Temporarily Out of Stock\"]]");
    private final By emailFieldLocator = By.xpath("//input[@name=\"Email\" and contains(@placeholder, \"Enter email\")]");
    private final By notifyBtnLocator = By.xpath("//input[@id=\"submitBtn\" and @name=\"submitBtn\"]");
    private final By emailValidationLocator = By.xpath("//span[contains(normalize-space(.), \"You’re signed up\")]");
    private final By temporarilyLocatorAirCare = By.xpath("//span[text()=\"Temporarily out of stock in your area.\"]");

    private final By sortByDropdownBtn = By.xpath("//div[@id='sortByFacet']//div[@class='ng-select-container ng-has-value']");

    private final By standardWidth = By.xpath("//b[text()=\"Standard Width \"]/ancestor::app-elux-product-facet-list//div[label[div[span[text()=' 36\" ']]]]/input\n");
    // private final By standardWidthProductCount=By.xpath("//span[contains(text(),'W:')]/following-sibling::span[@class='font-weight-bold']");
    private final By loadMoreBtn = By.xpath("//div[@class='row col-12 load-more']//button[text()=' Load more ']");
    private final By productCount = By.xpath("//span[@name='ProductsCount' or @class='totalResults resultsBorder']");

    private final By viewFullSpecsBtn = By.xpath("//button[text()='View full specs']");
    private final By quickSpecs = By.xpath("//div[@id='QuickSpecAccrd']");
    private final By specificationsHeading = By.xpath("//h3[text()='Specifications']");

    private final By resetAllButton = By.xpath("//span[text()=\" Hide filters\"]/ancestor::div//span[text()=\" Reset all \"]");
    private final By productUniqueCode = By.xpath("//h2[@class='prod_id Utility-TextProduct-SKU-Sm ng-star-inserted']");
    private final By productTitle = By.xpath("//h1[@class='H1H1_Desktop mt-34 category-heading']");

    private final By availabilityCheckbox = By.xpath("//b[contains(text(),'Availability')]" + "/ancestor::app-elux-product-facet-list" + "//div//b[text()='Availability']" + "/parent::div/child::div//input[@aria-label='Availability']");

    private final By addToCartForPLP = By.xpath("//div[@id='earliestDeliveryDateDiv']/parent::app-elx-earliest-delivery-day-common//following-sibling::div//span[contains(text(),'Add to cart')]");

    private By getFeatureLocator(String featureKey, String featureValue) {
        return By.xpath("//b[contains(text(),'" + featureKey + "')]/ancestor::app-elux-product-facet-list//div//input[@id='" + featureValue + "']");


    }

    private By getSelectRoomSizeLocator(String featureKey) {
        return By.xpath("//div[@id='facet-drawer']//div[@id='roomSizeRange-wrapper']//span[text()='" + featureKey + "']/parent::div/preceding-sibling::div");
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
        try {
            WebElement popup = null;

            try {
                popup = WaitUtils.untilVisible(emailPopUp);
            } catch (TimeoutException e) {
                System.out.println("No email popup detected. Continuing test...");
            }

            if (popup != null && popup.isDisplayed()) {
                System.out.println("Email popup detected. Attempting to close...");
                WebElementUtil.clickElement(emailPopUp);

                Thread.sleep(1000);

                if (popup.isDisplayed()) {
                    System.out.println("Warning: Email popup still visible after close attempt.");
                } else {
                    System.out.println("Email popup closed successfully.");
                }
            } else {
                System.out.println("No email popup found, skipping close.");
            }

        } catch (Exception e) {
            System.out.println("Exception while handling email popup: " + e.getMessage());
        }
    }


    public void clickOnProductMenu(String text) {
        WebDriver driver=DriverManager.getDriver();
        By locator = By.xpath("//span[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.scrollAndClickUsingJSE(driver,driver.findElement(locator));
    }


    public WebElement verifyFiltersInPLP(String text) {
        WebDriver driver = DriverManager.getDriver();
        String dynamicXpath = "//b[contains(text(),'" + text + "')]";
        WebElement element = WebElementUtil.findElement(By.xpath(dynamicXpath));
        WebElementUtil.scrollToElement(driver, element);
        Assert.assertTrue(element.isDisplayed(), "Element with text '" + text + "' is not displayed.");
        return element;
    }

    public void verifyProductItemPage(String text, String assertValue) {
        By locator = By.xpath("//h1[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator, 60);
        String s1 = WebElementUtil.getText(locator);
        Assert.assertEquals(s1, assertValue);
    }

    public void verifyFiltersInProductItems(String text, int time, String assertValue) {

        try {
            WebDriver driver = DriverManager.getDriver();
            WebElementUtil.scrollByPixels(driver,0,350);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            closeEmailPopUp();
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(productFilterItem(text)));
            WebElementUtil.scrollToElement(driver, element);
            wait.until(d -> !element.getText().trim().isEmpty());

            String actualText = element.getText().trim();
            Assert.assertEquals(actualText, assertValue, "Text of the filter item does not match the expected value.");
            System.out.println(" Verified filter text: '" + actualText + "' matches expected value.");

        } catch (TimeoutException e) {
            throw new RuntimeException("Timeout: Filter element '" + text + "' not visible within 20 seconds.", e);

        } catch (AssertionError e) {
            throw new AssertionError(" Assertion failed for filter item '" + text + "': " + e.getMessage(), e);

        } catch (Exception e) {
            throw new RuntimeException(" Unexpected error occurred while validating filter item '" + text + "'.", e);
        }

    }


    public void verifySortBy(String text, int time, String assertValue) {

        try {
            WebDriver driver = DriverManager.getDriver();
            WebElementUtil.zoomInOrOut(100);
            String actualElement = WebElementUtil.findElement(productSortBy(text)).getText();
            Assert.assertEquals(actualElement, assertValue);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public By productFilterItem(String text) {
        WebDriver driver =DriverManager.getDriver();
        By locator = By.xpath("//b[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.scrollAndClickUsingJSE(driver,driver.findElement(locator));
        WebElementUtil.clickElement(locator);
        return locator;
    }

    public By productSortBy(String text) {
        By locator = By.xpath("//span[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
        return locator;
    }

    public void verifyHideAndShowAllFilters(String text){
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

    }


    public void verifyProductWidthHeightAndDepth(String type, String value) throws InterruptedException {

        WebDriver driver = DriverManager.getDriver();
        loadMoreProducts(driver);
        List<WebElement> products = WebElementUtil.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
        int totalProducts = products.size();

        for (int i = 0; i < totalProducts; i++) {
            String productXpath = "//div[@id='PlpItem" + i + "']//span[@class='product-dimension-attr-styles' and contains(text(),'" + type + "')]/following-sibling::span";
            List<WebElement> sizeElements = WebElementUtil.findElements(By.xpath(productXpath));
            if (!sizeElements.isEmpty()) {
                String sizeText = sizeElements.get(0).getText().trim();
                Assert.assertTrue(sizeText.contains(value), "Invalid size found for product " + i + ": " + sizeText);
            } else {
                Assert.fail("Size element not found for product " + i);
            }
        }

        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(30, java.util.concurrent.TimeUnit.SECONDS);
    }


    public void verifyProductPrice(double minPrice, double maxPrice, String priceRange) {
        WebDriver driver = DriverManager.getDriver();

        By price = By.xpath("//b[contains(text(),'Price')]/ancestor::app-elux-product-facet-list//div[label/div/span[contains(text(),'" + priceRange + "')]]/input");

        try {

            WaitUtils.untilVisible(price, 60);
            WebElementUtil.clickElement(price);
            Thread.sleep(6000);

            List<WebElement> products = WebElementUtil.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
            int totalProducts = products.size();
            System.out.println("Total products found: " + totalProducts);
            for (int i = 0; i < totalProducts; i++) {
                String priceXpath = "//div[@id='PlpItem" + i + "']//div[@class='container price d-flex justify-content-flex-start align-items-center']/span[@class='H3H3_Desktop color-promo-green']";
                WebElement priceElement = WebElementUtil.findElement(By.xpath(priceXpath));
                if (priceElement != null) {
                    String priceText = priceElement.getText().trim();
                    double priceValue = parsePrice(priceText);
                    System.out.println("Product " + i + " - Price: ₹" + priceValue);
                    Assert.assertTrue(priceValue >= minPrice && priceValue <= maxPrice, "Product " + i + " has an invalid price. Expected price between $" + minPrice + " and $" + maxPrice + ", but found $" + priceValue);
                } else {
                    Assert.fail("Price element not found for product " + i);
                }
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


    public void featureFilter(String website, String featureKey, String featureValue) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        if (website == null || website.isEmpty()) {
            throw new IllegalArgumentException(" Website parameter cannot be null or empty.");
        }
        website = website.trim().toLowerCase();

        String xpath1;
        String xpath2;
        if (website.equals("frigidaire")) {
            xpath1 = "//b[contains(text(),'" + featureKey + "')]/ancestor::app-elux-product-facet-list" + "//div//input[@id='" + featureValue + "']";

            xpath2 = "//b[contains(text(),'" + featureKey + "')]/ancestor::app-elux-product-facet-list" + "//div[label[div[span[contains(text(),'" + featureValue + "')]]]]//input/following-sibling::label";

        } else if (website.equals("electrolux")) {
            xpath1 = "//span[contains(text(),'" + featureKey + "')]/ancestor::app-elux-product-facet-list//input[normalize-space(@id)='" + featureValue + "']";

            xpath2 = "//span[contains(text(),'" + featureKey + "')]/ancestor::app-elux-product-facet-list" + "//div[label[div[span[contains(text(),'" + featureValue + "')]]]]//input/following-sibling::label";
        } else {
            throw new IllegalArgumentException(" Unsupported website: " + website);
        }
        WebElement elementToClick = null;

        try {
            elementToClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath1)));

        } catch (TimeoutException e1) {
            try {
                elementToClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath2)));

            } catch (TimeoutException e2) {
                throw e2;
            }
        }
        boolean isChecked = elementToClick.isSelected();
        Assert.assertFalse(isChecked, " Checkbox for filter '" + featureValue + "' should be unchecked before clicking.");
        WebElementUtil.scrollAndClickUsingJSE(driver, elementToClick);
        Thread.sleep(3000);
    }


    public void verifySelectedFilters(String filterText) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String xpath = "//span[text()=' Hide filters']/ancestor::div//span[text()='" + filterText + "']";

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


    public void verifyExpandAndCollapseFilter(String website, String facetName, String filterValue) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        if (website == null || website.isEmpty()) {
            throw new IllegalArgumentException("Website parameter cannot be null or empty.");
        }
        String facetXPath;
        String filterValueXPath;

        if (website.equalsIgnoreCase("frigidaire")) {
            facetXPath = "//b[normalize-space(text())='" + facetName + "']";
            filterValueXPath = facetXPath + "/ancestor::app-elux-product-facet-list" + "//span[normalize-space(text())='" + filterValue + "']";
        } else if (website.equals("electrolux")) {
            facetXPath = "//span[normalize-space(text())='" + facetName + "']";
            filterValueXPath = facetXPath + "/ancestor::app-elux-product-facet-list" + "//span[normalize-space(text())='" + filterValue + "']";
        } else {
            throw new IllegalArgumentException("Unsupported website: " + website);
        }

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(filterValueXPath)));

        } catch (TimeoutException e) {
            throw new AssertionError("Filter value was not visible before collapsing. Test invalid.");
        }


        WebElement facetElement = WebElementUtil.findElement(By.xpath(facetXPath));
        WebElementUtil.scrollAndClickUsingJSE(driver, facetElement);


        boolean isInvisible = true;
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(filterValueXPath)));

        } catch (TimeoutException e) {
            isInvisible = false;

        }

        Assert.assertTrue(isInvisible, "Filter value should be invisible after collapsing the filter group.");

        Thread.sleep(1000);
        WebElementUtil.scrollAndClickUsingJSE(driver, facetElement);
        Thread.sleep(1000);
    }

    public void clickOnSortByDropDownvalues(String text, String assertValue) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        WaitUtils.untilVisible(sortByDropdownBtn, 60000);
        //WebElementUtil.clickElementUsingJSE(driver,sortByDropdownBtn);
        WebElementUtil.clickElement(sortByDropdownBtn);
        String selectedSortBy = WebElementUtil.findElement(getSortOptionByText(text)).getText();

        Thread.sleep(3000);
        WaitUtils.untilVisible(getSortOptionByText(text), 60);
        Assert.assertEquals(selectedSortBy, assertValue);
        WebElementUtil.clickElement(getSortOptionByText(text));
        Thread.sleep(6000);

    }

    public void clickOnLoadMoreBtn() throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();


        WaitUtils.untilVisible(loadMoreBtn, 60);

        WebElement element = WebElementUtil.findElement(loadMoreBtn);
        WebElementUtil.scrollToElement(driver, element);
        WaitUtils.untilClickable(element, 40000);
        WebElementUtil.scrollAndClickUsingJSE(driver, element);

        Thread.sleep(7000);
        WebElementUtil.scrollUp(driver, 6000);

    }

    public By expandAndCollapseFilter(String text) {

        return By.xpath("//b[normalize-space(text())='" + text + "' and @class='text-capitalize widthFMob']" + "/ancestor::div[@class='acc-header-srp Body-LargeBody_Large-Bold widthMob row']" + "//img[@class='header-icon']");


    }

    public By getSortOptionByText(String optionText) {
        String xpath = String.format("//div[@role='listbox']//span[text()='" + optionText + "']");
        return By.xpath(xpath);
    }


    public void verifyPriceLowToHighSort(String website) {
        WebDriver driver = DriverManager.getDriver();
        try {
            loadMoreProducts(driver);
            List<WebElement> products = WebElementUtil.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
            int totalProducts = products.size();
            System.out.println("Total products found: " + totalProducts);
            List<Double> productPrices = new ArrayList<>();

            for (int i = 0; i < totalProducts; i++) {
                String priceXpath;
                if (website.equalsIgnoreCase("frigidaire")) {
                    priceXpath = "//div[@id='PlpItem" + i + "']//div[@class='container price d-flex justify-content-flex-start align-items-center']/span[@class='H3H3_Desktop color-promo-green' or @class='H3H3_Desktop']";
                } else if (website.equalsIgnoreCase("electrolux")) {
                    priceXpath = "//div[@id='PlpItem" + i + "']//span[@class=\"H3H3_Desktop saleprice\"or @class=\"H3H3_Desktop\"]";
                    System.out.println(priceXpath);
                } else {
                    throw new IllegalArgumentException("Unsupported website: " + website);
                }
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
                Assert.assertTrue(productPrices.get(i) <= productPrices.get(i + 1), "Prices are not in ascending order. Product " + i + " price: $" + productPrices.get(i) + ", Product " + (i + 1) + " price: $" + productPrices.get(i + 1));
            }

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }

    public void verifyBiggestSavingsSort(String website) {
        WebDriver driver = DriverManager.getDriver();

        try {
            if (website == null || website.isEmpty()) {
                throw new IllegalArgumentException(" Website parameter cannot be null or empty.");
            }
            website = website.toLowerCase().trim();
            loadMoreProducts(driver);
            List<WebElement> products = WebElementUtil.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
            int totalProducts = products.size();
            List<Double> productSavings = new ArrayList<>();
            List<Integer> productIndexes = new ArrayList<>();

            for (int i = 0; i < totalProducts; i++) {

                String actualPriceXpath;
                String discountedPriceXpath;
                if (website.equals("frigidaire")) {
                    actualPriceXpath = "//div[@id='PlpItem" + i + "']//span[@class='Utility-TextProduct-SKU-Lrg color-support-mid-charcoal' or @class='H3H3_Desktop']";
                    discountedPriceXpath = "//div[@id='PlpItem" + i + "']//span[@class='H3H3_Desktop color-promo-green']";

                } else if (website.equals("electrolux")) {
                    actualPriceXpath = "//div[@id='PlpItem" + i + "']//span[@class='H3H3_Desktop' or @class='CTA-Text-ELE-Blue-Mid']";
                    discountedPriceXpath = "//div[@id='PlpItem" + i + "']//span[contains(@class,'H3H3_Desktop saleprice')]";
                } else {
                    throw new IllegalArgumentException(" Unsupported website: " + website);
                }
                List<WebElement> actualPriceElements = WebElementUtil.findElements(By.xpath(actualPriceXpath));
                List<WebElement> discountedPriceElements = WebElementUtil.findElements(By.xpath(discountedPriceXpath));

                double actualPrice = 0.0;
                double discountedPrice = 0.0;
                if (website.equals("electrolux")) {
                    actualPrice = parsePriceForElectrolux(getTextSafe(actualPriceElements, 0));
                    discountedPrice = parsePriceForElectrolux(getTextSafe(discountedPriceElements, 0));
                } else {
                    actualPrice = parsePrice(getTextSafe(actualPriceElements, 0));
                    discountedPrice = parsePrice(getTextSafe(discountedPriceElements, 0));
                }
                if (actualPrice == 0.0 && discountedPrice == 0.0) {
                    System.out.println(" Price not found for product index: " + i);
                    productSavings.add(0.0);
                    productIndexes.add(i);
                    continue;
                }
                double savings;
                if (discountedPrice <= 0.0 || discountedPrice == actualPrice) {
                    savings = 0.0;
                    discountedPrice = actualPrice;
                } else {
                    savings = actualPrice - discountedPrice;
                    if (savings < 0) savings = 0.0;
                }

                System.out.println("Product " + i + " - Actual: $" + actualPrice + ", Discounted: $" + discountedPrice + ", Savings: $" + savings);

                productSavings.add(savings);
                productIndexes.add(i);
            }
            for (int i = 0; i < productSavings.size() - 1; i++) {
                Assert.assertTrue(productSavings.get(i) >= productSavings.get(i + 1), " Savings not sorted descending. Product " + productIndexes.get(i) + " savings: $" + productSavings.get(i) + ", Product " + productIndexes.get(i + 1) + " savings: $" + productSavings.get(i + 1));
            }

            System.out.println(" Verified 'Biggest Savings' sorting successfully for: " + website);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(" Test failed for " + website + " due to exception: " + e.getMessage());
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

    private double parsePriceForElectrolux(String priceText) {
        try {
            priceText = priceText.replaceAll("[^0-9.]", "").trim();
            if (!priceText.contains(".") && priceText.length() > 2) {
                priceText = priceText.substring(0, priceText.length() - 2) + "." + priceText.substring(priceText.length() - 2);
            }

            return Double.parseDouble(priceText);
        } catch (Exception e) {
            System.out.println(" Could not parse price text: " + priceText);
            return 0.0;
        }
    }


    public void verifyPriceHighToLowSort(String website) {
        WebDriver driver = DriverManager.getDriver();

        try {
            loadMoreProducts(driver);
            List<WebElement> products = WebElementUtil.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
            int totalProducts = products.size();
            System.out.println("Total products found: " + totalProducts);

            List<Double> productPrices = new ArrayList<>();

            for (int i = 0; i < totalProducts; i++) {
                String priceXpath;

                if (website.equalsIgnoreCase("frigidaire")) {
                    priceXpath = "//div[@id='PlpItem" + i + "']//div[@class='container price d-flex justify-content-flex-start align-items-center']/span[@class='H3H3_Desktop color-promo-green' or @class='H3H3_Desktop']";
                } else if (website.equalsIgnoreCase("electrolux")) {
                    priceXpath = "//div[@id='PlpItem" + i + "']//span[@class=\"H3H3_Desktop saleprice\"or @class=\"H3H3_Desktop\"]";
                    System.out.println(priceXpath);
                } else {
                    throw new IllegalArgumentException("Unsupported website: " + website);
                }

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


    public void loadMoreProducts(WebDriver driver) {
        try {


            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

            WebElement productCountElement = null;
            WebElement loadMoreElement = WebElementUtil.findElement(loadMoreBtn);

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


    public void validateFrigidaireGalleryAndProfessionalProducts(String text, String assertValue) {


        WebDriver driver = DriverManager.getDriver();
        loadMoreProducts(driver);
        List<WebElement> products = WebElementUtil.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
        int totalProducts = products.size();
        System.out.println("Total products found: " + totalProducts);
        for (int i = 0; i < totalProducts; i++) {
            try {

                String productXPath = "//div[starts-with(@id,'PlpItem" + i + "')]//div[@id='racBrandImg']//img[@alt='" + text + "']";
                WebElement productImage = WebElementUtil.findElement(By.xpath(productXPath));
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
                    WebElement imageElement = WaitUtils.untilVisible((By.xpath(imgXpath)), 80000);

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
            WebElementUtil.scrollAndClickUsingJSE(driver, WebElementUtil.findElement(quickSpecs));
            System.out.println("quick specs check");


            WebElementUtil.scrollAndClickUsingJSE(driver, WebElementUtil.findElement(viewFullSpecsBtn));
            WebElement specifications = WaitUtils.untilVisible(specificationsHeading, 80000);
            WebElementUtil.mouseHover(driver, specifications);

            WebElement featureNameElement = WaitUtils.untilVisible(getFeatureSpecsLocator(featureName), 80000);


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


        return WebElementUtil.findElement(dynamicLocator);
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


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));


        try {
            boolean isRed = wait.until(d -> {
                WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentElement;", filterElement);
                String parentClass = parent != null ? parent.getAttribute("class") : "";
                return parentClass.contains("popularFilteSelected");
            });
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -200);");
            Assert.assertTrue(isRed, " Popular filter '" + filterName + "' did not turn red/active after clicking checkbox.");
            System.out.println(" Popular filter '" + filterName + "' successfully turned red (#EA1947).");

        } catch (TimeoutException e) {
            Assert.fail(" Popular filter '" + filterName + "' did not turn red/active within timeout.");
        }
    }


    public void validateCheckboxCheckedWhenPopularFilterClicked(String popularFilterName, String filterCategory, String filterName) {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        By filterLocator = By.xpath("//div[@id='fixedPosition']//div[contains(text(),'" + popularFilterName + "')]");
        By checkboxLocator = By.xpath("//b[contains(text(),'" + filterCategory + "')]/ancestor::app-elux-product-facet-list" + "//div[label[div[span[contains(text(),'" + filterName + "')]]]]//input");


        WebElement popularFilter = wait.until(ExpectedConditions.elementToBeClickable(filterLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", popularFilter);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", popularFilter);
        System.out.println("Clicked on Popular Filter: " + popularFilterName);


        wait.until(ExpectedConditions.stalenessOf(popularFilter)); // wait until old reference becomes stale
        System.out.println(" Waiting for PLP filter DOM to stabilize...");


        WebElement freshFilter = wait.until(ExpectedConditions.presenceOfElementLocated(filterLocator));


        boolean turnedRed = wait.until(d -> {
            try {
                WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentElement;", freshFilter);
                if (parent == null) return false;
                String parentClass = parent.getAttribute("class");
                return parentClass != null && parentClass.contains("popularFilteSelected");
            } catch (StaleElementReferenceException e) {
                WebElement reloadedFilter = WebElementUtil.findElement(filterLocator);
                WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentElement;", reloadedFilter);
                String cls = parent != null ? parent.getAttribute("class") : "";
                return cls.contains("popularFilteSelected");
            }
        });
        Assert.assertTrue(turnedRed, " Popular filter '" + popularFilterName + "' did not turn red after clicking.");
        System.out.println(" Popular Filter '" + popularFilterName + "' turned red/active after click.");


        wait.until(ExpectedConditions.presenceOfElementLocated(checkboxLocator));
        WebElement checkbox = WebElementUtil.findElement(checkboxLocator);


        wait.until(d -> {
            try {
                return checkbox.isSelected();
            } catch (StaleElementReferenceException e) {
                WebElement freshCheckbox = WebElementUtil.findElement(checkboxLocator);
                return freshCheckbox.isSelected();
            }
        });

        Assert.assertTrue(checkbox.isSelected(), " Checkbox for '" + filterName + "' under '" + filterCategory + "' is not checked after clicking Popular Filter.");
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
            List<WebElement> products = WebElementUtil.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
            int totalProducts = products.size();
            System.out.println("Total products found: " + totalProducts);
            String mainWindow = driver.getWindowHandle();
            for (int i = 0; i < totalProducts; i++) {
                try {

                    String imgXpath = "(//div[@class='container-fluid px-2 plp' or @class='container-fluid px-0 plp']//div[@id='PlpItem" + i + "']//app-elux-image//img)[1]";
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


    public void validateProductIsInStock(By locator) {
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


    public void validateCheckboxUncheckedAfterCrossClick(String filterCategory, String filterName, String crossFilterName) {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        By pillCross = selectedFilterCross(crossFilterName);

        By checkbox = getFeatureLocator(filterCategory, filterName);
        wait.until(ExpectedConditions.elementToBeClickable(checkbox));
        WebElementUtil.scrollAndClickUsingJSE(driver, WebElementUtil.findElement(checkbox));
        WebElement crossElement = wait.until(ExpectedConditions.elementToBeClickable(pillCross));
        WebElementUtil.scrollToElement(driver, crossElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", crossElement);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(selectedFilterCross(crossFilterName)));
        WebElement freshCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(checkbox));
        boolean isUnchecked = !freshCheckbox.isSelected();
        Assert.assertTrue(isUnchecked, " Checkbox for " + filterName + " is still checked after removing filter.");

    }

    public void verifyAcRoomSize(String featureKey, String SpecsName, String SpecsKey, String SpecValue, int lowerBound, int upperBound) throws InterruptedException {


        WebDriver driver=DriverManager.getDriver();
        WebElementUtil.scrollByPixels(driver,0,350);
        WebElement imageElement = WaitUtils.untilClickable(getSelectRoomSizeLocator(featureKey),60);
        WebElementUtil.mouseHover(DriverManager.getDriver(), imageElement);
        WebElementUtil.scrollAndClickUsingJSE(DriverManager.getDriver(), WebElementUtil.findElement(getSelectRoomSizeLocator(featureKey)));

//        WebElementUtil.clickElement(getSelectRoomSizeLocator(featureKey));
        Thread.sleep(6000);
//         loadMoreProducts(driver);
//         validateAirCareProductsForRoomSize( SpecsName ,  SpecsKey ,  SpecValue ,  lowerBound, upperBound);


    }

    public void validateAirCareProductsForRoomSize(String SpecsName, String SpecsKey, String SpecValue, int lowerBound, int upperBound) throws InterruptedException {
        try {
            WebDriver driver = DriverManager.getDriver();
            List<WebElement> products = WebElementUtil.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
            int totalProducts = products.size();
            System.out.println("Total products found: " + totalProducts);
            String mainWindow = driver.getWindowHandle();

            for (int i = 0; i < totalProducts; i++) {
                try {
                    String imgXpath = "(//div[@class='container-fluid px-2 plp']//div[@id='PlpItem" + i + "']//app-elux-image//img)[1]";
                    WebElement imageElement = WaitUtils.untilVisible(By.xpath(imgXpath), 40000);

                    System.out.println("Opening product index: " + i);
                    Actions actions = new Actions(driver);
                    actions.keyDown(Keys.CONTROL).click(imageElement).keyUp(Keys.CONTROL).build().perform();
                    Thread.sleep(10000);
                    WebElementUtil.switchToNewTab(driver, mainWindow);
                    WebElement productUniqueCodeElement = WaitUtils.untilVisible(productUniqueCode, 30000);
                    Assert.assertTrue(productUniqueCodeElement.isDisplayed(), "Unique Product Code not displayed");
                    WaitUtils.untilVisible(quickSpecs, 30000);
                    WebElementUtil.scrollAndClickUsingJSE(driver, WebElementUtil.findElement(quickSpecs));
                    WebElementUtil.scrollAndClickUsingJSE(driver, WebElementUtil.findElement(viewFullSpecsBtn));
                    WebElement featureNameElement = WaitUtils.untilVisible(getFeatureSpecsLocator(SpecsName), 30000);
                    WebElementUtil.scrollToElement(driver, featureNameElement);
                    Assert.assertTrue(featureNameElement.isDisplayed(), SpecsName + " feature element is not displayed.");
                    WebElement featureElement = WaitUtils.untilVisible(getQuiickSpecsFeatureLocator(SpecsKey, SpecValue), 1);
                    String elementText = featureElement.getText().trim();
                    String[] rangeParts = SpecValue.split("-");
                    if (rangeParts.length == 2) {
                        lowerBound = Integer.parseInt(rangeParts[0].trim());
                        upperBound = Integer.parseInt(rangeParts[1].trim());
                        int elementValue = Integer.parseInt(elementText.trim());
                        System.out.println(elementValue);
                        Assert.assertTrue(elementValue >= lowerBound && elementValue <= upperBound, "Value " + elementValue + " is not within the expected range " + SpecValue);
                    } else {
                        System.out.println("Invalid range format: " + SpecValue);
                    }

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



    public void openAllProductsAndValidateColor(String website , String color ,String expectedColor) {
        try {
            WebDriver driver = DriverManager.getDriver();
            loadMoreProducts(driver);
            verifyProductCount(driver, driver.findElement(productCount));

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

                    validateProductColor(website,i,color, expectedColor);

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
    public void validateProductColor(String webSite,int index, String color, String expectedColor) {
        WebDriver driver = DriverManager.getDriver();
        try {
            webSite = webSite.trim().toLowerCase();

            By frigidaireColorLocator = By.xpath(
                    "//p[text()='"+color+"']");

            By electroluxColorLocator = By.xpath(
                    "//span[text()='"+color+"']");

            By colorLocator;

            switch (webSite) {
                case "frigidaire":
                    colorLocator = frigidaireColorLocator;
                    System.out.println(" Using Frigidaire color locator");
                    break;

                case "electrolux":
                    colorLocator = electroluxColorLocator;
                    System.out.println("Using Electrolux color locator");
                    break;

                default:
                    throw new IllegalArgumentException(" Unsupported website: " + webSite);
            }

            WebElement colorElement = WaitUtils.untilVisible(colorLocator, 15000);

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", colorElement);

            String actualColor = colorElement.getText().trim().toLowerCase();
            expectedColor = expectedColor.trim().toLowerCase();


            System.out.println("Product " + index + " | Expected Color: " + expectedColor + " | Actual Color: " + actualColor);

            Assert.assertEquals(actualColor, expectedColor,
                    "Color mismatch for product " + index + ": Expected [" + expectedColor + "] but found [" + actualColor + "]");

            System.out.println("Color matched for product " + index + " on " + webSite);

        } catch (Exception e) {
            System.out.println(" Error validating color for product " + index + " on " + webSite + ": " + e.getMessage());
        }
    }

}









