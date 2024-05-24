package com.automation.pages;

import org.openqa.selenium.WebElement;

import com.automation.base.BasePage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FormPage extends BasePage {

	public FormPage(AppiumDriver driver) {
		super(driver);
	}

	@AndroidFindBy(accessibility = "text-input")
	WebElement formInputField;
	@AndroidFindBy(accessibility = "input-text-result")
	WebElement formReviewField;
	@AndroidFindBy(accessibility = "switch")
	WebElement radioButton;
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Dropdown\"]/android.view.ViewGroup/android.widget.EditText")
	WebElement dropdown;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]")
	
//	@AndroidFindBy(androidDataMatcher="Appium is awesome")
	WebElement dropdownSelect;

	public void enterDataIntoField(String enteredText) throws InterruptedException {

		formInputField.click();
		formInputField.sendKeys(enteredText);
		Thread.sleep(10000);

	}

	public String retriveReviewText() {
		String enteredText = formReviewField.getText();

		return enteredText;
	}

	public void clickOnRadioButton() {

		radioButton.click();
	}

	public void selectFromDropdown(int i) throws InterruptedException {

		dropdown.click();
		Thread.sleep(10000);
		dropdownSelect.click();

	}

}
