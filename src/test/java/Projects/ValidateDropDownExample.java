package Projects;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.PracticePage1;


public class ValidateDropDownExample extends base {


	public WebDriver driver;
	
	private static Logger Log=LogManager.getLogger(ValidateDropDownExample.class.getName());	
	
	@BeforeTest
	public void startup() throws IOException {
		driver = initializeDriver();
		Log.info("Driver is initialized for 'ValidateSuggestionClass' class");
		
	}
	
	
	@Test

	public void checkDropDownText() throws IOException {

		driver.get(prop.getProperty("url"));
		PracticePage1 pg1 = new PracticePage1(driver);

		String SuggestionClassText = pg1.getSuggestionClass().getText();
		Assert.assertEquals("Suggession Class Example", SuggestionClassText);
		Log.info("Suggession class example text is validated successfully");

	}

	@Test

	public void checkSuggestionClassTextBox() throws IOException {

		driver.get(prop.getProperty("url"));
		PracticePage1 pg1 = new PracticePage1(driver);

		pg1.getSuggestionClassTextBox().sendKeys("Ind");
		List<WebElement> options=driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
	    int optionSize= driver.findElements(By.xpath("//ul[@id='ui-id-1']/li")).size();
	    System.out.println(optionSize);
	    for(int i=0;i<optionSize;i++)
	    {
	    	String name=(options.get(i).getText());
	    	if(name.equalsIgnoreCase("India"))
	    	{
	    		options.get(i).click();
	    	
	    		break;
	    	}
	    	
	    }

	}
	
	}
