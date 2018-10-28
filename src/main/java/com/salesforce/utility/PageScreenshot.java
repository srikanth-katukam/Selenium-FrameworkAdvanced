package com.salesforce.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class PageScreenshot {
	public static void takeScreenshot(WebDriver driver)
	{
	WebDriver ldriver = driver;
	// Take screenshot and store as a file format
	  File src= ((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
	try {
	  // now copy the  screenshot to desired location using copyFile method
	 ldriver=driver;
	 FileUtils.copyFile(src, new File("Screenshots/"+System.currentTimeMillis()+".png"));
	       }
	 
	catch (Exception e)
	{
		System.out.println(e.getMessage());
	 
	  }
	}
}
