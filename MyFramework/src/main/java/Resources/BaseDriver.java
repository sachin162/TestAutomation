package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BaseDriver 
{
	public WebDriver driver;
	public Properties prop = new Properties();
	@Test
	public WebDriver initializeDriver() throws IOException
	{
		
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		
		String browser=System.getProperty("browser1","chrome"); //mvn test -Dbrowser-chrome
		//String browser=prop.getProperty("browser");
		if(browser.equals("chrome"))
		{
			ChromeOptions option= new ChromeOptions();
			option.addArguments("headless");
			System.out.println("Printing the User Directory");
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\sachin.kulkarni\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(option);
		}
		else if(browser.equals("internet explorer"))
		{
			
			
		}
		else
		{
			
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenShot(String testCaseName,WebDriver driver) throws IOException
	{
		 TakesScreenshot ts=(TakesScreenshot) driver;
		 File source=ts.getScreenshotAs(OutputType.FILE);
		 String dest = System.getProperty("user.dir")+"\\images\\"+testCaseName+".png";
		 FileUtils.copyFile(source,new File(dest));
	}
}
