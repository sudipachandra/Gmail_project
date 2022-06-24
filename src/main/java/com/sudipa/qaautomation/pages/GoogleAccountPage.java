package com.sudipa.qaautomation.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleAccountPage extends AbstractBasePage {

	@FindBy(xpath="//input[@type='email']")
	private WebElement emailInput;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement passwordInput;
	
	@FindBy(xpath="//button[span/text() = 'Next']")
	private WebElement nextButton;
	
	public GoogleAccountPage(WebDriver driver) {
		super(driver);
	}

	public GmailLoggedInHomePage login(String email, String password) {
		emailInput.sendKeys(email);
		nextButton.click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(passwordInput));
		
		passwordInput.sendKeys(password);
		nextButton.click();
		w.until(ExpectedConditions.titleContains(email));

		return new GmailLoggedInHomePage(driver);
	}

}
