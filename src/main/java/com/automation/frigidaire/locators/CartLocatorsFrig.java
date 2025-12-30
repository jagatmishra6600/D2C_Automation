package com.automation.frigidaire.locators;
import com.automation.electrolux.locators.CLPLocatorsElux;
import org.openqa.selenium.By;

public class CartLocatorsFrig {
    public final By orderSummaryText = By.xpath("//h4[normalize-space(text())='Order summary']");
    public final By subtotalText = By.xpath("//div[normalize-space(text())='Subtotal']");
    public final By subtotalPrice = By.xpath("//div[normalize-space(text())='Subtotal']/following-sibling::div[contains(@class, 'summary-amount')]");
    public final By installationPartsText = By.xpath("//div[normalize-space(text())='Installation parts']");
    public final By installationPartsPrice = By.xpath("//div[normalize-space(text())='Installation parts']/following-sibling::div[contains(@class, 'summary-amount')]");
    public final By totalText = By.xpath("//div[normalize-space(text())='Total']");
    public final By totalPrice = By.xpath("//div[normalize-space(text())='Total']/following-sibling::div[contains(@class, 'summary-amount')]");
    public final By promoCodeText = By.xpath("//h6[normalize-space(text())='Promo code']");
    public final By proceedToCheckOutButton = By.xpath("(//button[normalize-space(text())='Proceed to checkout'])[2]");
    public final By emptyCartButton = By.xpath("//button[contains(@class, 'emptyCartBtn')]");
    public final By confirmButton = By.xpath("//app-elux-cart-empty-modal//button//p[contains(text(),'Yes')]");
    public final By yourCartIsEmptyText = By.xpath("//p[text()='Your shopping cart is empty']");
    public final By productRemoveCloseButton = By.xpath("//a[contains(@href, '/en/p')]//..//..//following-sibling::div[3]//button");
    public final By removeButton = By.xpath("//app-elux-cart-confirm-modal//button//p[text()='Remove']");
    public final By productCount = By.xpath("//cx-item-counter//input[@type='number']");
    public final By increaseButton = By.xpath("//cx-item-counter//button[@type='button']//img[contains(@src, 'plus')]");
    public final By decreaseButton = By.xpath("//cx-item-counter//button[@type='button']//img[contains(@src, 'minus')]");

    //promo code locators
    public final By promoDropdown = By.xpath("//h6[contains(normalize-space(),'Promo code')]");
    public final By promoCodeInputField = By.id("couponCodeEntryForm");
    public final By applyPromoCodeButton = By.id("submitCouponButton");
    public final By promoErrorMessage = By.xpath("//div[@id='appliedCouponMessage']//b");

    //  Error message for currently unavailable products locators

    public final By SmallAppliances = By.xpath(" //*[@class='undefined' and text()=' Small Appliances ']");
    public final By Espressomaker = By.xpath("//*[ text()=' Espresso Maker ']");
    public final By SaveandViewCart = By.xpath("//*[@class='btn btn-block btn-primary ng-star-inserted']");
    public final By Cancelbutton = By.xpath("//*[@src=\"/icons/frg-icons-close-d-7-CartModal.webp\"]");
    public final By Retrominifridge = By.xpath("//*[@class='secondarycategory text-wrap zeplinStyleChild mb-0 Charcoal ng-star-inserted' and text() = '  Retro Mini Fridges ']");
    public final By itemaddtocart = By.xpath("(//*[@class='ng-star-inserted' and text()=' Add to cart '])[3]");
    public final By Minifridgetwo = By.xpath(" (//*[@class='addToCart btn btn-primary btn-block ng-star-inserted'])[4]");
    public final By Accessories = By.xpath(" //*[@class='familyStore-Nav-Multi']");
    public final By Icemakers = By.xpath(" //*[@class='secondarycategory text-wrap zeplinStyleChild mb-0 ng-star-inserted' and text()=' Ice Makers ']");
    public final By Icemakersproduct = By.xpath(" (//*[@class='ng-star-inserted' and text()=' Add to cart '])[1]");
    public final By YourCart = By.xpath("//*[@class='emptyCartBtn Empty-cart Utility-TextUtility-Text-Links']");
    public final By Carticon = By.xpath("//*[@class='elxIconsCart' and @ src='/icons/frg-icons-cart-1-f-6-d-2.svg']");
    public final By Currentlyunavailable = By.xpath(" (//*[@class='H4H4_Desktop col-md-11 col-12 p-0 m-0'])[1]");
    public final By Itemcurrentlyunavailable = By.xpath("(//*[@class='stock-msg removeMobileText'])[1]");
    public final By Removefromcart = By.xpath("( (//*[@class='textDecoration' and text()=' Remove from cart '])[1]");
    public final By Itemremoved = By.xpath("(//*[@class='modal-subTitle' and text()='The following item(s) have been removed from your cart.']");
    public final By Proccedtocheckoutbutton = By.xpath("(//*[@class='btn w-100 btn-orange ng-star-inserted' ]");
    public final By Continueshopping = By.xpath("(//*[@class='btn w-100 btn-outline-dark']");

}
