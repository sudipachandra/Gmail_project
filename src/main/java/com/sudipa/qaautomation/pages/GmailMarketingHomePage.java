package com.sudipa.qaautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailMarketingHomePage extends AbstractBasePage {
	
	@FindBy(xpath="//a[@data-action='sign in']")
	private WebElement signInLink;
	
	public GmailMarketingHomePage(WebDriver driver) {
		super(driver);
	}
	
	public GoogleAccountPage clickOnSignIn() {
		signInLink.click();

		return new GoogleAccountPage(driver);
	}

}
