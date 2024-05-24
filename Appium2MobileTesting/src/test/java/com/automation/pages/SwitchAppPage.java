package com.automation.pages;

import com.automation.base.BasePage;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;

public class SwitchAppPage extends BasePage {
	
	public SwitchAppPage(AppiumDriver driver) {
		super(driver);
	}

	public void switchApp() {
		System.out.println("trying to switch the apps");
		driver.executeScript("mobile: startActivity", ImmutableMap.of("intent","com.google.android.settings/.Settings" ));
	}

}
