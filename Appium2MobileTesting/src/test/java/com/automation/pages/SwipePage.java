package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.automation.base.BasePage;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SwipePage extends BasePage{
	
	
	public SwipePage(AppiumDriver driver) {
		super(driver);
	}
	
	@AndroidFindBy(accessibility = "Carousel")
	RemoteWebElement carousel;
	
	@AndroidFindBy(accessibility = "Swipe-screen")
	RemoteWebElement foundLogo;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Swipe-screen\"]/android.view.ViewGroup/android.widget.TextView")
	RemoteWebElement foundMeText;

	public void swipeRight() {
		driver.executeScript("gesture: swipe", ImmutableMap.of("elementId", carousel.getId(), "percentage", 50, "direction", "left"));
		   System.out.println("  swipe done");
		
	}

	public void scrollUntilLogoFound() {
		   driver.executeScript("gesture: scrollElementIntoView", ImmutableMap.of("scrollableView", foundLogo.getId(),
				    "strategy", "accessibility id",
				    "selector", "WebdriverIO logo",
				    "percentage", 50,
				    "direction", "up",
				    "maxCount", 5));
		
	}

	public boolean isImageFound() {
		return foundMeText.isDisplayed();
		
	}
	
	
	
	
}
