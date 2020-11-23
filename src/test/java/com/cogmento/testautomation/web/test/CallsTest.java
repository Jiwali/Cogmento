package com.cogmento.testautomation.web.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cogmento.testautoamtion.web.pages.CallsPage;
import com.cogmento.testautoamtion.web.pages.HomePage;
import com.cogmento.testautoamtion.web.pages.LoginPage;
import com.cogmento.testautomation.web.util.TestBase;
import com.cogmento.testautomation.web.util.TestUtil;

public class CallsTest extends TestBase {
	WebDriver driver;
	@BeforeMethod
	public void launch_browser() {
		driver = initialization();
	}
	
	@DataProvider
	public Object[][] read_excel() throws InvalidFormatException, IOException {
		TestUtil testutile=new TestUtil();
		return testutile.get_testdata("Calls");
	}
	
	@Test(dataProvider = "read_excel")
	public void create_new_call(String type1) throws InterruptedException {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login();
		HomePage homepage=new HomePage(driver);
		homepage.click_calls();
		CallsPage callspage=new CallsPage(driver);
		callspage.select_newtask_button();
		callspage.create_calls(driver, type1);
	}
}
