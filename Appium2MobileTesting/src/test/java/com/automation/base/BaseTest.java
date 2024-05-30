package com.automation.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


public class BaseTest {
	
	public static AppiumDriver driver;
	AppiumDriverLocalService service;
	
	public void startAppium() {
		AppiumServiceBuilder builder = new AppiumServiceBuilder().withAppiumJS(new File ("C:\\Users\\jandh\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.withArgument(GeneralServerFlag.USE_PLUGINS, "gestures")
				.withArgument(GeneralServerFlag.ALLOW_INSECURE, "chromedriver_autodownload")
				.withTimeout(Duration.ofSeconds(300));
		
		service= AppiumDriverLocalService.buildService(builder);
		 service.start();
		 System.out.println("Server Started");
	}
	
	public void stopAppium() {
		service.stop();
		 System.out.println("Server stoped");
	}
	
	
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
