package com.automation.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	
	public static AppiumDriver driver;
	
	public AppiumDriver startApp() throws MalformedURLException
	{
		 File app=new File("C:\\Users\\jandh\\Downloads\\android-wdio-native.apk");
			UiAutomator2Options options = new UiAutomator2Options();
			options.setCapability("deviceName", "emulator-5554");
			options.setCapability("platformName", "Android");
			options.setCapability("platformVersion", "12");
		
		
			options.setCapability("app",app.getAbsolutePath());
			options.setCapability("appPackage", "com.wdiodemoapp");
			options.setCapability("appActivity", "com.wdiodemoapp.MainActivity");
			options.setCapability("hideKeyboard", true);
			options.setCapability("noReset", false);
			
			 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

		return driver;
	}
	
	public AppiumDriver startAppSolondriod() throws MalformedURLException
	{
		 File app=new File("C:\\Users\\jandh\\Downloads\\android-wdio-native.apk");
			UiAutomator2Options options = new UiAutomator2Options();
			options.setCapability("deviceName", "emulator-5554");
			options.setCapability("platformName", "Android");
			options.setCapability("platformVersion", "12");
		
		
			options.setCapability("app",app.getAbsolutePath());
			options.setCapability("appPackage", "com.solodroid.solomerce");
			options.setCapability("appActivity", "com.solodroid.solomerce.activities.MainActivity");
			options.setCapability("hideKeyboard", true);
			options.setCapability("noReset", false);
			
			 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

		return driver;
	}
	
	

}
