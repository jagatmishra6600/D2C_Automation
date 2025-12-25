package com.automation.frigidaire.pages;

import com.automation.electrolux.locators.RefrigeratorLocatorsElux;
import com.automation.utils.WebElementUtil;

import static com.automation.utils.WebElementUtil.*;

public class RefrigeratorPageActionsFrig extends RefrigeratorLocatorsElux {


    public void clickOnKitchen() {
        clickElement(kitchen);
    }
    public void clickOnRefrigeratorSubcategory() {
        clickElement(RefrigeratorSubcategory);

    }
    public boolean verifyRefigeratorText() {
        isDisplayed(Refrigeratorsboldtext);
        return true;
    }

    public boolean verifyFrenchdoorText() {
        isDisplayed(FrenchDoor);
        return true;
    }

    public boolean verifySidebyside() {
        isDisplayed(Sidebyside);
        return true;
    }

    public boolean verifySingleDoor() {
        isDisplayed(SingleDoor);
        return true;
    }

    public boolean verifyTopfreezer() {
        isDisplayed(Topfreezer);
        return true;
    }

    public boolean verifyBottomFreezer() {
        isDisplayed(BottomFreezer);
        return true;
    }

    public boolean verifyCompact() {
        isDisplayed(Compact);
        return true;
    }

    public boolean verifyWineandbeverage() {
        isDisplayed(Wineandbeverage);
        return true;
    }
    public boolean verifyShoptoprated() {
        scrollIntoView(Shoptoprated);
        return true;
    }

    public boolean verifyBestseller() {
        scrollIntoView(Bestseller);
        return true;
    }

    public boolean verifyFridgetext() {
        scrollIntoView(Fridgetext);
        return true;
    }

    public boolean verifyReviews() {
        scrollIntoView(Reviews);
        return true;
    }

    public boolean verifyPrice() {
        scrollIntoView(Price);
        return true;
    }

    public boolean verifyTitle() {
        scrollIntoView(Title);
        return true;
    }

    public boolean verifyMessage() {
        scrollIntoView(Message);
        return true;
    }

    public void clickOnSidebysidenext() {
        clickElement(Sidebysidenext);
    }

    public void clickOnNextbutton() {
        clickElement(Nextbutton);
    }

    public void clickOnLargestoragecapacity() {
        clickElement(Largestoragecapacity);
    }
    public void clickOnseeresult() {
        clickElement(seeresult);

    }
    public void clickOnYourresult() {
        clickElement(Yourresult);
    }

        public boolean verifySelecteditemresult() {
        scrollIntoView(Selecteditemresult);
        return true;
    }
    public boolean verifyfrigidaireproffessional() {
        isDisplayed(frigidaireproffessional);
        return true;
    }


   public boolean verifytotalRatings() {
       isDisplayed(totalRatings);
       return true;

   }

   public boolean VerifyRefrigeratorproductname() {
       isDisplayed(Refrigeratorproductname);
       return true;
   }
    public boolean verifyRefproductprices() {
        isDisplayed(Refproductprices);
        return true;
    }
   public void clickOnmorefrenchdooroptions() {
      scrollIntoView(morefrenchdooroptions);
       clickElement(morefrenchdooroptions);
   }
   public void clickOnrefrigeratorimage() {

       scrollIntoView(refrigeratorimage);
       clickElement(refrigeratorimage);

    }

    public boolean verifyPDProductRating() {
        isDisplayed(PDPproductRating);
        return true;
    }

    public boolean verifyPDPProductName() {
        isDisplayed(PDPproductname);
        return true;
    }

    public boolean verifyPDPProductimage() {
        isDisplayed(PDPproduct_image);
        return true;
    }


}




