package com.cogmento.testautomation.web.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {
	WebDriver driver;
	public Properties props;
	
	public TestBase() {
		props=new Properties();
		FileInputStream file = null;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			props.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public WebDriver initialization() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")+props.getProperty("chromeDriverPath"));
		driver = new ChromeDriver();
		driver.get(props.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		return driver;
	}

}
