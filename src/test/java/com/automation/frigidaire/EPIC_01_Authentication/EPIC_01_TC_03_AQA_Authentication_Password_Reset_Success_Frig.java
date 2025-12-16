package com.automation.frigidaire.EPIC_01_Authentication;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.BaseTest;
import com.automation.frigidaire.pages.ForgotPasswordPageActionsFrig;
import com.automation.frigidaire.pages.HomePageActionsFrig;
import com.automation.frigidaire.pages.ResetPasswordPageActionsFrig;
import com.automation.frigidaire.pages.MailDropPageActionsFrig;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExtentReportManager;

@Test(singleThreaded = true)
public class EPIC_01_TC_03_AQA_Authentication_Password_Reset_Success_Frig extends BaseTest {
    HomePageActionsFrig homePage = new HomePageActionsFrig();
    ForgotPasswordPageActionsFrig forgotPasswordPage = new ForgotPasswordPageActionsFrig();
    MailDropPageActionsFrig mailDropPage = new MailDropPageActionsFrig();
    ResetPasswordPageActionsFrig resetPasswordPage = new ResetPasswordPageActionsFrig();
    String emailAddress = ConfigReader.getProperty("user.email");
    String newPassword = ConfigReader.getProperty("user.password");
    
    @Test(groups = {"smoke", "regression"}, description = "Verify that a user can successfully reset their password through the Frigidaire website and that the corresponding password reset and confirmation emails are received and validated.")
    public void EPIC_01_Authentication_TC_03_VerifyPasswordResetFlowAndEmailNotifications() throws InterruptedException {
 
        homePage.navigateToResetPasswordPage().resetPassword(emailAddress);
        Assert.assertTrue(forgotPasswordPage.isCheckYourEmailMessageDisplayed(), "Check your Email Label and Message is not displayed");
        mailDropPage.openFirstMailInInbox(emailAddress, "Password Reset");
        mailDropPage.verifyFrigidaireResponseMailIsCorrect();
        mailDropPage.clickMailResetYourPasswordLink();
        resetPasswordPage.verifyResetPasswordPage();
        resetPasswordPage.resetPassword(newPassword);
        mailDropPage.openFirstMailInInbox(emailAddress, "Frigidaire password changed");
        mailDropPage.verifyFrigidaireResponseMailIsCorrect();
        ExtentReportManager.getTest().pass("Password reset flow completed successfully. Verified reset email, reset confirmation email, and all related UI elements.");
    }
}
