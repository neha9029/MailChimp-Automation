package com.mailchimp.testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class TestNGTestCases {

	public static WebDriver driver;
	public String webSiteURL;
	private static final Logger log = LogManager.getLogger(TestNGTestCases.class.getName());
	
	@BeforeClass
	public void setUp() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "/Users/nehanaik/selenium/chromedriver");
		driver = new ChromeDriver();
		webSiteURL ="https://mailchimp.com/";
		driver.get(webSiteURL);
		log.info("Launching MailChimp.com on Chrome Browser");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		log.info("Maximizing Window");
	}
	
	@Test
	public void testMethod() {
		log.trace("test");
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		log.info("Terminated the browser");
	}
}
