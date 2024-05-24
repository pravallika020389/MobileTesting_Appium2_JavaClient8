package com.automation.pages;

import org.openqa.selenium.WebElement;

import com.automation.base.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {

	public LoginPage(AppiumDriver driver) {
		super(driver);
	}
	
	@AndroidFindBy(accessibility = "input-email")
	WebElement emailInput; 
	
	@AndroidFindBy(accessibility = "input-password")
	WebElement passwordInput; 
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup/android.widget.TextView")
	WebElement loginButton; 
	
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]")
	WebElement emailErrorMsg; 
	
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[2]")
	WebElement passwordErrorMsg; 
	
	@AndroidFindBy(id = "android:id/alertTitle")
	WebElement successAlert; 
	
	@AndroidFindBy(id = "android:id/button1")
	WebElement okButton; 
	
	public void enterUserId(String userId) throws InterruptedException {
		emailInput.click();
		Thread.sleep(5000);
		emailInput.sendKeys(userId);
		
	}

	public void enterPassword(String password) throws InterruptedException {
		passwordInput.click();
		Thread.sleep(5000);
		passwordInput.sendKeys(password);
		
	}
	
	public void clickLoginButton() throws InterruptedException {
		Thread.sleep(5000);
		loginButton.click();	
		
	}
	
	public String retriveUserIdErrorMsg() throws InterruptedException {
		Thread.sleep(5000);
		String inValidUserIdMsg= emailErrorMsg.getText();	
		return inValidUserIdMsg;
		
	}
	public String retrivePasswordErrorMsg() throws InterruptedException {
		Thread.sleep(5000);
		String inValidPasswordMsg= passwordErrorMsg.getText();	
		return inValidPasswordMsg;
		
	}
	
	public String retriveSuccessMsg() throws InterruptedException {
		Thread.sleep(5000);
		String validLoginMsg= successAlert.getText();	
		return validLoginMsg;
	
	}
	
	public void clickOkButton() throws InterruptedException {
		Thread.sleep(5000);
		okButton.click();	
		
	}
	

}
