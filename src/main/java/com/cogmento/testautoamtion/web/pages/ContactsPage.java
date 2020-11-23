package com.cogmento.testautoamtion.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	
	@FindBy(xpath="//button[text()='New']")
	private WebElement newbutton;
	
	@FindBy(xpath="//input[@name='first_name']")
	private WebElement firstname;
	
	@FindBy(xpath="//input[@name='last_name']")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@name='middle_name']")
	private WebElement middlename;
	
	@FindBy(xpath="//div[@name='status' and @role='listbox']")
	private WebElement status;
	
//	@FindBy(xpath="//span[text()='New']")
//	private WebElement newstatus;
	
	@FindBy(xpath="//div[@name='category' and @role='listbox']")
	private WebElement category;
	
	
	@FindBy(xpath="//input[@name='do_not_call']")
	private WebElement donotcall;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement savebutton;
	
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void click_newbutton() {
		newbutton.click();
	}
	
	public void create_new_contact(WebDriver driver, String fn, String ln, String mn, String status1, String category1) {
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		middlename.sendKeys(mn);
		status.click();
		driver.findElement(By.xpath("//span[text()='"+status1+"']")).click();
		category.click();
		driver.findElement(By.xpath("//span[text()='"+category1+"']")).click();
		
		JavascriptExecutor javascriptexecutor =  (JavascriptExecutor) driver;
		javascriptexecutor.executeScript("arguments[0].click()", donotcall);
		
		savebutton.click();
	}

}
