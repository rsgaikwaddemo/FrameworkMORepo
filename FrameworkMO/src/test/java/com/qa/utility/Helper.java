package com.qa.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler; 

public class Helper {

	
		//screenshot, alerts, frames, windows, Sync issue, javascript executer
	
		public static String captureScreenshots(WebDriver driver) {
			
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			String screenshotPath = System.getProperty("user.dir")+"/Screenshots/CRMDemo_"+ getCurrentDateTime() +".png";
			try {	
				
				FileHandler.copy(src, new File(screenshotPath));
		
				System.out.println("ScreenShot Captured");
			
			} catch (Exception e) {
				System.out.println("unable to capture Screenshots"+e.getMessage());
				e.printStackTrace();
			}
			
			return screenshotPath;
		}
		
		public static String getCurrentDateTime() {
			DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
			
			Date currentDate = new Date();
			return customFormat.format(currentDate);
		}
}
