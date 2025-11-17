package com.automation.frigidaire.pages;

import com.automation.electrolux.locators.Frigidaire_Refrigerator;
import com.automation.frigidaire.utils.WebElementUtil;

public class FrigidaireRefrigeratorPage extends Frigidaire_Refrigerator {


    public void clickOnKitchen() {
        WebElementUtil.clickElement(kitchen);
    }

    public void clickOnRefrigeratorSubcategory() {
        WebElementUtil.clickElement(RefrigeratorSubcategory);

    }

    public boolean verifyRefigeratorText() {
        WebElementUtil.isDisplayed(Refrigeratorsboldtext);
        return true;
    }

    public boolean verifyFrenchdoorText() {
        WebElementUtil.isDisplayed(FrenchDoor);
        return true;
    }

    public boolean verifySidebyside() {
        WebElementUtil.isDisplayed(Sidebyside);
        return true;
    }

    public boolean verifySingleDoor() {
        WebElementUtil.isDisplayed(SingleDoor);
        return true;
    }

    public boolean verifyTopfreezer() {
        WebElementUtil.isDisplayed(Topfreezer);
        return true;
    }

    public boolean verifyBottomFreezer() {
        WebElementUtil.isDisplayed(BottomFreezer);
        return true;
    }

    public boolean verifyCompact() {
        WebElementUtil.isDisplayed(Compact);
        return true;
    }

    public boolean verifyWineandbeverage() {
        WebElementUtil.isDisplayed(Wineandbeverage);
        return true;
    }
    public boolean verifyShoptoprated() {
        WebElementUtil.scrollIntoView(Shoptoprated);
        return true;
    }

    public boolean verifyBestseller() {
        WebElementUtil.scrollIntoView(Bestseller);
        return true;
    }

    public boolean verifyFridgetext() {
        WebElementUtil.scrollIntoView(Fridgetext);
        return true;
    }

    public boolean verifyReviews() {
        WebElementUtil.scrollIntoView(Reviews);
        return true;
    }

    public boolean verifyPrice() {
        WebElementUtil.scrollIntoView(Price);
        return true;
    }

    public boolean verifyTitle() {
        WebElementUtil.scrollIntoView(Title);
        return true;
    }

    public boolean verifyMessage() {
        WebElementUtil.scrollIntoView(Message);
        return true;
    }

    public void clickOnSidebysidenext() {
        WebElementUtil.clickElement(Sidebysidenext);
    }

    public void clickOnNextbutton() {
        WebElementUtil.clickElement(Nextbutton);
    }

    public void clickOnLargestoragecapacity() {
        WebElementUtil.clickElement(Largestoragecapacity);
    }
    public void clickOnseeresult() {
        WebElementUtil.clickElement(seeresult);

    }
    public void clickOnYourresult() {
        WebElementUtil.clickElement(Yourresult);
    }

        public boolean verifySelecteditemresult() {
        WebElementUtil.scrollIntoView(Selecteditemresult);
        return true;
    }
    public boolean verifyfrigidaireproffessional() {
        WebElementUtil.isDisplayed(frigidaireproffessional);
        return true;
    }


   public boolean verifytotalRatings() {
       WebElementUtil.isDisplayed(totalRatings);
       return true;

   }

   public boolean VerifyRefrigeratorproductname() {
       WebElementUtil.isDisplayed(Refrigeratorproductname);
       return true;
   }
    public boolean verifyRefproductprices() {
        WebElementUtil.isDisplayed(Refproductprices);
        return true;
    }
   public void clickOnmorefrenchdooroptions() {
      WebElementUtil.scrollIntoView(morefrenchdooroptions);
       WebElementUtil.clickElement(morefrenchdooroptions);
   }
   public void clickOnrefrigeratorimage() {

       WebElementUtil.scrollIntoView(refrigeratorimage);
       WebElementUtil.clickElement(refrigeratorimage);

    }

    public boolean verifyPDProductRating() {
        WebElementUtil.isDisplayed(PDPproductRating);
        return true;
    }

    public boolean verifyPDPProductName() {
        WebElementUtil.isDisplayed(PDPproductname);
        return true;
    }

    public boolean verifyPDPProductimage() {
        WebElementUtil.isDisplayed(PDPproduct_image);
        return true;
    }


}




