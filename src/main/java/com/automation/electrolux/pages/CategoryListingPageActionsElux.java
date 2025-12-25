package com.automation.electrolux.pages;


import com.automation.electrolux.locators.CLPLocatorsElux;
import com.automation.utils.WebElementUtil;
import org.testng.Assert;

public class CategoryListingPageActionsElux {


    CLPLocatorsElux eluxPage_Locator = new CLPLocatorsElux();

    public void clickOnLaundry() {
        WebElementUtil.clickElement(eluxPage_Locator.Laundry);
    }
    public void clickOnFrontloadLaundry() {
        WebElementUtil.clickElement(eluxPage_Locator.FrontloadLaundry);
    }
    public boolean verifyLaundryTowersText() {
        Assert.assertTrue(WebElementUtil.getText(eluxPage_Locator.LaundryTowers).contains("Laundry Towers"), "Laundry Towers text is not found");
        return true;
    }

    public boolean verifyWasherDryerSetsText() {
        Assert.assertTrue(WebElementUtil.getText(eluxPage_Locator.WasherDryerSets).contains("Washer and Dryer Sets"), "Washer and Dryer Sets text is not found");
        return true;
    }

    public boolean verifyWashersText() {
        Assert.assertTrue(WebElementUtil.getText(eluxPage_Locator.Washers).contains("Washers"), "Washers text is not found");
        return true;
    }

    public boolean verifyDryersText() {
        Assert.assertTrue(WebElementUtil.getText(eluxPage_Locator.Dryers).contains("Dryers"), "Dryers text is not found");
        return true;
    }
    public void clickOnLaundryTowers() {
        WebElementUtil.clickElement(eluxPage_Locator.LaundryTowers);
    }
    public void clickOnWasherDryerSets() {
        WebElementUtil.clickElement(eluxPage_Locator.WasherDryerSets);
    }
    public void clickOnWashers() {
        WebElementUtil.clickElement(eluxPage_Locator.Washers);
    }
    public void clickOnDryers() {
        WebElementUtil.clickElement(eluxPage_Locator.Dryers);
    }
    public boolean verifyLaundryTowersTitle() {
        Assert.assertTrue(WebElementUtil.getText(eluxPage_Locator.categoryTitle).contains("Stacked Washer and Dryer Units"), "Stacked Washer and Dryer Units title  not found");
        return true;
    }
    public boolean verifyWasherDryerSetsTitle() {
        Assert.assertTrue(WebElementUtil.getText(eluxPage_Locator.categoryTitle).contains("Washer & Dryer Sets"), "Washer & Dryer Sets title is not found");
        return true;
    }
    public boolean verifyWashersTitle() {
        Assert.assertTrue(WebElementUtil.getText(eluxPage_Locator.categoryTitle).contains("Washers"), "Washers title is not found");
        return true;
    }
    public boolean verifyDryersTitle() {
        Assert.assertTrue(WebElementUtil.getText(eluxPage_Locator.categoryTitle).contains("Dryers"), "Dryers title not found");
        return true;
    }

 public void verifyListingPage() {
     Assert.assertTrue(WebElementUtil.getText(eluxPage_Locator.Hidefilters).contains("Hide filters"), "Hide Filter is not shown");
     Assert.assertTrue(WebElementUtil.getText(eluxPage_Locator.Results).contains("Results"), "Filter results are not shown");
     Assert.assertTrue(WebElementUtil.getText(eluxPage_Locator.Sortby).contains("Sort by :"), "Sort by option is not shown");

 }
public void clickBackButton() throws InterruptedException {
    WebElementUtil.clickBackButton();
    Thread.sleep(2000);

    }

}
