package com.automation.electrolux.pages;

import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ElectroluxOutOfStock {

    private final By emailPopUp = By.xpath("//span[@id=\"close-modal123\"]");
    private final By freeDelivery = By.xpath("//p[contains(normalize-space(.), \"Free delivery\")]\n");
    private final By earliestDelivery = By.xpath("//p[contains(text(), 'Earliest delivery')]");
    private static final By addToCart = By.xpath("//span[normalize-space()='Add to cart']");
    private final By outOfStock = By.xpath("//span[contains(text(), 'Temporarily out of stock in your area.')]");
    private final By emailField = By.xpath("//div[@id='container_EMAIL']//input[@name='Email']");
    private final By notify = By.xpath("//div[@id='container_EMAIL']//input[@name='submitBtn']");
    private final By notifyVerify = By.xpath("//span[contains(text(), 'You’re signed up')]");


    public void clickOnProductMenu(String text) {
        By locator = By.xpath("//h5[normalize-space(text())='" + text + "']");
        WebElementUtil.waitForElementToBeVisible(locator);
        WebElementUtil.clickElement(locator);
    }

    public void closeEmailPopUp() {
        WaitUtils.untilVisible(emailPopUp, 60);
        WebElementUtil.clickElement(emailPopUp);
    }

    public void verifyStockForVacuums(int i) throws InterruptedException {
        boolean result = selectProductAndCheckAddToCart(i);
        WebDriver driver = DriverManager.getDriver();
        if (result) {
            WebElementUtil.zoomInOrOut(50);
            WebElement freeDeliveryText = driver.findElement(freeDelivery);
            String actual = freeDeliveryText.getText();
            String partialText = "Free delivery";
            Assert.assertTrue(actual.contains(partialText));

            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
        } else {
            checkOutOfStock();
        }
    }
    public void verifyStockForLaundry(int i) throws InterruptedException {
        boolean result=selectProductAndCheckAddToCart(i);
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        if (result) {
            WebElementUtil.zoomInOrOut(50);
            WaitUtils.implicitWait(15);
            WebElement freeDeliveryText = wait.until(ExpectedConditions.visibilityOfElementLocated(earliestDelivery));
            Assert.assertTrue(freeDeliveryText.getText().contains("Earliest delivery"));
            System.out.println("Product is in stock. Verifying Add to Cart...");
            WaitUtils.implicitWait(2);
            driver.navigate().back();
            WaitUtils.implicitWait(2);
        } else {
            checkOutOfStock();
        }
    }
    public static boolean selectProductAndCheckAddToCart(int i) {
        WebElementUtil.zoomInOrOut(35);
        By productXpath = By.xpath("//div[@id=\"PlpItem"+i+"\"]//div[@class=\"Product-title Body-XLargeBody_XLarge-Title m-auto\"]");
        WebElementUtil.waitForElementToBeClickable(productXpath);
        WebElementUtil.clickElement(productXpath);
        System.out.println("Clicked on product: ");
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        boolean isAddToCartPresent;
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(addToCart));
            isAddToCartPresent = true;
            System.out.println("'Add to cart' button is visible for product: ");
        } catch (TimeoutException e) {
            isAddToCartPresent = false;
            System.out.println(" Temporarily out of stock in your area for product: ");
        }
        return isAddToCartPresent;
    }
    public void checkOutOfStock() throws InterruptedException {
        WebElementUtil.zoomInOrOut(40);
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement outOfStockText = wait.until(ExpectedConditions.visibilityOfElementLocated(outOfStock));
        Assert.assertTrue(outOfStockText.getText().contains("Temporarily out of stock in your area."));

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        emailInput.clear();
        emailInput.sendKeys("rajatverma11@gmail.com");

        WebElement notifyButton = wait.until(ExpectedConditions.elementToBeClickable(notify));
        notifyButton.click();
        System.out.println("Clicked Notify button.");

        WebElement verifyText = wait.until(ExpectedConditions.visibilityOfElementLocated(notifyVerify));
        Assert.assertTrue(verifyText.getText().contains("You’re signed up"));
        System.out.println("Notification confirmation verified.");

        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
    }

    public void checkPlpItem(String ProductName) throws InterruptedException {
        WebElementUtil.zoomInOrOut(60);
        Thread.sleep(5000);
        WebDriver driver = DriverManager.getDriver();
        List<WebElement> items = driver.findElements(By.xpath("//div[starts-with(@id, 'PlpItem')]"));
        for (int i = 0; i < 5; i++) {
            if(ProductName.equalsIgnoreCase("Vacuums")){
                verifyStockForVacuums(i);
            } else if (ProductName.equalsIgnoreCase("Laundry")) {
                verifyStockForLaundry(i);
            }
        }
    }
}
