package com.mailchimp.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.mailchimp.testcases.TestNGTestCases.driver;

public class ScrollingElementsIntoView {
	
	private static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public static void scrollToFindElement(WebElement element) throws InterruptedException {
		js.executeScript("window.scrollBy(0,2000);");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
	}
	

}
