package com.cogmento.testautoamtion.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath="//span[text()='Contacts']")
	private WebElement contacts;
	
	@FindBy(xpath="//span[text()='Tasks']")
	private WebElement tasks;
	
	@FindBy(xpath="//span[text()='Calls']")
	private WebElement calls;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void click_contacts() {
		contacts.click();
	}
	
	public void click_task() {
		tasks.click();
	}
	
	public void click_calls() {
		calls.click();
	}

}
