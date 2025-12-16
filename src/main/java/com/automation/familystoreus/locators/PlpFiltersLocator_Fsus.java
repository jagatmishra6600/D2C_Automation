package com.automation.familystoreus.locators;

import org.openqa.selenium.By;

import static java.awt.SystemColor.text;


public class PlpFiltersLocator_Fsus {

    public static By navBarFilter(String text){
        return By.xpath("//h5[normalize-space(text())='" + text + "']");
    }

    public static By exploreVacuums = By.xpath("//span[text()=\"Explore Vacuums\"]");

    public static By filtersOnPlp(String filterName){
        return By.xpath("//div[@class=\"mainFacetContainer\"]//span[text()='" + text + "']");
    }
    public static By filtersCheckBox(String filterName) {
        return By.xpath("//app-elux-product-facet//div[@class=\"acc-body-srp Utility-TextSpecs-List\"]//span[text()='" + text + "']/parent::label/parent::div/input");
    }
    public static By hideAndShowFilter(String text)
    {
        return By.xpath("//span[text()='" + text + "']");
    }
    public static By expandAndCollapseFilter(String filterName){
        return By.xpath("//span[text()='" + text + "']/parent::div/following-sibling::div/img");
    }

    public static By resetAll = By.xpath("//span[text()=\" Hide Filters\"]/ancestor::div//span[text()=\" Reset all \"]");

    public static By productCountOnSelectedFilter = By.xpath("//span[text()=\" Hide Filters\"]/ancestor::div//span[@class=\"totalResults resultsBorder\"]");

    public static By filterCrossButton(String filtername){
        return By.xpath("//span[text()=\" Hide Filters\"]/ancestor::div//span[text()='" + text + "']/i");
    }

    public static By sortByDropDown = By.xpath("//div[@id='sortByFacet']//div[@class='ng-select-container ng-has-value']");

    public static By getSortByDropDown(String text){
        return By.xpath("//div[@role='listbox']//span[text()='" + text + "']");
    }

    public By getPlpItem(int num) {
        return By.xpath("//cx-page-slot[@class='ProductListSlot has-components']" +
                "//div[@id='PlpItem" + num + "']" +
                "//div[@class='col- Product-Image-Placeholder']");
    }


}
