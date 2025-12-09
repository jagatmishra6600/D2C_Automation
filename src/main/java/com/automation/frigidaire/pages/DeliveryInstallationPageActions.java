package com.automation.frigidaire.pages;

import com.automation.frigidaire.locators.FE_DeliveryAndInstallation;
import com.automation.frigidaire.utils.WebElementUtil;
import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automation.utils.WebElementUtil.*;
import org.testng.Assert;
import java.time.Duration;


public class DeliveryInstallationPageActions {


    private final WebDriver driver;


    // Constructor - gets WebDriver from DriverManager
    public DeliveryInstallationPageActions() {
        this.driver = DriverManager.getDriver();

    }


//    public void validate(String username) {
//      //  WebElement usernameField = WebElementUtil.waitForElementToBeClickable(FE_DeliveryAndInstallation.loginButton);
//       // usernameField.clear();
//       // usernameField.sendKeys(username);
//    }
//    public boolean verifySectionHeader(String sectionText){
//        try {
//            String xpath = String.format("//h3[normalize-space(text())='%s']",sectionText);
//            WebElement sectionHeader = driver.findElement(By.xpath(xpath));
//            return sectionHeader.isDisplayed();
//        }catch (NoSuchElementException e){
//            return false;
//        }
//    }
//
//    public void clickProductFromPLP(WebDriver driver, int productIndex) throws InterruptedException {
//        // Build dynamic XPATH for any PLP item
//        String productXPath = "//div[@class='container-fluid px-2 plp']"
//                + "//div[@id='PlpItem" + productIndex + "']"
//                + "//div[contains(@class,'Product-Image-Placeholder')]"
//                + "//app-elux-image";
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//
//        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productXPath)));
//        product.click();
//        System.out.println("product is open");
//    }




    public boolean   isSectionVisible(String text)  {
      return  WebElementUtil.isDisplayed(FE_DeliveryAndInstallation.optionByText(text));
    }

    public void selectProductAndAddToCart( int productIndex) throws InterruptedException {
        try {
        WebDriver driver=DriverManager.getDriver();
        // Step 1: Build dynamic XPATH for PLP product based on the index
        String productXPath = "//div[@class='container-fluid px-2 plp']"
                + "//div[@id='PlpItem" + productIndex + "']"
                + "//div[contains(@class,'Product-Image-Placeholder')]"
                + "//app-elux-image";


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productXPath)));

        product.click();
        System.out.println("Product opened");

        String addToCartXPath = "//app-elux-action-button[@class=\"luxuryProductDetails productDetails ng-star-inserted\"]/a/span";

        WebElement addToCartBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(addToCartXPath)));
        // Scroll to the "Add to Cart" button
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", addToCartBtn);
        wait.until(ExpectedConditions.visibilityOf(addToCartBtn));  // Ensure the element is visible
        // Wait for the "Add to Cart" button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        // Attempt normal click, if fails use JS click as a fallback for Angular components

            WebElementUtil.scrollAndClickUsingJSE(driver,addToCartBtn);
        } catch (Exception e) {
           e.printStackTrace();
        }
        System.out.println("Clicked Add To Cart");

    }

    public void verifyHeadingAndSubLinksinDAndSPage(String label) {
        WebDriver driver = DriverManager.getDriver();
        // Dynamically get the radio button using the label
        By radioButton = FE_DeliveryAndInstallation.getRadioButton(label);
        // Create WebDriverWait instance with a 60 seconds timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        // Wait until the radio button is visible and clickable
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(radioButton));
        // Scroll to the element (optional, depending on page design)
        WebElementUtil.scrollByPixels(driver, 0, 450);
        Assert.assertTrue(element.isDisplayed(),"The radio button is not visible!");
        WebElementUtil.scrollByPixels(driver, 0, 600);
       WebElementUtil.scrollAndClickUsingJSE(driver,driver.findElement(FE_DeliveryAndInstallation.viewIncludedPartsLink));
//        Assert.assertTrue(subLink.isDisplayed(),"The subLink is not visible!");
       // subLink.click();


    }

    public void Verify(String label) {
        By radioButton = FE_DeliveryAndInstallation.getRadioButton(label);
        WebElement element = driver.findElement(radioButton);
        element.click();
    }




    public void verifyPopupTextIsVisible() {
        // List of XPath expressions to verify specific texts in the popup
        try {
        WebDriver driver=DriverManager.getDriver();

      WebElement DeliveryAndAppliancePopUp=  WaitUtils.untilVisible(FE_DeliveryAndInstallation.DeliveryAndAppliancePopUp);
        Assert.assertTrue(DeliveryAndAppliancePopUp.isDisplayed(),"pop up heading is not visible");

        WebElement DAndAppIncludedProductTxt=  WaitUtils.untilVisible(FE_DeliveryAndInstallation.DAndAppIncludedProductTxt);
        Assert.assertTrue(DAndAppIncludedProductTxt.isDisplayed(),"pop up text is not visible");

        WebElement DAndAppIncludeWithServiceTxt= WaitUtils.untilVisible(FE_DeliveryAndInstallation.includeWithService("Included with service:"));
        Assert.assertTrue(DAndAppIncludeWithServiceTxt.isDisplayed(),"pop up text IncludeWithService is not visible");

        WebElement DAndAppDeliveryTxt= WaitUtils.untilVisible(FE_DeliveryAndInstallation.includeWithService("Delivery"));
        Assert.assertTrue(DAndAppDeliveryTxt.isDisplayed(),"pop up text for delivery is not visible");

        WebElement DAndAppInstallationTxt= WaitUtils.untilVisible(FE_DeliveryAndInstallation.includeWithService("Installation (ready to use)"));
        Assert.assertTrue(DAndAppInstallationTxt.isDisplayed(),"pop up text for installation is not visible");
            System.out.println("Installation is visible");

        WebElement DAndAppTotalTxt= WaitUtils.untilVisible(FE_DeliveryAndInstallation.includeWithService("Total"));
        Assert.assertTrue(DAndAppTotalTxt.isDisplayed(),"pop up text for total is not visible");

        } catch (Exception e) {
            e.printStackTrace();
        }

        }

public void verifyProtectionPlanSection(String text) {
    try {
        WebElement ele = WaitUtils.untilVisible(FE_DeliveryAndInstallation.selectProtectionHeading);
        WebElementUtil.scrollToElement(driver,ele);
        Assert.assertTrue(ele.isDisplayed(), "protection plan heading is not visible");

        WebElement protectionSubTxt = WaitUtils.untilVisible(FE_DeliveryAndInstallation.protectionPlanSubText);
        Assert.assertTrue(protectionSubTxt.isDisplayed(),"sub text is not visible");

        WebElement protectProtectionPlanTxt = WaitUtils.untilVisible(FE_DeliveryAndInstallation.protectProtectionPlan);
        Assert.assertTrue(protectProtectionPlanTxt.isDisplayed(),"protect protection plan text is not visible");
        WebElementUtil.scrollAndClickUsingJSE(driver,driver.findElement(FE_DeliveryAndInstallation.protectionPlanViewDetailsLink));

//        WebElement totalAppProtectionHeading = WaitUtils.untilVisible(FE_DeliveryAndInstallation.totalProtectionPlan);
//        Assert.assertTrue(totalAppProtectionHeading.isDisplayed(),"protect protection plan text is not visible");
//
//        WebElement totalAppProtectionPlanSubTxt = WaitUtils.untilVisible(FE_DeliveryAndInstallation.totalProtectionPlanSubTxt);
//        Assert.assertTrue(totalAppProtectionPlanSubTxt.isDisplayed(),"protect protection plan text is not visible");


        WebElement totalAppProtectionPlanPopUp = WaitUtils.untilVisible(FE_DeliveryAndInstallation.protectionPlanPopUp);
        Assert.assertTrue(totalAppProtectionPlanPopUp.isDisplayed(),"protect protection plan text is not visible");

    } catch (Exception e) {
        e.printStackTrace();
    }
}





}
