package com.cogmento.testautomation.web.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cogmento.testautoamtion.web.pages.ContactsPage;
import com.cogmento.testautoamtion.web.pages.HomePage;
import com.cogmento.testautoamtion.web.pages.LoginPage;
import com.cogmento.testautomation.web.util.TestBase;
import com.cogmento.testautomation.web.util.TestUtil;

public class ContactsTest extends TestBase {
	WebDriver driver;
	
	
   @BeforeMethod
   public void launch_browser() {
	 driver= initialization();
	 
   }
   
   @DataProvider
   public Object[][] read_excel() throws InvalidFormatException, IOException{
	   TestUtil testutil=new TestUtil();
	   return testutil.get_testdata("Contact");
   }
	
   @Test(dataProvider="read_excel")
   public void create_new_contact(String firstname, String lastname, String middlename, String status1, String category) {
	   LoginPage loginpage=new LoginPage(driver);
	   loginpage.login();
	   
	   HomePage homepage=new HomePage(driver);
	   homepage.click_contacts();
	   
	   ContactsPage contactspage=new ContactsPage(driver);
	   contactspage.click_newbutton();
	   contactspage.create_new_contact(driver, firstname, lastname, middlename, status1, category);
	   
	   
	  
   }
   
  

}
