package Projects;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

		//driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		PracticePage1 pg1 = new PracticePage1(driver);

		String DropDownText = pg1.getDropDownExample().getText();
		//Assert.assertEquals("Dropdown Example", DropDownText );
		//Log.info("Drop Down example text is validated successfully");
		System.out.println(DropDownText);

	}

	@Test

	public void checkDropDown() throws IOException, InterruptedException {
		
//		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		PracticePage1 pg1 = new PracticePage1(driver);

		//pg1.getSelectDropDown().click();
	    Select s=new Select(pg1.getSelectDropDown());
	    //Thread.sleep(3000L);
	    s.selectByVisibleText("Option2");
	   //System.out.println(pg1.getSelectDropDown().getTagName());
	    WebElement option=s.getFirstSelectedOption();
	    String selectedName=option.getText();
	    //System.out.println(selectedName);
	    
	    Assert.assertTrue(selectedName.equalsIgnoreCase("Option2"));
	   

	}
	
	}
