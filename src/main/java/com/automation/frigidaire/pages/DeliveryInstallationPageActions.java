package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.FE_DeliveryAndInstallation;
import com.automation.frigidaire.locators.FE_PLP;
import com.automation.frigidaire.utils.WebElementUtil;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automation.utils.WebElementUtil.*;
import org.testng.Assert;

import java.time.Duration;

import static com.automation.frigidaire.locators.FE_DeliveryAndInstallation.declineprotectionBy;



public class DeliveryInstallationPageActions {


    private final WebDriver driver;


    public DeliveryInstallationPageActions() {
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
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            com.automation.utils.WebElementUtil.scrollToElement(driver, driver.findElement(By.xpath(productXPath)));
            WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productXPath)));
            com.automation.utils.WebElementUtil.scrollAndClickUsingJSE(driver, product);
            WebElementUtil.scrollByPixels(driver, 0, 500);
            WaitUtils.sleep(5000);
            WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(FE_PLP.ADD_TO_CART_FOR_PLP));
            WaitUtils.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void verifyHeadingAndSubLinksinDAndSPage(String label) {
        WebDriver driver = DriverManager.getDriver();
        By radioButton = FE_DeliveryAndInstallation.getRadioButton(label);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(radioButton));
        WebElementUtil.scrollByPixels(driver, 0, 450);
        Assert.assertTrue(element.isDisplayed(), "The radio button is not visible!");
        WebElementUtil.scrollByPixels(driver, 0, 600);
        WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(FE_DeliveryAndInstallation.viewIncludedPartsLink));
    }

    public void Verify(String label) {
        By radioButton = FE_DeliveryAndInstallation.getRadioButton(label);
        WebElement element = driver.findElement(radioButton);
        element.click();
    }

    public void validateViewDetailsPopUp() {
        try
            {
                WebElement DeliveryAndAppliancePopUp = WaitUtils.untilVisible(FE_DeliveryAndInstallation.TotalApplianceProtectionHeading);
                Assert.assertTrue(DeliveryAndAppliancePopUp.isDisplayed(), "pop up heading is not visible");
                WebElement DAndAppIncludedProductTxt = WaitUtils.untilVisible(FE_DeliveryAndInstallation.TotalApplianceProtectionPopUpText);
                Assert.assertTrue(DAndAppIncludedProductTxt.isDisplayed(), "pop up text is not visible");
                WebElement closePopUpBtn = WaitUtils.untilVisible(FE_DeliveryAndInstallation.viewIncludePartsClosePopUpButton);
                Assert.assertTrue(closePopUpBtn.isDisplayed(), "popUp Close Button is not visible");
                closePopUpBtn.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void verifyPopupTextIsVisible() {
        try {
                WebElement DeliveryAndAppliancePopUp = WaitUtils.untilVisible(FE_DeliveryAndInstallation.DeliveryAndAppliancePopUp);
                Assert.assertTrue(DeliveryAndAppliancePopUp.isDisplayed(), "pop up heading is not visible");
                WebElement DAndAppIncludedProductTxt = WaitUtils.untilVisible(FE_DeliveryAndInstallation.DAndAppIncludedProductTxt);
                Assert.assertTrue(DAndAppIncludedProductTxt.isDisplayed(), "pop up text is not visible");
                WebElement DAndAppIncludeWithServiceTxt = WaitUtils.untilVisible(FE_DeliveryAndInstallation.includeWithService("Included with service:"));
                Assert.assertTrue(DAndAppIncludeWithServiceTxt.isDisplayed(), "pop up text IncludeWithService is not visible");
                WebElement DAndAppDeliveryTxt = WaitUtils.untilVisible(FE_DeliveryAndInstallation.includeWithService("Delivery"));
                Assert.assertTrue(DAndAppDeliveryTxt.isDisplayed(), "pop up text for delivery is not visible");
                WebElement DAndAppInstallationTxt = WaitUtils.untilVisible(FE_DeliveryAndInstallation.includeWithService("Installation (ready to use)"));
                Assert.assertTrue(DAndAppInstallationTxt.isDisplayed(), "pop up text for installation is not visible");
                WebElement DAndAppTotalTxt = WaitUtils.untilVisible(FE_DeliveryAndInstallation.includeWithService("Total"));
                Assert.assertTrue(DAndAppTotalTxt.isDisplayed(), "pop up text for total is not visible");
                WaitUtils.sleep(5000);
                WebElement closePopUpBtn = WaitUtils.untilVisible(FE_DeliveryAndInstallation.viewIncludePartsClosePopUpButton);
                Assert.assertTrue(closePopUpBtn.isDisplayed(), "popUp Close Button is not visible");
                closePopUpBtn.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyProtectionPlanSection(String brand) {
        try {
            WebElement ele = WaitUtils.untilVisible(FE_DeliveryAndInstallation.selectProtectionHeading);
            WebElementUtil.scrollToElement(driver, ele);
            Assert.assertTrue(ele.isDisplayed(), "protection plan heading is not visible");

            WebElement protectionSubTxt = WaitUtils.untilVisible(FE_DeliveryAndInstallation.protectionPlanSubText);
            Assert.assertTrue(protectionSubTxt.isDisplayed(), "sub text is not visible");

            if (brand.equals("frigidaire")) {
                WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(FE_DeliveryAndInstallation.protectionPlanViewDetailsLink));
                WebElement totalAppProtectionPlanPopUp = WaitUtils.untilVisible(FE_DeliveryAndInstallation.protectionPlanPopUp);
                Assert.assertTrue(totalAppProtectionPlanPopUp.isDisplayed(), "protect protection plan text is not visible");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean isDeclineProtectionVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement declineProtection = wait.until(ExpectedConditions.visibilityOfElementLocated(FE_DeliveryAndInstallation.declineprotectionBy));
            WebElementUtil.clickElementUsingJSE(driver, declineprotectionBy);
            Assert.assertTrue(declineProtection.isDisplayed(), "Decline Protection is not visible");
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void validateProtectionPlanPrice(String brand, String year) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();

        if (brand.equals("frigidaire")) {

            By yearLocator = FE_DeliveryAndInstallation.getPlanYearLocator(year);
            WebElementUtil.waitForElementToBeVisible(yearLocator, 60);
            WebElementUtil.clickElementUsingJSE(driver, yearLocator);
            double extractedPrice = extractPrice(FE_DeliveryAndInstallation.getPriceLocator(year));
            WebElementUtil.scrollByPixels(driver, 550, 0);
            WebElementUtil.scrollToElement(driver, driver.findElement(FE_DeliveryAndInstallation.protectionPlanPrice));
            WaitUtils.sleep(5000);
            WaitUtils.untilVisible(FE_DeliveryAndInstallation.protectionPlanPrice, 60);
            WebElement protectionPlanElement = driver.findElement(FE_DeliveryAndInstallation.protectionPlanPrice);
            String protectionPlanText = protectionPlanElement.getText();
            String cleanedProtectionPlanPrice = protectionPlanText.replaceAll("[^0-9.]", "");
            double protectionPlanPrice = Double.parseDouble(cleanedProtectionPlanPrice);
            Assert.assertEquals(extractedPrice, protectionPlanPrice, "Price Mismatch");
            WebElementUtil.isDisplayed(FE_DeliveryAndInstallation.subTotalPrice);
            WebElement subTotalPrice = driver.findElement(FE_DeliveryAndInstallation.subTotalPrice);
            String GetSubtotalPrice = subTotalPrice.getText().replaceAll("[^0-9.]", "");
            double subtotal = Double.parseDouble(GetSubtotalPrice);
            double totalPrice = subtotal + protectionPlanPrice;
            WebElement totalPriceElement = driver.findElement(FE_DeliveryAndInstallation.totalPrice);
            String totalPriceText = totalPriceElement.getText();
            String cleanedTotalPrice = totalPriceText.replaceAll("[^0-9.]", "");
            double displayedTotalPrice = Double.parseDouble(cleanedTotalPrice);
            Assert.assertEquals(totalPrice, displayedTotalPrice, "ERROR: The total price does not match!");
            WebElementUtil.waitForElementToBeVisible(yearLocator, 60);
            WebElementUtil.scrollToElement(driver, driver.findElement(yearLocator));
        } else {
            By yearLocator = FE_DeliveryAndInstallation.getYearLocatorForElectrolux(year);
            WebElementUtil.waitForElementToBeVisible(yearLocator, 60);
            WebElementUtil.clickElementUsingJSE(driver, yearLocator);
            double extractedPrice = extractPrice(FE_DeliveryAndInstallation.getPriceLocatorForElectrolux(year));
            WebElementUtil.scrollByPixels(driver, 550, 0);

//            WebElementUtil.scrollToElement(driver, driver.findElement(FE_DeliveryAndInstallation.installationServices));

            WebElementUtil.scrollToElement(driver, driver.findElement(FE_DeliveryAndInstallation.protectionPlanPriceForElectrolux));
            WaitUtils.sleep(5000);

//            WaitUtils.untilVisible(FE_DeliveryAndInstallation.installationServices, 60);
//            WebElement installationServicePlanElement = driver.findElement(FE_DeliveryAndInstallation.installationServices);
//            String installationServicePlanText = installationServicePlanElement.getText();
//            System.out.println(installationServicePlanText);
//            String cleanedProtectionPlanPrices = installationServicePlanText.replaceAll("[$]", "");// Remove '$' and ',' for example
//            System.out.println(cleanedProtectionPlanPrices);

            WaitUtils.untilVisible(FE_DeliveryAndInstallation.protectionPlanPriceForElectrolux, 60);
            WebElement protectionPlanElement = driver.findElement(FE_DeliveryAndInstallation.protectionPlanPriceForElectrolux);
            String protectionPlanText = protectionPlanElement.getText();
            String cleanedProtectionPlanPrice = protectionPlanText.replaceAll("[^0-9.]", "");// Remove '$' and ',' for example

          //  double installationPlanPrice = Double.parseDouble(cleanedProtectionPlanPrices);

            double protectionPlanPrice = Double.parseDouble(cleanedProtectionPlanPrice);
            Assert.assertEquals(extractedPrice, protectionPlanPrice, "Price Mismatch");
            WebElementUtil.isDisplayed(FE_DeliveryAndInstallation.subTotalPrice);
            WebElement subTotalPrice = driver.findElement(FE_DeliveryAndInstallation.subTotalPrice);
            String GetSubtotalPrice = subTotalPrice.getText().replaceAll("[^0-9.]", "");
            double subtotal = Double.parseDouble(GetSubtotalPrice);
            double totalPrice = subtotal +  protectionPlanPrice;
            WebElement totalPriceElement = driver.findElement(FE_DeliveryAndInstallation.totalPriceForElectrolux);
            String totalPriceText = totalPriceElement.getText();
            String cleanedTotalPrice = totalPriceText.replaceAll("[^0-9.]", "");
            double displayedTotalPrice = Double.parseDouble(cleanedTotalPrice);
            Assert.assertEquals(totalPrice, displayedTotalPrice, "ERROR: The total price does not match!");
            WebElementUtil.waitForElementToBeVisible(yearLocator, 60);
            WebElementUtil.scrollToElement(driver, driver.findElement(yearLocator));
        }
    }

    public double extractPrice(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        return Double.parseDouble(text.replace("$", "").replace(",", "").trim());
    }


}