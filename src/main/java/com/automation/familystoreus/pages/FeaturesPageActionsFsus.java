package com.automation.familystoreus.pages;

import com.automation.familystoreus.locators.FeaturesLocatorsFsus;
import com.automation.utils.WebElementUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.util.List;

public class FeaturesPageActionsFsus {

    FeaturesLocatorsFsus locators = new FeaturesLocatorsFsus();

    public void searchProduct(String productName) {
        WebElementUtil.waitForElementToBeVisible(locators.searchBox);
        WebElementUtil.sendKeys(locators.searchBox, productName + Keys.ENTER);
    }

    public void selectProductFromPLP() {
        WebElementUtil.waitForElementToBeVisible(locators.productPDP, 10);
        WebElementUtil.waitForElementToBeClickable(locators.productPDP, 10);
        WebElementUtil.scrollIntoView(locators.productPDP);
        WebElementUtil.clickElement(locators.productPDP);
    }

    public boolean validateFeatureDescription() {
        WebElementUtil.waitForElementToBeVisible(locators.featureDescription);
        String description = WebElementUtil.getText(locators.featureDescription);
        return description != null && !description.trim().isEmpty();
    }

    public boolean validateViewMoreButtonFunctionality() {
        WebElementUtil.scrollToElementStable(locators.featureBtnSection);
        WebElementUtil.scrollIntoView(locators.viewMoreButton, 200);
        WebElementUtil.waitForElementToBeVisible(locators.viewMoreButton, 10);
        WebElementUtil.clickElement(locators.viewMoreButton);
        WebElementUtil.scrollIntoView(locators.viewMoreFeatures, 100);
        WebElementUtil.waitForElementToBeVisible(locators.viewMoreFeatures, 10);
        WebElementUtil.clickElement(locators.viewMoreFeatures);
        return WebElementUtil.isDisplayed(locators.viewMoreFeatures);
    }

    public boolean validateDownloadableDocuments() {
        // Validate document links
        List<WebElement> docs = WebElementUtil.findElements(locators.singleLangDocuments);

        if (docs.isEmpty()) {
            System.err.println("No documents found: ");
            return false;
        }

        for (WebElement doc : docs) {
            String docName = doc.getText().trim();
            String href = doc.getAttribute("href");
            if (!doc.isDisplayed() || !doc.isEnabled()) {
                System.err.println("Document not visible/enabled: " + docName);
                return false;
            }
            if (href == null || !href.toLowerCase().contains(".pdf")) {
                System.err.println("Document not a PDF: " + docName + "href=" + href);
                return false;
            }
        }
        return true;
    }

}
