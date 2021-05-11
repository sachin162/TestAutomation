package Resources;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.qaClickAcademyHomePage;
import pageObjects.qaClickAcademyLogInPage;



public class BaseTest extends BaseDriver
{
	WebDriver driver;
	private static Logger log=LogManager.getLogger(BaseTest.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		log.info("Initializing the browser");
		driver=initializeDriver();
		//editing this file for github
         
	}
	 @Test(dataProvider="getData")
	    public void basePageNavigation(String email,String pass,String text) throws IOException
	    {
		 	log.info("Navigating to http://www.qaclickacademy.com/");
		 	driver.get(prop.getProperty("url"));
		 	log.info("Navigation SUCCESS");
		 	qaClickAcademyHomePage homePage = new qaClickAcademyHomePage(driver);
		 	log.info("clicking on LOGIN ");
	         homePage.getLogin().click();
	         log.info("clicked on LOGIN ");
	         qaClickAcademyLogInPage loginPage =new qaClickAcademyLogInPage(driver);
	         log.info("Entering email ");
	         loginPage.getEmailTextBox().sendKeys(email);
	         log.info("Entering password ");
	         loginPage.getPasswordTextBox().sendKeys(pass);
	         System.out.println(text);
	         log.info("click on LOGIN BUTTON ");
	         loginPage.getLoginButton().click();
	         log.info("End of Test case 1");
	        
	    }
	 
	 	@DataProvider
	 	public Object[][] getData()
	 	{
	 		//row ---> No of data
	 		//Col --> No of values in each data
	 		Object[][] data= new Object[2][3];
	 		
	 		data[0][0]="sksachin1510gmail.com";
	 		data[0][1]="Sksachin1510";
	 		data[0][2]="Allowed";
	 		
	 		data[1][0]="abc@gmail.com";
	 		data[1][1]="Sksachin1510k";
	 		data[1][2]="Restricted";
	 		
	 		return data;
	 				
	 		
	 	}
	 	@AfterTest
		public void close()
		{
			driver.close();
		}
}
