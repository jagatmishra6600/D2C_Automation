package com.automation.electrolux.pages;


import com.automation.electrolux.locators.DeliveryAndInstallationLocatorsElux;
import com.automation.frigidaire.locators.DeliveryAndInstallationLocatorsFrig;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


import static com.automation.electrolux.pages.PLPProductItemsPageActionsElux.addToCart;

public class DeliveryInstallationPageActionsElux {
    private final WebDriver driver;


    public DeliveryInstallationPageActionsElux() {
        this.driver = DriverManager.getDriver();
    }

    public void selectProductAndAddToCart(int productIndex) throws InterruptedException {
        try {
            WebDriver driver = DriverManager.getDriver();
            String productXPath =
                    "//div[(contains(@class,'container-fluid px-2 plp') or " +
                            "contains(@class,'container-fluid Appliance-Card'))]" +
                            "//div[@id='PlpItem" + productIndex + "']" +
                            "//div[contains(@class,'Product-Image-Placeholder')]" +
                            "//app-elux-image";

            By productLocator=By.xpath(productXPath);

            com.automation.utils.WebElementUtil.scrollToElement(driver, driver.findElement(By.xpath(productXPath)));
            WebElementUtil.waitForElementToBeClickable(productLocator,60);
            com.automation.utils.WebElementUtil.scrollAndClickUsingJSE(driver, productLocator);
            WebElementUtil.scrollByPixels(driver, 0, 500);
            WaitUtils.sleep(60);
            WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(addToCart));
            WaitUtils.sleep(60);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void verifyHeadingAndSubLinksinDAndSPage(String label) {
        By radioButton = DeliveryAndInstallationLocatorsElux.getRadioButton(label);
        WebElementUtil.waitForElementToBeClickable(radioButton,60);
        WebElementUtil.scrollToElementStable(radioButton);
        WebElementUtil.isDisplayed(radioButton);
        WebElementUtil.scrollToElementStable(DeliveryAndInstallationLocatorsElux.viewIncludedPartsLink);
        WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(DeliveryAndInstallationLocatorsElux.viewIncludedPartsLink));
    }


    public void verifyPopupTextIsVisible() {
        try {

            WaitUtils.untilVisible(DeliveryAndInstallationLocatorsElux.DeliveryAndAppliancePopUp);
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsElux.DeliveryAndAppliancePopUp);
            WaitUtils.untilVisible(DeliveryAndInstallationLocatorsElux.DAndAppIncludedProductTxt);
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsElux.DAndAppIncludedProductTxt);
            WaitUtils.untilVisible(DeliveryAndInstallationLocatorsElux.includeWithService("Included with service:"));
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsElux.includeWithService("Included with service:"));
            WaitUtils.untilVisible(DeliveryAndInstallationLocatorsElux.includeWithService("Delivery"));
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsElux.includeWithService("Delivery"));
            WaitUtils.untilVisible(DeliveryAndInstallationLocatorsElux.includeWithService("Installation (ready to use)"));
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsElux.includeWithService("Installation (ready to use)"));
            WaitUtils.untilVisible(DeliveryAndInstallationLocatorsElux.includeWithService("Total"));
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsElux.includeWithService("Total"));
            WaitUtils.sleep(5000);
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsElux.viewIncludePartsClosePopUpButton);
            WaitUtils.untilVisible(DeliveryAndInstallationLocatorsElux.viewIncludePartsClosePopUpButton).click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyProtectionPlanSection(String brand) {
        try {
           WaitUtils.untilVisible(DeliveryAndInstallationLocatorsElux.selectProtectionHeading);
           WebElementUtil.scrollToElementStable(DeliveryAndInstallationLocatorsElux.selectProtectionHeading);
           WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsElux.selectProtectionHeading);
            WaitUtils.untilVisible(DeliveryAndInstallationLocatorsElux.protectionPlanSubText);
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsElux.protectionPlanSubText);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean isDeclineProtectionVisible() {
        try {
            WebDriver driver=DriverManager.getDriver();
            WaitUtils.waitForVisibility(driver, DeliveryAndInstallationLocatorsFrig.declineprotectionBy,60);
            WebElementUtil.waitForClickable(driver, DeliveryAndInstallationLocatorsFrig.declineprotectionBy,60);
            WebElementUtil.clickElementUsingJSE(driver, DeliveryAndInstallationLocatorsFrig.declineprotectionBy);
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsFrig.declineprotectionBy);
           return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void validateProtectionPlanPrice(String brand, String year) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();


            By yearLocator = DeliveryAndInstallationLocatorsElux.getYearLocatorForElectrolux(year);
            WebElementUtil.waitForElementToBeVisible(yearLocator, 60);
            WebElementUtil.clickElementUsingJSE(driver, yearLocator);
            double extractedPrice = extractPrice(DeliveryAndInstallationLocatorsElux.getPriceLocatorForElectrolux(year));
            WebElementUtil.scrollByPixels(driver, 550, 0);
//            WebElementUtil.scrollToElement(driver, driver.findElement(FE_DeliveryAndInstallation.installationServices));
            WebElementUtil.scrollToElement(driver, driver.findElement(DeliveryAndInstallationLocatorsElux.protectionPlanPriceForElectrolux));
            WaitUtils.sleep(5000);
//            WaitUtils.untilVisible(FE_DeliveryAndInstallation.installationServices, 60);
//            WebElement installationServicePlanElement = driver.findElement(FE_DeliveryAndInstallation.installationServices);
//            String installationServicePlanText = installationServicePlanElement.getText();
//            System.out.println(installationServicePlanText);
//            String cleanedProtectionPlanPrices = installationServicePlanText.replaceAll("[$]", "");// Remove '$' and ',' for example
//            System.out.println(cleanedProtectionPlanPrices);

            WaitUtils.untilVisible(DeliveryAndInstallationLocatorsElux.protectionPlanPriceForElectrolux, 60);
            WebElement protectionPlanElement = driver.findElement(DeliveryAndInstallationLocatorsElux.protectionPlanPriceForElectrolux);
            String protectionPlanText = protectionPlanElement.getText();
            String cleanedProtectionPlanPrice = protectionPlanText.replaceAll("[^0-9.]", "");
            //  double installationPlanPrice = Double.parseDouble(cleanedProtectionPlanPrices);
            double protectionPlanPrice = Double.parseDouble(cleanedProtectionPlanPrice);
            Assert.assertEquals(extractedPrice, protectionPlanPrice, "Price Mismatch");
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsElux.subTotalPrice);
            WebElement subTotalPrice = driver.findElement(DeliveryAndInstallationLocatorsElux.subTotalPrice);
            String GetSubtotalPrice = subTotalPrice.getText().replaceAll("[^0-9.]", "");
            double subtotal = Double.parseDouble(GetSubtotalPrice);
            double totalPrice = subtotal +  protectionPlanPrice;
            WebElement totalPriceElement = driver.findElement(DeliveryAndInstallationLocatorsElux.totalPriceForElectrolux);
            String totalPriceText = totalPriceElement.getText();
            String cleanedTotalPrice = totalPriceText.replaceAll("[^0-9.]", "");
            double displayedTotalPrice = Double.parseDouble(cleanedTotalPrice);
            Assert.assertEquals(totalPrice, displayedTotalPrice, "ERROR: The total price does not match!");
            WebElementUtil.waitForElementToBeVisible(yearLocator, 60);
            WebElementUtil.scrollToElement(driver, driver.findElement(yearLocator));
        }


    public double extractPrice(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        return Double.parseDouble(text.replace("$", "").replace(",", "").trim());
    }

}
