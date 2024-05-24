package com.automation.utilities;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;

public class FingureGesture {
	
	private Point getCentreOfElement(Point location, Dimension size) {
		// TODO Auto-generated method stub
		return new Point((int)(location.getX()+size.width/2),(int)(location.getY()+size.height/2));
	}
	

	public void zoomIn(WebElement samsungPic,AppiumDriver driver) {
		Point location = samsungPic.getLocation();
		Point centerOfElement = getCentreOfElement(samsungPic.getLocation(),samsungPic.getSize());
		
		PointerInput fingure1 = new PointerInput(PointerInput.Kind.TOUCH,"fingure1");	
		PointerInput fingure2 = new PointerInput(PointerInput.Kind.TOUCH,"fingure2");
		
		Sequence sequence1 = new Sequence(fingure1,1)
		.addAction(fingure1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),centerOfElement))
		.addAction(fingure1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		.addAction(new Pause(fingure1,Duration.ofMillis(200)) )
		.addAction(fingure1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), centerOfElement.getX()+100,
				centerOfElement.getY()-100))
		.addAction(fingure1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		
		
		
		Sequence sequence2 = new Sequence(fingure2,1)
		.addAction(fingure2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),centerOfElement))
		.addAction(fingure2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		.addAction(new Pause(fingure2,Duration.ofMillis(200)) )
		.addAction(fingure2.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), centerOfElement.getX()-100,
				centerOfElement.getY()+100))
		.addAction(fingure2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		
		driver.perform(Arrays.asList(sequence1,sequence2));
		
	
	}
	
	
	
	public void tap(WebElement samsungPic,AppiumDriver driver) {
		Point location = samsungPic.getLocation();
		Point centerOfElement = getCentreOfElement(samsungPic.getLocation(),samsungPic.getSize());
		
		PointerInput fingure1 = new PointerInput(PointerInput.Kind.TOUCH,"fingure1");	
		
		
		Sequence sequence1 = new Sequence(fingure1,1)
		.addAction(fingure1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),centerOfElement))
		.addAction(fingure1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		.addAction(new Pause(fingure1,Duration.ofMillis(200)) )
		.addAction(fingure1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		
		
		
		
		driver.perform(Collections.singletonList(sequence1));
	}
	
	
	public void longPress(WebElement samsungPic,AppiumDriver driver) {
		Point location = samsungPic.getLocation();
		Point centerOfElement = getCentreOfElement(samsungPic.getLocation(),samsungPic.getSize());
		
		PointerInput fingure1 = new PointerInput(PointerInput.Kind.TOUCH,"fingure1");	
		
		
		Sequence sequence1 = new Sequence(fingure1,1)
		.addAction(fingure1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),centerOfElement))
		.addAction(fingure1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		.addAction(new Pause(fingure1,Duration.ofSeconds(1)) )
		.addAction(fingure1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		
		
		
		
		driver.perform(Collections.singletonList(sequence1));
	}
	

	
		
	}



