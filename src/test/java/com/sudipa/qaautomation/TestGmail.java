package com.sudipa.qaautomation;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.testng.annotations.Test;

import com.sudipa.qaautomation.pages.GmailLoggedInHomePage;
import com.sudipa.qaautomation.pages.GmailMarketingHomePage;
import com.sudipa.qaautomation.pages.GoogleAccountPage;

public class TestGmail extends AbstractTestBase {
    
    @Test
    public void testGmail() throws InterruptedException {
    	GmailMarketingHomePage homePage = new GmailMarketingHomePage(driver);
    	GoogleAccountPage accountPage = homePage.clickOnSignIn();
    	GmailLoggedInHomePage gmailHomePage = accountPage.login("automationt691", "Qazxsw!23");
    	MailData mailData = new MailData("automationt691@gmail.com", "automationt691@gmail.com", "Test Mail", "Test Email Body"); 
    	MailData receivedMailData = gmailHomePage
    		.composeMail(mailData)
    		.send(false)
    		.waitTillMailArrives(Duration.ofSeconds(5), false)
    		.openMail(mailData);
    	

    	// Verifications
    	assertEquals(receivedMailData.getSubject(), mailData.getSubject());
    	assertEquals(receivedMailData.getBody(), mailData.getBody());
    }

}
