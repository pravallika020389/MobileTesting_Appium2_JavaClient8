package com.automation.pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.automation.base.BasePage;
import com.automation.utilities.FingureGesture;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SolodroidPage extends BasePage {
	
	public SolodroidPage(AppiumDriver driver) {
		super(driver);
	}
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ImageView")
	WebElement samsungS10;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/product_image")
	WebElement  samsungS10Pic;

	@AndroidFindBy(id="com.solodroid.solomerce:id/image")
	RemoteWebElement  samsungPicture;
	
	@AndroidFindBy(id="com.solodroid.solomerce:id/image")
	WebElement  samsungPic;
	
	public void clickSamsungS10() {
		samsungS10.click();
	}

	public void clickSamsungS10Pic() {
		samsungS10Pic.click();
		
	}

	public void doubletabPic() {
		driver.executeScript("gesture: doubleTap", Map.of("elementId", samsungPicture.getId()));
		
	}

	public void zoomInPic() {
		
		FingureGesture fingureGesture = new FingureGesture();
		fingureGesture.zoomIn(samsungPic,driver);
	}

	public void tapSamsungS10Pic() {
		FingureGesture fingureGesture = new FingureGesture();
		fingureGesture.tap(samsungS10Pic,driver);
		
	}

}
