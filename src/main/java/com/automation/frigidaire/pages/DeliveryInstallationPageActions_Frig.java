package com.automation.frigidaire.pages;

import com.automation.electrolux.locators.DeliveryAndInstallationLocator_Elux;
import com.automation.frigidaire.locators.DeliveryAndInstallation_Frig;
import com.automation.frigidaire.locators.PLP_Frig;
import com.automation.frigidaire.utils.WebElementUtil;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.automation.electrolux.pages.PLPProductItemsPageActions_Elux.addToCart;
import static com.automation.frigidaire.locators.DeliveryAndInstallation_Frig.declineprotectionBy;



public class DeliveryInstallationPageActions_Frig {


    private final WebDriver driver;


    public DeliveryInstallationPageActions_Frig() {
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
            com.automation.utils.WebElementUtil.waitForElementToBeClickable(productLocator,60);
            //WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productXPath)));
            com.automation.utils.WebElementUtil.scrollAndClickUsingJSE(driver, productLocator);
            com.automation.utils.WebElementUtil.scrollByPixels(driver, 0, 500);
            WaitUtils.sleep(60);
            com.automation.utils.WebElementUtil.waitForElementToBeClickable(PLP_Frig.ADD_TO_CART_FOR_PLP);
            WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(PLP_Frig.ADD_TO_CART_FOR_PLP));
            WaitUtils.sleep(60);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void verifyHeadingAndSubLinksinDAndSPage(String label) {

        By radioButton = DeliveryAndInstallation_Frig.getRadioButton(label);


        WebElementUtil.waitForElementToBeClickable(radioButton,60);
        com.automation.utils.WebElementUtil.scrollToElementStable(DeliveryAndInstallationLocator_Elux.viewIncludedPartsLink);
        WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(DeliveryAndInstallation_Frig.viewIncludedPartsLink));
    }

    public void validateViewDetailsPopUp() {
        try {
            WebElement viewDetailsBtn = WaitUtils.untilVisible(DeliveryAndInstallation_Frig.protectionPlanViewDetailsLink);
            viewDetailsBtn.click();

            WaitUtils.untilVisible(DeliveryAndInstallation_Frig.TotalApplianceProtectionHeading);
            WebElementUtil.isDisplayed(DeliveryAndInstallation_Frig.TotalApplianceProtectionHeading);

            WaitUtils.untilVisible(DeliveryAndInstallation_Frig.TotalApplianceProtectionPopUpText);
            WebElementUtil.isDisplayed(DeliveryAndInstallation_Frig.TotalApplianceProtectionPopUpText);

            WebElement closePopUpBtn = WaitUtils.untilVisible(DeliveryAndInstallation_Frig.viewIncludePartsClosePopUpButton);

            Assert.assertTrue(closePopUpBtn.isDisplayed(), "Pop-up Close Button is not visible");
            closePopUpBtn.click();

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred while validating View Details popup: " + e.getMessage());
        }
    }


    public void verifyPopupTextIsVisible() {
        try {
                WaitUtils.untilVisible(DeliveryAndInstallation_Frig.DeliveryAndAppliancePopUp);
                WebElementUtil.isDisplayed(DeliveryAndInstallation_Frig.DeliveryAndAppliancePopUp);
               WaitUtils.untilVisible(DeliveryAndInstallation_Frig.DAndAppIncludedProductTxt);
               WebElementUtil.isDisplayed(DeliveryAndInstallation_Frig.DAndAppIncludedProductTxt);
                WaitUtils.untilVisible(DeliveryAndInstallation_Frig.includeWithService("Included with service:"));
                WebElementUtil.isDisplayed(DeliveryAndInstallation_Frig.includeWithService("Included with service:"));
                WaitUtils.untilVisible(DeliveryAndInstallation_Frig.includeWithService("Delivery"));
                WebElementUtil.isDisplayed(DeliveryAndInstallation_Frig.includeWithService("Delivery"));
                WaitUtils.untilVisible(DeliveryAndInstallation_Frig.includeWithService("Installation (ready to use)"));
                WebElementUtil.isDisplayed(DeliveryAndInstallation_Frig.includeWithService("Installation (ready to use)"));
                WaitUtils.untilVisible(DeliveryAndInstallation_Frig.includeWithService("Total"));
                WebElementUtil.isDisplayed(DeliveryAndInstallation_Frig.includeWithService("Total"));
                WaitUtils.sleep(5000);
                com.automation.utils.WebElementUtil.isDisplayed(DeliveryAndInstallationLocator_Elux.viewIncludePartsClosePopUpButton);
                WaitUtils.untilVisible(DeliveryAndInstallationLocator_Elux.viewIncludePartsClosePopUpButton).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyProtectionPlanSection(String brand) {
        try {
            WaitUtils.untilVisible(DeliveryAndInstallationLocator_Elux.selectProtectionHeading);
            com.automation.utils.WebElementUtil.scrollToElementStable(DeliveryAndInstallationLocator_Elux.selectProtectionHeading);
            com.automation.utils.WebElementUtil.isDisplayed(DeliveryAndInstallationLocator_Elux.selectProtectionHeading);
            WaitUtils.untilVisible(DeliveryAndInstallationLocator_Elux.protectionPlanSubText);
            com.automation.utils.WebElementUtil.isDisplayed(DeliveryAndInstallationLocator_Elux.protectionPlanSubText);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean isDeclineProtectionVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement declineProtection = wait.until(ExpectedConditions.visibilityOfElementLocated(DeliveryAndInstallation_Frig.declineprotectionBy));
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

            By yearLocator = DeliveryAndInstallation_Frig.getPlanYearLocator(year);
            WebElementUtil.waitForElementToBeVisible(yearLocator, 60);
            WebElementUtil.clickElementUsingJSE(driver, yearLocator);
            double extractedPrice = extractPrice(DeliveryAndInstallation_Frig.getPriceLocator(year));
            WebElementUtil.scrollByPixels(driver, 550, 0);
            WebElementUtil.scrollToElement(driver, driver.findElement(DeliveryAndInstallation_Frig.protectionPlanPrice));
            WaitUtils.sleep(5000);
            WaitUtils.untilVisible(DeliveryAndInstallation_Frig.protectionPlanPrice, 60);
            WebElement protectionPlanElement = driver.findElement(DeliveryAndInstallation_Frig.protectionPlanPrice);
            String protectionPlanText = protectionPlanElement.getText();
            String cleanedProtectionPlanPrice = protectionPlanText.replaceAll("[^0-9.]", "");
            double protectionPlanPrice = Double.parseDouble(cleanedProtectionPlanPrice);
            Assert.assertEquals(extractedPrice, protectionPlanPrice, "Price Mismatch");
            WebElementUtil.isDisplayed(DeliveryAndInstallation_Frig.subTotalPrice);
            WebElement subTotalPrice = driver.findElement(DeliveryAndInstallation_Frig.subTotalPrice);
            String GetSubtotalPrice = subTotalPrice.getText().replaceAll("[^0-9.]", "");
            double subtotal = Double.parseDouble(GetSubtotalPrice);
            double totalPrice = subtotal + protectionPlanPrice;
            WebElement totalPriceElement = driver.findElement(DeliveryAndInstallation_Frig.totalPrice);
            String totalPriceText = totalPriceElement.getText();
            String cleanedTotalPrice = totalPriceText.replaceAll("[^0-9.]", "");
            double displayedTotalPrice = Double.parseDouble(cleanedTotalPrice);
            Assert.assertEquals(totalPrice, displayedTotalPrice, "ERROR: The total price does not match!");
            WebElementUtil.waitForElementToBeVisible(yearLocator, 60);
            WebElementUtil.scrollToElement(driver, driver.findElement(yearLocator));
     }
       // else {
//            By yearLocator = DeliveryAndInstallation_Frig.getYearLocatorForElectrolux(year);
//            WebElementUtil.waitForElementToBeVisible(yearLocator, 60);
//            WebElementUtil.clickElementUsingJSE(driver, yearLocator);
//            double extractedPrice = extractPrice(DeliveryAndInstallation_Frig.getPriceLocatorForElectrolux(year));
//            WebElementUtil.scrollByPixels(driver, 550, 0);
//
////            WebElementUtil.scrollToElement(driver, driver.findElement(FE_DeliveryAndInstallation.installationServices));
//
//            WebElementUtil.scrollToElement(driver, driver.findElement(DeliveryAndInstallation_Frig.protectionPlanPriceForElectrolux));
//            WaitUtils.sleep(5000);
//            WaitUtils.untilVisible(DeliveryAndInstallation_Frig.protectionPlanPriceForElectrolux, 60);
//            WebElement protectionPlanElement = driver.findElement(DeliveryAndInstallation_Frig.protectionPlanPriceForElectrolux);
//            String protectionPlanText = protectionPlanElement.getText();
//            String cleanedProtectionPlanPrice = protectionPlanText.replaceAll("[^0-9.]", "");// Remove '$' and ',' for example
//            double protectionPlanPrice = Double.parseDouble(cleanedProtectionPlanPrice);
//            Assert.assertEquals(extractedPrice, protectionPlanPrice, "Price Mismatch");
//            WebElementUtil.isDisplayed(DeliveryAndInstallation_Frig.subTotalPrice);
//            WebElement subTotalPrice = driver.findElement(DeliveryAndInstallation_Frig.subTotalPrice);
//            String GetSubtotalPrice = subTotalPrice.getText().replaceAll("[^0-9.]", "");
//            double subtotal = Double.parseDouble(GetSubtotalPrice);
//            double totalPrice = subtotal +  protectionPlanPrice;
//            WebElement totalPriceElement = driver.findElement(DeliveryAndInstallation_Frig.totalPriceForElectrolux);
//            String totalPriceText = totalPriceElement.getText();
//            String cleanedTotalPrice = totalPriceText.replaceAll("[^0-9.]", "");
//            double displayedTotalPrice = Double.parseDouble(cleanedTotalPrice);
//            Assert.assertEquals(totalPrice, displayedTotalPrice, "ERROR: The total price does not match!");
//            WebElementUtil.waitForElementToBeVisible(yearLocator, 60);
//            WebElementUtil.scrollToElement(driver, driver.findElement(yearLocator));
//        }
    }

    public double extractPrice(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        return Double.parseDouble(text.replace("$", "").replace(",", "").trim());
    }


}