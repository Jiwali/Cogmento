package com.cogmento.testautoamtion.web.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CallsPage {
	
	@FindBy(xpath="//button[text()='New']")
	private WebElement newbutton;
	
	@FindBy(xpath="//button[text()='Upgrade to Pro']")
	private WebElement upgradetoprobutton;
	
	@FindBy(xpath="//a[text()='Pay using a Debit or Credit Card']")
	private WebElement payUsingDebitCard;
	
	@FindBy(xpath="//i[@class='close icon']")
	private WebElement crossButton;
	
	@FindBy(xpath="//label[text()='Call Time']/..//input[@class='calendarField']")
	private WebElement callTime;
	
	@FindBy(xpath="//div[@name='type']//div[text()='Select']")
	private WebElement type;
	
	@FindBy(xpath="//span[text()='SKYPE']")
	private WebElement skyptetype;
	
	@FindBy(xpath="//a[text()='Invoices']")
	private WebElement invoices;
	
	@FindBy(xpath="//a[text()='Charges']")
	private WebElement charges;
	
	@FindBy(xpath="//a[text()='Telephony Billing']")
	private WebElement telephonybilling;
	
	@FindBy(xpath="//a[text()='Terminate Account']")
	private WebElement terminateaccount;
	
	public CallsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void select_newtask_button() {
		newbutton.click();
	}
	
	public void create_calls(WebDriver driver, String type1) throws InterruptedException {
		upgradetoprobutton.click();
		payUsingDebitCard.click();
		crossButton.click();
		invoices.click();
		charges.click();
		telephonybilling.click();
		terminateaccount.click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		callTime.sendKeys("23/11/2020 23:00");
		type.click();
		driver.findElement(By.xpath("//span[text()='"+type1+"']")).click();
	}

}
