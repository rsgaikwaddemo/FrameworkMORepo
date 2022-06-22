package com.qa.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.pages.BaseClass;
import com.qa.pages.LoginPageMO;
 

  public class LoginTestMO extends BaseClass {
				@Test(priority = 1)
			public void LoginApp() { 
					
				logger = report.createTest("Login To CRM");
				
				LoginPageMO loginpage = PageFactory.initElements(driver, LoginPageMO.class);
				
				logger.info("Starting Application");
				
				loginpage.loginToCRM(excel.getStringData("login", 0, 0),excel.getStringData("login", 0, 1)); 
				
				logger.pass("Login done Successfully");
			}
			
			@Test(priority = 2)
			public void printTitle() {
				System.out.println(driver.getTitle());
			}
  }	
			

