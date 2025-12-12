package com.automation.electrolux.pages;


import com.automation.electrolux.locators.DeliveryAndInstallationLocator_Elux;
import com.automation.frigidaire.locators.DeliveryAndInstallation_Frig;
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


import static com.automation.electrolux.pages.PLPProductItemsPageActions_Elux.addToCart;

public class DeliveryInstallationPageActions_Elux {
    private final WebDriver driver;


    public DeliveryInstallationPageActions_Elux() {
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
        By radioButton = DeliveryAndInstallationLocator_Elux.getRadioButton(label);
        WebElementUtil.waitForElementToBeClickable(radioButton,60);
        WebElementUtil.scrollToElementStable(radioButton);
        WebElementUtil.isDisplayed(radioButton);
        WebElementUtil.scrollToElementStable(DeliveryAndInstallationLocator_Elux.viewIncludedPartsLink);
        WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(DeliveryAndInstallationLocator_Elux.viewIncludedPartsLink));
    }


    public void verifyPopupTextIsVisible() {
        try {

            WaitUtils.untilVisible(DeliveryAndInstallationLocator_Elux.DeliveryAndAppliancePopUp);
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocator_Elux.DeliveryAndAppliancePopUp);
            WaitUtils.untilVisible(DeliveryAndInstallationLocator_Elux.DAndAppIncludedProductTxt);
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocator_Elux.DAndAppIncludedProductTxt);
            WaitUtils.untilVisible(DeliveryAndInstallationLocator_Elux.includeWithService("Included with service:"));
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocator_Elux.includeWithService("Included with service:"));
            WaitUtils.untilVisible(DeliveryAndInstallationLocator_Elux.includeWithService("Delivery"));
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocator_Elux.includeWithService("Delivery"));
            WaitUtils.untilVisible(DeliveryAndInstallationLocator_Elux.includeWithService("Installation (ready to use)"));
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocator_Elux.includeWithService("Installation (ready to use)"));
            WaitUtils.untilVisible(DeliveryAndInstallationLocator_Elux.includeWithService("Total"));
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocator_Elux.includeWithService("Total"));
            WaitUtils.sleep(5000);
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocator_Elux.viewIncludePartsClosePopUpButton);
            WaitUtils.untilVisible(DeliveryAndInstallationLocator_Elux.viewIncludePartsClosePopUpButton).click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyProtectionPlanSection(String brand) {
        try {
           WaitUtils.untilVisible(DeliveryAndInstallationLocator_Elux.selectProtectionHeading);
           WebElementUtil.scrollToElementStable(DeliveryAndInstallationLocator_Elux.selectProtectionHeading);
           WebElementUtil.isDisplayed(DeliveryAndInstallationLocator_Elux.selectProtectionHeading);
            WaitUtils.untilVisible(DeliveryAndInstallationLocator_Elux.protectionPlanSubText);
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocator_Elux.protectionPlanSubText);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean isDeclineProtectionVisible() {
        try {
            WebDriver driver=DriverManager.getDriver();
            WaitUtils.waitForVisibility(driver, DeliveryAndInstallation_Frig.declineprotectionBy,60);
            WebElementUtil.waitForClickable(driver, DeliveryAndInstallation_Frig.declineprotectionBy,60);
            WebElementUtil.clickElementUsingJSE(driver, DeliveryAndInstallation_Frig.declineprotectionBy);
            WebElementUtil.isDisplayed(DeliveryAndInstallation_Frig.declineprotectionBy);
           return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void validateProtectionPlanPrice(String brand, String year) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();


            By yearLocator = DeliveryAndInstallationLocator_Elux.getYearLocatorForElectrolux(year);
            WebElementUtil.waitForElementToBeVisible(yearLocator, 60);
            WebElementUtil.clickElementUsingJSE(driver, yearLocator);
            double extractedPrice = extractPrice(DeliveryAndInstallationLocator_Elux.getPriceLocatorForElectrolux(year));
            WebElementUtil.scrollByPixels(driver, 550, 0);
//            WebElementUtil.scrollToElement(driver, driver.findElement(FE_DeliveryAndInstallation.installationServices));
            WebElementUtil.scrollToElement(driver, driver.findElement(DeliveryAndInstallationLocator_Elux.protectionPlanPriceForElectrolux));
            WaitUtils.sleep(5000);
//            WaitUtils.untilVisible(FE_DeliveryAndInstallation.installationServices, 60);
//            WebElement installationServicePlanElement = driver.findElement(FE_DeliveryAndInstallation.installationServices);
//            String installationServicePlanText = installationServicePlanElement.getText();
//            System.out.println(installationServicePlanText);
//            String cleanedProtectionPlanPrices = installationServicePlanText.replaceAll("[$]", "");// Remove '$' and ',' for example
//            System.out.println(cleanedProtectionPlanPrices);

            WaitUtils.untilVisible(DeliveryAndInstallationLocator_Elux.protectionPlanPriceForElectrolux, 60);
            WebElement protectionPlanElement = driver.findElement(DeliveryAndInstallationLocator_Elux.protectionPlanPriceForElectrolux);
            String protectionPlanText = protectionPlanElement.getText();
            String cleanedProtectionPlanPrice = protectionPlanText.replaceAll("[^0-9.]", "");
            //  double installationPlanPrice = Double.parseDouble(cleanedProtectionPlanPrices);
            double protectionPlanPrice = Double.parseDouble(cleanedProtectionPlanPrice);
            Assert.assertEquals(extractedPrice, protectionPlanPrice, "Price Mismatch");
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocator_Elux.subTotalPrice);
            WebElement subTotalPrice = driver.findElement(DeliveryAndInstallationLocator_Elux.subTotalPrice);
            String GetSubtotalPrice = subTotalPrice.getText().replaceAll("[^0-9.]", "");
            double subtotal = Double.parseDouble(GetSubtotalPrice);
            double totalPrice = subtotal +  protectionPlanPrice;
            WebElement totalPriceElement = driver.findElement(DeliveryAndInstallationLocator_Elux.totalPriceForElectrolux);
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
