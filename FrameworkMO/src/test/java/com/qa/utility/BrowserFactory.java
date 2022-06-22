package com.qa.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
		public static WebDriver driver;

		public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) {
			
			if(browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				driver = new ChromeDriver();
				
			}
			else if(browserName.equals("firefox")){
				System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver-v0.31.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browserName.equals("IE")) {
				System.out.println("Sorry we do not support this browser");
			}
			
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			
			driver.get(appURL);
			
			return driver;
		}
		
		public static void quitBrowser(WebDriver driver) {
			
			driver.quit();
		}
}
