package com.automation.tests;

import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.DragDropPage;
import com.automation.pages.FormPage;
import com.automation.pages.LoginPage;
import com.automation.pages.SolodroidPage;
import com.automation.pages.SwipePage;
import com.automation.pages.SwitchAppPage;
import com.automation.pages.WebViewPage;
import com.automation.utilities.PropertiesUtility;


import io.appium.java_client.AppiumDriver;

public class TestScripts extends BaseTest {
	static AppiumDriver driver;
	LoginPage loginPage;
	FormPage formPage;
	SwipePage swipePage;
	DragDropPage dragDropPage;
	WebViewPage webViewPage;
	SwitchAppPage switchAppPage;
	SolodroidPage solodroidPage;
	
	PropertiesUtility	pro;
	Properties	appProp;
	
	
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		driver = startApp();
		loginPage = new LoginPage(driver);
		pro = new PropertiesUtility();
		appProp = pro.loadFile("applicationDataProperties");
	}
	
	
	@Test
	public void validateLoginInValidEmail_01() throws InterruptedException {
			
		Thread.sleep(10000);
		String userId = appProp.getProperty("login.invalid.userid");
		String password = appProp.getProperty("login.valid.password");
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Login\"]")).click();
		Thread.sleep(10000);
		loginPage.enterUserId(userId);
		Thread.sleep(5000);
		loginPage.enterPassword(password);
		Thread.sleep(5000);
		loginPage.clickLoginButton();
		Thread.sleep(5000);
		String expectedInValidUserIdMsg= appProp.getProperty("login.invalid.userid.msg");
		String actualInValidUserIdMsg= loginPage.retriveUserIdErrorMsg();
		Assert.assertEquals(actualInValidUserIdMsg, expectedInValidUserIdMsg);
	}
	
	@Test
	public void validateLoginInValidPassword_02() throws InterruptedException {
		Thread.sleep(10000);
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.invalid.password");
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Login\"]")).click();
		Thread.sleep(10000);
		loginPage.enterUserId(userId);
		Thread.sleep(5000);
		loginPage.enterPassword(password);
		Thread.sleep(5000);
		loginPage.clickLoginButton();
		Thread.sleep(5000);
		String expectedInValidPasswordMsg= appProp.getProperty("login.invalid.password.msg");
		String actualInValidPasswordMsg= loginPage.retrivePasswordErrorMsg();
		Assert.assertEquals(expectedInValidPasswordMsg, actualInValidPasswordMsg);
	}
	
	@Test
	public void validateLoginSucess_03() throws InterruptedException {
		Thread.sleep(10000);
		String userId = appProp.getProperty("login.valid.userid");
		String password = appProp.getProperty("login.valid.password");
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Login\"]")).click();
		Thread.sleep(10000);
		loginPage.enterUserId(userId);
		Thread.sleep(5000);
		loginPage.enterPassword(password);
		Thread.sleep(5000);
		loginPage.clickLoginButton();
		Thread.sleep(5000);
		String expectedLoginMsg= appProp.getProperty("login.success.msg");
		String actualLoginMsg= loginPage.retriveSuccessMsg();
		Assert.assertEquals(actualLoginMsg, expectedLoginMsg);
		loginPage.clickOkButton();
	}

	@Test
	public void validateForm_04() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Forms\"]")).click();
		Thread.sleep(10000);
		String enteredText = appProp.getProperty("form.input");
		
		formPage = new FormPage(driver);
		formPage.enterDataIntoField(enteredText);

		String reviewText = formPage.retriveReviewText();
		Assert.assertEquals(enteredText, reviewText);
		Thread.sleep(10000);
		formPage.clickOnRadioButton();
		Thread.sleep(10000);
		formPage.selectFromDropdown(3);

	}
	
	
	@Test
	public void validateSwipe_withGestures_05() throws InterruptedException {
		Thread.sleep(10000);
		 driver.findElement(By.xpath("//android.view.View[@content-desc=\"Swipe\"]")).click();
		 swipePage=new SwipePage(driver);
		 swipePage.swipeRight();
		  
		
	}
	
	@Test
	public void validateScrollUntillElement_withGestures_06() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Swipe\"]")).click();
		Thread.sleep(5000);
		 swipePage=new SwipePage(driver);
		 swipePage.scrollUntilLogoFound();
		 Thread.sleep(2000);
		 Assert.assertEquals(true, swipePage.isImageFound()); 
		  
		
	}
	
	@Test
	public void validateDragAndDrop_withGestures_07() throws InterruptedException {
		Thread.sleep(10000);
		   driver.findElement(By.xpath("//android.view.View[@content-desc=\"Drag\"]")).click();
		   Thread.sleep(10000);
		   dragDropPage = new DragDropPage(driver);
		   dragDropPage.dropDrop();
		   Thread.sleep(5000);
		   Assert.assertEquals(true, dragDropPage.isDragDropDone());
	}
	
	
//	@Test
//	public void validateWebView_08() throws InterruptedException {
//		Thread.sleep(10000);
//		 driver.findElement(By.xpath("//android.view.View[@content-desc=\"Webview\"]")).click();
//		   Thread.sleep(5000);
//		   webViewPage = new WebViewPage(driver);
//		   webViewPage.clickOnbutton();
//		   Thread.sleep(5000);
//		   Assert.assertEquals(true, dragDropPage.isDragDropDone());
//	}
	
	
	@Test
	public void validateSwitchApp_withGestures_09() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\"Drag\"]")).click();
		 Thread.sleep(5000);
		 switchAppPage = new SwitchAppPage(driver);
		switchAppPage.switchApp();
		Thread.sleep(10000);  
	}
	
	@Test
	public void validate_Solondriod_doubleTap_withGestures_10() throws InterruptedException, MalformedURLException {
		
		driver = startAppSolondriod();
		solodroidPage = new SolodroidPage(driver);
		Thread.sleep(10000);
		solodroidPage.clickSamsungS10();
		Thread.sleep(5000);
		solodroidPage.clickSamsungS10Pic();
		Thread.sleep(5000);
		solodroidPage.doubletabPic();
		Thread.sleep(5000);
		solodroidPage.doubletabPic();
	}
	
	@Test
	public void validate_Solondriod_zoom_FingureGesture_11() throws InterruptedException, MalformedURLException {
		
		driver = startAppSolondriod();
		solodroidPage = new SolodroidPage(driver);
		Thread.sleep(10000);
		solodroidPage.clickSamsungS10();
		Thread.sleep(5000);
		solodroidPage.tapSamsungS10Pic();
		Thread.sleep(5000);
		//solodroidPage.zoomInPic();
		
	}
	
	

		
}
