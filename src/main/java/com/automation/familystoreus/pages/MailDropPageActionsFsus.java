package com.automation.familystoreus.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.automation.familystoreus.locators.MailDropPage_Fsus;
import static com.automation.familystoreus.locators.MailDropPage_Fsus.*;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtil;

public class MailDropPageActionsFsus {
	boolean firstMailFlag = false;
	
	public MailDropPageActionsFsus navigateToMailDropPage() {
		WebElementUtil.navigateTo("https://maildrop.cc/");
		return this;
	}
	
	public MailDropPageActionsFsus enterEmailAddress(String emailAddress) {
		WebElementUtil.isDisplayed(MailDropPage_Fsus.firstMail);
		WebElementUtil.sendKeys(MailDropPage_Fsus.header_EmailAddressField, emailAddress);
		return this;
	}
	
	public MailDropPageActionsFsus clickViewMailBoxButton() {
		WebElementUtil.clickElement(MailDropPage_Fsus.header_ViewMailBoxButton);
		return this;
	}
	
	public boolean isInboxLoaded() {
		return WebElementUtil.isDisplayed(MailDropPage_Fsus.inboxRefreshButton);
	}
	
	public MailDropPageActionsFsus login(String emailAddress) {
		return navigateToMailDropPage()
					.clickViewMailBoxButton()
					.enterEmailAddress(emailAddress)
					.clickViewMailBoxButton();
	}

	public MailDropPageActionsFsus clickInboxRefresh() {
		WebElementUtil.clickElement(MailDropPage_Fsus.inboxRefreshButton);
		return this;
	}
	
	public MailDropPageActionsFsus clickFirstMailInInbox() {
		waitForFirstMailToAppear();
		WebElementUtil.clickElement(MailDropPage_Fsus.firstMail);
		return this;
	}
	
	public void waitForFirstMailToAppear() {
		var count = 0;
		while(!WebElementUtil.isDisplayed(MailDropPage_Fsus.firstMail) && count<3) {
			firstMailFlag = true;
			clickRefreshMailboxButton();
			count++;
		}
	}
	
	public void waitForLatestMailToAppear() {
		for(int k=0;k<3;k++) {
			WaitUtils.sleep(10000);
			clickInboxRefresh();
		}
		clickInboxRefresh().clickFirstMailInInbox();
	}
	
	public MailDropPageActionsFsus refreshInboxUntilMailTitleMatches(String expectedMailTitle) {
		for(int i=0;i<5;i++) {
			WaitUtils.sleep(2000);
			WebElementUtil.isDisplayed(MailDropPage_Fsus.mail_Title);
			if(getMailTitle().equalsIgnoreCase(expectedMailTitle)) {
				return this;
			}
			clickInboxRefresh();
		}
		return this;
	}
	
	public MailDropPageActionsFsus openFirstMailInInbox(String emailAddress) {
		login(emailAddress).clickInboxRefresh().clickFirstMailInInbox();
		WebElementUtil.isDisplayed(MailDropPage_Fsus.mail_Title);
		return this;
	}
	
	public MailDropPageActionsFsus openFirstMailInInbox(String emailAddress, String expectedMailTitle)  {
		login(emailAddress).clickInboxRefresh().clickFirstMailInInbox();
		WaitUtils.sleep(2000);
		if(getMailTitle().equals("Please reset your password") && !firstMailFlag) {
			waitForLatestMailToAppear();
		}
		refreshInboxUntilMailTitleMatches(expectedMailTitle);
		return this;
	}

	public String getMailTitle() {
		WebElementUtil.isDisplayed(MailDropPage_Fsus.mail_Title);
		var mailTitleValue = WebElementUtil.getText(MailDropPage_Fsus.mail_Title);
	    if(mailTitleValue.isEmpty() || mailTitleValue.equals("")) {
	    	WebElementUtil.isDisplayed(MailDropPage_Fsus.mail_Title);
	    	mailTitleValue = WebElementUtil.getText(MailDropPage_Fsus.mail_Title);
	    }
	    return mailTitleValue;
	}
	
	public boolean isMailResetYourPasswordLinkDisplayed() {
	    return WebElementUtil.performInFrame(MailDropPage_Fsus.mailFrame, () -> 
	        WebElementUtil.isDisplayed(MailDropPage_Fsus.mail_ResetPasswordLink)
	    );
	}
	
	public ResetPasswordPageActionsFsus clickMailResetYourPasswordLink() {
		WebElementUtil.isDisplayed(MailDropPage_Fsus.mail_Title);
		WebElementUtil.switchToFrame(MailDropPage_Fsus.mailFrame);
		WebElementUtil.openLinkInNewTab(MailDropPage_Fsus.mail_ResetPasswordLink);
		WebElementUtil.switchToDefaultContent();
		WebElementUtil.switchToLatestTabAndClosePrevious();
		return new ResetPasswordPageActionsFsus();
	}
	
	public String getPasswordResetMailMessage() {
	    return WebElementUtil.performInFrame(MailDropPage_Fsus.mailFrame, () -> 
	    	WebElementUtil.getText(MailDropPage_Fsus.passwordResetMailBodyText)
		);
	}

	public boolean isBrandLogoDisplayed() {
		return isMailFamilyStoreLogoDisplayed();
	}
	
	public String getFirstMailSubject() {	
		return WebElementUtil.getText(MailDropPage_Fsus.firstMailSubject);
	}
	
	public Boolean isMailFamilyStoreLogoDisplayed() {
		return WebElementUtil.performInFrame(MailDropPage_Fsus.mailFrame, () -> 
			WebElementUtil.isDisplayed(MailDropPage_Fsus.mail_FamilyStoreLogo)
        );
	}
	
	public MailDropPageActionsFsus clickRefreshMailboxButton() {
		WebElementUtil.clickElement(MailDropPage_Fsus.refreshMailBoxButton);
		return this;
	}
	
	public int getMailsCount() {
		WebElementUtil.waitForCondition(ExpectedConditions.visibilityOfAllElementsLocatedBy(MailDropPage_Fsus.mailList));
		return WebElementUtil.findElements(MailDropPage_Fsus.mailList).size();
	}
	
	public MailDropPageActionsFsus verifyPasswordResetMail() {
		Assert.assertEquals(getMailTitle(), "Please reset your password", "'Please reset your password' title is not present in password reset mail");
        Assert.assertTrue(isMailResetYourPasswordLinkDisplayed(), "'Click here to reset your password' link is not displayed in the in password reset mail");
        Assert.assertTrue(getPasswordResetMailMessage().contains("This link will expire in 24 hours. To get a new password reset link,"),
        						"Email Body does not contain Message stating 'Link will expire in 24 hours' in password reset mail");
        Assert.assertTrue(isBrandLogoDisplayed(), "Electrolux Family Store Logo is not displayed in password reset mail");      	
        return this;
	}
}
