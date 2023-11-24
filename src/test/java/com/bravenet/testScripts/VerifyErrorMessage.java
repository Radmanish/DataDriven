package com.bravenet.testScripts;



import org.testng.Assert;

import org.testng.annotations.Test;

import com.bravenet.pages.LandingPage;
import com.bravenet.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyErrorMessage extends BaseTest {
		
   @Test
   public void verifyErrorMsg() throws InterruptedException {
	
	   LandingPage landing = new LandingPage(driver);
	   Thread.sleep(3000);
	   
	   landing.clickOnAccountLogin();
	   
	String actualTile= driver.getTitle();
	String expectedTitle= "Login to Your Account";
	
	Assert.assertEquals(actualTile, expectedTitle);
	   LoginPage login = new LoginPage(driver);
	//   4) Enter an invalid username
	   
	   login.enterUsername("skjlksdfj@gmail.com");
	//   5)Enter an invalid password
	   login.enterPasswrod("aapssjsjd123");
	//   6)CLick on Login Button 
	   login.clickOnLoginBTN();
	//   7) Verify the error message 
	   Thread.sleep(3000);
	   String actualErrMsg = login.errorMsg();
	   String expectedErrMsg="You must login with your username";
	   Assert.assertEquals(actualErrMsg,expectedErrMsg);
   }



}
