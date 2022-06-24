package com.sudipa.qaautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractTestBase {

    protected WebDriver driver;
    
    public AbstractTestBase() {
    	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void launchBrowser() {
    	driver.get("https://www.google.com/intl/en-GB/gmail/about/");
    }

    @AfterMethod
    public void quitDriver() throws InterruptedException {
        driver.quit();
    }
}
