package com.automation.familystoreus.locators;

import com.automation.utils.DriverManager;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PLPProductItemsLocatorFsus {


    public final By emailPopUp = By.xpath("//span[@id=\"close-modal123\"]");
    public final By addToCart = By.xpath("//span[normalize-space()='Add to cart' and contains(@class,'ng-star-inserted')]");
    public final By earliestDelivery = By.xpath("//span[contains(text(), 'Earliest delivery:') or contains(text(),'In stock!')]");
    public final By temporarilyLocator = By.xpath("//button[span[text()=\"Temporarily Out of Stock\"]]");
    public final By emailFieldLocator = By.xpath("//input[@name=\"Email\" and contains(@placeholder, \"Enter email\")]");
    public final By emailValidationLocator = By.xpath("//span[contains(normalize-space(.), \"You’re signed up\")]");
    public final By notifyBtnLocator = By.xpath("//input[@id=\"submitBtn\" and @name=\"submitBtn\"]");
    public final By temporarilyLocatorAirCare = By.xpath("//span[text()=\"Temporarily out of stock in your area.\"]");

    public final By sortByDropdownBtn = By.xpath("//div[@id='sortByFacet']//div[@class='ng-select-container ng-has-value']");

    public final By standardWidth = By.xpath(
            "//b[text()=\"Standard Width \"]/ancestor::app-elux-product-facet-list" +
                    "//div[label[div[span[text()=' 36\" ']]]]/input"
    );

    public final By loadMoreBtn = By.xpath("//div[@class='row col-12 load-more']//button[text()=' Load more ']");
    public final By productCount = By.xpath("//span[@name='ProductsCount' or @class='totalResults resultsBorder']");

    public final By viewFullSpecsBtn = By.xpath("//button[text()='View full specs']");
    public final By quickSpecs = By.xpath("//div[@id='QuickSpecAccrd']");
    public final By specificationsHeading = By.xpath("//h3[text()='Specifications']");

    public final By resetAllButton = By.xpath("//span[text()=\" Hide filters\"]/ancestor::div//span[text()=\" Reset all \"]");
    public final By productUniqueCode = By.xpath("//h2[@class='prod_id Utility-TextProduct-SKU-Sm ng-star-inserted']");
    public final By productTitle = By.xpath("//h1[@class='H1H1_Desktop mt-34 category-heading']");

    public final By availabilityCheckbox = By.xpath(
            "//b[contains(text(),'Availability')]" +
                    "/ancestor::app-elux-product-facet-list" +
                    "//div//b[text()='Availability']" +
                    "/parent::div/child::div//input[@aria-label='Availability']"
    );

    public final By addToCartForPLP = By.xpath(
            "//div[@id='earliestDeliveryDateDiv']/parent::app-elx-earliest-delivery-day-common" +
                    "//following-sibling::div//span[contains(text(),'Add to cart')]"
    );

    public final By searchBoxs = By.xpath("//input[@placeholder='Search']");
    public final By searchButton = By.xpath("//cx-icon[@aria-label='search']");

    private By getFeatureLocator(String featureKey, String featureValue) {
        return By.xpath("//b[contains(text(),'" + featureKey + "')]/ancestor::app-elux-product-facet-list//div//input[@id='" + featureValue + "']");


    }

    private By getSelectRoomSizeLocator(String featureKey) {
        return By.xpath("//div[@id='facet-drawer']//div[@id='roomSizeRange-wrapper']//span[text()='" + featureKey + "']/parent::div/preceding-sibling::div");
    }


    private By getQuiickSpecsFeatureLocator(String featureKey, String featureValue) {
        return By.xpath("//span[text()='" + featureKey + "']//parent::div//following-sibling::div//span[contains(text(),'" + featureValue + "')]");


    }

    private By selectedFilterCross(String filterName) {
        return By.xpath("//span[@class='border border-light p-2 m-2 Body-MediumBody_Medium' and normalize-space(text())='" + filterName + "']//i");
    }


    public static By productLink(String productCode) {
        return By.xpath("//div[text()='" + productCode +"']/ancestor::div[@class='col- product-card my-0']/preceding-sibling::div[@class='col-']//a");}



}
