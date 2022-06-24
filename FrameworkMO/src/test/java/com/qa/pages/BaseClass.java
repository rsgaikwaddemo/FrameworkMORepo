package com.qa.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.beust.jcommander.Parameter;
import com.qa.utility.BrowserFactory;
import com.qa.utility.ConfigDataProvider;
import com.qa.utility.ExcelDataProvider;
import com.qa.utility.Helper;

public class BaseClass{
		
		public WebDriver driver;
		public ExcelDataProvider excel;
		public ConfigDataProvider configdp;	
		public ExtentSparkReporter extent;
		public ExtentReports report;
		public ExtentTest logger;
		
			@BeforeSuite
			public void setupSuit() {
				
				Reporter.log("Setting up reports and test started",true);
				excel = new ExcelDataProvider();
				configdp= new ConfigDataProvider();
				
				extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRMO"+Helper.getCurrentDateTime()+".html"));
				report = new ExtentReports();
				report.attachReporter(extent);
				
				Reporter.log("Setting and Configurations done-- Test can be Started",true);
			}
			
			@Parameters({"browser", "urlToBeTested"})
			@BeforeClass
			public void setup(String browser, String url) {
				
				Reporter.log("Trying to start browser",true);
				
				//driver = BrowserFactory.startApplication(driver, configdp.getBrowser(), configdp.getStagingURL());
				
				driver = BrowserFactory.startApplication(driver, browser,url);
				
				Reporter.log("Browser is up and running",true);
			}
			
			
			@AfterClass
			public void tearDwon() {
				BrowserFactory.quitBrowser(driver);
			}
			
			@AfterMethod
			public void tearDwonMethod(ITestResult result) {
				
				Reporter.log("Test is about to end",true);
				
				if(result.getStatus()==ITestResult.FAILURE) {
					
					logger.fail("Login Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());	
				}
				else if(result.getStatus()==ITestResult.SUCCESS){
					logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
				}
				report.flush();
				
				Reporter.log("Test completed and reports generated",true);
			}
}