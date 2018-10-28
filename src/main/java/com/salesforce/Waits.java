package com.salesforce;

import com.google.common.base.Function;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class Waits {
static WebDriver ldriver;
static WebElement lelement;
	public static void waitForAnElement(WebDriver driver,final WebElement ele)
	{
		ldriver =driver;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(ldriver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(5, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);

			   WebElement lelement = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver ldriver) {
			       return ele;
			     }
			   });
			   System.out.println("WebElement Found :"+lelement);
	}
}
