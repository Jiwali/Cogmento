package com.cogmento.testautoamtion.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	
	@FindBy(xpath="//button[text()='New']")
	private WebElement newButton;
	
	@FindBy(xpath="//input[@name='title']")
	private WebElement title1;
	
	@FindBy(xpath="//div[@class='ui fluid selection dropdown']")
	private WebElement assignedto;
	
//	@FindBy(xpath="//div[@class='active selected item']//..//span[text()='Jiwali Patil']")
//	private WebElement jiwalipatil;
	
	@FindBy(xpath="//div[@name='type']//..//div[text()='Select']")
	private WebElement selectdropdown;
	
//	@FindBy(xpath="//span[text()='General Support']")
//	private WebElement generalsupport;
	
	@FindBy(xpath="//div[@name='contact']//input[@class='search']")
	private WebElement contactbutton;
	
	@FindBy(xpath="//span[text()='Shubham Ravindra Patil']")
	private WebElement shubhampatilcontact;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement savebutton;

	
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void select_newtask_button() {
		newButton.click();	
	}
	
	public void create_task(WebDriver driver, String title, String type) throws InterruptedException {
		title1.sendKeys(title);
		assignedto.click();
	//	jiwalipatil.click();
		selectdropdown.click();
		driver.findElement(By.xpath("//span[text()='"+type+"']")).click();
	//	contactbutton.click();
		Thread.sleep(2000);
		contactbutton.sendKeys("Shubha");
		Thread.sleep(2000);
		shubhampatilcontact.click();
		savebutton.click();
		
	}

}
