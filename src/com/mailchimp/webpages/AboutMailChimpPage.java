package com.mailchimp.webpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutMailChimpPage {

	public static WebElement element = null;
	public static String[] names = new String[14];

	public static String [] position = new String[14];
	public static String[] description = new String[14];


	public static WebElement getLeardershipText(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@class=\"row pb3 center\"]/div[1]/h2"));
		return element;
	}


	//Method to get Member Name 
	public static String[] getMemberName(WebDriver driver) {

		for(int i = 0; i<14; i++) {

			//System.out.println( driver.findElement(By.xpath("//*[@class='row align-left bio_wrapper']//div["+(i+1)+"]/a/h3")).getText());

			names[i] = driver.findElement(By.xpath("//*[@class='row align-left bio_wrapper']//div["+(i+1)+"]/a/h3")).getText().toString();
		}

		return names;
	}

	//Method to get Member Position 
	public static String[] getMemberPosition(WebDriver driver) {
		for(int i =0;i<14;i++) {

			position[i]=driver.findElement(By.xpath("//*[@class='row align-left bio_wrapper']//div["+(i+1)+"]/a/span")).getText().toString();
		}
		return position;
	}

	//Method to get Member Description 
	public static String[] getMemberDescription(WebDriver driver) {

		for(int i = 0; i<14; i++) {

			description[i] = driver.findElement(By.xpath("//*[@class='row align-left bio_wrapper']/div["+(i+1)+"]/a")).getAttribute("data-description").toString();
		}

		return description;
	}



}
