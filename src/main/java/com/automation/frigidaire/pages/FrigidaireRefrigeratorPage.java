package com.automation.frigidaire.pages;

import com.automation.frigidaire.utils.WebElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FrigidaireRefrigeratorPage {

    private final By kitchen = By.xpath("//*[text()=' Kitchen ']");
    private final By RefrigeratorSubcategory = By.xpath("//span[text()='Refrigerators']");
    private final By Refrigeratorsboldtext = By.xpath("//p[text()='Refrigerators']");
    private final By FrenchDoor = By.xpath("//a[@href='/en/kitchen-appliances/refrigerators/french-door' and text()='French Door']");
    private final By Sidebyside = By.xpath("//a[@href='/en/kitchen-appliances/refrigerators/side-by-side' and text()='Side-by-Side']");
    private final By SingleDoor = By.xpath("//a[@href='/en/kitchen-appliances/single-door-refrigerator-freezer' and text()='Single Door']");
    private final By Topfreezer = By.xpath("//a[@href='/en/kitchen-appliances/refrigerators/top-freezer' and text()='Top Freezer']");
    private final By BottomFreezer = By.xpath("//a[@href='/en/kitchen-appliances/refrigerators/bottom-freezer' and text()='Bottom Freezer']");
    private final By Compact = By.xpath("//a[@href='/en/kitchen-appliances/refrigerators/compact' and text()='Compact']");
    private final By Wineandbeverage = By.xpath("//a[@href='/en/kitchen-appliances/refrigerators/wine-beverage' and text()='Wine & Beverage']");
    private final By Shoptoprated = By.xpath("//h2[text()=' Shop Top Rated Refrigerators']");
    private final By Bestseller = By.xpath("//span[text()='Best Seller']");
    private final By Fridgetext = By.xpath("//span[text()='Stainless Steel Side-by-Side Column Refrigerator and Freezer Set with Flat Trim Kit']");
    private final By Reviews = By.xpath("//div[text()='(1)']");
    private final By Price = By.xpath("//div[@id='carouselItem-0']//span[@class='price']");
    private final By Title = By.xpath("//h2[text()='Find the Right Refrigerator for Your Home']");
    private final By Message = By.xpath("//p[text()='What is your preferred refrigerator style?']");
    private final By Sidebysidenext = By.xpath("//p[@class='quiz-headline' and text()=' French Door']");
    private final By Nextbutton = By.xpath("//*[text()='Next']");
    private final By Largestoragecapacity = By.xpath("//*[text()=' Large storage capacity']");
    private final By seeresult = By.xpath("//*[text()='See Results']");
    private final By Yourresult = By.xpath("//*[text()='Your Results']");
    private final By Selecteditemresult = By.xpath("//*[text()='You’ve selected: ']");
    private final By frigidaireproffessional = By.xpath("//*[@src=\"/assets/icons/frg-icons-Frigidaire Professional.svg\"]");
    private final By totalRatings = By.xpath("//*[text()='(2962)']");
    private final By Refrigeratorproductname = By.xpath("//a[@href=\"/en/p/kitchen/refrigerators/french-door-refrigerators/GRFC2353AF\" and @class = 'text-decoration-none']");
    private final By Refproductprices = By.xpath("//*[text()='$2,098']");
    private final By morefrenchdooroptions = By.xpath("//div[@class='explore']/a");
    private final By refrigeratorimage = By.xpath("(//div[@id='PlpItem0']//a[@tabindex='-1'])[2]");
    private final By refrigeratorproducttext = By.xpath("(//div[@id='PlpItemundefined'])[1]//a[@class='text-decoration-none']");
    //private final By PDPratingsproduct= By.xpath("//*[text()='4.4']");
    private final By PDPproduct_image= By.xpath("//div[@id='openInModal']//img[@alt='Main Display 1']");
    private final By PDPproductname= By.xpath("//name //div[@class='pdp_info_wrapper']//h1");
    private final By PDPproductRating= By.xpath("//div[@class='bv_main_container']");





    public void clickOnKitchen() {
        WebElementUtil.clickElement(kitchen);
        //return new FrigidairePlpPageActions();

    }

    public void clickOnRefrigeratorSubcategory() {
        WebElementUtil.clickElement(RefrigeratorSubcategory);
        //return new FrigidairePlpPageActions();

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
    public void clickOnrefrigeratorproducttext() {
       WebElementUtil.clickElement(refrigeratorproducttext);
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




