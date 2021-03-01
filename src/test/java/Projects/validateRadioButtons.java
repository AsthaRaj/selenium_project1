package Projects;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;

import pageObjects.PracticePage1;

public class validateRadioButtons extends base {

	public WebDriver driver;
	
	private static Logger Log=LogManager.getLogger(validateRadioButtons.class.getName());

	@BeforeTest
	public void startup() throws IOException {
		driver = initializeDriver();
		Log.info("Driver is initialized for 'validateRadioButtons' class");
		

	}

	//PracticePage1 pg1 = new PracticePage1(driver);

	
	@Test

	public void checkRadioButtonText() throws IOException {

		driver.get(prop.getProperty("url"));
		PracticePage1 pg1 = new PracticePage1(driver);

		String RadioButtonText = pg1.getRadioButtonExample().getText();
		Assert.assertEquals("Radio Button Example", RadioButtonText);
		Log.info("Radio Button text is validated successfully");

	}
  @Test
	public void validateRadio1() {
	  
	  PracticePage1 pg1 = new PracticePage1(driver);
		pg1.getRadio1().click();
		Assert.assertTrue(pg1.getRadio1().isSelected());
		Log.info("Radio Button1 is clicked and validated successfully");

	}
	@Test
	public void validateRadio2() {
        
		PracticePage1 pg1 = new PracticePage1(driver);
		pg1.getRadio2().click();
		Assert.assertTrue(pg1.getRadio2().isSelected());
		Log.info("Radio Button2 is clicked and validated successfully");

		
		

	}
	@Test
	public void validateRadio3() {
        
		PracticePage1 pg1 = new PracticePage1(driver);
		pg1.getRadio3().click();
		Assert.assertTrue(pg1.getRadio2().isSelected());
		Log.info("Radio Button3 is clicked and validated successfully");

	}
	
	

}
