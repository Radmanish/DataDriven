package com.bravenet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	@FindBy(id="userid")
	private WebElement emailTxtBox;
	
	@FindBy(id= "password")
	private WebElement passTxtBox;
	
	@FindBy(xpath="//button[contains(@type,'submit')]")
	private WebElement loginBTN;
	@FindBy(xpath="//span[contains(@class,'md-error')]")
	private WebElement errorMessage;
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	

	public void enterUsername(String UserName) {
		
		emailTxtBox.sendKeys(UserName);
	}
	public void enterPasswrod(String Password) {
		
		passTxtBox.sendKeys(Password);
	}
	
public void clickOnLoginBTN() {
		
	loginBTN.click();
	}

	public String errorMsg() {
		return errorMessage.getText();
		
		
	}
}
