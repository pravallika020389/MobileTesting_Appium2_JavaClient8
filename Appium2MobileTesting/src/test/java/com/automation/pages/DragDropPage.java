package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

import com.automation.base.BasePage;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DragDropPage extends BasePage {

	public DragDropPage(AppiumDriver driver) {
		super(driver);
	}
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-Retry\"]/android.view.ViewGroup ")
	RemoteWebElement retryButton;
	
	
	
	public void dropDrop() throws InterruptedException { 
	   for(int i=1;i<4;i++) {
		   Thread.sleep(1000);
//		   String accessibilityIdDrag ="drag-l"+i;
//		   String accessibilityIdDrop ="drop-l"+i;
//		   @AndroidFindBy(accessibility = accessibilityIdDrag)
//			RemoteWebElement source;
//		   @AndroidFindBy(accessibility = accessibilityIdDrop)
//			RemoteWebElement destination;
			   RemoteWebElement source = (RemoteWebElement)driver.findElement(AppiumBy.accessibilityId("drag-l"+i));
			   RemoteWebElement destination = (RemoteWebElement) driver.findElement(AppiumBy.accessibilityId("drop-l"+i));
		  Thread.sleep(1000);
		   driver.executeScript("gesture: dragAndDrop", ImmutableMap.of("sourceId", source.getId(), "destinationId", destination.getId()));
	   }
	   Thread.sleep(2000);
	   for(int i=1;i<4;i++) {
		   Thread.sleep(1000);
		   RemoteWebElement source = (RemoteWebElement)driver.findElement(AppiumBy.accessibilityId("drag-c"+i));
		   RemoteWebElement destination = (RemoteWebElement) driver.findElement(AppiumBy.accessibilityId("drop-c"+i));
		   Thread.sleep(1000);
		   driver.executeScript("gesture: dragAndDrop", ImmutableMap.of("sourceId", source.getId(), "destinationId", destination.getId()));
	   }
	   Thread.sleep(2000);
	   for(int i=1;i<4;i++) {
		   Thread.sleep(1000);
		   RemoteWebElement source = (RemoteWebElement)driver.findElement(AppiumBy.accessibilityId("drag-r"+i));
		   RemoteWebElement destination = (RemoteWebElement) driver.findElement(AppiumBy.accessibilityId("drop-r"+i));
		   Thread.sleep(1000);
		   driver.executeScript("gesture: dragAndDrop", ImmutableMap.of("sourceId", source.getId(), "destinationId", destination.getId()));
	   }
	
	   Thread.sleep(20000);
	  String result= driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Drag-drop-screen\"]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView")).getText();
	   if(result.equalsIgnoreCase("Congratulations")) {
		  System.out.println("sucessfully complted drag and drop" ); 
	
	
}
	}   
	   



	public boolean isDragDropDone() {
		
		if(retryButton.isDisplayed()) {
			return true;
		}
		
		return false;
		
	}
}
