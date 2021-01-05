package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class qaClickAcademyLogInPage
{
public WebDriver driver;
	
	public qaClickAcademyLogInPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	By email=By.id("user_email");
	By password=By.id("user_password");
	By logInButton= By.name("commit");
	public WebElement getEmailTextBox()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPasswordTextBox()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLoginButton()
	{
		return driver.findElement(logInButton);
	}
	
	

}
