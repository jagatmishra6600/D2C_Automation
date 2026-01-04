package com.automation.frigidaire.pages;

import com.automation.electrolux.locators.DeliveryAndInstallationLocatorsElux;
import com.automation.frigidaire.locators.DeliveryAndInstallationLocatorsFrig;
import com.automation.frigidaire.locators.PLPLocatorsFrig;
import com.automation.frigidaire.utils.WebElementUtil;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.automation.electrolux.pages.PLPProductItemsPageActionsElux.addToCart;
import static com.automation.frigidaire.locators.DeliveryAndInstallationLocatorsFrig.declineprotectionBy;



public class DeliveryInstallationPageActionsFrig {

    DeliveryAndInstallationLocatorsFrig dandsPage_Locator=new DeliveryAndInstallationLocatorsFrig();
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
            com.automation.utils.WebElementUtil.scrollToElement(driver, driver.findElement(By.xpath(productXPath)));
            com.automation.utils.WebElementUtil.waitForElementToBeClickable(productLocator,60);
            //WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productXPath)));
            com.automation.utils.WebElementUtil.scrollAndClickUsingJSE(driver, productLocator);
            com.automation.utils.WebElementUtil.scrollByPixels(driver, 0, 500);
            WaitUtils.sleep(60);
            com.automation.utils.WebElementUtil.waitForElementToBeClickable(PLPLocatorsFrig.ADD_TO_CART_FOR_PLP);
            WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(PLPLocatorsFrig.ADD_TO_CART_FOR_PLP));
            WaitUtils.sleep(60);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void verifyHeadingAndSubLinksinDAndSPage(String label) {

        By radioButton = DeliveryAndInstallationLocatorsFrig.getRadioButton(label);


        WebElementUtil.waitForElementToBeClickable(radioButton,60);
        com.automation.utils.WebElementUtil.scrollToElementStable(DeliveryAndInstallationLocatorsElux.viewIncludedPartsLink);
        WebElementUtil.scrollAndClickUsingJSE(driver, driver.findElement(DeliveryAndInstallationLocatorsFrig.viewIncludedPartsLink));
    }

    public void validateViewDetailsPopUp() {
        try {
            WebElement viewDetailsBtn = WaitUtils.untilVisible(DeliveryAndInstallationLocatorsFrig.protectionPlanViewDetailsLink);
            viewDetailsBtn.click();

            WaitUtils.untilVisible(DeliveryAndInstallationLocatorsFrig.TotalApplianceProtectionHeading);
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsFrig.TotalApplianceProtectionHeading);

            WaitUtils.untilVisible(DeliveryAndInstallationLocatorsFrig.TotalApplianceProtectionPopUpText);
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsFrig.TotalApplianceProtectionPopUpText);

            WebElement closePopUpBtn = WaitUtils.untilVisible(DeliveryAndInstallationLocatorsFrig.viewIncludePartsClosePopUpButton);

            Assert.assertTrue(closePopUpBtn.isDisplayed(), "Pop-up Close Button is not visible");
            closePopUpBtn.click();

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred while validating View Details popup: " + e.getMessage());
        }
    }


    public void verifyPopupTextIsVisible() {
        try {
                WaitUtils.untilVisible(DeliveryAndInstallationLocatorsFrig.DeliveryAndAppliancePopUp);
                WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsFrig.DeliveryAndAppliancePopUp);
               WaitUtils.untilVisible(DeliveryAndInstallationLocatorsFrig.DAndAppIncludedProductTxt);
               WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsFrig.DAndAppIncludedProductTxt);
                WaitUtils.untilVisible(DeliveryAndInstallationLocatorsFrig.includeWithService("Included with service:"));
                WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsFrig.includeWithService("Included with service:"));
                WaitUtils.untilVisible(DeliveryAndInstallationLocatorsFrig.includeWithService("Delivery"));
                WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsFrig.includeWithService("Delivery"));
                WaitUtils.untilVisible(DeliveryAndInstallationLocatorsFrig.includeWithService("Installation (ready to use)"));
                WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsFrig.includeWithService("Installation (ready to use)"));
                WaitUtils.untilVisible(DeliveryAndInstallationLocatorsFrig.includeWithService("Total"));
                WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsFrig.includeWithService("Total"));
                WaitUtils.sleep(5000);
                com.automation.utils.WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsElux.viewIncludePartsClosePopUpButton);
                WaitUtils.untilVisible(DeliveryAndInstallationLocatorsElux.viewIncludePartsClosePopUpButton).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyProtectionPlanSection(String brand) {
        try {
            WaitUtils.untilVisible(DeliveryAndInstallationLocatorsElux.selectProtectionHeading);
            com.automation.utils.WebElementUtil.scrollToElementStable(DeliveryAndInstallationLocatorsElux.selectProtectionHeading);
            com.automation.utils.WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsElux.selectProtectionHeading);
            WaitUtils.untilVisible(DeliveryAndInstallationLocatorsElux.protectionPlanSubText);
            com.automation.utils.WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsElux.protectionPlanSubText);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean isDeclineProtectionVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement declineProtection = wait.until(ExpectedConditions.visibilityOfElementLocated(DeliveryAndInstallationLocatorsFrig.declineprotectionBy));
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

            By yearLocator = DeliveryAndInstallationLocatorsFrig.getPlanYearLocator(year);
            WebElementUtil.waitForElementToBeVisible(yearLocator, 60);
            WebElementUtil.clickElementUsingJSE(driver, yearLocator);
            double extractedPrice = extractPrice(DeliveryAndInstallationLocatorsFrig.getPriceLocator(year));
            WebElementUtil.scrollByPixels(driver, 550, 0);
            WebElementUtil.scrollToElement(driver, driver.findElement(DeliveryAndInstallationLocatorsFrig.protectionPlanPrice));
            WaitUtils.sleep(5000);
            WaitUtils.untilVisible(DeliveryAndInstallationLocatorsFrig.protectionPlanPrice, 60);
            WebElement protectionPlanElement = driver.findElement(DeliveryAndInstallationLocatorsFrig.protectionPlanPrice);
            String protectionPlanText = protectionPlanElement.getText();
            String cleanedProtectionPlanPrice = protectionPlanText.replaceAll("[^0-9.]", "");
            double protectionPlanPrice = Double.parseDouble(cleanedProtectionPlanPrice);
            Assert.assertEquals(extractedPrice, protectionPlanPrice, "Price Mismatch");
            WebElementUtil.isDisplayed(DeliveryAndInstallationLocatorsFrig.subTotalPrice);
            WebElement subTotalPrice = driver.findElement(DeliveryAndInstallationLocatorsFrig.subTotalPrice);
            String GetSubtotalPrice = subTotalPrice.getText().replaceAll("[^0-9.]", "");
            double subtotal = Double.parseDouble(GetSubtotalPrice);
            double totalPrice = subtotal + protectionPlanPrice;
            WebElement totalPriceElement = driver.findElement(DeliveryAndInstallationLocatorsFrig.totalPrice);
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



    public void selectRequiredInstallationPart() {
        com.automation.utils.WebElementUtil.scrollToElementCenter(dandsPage_Locator.deliveryOnlyOption);
        com.automation.utils.WebElementUtil.clickElement(dandsPage_Locator.deliveryOnlyOption);
        com.automation.utils.WebElementUtil.scrollToElementCenter(dandsPage_Locator.requireInstallationPartsText);
        com.automation.utils.WebElementUtil.isDisplayed(dandsPage_Locator.requireInstallationPartsText);
        com.automation.utils.WebElementUtil.waitForElementToBeClickable(dandsPage_Locator.partCheckBox,10);
        com.automation.utils.WebElementUtil.clickElementUsingJSE(dandsPage_Locator.partCheckBox);


    }


    public DeliveryInstallationPageActionsFrig clickSideSaveAndViewCartButton() {

        com.automation.utils.WebElementUtil.scrollToElementCenter(dandsPage_Locator.saveSideAndViewCartButton);
        com.automation.utils.WebElementUtil.waitForElementToBeClickable(dandsPage_Locator.saveSideAndViewCartButton,20);
        com.automation.utils.WebElementUtil.clickElementUsingJSE(dandsPage_Locator.saveSideAndViewCartButton);
        return new DeliveryInstallationPageActionsFrig();
    }
    public DAndSPageActionsFrig clickAddToCartButton() {
        com.automation.utils.WebElementUtil.scrollToElementCenter(dandsPage_Locator.addToCartButton);
        com.automation.utils.WebElementUtil.clickElement(dandsPage_Locator.addToCartButton);
        return new DAndSPageActionsFrig();
    }

    public void selectAddOnServices(){


        com.automation.utils.WebElementUtil.scrollToElementCenter(dandsPage_Locator.addOnServiceText);
        WebElementUtil.waitForElementToBeVisible(dandsPage_Locator.addOnServiceText,10);

        WaitUtils.sleep(3000);
        com.automation.utils.WebElementUtil.scrollToElementStable(dandsPage_Locator.selectAddOnServices);
        WebElementUtil.waitForElementToBeVisible(dandsPage_Locator.selectAddOnServices,10);
        com.automation.utils.WebElementUtil.waitForElementToBeClickable(dandsPage_Locator.selectAddOnServices,10);
        com.automation.utils.WebElementUtil.waitForElementToBeClickable(dandsPage_Locator.selectAddOnServices,10);
        WebElementUtil.clickElement(dandsPage_Locator.selectAddOnServices);

        com.automation.utils.WebElementUtil.scrollToElementCenter(dandsPage_Locator.protectionPlanText);
        WebElementUtil.waitForElementToBeVisible(dandsPage_Locator.protectionPlanText,10);


        WaitUtils.sleep(3000);
        WebElementUtil.waitForElementToBeVisible(dandsPage_Locator.selectProtectionPlan, 10);
        WebElementUtil.waitForElementToBeClickable(dandsPage_Locator.selectProtectionPlan,10);
        WebElementUtil.clickElement(dandsPage_Locator.selectProtectionPlan);
        com.automation.utils.WebElementUtil.scrollToElementStable(dandsPage_Locator.InstallationsPartPrice);
        com.automation.utils.WebElementUtil.isDisplayed(dandsPage_Locator.InstallationsPartPrice);
        com.automation.utils.WebElementUtil.isDisplayed(dandsPage_Locator.AddOnServicesPartPrice);
        com.automation.utils.WebElementUtil.isDisplayed(dandsPage_Locator.TapProtectionPlanPrice);


        WaitUtils.sleep(3000);
        com.automation.utils.WebElementUtil.scrollToElementStable(dandsPage_Locator.saveAndViewCartButton);
        WebElementUtil.waitForElementToBeVisible(dandsPage_Locator.saveAndViewCartButton, 10);
        WebElementUtil.waitForElementToBeClickable(dandsPage_Locator.saveAndViewCartButton, 10);
        WebElementUtil.clickElement(dandsPage_Locator.saveAndViewCartButton);

        WaitUtils.sleep(3000);
    }

}