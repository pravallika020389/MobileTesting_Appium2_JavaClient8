package com.automation.pages;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.automation.base.BasePage;
import com.automation.utilities.FingureGesture;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.SupportsContextSwitching;

public class WebViewPage extends BasePage {
	
	public WebViewPage(AppiumDriver driver) {
		super(driver);
	}

	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"View on GitHub\"]/android.widget.TextView")
	WebElement gitHubLink;
	
	@AndroidFindBy(id = "__docusaurus_skipToContent_fallback")
	RemoteWebElement scroll;
	
	
	@AndroidFindBy(xpath = "//a[contains(@href,'projects') and @data-hotkey='g b']")
	WebElement projects;
	
	

	public void clickOnbutton() {
		
		
	}

	public void swipeDown() {
		System.out.println("Swipe started");
		FingureGesture fingureGesture = new FingureGesture();
		fingureGesture.scroll(driver);
		System.out.println("Swipe stoped");
		
	}
	
	public void swipeDown_gestures() {
		System.out.println("Swipe started");
		 driver.executeScript("gesture: scrollElementIntoView", ImmutableMap.of("scrollableView", scroll.getId(),
				    "strategy", "xpath",
				    "selector", "//android.view.View[@content-desc=\\\"View on GitHub\\\"]/android.widget.TextView",
				    "percentage", 50,
				    "direction", "up",
				    "maxCount", 5));
		System.out.println("Swipe stoped");
		
	}
	
	public void clickGithubLink() {
		gitHubLink.click();
	}
	
	
	public void switchToGitHubAndGetTittle() {
		System.out.println("trying to switch");
		
		String chromeContest="";
		
		Set<String> contextNames =((SupportsContextSwitching) driver).getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName);
			if(contextName.contains("chrome")) {
				chromeContest=contextName;
				break;
			}
		}
		System.out.println(((SupportsContextSwitching) driver).getContext());
		System.out.println(chromeContest);
		((SupportsContextSwitching) driver).context(chromeContest); // set context to WEBVIEW_1
		System.out.println(((SupportsContextSwitching) driver).getContext());
	

		
	//	System.out.println("trying to switch the apps");
	//	driver.executeScript("mobile: startActivity", ImmutableMap.of("intent","com.android.chrome/.browser.ChromeTabbedActivity" ));
		
		System.out.println("Trying to get title");
		String title=driver.getTitle();
		System.out.println(title);
	}
	
	
	public void clickRepos() {
		projects.click();
	}

	public void switchToWdio() {
		driver.executeScript("mobile: startActivity", ImmutableMap.of("intent","com.wdiodemoapp/.MainActivity" ));
		
	}
	
}
