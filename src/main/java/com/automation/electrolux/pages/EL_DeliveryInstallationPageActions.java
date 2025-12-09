package com.automation.electrolux.pages;


import com.automation.electrolux.locators.EL_DeliveryAndInstallation;
import com.automation.frigidaire.locators.FE_DeliveryAndInstallation;
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


import static com.automation.electrolux.locators.EL_DeliveryAndInstallation.declineprotectionBy;
import static com.automation.electrolux.pages.ElectroluxPLPProductItemsPageActions.addToCart;

public class EL_DeliveryInstallationPageActions {
    private final WebDriver driver;


    public EL_DeliveryInstallationPageActions() {
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
            WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(addToCart));
            WaitUtils.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void verifyHeadingAndSubLinksinDAndSPage(String label) {
        WebDriver driver = DriverManager.getDriver();
        By radioButton = EL_DeliveryAndInstallation.getRadioButton(label);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(radioButton));
        WebElementUtil.scrollByPixels(driver, 0, 450);
        Assert.assertTrue(element.isDisplayed(), "The radio button is not visible!");
        WebElementUtil.scrollByPixels(driver, 0, 600);
        WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(EL_DeliveryAndInstallation.viewIncludedPartsLink));
    }

    public void Verify(String label) {
        By radioButton = EL_DeliveryAndInstallation.getRadioButton(label);
        WebElement element = driver.findElement(radioButton);
        element.click();
    }

    public void validateViewDetailsPopUp() {
        try
        {
            WebElement DeliveryAndAppliancePopUp = WaitUtils.untilVisible(EL_DeliveryAndInstallation.TotalApplianceProtectionHeading);
            Assert.assertTrue(DeliveryAndAppliancePopUp.isDisplayed(), "pop up heading is not visible");
            WebElement DAndAppIncludedProductTxt = WaitUtils.untilVisible(EL_DeliveryAndInstallation.TotalApplianceProtectionPopUpText);
            Assert.assertTrue(DAndAppIncludedProductTxt.isDisplayed(), "pop up text is not visible");
            WebElement closePopUpBtn = WaitUtils.untilVisible(EL_DeliveryAndInstallation.viewIncludePartsClosePopUpButton);
            Assert.assertTrue(closePopUpBtn.isDisplayed(), "popUp Close Button is not visible");
            closePopUpBtn.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void verifyPopupTextIsVisible() {
        try {
            WebElement DeliveryAndAppliancePopUp = WaitUtils.untilVisible(EL_DeliveryAndInstallation.DeliveryAndAppliancePopUp);
            Assert.assertTrue(DeliveryAndAppliancePopUp.isDisplayed(), "pop up heading is not visible");
            WebElement DAndAppIncludedProductTxt = WaitUtils.untilVisible(EL_DeliveryAndInstallation.DAndAppIncludedProductTxt);
            Assert.assertTrue(DAndAppIncludedProductTxt.isDisplayed(), "pop up text is not visible");
            WebElement DAndAppIncludeWithServiceTxt = WaitUtils.untilVisible(EL_DeliveryAndInstallation.includeWithService("Included with service:"));
            Assert.assertTrue(DAndAppIncludeWithServiceTxt.isDisplayed(), "pop up text IncludeWithService is not visible");
            WebElement DAndAppDeliveryTxt = WaitUtils.untilVisible(EL_DeliveryAndInstallation.includeWithService("Delivery"));
            Assert.assertTrue(DAndAppDeliveryTxt.isDisplayed(), "pop up text for delivery is not visible");
            WebElement DAndAppInstallationTxt = WaitUtils.untilVisible(EL_DeliveryAndInstallation.includeWithService("Installation (ready to use)"));
            Assert.assertTrue(DAndAppInstallationTxt.isDisplayed(), "pop up text for installation is not visible");
            WebElement DAndAppTotalTxt = WaitUtils.untilVisible(EL_DeliveryAndInstallation.includeWithService("Total"));
            Assert.assertTrue(DAndAppTotalTxt.isDisplayed(), "pop up text for total is not visible");
            WaitUtils.sleep(5000);
            WebElement closePopUpBtn = WaitUtils.untilVisible(EL_DeliveryAndInstallation.viewIncludePartsClosePopUpButton);
            Assert.assertTrue(closePopUpBtn.isDisplayed(), "popUp Close Button is not visible");
            closePopUpBtn.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyProtectionPlanSection(String brand) {
        try {
            WebElement ele = WaitUtils.untilVisible(EL_DeliveryAndInstallation.selectProtectionHeading);
            WebElementUtil.scrollToElement(driver, ele);
            Assert.assertTrue(ele.isDisplayed(), "protection plan heading is not visible");

            WebElement protectionSubTxt = WaitUtils.untilVisible(EL_DeliveryAndInstallation.protectionPlanSubText);
            Assert.assertTrue(protectionSubTxt.isDisplayed(), "sub text is not visible");

            if (brand.equals("frigidaire")) {
                WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(EL_DeliveryAndInstallation.protectionPlanViewDetailsLink));
                WebElement totalAppProtectionPlanPopUp = WaitUtils.untilVisible(EL_DeliveryAndInstallation.protectionPlanPopUp);
                Assert.assertTrue(totalAppProtectionPlanPopUp.isDisplayed(), "protect protection plan text is not visible");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean isDeclineProtectionVisible() {
        try {
//
            WebDriver driver=DriverManager.getDriver();
            WebElement declineProtection = WaitUtils.waitForVisibility(driver, FE_DeliveryAndInstallation.declineprotectionBy,60);
            WebElementUtil.waitForClickable(driver,FE_DeliveryAndInstallation.declineprotectionBy,60);
            WebElementUtil.clickElementUsingJSE(driver,FE_DeliveryAndInstallation.declineprotectionBy);
            Assert.assertTrue(declineProtection.isDisplayed(), "Decline Protection is not visible");
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void validateProtectionPlanPrice(String brand, String year) throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();


            By yearLocator = EL_DeliveryAndInstallation.getYearLocatorForElectrolux(year);
            WebElementUtil.waitForElementToBeVisible(yearLocator, 60);
            WebElementUtil.clickElementUsingJSE(driver, yearLocator);
            double extractedPrice = extractPrice(EL_DeliveryAndInstallation.getPriceLocatorForElectrolux(year));
            WebElementUtil.scrollByPixels(driver, 550, 0);

//            WebElementUtil.scrollToElement(driver, driver.findElement(FE_DeliveryAndInstallation.installationServices));

            WebElementUtil.scrollToElement(driver, driver.findElement(EL_DeliveryAndInstallation.protectionPlanPriceForElectrolux));
            WaitUtils.sleep(5000);

//            WaitUtils.untilVisible(FE_DeliveryAndInstallation.installationServices, 60);
//            WebElement installationServicePlanElement = driver.findElement(FE_DeliveryAndInstallation.installationServices);
//            String installationServicePlanText = installationServicePlanElement.getText();
//            System.out.println(installationServicePlanText);
//            String cleanedProtectionPlanPrices = installationServicePlanText.replaceAll("[$]", "");// Remove '$' and ',' for example
//            System.out.println(cleanedProtectionPlanPrices);

            WaitUtils.untilVisible(EL_DeliveryAndInstallation.protectionPlanPriceForElectrolux, 60);
            WebElement protectionPlanElement = driver.findElement(EL_DeliveryAndInstallation.protectionPlanPriceForElectrolux);
            String protectionPlanText = protectionPlanElement.getText();
            String cleanedProtectionPlanPrice = protectionPlanText.replaceAll("[^0-9.]", "");// Remove '$' and ',' for example

            //  double installationPlanPrice = Double.parseDouble(cleanedProtectionPlanPrices);

            double protectionPlanPrice = Double.parseDouble(cleanedProtectionPlanPrice);
            Assert.assertEquals(extractedPrice, protectionPlanPrice, "Price Mismatch");
            WebElementUtil.isDisplayed(EL_DeliveryAndInstallation.subTotalPrice);
            WebElement subTotalPrice = driver.findElement(EL_DeliveryAndInstallation.subTotalPrice);
            String GetSubtotalPrice = subTotalPrice.getText().replaceAll("[^0-9.]", "");
            double subtotal = Double.parseDouble(GetSubtotalPrice);
            double totalPrice = subtotal +  protectionPlanPrice;
            WebElement totalPriceElement = driver.findElement(EL_DeliveryAndInstallation.totalPriceForElectrolux);
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
