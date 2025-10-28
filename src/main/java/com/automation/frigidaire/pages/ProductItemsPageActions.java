package com.automation.frigidaire.pages;

import com.automation.frigidaire.utils.DriverManager;
import com.automation.frigidaire.utils.WaitUtils;
import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ProductItemsPageActions {
    private final By sortByDropdownBtn=By.xpath("//div[@id='sortByFacet']//div[@class='ng-select-container ng-has-value']");
    private final By emailPopUp=By.xpath("//span[@id=\"close-modal123\"]");
    private final By standardWidth=By.xpath("//b[text()=\"Standard Width \"]/ancestor::app-elux-product-facet-list//div[label[div[span[text()=' 36\" ']]]]/input\n");
   // private final By standardWidthProductCount=By.xpath("//span[contains(text(),'W:')]/following-sibling::span[@class='font-weight-bold']");
   private final By loadMoreBtn =By.xpath("//div[@class='row col-12 load-more']//button[text()=' Load more ']");
    private final By productCount =By.xpath("//span[@name='ProductsCount']");

    private final By viewFullSpecsBtn =By.xpath("//button[text()='View full specs']");
    private final By quickSpecs =By.xpath("//div[@id='QuickSpecAccrd']");
    private final By specificationsHeading =By.xpath("//h3[text()='Specifications']");

    private final By resetAllButton=By.xpath("//span[text()=\" Hide filters\"]/ancestor::div//span[text()=\" Reset all \"]");
   private final By productUniqueCode =By.xpath("//h2[@class='prod_id Utility-TextProduct-SKU-Sm ng-star-inserted']");

    public By getFeatureLocator(String featureKey, String featureValue) {
        return By.xpath("//div[@class='heading col-8']//span[text()='"
                + featureKey + "']/parent::div/following-sibling::div//span[normalize-space(text()='"
                + featureValue + "')]");
    }


    public void verifyProductItemPage(String text)
    {
        By locator = By.xpath("//h1[normalize-space(text())='"+text+"']");
        System.out.println(locator);
        WebElementUtil.waitForElementToBeVisible(locator);
        String s1=  WebElementUtil.getText(locator);
        Assert.assertEquals(s1,"French Door Refrigerators");
    }

    public void verifyFiltersInProductItems(String text, int time ,String assertValue)
    {

        try {
             WebDriver driver = DriverManager.getDriver();
             WebElementUtil.zoomInOrOut(25);

             System.out.println("scrolled successfully");
             String actualElement = driver.findElement(productFilterItem(text)).getText();
             Assert.assertEquals(actualElement, assertValue);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public void verifySortBy(String text, int time ,String assertValue)
    {

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

    public void selectSortByDropDown(String text, int time ,String assertValue)
    {

        try {
           WaitUtils.untilVisible(sortByDropdownBtn,30);
           WebElementUtil.clickElement(sortByDropdownBtn);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



    public ProductItemsPageActions clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
        return this;
    }


    public By productFilterItem(String text) {
        By locator = By.xpath("//b[normalize-space(text())='"+text+"']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
        return locator;
    }

    public By productSortBy(String text) {
        By locator = By.xpath("//span[normalize-space(text())='"+text+"']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
        return locator;
    }

    public void verifyHideAndShowAllFilters(String text) {
        By locator = By.xpath("//span[normalize-space(text())='"+text+"']");
       WebElement element = WebElementUtil.waitForElementToBeVisible(locator);
       Assert.assertTrue(element.isDisplayed(),"Not able to load Filter in the page");
       WebElementUtil.clickElement(locator);
    }
    public void verifyHideFilters(String text) {
        By locator = By.xpath("//span[normalize-space(text())='"+text+"']");
        WebElement element = WebElementUtil.waitForElementToBeVisible(locator);
        Assert.assertTrue(element.isDisplayed(),"Not able to load Filter in the page");

    }


    public void closeEmailPopUp()
    {
        WaitUtils.untilVisible(emailPopUp,60);
        Assert.assertTrue(WebElementUtil.isDisplayed(emailPopUp), "Email popup should be displayed before closing.");
        WebElementUtil.clickElement(emailPopUp);
        Assert.assertFalse(WebElementUtil.isDisplayed(emailPopUp), "Email popup should not be displayed after closing.");


    }

    public void standardWidthClick() throws InterruptedException {
        WaitUtils.untilVisible(standardWidth,60);
        WebElementUtil.clickElement(standardWidth);
        Thread.sleep(3000);
//        for(WebElement element: elements){
//            System.out.println(element.getText());
//        }
    }


    public void verifyProductWidthHeightAndDepth() throws InterruptedException
    {

   WebDriver driver = DriverManager.getDriver();
       By width= By.xpath("//b[text()=\"Standard Width \"]/ancestor::app-elux-product-facet-list//div[label[div[span[contains(text(),' 36')]]]]/input");
       WaitUtils.untilVisible(width,60);
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


    public void verifyProductPrice(double minPrice,double maxPrice ,String priceRange) {
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

//    public void featureFilter(String text1 , String text2) throws InterruptedException {
//        WebDriver driver=DriverManager.getDriver();
//        WebElement clickFeatureFilture=driver.findElement(By.xpath("//b[text()='"+text1+"']/ancestor::app-elux-product-facet-list//div[label[div[span[text()='"+text2+"']]]]//input\n"));
//        WebElement clickFeatureFilture=driver.findElement(By.xpath("//b[text()='"+text1+"']/ancestor::app-elux-product-facet-list//div[label[div[span[text()='"+text2+"']]]]//input/following-sibling::label\n"));
//
//
//        WaitUtils.untilVisible(clickFeatureFilture,60);
//        WebElementUtil.safeClick(driver,clickFeatureFilture);
//        //WebElementUtil.clickElement(clickFeatureFilture);
//        Thread.sleep(3000);
//    }

    public void featureFilter(String text1, String text2) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();

        String xpath1 = "//b[contains(text(),'" + text1 + "')]/ancestor::app-elux-product-facet-list//div[label[div[span[contains(text(),'" + text2 + "')]]]]//input";

        String xpath2 = "//b[contains(text(),'" + text1 + "')]/ancestor::app-elux-product-facet-list//div[label[div[span[contains(text(),'" + text2 + "')]]]]//input/following-sibling::label";

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

//        if (isChecked) {
//            System.out.println("☑ The checkbox is already checked for filter: " + text2);
//        } else {
//            System.out.println("The checkbox is currently unchecked for filter: " + text2);
//        }
        Assert.assertFalse(isChecked, "Checkbox for filter '" + text2 + "' should be unchecked before clicking.");
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
            System.out.println("✔ Filter '" + filterText + "' is visible under selected filters.");
        } catch (TimeoutException e) {
            Assert.fail("The filter '" + filterText + "' was not found under selected filters.");
        }
WebElement verifyResetAll=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        Assert.assertTrue(verifyResetAll.isDisplayed(), "The Hidden filter is not displayed.");
        WebElementUtil.clickElement(resetAllButton);

        Thread.sleep(6000);
        List<WebElement> filtersAfterReset = driver.findElements(By.xpath(xpath));
        Assert.assertTrue(filtersAfterReset.isEmpty(),
                "The filter '" + filterText + "' should NOT be visible after clicking Reset All.");
        System.out.println("✔ Filter '" + filterText + "' is no longer selected after Reset All.");

    }


    public void verifyExpandAndCollapseFilter(String facetName, String filterValue) throws InterruptedException {

        WaitUtils.untilVisible(resetAllButton,10000);
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
        WebElementUtil.scrollAndClickUsingJSE(driver,driver.findElement(facetLocator));
        System.out.println("clicked on facet Locator");
        boolean isInvisible = true;
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(filterValueXPath)));
            System.out.println("✅ Filter value is no longer visible after collapsing — PASS");
        } catch (TimeoutException e) {
            isInvisible = false;
            System.out.println("❌ Filter value is still visible after collapsing — FAIL");
        }

        Assert.assertTrue(isInvisible, "Filter value should be invisible after collapsing the filter group.");

        // Optional: small pause for visual verification in UI
        Thread.sleep(1000);
    }

//    public void verifyExpandAndCollapseFilter(String text) {
//       By locator= expandAndCollapseFilter("Series ");
//        WebElementUtil.clickElement(locator);
//        //b[text()="Series "]/ancestor::app-elux-product-facet-list//div[label[div[span[normalize-space(text())="Frigidaire"]]]]
//    }





    public void clickOnSortByDropDownvalues(String text , String assertValue) throws InterruptedException {
        WebDriver driver=DriverManager.getDriver();
        WaitUtils.untilVisible(sortByDropdownBtn,10000);
        //WebElementUtil.clickElementUsingJSE(driver,sortByDropdownBtn);
          WebElementUtil.clickElement(sortByDropdownBtn);
        String selectedSortBy=driver.findElement(getSortOptionByText(text)).getText();
        System.out.println(selectedSortBy);
        Thread.sleep(3000);
        WaitUtils.untilVisible(getSortOptionByText(text),60);
        Assert.assertEquals(selectedSortBy,assertValue);
        WebElementUtil.clickElement(getSortOptionByText(text));
        Thread.sleep(6000);

    }

    public void clickOnLoadMoreBtn() throws InterruptedException
    {
        WebDriver driver=DriverManager.getDriver();


        WaitUtils.untilVisible(loadMoreBtn,60);

        WebElement element =driver.findElement(loadMoreBtn);
        WebElementUtil.scrollToElement(driver,element);
        WaitUtils.untilClickable(element,4000);
        WebElementUtil.scrollAndClickUsingJSE(driver,element);

        System.out.println("clicked on load more btn ");

       // System.out.println("clicked on load more btn--------- ");
        Thread.sleep(7000);
        WebElementUtil.scrollUp(driver,6000);

    }
    public By expandAndCollapseFilter(String text) {

     //  return  By.xpath("//div[div[@class='acc-header-srp Body-LargeBody_Large-Bold widthMob row ng-star-inserted']]//div[div[b[normalize-space(text())='"+text+"']]]/following-sibling::div[@class='col-md-2 col-lg-2 col-2 text-right paddingMob0']/img");

        return By.xpath("//b[normalize-space(text())='" + text +
                "' and @class='text-capitalize widthFMob']" +
                "/ancestor::div[@class='acc-header-srp Body-LargeBody_Large-Bold widthMob row']" +
                "//img[@class='header-icon']");


    }
    public By getSortOptionByText(String optionText) {
        String xpath = String.format("//div[@role='listbox']//span[text()='"+optionText+"']");
        return By.xpath(xpath);
    }


    public void verifyPriceLowToHighSort() {
        WebDriver driver = DriverManager.getDriver();
        try {

            List<WebElement> products = driver.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
            int totalProducts = products.size();
            System.out.println("Total products found: " + totalProducts);

            // Create a list to store product prices
            List<Double> productPrices = new ArrayList<>();

            for (int i = 0; i < totalProducts; i++) {
                String priceXpath = "//div[@id='PlpItem" + i + "']//div[@class='container price d-flex justify-content-flex-start align-items-center']/span[@class='H3H3_Desktop color-promo-green']";
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
            List<WebElement> products = driver.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
            int totalProducts = products.size();
            System.out.println("Total products found: " + totalProducts);
            List<Double> productSavings = new ArrayList<>();
            List<Integer> productIndexes = new ArrayList<>();

            for (int i = 0; i < totalProducts; i++) {

                String actualPriceXpath = "//div[@id='PlpItem" + i + "']//div[@class='container price d-flex justify-content-flex-start align-items-center']//s[@class='Utility-TextStrike-Through-Price']";
                WebElement actualPriceElement = driver.findElement(By.xpath(actualPriceXpath));
                String discountedPriceXpath = "//div[@id='PlpItem" + i + "']//div[@class='container price d-flex justify-content-flex-start align-items-center']/span[@class='H3H3_Desktop color-promo-green']";
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
                List<WebElement> products = driver.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
                int totalProducts = products.size();
                System.out.println("Total products found: " + totalProducts);

                List<Double> productPrices = new ArrayList<>();

                for (int i = 0; i < totalProducts; i++) {
                    String priceXpath = "//div[@id='PlpItem" + i + "']//div[@class='container price d-flex justify-content-flex-start align-items-center']/span[@class='H3H3_Desktop color-promo-green']";
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


        public void openAllProductsAndValidate(String featureName, String featureKey, String featureValue) {
            try {
                WebDriver driver = DriverManager.getDriver();
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);



                    // Click "Load More" until it's gone
                    while (true) {
                        try {
                            WebElement loadMoreElement = driver.findElement(loadMoreBtn);

                            if (loadMoreElement.isDisplayed()) {
                                WebElementUtil.scrollAndClickUsingJSE(driver, loadMoreElement);
                                // Wait for new products to load
                                Thread.sleep(5000);
                                WebElement productCountElement =WaitUtils.untilVisible((productCount),40000);
                                WebElementUtil.scrollToElement(driver,productCountElement);
                                Assert.assertTrue(productCountElement.isDisplayed(),"Not displayed");
                                System.out.println(productCountElement.getText());

                            } else {
                                break;
                            }
                        } catch (Exception e) {
                            break; // Load More not present
                        }
                    }

//                WebElement loadMoreElement= driver.findElement(loadMoreBtn);
//                WebElementUtil.scrollAndClickUsingJSE(driver,loadMoreElement);
                List<WebElement> products = driver.findElements(By.xpath("//div[starts-with(@id,'PlpItem')]"));
                int totalProducts = products.size();
                System.out.println("Total products found: " + totalProducts);
                String mainWindow = driver.getWindowHandle();
                for (int i = 0; i < totalProducts; i++) {
                    try {
                        // Dynamic XPath — always picks the first image
                        String imgXpath = "(//div[@class='container-fluid px-2 plp']//div[@id='PlpItem" + i + "']//app-elux-image//img)[1]";
                        WebElement imageElement = WaitUtils.untilVisible((By.xpath(imgXpath)),40000);

                        System.out.println("🛍 Opening product index: " + i);
                        Actions actions = new Actions(driver);
                        actions.keyDown(Keys.CONTROL).click(imageElement).keyUp(Keys.CONTROL).build().perform();
                        Thread.sleep(10000);
//                        switchToNewTab(mainWindow);
                        WebElementUtil.switchToNewTab(driver,mainWindow);
                        validateProduct(i,featureName ,featureKey,featureValue);
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


        /** Validation logic for each product */
//        private void validateProduct(int index , String featureName, String featureKey, String featureValue) {
//            try {
//                WebDriver driver = DriverManager.getDriver();
//                System.out.println("Validating product index " + index);
//                System.out.println("Current URL: " + driver.getCurrentUrl());
//
//                WebElement featureNameElement=driver.findElement(getFeatureSpecsLocator(featureName));
//                // Find and store the WebElement
//                WebElement productUniqueCodeElement = driver.findElement(productUniqueCode);
//                WaitUtils.untilVisible(productUniqueCode,30000);
//                Assert.assertTrue(productUniqueCodeElement.isDisplayed(),"Unique Product Code not displayed");
//                WaitUtils.untilVisible(quickSpecs,30000);
//                WebElementUtil.scrollAndClickUsingJSE(driver,driver.findElement(quickSpecs));
//                WaitUtils.untilVisible(viewFullSpecsBtn,30000);
//                WebElementUtil.scrollAndClickUsingJSE(driver,driver.findElement(viewFullSpecsBtn));
//                WebElementUtil.scrollToElement(driver,driver.findElement(getFeatureSpecsLocator("Ice Maker")));
//                Assert.assertTrue(featureNameElement.isDisplayed(), "Ice Maker element is not displayed.");
//                WebElement featureElement = driver.findElement(getFeatureLocator(featureName, featureValue));
//                String elementText = featureElement.getText().trim();
//                Assert.assertTrue(featureNameElement.isDisplayed(), " element is not displayed.");
//                Assert.assertEquals(elementText, featureValue, featureName + " with value " + featureValue + " is not displayed correctly. Found: " + elementText);
//
//
//            } catch (Exception e) {
//                System.out.println("Validation failed for product index " + index + ": " + e.getMessage());
//            }
//        }

        private void validateProduct(int index, String featureName, String featureKey, String featureValue) {
            try {
                WebDriver driver = DriverManager.getDriver();
                System.out.println("Validating product index " + index);
                System.out.println("Current URL: " + driver.getCurrentUrl());

                // Wait for and get the feature element by name (like 'Ice Maker')


                // Wait for the unique product code element and assert its visibility
                WebElement productUniqueCodeElement = WaitUtils.untilVisible(productUniqueCode, 30000);
                System.out.println(productUniqueCodeElement);
                Assert.assertTrue(productUniqueCodeElement.isDisplayed(),"Unique Product Code not displayed");


                System.out.println("unique prod check");
                // Wait for and click the "Quick Specs" button
                WaitUtils.untilVisible(quickSpecs, 30000);
                WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(quickSpecs));
                System.out.println("quick specs check");
                // Wait for and click the "View Full Specs" button

                WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(viewFullSpecsBtn));
                WebElement specifications = WaitUtils.untilVisible(specificationsHeading, 30000);
                WebElementUtil.mouseHover(driver,specifications);

                WebElement featureNameElement=WaitUtils.untilVisible(getFeatureSpecsLocator(featureName),30000);

                // Scroll to the feature and validate that the feature name element is displayed
                WebElementUtil.scrollToElement(driver, featureNameElement);
                Assert.assertTrue(featureNameElement.isDisplayed(),featureName + " feature element is not displayed.");

                // Find and validate the feature value (e.g., "Yes" for Ice Maker)
                WebElement featureElement = WaitUtils.untilVisible(getFeatureLocator(featureKey, featureValue), 30000);
                String elementText = featureElement.getText().trim();

                // Validate that the feature element's text matches the expected value
                Assert.assertEquals(elementText,featureValue,"Value Mismatch");

                // Optionally, print the value for debugging purposes
                System.out.println("Feature value for " + featureKey + ": " + elementText);

            } catch (Exception e) {
                System.out.println("Validation failed for product index " + index + ": " + e.getMessage());
            }
        }


    public By getFeatureSpecsLocator(String text) {
        return By.xpath("//h5[text()='" + text + "']");
    }

}








