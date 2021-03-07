package Projects;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.PracticePage2;

public class ValidateAlertExample extends base {

	public WebDriver driver;
	public PracticePage2 pg2;

	private static Logger Log = LogManager.getLogger(ValidateDropDownExample.class.getName());

	@BeforeTest
	public void startup() throws IOException {
		driver = initializeDriver();
		pg2 = new PracticePage2(driver);
		driver.get(prop.getProperty("url"));
		Log.info("Driver is initialized for 'ValidateSuggestionClass' class");

	}

	@Test
	// Validate Text of alert button
	public void checkSwitchAlertText() throws IOException {

		String SwitchAlertText = pg2.getSwitchToAlertExample().getText();
		System.out.println(SwitchAlertText);
		Assert.assertEquals("Switch To Alert Example", SwitchAlertText);
		Log.info("Switch To Alert Text is validated successfully");

	}

	@Test
	// Validating text box
	public void checkAlertTextBox() {

		pg2.getSwitchAlertTextBox().sendKeys("Astha");

		String Text = pg2.getSwitchAlertTextBox().getAttribute("value");
		System.out.println(Text);
		Assert.assertTrue(Text.equalsIgnoreCase("Astha"));
	}

	@Test
	// Validating alert getting accepted successfully or not
	public void checkAlert() {

		pg2.getAlertButton().click();
		String AlertText = driver.switchTo().alert().getText();
		Assert.assertEquals("Hello , share this practice page and share your knowledge", AlertText);
		driver.switchTo().alert().accept();

		try {
			driver.switchTo().alert();
			System.out.println("Alert is not accepted successfully");
		} catch (NoAlertPresentException ex) {
			System.out.println("Alert is accepted successfully");
		}
	}

	
	@AfterTest
	// Closing browsers
	public void tearDown() {
		driver.close();
	}

}
