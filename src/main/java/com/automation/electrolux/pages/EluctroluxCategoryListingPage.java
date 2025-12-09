package com.automation.electrolux.pages;


import com.automation.electrolux.locators.Elux_CLP;
import com.automation.frigidaire.utils.WebElementUtil;
import org.testng.Assert;

public class EluctroluxCategoryListingPage extends Elux_CLP {

    public void clickOnLaundry() {
        WebElementUtil.clickElement(Laundry);
    }
    public void clickOnFrontloadlaundry() {
        WebElementUtil.clickElement(Frontloadlaundry);
    }
    public boolean verifyLaundryTowersText() {
        WebElementUtil.isDisplayed(LaundryTowers);
        return true;
    }

    public boolean verifyWasherDryerSetsText() {
        WebElementUtil.isDisplayed(WasherDryerSets);
        return true;
    }

    public boolean verifyWashersText() {
        WebElementUtil.isDisplayed(Washers);
        return true;
    }

    public boolean verifyDryersText() {
        WebElementUtil.isDisplayed(Dryers);
        return true;
    }
    public void clickOnLaundryTowers() {
        WebElementUtil.clickElement(LaundryTowers);
    }
    public void clickOnWasherDryerSets() {
        WebElementUtil.clickElement(WasherDryerSets);
    }
    public void clickOnWashers() {
        WebElementUtil.clickElement(Washers);
    }
    public void clickOnDryers() {
        WebElementUtil.clickElement(Dryers);
    }


 public void verifyListingPage(String url) {
     Assert.assertTrue(WebElementUtil.getCurrentUrl().contains(url));
     Assert.assertTrue(WebElementUtil.getText(Hidefilters).contains("Hide filters"), "Hide Filter is not shown");
     Assert.assertTrue(WebElementUtil.getText(Results).contains("Results"), "Filter results are not shown");
     Assert.assertTrue(WebElementUtil.getText(Sortby).contains("Sort by :"), "Sort by option is not shown");

 }
public void clickBackButton(){
    WebElementUtil.clickBackButton();

    }

}
