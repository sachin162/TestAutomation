package Resources;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.qaClickAcademyHomePage;
import pageObjects.qaClickAcademyLogInPage;



public class ValidateTitle extends BaseDriver
{
	WebDriver driver;
	private static Logger log=LogManager.getLogger(ValidateTitle.class.getName());
		@BeforeTest
		public void initialize() throws IOException
		{
			driver=initializeDriver();
	         driver.get(prop.getProperty("url"));
		}
	
		@Test
	    public void validateTitle() throws IOException
	    {
			
			log.info("Test case 2 starts ");
	         qaClickAcademyHomePage homePage = new qaClickAcademyHomePage(driver);
	         String text=homePage.getFeatureText().getText();
	         log.info("Validating title ");
	         if(text.equals("Featured courses"))
	         {
	        	Assert.assertTrue(true); 
	         }
	         else
	         {
	        	 log.info("Validation of title failed");
	         }
	         log.info("Validating wether  navigation bar  is displayed");
	         if(homePage.getNavBar().isDisplayed())
	         {
	        	 Assert.assertTrue(true); 
	        	 log.info("VAlidation SUCCESS:navigation bar  is displayed");
	         }
	         
	         qaClickAcademyLogInPage loginPage =new qaClickAcademyLogInPage(driver);
	         System.out.println(text);
	         log.info("End of TEst case 2");
	         
	        
	    }
		
		@AfterTest
		public void close()
		{
			driver.close();
		}
	 
	 	
}
