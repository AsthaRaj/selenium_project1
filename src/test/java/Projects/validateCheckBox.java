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

public class validateCheckBox extends base {

	public WebDriver driver;
	
	private static Logger Log=LogManager.getLogger(validateCheckBox.class.getName());

	@BeforeTest
	public void startup() throws IOException {
		driver = initializeDriver();
		Log.info("Driver is initialized for 'validateRadioButtons' class");
		

	}

	
@Test

	public void checkRadioButtonText() throws IOException {

		driver.get(prop.getProperty("url"));
		PracticePage1 pg1 = new PracticePage1(driver);

		String CheckBoxText = pg1.getCheckBoxExample().getText();
		Assert.assertEquals("Checkbox Example",CheckBoxText );
		Log.info("CheckBox text is validated successfully");

	}
  @Test
	public void validateCheckBox() {
	  
	  PracticePage1 pg1 = new PracticePage1(driver);
		pg1.getCheckBoxOption2().click();
		pg1.getCheckBoxOption3().click();
		
		Assert.assertTrue((pg1.getCheckBoxOption2().isSelected()) && (pg1.getCheckBoxOption3().isSelected()));
		
		
	}

	

}
