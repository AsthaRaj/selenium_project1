package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticePage2 {
	
	public WebDriver driver;

	private By SwitchWindowExample=By.xpath("//body/div[2]/div[1]/fieldset[1]/legend[1]");
	private By OpenWindow=By.id("openwindow");
	private By SwitchTabExample=By.xpath("//body/div[2]/div[2]/fieldset[1]/legend[1]");
	private By OpenTab=By.id("opentab");
	private By SwitchToAlertExample=By.xpath("//body/div[2]/div[3]/fieldset[1]/legend[1]");
	private By SwitchAlertTextBox=By.id("name");
	private By AlertButton=By.id("alertbtn");
	private By ConfirmButton=By.id("confirmbtn");
	
	
	public PracticePage2(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public WebElement getSwitchWindowExample()
	{
		return driver.findElement(SwitchWindowExample);
		
	}
	
	public WebElement getSwitchTabExample()
	{
		return driver.findElement(SwitchTabExample);
		
	}

	
	public WebElement getOpenTab()
	{
		return driver.findElement(OpenTab);
		
	}
	
	public WebElement getSwitchToAlertExample()
	{
		return driver.findElement(SwitchToAlertExample);
		
	}
	
	

	public WebElement getSwitchAlertTextBox()
	{
		return driver.findElement(SwitchAlertTextBox);
		
	}
	
	public WebElement getAlertButton()
	{
		return driver.findElement(AlertButton);
		
	}
	
	public WebElement getConfirmButton()
	{
		return driver.findElement(ConfirmButton);
		
	}
	

	
}
