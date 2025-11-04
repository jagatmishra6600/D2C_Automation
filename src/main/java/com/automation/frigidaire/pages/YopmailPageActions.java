package com.automation.frigidaire.pages;

import java.time.Duration;
import java.util.stream.Stream;

import org.openqa.selenium.By;

import com.automation.frigidaire.utils.DriverManager;
import com.automation.frigidaire.utils.WaitUtils;
import com.automation.frigidaire.utils.WebElementUtil;

public class YopmailPageActions {

	private final By emailAddressField = By.id("login");
	private final By checkInboxIcon = By.cssSelector("#refreshbut i");
	private final By inboxEmailIdTitle =  By.cssSelector(".bname");
	private final By inboxRefreshButton = By.id("refresh");
	private final By firstMail = By.cssSelector(".bodyinbox div[currentmail]");
	private final By mailGreetingMessage = By.xpath("//div[@id='mail']//p[contains(.,'Hi') or contains(.,'Dear')]");
	private final By mailThanksForCreatingAccountMessage = By.xpath("//div[@id='mail']//p[contains(.,'Thanks for creating an account')]");
	private final By mailClickToActivateAccountLink = By.xpath("//div[@id='mail']//a[contains(.,'activate your account')]");
	private final By mailLinkExpiresText = By.xpath("//div[@id='mail']//p[contains(.,'expires')]");
	private final By mailNotIntendedRecipientText = By.xpath("//div[@id='mail']//p[contains(text(),'If you are not the intended recipient')]");
	private final By mailFooterFacebookLink = By.cssSelector("div#mail img[alt='facebook']");
	private final By mailFooterTwitterLink = By.cssSelector("div#mail img[alt='twitter']");
	private final By mailFooterYoutubeLink = By.cssSelector("div#mail img[alt='youtube']");
	private final By mailFooterPintrestLink = By.cssSelector("div#mail img[alt='pintrest']");
	private final By mailFooterInstagramLink = By.cssSelector("div#mail img[alt='instagram']");
	
	
	public YopmailPageActions navigateToYopmailPage() {
		WebElementUtil.navigateTo("https://yopmail.com/");
		return this;
	}
	
	public YopmailPageActions enterEmailAddress(String emailAddress) {
		WaitUtils.sleep(2000);
		WebElementUtil.sendKeys(emailAddressField, emailAddress);
		return this;
	}
	
	public YopmailPageActions clickCheckInboxButton() {
		WebElementUtil.clickElement(checkInboxIcon);	
		return this;
	}
	
	public boolean isInboxLoaded() {
		return WebElementUtil.isDisplayed(inboxEmailIdTitle);
	}
	
	public YopmailPageActions login(String emailAddress) {
		return navigateToYopmailPage()
					.enterEmailAddress(emailAddress)
					.clickCheckInboxButton();
	}
	
	public YopmailPageActions clickInboxRefresh() {
		WebElementUtil.clickElement(inboxRefreshButton);	
		return this;
	}
	
	public YopmailPageActions clickFirstMailInInbox() {	
		WebElementUtil.switchToFrame("ifinbox");
		WebElementUtil.clickElement(firstMail);
		WebElementUtil.switchToDefaultContent();
		return this;
	}
	
	public YopmailPageActions openFirstMailInInbox(String emailAddress) {
		return login(emailAddress).clickInboxRefresh().clickFirstMailInInbox();
	}
	
	public boolean isClickHereToActivateAccountLinkDisplayed() {
	    return WebElementUtil.performInFrame("ifmail", () -> 
	        WebElementUtil.isDisplayed(mailClickToActivateAccountLink)
	    );
	}
	
	public String getMailGreetingMessage() {
	    return WebElementUtil.performInFrame("ifmail", () -> 
	        WebElementUtil.getText(mailGreetingMessage)
	    );
	}
	
	public String getMailThanksForCreatingAccountMessage() {
	    return WebElementUtil.performInFrame("ifmail", () -> 
	        WebElementUtil.getText(mailThanksForCreatingAccountMessage)
	    );
	}
	
	public String getLinkExpiresMessage() {
	    return WebElementUtil.performInFrame("ifmail", () -> 
	        WebElementUtil.getText(mailLinkExpiresText)
	    );
	}
	
	public String getNotIntendedRecipientMessage() {
	    return WebElementUtil.performInFrame("ifmail", () -> 
	        WebElementUtil.getText(mailNotIntendedRecipientText)
	    );
	}
	
	public boolean isMailFooterSocialMediaLinksDisplayed() {
	    return WebElementUtil.performInFrame("ifmail", () ->
	        Stream.of(
	            mailFooterFacebookLink,
	            mailFooterInstagramLink,
	            mailFooterPintrestLink,
	            mailFooterTwitterLink,
	            mailFooterYoutubeLink
	        ).allMatch(WebElementUtil::isDisplayed)
	    );
	}
	
}
