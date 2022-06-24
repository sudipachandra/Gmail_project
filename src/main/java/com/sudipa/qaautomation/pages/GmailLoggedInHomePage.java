package com.sudipa.qaautomation.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sudipa.qaautomation.MailData;

public class GmailLoggedInHomePage extends AbstractBasePage {

	@FindBy(xpath = "//div/div/div[@role='button' and @tabindex='0' and @style='user-select: none']")
	private WebElement composeButton;

	@FindBy(xpath = "//textarea[@aria-label='To']")
	private WebElement toBox;

	@FindBy(xpath = "//input[@name='subjectbox']")
	private WebElement subjectBox;

	@FindBy(xpath = "//div[@aria-label='Message Body']")
	private WebElement messageBodyArea;

	@FindBy(xpath = "//div[@data-tooltip='More options']")
	private WebElement moreOptionsInput;
	
	@FindBy(xpath = "//div[text()='Label']")
	private WebElement labelInput;

	@FindBy(xpath = "//div[@role='button' and text()='Send']")
	private WebElement sendButton;

	@FindBy(xpath = "//tr[td/div[@role='checkbox'][//span/@name='me']]")
	private WebElement newEmailRow;

	@FindBy(xpath = "(//span[@email])[1]")
	private WebElement receivedMailFrom;

	@FindBy(xpath = "(//div[@data-message-id]/div/div/div/div/div)[1]")
	private WebElement receivedMailBody;

	@FindBy(xpath = "//table[@role='presentation']//h2")
	private WebElement receivedMailSubject;

	public GmailLoggedInHomePage(WebDriver driver) {
		super(driver);
	}

	public GmailLoggedInHomePage composeMail(MailData mailInputData) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(composeButton));

		composeButton.click();
		toBox.sendKeys(mailInputData.getTo());
		subjectBox.sendKeys(mailInputData.getSubject());
		messageBodyArea.sendKeys(mailInputData.getBody());

		return this;
	}

	public GmailLoggedInHomePage send(boolean isScheduleSend) {
		if (!isScheduleSend) {
			sendButton.click();
		}
		return this;
	}

	public GmailLoggedInHomePage waitTillMailArrives(Duration waitTime, boolean shouldForceRefresh)
			throws InterruptedException {
		if (!shouldForceRefresh) {
			// TODO:: Wait for expected condition to check what changes when new email
			// arrives
			Thread.sleep(waitTime.toMillis());
		}

		return this;
	}

	public MailData openMail(MailData mailInputData) throws InterruptedException {
		newEmailRow.click();
		Thread.sleep(2000);
		MailData receivedData = new MailData(null, receivedMailFrom.getText(), receivedMailSubject.getText(),
				receivedMailBody.getText());

		return receivedData;
	}
}
