package com.automation.pages;

import org.openqa.selenium.WebElement;

import com.automation.base.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WebViewPage extends BasePage {
	
	public WebViewPage(AppiumDriver driver) {
		super(driver);
	}

	@AndroidFindBy(accessibility = "text-input")
	WebElement formInputField;

	public void clickOnbutton() {
		// TODO Auto-generated method stub
		
	}

}
