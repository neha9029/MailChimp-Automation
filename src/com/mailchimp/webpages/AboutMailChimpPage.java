package com.mailchimp.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutMailChimpPage {
	
	public static WebElement[] elementArray = null;
	
	public static WebElement[] getMemberName(WebDriver driver) {
		
		for(int i = 0; i<14; i++) {
		   elementArray[i]= driver.findElement(By.xpath("//*[@class=\'row align-left bio_wrapper\']//div[i+1]/a/h3"));

		}
		return elementArray;
	}
	
	
	public static WebElement[] getMemeberPosition(WebDriver driver) {
		for(int i =0;i<14;i++) {
			
			elementArray[i]=driver.findElement(By.xpath("//*[@class=\'row align-left bio_wrapper\']//div[i+1]/a/span"));
		}
		return elementArray;
	}
	
	public static WebElement[] getMemberDescription(WebDriver driver) {
		
		for(int i = 0; i<14; i++) {

			elementArray[i] = driver.findElement(By.xpath("//*[@class=\'row align-left bio_wrapper\']//div[i+1]/a"));
		}
		
		return elementArray;
	}
	

	

}
