package com.bravenet.testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void launchApplication() {
		
//		 1) Open the Browser
		WebDriverManager.chromedriver().setup();
//		 2) Maximize the page
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	//  3) Navigate to application 
		driver.get("https://www.bravenet.com/login");

		
	}
	
	@AfterClass
	public void closeBrowser() {
		//driver.close();
	}

}
