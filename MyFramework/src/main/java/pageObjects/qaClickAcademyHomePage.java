package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class qaClickAcademyHomePage 
{
	public WebDriver driver;
	
	public qaClickAcademyHomePage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	private By signIn=By.xpath("//a[@href='https://rahulshettyacademy.com/sign_in/']");
	private By featureText =By.xpath("//div[@class='text-center']//h2");
	private By navBar = By.xpath("//*[@id=\"homepage\"]/header/div[2]/div/nav/ul");////*[@id="homepage"]/header/div[2]/div/nav/ul
	
	public WebElement getLogin()
	{
		return driver.findElement(signIn);
	}
	
	public WebElement getFeatureText()
	{
		return driver.findElement(featureText);
	}
	
	public WebElement getNavBar()
	{
		return driver.findElement(navBar);
	}
	

}
