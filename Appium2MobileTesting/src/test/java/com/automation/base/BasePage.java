package com.automation.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {

	
	protected static AppiumDriver driver;
	
	
	public BasePage(AppiumDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	

	
	
	
}
