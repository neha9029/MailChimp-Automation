package com.mailchimp.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
	
	public static WebElement element = null;
	
	//Finding 'About MailChimp' element
	public static WebElement aboutMailChimp(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/about/']"));
		return element;
	}
	
	//Clicking on 'About MailChimp' link
	public static void clickOnAboutLink(WebDriver driver) {
		element = aboutMailChimp(driver);
		element.click();
		
		
	}
	
	

}
