package com.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.base.BaseTest;
 

public class TestEventListernersUtility implements ITestListener{
	private static ExtentReportsUtility extentReport ; 
	public void onTestStart(ITestResult result) {
		extentReport.startSingleTestReport(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		extentReport.logTestpassed(result.getMethod().getMethodName() +" is passed" );
	}

	public void onTestFailure(ITestResult result) {
		extentReport.logTestFailed(result.getMethod().getMethodName() +" is failed");
		extentReport.logTestFailedWithException(result.getThrowable());
		BaseTest ob= new BaseTest();
		WebDriver driver= BaseTest.driver;
		System.out.println("driver got it in listerners utility="+driver);
//		File imageFile=ob.takescreenshot(driver);
//		byte[] fileContent=null;
//		try {
//			fileContent = FileUtils.readFileToByteArray(new File(imageFile.getAbsolutePath()));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String imageEncodedString = Base64.getEncoder().encodeToString(fileContent);
//		
//		extentReport.logTestWithScreenShot(imageEncodedString);
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	//	ITestListener.super.onTestSkipped(result);
	}

	public void onStart(ITestContext context) {
		extentReport= ExtentReportsUtility.getInstance();
		extentReport.startExtentReport();
	}

	public void onFinish(ITestContext context) {
		extentReport.endReport();
	}

}
