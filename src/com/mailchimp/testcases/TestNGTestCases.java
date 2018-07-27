package com.mailchimp.testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mailchimp.actions.ScrollingElementsIntoView;
import com.mailchimp.csv.CSVFile;
import com.mailchimp.webpages.AboutMailChimpPage;
import com.mailchimp.webpages.Homepage;

import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

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
	public void testMethod() throws InterruptedException, IOException {

		//Scrolling About MailChimp link into view 
		ScrollingElementsIntoView.scrollToFindElement(Homepage.aboutMailChimp(driver));
		log.info("Scrolling 'About MailChimp' link into View");
		Thread.sleep(3000);

		//Clicking on About MailChimp link
		Homepage.clickOnAboutLink(driver);
		log.info("Clicking on the about link");

        //SCrolling LeaderShip text on AboutMailChimp into view
		ScrollingElementsIntoView.scrollToFindElement(AboutMailChimpPage.getLeardershipText(driver));
		log.info("Scrolling 'LeaderShip' text into View");
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);


		//Printing names
		String namesElements[] = (AboutMailChimpPage.getMemberName(driver));

		for(String word: namesElements) {
			System.out.println(word);
		}

		//Printing positions
		String positionElements[] = (AboutMailChimpPage.getMemberPosition(driver));

		for(String position: positionElements) {
			System.out.println(position);
		}


		//Printing descriptions
		String descriptionElements[] = (AboutMailChimpPage.getMemberDescription(driver));

		for(String description: descriptionElements) {
			System.out.println(description);
		}

		//Writing to CSV file

		/*CSVFile.writeToCSVFile("/Users/nehanaik/git/MailChimpAutomation/resources/MailChimp.csv",",");
		log.info("CSV file with Name, Title, Description generated");
		 */
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		log.info("Terminated the browser");
	}
}
