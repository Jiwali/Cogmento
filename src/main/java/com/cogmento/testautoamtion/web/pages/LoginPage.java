package com.cogmento.testautoamtion.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cogmento.testautomation.web.util.TestBase;

public class LoginPage extends TestBase{

	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailfield;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordfield;

	@FindBy(xpath = "//div[text()='Login']")
	private WebElement submitbutton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void login() {
		emailfield.sendKeys(props.getProperty("username"));
		passwordfield.sendKeys(props.getProperty("password"));
		submitbutton.click();
	}

}
