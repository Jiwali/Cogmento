package com.cogmento.testautomation.web.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cogmento.testautoamtion.web.pages.HomePage;
import com.cogmento.testautoamtion.web.pages.LoginPage;
import com.cogmento.testautoamtion.web.pages.TaskPage;
import com.cogmento.testautomation.web.util.TestBase;
import com.cogmento.testautomation.web.util.TestUtil;

public class TaskTest extends TestBase {
	WebDriver driver;
	
	@BeforeMethod
	public void launch_browser() {
		driver = initialization();
	}

	@DataProvider
	public Object[][] read_excel() throws InvalidFormatException, IOException {
		TestUtil testUtil = new TestUtil();
		return testUtil.get_testdata("Task");
	}

	@Test(dataProvider = "read_excel")
	public void create_new_task(String title, String type) throws InterruptedException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login();

		HomePage homepage = new HomePage(driver);
		homepage.click_task();

		TaskPage taskpage = new TaskPage(driver);
		taskpage.select_newtask_button();
		taskpage.create_task(driver, title, type);

	}

}
