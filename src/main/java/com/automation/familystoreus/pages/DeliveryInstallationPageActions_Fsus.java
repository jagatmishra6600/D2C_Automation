package com.automation.familystoreus.pages;

import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DeliveryInstallationPageActions_Fsus {

    public By searchBox = By.xpath("//input[@class='navSearchDirty']");
    public By productName = By.xpath("//div[@class=\"col- my-3 mx-3 mb-5\"]//a");
    public By addToCartButton = By.xpath("//app-elux-action-button[@class='luxuryProductDetails productDetails ng-star-inserted']//a");

    public By PROTECTION_PLAN_TITLE = By.xpath("//h3[text()='Protection plan']");
    public By PROTECTION_PLAN_MESSAGE = By.xpath("//div[@class='Enhance-your-manufac Body-MediumBody_Medium-Spec-List']");
    public By DECLINE_BUTTON = By.xpath("//div[@class='declineProtectionText']");
    public By getYearPrice(String yearText) {
        return By.xpath("//div[text()='" + yearText + "']/ancestor::div[@class='years ng-star-inserted']//div[@class='mt-1 esaPrice ng-star-inserted']");
    }

    public By SUB_TOTAL_LABEL = By.xpath("//b[text()=' Sub total ']");
    public By SUB_TOTAL_PRICE = By.xpath("//b[text()=' Sub total ']//parent::div[@class='Body_Large-Title col-6 col-md-6 p-0']//following-sibling::div[@class='Body_Large-Title col-6 col-md-6 p-0 text-right']//b");
    public By TOTAL_PRICE = By.xpath("//div[text()=' Total ']//following-sibling::div");

    public void searchProduct(String keyword) {
        WebElement search = WebElementUtil.waitForElementToBeVisible(searchBox,10);
        search.clear();
        search.sendKeys(keyword);
        search.sendKeys(Keys.ENTER);
    }

    public void clickProduct(){
        WebElementUtil.scrollToElementStable(productName);
        WebElementUtil.waitForElementToBeVisible(productName,10);
        WebElementUtil.waitForElementToBeClickable(productName,10);
        WebElementUtil.clickElement(productName);

        WebElementUtil.scrollToElementStable(addToCartButton);
        WebElementUtil.waitForElementToBeVisible(addToCartButton,10);
        WebElementUtil.waitForElementToBeClickable(addToCartButton,10);
        WebElementUtil.clickElement(addToCartButton);
    }

    public void verifyProtectionPlan(){

        WebElementUtil.scrollToElementCenter(PROTECTION_PLAN_TITLE);
        WebElementUtil.waitForElementToBeVisible(PROTECTION_PLAN_TITLE,10);
        WebElementUtil.isDisplayed(PROTECTION_PLAN_TITLE);

        WebElementUtil.waitForElementToBeVisible(PROTECTION_PLAN_MESSAGE,10);
        WebElementUtil.isDisplayed(PROTECTION_PLAN_MESSAGE);

    }

    public void selectProtectionPlan(String year){

        WebElementUtil.waitForElementToBeVisible(getYearPrice(year),10);
        String yearprice = WebElementUtil.getText(getYearPrice(year));
        yearprice = yearprice.replace("$","").replace(",","");
        System.out.println(yearprice);

        calculatedYearPrice(yearprice);

    }
    public void calculatedYearPrice(String yearPrice){
        double priceAdd = 0;
        if (yearPrice.equalsIgnoreCase("Free")) {
            priceAdd = 0;
        } else {
            String num = yearPrice.replace("$", "").replace(",", "");
            priceAdd = Double.parseDouble(num);
        }
        WebElementUtil.waitForElementToBeVisible(SUB_TOTAL_PRICE);
        WebElementUtil.scrollToElementStable(SUB_TOTAL_PRICE);
        String subTotalText = WebElementUtil.getText(SUB_TOTAL_PRICE);

        String totalPriceNumeric = subTotalText.replace("$", "").replace(",", "");
        double subTotalPrice = Double.parseDouble(totalPriceNumeric);
        double expectedTotal = priceAdd + subTotalPrice;


        WebElementUtil.waitForElementToBeVisible(TOTAL_PRICE);
        String totalPrice = WebElementUtil.getText(TOTAL_PRICE);
        String totalPriceActual = totalPrice.replace("$", "").replace(",", "");
        double actualTotal = Double.parseDouble(totalPriceActual);

        Assert.assertEquals(actualTotal, expectedTotal, "Error");

    }
}
