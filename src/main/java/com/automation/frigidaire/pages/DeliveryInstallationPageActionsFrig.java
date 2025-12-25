package com.automation.frigidaire.pages;

import com.automation.electrolux.locators.DeliveryAndInstallationLocatorsElux;
import com.automation.frigidaire.locators.DeliveryAndInstallationLocatorsFrig;
import com.automation.frigidaire.locators.PLPLocatorsFrig;
import com.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static com.automation.utils.WebElementUtil.*;
import static com.automation.utils.WaitUtils.*;
import java.time.Duration;

import static com.automation.frigidaire.locators.DeliveryAndInstallationLocatorsFrig.declineprotectionBy;



public class DeliveryInstallationPageActionsFrig {


    private final WebDriver driver;


    public DeliveryInstallationPageActionsFrig() {
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
           scrollToElement(driver.findElement(By.xpath(productXPath)));
           waitForElementToBeClickable(productLocator);
            //WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productXPath)));
           scrollAndClickUsingJSE(productLocator);
            scrollByPixels(0, 500);
            sleep(60);
            waitForElementToBeClickable(PLPLocatorsFrig.ADD_TO_CART_FOR_PLP);
            scrollAndClickUsingJSE(PLPLocatorsFrig.ADD_TO_CART_FOR_PLP);
            sleep(60);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void verifyHeadingAndSubLinksinDAndSPage(String label) {
        By radioButton = DeliveryAndInstallationLocatorsFrig.getRadioButton(label);
        waitForElementToBeClickable(radioButton);
        scrollToElementStable(DeliveryAndInstallationLocatorsElux.viewIncludedPartsLink);
        scrollAndClickUsingJSE(DeliveryAndInstallationLocatorsFrig.viewIncludedPartsLink);
    }

    public void validateViewDetailsPopUp() {
        try {
            WebElement viewDetailsBtn = untilVisible(DeliveryAndInstallationLocatorsFrig.protectionPlanViewDetailsLink);
            viewDetailsBtn.click();

            untilVisible(DeliveryAndInstallationLocatorsFrig.TotalApplianceProtectionHeading);
            isDisplayed(DeliveryAndInstallationLocatorsFrig.TotalApplianceProtectionHeading);

            untilVisible(DeliveryAndInstallationLocatorsFrig.TotalApplianceProtectionPopUpText);
            isDisplayed(DeliveryAndInstallationLocatorsFrig.TotalApplianceProtectionPopUpText);

            WebElement closePopUpBtn = untilVisible(DeliveryAndInstallationLocatorsFrig.viewIncludePartsClosePopUpButton);

            Assert.assertTrue(closePopUpBtn.isDisplayed(), "Pop-up Close Button is not visible");
            closePopUpBtn.click();

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred while validating View Details popup: " + e.getMessage());
        }
    }


    public void verifyPopupTextIsVisible() {
        try {
            untilVisible(DeliveryAndInstallationLocatorsFrig.DeliveryAndAppliancePopUp);
            isDisplayed(DeliveryAndInstallationLocatorsFrig.DeliveryAndAppliancePopUp);
            untilVisible(DeliveryAndInstallationLocatorsFrig.DAndAppIncludedProductTxt);
            isDisplayed(DeliveryAndInstallationLocatorsFrig.DAndAppIncludedProductTxt);
            untilVisible(DeliveryAndInstallationLocatorsFrig.includeWithService("Included with service:"));
            isDisplayed(DeliveryAndInstallationLocatorsFrig.includeWithService("Included with service:"));
            untilVisible(DeliveryAndInstallationLocatorsFrig.includeWithService("Delivery"));
            isDisplayed(DeliveryAndInstallationLocatorsFrig.includeWithService("Delivery"));
            untilVisible(DeliveryAndInstallationLocatorsFrig.includeWithService("Installation (ready to use)"));
            isDisplayed(DeliveryAndInstallationLocatorsFrig.includeWithService("Installation (ready to use)"));
            untilVisible(DeliveryAndInstallationLocatorsFrig.includeWithService("Total"));
            isDisplayed(DeliveryAndInstallationLocatorsFrig.includeWithService("Total"));
            sleep(5000);
                com.automation.utils.WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsElux.viewIncludePartsClosePopUpButton);
            untilVisible(DeliveryAndInstallationLocatorsElux.viewIncludePartsClosePopUpButton).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyProtectionPlanSection(String brand) {
        try {
            untilVisible(DeliveryAndInstallationLocatorsElux.selectProtectionHeading);
            com.automation.utils.WebElementUtil.scrollToElementStable(DeliveryAndInstallationLocatorsElux.selectProtectionHeading);
            com.automation.utils.WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsElux.selectProtectionHeading);
            untilVisible(DeliveryAndInstallationLocatorsElux.protectionPlanSubText);
            com.automation.utils.WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsElux.protectionPlanSubText);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean isDeclineProtectionVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement declineProtection = wait.until(ExpectedConditions.visibilityOfElementLocated(DeliveryAndInstallationLocatorsFrig.declineprotectionBy));
            clickElementUsingJSE(declineprotectionBy);
            Assert.assertTrue(declineProtection.isDisplayed(), "Decline Protection is not visible");
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void validateProtectionPlanPrice(String brand, String year) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();

        if (brand.equals("frigidaire")) {

            By yearLocator = DeliveryAndInstallationLocatorsFrig.getPlanYearLocator(year);
            waitForElementToBeVisible(yearLocator);
            clickElementUsingJSE( yearLocator);
            double extractedPrice = extractPrice(DeliveryAndInstallationLocatorsFrig.getPriceLocator(year));
            scrollByPixels( 550, 0);
            scrollToElement(driver.findElement(DeliveryAndInstallationLocatorsFrig.protectionPlanPrice));
            sleep(5000);
            untilVisible(DeliveryAndInstallationLocatorsFrig.protectionPlanPrice);
            WebElement protectionPlanElement = driver.findElement(DeliveryAndInstallationLocatorsFrig.protectionPlanPrice);
            String protectionPlanText = protectionPlanElement.getText();
            String cleanedProtectionPlanPrice = protectionPlanText.replaceAll("[^0-9.]", "");
            double protectionPlanPrice = Double.parseDouble(cleanedProtectionPlanPrice);
            Assert.assertEquals(extractedPrice, protectionPlanPrice, "Price Mismatch");
            isDisplayed(DeliveryAndInstallationLocatorsFrig.subTotalPrice);
            WebElement subTotalPrice = driver.findElement(DeliveryAndInstallationLocatorsFrig.subTotalPrice);
            String GetSubtotalPrice = subTotalPrice.getText().replaceAll("[^0-9.]", "");
            double subtotal = Double.parseDouble(GetSubtotalPrice);
            double totalPrice = subtotal + protectionPlanPrice;
            WebElement totalPriceElement = driver.findElement(DeliveryAndInstallationLocatorsFrig.totalPrice);
            String totalPriceText = totalPriceElement.getText();
            String cleanedTotalPrice = totalPriceText.replaceAll("[^0-9.]", "");
            double displayedTotalPrice = Double.parseDouble(cleanedTotalPrice);
            Assert.assertEquals(totalPrice, displayedTotalPrice, "ERROR: The total price does not match!");
            waitForElementToBeVisible(yearLocator);
            scrollToElement(driver.findElement(yearLocator));
     }
       // else {
//            By yearLocator = DeliveryAndInstallation_Frig.getYearLocatorForElectrolux(year);
//           waitForElementToBeVisible(yearLocator, 60);
//           clickElementUsingJSE(driver, yearLocator);
//            double extractedPrice = extractPrice(DeliveryAndInstallation_Frig.getPriceLocatorForElectrolux(year));
//           scrollByPixels(driver, 550, 0);
//
////           scrollToElement(driver, driver.findElement(FE_DeliveryAndInstallation.installationServices));
//
//           scrollToElement(driver, driver.findElement(DeliveryAndInstallation_Frig.protectionPlanPriceForElectrolux));
//            sleep(5000);
//            untilVisible(DeliveryAndInstallation_Frig.protectionPlanPriceForElectrolux, 60);
//            WebElement protectionPlanElement = driver.findElement(DeliveryAndInstallation_Frig.protectionPlanPriceForElectrolux);
//            String protectionPlanText = protectionPlanElement.getText();
//            String cleanedProtectionPlanPrice = protectionPlanText.replaceAll("[^0-9.]", "");// Remove '$' and ',' for example
//            double protectionPlanPrice = Double.parseDouble(cleanedProtectionPlanPrice);
//            Assert.assertEquals(extractedPrice, protectionPlanPrice, "Price Mismatch");
//           isDisplayed(DeliveryAndInstallation_Frig.subTotalPrice);
//            WebElement subTotalPrice = driver.findElement(DeliveryAndInstallation_Frig.subTotalPrice);
//            String GetSubtotalPrice = subTotalPrice.getText().replaceAll("[^0-9.]", "");
//            double subtotal = Double.parseDouble(GetSubtotalPrice);
//            double totalPrice = subtotal +  protectionPlanPrice;
//            WebElement totalPriceElement = driver.findElement(DeliveryAndInstallation_Frig.totalPriceForElectrolux);
//            String totalPriceText = totalPriceElement.getText();
//            String cleanedTotalPrice = totalPriceText.replaceAll("[^0-9.]", "");
//            double displayedTotalPrice = Double.parseDouble(cleanedTotalPrice);
//            Assert.assertEquals(totalPrice, displayedTotalPrice, "ERROR: The total price does not match!");
//           waitForElementToBeVisible(yearLocator, 60);
//           scrollToElement(driver, driver.findElement(yearLocator));
//        }
    }

    public double extractPrice(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        return Double.parseDouble(text.replace("$", "").replace(",", "").trim());
    }


}