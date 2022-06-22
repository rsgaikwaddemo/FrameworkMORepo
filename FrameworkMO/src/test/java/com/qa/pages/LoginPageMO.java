package com.qa.pages;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageMO {
	
	//	WebDriver driver;

//		public LoginPageMO(WebDriver driver){
//			System.out.println("driver intitiated");
//			this.driver= driver;
//	}
		
		//page facotry: OR
		@FindBy(name="email") WebElement uname;
		
		@FindBy(name="password") WebElement pass;
		
		@FindBy(xpath = "//div[contains(text(), 'Login')]") WebElement loginbtn;
				
		public void loginToCRM(String username, String password) 
		{		
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				System.out.println("Wait");
			}
			
			uname.sendKeys(username);
			pass.sendKeys(password);
			
			loginbtn.click();
		}
}
